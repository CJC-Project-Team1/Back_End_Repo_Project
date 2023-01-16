package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.exception.ExceptionById;
import com.infy.Small_Business_Finance_App.app.model.AppliedLoan;
import com.infy.Small_Business_Finance_App.app.repository.AppliedLoanRepository;
import com.infy.Small_Business_Finance_App.app.serviceI.AppliedLoanServiceI;
@Service
public class AppliedLoanServiceImpl implements AppliedLoanServiceI
{
	@Autowired
	AppliedLoanRepository ar;

	@Override
	public void saveAppliedLoan(AppliedLoan al) {
		// TODO Auto-generated method stub
		ar.save(al);
	}

	@Override
	public List<AppliedLoan> getAppliedLoan() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public void updateAppliedLoan(AppliedLoan al, int id) throws ExceptionById {
		// TODO Auto-generated method stub
		Optional<AppliedLoan> oa=ar.findById(id);
		if(oa.isPresent())
		{
			AppliedLoan a=oa.get();
			a.setExpectedAmount(al.getExpectedAmount());
			a.setLoanType(al.getLoanType());
			a.setEmiCount(al.getEmiCount());
			a.setTenure(al.getTenure());
			a.setLoanStatus(al.getLoanStatus());
			a.setRateOfInterest(al.getRateOfInterest());
			ar.save(a);
		}
		else {
			throw new ExceptionById("No record found with this id");
		}
	}

	@Override
	public void deleteAppliedLoan(int id) {
		// TODO Auto-generated method stub
		ar.deleteById(id);
	}

}
