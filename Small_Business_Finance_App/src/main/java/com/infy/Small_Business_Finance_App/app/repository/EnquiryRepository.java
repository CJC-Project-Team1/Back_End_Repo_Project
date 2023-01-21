package com.infy.Small_Business_Finance_App.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.Small_Business_Finance_App.app.model.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>
{
	public List<Enquiry> findByEnquiryStatus(String status);

	public Optional<Enquiry> findByPanCard(String panCard);
}
