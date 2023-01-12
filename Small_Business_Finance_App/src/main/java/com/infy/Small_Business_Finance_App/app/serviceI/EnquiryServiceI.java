package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.Enquiry;

public interface EnquiryServiceI {

	public Enquiry saveEnquiry(Enquiry enq);

	public List<Enquiry> getAllEnquiry();

	public Enquiry getEnquiryById(int id);

	public Enquiry updateEnquiry(int id, Enquiry e);

}
