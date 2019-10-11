package com.ing.mortgages.exception;

public class MortgagesDoesntExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MortgagesDoesntExistException(String message) {
		super(message);
	}

}
