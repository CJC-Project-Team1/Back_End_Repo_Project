package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.BorrowerBankDetails;

public interface BorrowerBankDetailsServiceI {

	public void saveBankDetails(BorrowerBankDetails bd);

	public List<BorrowerBankDetails> getBankDetails();

	public void updateBankDetails(BorrowerBankDetails bd, int id);

	public void deleteBankDetails(int id);

}
