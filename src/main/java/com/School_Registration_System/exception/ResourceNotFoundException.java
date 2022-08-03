package com.School_Registration_System.exception;



public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	String resourceName;
	String fieldName;
	
	long fieldValue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with this %s:%s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	
	
}
