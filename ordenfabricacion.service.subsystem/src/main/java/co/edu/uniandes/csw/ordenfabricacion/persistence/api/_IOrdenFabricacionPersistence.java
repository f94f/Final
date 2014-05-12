
package co.edu.uniandes.csw.ordenfabricacion.persistence.api;

import java.util.List; 

import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;

public interface _IOrdenFabricacionPersistence {

	public OrdenFabricacionDTO createOrdenFabricacion(OrdenFabricacionDTO detail);
	public List<OrdenFabricacionDTO> getOrdenFabricacions();
	public OrdenFabricacionDTO getOrdenFabricacion(Long id);
	public void deleteOrdenFabricacion(Long id);
	public void updateOrdenFabricacion(OrdenFabricacionDTO detail);
	
}