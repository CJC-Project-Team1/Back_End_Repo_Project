package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		System.out.println("*******************");
		System.out.println(b.getBankDetails().getBankDetailsId());
		System.out.println("*******************");
		brepo.save(b);
	}

	@Override
	public List<Borrower> getBorrower() {
		// TODO Auto-generated method stub
		return brepo.findAll();
	}

	@Override
	public void updateBorrower(Borrower b, int id) {
		// TODO Auto-generated method stub
		Optional<Borrower> ob=brepo.findById(id);
		if(ob.isPresent())
		{
			brepo.save(b);
		}
	}

	@Override
	public void deleteBorrower(int id) {
		// TODO Auto-generated method stub
		brepo.deleteById(id);
	}

}
