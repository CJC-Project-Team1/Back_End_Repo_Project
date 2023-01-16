package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.AppliedLoan;

public interface AppliedLoanServiceI {

	public void saveAppliedLoan(AppliedLoan al);

	public List<AppliedLoan> getAppliedLoan();

	public void updateAppliedLoan(AppliedLoan al, int id);

	public void deleteAppliedLoan(int id);

}
