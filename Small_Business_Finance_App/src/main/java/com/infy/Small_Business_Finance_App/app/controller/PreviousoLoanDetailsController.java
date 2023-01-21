package com.infy.Small_Business_Finance_App.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Small_Business_Finance_App.app.dto.PreviousLoanDetailsDto;
import com.infy.Small_Business_Finance_App.app.model.PreviousLoanDetails;
import com.infy.Small_Business_Finance_App.app.serviceI.PreviousoLoanDetailsMapper;
import com.infy.Small_Business_Finance_App.app.serviceI.PreviousoLoanDetailsServiceI;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/CJC-Project-Team1/Back_End_Repo_Project.git
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/previousLoanDetailsApi")
public class PreviousoLoanDetailsController
{
	@Autowired
	PreviousoLoanDetailsServiceI plsi;
	
	PreviousoLoanDetailsMapper plmap;
	
	@PostMapping(value = "/previousLoanDetail")
	public ResponseEntity<String> savePreviousoLoanDetails(@RequestBody PreviousLoanDetailsDto dto)
	{
		PreviousLoanDetails pld=plmap.INSTANCE.dtoToPreviousoLoanDetails(dto);
		plsi.savePreviousoLoanDetails(pld);
		return new ResponseEntity<String>("Saved",HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/previousLoanDetails")
	public ResponseEntity<List<PreviousLoanDetailsDto>> getPreviousoLoanDetails()
	{
		List<PreviousLoanDetails> pls=plsi.getPreviousoLoanDetails();
		List<PreviousLoanDetailsDto> dtos=plmap.INSTANCE.previousoLoanDetailsToDtos(pls);
		return new ResponseEntity<List<PreviousLoanDetailsDto>>(dtos,HttpStatus.OK);
	}
	
	@PutMapping(value = "/previousLoanDetail/{id}")
	public ResponseEntity<String> updatePreviousoLoanDetails(@RequestBody PreviousLoanDetailsDto dto,@PathVariable int id)
	{
		PreviousLoanDetails pld=plmap.INSTANCE.dtoToPreviousoLoanDetails(dto);
		plsi.updatePreviousoLoanDetails(pld,id);
		return new ResponseEntity<String>("Updated",HttpStatus.OK);
	} 
	
	@DeleteMapping(value = "/previousLoanDetail/{id}")
	public ResponseEntity<String> deletePreviousoLoanDetails(@PathVariable int id)
	{
		plsi.deletePreviousoLoanDetails(id);
		return new ResponseEntity<String>("Deleted",HttpStatus.NO_CONTENT);
	} 
}
