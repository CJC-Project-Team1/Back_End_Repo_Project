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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.Small_Business_Finance_App.app.dto.BorrowerDto;
import com.infy.Small_Business_Finance_App.app.model.Borrower;
import com.infy.Small_Business_Finance_App.app.model.PreviousLoanDetails;
import com.infy.Small_Business_Finance_App.app.serviceI.BorrowerMapper;
import com.infy.Small_Business_Finance_App.app.serviceI.BorrowerServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/borrowerApi")
public class BorrowerController 
{
	@Autowired
	BorrowerServiceI bsi;
	
	BorrowerMapper bmap;
	@PostMapping(value = "/borrower",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> saveBorrower(
			@RequestPart(value = "adharCard") MultipartFile adhar,
			@RequestPart(value = "panCard") MultipartFile pan,
			@RequestPart(value = "photo") MultipartFile photo,
			@RequestPart(value = "bankStatement") MultipartFile statement,
			@RequestPart(value = "addressProof") MultipartFile address,
			@RequestPart(value = "balanceSheet") MultipartFile balancesheet,
			@RequestPart(value = "gstCertificate") MultipartFile gst,
			@RequestPart(value = "proprietaryDeed") MultipartFile deed,
			@RequestPart(value = "borrower") String borrower)
	{
		ObjectMapper om= new ObjectMapper();
		
		try {
			
			Borrower b = om.readValue(borrower, Borrower.class);
			b.getBorrowerDocuments().setAdharCard(adhar.getBytes());
			b.getBorrowerDocuments().setPanCard(pan.getBytes());
			b.getBorrowerDocuments().setPhoto(photo.getBytes());
			b.getBorrowerDocuments().setBankStatement(statement.getBytes());
			b.getBorrowerDocuments().setAddressProof(address.getBytes());
			b.getBorrowerDocuments().setBalanceSheet(balancesheet.getBytes());
			b.getBorrowerDocuments().setGstCertificate(gst.getBytes());
			b.getBorrowerDocuments().setProprietaryDeed(deed.getBytes());
			System.out.println(b);
			System.out.println("adhar card="+b.getBorrowerDocuments().getAdharCard());
			bsi.saveBorrower(b);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return new ResponseEntity<String>("Saved",HttpStatus.CREATED);
		} 
	
	@GetMapping(value = "/borrowers")
	public ResponseEntity<List<Borrower>> getBorrower()
	{
		List<Borrower> list=bsi.getBorrower();
		return new ResponseEntity<List<Borrower>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value = "/borrower/{id}")
	public ResponseEntity<Borrower> getBorrower(@PathVariable int id)
	{
		Borrower b=bsi.getBorrowerById(id);
		return new ResponseEntity<Borrower>(b,HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/update")
	public String update(@RequestBody Borrower b) {
		
		System.out.println("in update borrower");
		bsi.updateBorrower(b);
		return "updated";
	}
	
	@DeleteMapping(value = "/borrower/{id}")
	public ResponseEntity<String> deleteBorrower(@PathVariable int id)
	{
			bsi.deleteBorrower(id);
			return new ResponseEntity<String>("Deleted",HttpStatus.NO_CONTENT);
	} 
}
