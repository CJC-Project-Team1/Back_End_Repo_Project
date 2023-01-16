package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.infy.Small_Business_Finance_App.app.dto.BorrowerBankDetailsDto;
import com.infy.Small_Business_Finance_App.app.model.BorrowerBankDetails;

@Mapper
public interface BorrowerBankDetailsMapper
{
	BorrowerBankDetailsMapper INSTANCE=Mappers.getMapper(BorrowerBankDetailsMapper.class);
	public BorrowerBankDetails dtoToBorrowerBankDetails(BorrowerBankDetailsDto bdto);
	public BorrowerBankDetailsDto borrowerBankDetailsToDto(BorrowerBankDetails bbd);
	public List<BorrowerBankDetails> dtosToBorrowerBankDetails(List<BorrowerBankDetailsDto> bdtos);
	public List<BorrowerBankDetailsDto> borrowerBankDetailsToDtos(List<BorrowerBankDetails> bbds);
}
