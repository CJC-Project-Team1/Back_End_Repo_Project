package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.infy.Small_Business_Finance_App.app.model.Borrower;

public interface BorrowerServiceI {

	public void saveBorrower(Borrower b);

	public List<Borrower> getBorrower();

	public void updateBorrower(Borrower b);

	public void deleteBorrower(int id);

	public Borrower getBorrowerById(int id);

}
