package com.ing.mortgages.dto;

public class TransactionRequest {
	private Long accNumber;
	private Double transactionAmount;
	private Integer userId;
	
	public Long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(Long accNumber) {
		this.accNumber = accNumber;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

}
