package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.infy.Small_Business_Finance_App.app.dto.PreviousLoanDetailsDto;
import com.infy.Small_Business_Finance_App.app.model.PreviousLoanDetails;

@Mapper
public interface PreviousoLoanDetailsMapper 
{
	PreviousoLoanDetailsMapper INSTANCE=Mappers.getMapper(PreviousoLoanDetailsMapper.class);
	public PreviousLoanDetails dtoToPreviousoLoanDetails(PreviousLoanDetailsDto pdto);
	public PreviousLoanDetailsDto previousoLoanDetailsToDto(PreviousLoanDetails ploan);
	public List<PreviousLoanDetails> dtosToPreviousoLoanDetails(List<PreviousLoanDetailsDto> pdtos);
	public List<PreviousLoanDetailsDto> previousoLoanDetailsToDtos(List<PreviousLoanDetails> pdtos);
}
