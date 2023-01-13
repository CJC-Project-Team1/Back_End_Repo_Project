package com.infy.Small_Business_Finance_App.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infy.Small_Business_Finance_App.app.dto.EMIdto;
import com.infy.Small_Business_Finance_App.app.model.EMI;
import com.infy.Small_Business_Finance_App.app.serviceI.EMImapper;
import com.infy.Small_Business_Finance_App.app.serviceI.EMIserviceI;

@RestController
@RequestMapping(value = "/emiApi")
public class EMIcontroller 
{
	@Autowired
	EMIserviceI emiS;
	
	EMImapper emiMap;
	
	@PostMapping(value = "/saveEMI",consumes = {"application/json","application/xml"} )
	public ResponseEntity<EMIdto> saveEMI(@RequestBody EMIdto emiDto)
	{
		EMI emi=emiMap.INSTANCE.dtoToEmi(emiDto);
		EMI em=emiS.saveEMI(emi);
		EMIdto edto=emiMap.INSTANCE.emiToDto(em);
		return new ResponseEntity<EMIdto>(edto,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllEMI",produces = {"application/json","application/xml"} )
	public ResponseEntity<List<EMIdto>> getAll()
	{
		List<EMI> emiList=emiS.getAllEMI();
		List<EMIdto> emiDtos=emiMap.INSTANCE.emisToDtos(emiList);
		return new ResponseEntity<List<EMIdto>>(emiDtos,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEMIbyId/{id}",produces = {"application/json","application/xml"} )
	public ResponseEntity<EMIdto> getById(@PathVariable int id)
	{
		EMI emi=emiS.getEMIById(id);
		EMIdto emiDto=emiMap.INSTANCE.emiToDto(emi);
		return new ResponseEntity<EMIdto>(emiDto,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateEMI/{id}",consumes = {"application/json","application/xml"} )
	public ResponseEntity<EMIdto> saveEMI(@RequestBody EMI emi,@PathVariable int id)
	{
		EMI em=emiS.updateEMI(id,emi);
		EMIdto edto=emiMap.INSTANCE.emiToDto(emi);
		return new ResponseEntity<EMIdto>(edto,HttpStatus.CREATED);
	}
	
	
}
