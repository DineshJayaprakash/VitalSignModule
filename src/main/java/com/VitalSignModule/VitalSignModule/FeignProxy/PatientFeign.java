package com.VitalSignModule.VitalSignModule.FeignProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



/**
 * interface PatientFeign
 * 
 * @created By Dinesh J
 * @created Date 04/12
 * @description used to interact with patient module
 */
@FeignClient(name="patientService", url = "${feign.client.proxy.patientModule}")
public interface PatientFeign {
	
	
	/**
	 * function getPatientId
	 * 
	 * @return id
	 * @description used to get the patient id from patient module
	 */
	@GetMapping("/patients/getPatientId")
	public long getPatientId();

}
