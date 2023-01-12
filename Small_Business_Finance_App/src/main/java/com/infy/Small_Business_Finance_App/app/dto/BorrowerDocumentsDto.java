package com.infy.Small_Business_Finance_App.app.dto;

import javax.persistence.Lob;

import lombok.Data;
@Data
public class BorrowerDocumentsDto
{
	private Integer documentId;
	@Lob
	private byte[] adharCard;
	@Lob
	private byte[] panCard;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] bankStatement;
	@Lob
	private byte[] addressProof;
	@Lob
	private byte[] balanceSheet;
	@Lob
	private byte[] gstCertificate;
	@Lob
	private byte[] proprietaryDeed;
}
