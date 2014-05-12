
package co.edu.uniandes.csw.inventario.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.inventario.logic.dto.InventarioDTO;
import co.edu.uniandes.csw.inventario.persistence.entity.InventarioEntity;

public abstract class _InventarioConverter {


	public static InventarioDTO entity2PersistenceDTO(InventarioEntity entity){
		if (entity != null) {
			InventarioDTO dto = new InventarioDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
			return dto;
		}else{
			return null;
		}
	}
	
	public static InventarioEntity persistenceDTO2Entity(InventarioDTO dto){
		if(dto!=null){
			InventarioEntity entity=new InventarioEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<InventarioDTO> entity2PersistenceDTOList(List<InventarioEntity> entities){
		List<InventarioDTO> dtos=new ArrayList<InventarioDTO>();
		for(InventarioEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<InventarioEntity> persistenceDTO2EntityList(List<InventarioDTO> dtos){
		List<InventarioEntity> entities=new ArrayList<InventarioEntity>();
		for(InventarioDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}