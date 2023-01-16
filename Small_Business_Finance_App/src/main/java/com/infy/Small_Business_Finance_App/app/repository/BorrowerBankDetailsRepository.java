package com.infy.Small_Business_Finance_App.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.Small_Business_Finance_App.app.model.BorrowerBankDetails;

@Repository
public interface BorrowerBankDetailsRepository extends JpaRepository<BorrowerBankDetails, Integer>
{

}
