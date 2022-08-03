package com.School_Registration_System.exception;

import org.springframework.http.HttpStatus;

public class ParameterNotAccepted extends Exception {

	private static final long serialVersionUID = -4288253916511191681L;
	private String errorCode;
	private String errorMessage;
	private Object result;

	public ParameterNotAccepted(String errorCode, String errorMessage, Object result) {

		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.result = result;
	}

	public String getErrorCode() {
		return errorCode;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
