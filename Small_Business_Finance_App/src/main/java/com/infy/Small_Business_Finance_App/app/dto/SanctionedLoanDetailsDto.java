package com.infy.Small_Business_Finance_App.app.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.infy.Small_Business_Finance_App.app.model.Borrower;
import com.infy.Small_Business_Finance_App.app.model.EMI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SanctionedLoanDetailsDto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sanctionedLoanId;
	private String sanctionedLoanAmount;
	private String sanctionedLoanTenure;
	private Float rateOfInterest;
	private Double monthlyEmi;
	@Lob
	private byte[] sanctionLetter;
	@OneToOne(cascade = CascadeType.ALL)
	private Borrower borrower;
	@OneToMany(cascade = CascadeType.ALL)
	private List<EMI> emilist;

}
