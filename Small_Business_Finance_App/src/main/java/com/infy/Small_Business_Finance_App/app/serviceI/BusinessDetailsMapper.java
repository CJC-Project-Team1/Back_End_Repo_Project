package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.infy.Small_Business_Finance_App.app.dto.BusinessDetailsDto;
import com.infy.Small_Business_Finance_App.app.model.BusinessDetails;

@Mapper
public interface BusinessDetailsMapper 
{
	BusinessDetailsMapper INSTANCE=Mappers.getMapper(BusinessDetailsMapper.class);
	public BusinessDetails dtoToBusinessDetails(BusinessDetailsDto dto);
	public BusinessDetailsDto businessDetailsDto(BusinessDetails bd);
	public List<BusinessDetails> dtosToBusinessDetails(List<BusinessDetailsDto> dtos);
	public List<BusinessDetailsDto> businessDetailsDtos(List<BusinessDetails> bds);
}
