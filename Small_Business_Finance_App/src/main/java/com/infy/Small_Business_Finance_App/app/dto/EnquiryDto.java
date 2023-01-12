package com.infy.Small_Business_Finance_App.app.dto;

import com.infy.Small_Business_Finance_App.app.model.Cibil;

import lombok.Data;

@Data
public class EnquiryDto {

	private Integer enquiryId;
	private String customerName;
	private String panCard;
	private String adharCard;
	private String emailId;
	private String dateOfBirth;
	private String enquiryStatus;
	private Long contactNo;
	private Cibil cbl;
}
