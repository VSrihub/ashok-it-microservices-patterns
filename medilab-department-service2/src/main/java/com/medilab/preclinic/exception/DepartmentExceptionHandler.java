package com.medilab.preclinic.exception;

import java.util.Date;

import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentExceptionHandler {

	private static final Logger logger = Logger.getLogger(DepartmentExceptionHandler.class);
	
	@ExceptionHandler
	public ResponseEntity<ApiError> handleDeptNotFound(DepartmentNotFound dnf){
		logger.info("DepartmentExceptionHandler-->handleDeptNotFound");
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), 
				dnf.getMessage(), 
				new Date(), 
				dnf.getMessage()) ;
		return ResponseEntity.ok(error);
	}
	
	@ExceptionHandler
	public ResponseEntity<ApiError> handleDeptCrateException(DepartmentCreationException dce){
		logger.info("DepartmentExceptionHandler-->handleDeptNotFound");
		ApiError error = new ApiError(HttpStatus.NOT_ACCEPTABLE.value(), 
				dce.getMessage(), 
				new Date(), 
				dce.getMessage()) ;
		return ResponseEntity.ok(error);
	}
}
