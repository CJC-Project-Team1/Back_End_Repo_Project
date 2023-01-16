package com.infy.Small_Business_Finance_App.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Borrower 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer borrowerId;
	private String borrowerName;
	private String dateOfBirth;
	private String emailId;
	private Long contactNo;
	private Long adharNo;
	private String panNo;
	private String address;
	private String documentStatus;
	private String gstNo;
	@OneToOne
	private BorrowerBankDetails bankDetails;
//	@OneToOne
//	private BusinessDetails businessDetails;
//	@OneToMany
//	private List<PreviousLoanDetails> loanHistory;
//	@OneToOne
//	private BorrowerDocuments borrowerDocuments;
//	@OneToOne
//	private AppliedLoan appliedLoan;
}
