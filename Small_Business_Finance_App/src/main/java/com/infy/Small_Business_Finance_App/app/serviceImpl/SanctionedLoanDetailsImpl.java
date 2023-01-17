package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.exception.ExceptionById;
import com.infy.Small_Business_Finance_App.app.model.SanctionedLoanDetails;
import com.infy.Small_Business_Finance_App.app.repository.SanctionedLoanDetailsRepository;
import com.infy.Small_Business_Finance_App.app.serviceI.SanctionedLoanDetailsServiceI;

@Service
public class SanctionedLoanDetailsImpl implements SanctionedLoanDetailsServiceI
{
	@Autowired
	SanctionedLoanDetailsRepository sr;

	@Override
	public SanctionedLoanDetails saveSanLoanDetails(SanctionedLoanDetails sLoan) 
	{
		return sr.save(sLoan);
	}

	@Override
	public List<SanctionedLoanDetails> getAllSanLoanDetails() 
	{
		List<SanctionedLoanDetails> sLoanList=sr.findAll();
		return sLoanList;
	}

	@Override
	public SanctionedLoanDetails getSanLoanDetailsById(int id) 
	{
		Optional<SanctionedLoanDetails> os=sr.findById(id);
		if(os.isPresent())
		{
			SanctionedLoanDetails sLoan=os.get();
			return sLoan;
		}
		else
		{
			throw new ExceptionById("Sorry!! No SanctionedLoanDetails is present with this ID .");
		}
		
	}

	@Override
	public SanctionedLoanDetails updateSanLoanDetails(int id, SanctionedLoanDetails sLoan) 
	{
		Optional<SanctionedLoanDetails> os=sr.findById(id);
		if(os.isPresent())
		{
			SanctionedLoanDetails sL=os.get();
			sL.setSanctionedLoanAmount(sLoan.getSanctionedLoanAmount());
			sL.setSanctionedLoanTenure(sLoan.getSanctionedLoanTenure());
			sL.setCustomerName(sLoan.getCustomerName());
			sL.setCustomerId(sLoan.getCustomerId());
			sL.setMonthlyEmi(sLoan.getMonthlyEmi());
			sL.setEmi(sLoan.getEmi());
			
			return sr.save(sL);
		}
		else
		{
			throw new ExceptionById("Sorry!! No SanctionedLoanDetails is present with this ID .");
		}
	}

}
