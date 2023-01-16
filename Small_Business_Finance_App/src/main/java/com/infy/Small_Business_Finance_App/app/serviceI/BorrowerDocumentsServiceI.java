package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.BorrowerDocuments;

public interface BorrowerDocumentsServiceI {

	public void saveBorrowerDocuments(BorrowerDocuments bd);

	public List<BorrowerDocuments> getBorrowerDocuments();

	public void updateBorrowerDocuments(BorrowerDocuments bd, int id);

	public void deleteBorrowerDocuments(int id);

}
