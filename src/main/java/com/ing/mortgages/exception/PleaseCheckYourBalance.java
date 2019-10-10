package com.ing.mortgages.exception;

public class PleaseCheckYourBalance  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public  PleaseCheckYourBalance(String message) {
		super(message);
	}

}
