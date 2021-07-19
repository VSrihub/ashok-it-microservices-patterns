package com.medilab.preclinic.exception;

public class DoctorNotFound extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public DoctorNotFound() {
		// TODO Auto-generated constructor stub
	}
	public DoctorNotFound(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
}
