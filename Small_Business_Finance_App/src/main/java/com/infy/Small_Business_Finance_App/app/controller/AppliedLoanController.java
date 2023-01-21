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

import com.infy.Small_Business_Finance_App.app.dto.AppliedLoanDto;
import com.infy.Small_Business_Finance_App.app.model.AppliedLoan;
import com.infy.Small_Business_Finance_App.app.serviceI.AppliedLoanMapper;
import com.infy.Small_Business_Finance_App.app.serviceI.AppliedLoanServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/aplliedloanApi")
public class AppliedLoanController 
{
	@Autowired
	AppliedLoanServiceI alsi;
	AppliedLoanMapper almap;
	
	@PostMapping(value = "/appliedloan")
	public ResponseEntity<String> saveAppliedLoan(@RequestBody AppliedLoanDto adto)
	{
		AppliedLoan al=almap.INSTANCE.dtoToAppliedLoan(adto);
		alsi.saveAppliedLoan(al);
		return new ResponseEntity<String>("Saved",HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/appliedloans")
	public ResponseEntity<List<AppliedLoanDto>> getAppliedLoan()
	{
		List<AppliedLoan> als=alsi.getAppliedLoan();
		List<AppliedLoanDto> adtos=almap.INSTANCE.appliedLoansToDtos(als);
		return new ResponseEntity<List<AppliedLoanDto>>(adtos,HttpStatus.OK);
	}
	
	@PutMapping(value = "/appliedloan/{id}")
	public ResponseEntity<String> updateAppliedLoan(@RequestBody AppliedLoanDto adto,@PathVariable int id)
	{
		AppliedLoan al=almap.INSTANCE.dtoToAppliedLoan(adto);
		alsi.updateAppliedLoan(al,id);
		return new ResponseEntity<String>("Updated",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/appliedloan/{id}")
	public ResponseEntity<String> deleteAppliedLoan(@PathVariable int id)
	{
		alsi.deleteAppliedLoan(id);
		return new ResponseEntity<String>("Deleted",HttpStatus.NO_CONTENT);
	}
}
