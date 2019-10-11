package com.ing.mortgages.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "loan")
public class Loan implements Serializable {
	
	private static final long serialVersionUID = -5901129703546095407L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loanId;
	private Integer loanAmount;
	private Integer tenure;
	private Double EMI;
	private Integer rateOfInterest;
	
	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Integer getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Double getEMI() {
		return EMI;
	}

	public void setEMI(Double eMI) {
		EMI = eMI;
	}

	public Integer getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Integer rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}


}