package com.infy.Small_Business_Finance_App.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	@OneToOne(cascade = CascadeType.MERGE)
	private BorrowerBankDetails bankDetails;
	@OneToOne(cascade = CascadeType.MERGE)
	private BusinessDetails businessDetails;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<PreviousLoanDetails> loanHistory;
	@OneToOne(cascade = CascadeType.MERGE)
	private BorrowerDocuments borrowerDocuments;
	@OneToOne(cascade = CascadeType.MERGE)
	private AppliedLoan appliedLoan;
}
