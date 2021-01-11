package com.VitalSignModule.VitalSignModule.Dto;

import java.io.Serializable;

import lombok.Data;


/**
 * class VitalDto
 * 
 * @created By Dinesh J
 * @created Date 05/12
 * @description Used to give the response to end user
 */
@Data
public class VitalDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id of the vital
	 */
	private Long vitalId;
	
	/**
	 * userId of the vital
	 */
	private Long userId;
	
	/**
	 * patientId of the vital
	 */
	private Long patientId;
	
	/**
	 * name of the vital
	 */
	private String vitalName;
	
	/**
	 * pulse of the vital
	 */
	private String pulse;
	
	/**
	 * bloodPressure of the vital
	 */
	private String bloodPressure;
	
	/**
	 * temprature of the vital
	 */
	private String temprature;
	
	/**
	 * respirations of the vital
	 */
	private String respirations;
	
	/**
	 * bloodSugar of the vital
	 */
	private String  bloodSugar;
	
	/**
	 * weight of the vital
	 */
	private String weight;
	
	/**
	 * height of the vital
	 */
	private String height;
	
	/**
	 * sPO2Sat of the vital
	 */
	private String sPO2Sat;
	
	/**
	 * pTINR of the vital
	 */
	private String pTINR;

}
