package com.ing.mortgages.entity;

import java.time.LocalDateTime;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name= "mortgage")
public class Mortgage {
	
private static final long serialVersionUID = -5901129703546095407L;
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mortgageId;
	private String propertyName;
	private String propertyAddress;
	private Integer propertyValue;
	private Integer loanAmount;

	private Integer rateOfInterest;
	private Integer tenure;
	private Double emi;
	private Double totalAmount;
	private Double outstandingBalance;
	private LocalDateTime createdDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;




	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}




	public Integer getMortgageId() {
		return mortgageId;
	}


	public void setMortgageId(Integer mortgageId) {
		this.mortgageId = mortgageId;
	}






	public String getPropertyName() {
		return propertyName;
	}


	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}



	public String getPropertyAddress() {
		return propertyAddress;
	}


	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}


	public Integer getPropertyValue() {
		return propertyValue;
	}


	public void setPropertyValue(Integer propertyValue) {
		this.propertyValue = propertyValue;
	}


	public Integer getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}





	



	public Integer getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Integer rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
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

}


