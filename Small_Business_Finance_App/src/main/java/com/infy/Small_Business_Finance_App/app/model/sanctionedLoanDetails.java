package com.infy.Small_Business_Finance_App.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;



@Data
@Entity
public class sanctionedLoanDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sanctionedLoanId;
	private String sanctionedLoanAmount;
	private String sanctionedLoanTenure;
	private String customerName;
	private Integer customerId;
	private Double emi;

}
