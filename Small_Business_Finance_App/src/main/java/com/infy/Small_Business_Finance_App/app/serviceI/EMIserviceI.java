package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import com.infy.Small_Business_Finance_App.app.model.EMI;

public interface EMIserviceI {

	public EMI saveEMI(EMI emi);

	public EMI updateEMI(EMI emi, int id);

	public List<EMI> getAll();

	public List<EMI> getEmiByStatus(String status);

	public List<EMI> getEmiByDeaulter(Integer def);

}
