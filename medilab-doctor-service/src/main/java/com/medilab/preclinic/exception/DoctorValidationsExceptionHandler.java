package com.medilab.preclinic.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DoctorValidationsExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ApiError> errorsList = new ArrayList<>();
			ex.getFieldErrors().stream().forEach(fieldError->{
				ApiError apiError = new ApiError(status.value(),fieldError.getDefaultMessage(),
						new Date(),status.getReasonPhrase());
				errorsList.add(apiError);
			});
		return ResponseEntity.status(HttpStatus.OK).body(errorsList);
	}
}
