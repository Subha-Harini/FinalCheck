package com.cognizant.stockmarketcharting.authenticationservice.exception;

public class VerificationPendingException extends Exception {
	
	private String msg;

	public VerificationPendingException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
