package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.BusinessDetails;

public interface BusinessDetailsServiceI {

	public void saveBusinessDetails(BusinessDetails bd);

	public List<BusinessDetails> getBusinessDetails();

	public void updateBusinessDetails(BusinessDetails bd, int id);

	public void deleteBusinessDetails(int id);

}
