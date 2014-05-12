
package co.edu.uniandes.csw.ordenreaprovicionamiento.logic.api;

import java.util.List; 

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;

public interface _IOrdenReaprovicionamientoLogicService {

	public OrdenReaprovicionamientoDTO createOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO detail);
	public List<OrdenReaprovicionamientoDTO> getOrdenReaprovicionamientos();
	public OrdenReaprovicionamientoDTO getOrdenReaprovicionamiento(Long id);
	public void deleteOrdenReaprovicionamiento(Long id);
	public void updateOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO detail);
	
}