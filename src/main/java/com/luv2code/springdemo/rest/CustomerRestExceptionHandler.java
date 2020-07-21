package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	
	// Add and exception handler for CustomerNotFoundException
	//NOT_FOUND is 404 exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc)
	{
		// create CustomerErrorResponse
		CustomerErrorResponse error=new CustomerErrorResponse(
									HttpStatus.NOT_FOUND.value(),
									exc.getMessage(),
									System.currentTimeMillis());
		//return ResponseEntity    
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//Add another exception Handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc)
	{
		// create CustomerErrorResponse
		// BAD_REQUEST is the 400 error
		CustomerErrorResponse error=new CustomerErrorResponse(
									HttpStatus.BAD_REQUEST.value(), 
									exc.getMessage(),
									System.currentTimeMillis());
		//return ResponseEntity    
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	

}
