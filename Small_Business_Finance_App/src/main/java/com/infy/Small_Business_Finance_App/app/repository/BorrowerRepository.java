package com.infy.Small_Business_Finance_App.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.Small_Business_Finance_App.app.model.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer>{

	public List<Borrower> findByDocumentStatus(String status);
}
