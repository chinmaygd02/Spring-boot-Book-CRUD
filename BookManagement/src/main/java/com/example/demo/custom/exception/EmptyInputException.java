package com.example.demo.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class EmptyInputException extends RuntimeException{

	public EmptyInputException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public EmptyInputException() {
		
	}
	public String getErrorCode() {
		return errorCode;
	}
	@Override
	public String toString() {
		return "EmptyInputException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	private String errorCode;
	private String errorMessage;
}
