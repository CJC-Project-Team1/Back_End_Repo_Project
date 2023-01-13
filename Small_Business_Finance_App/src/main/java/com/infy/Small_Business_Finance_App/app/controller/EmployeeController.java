package com.infy.Small_Business_Finance_App.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.Small_Business_Finance_App.app.dto.EmployeeDto;
import com.infy.Small_Business_Finance_App.app.model.Employee;
import com.infy.Small_Business_Finance_App.app.serviceI.EmployeeMapper;
import com.infy.Small_Business_Finance_App.app.serviceI.EmployeeServiceI;

@RestController
@RequestMapping(value = "/empApi")
public class EmployeeController 
{
	@Autowired
	EmployeeServiceI esi;
	
	EmployeeMapper mapper;
	
	@PostMapping(value = "/saveEmp", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestPart(value = "employeedetails") String employeedetails, @RequestPart(value = "photo") MultipartFile photo) throws Exception, JsonProcessingException
	{
		ObjectMapper om = new ObjectMapper();
		EmployeeDto empDto = om.readValue(employeedetails, EmployeeDto.class);
		empDto.setPhoto(photo.getBytes());
		Employee emp = mapper.INSTANCE.dtoToEmployee(empDto);
		emp.setEmpStatus("Active");
		Employee employee = esi.save(emp);
		EmployeeDto edto = mapper.INSTANCE.employeeToDto(employee);
		return new ResponseEntity<EmployeeDto>(edto, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "getAllActiveEmp")
	public ResponseEntity<List<EmployeeDto>> getAllActiveEmp()
	{
		List<Employee> emplist = esi.getAllActiveEmp();
		List<EmployeeDto> edtolist = mapper.INSTANCE.employeesToDtos(emplist);
		return new ResponseEntity<List<EmployeeDto>>(edtolist, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllEmp")
	public ResponseEntity<List<EmployeeDto>> getAllEmpData()
	{
		List<Employee> emplist = esi.getAllEmp();
		List<EmployeeDto> edtolist = mapper.INSTANCE.employeesToDtos(emplist);
		return new ResponseEntity<List<EmployeeDto>>(edtolist, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEmp/{id}")
	public ResponseEntity<EmployeeDto> getEmpById(@PathVariable("id") int id)
	{
		Employee emp = esi.getEmpById(id);
		EmployeeDto edto = mapper.INSTANCE.employeeToDto(emp);
		return new ResponseEntity<EmployeeDto>(edto, HttpStatus.OK);
	}
	
	@PutMapping(value = "updateEmp/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<EmployeeDto> updateEmp(@PathVariable("id") int id, @RequestPart(value = "photo") MultipartFile photo, @RequestPart(value = "employeedetails") String employeedetails) throws Exception, JsonProcessingException
	{
		ObjectMapper om = new ObjectMapper();
		EmployeeDto empDto = om.readValue(employeedetails, EmployeeDto.class);
		empDto.setPhoto(photo.getBytes());
		Employee emp = mapper.INSTANCE.dtoToEmployee(empDto);
		Employee e = esi.updateEmp(emp, id);
		EmployeeDto edto = mapper.INSTANCE.employeeToDto(e);
		return new ResponseEntity<EmployeeDto>(edto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteEmp/{id}")
	public void deleteEmp(@PathVariable("id") int id)
	{
		Employee e = esi.getEmpById(id);
		e.setEmpStatus("Inactive");
		Employee emp = esi.save(e);
	}
}
