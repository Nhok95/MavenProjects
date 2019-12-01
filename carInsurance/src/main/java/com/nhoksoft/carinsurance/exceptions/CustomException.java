package com.nhoksoft.carinsurance.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException{
	
	private String message;
	private String error;
	private String status;
	
	public CustomException() {}

	public CustomException(String error, String simpleMessage, String message, HttpStatus status) {
		super();
		this.message = message;
		this.error = error + ": " + simpleMessage;
		this.status = Integer.toString(status.value()) + ": " + status.name() ;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomException [message=" + message + ", error=" + error + ", status=" + status + "]";
	}
	
}
