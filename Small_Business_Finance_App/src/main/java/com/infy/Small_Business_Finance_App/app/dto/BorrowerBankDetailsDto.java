package com.infy.Small_Business_Finance_App.app.dto;

import lombok.Data;

@Data
public class BorrowerBankDetailsDto 
{
	private Integer bankDetailsId;
	private Long bankAccountNo;
	private String ifcsCode;
	private String bankName;
	private String bankBranch;
}
