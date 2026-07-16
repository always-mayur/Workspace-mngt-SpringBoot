package com.workspace.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.workspace.common.CommonResponse;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public CommonResponse handleResourceNotFoundException(ResourceNotFoundException exception)
	{
//		CommonResponse response = new CommonResponse();
//		
//		response.setStatus("failure");
//		response.setResponseObject(null);
//		response.setErrorMessage(exception.getMessage());
//		
//		return response;
		return CommonResponse.failure(exception.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CommonResponse handleValidationException(MethodArgumentNotValidException exception)
	{
		CommonResponse response = new CommonResponse();
		
		response.setStatus("failue");
		response.setResponseObject(null);
		
		
		response.setErrorMessage(exception.getBindingResult().
				getAllErrors().get(0).getDefaultMessage());
		
		return response;
	}
	
	@ExceptionHandler(Exception.class)
	public CommonResponse handleException(Exception exception)
	{
	    return CommonResponse.failure(
	            exception.getMessage());
	}
}
