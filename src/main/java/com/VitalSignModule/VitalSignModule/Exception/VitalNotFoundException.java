package com.VitalSignModule.VitalSignModule.Exception;

/**
 * class VitalNotFoundException
 * 
 * @created By Dinesh J
 * @created Date 04/12
 * @description used to handle vitalNotFound Exception
 */
public class VitalNotFoundException extends RuntimeException {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Parameterized Constructor 
	 * 
	 * @param id
	 * @Description Passing the Custom message to Super Class
	 */
	public VitalNotFoundException(Long id) {
		super("Could not find the vital for mentioned id " +" "+ id );
	}

}
