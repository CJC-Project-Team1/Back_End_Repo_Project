package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.EMI;

public interface EMIserviceI {

	public EMI saveEMI(EMI em);

	public List<EMI> getAllEMI();
	
	public EMI getEMIById(int id);

	public EMI updateEMI(int id, EMI emi);

}
