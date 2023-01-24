package com.infy.Small_Business_Finance_App.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String applicationStatus;
	private String gstNo;
	@OneToOne(cascade = CascadeType.ALL)
	private BorrowerBankDetails bankDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private BusinessDetails businessDetails;
	@OneToOne(cascade = CascadeType.ALL)
    private PreviousLoanDetails loanHistory;
	@OneToOne(cascade = CascadeType.ALL)
	private BorrowerDocuments borrowerDocuments;
	@OneToOne(cascade = CascadeType.ALL)
	private AppliedLoan appliedLoan;
}
