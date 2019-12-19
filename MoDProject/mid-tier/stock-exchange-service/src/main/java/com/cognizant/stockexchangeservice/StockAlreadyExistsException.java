package com.cognizant.stockexchangeservice;

public class StockAlreadyExistsException extends Exception {
	private String msg;

	public StockAlreadyExistsException(String msg) {
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
