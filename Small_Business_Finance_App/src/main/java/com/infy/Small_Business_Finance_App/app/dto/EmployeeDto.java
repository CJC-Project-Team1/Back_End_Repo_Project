package com.infy.Small_Business_Finance_App.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.infy.Small_Business_Finance_App.app.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
