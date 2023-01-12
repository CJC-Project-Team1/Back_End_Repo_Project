package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.exception.AlreadyUsedPanNumberException;
import com.infy.Small_Business_Finance_App.app.exception.ExceptionById;
import com.infy.Small_Business_Finance_App.app.model.Enquiry;
import com.infy.Small_Business_Finance_App.app.repository.EnquiryRepository;
import com.infy.Small_Business_Finance_App.app.serviceI.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI
{
	@Autowired
	EnquiryRepository er;

	@Override
	public Enquiry saveEnquiry(Enquiry enq) 
	{
		List<Enquiry> eList = er.findAll();
		for(Enquiry e:eList)
		{
			if(e.getPanCard().equals(enq.getPanCard()))
			{
				throw new AlreadyUsedPanNumberException("THIS PAN NUMBER IS ALREADY REGISTERED.");
			}	
			
		}
		return er.save(enq);
		
	}

	@Override
	public List<Enquiry> getAllEnquiry() 
	{
		List<Enquiry> LE=er.findAll();
		return LE;
	}

	@Override
	public Enquiry getEnquiryById(int id) 
	{
		Optional<Enquiry> oe= er.findById(id);
		if(oe.isPresent())
		{
			Enquiry enq=oe.get();
			return enq;
		}
		else
		{
			throw new ExceptionById("Sorry! No Enquiry is present with tis ID.");
		}
		
	}

	@Override
	public Enquiry updateEnquiry(int id, Enquiry e) 
	{
		Optional<Enquiry> oe=er.findById(id);
		if(oe.isPresent())
		{
			Enquiry enq = oe.get();
			enq.setEnquiryStatus(e.getEnquiryStatus());			
			return er.save(enq);
		}
		else
		{
			throw new ExceptionById("Sorry! No Enquiry is present with tis ID.");
		}
		
	}

}
