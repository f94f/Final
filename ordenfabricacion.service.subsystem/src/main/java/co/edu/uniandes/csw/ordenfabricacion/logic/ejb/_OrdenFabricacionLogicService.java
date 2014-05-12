
package co.edu.uniandes.csw.ordenfabricacion.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordenfabricacion.logic.api._IOrdenFabricacionLogicService;
import co.edu.uniandes.csw.ordenfabricacion.persistence.api.IOrdenFabricacionPersistence;

public abstract class _OrdenFabricacionLogicService implements _IOrdenFabricacionLogicService {

	@Inject
	protected IOrdenFabricacionPersistence persistance;

	public OrdenFabricacionDTO createOrdenFabricacion(OrdenFabricacionDTO ordenFabricacion){
		return persistance.createOrdenFabricacion( ordenFabricacion); 
    }

	public List<OrdenFabricacionDTO> getOrdenFabricacions(){
		return persistance.getOrdenFabricacions(); 
	}

	public OrdenFabricacionDTO getOrdenFabricacion(Long id){
		return persistance.getOrdenFabricacion(id); 
	}

	public void deleteOrdenFabricacion(Long id){
	    persistance.deleteOrdenFabricacion(id); 
	}

	public void updateOrdenFabricacion(OrdenFabricacionDTO ordenFabricacion){
	    persistance.updateOrdenFabricacion(ordenFabricacion); 
	}	
}