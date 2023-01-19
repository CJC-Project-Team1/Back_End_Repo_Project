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
		emp.setEmpStatus("Active");
		return er.save(emp);
	}
	
	public List<Employee> getAllEmp()
	{
		return er.findAll();
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
	
	public Employee getEmployeeById(int id)
	{
		Optional<Employee> oe = er.findById(id);
		if(oe.isPresent())
		{
			Employee emp = oe.get();
			return emp;
		}
		else
		{
			throw new ExceptionById("Sorry! No Employee is present with this ID.");
		}
	}
	
	public Employee updateEmp(Employee emp, int id)
	{
		Optional<Employee> oe = er.findById(id);
		if(oe.isPresent())
		{
			emp.setEmpStatus(oe.get().getEmpStatus());
			emp.setEmployeeId(id);
			emp.setPhoto(oe.get().getPhoto());
			Employee e = er.save(emp);
			return e;
		}
		else
		{
			throw new ExceptionById("Sorry! No Employee is present with this ID.");
		}
	}
	
	public void deleteEmp(int id)
	{
		Optional<Employee> oe = er.findById(id);
		if(oe.isPresent())
		{
			Employee emp = oe.get();
			emp.setEmpStatus("Inactive");
			er.save(emp);
		}
		else
		{
			throw new ExceptionById("Sorry! No Employee is present with this ID.");
		}
	}
}
