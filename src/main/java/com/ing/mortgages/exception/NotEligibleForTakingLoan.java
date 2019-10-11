package com.ing.mortgages.exception;

public class NotEligibleForTakingLoan extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotEligibleForTakingLoan(String message) {
		super(message);
	}

}
