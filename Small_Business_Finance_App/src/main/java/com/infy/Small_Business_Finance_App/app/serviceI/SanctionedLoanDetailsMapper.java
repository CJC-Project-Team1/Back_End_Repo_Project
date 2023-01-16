package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.infy.Small_Business_Finance_App.app.dto.SanctionedLoanDetailsDto;
import com.infy.Small_Business_Finance_App.app.model.SanctionedLoanDetails ;

@Mapper
public interface SanctionedLoanDetailsMapper 
{
	SanctionedLoanDetailsMapper INSTANCE=Mappers.getMapper(SanctionedLoanDetailsMapper.class);
	public SanctionedLoanDetails  dtoToEntity (SanctionedLoanDetailsDto sLoanDto);
	public SanctionedLoanDetailsDto entityToDto(SanctionedLoanDetails  sLoan );
	public List<SanctionedLoanDetails> dtosToEntities(List<SanctionedLoanDetailsDto> sLoanDtoList);
	public List<SanctionedLoanDetailsDto> entitiesToDtos(List<SanctionedLoanDetails> sLoanList);
	
}
