package com.ing.mortgages.entity;



import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transactionId;
	private Long accountNo;
	private double amountDeducted;
	private LocalDateTime tDate;
	private double outStandingBalance;
	private Integer mortgageId;
	@ManyToOne

	@JoinColumn(name="account_id")

	@JoinColumn(name="account_number")
	private Account account;
	
	
	public double getOutStandingBalance() {
		return outStandingBalance;
	}
	public void setOutStandingBalance(double outStandingBalance) {
		this.outStandingBalance = outStandingBalance;
	}
	public Integer getMortgageId() {
		return mortgageId;
	}
	public void setMortgageId(Integer mortgageId) {
		this.mortgageId = mortgageId;
	}
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}


