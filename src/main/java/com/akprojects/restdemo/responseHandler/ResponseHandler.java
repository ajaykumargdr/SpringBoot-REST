package com.akprojects.restdemo.responseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
	
	// custom repose structure
	public static ResponseEntity<Object> responseBuilder(
			String message,
			HttpStatus httpStatus,
			Object responseObject 	// real data
			)
	{
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", message);
		response.put("HttpStatus", httpStatus);
		response.put("data", responseObject);
		
		return new ResponseEntity<>(response, httpStatus);
	}

}
