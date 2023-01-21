package com.infy.Small_Business_Finance_App.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Small_Business_Finance_App.app.model.Cibil;
import com.infy.Small_Business_Finance_App.app.serviceI.CibilService;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/cibilApi")
public class CibilController 
{
	@Autowired
	CibilService csi;
	
	@GetMapping(value = "/cibil/{panCard}")
	public ResponseEntity<String> checkCibil(@PathVariable String panCard)
	{
		Cibil b=csi.checkCibil(panCard);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
