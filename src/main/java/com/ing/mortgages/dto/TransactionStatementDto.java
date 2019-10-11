package com.ing.mortgages.dto;

import java.time.LocalDateTime;

public class TransactionStatementDto {
	private Integer transactionId;
	private Long accountNo;
	private double amountDeducted;
	private LocalDateTime tDate;
	private Double outStandingBalance;
	private Integer mortgageId;

	public LocalDateTime gettDate() {
		return tDate;
	}

	public void settDate(LocalDateTime tDate) {
		this.tDate = tDate;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getMortgageId() {
		return mortgageId;
	}

	public void setMortgageId(Integer mortgageId) {
		this.mortgageId = mortgageId;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public double getAmountDeducted() {
		return amountDeducted;
	}

	public void setAmountDeducted(double amountDeducted) {
		this.amountDeducted = amountDeducted;
	}

	public Double getOutStandingBalance() {
		return outStandingBalance;
	}

	public void setOutStandingBalance(Double outStandingBalance) {
		this.outStandingBalance = outStandingBalance;
	}


}
