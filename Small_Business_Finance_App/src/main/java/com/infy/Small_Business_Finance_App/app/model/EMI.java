package com.infy.Small_Business_Finance_App.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class EMI 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer emiId;
	private String emiStatus;
	private String emiTenure;
	private Long emiAmount;
	private String emiPaid;
	private String emiRemaining;
	private Integer defautlerCount;
	@OneToOne(cascade = CascadeType.ALL)
	private sanctionedLoanDetails sanLoan;
	
	//one to one relationship

}
