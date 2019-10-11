package com.ing.mortgages.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	

	@ExceptionHandler(InvalidUsernameOrPasswordException.class)
	public ResponseEntity<ResponseError> invalidUsernameOrPassword(InvalidUsernameOrPasswordException ex) {
		ResponseError error = new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LoansListEmpty.class)
	public ResponseEntity<ResponseError> loansListEmpty(LoansListEmpty ex) {
		ResponseError error = new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MortgagesDoesntExistException.class)
	public ResponseEntity<ResponseError> mortgagesDoesntExistException(MortgagesDoesntExistException ex) {
		ResponseError error = new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotEligibleForTakingLoan.class)
	public ResponseEntity<ResponseError> notEligibleForTakingLoan(NotEligibleForTakingLoan ex) {
		ResponseError error = new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PleaseCheckYourBalance.class)
	public ResponseEntity<ResponseError> globalExceptionHandler(PleaseCheckYourBalance exception) {
		ResponseError errorResponse = new ResponseError(exception.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}


}