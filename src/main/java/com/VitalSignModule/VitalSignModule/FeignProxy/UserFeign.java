package com.VitalSignModule.VitalSignModule.FeignProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * interface UserFeign
 * 
 * @created By Dinesh J
 * @created Date 04/12
 * @description used to interact with User module
 */
@FeignClient(name="userService",url = "${feign.client.proxy.userModule}")
public interface UserFeign {
	
	
	/**
	 * function getUserId
	 * 
	 * @return id
	 * @description used to get UserId from User module
	 */
	@GetMapping("/users/getUserId")
	public long getUserId();

}
