package com.infy.Small_Business_Finance_App.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.Small_Business_Finance_App.app.model.EMI;

@Repository
public interface EMIrepository extends JpaRepository<EMI, Integer>
{
	public List<EMI> findByEmiStatus(String emiStatus);
	public List<EMI>  findByDefautlerCount(Integer def);
}
