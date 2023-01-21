package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.model.Cibil;
import com.infy.Small_Business_Finance_App.app.model.Enquiry;
import com.infy.Small_Business_Finance_App.app.repository.CibilRepository;
import com.infy.Small_Business_Finance_App.app.repository.EnquiryRepository;
import com.infy.Small_Business_Finance_App.app.serviceI.CibilService;

@Service
public class CibilServiceImpl implements CibilService
{
	@Autowired
	CibilRepository cr;
	
	@Autowired
	EnquiryRepository er;

	@Override
	public Cibil checkCibil(String panCard) {
		// TODO Auto-generated method stub
		Optional<Enquiry> oe=er.findByPanCard(panCard);
		Cibil c=new Cibil();
		if(oe.isPresent())
		{
			Random random=new Random();
			Enquiry e=oe.get();
			c.setCibilScore(random.nextInt(899)+100);
			if(c.getCibilScore()<300)
			{
				c.setCibilRemark("Poor");
			}
			if(c.getCibilScore()>=300 && c.getCibilScore()<700)
			{
				c.setCibilRemark("Moderate");
			}
			if(c.getCibilScore()>=700)
			{
				c.setCibilRemark("Good");
			}
//			Cibil cbl=cr.findByCibilScore(c.getCibilScore());
//			System.out.println("*****************" + cbl);
			e.setCibil(c);
			er.save(e);
			return c;
		}
		return null;
	}
	
}
