package com.VitalSignModule.VitalSignModule.Service;


import java.util.List;
import java.lang.reflect.Type;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.VitalSignModule.VitalSignModule.Aop.TrackExecutionTime;
import com.VitalSignModule.VitalSignModule.Dto.VitalDto;
import com.VitalSignModule.VitalSignModule.Exception.VitalNotFoundException;
import com.VitalSignModule.VitalSignModule.FeignProxy.PatientFeign;
import com.VitalSignModule.VitalSignModule.FeignProxy.UserFeign;
import com.VitalSignModule.VitalSignModule.Model.Vital;
import com.VitalSignModule.VitalSignModule.Repository.VitalRepository;


/**
 * class VitalServiceImpl
 * 
 * @created By Dinesh J
 * @created Date 05/12
 * @description used to implement the vitalService
 */
@Service
public class VitalServiceImpl implements VitalService {
	
	/**
	 * userFeign Bean
	 */
	private final UserFeign userFeign;    
	
	/**
	 * patientFeign Bean
	 */
	private final PatientFeign patientFeign;   
	
	/**
	 * vitalRepository Bean
	 */
	private final VitalRepository vitalRepository; 
	
	/**
	 * modelMapper Bean
	 */
	private final ModelMapper modelMapper;  
	
	
	/**
	 * Parameterized Constructor 
	 * 
	 * @param userFeign
	 * @Description dependency Injection
	 */
	@Autowired
	public VitalServiceImpl(UserFeign userFeign, VitalRepository vitalRepository,ModelMapper modelMapper,PatientFeign patientFeign) {
		this.userFeign = userFeign;
		this.vitalRepository = vitalRepository;
		this.modelMapper = modelMapper;
		this.patientFeign = patientFeign;
	}
	
	
	@TrackExecutionTime
	public List<VitalDto> getAllVitals() {
		List<Vital> myVitals = vitalRepository.findAll();
		Type listType = new TypeToken<List<VitalDto>>(){}.getType();
		List<VitalDto>retVitalDto = modelMapper.map(myVitals, listType);
		return retVitalDto;
	}
	
	@TrackExecutionTime
	public VitalDto getVitalById( Long id) {
		Vital myVital = vitalRepository.findById(id).orElseThrow(()->new VitalNotFoundException(id));
		VitalDto retVitalDto = modelMapper.map(myVital, VitalDto.class);
		return retVitalDto;
	}
	
	@TrackExecutionTime
	public VitalDto addVital( VitalDto myVital) {
		VitalDto MyVital = modelMapper.map(myVital, VitalDto.class);
		MyVital.setUserId(userFeign.getUserId());
		MyVital.setPatientId(patientFeign.getPatientId());
		Vital useMyVital = modelMapper.map(MyVital, Vital.class); 
		Vital responseVital = vitalRepository.save(useMyVital);
		VitalDto retVital = modelMapper.map(responseVital, VitalDto.class);
		return retVital;
	}
	
	@TrackExecutionTime
	public VitalDto updateVital( VitalDto myVital,  Long id) {
		Vital MyVital = modelMapper.map(myVital,Vital.class);
		Vital updatedVitalResponse = vitalRepository.findById(id).map(vital->{vital.setUserId(userFeign.getUserId());
		vital.setPatientId(patientFeign.getPatientId());
		vital.setVitalName(MyVital.getVitalName());
		vital.setBloodPressure(MyVital.getBloodPressure());
		vital.setBloodSugar(MyVital.getBloodSugar());
		vital.setHeight(MyVital.getHeight());
		vital.setPTINR(MyVital.getPTINR());
		vital.setPulse(MyVital.getPulse());
		vital.setRespirations(MyVital.getRespirations());
		vital.setSPO2Sat(MyVital.getSPO2Sat());
		vital.setTemprature(MyVital.getTemprature());
		return vitalRepository.save(vital);}).orElseGet(()->{MyVital.setUserId(id);return vitalRepository.save(MyVital);});
		VitalDto myVitalDto = modelMapper.map(updatedVitalResponse, VitalDto.class);
		return  myVitalDto;
	}
	
	@TrackExecutionTime
	public void deleteVitalById( Long id) {
		try{
			vitalRepository.deleteById(id);
		}
		catch(Exception e) {
			throw new VitalNotFoundException(id);
		}
	}
	
	@TrackExecutionTime
	public List<VitalDto> getPaginationWithSorting(int pageNo, int pageSize, String sortBy) {
		Pageable paging =  PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		Page<Vital> pagedResult = vitalRepository.findAll(paging);
		List<Vital> vitalList = pagedResult.toList();
		Type listType = new TypeToken<List<VitalDto>>(){}.getType();
		List<VitalDto> myVitalDtoList = modelMapper.map(vitalList, listType);
		return myVitalDtoList;
	}
	
	@TrackExecutionTime
	public List<VitalDto> findByVitalName(String vitalname) {
		List<Vital> myVital = vitalRepository.findByVitalName(vitalname);
		Type listType = new TypeToken<List<VitalDto>>(){}.getType();
		List<VitalDto> myVitalDto = modelMapper.map(myVital,listType);
		return myVitalDto;
	}

}
