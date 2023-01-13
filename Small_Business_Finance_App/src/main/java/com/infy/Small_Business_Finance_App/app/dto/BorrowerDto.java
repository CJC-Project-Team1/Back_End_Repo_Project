package com.infy.Small_Business_Finance_App.app.dto;

import lombok.Data;

@Data
public class BorrowerDto
{
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
	private AppliedLoanDto appliedLoanDto;
	private BorrowerBankDetailsDto bankDetailsDto;
	private BorrowerDocumentsDto documentDto;
	private BusinessDetailsDto businessDetailsDto;
	private PreviousLoanDetailsDto loanDetailsDto;
}
