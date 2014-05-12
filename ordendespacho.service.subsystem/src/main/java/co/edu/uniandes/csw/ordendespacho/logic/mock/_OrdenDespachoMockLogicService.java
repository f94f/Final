
package co.edu.uniandes.csw.ordendespacho.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.ordendespacho.logic.api._IOrdenDespachoLogicService;

public abstract class _OrdenDespachoMockLogicService implements _IOrdenDespachoLogicService {

	private Long id= new Long(1);
	protected List<OrdenDespachoDTO> data=new ArrayList<OrdenDespachoDTO>();

	public OrdenDespachoDTO createOrdenDespacho(OrdenDespachoDTO ordenDespacho){
		id++;
		ordenDespacho.setId(id);
		return ordenDespacho;
    }

	public List<OrdenDespachoDTO> getOrdenDespachos(){
		return data; 
	}

	public OrdenDespachoDTO getOrdenDespacho(Long id){
		for(OrdenDespachoDTO data1:data){
			if(data1.getId().equals(id)){
				return data1;
			}
		}
		return null;
	}

	public void deleteOrdenDespacho(Long id){
	    OrdenDespachoDTO delete=null;
		for(OrdenDespachoDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updateOrdenDespacho(OrdenDespachoDTO ordenDespacho){
	    OrdenDespachoDTO delete=null;
		for(OrdenDespachoDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(ordenDespacho);
		} 
	}	
}