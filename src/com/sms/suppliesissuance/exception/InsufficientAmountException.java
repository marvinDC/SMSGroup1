package com.sms.suppliesissuance.exception;

public class InsufficientAmountException extends Exception {

	private static final long serialVersionUID = -8481827939620052481L;
	private String message;
	
	public InsufficientAmountException(String message) {
		super();
		this.setMessage(message);
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
