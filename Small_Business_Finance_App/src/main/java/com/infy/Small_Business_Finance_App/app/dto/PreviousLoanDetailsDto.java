package com.infy.Small_Business_Finance_App.app.dto;

import lombok.Data;

@Data
public class PreviousLoanDetailsDto 
{
	private Integer loanDetailId;
	private String loanType;
	private Double loanAmount;
	private String loanTenure;
	private Double paidAmount;
	private Double remainingAmount;
	private String bankName;
	private Integer defaulterCount;
}
