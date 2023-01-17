package com.infy.Small_Business_Finance_App.app.model;

import lombok.Data;

@Data
public class Email 
{
	private String to;
	private String from;
	private String subject;
	private String text;
	private String borrowerName;
	private Integer applicationNo;
	private Double loanAmount;
	private String tenure;
	private Float intRate;
	
}
