package com.infy.Small_Business_Finance_App.app.serviceI;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	
	public Employee updateEmpPhoto(MultipartFile photo, int id) throws IOException;
	
}
