package com.VitalSignModule.VitalSignModule.Service;

import java.util.List;


import com.VitalSignModule.VitalSignModule.Dto.VitalDto;

/**
 * interface VitalService
 * 
 * @created By Dinesh J
 * @created Date 05/12
 * @description used to perform crud operatios
 */
public interface VitalService {

	/**
	 * function getAllVitals 
	 * 
	 * @return Vitals List from Db
	 * @description used to list out all the vital details
	 */
	public List<VitalDto> getAllVitals();
	
	/**
	 * function getVitalById
	 * 
	 * @param id
	 * @return Vital
	 * @description used to getting vital detail by id
	 */
	public VitalDto getVitalById(Long id);
	
	/**
	 * function addVital
	 * 
	 * @param myVital
	 * @return Vital
	 * @description used to add a new vital to db
	 */
	public VitalDto addVital(VitalDto myVital);
	
	/**
	 * function updateVital
	 * 
	 * @param myVital,id
	 * @return Vital
	 * @description used to update a existing vital to db based on id
	 */
	public VitalDto updateVital(VitalDto myVital, Long id);
	
	/**
	 * function deleteVitalById
	 * 
	 * @param id
	 * @return none
	 * @description used to update a existing vital to db based on id
	 */
	public void deleteVitalById(Long id);
	
	/**
	 * function getPaginationWithSorting
	 * 
	 * @param pageNo,pageSize,sortBy
	 * @return List of Vitals
	 * @description used to get pagination and Soring list of vitals from db
	 */
	public List<VitalDto> getPaginationWithSorting(int pageNo, int pageSize, String sortBy);
	
	/**
	 * function findByVitalName
	 * 
	 * @param vitalname
	 * @return List of Vitals
	 * @description used to get List of vitals from db by user's search
	 */
	public List<VitalDto> findByVitalName(String vitalname);
}
