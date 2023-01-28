package com.infy.Small_Business_Finance_App.app.controller;

import java.util.Collections;
import java.util.Comparator;
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

import com.infy.Small_Business_Finance_App.app.model.EMI;
import com.infy.Small_Business_Finance_App.app.serviceI.EMIserviceI;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/emiApi")
public class EMIcontroller {

	@Autowired
	EMIserviceI emiS;
	
	@PostMapping(value = "/saveEmi")
	public ResponseEntity<EMI> saveEMI(@RequestBody EMI emi)
	{
		EMI e=emiS.saveEMI(emi);
		return new ResponseEntity<EMI>(e,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/updateEmi/{id}")
	public ResponseEntity<EMI> updateEMI(@RequestBody EMI emi,@PathVariable int id)
	{
		EMI e=emiS.updateEMI(emi,id);
		return new ResponseEntity<EMI>(e,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllemi")
	public ResponseEntity<List<EMI>> getAllemi()
	{
		List<EMI> emiL=emiS.getAll();
		Collections.sort(emiL, new Comparator<EMI>() {

			@Override
			public int compare(EMI e1, EMI e2) {
				
				return e1.getEmiId()-e2.getEmiId();
			}
			
		});
		return new ResponseEntity<List<EMI>>(emiL,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllemi/{status}")
	public ResponseEntity<List<EMI>> getEmiByStatus(@PathVariable String status)
	{
		List<EMI> emiL=emiS.getEmiByStatus(status);
		return new ResponseEntity<List<EMI>>(emiL,HttpStatus.OK);
	}
}
