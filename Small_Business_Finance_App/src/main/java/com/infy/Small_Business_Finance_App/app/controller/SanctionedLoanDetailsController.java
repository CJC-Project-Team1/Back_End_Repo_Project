package com.infy.Small_Business_Finance_App.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.infy.Small_Business_Finance_App.app.dto.SanctionedLoanDetailsDto;
import com.infy.Small_Business_Finance_App.app.model.SanctionedLoanDetails;
import com.infy.Small_Business_Finance_App.app.serviceI.SanctionedLoanDetailsMapper;
import com.infy.Small_Business_Finance_App.app.serviceI.SanctionedLoanDetailsServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sanLoanApi")
public class SanctionedLoanDetailsController 
{
	@Autowired
	SanctionedLoanDetailsServiceI sLoanS;
	
	SanctionedLoanDetailsMapper sLoanMap;
	
	@PostMapping(value = "/saveSanLoan",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<SanctionedLoanDetailsDto> saveSanLoan(@RequestPart(value = "sanctionLetter") MultipartFile sanctionLetter,
																@RequestPart(value = "loandetails") String loandetails) throws Exception, JsonProcessingException
	{
		
		ObjectMapper om = new ObjectMapper();
		SanctionedLoanDetailsDto sldto = om.readValue(loandetails, SanctionedLoanDetailsDto.class);
		sldto.setSanctionLetter(sanctionLetter.getBytes());
		sldto.getEmilist().clear();
		SanctionedLoanDetails sLoan=sLoanMap.INSTANCE.dtoToEntity(sldto);
		SanctionedLoanDetails sL = sLoanS.saveSanLoanDetails(sLoan);
		SanctionedLoanDetailsDto sdt=sLoanMap.INSTANCE.entityToDto(sL);
		return new ResponseEntity<SanctionedLoanDetailsDto>(sdt,HttpStatus.CREATED);	
	}
	
	@GetMapping(value = "/getAllSanLoan",produces = {"application/json","application/xml"})
	public ResponseEntity<List<SanctionedLoanDetailsDto>> getAll()
	{
		List<SanctionedLoanDetails> sList = sLoanS.getAllSanLoanDetails();
		List<SanctionedLoanDetailsDto> sdList=sLoanMap.INSTANCE.entitiesToDtos(sList);
		return new ResponseEntity<List<SanctionedLoanDetailsDto>>(sdList,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSanLoanById/{id}",produces = {"application/json","application/xml"})
	public ResponseEntity<SanctionedLoanDetailsDto> getById(@PathVariable int id)
	{
		SanctionedLoanDetails sLoan = sLoanS.getSanLoanDetailsById(id);
		SanctionedLoanDetailsDto sDto=sLoanMap.INSTANCE.entityToDto(sLoan);
		return new ResponseEntity<SanctionedLoanDetailsDto>(sDto,HttpStatus.OK);
	}
	
	

	@PutMapping(value = "updateSanLoan/{id}",consumes = {"application/json","application/xml"})
	public ResponseEntity<SanctionedLoanDetailsDto> updateSanLoan(@RequestBody SanctionedLoanDetails sLaon,@PathVariable int id)
	{
		SanctionedLoanDetails sL = sLoanS.updateSanLoanDetails(id, sLaon);
		SanctionedLoanDetailsDto sdt=sLoanMap.INSTANCE.entityToDto(sL);
		return new ResponseEntity<SanctionedLoanDetailsDto>(sdt,HttpStatus.OK);	
	}
}
