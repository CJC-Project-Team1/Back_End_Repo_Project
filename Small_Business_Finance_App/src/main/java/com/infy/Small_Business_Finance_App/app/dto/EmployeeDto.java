package com.infy.Small_Business_Finance_App.app.dto;

import javax.persistence.Lob;

import lombok.Data;

@Data
public class EmployeeDto 
{
	private Integer employeeId;
	private String employeeName;
	private String designation;
	private String contactNo;
	private String emailId;
	private String dob;
	private String appointmentDate;
	private String address;
	private String username;
	private String password;
	private String empStatus;
	@Lob
	private byte[] photo;
}
