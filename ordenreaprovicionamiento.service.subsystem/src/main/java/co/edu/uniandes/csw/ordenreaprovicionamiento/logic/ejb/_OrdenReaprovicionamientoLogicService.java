
package co.edu.uniandes.csw.ordenreaprovicionamiento.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.api._IOrdenReaprovicionamientoLogicService;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.api.IOrdenReaprovicionamientoPersistence;

public abstract class _OrdenReaprovicionamientoLogicService implements _IOrdenReaprovicionamientoLogicService {

	@Inject
	protected IOrdenReaprovicionamientoPersistence persistance;

	public OrdenReaprovicionamientoDTO createOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO ordenReaprovicionamiento){
		return persistance.createOrdenReaprovicionamiento( ordenReaprovicionamiento); 
    }

	public List<OrdenReaprovicionamientoDTO> getOrdenReaprovicionamientos(){
		return persistance.getOrdenReaprovicionamientos(); 
	}

	public OrdenReaprovicionamientoDTO getOrdenReaprovicionamiento(Long id){
		return persistance.getOrdenReaprovicionamiento(id); 
	}

	public void deleteOrdenReaprovicionamiento(Long id){
	    persistance.deleteOrdenReaprovicionamiento(id); 
	}

	public void updateOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO ordenReaprovicionamiento){
	    persistance.updateOrdenReaprovicionamiento(ordenReaprovicionamiento); 
	}	
}