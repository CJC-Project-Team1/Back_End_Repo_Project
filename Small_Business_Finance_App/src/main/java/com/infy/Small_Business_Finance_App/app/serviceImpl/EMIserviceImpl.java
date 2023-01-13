package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.exception.ExceptionById;
import com.infy.Small_Business_Finance_App.app.model.EMI;
import com.infy.Small_Business_Finance_App.app.repository.EMIrepository;
import com.infy.Small_Business_Finance_App.app.serviceI.EMIserviceI;

@Service
public class EMIserviceImpl implements EMIserviceI
{
	@Autowired
	EMIrepository emiR;
	
	@Override
	public EMI saveEMI(EMI emi) 
	{
		return  emiR.save(emi);		
	}

	@Override
	public List<EMI> getAllEMI() 
	{
		List<EMI> emiList = emiR.findAll();
		return emiList;
	}

	@Override
	public EMI getEMIById(int id) 
	{
		Optional<EMI> oemi = emiR.findById(id);
		if(oemi.isPresent())
		{
			EMI emi = oemi.get();
			return emi ;
		}
		else
		{
			throw new ExceptionById("Sorry!! No EMI is present with this ID .");
		}
		
	}

	@Override
	public EMI updateEMI(int id, EMI emi) 
	{
		Optional<EMI> oemi = emiR.findById(id);
		if(oemi.isPresent())
		{
			EMI em = oemi.get();
			em.setEmiAmount(emi.getEmiAmount());
			em.setEmiPaid(emi.getEmiPaid());
			em.setEmiRemaining(emi.getEmiRemaining());
			em.setEmiStatus(emi.getEmiStatus());
			em.setEmiTenure(emi.getEmiTenure());
			em.setDefautlerCount(emi.getDefautlerCount());
			em.setSanLoan(emi.getSanLoan());
			
			return emiR.save(em);
		}
		else
		{
			throw new ExceptionById("Sorry!! No EMI is present with this ID .");
		}
		
	}

	
}
