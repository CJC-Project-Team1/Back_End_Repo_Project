package com.infy.Small_Business_Finance_App.app.dto;

import lombok.Data;

@Data
public class sanctionedLoanDetailsDto 
{
	private Integer sanctionedLoanId;
	private Long sanctionedLoanAmount;
	private Integer sanctionedLoanTenure;
	private String customerName;
	private Integer customerId;
	private Double emi;

}
