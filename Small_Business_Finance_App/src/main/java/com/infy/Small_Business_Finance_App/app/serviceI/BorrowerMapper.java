package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.infy.Small_Business_Finance_App.app.dto.BorrowerDto;
import com.infy.Small_Business_Finance_App.app.model.Borrower;

@Mapper
public interface BorrowerMapper
{
	BorrowerMapper INSTANCE=Mappers.getMapper(BorrowerMapper.class);
	public Borrower dtoToBorrower(BorrowerDto bdto);
	public BorrowerDto borrowerToDto(Borrower borrower);
	public List<Borrower> dtosToBorrowers(List<BorrowerDto> bdtos);
	public List<BorrowerDto> borrowersToDtos(List<Borrower> borrowers);
}
