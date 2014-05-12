
package co.edu.uniandes.csw.ordendespacho.persistence.api;

import java.util.List; 

import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;

public interface _IOrdenDespachoPersistence {

	public OrdenDespachoDTO createOrdenDespacho(OrdenDespachoDTO detail);
	public List<OrdenDespachoDTO> getOrdenDespachos();
	public OrdenDespachoDTO getOrdenDespacho(Long id);
	public void deleteOrdenDespacho(Long id);
	public void updateOrdenDespacho(OrdenDespachoDTO detail);
	
}