package com.inventory.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such value is present  in DB.. Please change your request");

	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleBusinessException(BusinessException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product details are invalid. Please validate");

	}	

}
