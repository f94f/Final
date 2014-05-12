
package co.edu.uniandes.csw.ordendespacho.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.ordendespacho.logic.api._IOrdenDespachoLogicService;
import co.edu.uniandes.csw.ordendespacho.persistence.api.IOrdenDespachoPersistence;

public abstract class _OrdenDespachoLogicService implements _IOrdenDespachoLogicService {

	@Inject
	protected IOrdenDespachoPersistence persistance;

	public OrdenDespachoDTO createOrdenDespacho(OrdenDespachoDTO ordenDespacho){
		return persistance.createOrdenDespacho( ordenDespacho); 
    }

	public List<OrdenDespachoDTO> getOrdenDespachos(){
		return persistance.getOrdenDespachos(); 
	}

	public OrdenDespachoDTO getOrdenDespacho(Long id){
		return persistance.getOrdenDespacho(id); 
	}

	public void deleteOrdenDespacho(Long id){
	    persistance.deleteOrdenDespacho(id); 
	}

	public void updateOrdenDespacho(OrdenDespachoDTO ordenDespacho){
	    persistance.updateOrdenDespacho(ordenDespacho); 
	}	
}