package com.infy.Small_Business_Finance_App.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Small_Business_Finance_App.app.dto.BusinessDetailsDto;
import com.infy.Small_Business_Finance_App.app.model.BusinessDetails;
import com.infy.Small_Business_Finance_App.app.serviceI.BusinessDetailsMapper;
import com.infy.Small_Business_Finance_App.app.serviceI.BusinessDetailsServiceI;

@RestController
@RequestMapping(value = "/businessdetailApi")
public class BusinessDetailsController 
{
	@Autowired
	BusinessDetailsServiceI bdsi;
	
	BusinessDetailsMapper bdmap;
	
	@PostMapping(value = "/businessdetail",consumes = {"application/json","application/xml"})
	public ResponseEntity<String> saveBusinessDetails(@RequestBody BusinessDetailsDto bdto)
	{
		BusinessDetails bd=bdmap.INSTANCE.dtoToBusinessDetails(bdto);
		bdsi.saveBusinessDetails(bd);
		return new ResponseEntity<String>("Saved",HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/businessdetails",produces = {"application/json","application/xml"})
	public ResponseEntity<List<BusinessDetailsDto>> getBusinessDetails()
	{
		List<BusinessDetails> bd=bdsi.getBusinessDetails();
		List<BusinessDetailsDto> bdtos=bdmap.INSTANCE.businessDetailsDtos(bd);
		return new ResponseEntity<List<BusinessDetailsDto>>(bdtos,HttpStatus.OK);
	}
	
	@PutMapping(value = "/businessdetail/{id}")
	public ResponseEntity<String> updateBusinessDetails(@RequestBody BusinessDetailsDto bdto,@PathVariable int id)
	{
		BusinessDetails bd=bdmap.INSTANCE.dtoToBusinessDetails(bdto);
		bdsi.updateBusinessDetails(bd,id);
		return new ResponseEntity<String>("Updated",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/businessdetail/{id}")
	public ResponseEntity<String> deleteBusinessDetails(@PathVariable int id)
	{
		bdsi.deleteBusinessDetails(id);
		return new ResponseEntity<String>("Deleted",HttpStatus.NO_CONTENT);
	}
}
