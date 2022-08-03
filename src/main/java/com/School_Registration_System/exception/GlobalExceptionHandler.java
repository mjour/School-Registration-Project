package com.School_Registration_System.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.School_Registration_System.dto.ApiResponse;
import com.School_Registration_System.dto.ResponseDTO;



@RestControllerAdvice
public class GlobalExceptionHandler {
	   @ExceptionHandler(ResourceNotFoundException.class)
		public  ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
		{
			
			 String message= ex.getMessage();
			 ApiResponse apiResponse = new ApiResponse(message,false);
			 return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}

	  	@ExceptionHandler(MethodArgumentNotValidException.class)
	  	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
	  		Map<String, String> resp = new HashMap<>();
	  		//IF ALL FIELD IS INVALID 
	  		//SO WE HAVE TO REMOVE ALL FIELD  AND MESSAGE
	  		
	  		ex.getBindingResult().getAllErrors().forEach((error) -> {
	  			String fieldName = ((FieldError) error).getField();
	  			String message = error.getDefaultMessage();
	  			resp.put(fieldName, message);
	  		});

	  		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	  	}
	  	
	  	@ExceptionHandler(BadRequestException.class)
		@ResponseBody
		public ResponseDTO<?> handleBadRequestException(BadRequestException badRequestException) {
			//logger(badRequestException);
			return prepareResponseVO(badRequestException.getErrorCode(), badRequestException.getErrorMessage());
		}
	  	
	  	private ResponseDTO<?> prepareResponseVO(String errorCode, String errorMessage) {
			return new ResponseDTO<>(errorCode, errorMessage);
		}
	  	
}
