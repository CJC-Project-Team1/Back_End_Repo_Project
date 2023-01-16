package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Small_Business_Finance_App.app.exception.ExceptionById;
import com.infy.Small_Business_Finance_App.app.model.BorrowerDocuments;
import com.infy.Small_Business_Finance_App.app.repository.BorrowerDocumentsRepository;
import com.infy.Small_Business_Finance_App.app.serviceI.BorrowerDocumentsServiceI;

@Service
public class BorrowerDocumentsServiceImpl implements BorrowerDocumentsServiceI
{
	@Autowired
	BorrowerDocumentsRepository bdrepo;

	@Override
	public void saveBorrowerDocuments(BorrowerDocuments bd) {
		// TODO Auto-generated method stub
		bdrepo.save(bd);
	}

	@Override
	public List<BorrowerDocuments> getBorrowerDocuments() {
		// TODO Auto-generated method stub
		return bdrepo.findAll();
	}

	@Override
	public void updateBorrowerDocuments(BorrowerDocuments bd, int id) throws ExceptionById{
		// TODO Auto-generated method stub
		Optional<BorrowerDocuments> ob=bdrepo.findById(id);
		if(ob.isPresent())
		{
			BorrowerDocuments b=ob.get();
			b.setAdharCard(bd.getAdharCard());
			b.setPanCard(bd.getPanCard());
			b.setPhoto(bd.getPhoto());
			b.setBankStatement(bd.getBankStatement());
			b.setBalanceSheet(bd.getBalanceSheet());
			b.setAddressProof(bd.getAddressProof());
			b.setGstCertificate(bd.getGstCertificate());
			b.setProprietaryDeed(bd.getProprietaryDeed());
			bdrepo.save(b);
		}
		else {
			throw new ExceptionById("No Record found with this id");
		}
	}

	@Override
	public void deleteBorrowerDocuments(int id) {
		// TODO Auto-generated method stub
		bdrepo.deleteById(id);
	}

}
