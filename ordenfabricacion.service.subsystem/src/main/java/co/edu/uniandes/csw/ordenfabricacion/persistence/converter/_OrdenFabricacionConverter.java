
package co.edu.uniandes.csw.ordenfabricacion.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordenfabricacion.persistence.entity.OrdenFabricacionEntity;

public abstract class _OrdenFabricacionConverter {


	public static OrdenFabricacionDTO entity2PersistenceDTO(OrdenFabricacionEntity entity){
		if (entity != null) {
			OrdenFabricacionDTO dto = new OrdenFabricacionDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setFecha(entity.getFecha());
				dto.setCantidad(entity.getCantidad());
				dto.setEstado(entity.getEstado());
			return dto;
		}else{
			return null;
		}
	}
	
	public static OrdenFabricacionEntity persistenceDTO2Entity(OrdenFabricacionDTO dto){
		if(dto!=null){
			OrdenFabricacionEntity entity=new OrdenFabricacionEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setFecha(dto.getFecha());
			entity.setCantidad(dto.getCantidad());
			entity.setEstado(dto.getEstado());
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<OrdenFabricacionDTO> entity2PersistenceDTOList(List<OrdenFabricacionEntity> entities){
		List<OrdenFabricacionDTO> dtos=new ArrayList<OrdenFabricacionDTO>();
		for(OrdenFabricacionEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<OrdenFabricacionEntity> persistenceDTO2EntityList(List<OrdenFabricacionDTO> dtos){
		List<OrdenFabricacionEntity> entities=new ArrayList<OrdenFabricacionEntity>();
		for(OrdenFabricacionDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}