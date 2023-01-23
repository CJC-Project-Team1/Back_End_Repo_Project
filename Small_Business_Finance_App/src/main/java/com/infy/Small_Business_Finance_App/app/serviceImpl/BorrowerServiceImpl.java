package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.exception.ExceptionById;
import com.infy.Small_Business_Finance_App.app.model.Borrower;
import com.infy.Small_Business_Finance_App.app.repository.BorrowerRepository;
import com.infy.Small_Business_Finance_App.app.serviceI.BorrowerServiceI;
@Service
public class BorrowerServiceImpl implements BorrowerServiceI
{
	@Autowired
	BorrowerRepository brepo;

	@Override
	public void saveBorrower(Borrower b)
	{
		System.out.println(b.getBankDetails().getBankDetailsId());
		brepo.save(b);
	}

	@Override
	public List<Borrower> getBorrower() {
		// TODO Auto-generated method stub
		return brepo.findAll();
	}

	@Override
	public void updateBorrower(Borrower b) {
			brepo.save(b);
	}

	@Override
	public void deleteBorrower(int id) {
		// TODO Auto-generated method stub
		brepo.deleteById(id);
	}

	@Override
	public Borrower getBorrowerById(int id) {
		Optional<Borrower> ob = brepo.findById(id);
		if(ob.isPresent())
		{
			Borrower b = ob.get();
			return b;
		}
	else {
		throw new ExceptionById("Sorry!!NO Borrower is present with this id.");
	}
	}

}
