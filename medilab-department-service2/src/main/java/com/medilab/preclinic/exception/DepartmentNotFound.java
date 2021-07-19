package com.medilab.preclinic.exception;

public class DepartmentNotFound extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public DepartmentNotFound() {
		// TODO Auto-generated constructor stub
	}
	public DepartmentNotFound(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
}
