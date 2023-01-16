package com.infy.Small_Business_Finance_App.app.dto;


import com.infy.Small_Business_Finance_App.app.model.EMI;
import lombok.Data;

@Data
public class SanctionedLoanDetailsDto 
{
	private Integer sanctionedLoanId;
	private String sanctionedLoanAmount;
	private String sanctionedLoanTenure;
	private String customerName;
	private Integer customerId;
	private Double loanEmi;
	private EMI emi;

}
