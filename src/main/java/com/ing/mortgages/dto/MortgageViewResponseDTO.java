package com.ing.mortgages.dto;

import java.time.LocalDateTime;

public class MortgageViewResponseDTO {
	
	private String propertyName;
	private Integer propertyValue;
	private Integer tenure;
	private Double emi;
	private Double totalAmount;
	private Double outstandingBalance;
	private LocalDateTime createdDate;
	private Integer userId;
	
	
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

	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	public Double getEmi() {
		return emi;
	}
	public void setEmi(Double emi) {
		this.emi = emi;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getOutstandingBalance() {
		return outstandingBalance;
	}
	public void setOutstandingBalance(Double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
