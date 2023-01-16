package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.infy.Small_Business_Finance_App.app.dto.AppliedLoanDto;
import com.infy.Small_Business_Finance_App.app.model.AppliedLoan;

@Mapper
public interface AppliedLoanMapper
{
	AppliedLoanMapper INSTANCE=Mappers.getMapper(AppliedLoanMapper.class);
	public AppliedLoan dtoToAppliedLoan(AppliedLoanDto adto);
	public AppliedLoanDto appliedLoanToDto(AppliedLoan al);
	public List<AppliedLoan> dtosToAppliedLoans(List<AppliedLoanDto> adtos);
	public List<AppliedLoanDto> appliedLoansToDtos(List<AppliedLoan> als);
}
