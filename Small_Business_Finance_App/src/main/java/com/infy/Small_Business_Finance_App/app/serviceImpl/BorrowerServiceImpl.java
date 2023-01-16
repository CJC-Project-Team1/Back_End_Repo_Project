package com.infy.Small_Business_Finance_App.app.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infy.Small_Business_Finance_App.app.model.AppliedLoan;
import com.infy.Small_Business_Finance_App.app.model.Borrower;
import com.infy.Small_Business_Finance_App.app.model.BorrowerBankDetails;
import com.infy.Small_Business_Finance_App.app.model.BorrowerDocuments;
import com.infy.Small_Business_Finance_App.app.model.BusinessDetails;
import com.infy.Small_Business_Finance_App.app.model.PreviousLoanDetails;
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
		Borrower borrower=new Borrower();
		borrower.setBorrowerName(b.getBorrowerName());
		borrower.setDateOfBirth(b.getDateOfBirth());
		borrower.setEmailId(b.getEmailId());
		borrower.setContactNo(b.getContactNo());
		borrower.setAdharNo(b.getAdharNo());
		borrower.setPanNo(b.getPanNo());
		borrower.setAddress(b.getAddress());
		borrower.setDocumentStatus(b.getDocumentStatus());
		borrower.setGstNo(b.getGstNo());
		
		BorrowerBankDetails bbd=new BorrowerBankDetails();
		bbd.setBankAccountNo(b.getBankDetails().getBankAccountNo());
		bbd.setIfscCode(b.getBankDetails().getIfscCode());
		bbd.setBankName(b.getBankDetails().getBankName());
		bbd.setBankBranch(b.getBankDetails().getBankBranch());
		borrower.setBankDetails(bbd);
//		
//		BusinessDetails bsd=new BusinessDetails();
//		bsd.setCompanyName(b.getBusinessDetails().getCompanyName());
//		bsd.setRevenue(b.getBusinessDetails().getRevenue());
//		bsd.setBusinesstype(b.getBusinessDetails().getBusinesstype());
//		borrower.setBusinessDetails(bsd);
//		
//		BorrowerDocuments bd=new BorrowerDocuments();
//		try
//		{
//			bd.setAdharCard(adhar.getBytes());
//			bd.setPanCard(pan.getBytes());
//			bd.setPhoto(photo.getBytes());
//			bd.setBankStatement(statement.getBytes());
//			bd.setAddressProof(address.getBytes());
//			bd.setBalanceSheet(balancesheet.getBytes());
//			bd.setGstCertificate(gst.getBytes());
//			bd.setProprietaryDeed(deed.getBytes());
//			borrower.setBorrowerDocuments(bd);
//		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		AppliedLoan apl=new AppliedLoan();
//		apl.setExpectedAmount(b.getAppliedLoan().getExpectedAmount());
//		apl.setLoanType(b.getAppliedLoan().getLoanType());
//		apl.setEmiCount(b.getAppliedLoan().getEmiCount());
//		apl.setTenure(b.getAppliedLoan().getTenure());
//		apl.setLoanStatus(b.getAppliedLoan().getLoanStatus());
//		apl.setRateOfInterest(b.getAppliedLoan().getRateOfInterest());
//		borrower.setAppliedLoan(apl);
//		
//		List<PreviousLoanDetails> list=new ArrayList<>();
//		list.forEach(ploan->{
//			ploan.setLoanType(b.getLoanHistory().forEach(loan->{loan.getLoanType();}));
//		});
		
		brepo.save(borrower);
	}

}
