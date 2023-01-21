package com.infy.Small_Business_Finance_App.app.controller;

import java.io.IOException;
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

import com.infy.Small_Business_Finance_App.app.dto.BorrowerDocumentsDto;
import com.infy.Small_Business_Finance_App.app.model.BorrowerDocuments;
import com.infy.Small_Business_Finance_App.app.serviceI.BorrowerDocumentsMapper;
import com.infy.Small_Business_Finance_App.app.serviceI.BorrowerDocumentsServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/borrowerDocumentsApi")
public class BorrowerDocumentsController
{
	@Autowired
	BorrowerDocumentsServiceI bdsi;
	BorrowerDocumentsMapper bdmap;
	
	@PostMapping(value = "/borrowerDocument",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> saveBorrowerDocuments(@RequestPart(value = "adhar") MultipartFile adhar,
			@RequestPart(value = "pan") MultipartFile pan,
			@RequestPart(value = "photo") MultipartFile photo,
			@RequestPart(value = "bankStatement") MultipartFile bankStatement,
			@RequestPart(value = "addressProof") MultipartFile addressProof,
			@RequestPart(value = "balanceSheet") MultipartFile balanceSheet,
			@RequestPart(value = "gstCertificate") MultipartFile gstCertificate,
			@RequestPart(value = "proprietaryDeed") MultipartFile proprietaryDeed) throws IOException
	{
		BorrowerDocumentsDto bdto=new BorrowerDocumentsDto();
		bdto.setAdharCard(adhar.getBytes());
		bdto.setPanCard(pan.getBytes());
		bdto.setPhoto(photo.getBytes());
		bdto.setBankStatement(bankStatement.getBytes());
		bdto.setAddressProof(addressProof.getBytes());
		bdto.setBalanceSheet(balanceSheet.getBytes());
		bdto.setGstCertificate(gstCertificate.getBytes());
		bdto.setProprietaryDeed(proprietaryDeed.getBytes());
		BorrowerDocuments bd=bdmap.INSTANCE.dtoToBorrowerDocuments(bdto);
		bdsi.saveBorrowerDocuments(bd);
		return new ResponseEntity<String>("Saved",HttpStatus.CREATED);
	}
	
	@GetMapping(value = "borrowerDocuments")
	public ResponseEntity<List<BorrowerDocumentsDto>> getBorrowerDocuments()
	{
		List<BorrowerDocuments> bds=bdsi.getBorrowerDocuments();
		List<BorrowerDocumentsDto> dtos=bdmap.INSTANCE.borrowerDocumentsToDtos(bds);
		return new ResponseEntity<List<BorrowerDocumentsDto>>(dtos,HttpStatus.OK);
	}
	
	@PutMapping(value = "/borrowerDocument/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> updateBorrowerDocuments(@RequestPart(value = "adhar") MultipartFile adhar,
			@RequestPart(value = "pan") MultipartFile pan,
			@RequestPart(value = "photo") MultipartFile photo,
			@RequestPart(value = "bankStatement") MultipartFile bankStatement,
			@RequestPart(value = "addressProof") MultipartFile addressProof,
			@RequestPart(value = "balanceSheet") MultipartFile balanceSheet,
			@RequestPart(value = "gstCertificate") MultipartFile gstCertificate,
			@RequestPart(value = "proprietaryDeed") MultipartFile proprietaryDeed,
			@PathVariable int id) throws IOException
	{
		BorrowerDocumentsDto bdto=new BorrowerDocumentsDto();
		bdto.setAdharCard(adhar.getBytes());
		bdto.setPanCard(pan.getBytes());
		bdto.setPhoto(photo.getBytes());
		bdto.setBankStatement(bankStatement.getBytes());
		bdto.setAddressProof(addressProof.getBytes());
		bdto.setBalanceSheet(balanceSheet.getBytes());
		bdto.setGstCertificate(gstCertificate.getBytes());
		bdto.setProprietaryDeed(proprietaryDeed.getBytes());
		BorrowerDocuments bd=bdmap.INSTANCE.dtoToBorrowerDocuments(bdto);
		bdsi.updateBorrowerDocuments(bd,id);
		return new ResponseEntity<String>("Updated",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/borrowerDocument/{id}")
	public ResponseEntity<String> deleteBorrowerDocuments(@PathVariable int id)
	{
		bdsi.deleteBorrowerDocuments(id);
		return new ResponseEntity<String>("Deleted",HttpStatus.NO_CONTENT);
	}
}
