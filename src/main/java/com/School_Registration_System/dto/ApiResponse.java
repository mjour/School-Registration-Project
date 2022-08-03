package com.School_Registration_System.dto;



public class ApiResponse {
	
private static final long serialVersionUID = 1L;
private String message;
private boolean success;



public ApiResponse(String message, boolean success) {
	super();
	this.message = message;
	this.success = success;
}
public ApiResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}


	
	
}
