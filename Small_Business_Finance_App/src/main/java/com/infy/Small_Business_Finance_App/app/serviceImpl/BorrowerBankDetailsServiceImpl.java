package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.exception.ExceptionById;
import com.infy.Small_Business_Finance_App.app.model.BorrowerBankDetails;
import com.infy.Small_Business_Finance_App.app.repository.BorrowerBankDetailsRepository;
import com.infy.Small_Business_Finance_App.app.serviceI.BorrowerBankDetailsServiceI;
@Service
public class BorrowerBankDetailsServiceImpl implements BorrowerBankDetailsServiceI
{
	@Autowired
	BorrowerBankDetailsRepository bdrepo;

	@Override
	public void saveBankDetails(BorrowerBankDetails bd) {
		// TODO Auto-generated method stub
		bdrepo.save(bd);
	}

	@Override
	public List<BorrowerBankDetails> getBankDetails() {
		// TODO Auto-generated method stub
		return bdrepo.findAll();
	}

	@Override
	public void updateBankDetails(BorrowerBankDetails bd, int id) throws ExceptionById {
		// TODO Auto-generated method stub
		Optional<BorrowerBankDetails> bbd=bdrepo.findById(id);
		if(bbd.isPresent())
		{
			BorrowerBankDetails b=bbd.get();
			b.setBankAccountNo(bd.getBankAccountNo());
			b.setIfscCode(bd.getIfscCode());
			b.setBankName(bd.getBankName());
			b.setBankBranch(bd.getBankBranch());
			bdrepo.save(b);
		}
		else
		{
			throw new ExceptionById("No details found with this id");
		}
	}

	@Override
	public void deleteBankDetails(int id) {
		// TODO Auto-generated method stub
		bdrepo.deleteById(id);
	}

}
