package com.infy.Small_Business_Finance_App.app.dto;

import lombok.Data;

@Data
public class AppliedLoanDto
{
	private Integer appliedLoanId;
	private Double expectedAmount;
	private String loanType;
	private Integer emiCount;
	private String tenure;
	private String loanStatus;
	private Double rateOfInterest;
}
