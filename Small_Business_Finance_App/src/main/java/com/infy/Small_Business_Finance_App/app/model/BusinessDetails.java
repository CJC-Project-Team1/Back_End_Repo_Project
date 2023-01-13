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
public class BusinessDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer businessId;
	private String companyName;
	private Double revenue;
	private String businesstype;
}
