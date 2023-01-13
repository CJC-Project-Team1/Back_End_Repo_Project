package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.Employee;

public interface EmployeeServiceI 
{

	public Employee save(Employee emp);

	public List<Employee> getAllEmp();

	public List<Employee> getAllActiveEmp();
	
	public List<Employee> getAllInactiveEmp();

	public Employee getEmployeeById(int id);

	public Employee updateEmp(Employee emp, int id);

	public void deleteEmp(int id);
	
}
