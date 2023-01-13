package com.infy.Small_Business_Finance_App.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.Small_Business_Finance_App.app.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{

	public List<Employee> findAllByEmpStatus(String status);

}
