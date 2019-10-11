package com.ing.mortgages.exception;

public class LoansListEmpty extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoansListEmpty(String message) {
		super(message);
	}
}
