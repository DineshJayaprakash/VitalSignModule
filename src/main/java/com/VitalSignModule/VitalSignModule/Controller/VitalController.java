package com.VitalSignModule.VitalSignModule.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.VitalSignModule.VitalSignModule.Dto.VitalDto;
import com.VitalSignModule.VitalSignModule.Service.VitalService;




/**
 * class VitalController
 * 
 * @created By Dinesh J
 * @created Date 04/12
 * @description used to perform endpoint mapping operations
 */
@RestController
@RequestMapping("vitals")
public class VitalController {
	

	/**
	 * VitalService bean
	 */
	private final VitalService vitalService;	
	
	
	/**
	 * Parameterized Constructor 
	 * 
	 * @param userFeign
	 * @description dependency Injection
	 */
	@Autowired
	public VitalController(VitalService vitalService) {
		this.vitalService = vitalService;
	}
	
	/**
	 * function getAllVitals
	 * 
	 * @param none
	 * @return List Of Vitals
	 * @description GetMapping used to get all the vitals from Db
	 */
	@Cacheable("vitals")
	@GetMapping("")
	public List<VitalDto> getAllVitals() {
		return vitalService.getAllVitals();
		
	}
	
	
	/**
	 * function getVitalById
	 * 
	 * @param id
	 * @return VitalDto
	 * @description GetMapping is used get a vital details from Db based on given id
	 */
	@Cacheable(key="#id",value="vital")
	@GetMapping("/{id}")
	public VitalDto getVitalById(@PathVariable Long id) {
		return vitalService.getVitalById(id);
	}
	
	
	/**
	 * function addVital
	 * 
	 * @param myVital
	 * @return VitalDto
	 * @description PostMapping used to add a given vital details into Db 
	 */
	@PostMapping("")
	public VitalDto addVital(@RequestBody VitalDto myVital) {
		return vitalService.addVital(myVital);
	}
	
	
	/**
	 * function updateVital
	 * 
	 * @param myVital,id
	 * @return VitalDto
	 * @description PutMapping used to update a vital details into Db
	 */
	@CachePut(key="#id",value="vital")
	@PutMapping("/{id}")
	public VitalDto updateVital(@RequestBody VitalDto myVital, @PathVariable Long id) {
		return  vitalService.updateVital(myVital, id);
	}
	
	
	/**
	 * function deleteVitalById
	 * 
	 * @param id
	 * @return VitalDto
	 * @description DeleteMapping used to delete a vital details from db
	 */
	@CacheEvict(key="#id",value="vital")
	@DeleteMapping("/{id}")
	public void deleteVitalById(@PathVariable Long id) {
			vitalService.deleteVitalById(id);
	}
	
	
	
	/**
	 * function getPaginationWithSorting
	 * 
	 * @param pageNo,pageSize,sortBy
	 * @return VitalDto
	 * @description GetMapping used to filter and sort the records fromdb
	 */
	@GetMapping("/{pageNo}/{pageSize}/{sortBy}")
	public List<VitalDto> getPaginationWithSorting(int pageNo, int pageSize, String sortBy) {
		return vitalService.getPaginationWithSorting(pageNo, pageSize, sortBy);
	}
	
	
	/**
	 * function findByVitalName
	 * 
	 * @param vitalName
	 * @return List of Vitals
	 * @description GetMapping used to get the list of vitals based on the search
	 */
	@GetMapping("checkByVitalName/{vitalName}")
	public List<VitalDto> findByVitalName(@PathVariable String vitalName) {
		return vitalService.findByVitalName(vitalName);
	}

}
