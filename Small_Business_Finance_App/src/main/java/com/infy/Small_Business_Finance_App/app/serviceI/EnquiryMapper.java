package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.infy.Small_Business_Finance_App.app.dto.EnquiryDto;
import com.infy.Small_Business_Finance_App.app.model.Enquiry;


@Mapper
public interface EnquiryMapper {
	
	EnquiryMapper INSTANCE=Mappers.getMapper(EnquiryMapper.class);
	public Enquiry dtoToEnquiry(EnquiryDto edto);
	public EnquiryDto enquiryToDto(Enquiry enq);
	public List<Enquiry> dtosToEnquiries(List<EnquiryDto> edtos);
	public List<EnquiryDto> enquiriesToDtos(List<Enquiry> enqs);
	

}
