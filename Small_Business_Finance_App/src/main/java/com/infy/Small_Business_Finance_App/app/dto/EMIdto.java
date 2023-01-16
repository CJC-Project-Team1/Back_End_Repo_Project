package com.infy.Small_Business_Finance_App.app.dto;

import lombok.Data;

@Data
public class EMIdto 
{
	private Integer emiId;
	private String emiStatus;
	private String emiTenure;
	private Long emiAmount;
	private String emiPaid;
	private String emiRemaining;
	private Integer defautlerCount;

}
