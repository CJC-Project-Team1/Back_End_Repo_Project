package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.infy.Small_Business_Finance_App.app.dto.EmployeeDto;
import com.infy.Small_Business_Finance_App.app.model.Employee;


@Mapper
public interface EmployeeMapper 
{
	EmployeeMapper INSTANCE=Mappers.getMapper(EmployeeMapper.class);
	public Employee dtoToEmployee(EmployeeDto empdto);
	public EmployeeDto employeeToDto(Employee emp);
	public List<Employee> dtosToEmployees(List<EmployeeDto> edtos);
	public List<EmployeeDto> employeesToDtos(List<Employee> enqs);
}
