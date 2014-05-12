
package co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.api;

import java.util.List; 

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;

public interface _IOrdenReaprovicionamientoPersistence {

	public OrdenReaprovicionamientoDTO createOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO detail);
	public List<OrdenReaprovicionamientoDTO> getOrdenReaprovicionamientos();
	public OrdenReaprovicionamientoDTO getOrdenReaprovicionamiento(Long id);
	public void deleteOrdenReaprovicionamiento(Long id);
	public void updateOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO detail);
	
}