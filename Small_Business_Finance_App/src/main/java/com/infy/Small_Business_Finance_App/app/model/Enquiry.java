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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer enquiryId;
	private String customerName;
	private String panCard;
	private String adharCard;
	private String emailId;
	private String dateOfBirth;
	private String enquiryStatus;
	private Long contactNo;
	@OneToOne(cascade = CascadeType.ALL)
	private Cibil cbl;

}
