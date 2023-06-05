package com.akprojects.restdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

//CloudVendorExceptionControllers
@ControllerAdvice
public class CloudVendorExceptionHandler {
	
	@ExceptionHandler(value = {CloudVendorNotFoundException.class})
	public ResponseEntity<Object> handlerCloudVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException){
		
		CloudVendorException cloudVendorException = new CloudVendorException(
					cloudVendorNotFoundException.getLocalizedMessage(),
					cloudVendorNotFoundException.getCause(),
					HttpStatus.NOT_FOUND
					
				);
		
		
		return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
	}
	
}
