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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Small_Business_Finance_App.app.dto.BorrowerBankDetailsDto;
import com.infy.Small_Business_Finance_App.app.model.BorrowerBankDetails;
import com.infy.Small_Business_Finance_App.app.serviceI.BorrowerBankDetailsMapper;
import com.infy.Small_Business_Finance_App.app.serviceI.BorrowerBankDetailsServiceI;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/CJC-Project-Team1/Back_End_Repo_Project.git
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/bankdetailsApi")
public class BorrowerBankDetailsController 
{
	@Autowired
	BorrowerBankDetailsServiceI bdsi;
	
	BorrowerBankDetailsMapper bdmap;
	
	@PostMapping(value = "/bankdetail",consumes = {"application/json","application/xml"})
	public ResponseEntity<String> saveBankDetails(@RequestBody BorrowerBankDetailsDto bdto)
	{
		BorrowerBankDetails bd=bdmap.INSTANCE.dtoToBorrowerBankDetails(bdto);
		bdsi.saveBankDetails(bd);
		return new ResponseEntity<String>("Saved",HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/bankdetails",produces = {"application/json","application/xml"})
	public ResponseEntity<List<BorrowerBankDetailsDto>> getBankDetails()
	{
		List<BorrowerBankDetails> bd=bdsi.getBankDetails();
		List<BorrowerBankDetailsDto> bdto=bdmap.INSTANCE.borrowerBankDetailsToDtos(bd);
		return new ResponseEntity<List<BorrowerBankDetailsDto>>(bdto,HttpStatus.OK);
	}
	
	@PutMapping(value = "/bankdetail/{id}")
	public ResponseEntity<String> updateBankDetails(@RequestBody BorrowerBankDetailsDto bdto,@PathVariable int id)
	{
		BorrowerBankDetails bd=bdmap.INSTANCE.dtoToBorrowerBankDetails(bdto);
		bdsi.updateBankDetails(bd,id);
		return new ResponseEntity<String>("Updated",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/bankdetail/{id}")
	public ResponseEntity<String> deleteBankDetails(@PathVariable int id)
	{
		bdsi.deleteBankDetails(id);
		return new ResponseEntity<String>("Deleted",HttpStatus.NO_CONTENT);
	}
}
