package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.model.EMI;
import com.infy.Small_Business_Finance_App.app.repository.EMIrepository;
import com.infy.Small_Business_Finance_App.app.serviceI.EMIserviceI;

@Service
public class EMIserviceImpl implements EMIserviceI
{
	@Autowired
	EMIrepository er;
	
	@Override
	public EMI saveEMI(EMI emi) 
	{
		EMI e = er.save(emi);
		return e;
	}

	@Override
	public EMI updateEMI(EMI emi, int id) 
	{
		Optional<EMI> oemi = er.findById(id);
		if(oemi.isPresent())
		{
			EMI em = oemi.get();
			em.setEmiAmount(emi.getEmiAmount());
			em.setDefautlerCount(emi.getDefautlerCount());
			em.setEmiId(emi.getEmiId());
			em.setEmiPaid(emi.getEmiPaid());
			em.setEmiRemaining(emi.getEmiRemaining());
			em.setEmiStatus(emi.getEmiStatus());
			em.setEmiTenure(emi.getEmiTenure());
			em.setDefautlerCount(emi.getDefautlerCount());
			return er.save(em);
			
		}
		return null;
	}

	@Override
	public List<EMI> getAll() 
	{
		List<EMI> emiL = er.findAll();
		return emiL;
	}

	@Override
	public List<EMI> getEmiByStatus(String status) 
	{
		List<EMI> emiL = er.findByEmiStatus(status);
		return emiL;
	}

}
