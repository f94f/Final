
package co.edu.uniandes.csw.ordendespacho.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.ordendespacho.persistence.entity.OrdenDespachoEntity;

public abstract class _OrdenDespachoConverter {


	public static OrdenDespachoDTO entity2PersistenceDTO(OrdenDespachoEntity entity){
		if (entity != null) {
			OrdenDespachoDTO dto = new OrdenDespachoDTO();
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
	
	public static OrdenDespachoEntity persistenceDTO2Entity(OrdenDespachoDTO dto){
		if(dto!=null){
			OrdenDespachoEntity entity=new OrdenDespachoEntity();
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
	
	public static List<OrdenDespachoDTO> entity2PersistenceDTOList(List<OrdenDespachoEntity> entities){
		List<OrdenDespachoDTO> dtos=new ArrayList<OrdenDespachoDTO>();
		for(OrdenDespachoEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<OrdenDespachoEntity> persistenceDTO2EntityList(List<OrdenDespachoDTO> dtos){
		List<OrdenDespachoEntity> entities=new ArrayList<OrdenDespachoEntity>();
		for(OrdenDespachoDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}