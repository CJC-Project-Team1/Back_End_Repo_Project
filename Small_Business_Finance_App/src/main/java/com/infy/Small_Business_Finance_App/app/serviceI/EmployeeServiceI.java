package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.Employee;

public interface EmployeeServiceI 
{

	public Employee save(Employee emp);

	public List<Employee> getAllEmp();

	public Employee getEmpById(int id);

	public Employee updateEmp(Employee emp, int id);

	public List<Employee> getAllActiveEmp();
	
	public List<Employee> getAllInactiveEmp();
	
}
