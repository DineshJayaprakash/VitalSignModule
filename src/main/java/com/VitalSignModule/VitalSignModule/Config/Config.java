package com.VitalSignModule.VitalSignModule.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * class Config
 * 
 * @created By Dinesh J
 * @created Date 04/12
 * @description used to create singleton beans for application
 */
@Configuration
public class Config {
	
	/**
	 * function modelMapper
	 * 
	 * @param none
	 * @return ModelMapper bean
	 * @description used to perform utility operations
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	
	/**
	 * function productApi
	 * 
	 * @param none
	 * @return new Docket
	 * @description used to perform documentation for vitalsign module 
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("UserModule.UserModule")).build();
	}

}
