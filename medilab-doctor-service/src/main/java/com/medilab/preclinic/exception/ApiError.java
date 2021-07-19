package com.medilab.preclinic.exception;

import java.util.Date;


public class ApiError {

	private int code;
	private String message;
	private Date time;
	
	public ApiError(int code, String message, Date time, String reason) {
		super();
		this.code = code;
		this.message = message;
		this.time = time;
		this.reason = reason;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private String reason;
	
  public static void main(String[] args) {
	String str = "str";
	Integer.parseInt(str);
	
	
}
}
