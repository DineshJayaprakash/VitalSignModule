package com.VitalSignModule.VitalSignModule.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * class Vital
 * 
 * @created By Dinesh J
 * @created Date 05/12
 * @description Used to save vital details to Db
 */
@Entity
@Data
@Table(name="vital")
public class Vital {
	
	/**
	 * Id of the vital
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vitalid")
	private Long vitalId;
	
	/**
	 * userId of the vital
	 */
	@Column(name="userid")
	private Long userId;
	
	/**
	 * patientId of the vital
	 */
	@Column(name="patientid")
	private Long patientId;
	
	/**
	 * name of the vital
	 */
	@Column(name="vitalname")
	private String vitalName;
	
	/**
	 * pulse of the vital
	 */
	@Column(name="pulse")
	private String pulse;
	
	/**
	 * bloodPressure of the vital
	 */
	@Column(name="bloodpressure")
	private String bloodPressure;
	
	/**
	 * temprature of the vital
	 */
	@Column(name="temprature")
	private String temprature;
	
	/**
	 * respirations of the vital
	 */
	@Column(name="respirations")
	private String respirations;
	
	/**
	 * bloodSugar of the vital
	 */
	@Column(name="bloodsugar")
	private String bloodSugar;
	
	/**
	 * weight of the vital
	 */
	@Column(name="weight")
	private String weight;
	
	/**
	 * height of the vital
	 */
	@Column(name="height")
	private String height;
	
	/**
	 * sPO2Sat of the vital
	 */
	@Column(name="spo2sat")
	private String sPO2Sat;
	
	/**
	 * pTINR of the vital
	 */
	@Column(name="ptinr")
	private String pTINR;
}
