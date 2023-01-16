package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.infy.Small_Business_Finance_App.app.dto.BorrowerDocumentsDto;
import com.infy.Small_Business_Finance_App.app.model.BorrowerDocuments;

@Mapper
public interface BorrowerDocumentsMapper
{
	BorrowerDocumentsMapper INSTANCE=Mappers.getMapper(BorrowerDocumentsMapper.class);
	public BorrowerDocuments dtoToBorrowerDocuments(BorrowerDocumentsDto dto);
	public BorrowerDocumentsDto borrowerDocumentsToDto(BorrowerDocuments bd);
	public List<BorrowerDocuments> dtosToBorrowerDocuments(List<BorrowerDocumentsDto> dtos);
	public List<BorrowerDocumentsDto> borrowerDocumentsToDtos(List<BorrowerDocuments> dtos);
}
