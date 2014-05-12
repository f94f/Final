
package co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.entity.OrdenReaprovicionamientoEntity;

public abstract class _OrdenReaprovicionamientoConverter {


	public static OrdenReaprovicionamientoDTO entity2PersistenceDTO(OrdenReaprovicionamientoEntity entity){
		if (entity != null) {
			OrdenReaprovicionamientoDTO dto = new OrdenReaprovicionamientoDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setFecha(entity.getFecha());
				dto.setCantidad(entity.getCantidad());
			return dto;
		}else{
			return null;
		}
	}
	
	public static OrdenReaprovicionamientoEntity persistenceDTO2Entity(OrdenReaprovicionamientoDTO dto){
		if(dto!=null){
			OrdenReaprovicionamientoEntity entity=new OrdenReaprovicionamientoEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setFecha(dto.getFecha());
			entity.setCantidad(dto.getCantidad());
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<OrdenReaprovicionamientoDTO> entity2PersistenceDTOList(List<OrdenReaprovicionamientoEntity> entities){
		List<OrdenReaprovicionamientoDTO> dtos=new ArrayList<OrdenReaprovicionamientoDTO>();
		for(OrdenReaprovicionamientoEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<OrdenReaprovicionamientoEntity> persistenceDTO2EntityList(List<OrdenReaprovicionamientoDTO> dtos){
		List<OrdenReaprovicionamientoEntity> entities=new ArrayList<OrdenReaprovicionamientoEntity>();
		for(OrdenReaprovicionamientoDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}