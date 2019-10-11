package com.ing.mortgages.dto;

public class ListOfLoansDTO {
	
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
