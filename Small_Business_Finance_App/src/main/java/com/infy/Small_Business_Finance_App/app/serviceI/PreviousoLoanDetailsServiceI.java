package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.PreviousLoanDetails;

public interface PreviousoLoanDetailsServiceI {

	public void savePreviousoLoanDetails(PreviousLoanDetails pld);

	public List<PreviousLoanDetails> getPreviousoLoanDetails();

	public void updatePreviousoLoanDetails(PreviousLoanDetails pld, int id);

	public void deletePreviousoLoanDetails(int id);

}
