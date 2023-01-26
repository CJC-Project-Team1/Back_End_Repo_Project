package com.infy.Small_Business_Finance_App.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Double emiAmount;
	private Integer emiCount;
	private Double loanBal;
	private Integer defautlerCount;
	private Date date;
}
