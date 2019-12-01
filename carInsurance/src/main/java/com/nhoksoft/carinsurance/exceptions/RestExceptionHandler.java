package com.nhoksoft.carinsurance.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<CustomException> handleIllegalArgumentException(Exception e) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new CustomException(e.getClass().getSimpleName(),
						e.getMessage(),
						"Argumentos errones",
						HttpStatus.BAD_REQUEST));
	}
		
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body("Exception");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
