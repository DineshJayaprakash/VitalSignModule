package com.VitalSignModule.VitalSignModule.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * class VitalAdvise
 * 
 * @created By Dinesh J
 * @created Date 04/12
 * @description used to handle the exceptions globally
 */
@ControllerAdvice
public class VitalAdvise {
	
	/**
	 * function vitalNotFoundHandler 
	 * 
	 * @param ex
	 * @return Message
	 * @description used to display the message and handle exception of VitalNotFound
	 */
	@ResponseBody
	@ExceptionHandler(VitalNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String vitalNotFoundHandler(VitalNotFoundException ex) {
		return ex.getMessage();
	}

}
