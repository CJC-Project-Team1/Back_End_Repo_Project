package com.infy.Small_Business_Finance_App.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.Small_Business_Finance_App.app.dto.EmployeeDto;
import com.infy.Small_Business_Finance_App.app.model.Employee;
import com.infy.Small_Business_Finance_App.app.serviceI.EmployeeMapper;
import com.infy.Small_Business_Finance_App.app.serviceI.EmployeeServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping("/empApi")
public class EmployeeController 
{
	@Autowired
	EmployeeServiceI esi;
	
	EmployeeMapper mapper;
	
	@PostMapping(value = "/saveEmp", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestPart(value = "photo") MultipartFile photo,
													@RequestPart(value = "empdetails") String empdetails) throws Exception, JsonProcessingException
	{
		ObjectMapper om = new ObjectMapper();
		EmployeeDto empdto = om.readValue(empdetails, EmployeeDto.class);
		empdto.setPhoto(photo.getBytes());
		Employee emp = mapper.INSTANCE.dtoToEmployee(empdto);
		Employee e = esi.save(emp);
		EmployeeDto edto = mapper.INSTANCE.employeeToDto(e);
		return new ResponseEntity<EmployeeDto>(edto, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllEmp")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee()
	{
		List<Employee> emplist = esi.getAllEmp();
		List<EmployeeDto> empdtolist = mapper.INSTANCE.employeesToDtos(emplist);
		return new ResponseEntity<List<EmployeeDto>>(empdtolist, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllActiveEmp")
	public ResponseEntity<List<EmployeeDto>> getAllActiveEmployee()
	{
		List<Employee> emplist = esi.getAllActiveEmp();
		List<EmployeeDto> empdtolist = mapper.INSTANCE.employeesToDtos(emplist);
		return new ResponseEntity<List<EmployeeDto>>(empdtolist, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllInactiveEmp")
	public ResponseEntity<List<EmployeeDto>> getAllInactiveEmployee()
	{
		List<Employee> emplist = esi.getAllInactiveEmp();
		List<EmployeeDto> empdtolist = mapper.INSTANCE.employeesToDtos(emplist);
		return new ResponseEntity<List<EmployeeDto>>(empdtolist, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEmp/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") int id)
	{
		Employee emp = esi.getEmployeeById(id);
		EmployeeDto edto = mapper.INSTANCE.employeeToDto(emp);
		return new ResponseEntity<EmployeeDto>(edto, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateEmpPhoto/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") int id, 
			@RequestPart(value = "photo") MultipartFile photo) throws Exception, JsonProcessingException
	{

		Employee e = esi.updateEmpPhoto(photo, id);
		EmployeeDto edto = mapper.INSTANCE.employeeToDto(e);
		return new ResponseEntity<EmployeeDto>(edto, HttpStatus.OK);
	}

	@PutMapping(value = "/updateEmp/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<EmployeeDto> updateEmployeePhoto(@PathVariable("id") int id, 
													@RequestPart(value = "empdetails") String empdetails) throws Exception, JsonProcessingException
	{
		ObjectMapper om = new ObjectMapper();
		EmployeeDto empdto = om.readValue(empdetails, EmployeeDto.class);
		Employee emp = mapper.INSTANCE.dtoToEmployee(empdto);
		Employee e = esi.updateEmp(emp, id);
		EmployeeDto edto = mapper.INSTANCE.employeeToDto(e);
		return new ResponseEntity<EmployeeDto>(edto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteEmp/{id}")
	public String deleteEmployeeById(@PathVariable("id") int id)
	{
//		EmployeeDto edto = new EmployeeDto();
//		edto.setEmployeeId(id);
//		Employee emp = mapper.dtoToEmployee(edto); 
		esi.deleteEmp(id);
		return "Deleted";
	}
}
