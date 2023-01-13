package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.exception.ExceptionById;
import com.infy.Small_Business_Finance_App.app.model.Employee;
import com.infy.Small_Business_Finance_App.app.repository.EmployeeRepository;
import com.infy.Small_Business_Finance_App.app.serviceI.EmployeeServiceI;
@Service
public class EmployeeServiceImpl implements EmployeeServiceI
{
	@Autowired
	EmployeeRepository er;
	
	public Employee save(Employee emp)
	{
		return er.save(emp);
	}
	
	public List<Employee> getAllEmp()
	{
		return er.findAll();
	}
	
	public Employee getEmpById(int id)
	{
		Optional<Employee> emp = er.findById(id);
		if(emp.isPresent())
		{
			Employee e = emp.get();
			return e;
		}
		else
		{
			throw new ExceptionById("Sorry! No Employee is present with this ID.");
		}
	}
	
	public List<Employee> getAllActiveEmp()
	{
		String status = "Active";
		return er.findAllByEmpStatus(status);
	}
	
	public List<Employee> getAllInactiveEmp()
	{
		String status = "Inactive";
		return er.findAllByEmpStatus(status);
	}
	
	public Employee updateEmp(Employee emp, int id)
	{
		Optional<Employee> e = er.findById(id);
		if(e.isPresent())
		{
			emp.setEmployeeId(id);
			emp.setEmpStatus(e.get().getEmpStatus());
			Employee employee = er.save(emp);
			return employee;
		}
		else
		{
			throw new ExceptionById("Sorry! No Employee is present with this ID.");
		}
	}
	
}
