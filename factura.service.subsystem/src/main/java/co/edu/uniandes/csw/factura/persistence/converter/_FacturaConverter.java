
package co.edu.uniandes.csw.factura.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.factura.persistence.entity.FacturaEntity;

public abstract class _FacturaConverter {


	public static FacturaDTO entity2PersistenceDTO(FacturaEntity entity){
		if (entity != null) {
			FacturaDTO dto = new FacturaDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
			return dto;
		}else{
			return null;
		}
	}
	
	public static FacturaEntity persistenceDTO2Entity(FacturaDTO dto){
		if(dto!=null){
			FacturaEntity entity=new FacturaEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<FacturaDTO> entity2PersistenceDTOList(List<FacturaEntity> entities){
		List<FacturaDTO> dtos=new ArrayList<FacturaDTO>();
		for(FacturaEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<FacturaEntity> persistenceDTO2EntityList(List<FacturaDTO> dtos){
		List<FacturaEntity> entities=new ArrayList<FacturaEntity>();
		for(FacturaDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}