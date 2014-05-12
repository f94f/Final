
package co.edu.uniandes.csw.ordenfabricacion.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordenfabricacion.logic.api._IOrdenFabricacionLogicService;

public abstract class _OrdenFabricacionMockLogicService implements _IOrdenFabricacionLogicService {

	private Long id= new Long(1);
	protected List<OrdenFabricacionDTO> data=new ArrayList<OrdenFabricacionDTO>();

	public OrdenFabricacionDTO createOrdenFabricacion(OrdenFabricacionDTO ordenFabricacion){
		id++;
		ordenFabricacion.setId(id);
		return ordenFabricacion;
    }

	public List<OrdenFabricacionDTO> getOrdenFabricacions(){
		return data; 
	}

	public OrdenFabricacionDTO getOrdenFabricacion(Long id){
		for(OrdenFabricacionDTO data1:data){
			if(data1.getId().equals(id)){
				return data1;
			}
		}
		return null;
	}

	public void deleteOrdenFabricacion(Long id){
	    OrdenFabricacionDTO delete=null;
		for(OrdenFabricacionDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updateOrdenFabricacion(OrdenFabricacionDTO ordenFabricacion){
	    OrdenFabricacionDTO delete=null;
		for(OrdenFabricacionDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(ordenFabricacion);
		} 
	}	
}