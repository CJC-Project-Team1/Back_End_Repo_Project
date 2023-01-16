package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.SanctionedLoanDetails;

public interface SanctionedLoanDetailsServiceI {

	public SanctionedLoanDetails saveSanLoanDetails(SanctionedLoanDetails sLoan);

	public List<SanctionedLoanDetails> getAllSanLoanDetails();
	
	public SanctionedLoanDetails getSanLoanDetailsById(int id);

	public SanctionedLoanDetails updateSanLoanDetails(int id, SanctionedLoanDetails sLoan);

}
