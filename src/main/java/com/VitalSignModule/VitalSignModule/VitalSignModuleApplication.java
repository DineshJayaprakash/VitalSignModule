package com.VitalSignModule.VitalSignModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * class VitalSignModuleApplication
 * 
 * @created By Dinesh J
 * @created Date 04/12
 * @description used to execute vitalSignModule
 */

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@EnableCaching
public class VitalSignModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalSignModuleApplication.class, args);
	}

}