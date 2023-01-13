package com.infy.Small_Business_Finance_App.app.serviceI;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.infy.Small_Business_Finance_App.app.dto.EMIdto;
import com.infy.Small_Business_Finance_App.app.model.EMI;

@Mapper
public interface EMImapper 
{
	EMImapper INSTANCE=Mappers.getMapper(EMImapper.class);
	public EMI dtoToEmi(EMIdto emidto);
	public EMIdto emiToDto(EMI emi);
	public List<EMI> dtosToEmis(List<EMIdto> emidtoList);
	public List<EMIdto> emisToDtos(List<EMI> emiList);
	
}
