package com.infy.Small_Business_Finance_App.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BorrowerDocuments
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
