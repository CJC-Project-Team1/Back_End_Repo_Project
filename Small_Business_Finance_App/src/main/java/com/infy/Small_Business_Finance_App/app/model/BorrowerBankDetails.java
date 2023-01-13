package com.infy.Small_Business_Finance_App.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BorrowerBankDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankDetailsId;
	private Long bankAccountNo;
	private String ifcsCode;
	private String bankName;
	private String bankBranch;
}
