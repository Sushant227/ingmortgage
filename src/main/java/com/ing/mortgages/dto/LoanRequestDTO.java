package com.ing.mortgages.dto;

public class LoanRequestDTO {
	
	private String propertyName;
	private Integer propertyValue;
	private String propertyAddress;
	private Integer userId;
	private Integer loanId;
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public Integer getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(Integer propertyValue) {
		this.propertyValue = propertyValue;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	
}
