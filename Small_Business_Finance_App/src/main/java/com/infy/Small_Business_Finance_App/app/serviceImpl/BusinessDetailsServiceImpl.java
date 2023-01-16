package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.exception.ExceptionById;
import com.infy.Small_Business_Finance_App.app.model.BusinessDetails;
import com.infy.Small_Business_Finance_App.app.repository.BusinessDetailsRepository;
import com.infy.Small_Business_Finance_App.app.serviceI.BusinessDetailsServiceI;
@Service
public class BusinessDetailsServiceImpl implements BusinessDetailsServiceI
{
	@Autowired
	BusinessDetailsRepository bdrepo;

	@Override
	public void saveBusinessDetails(BusinessDetails bd) {
		// TODO Auto-generated method stub
		bdrepo.save(bd);
	}

	@Override
	public List<BusinessDetails> getBusinessDetails() {
		// TODO Auto-generated method stub
		return bdrepo.findAll();
	}

	@Override
	public void updateBusinessDetails(BusinessDetails bd, int id) throws ExceptionById{
		// TODO Auto-generated method stub
		Optional<BusinessDetails> b=bdrepo.findById(id);
		if(b.isPresent())
		{
			BusinessDetails bds=b.get();
			bds.setCompanyName(bd.getCompanyName());
			bds.setRevenue(bd.getRevenue());
			bds.setBusinesstype(bd.getBusinesstype());
			bdrepo.save(bds);
		}
		else {
			throw new ExceptionById("No record found with this id");
		}
	}

	@Override
	public void deleteBusinessDetails(int id) {
		// TODO Auto-generated method stub
		bdrepo.deleteById(id);
	}

}
