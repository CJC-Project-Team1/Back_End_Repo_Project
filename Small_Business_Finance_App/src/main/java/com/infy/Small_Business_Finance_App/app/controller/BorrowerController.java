package com.infy.Small_Business_Finance_App.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

@RestController
@RequestMapping(value = "/bapi")
public class BorrowerController 
{
	@Autowired
	BorrowerServiceI bsi;
	
	BorrowerMapper bmap;
	
	@PostMapping(value = "/borrower",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<BorrowerDto> saveBorrower(//@RequestPart(value = "adharCard") MultipartFile adhar,
//			@RequestPart(value = "panCard") MultipartFile pan,
//			@RequestPart(value = "photo") MultipartFile photo,
//			@RequestPart(value = "bankStatement") MultipartFile statement,
//			@RequestPart(value = "addressProof") MultipartFile address,
//			@RequestPart(value = "balanceSheet") MultipartFile balancesheet,
//			@RequestPart(value = "gstCertificate") MultipartFile gst,
//			@RequestPart(value = "proprietaryDeed") MultipartFile deed,
			@RequestPart(value = "borrower") String borrower)
	{
		ObjectMapper obj=new ObjectMapper();
		try 
		{
			BorrowerDto bdto=obj.readValue(borrower, BorrowerDto.class);
			Borrower b=bmap.INSTANCE.dtoToBorrower(bdto);
//			Borrower bo=new Borrower();
//			List<PreviousLoanDetails> list=b.getLoanHistory();
//			bo.getLoanHistory().addAll(list);
			bsi.saveBorrower(b);
			BorrowerDto bdt=bmap.INSTANCE.borrowerToDto(b);
			return new ResponseEntity<BorrowerDto>(bdt,HttpStatus.CREATED);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
