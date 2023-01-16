package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.exception.ExceptionById;
import com.infy.Small_Business_Finance_App.app.model.PreviousLoanDetails;
import com.infy.Small_Business_Finance_App.app.repository.PreviousoLoanDetailsRepository;
import com.infy.Small_Business_Finance_App.app.serviceI.PreviousoLoanDetailsServiceI;

@Service
public class PreviousoLoanDetailsServiceImpl implements PreviousoLoanDetailsServiceI
{
	@Autowired
	PreviousoLoanDetailsRepository plrepo;

	@Override
	public void savePreviousoLoanDetails(PreviousLoanDetails pld) {
		// TODO Auto-generated method stub
		plrepo.save(pld);
	}

	@Override
	public List<PreviousLoanDetails> getPreviousoLoanDetails() {
		// TODO Auto-generated method stub
		return plrepo.findAll();
	}

	@Override
	public void updatePreviousoLoanDetails(PreviousLoanDetails pld,int id) throws ExceptionById{
		// TODO Auto-generated method stub
		Optional<PreviousLoanDetails> op=plrepo.findById(id);
		if(op.isPresent())
		{
			PreviousLoanDetails pl=op.get();
			pl.setLoanType(pld.getLoanType());
			pl.setLoanAmount(pld.getLoanAmount());
			pl.setLoanTenure(pld.getLoanTenure());
			pl.setPaidAmount(pld.getPaidAmount());
			pl.setRemainingAmount(pld.getRemainingAmount());
			pl.setBankName(pld.getBankName());
			pl.setDefaulterCount(pld.getDefaulterCount());
			plrepo.save(pl);
		}
		else {
			throw new ExceptionById("No record found with this id");
		}
	}

	@Override
	public void deletePreviousoLoanDetails(int id) {
		// TODO Auto-generated method stub
		plrepo.deleteById(id);
	}

}
