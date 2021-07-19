package com.medilab.preclinic.exception;

import java.time.LocalDate;

public class DoctorCreationException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private LocalDate time;
	private String createdBy;
	public LocalDate getTime() {
		return time;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public DoctorCreationException() {
		// TODO Auto-generated constructor stub
	}
	public DoctorCreationException(String message) {
		this.message=message;
		this.time=LocalDate.now();
		this.createdBy="admin";
	}
	public String getMessage() {
		return message;
	}
	
}
