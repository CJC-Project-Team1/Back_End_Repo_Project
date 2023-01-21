package com.infy.Small_Business_Finance_App.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infy.Small_Business_Finance_App.app.dto.EnquiryDto;
import com.infy.Small_Business_Finance_App.app.model.Enquiry;
import com.infy.Small_Business_Finance_App.app.serviceI.EnquiryMapper;
import com.infy.Small_Business_Finance_App.app.serviceI.EnquiryServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/enquiryApi")
public class EnquiryController {

	@Autowired
	EnquiryServiceI esi;
	
	EnquiryMapper emap; 
	 
	
	@GetMapping(value = "/getEnq")
	public String  get()
	{
		return "SPRING BOOT SMALL BUSINESS FINANCE APP.";
	}
	
	@PostMapping(value = "/saveEnq",consumes = {"application/json","application/xml"} )
	public ResponseEntity<EnquiryDto> saveEnquiry(@RequestBody Enquiry edto)
	{
//		Enquiry enq=emap.INSTANCE.dtoToEnquiry(edto);
		System.out.println(edto.getPanCard());
		Enquiry enqry=esi.saveEnquiry(edto);
		EnquiryDto edt=emap.INSTANCE.enquiryToDto(enqry);
		return new ResponseEntity<EnquiryDto>(edt,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllEnq",produces = {"application/json","application/xml"} )
	public ResponseEntity<List<Enquiry>> getAll()
	{
		List<Enquiry> enqList=esi.getAllEnquiry();
		List<EnquiryDto> enqDtos= emap.INSTANCE.enquiriesToDtos(enqList);
		return new ResponseEntity<List<Enquiry>>(enqList,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getEnqByStatus/{status}",produces = {"application/json","application/xml"} )
	public ResponseEntity<List<EnquiryDto>> getByStatus(@PathVariable String status)
	{
		List<Enquiry> enqList=esi.getByStatus(status);
		List<EnquiryDto> enqDtos= emap.INSTANCE.enquiriesToDtos(enqList);
		return new ResponseEntity<List<EnquiryDto>>(enqDtos,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEnqById/{id}",produces = {"application/json","application/xml"} )
	public ResponseEntity<EnquiryDto> getById(@PathVariable int id)
	{
		Enquiry enq=esi.getEnquiryById(id);
		EnquiryDto enqDto= emap.INSTANCE.enquiryToDto(enq);
		return new ResponseEntity<EnquiryDto>(enqDto,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateEnq/{id}",consumes = {"application/json","application/xml"})
	public ResponseEntity<EnquiryDto> updateEnq(@RequestBody Enquiry e,@PathVariable int id)
	{
		
		Enquiry enq=esi.updateEnquiry(id,e);
		System.out.println(enq.getCustomerName());
		System.out.println(enq.getEnquiryStatus());
		EnquiryDto edto=emap.INSTANCE.enquiryToDto(enq);
		
		return new ResponseEntity<EnquiryDto>(edto,HttpStatus.OK);
	}
	
	
}
