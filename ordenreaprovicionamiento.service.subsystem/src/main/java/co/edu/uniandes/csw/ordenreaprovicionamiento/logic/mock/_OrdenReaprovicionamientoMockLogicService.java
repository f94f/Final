
package co.edu.uniandes.csw.ordenreaprovicionamiento.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.api._IOrdenReaprovicionamientoLogicService;

public abstract class _OrdenReaprovicionamientoMockLogicService implements _IOrdenReaprovicionamientoLogicService {

	private Long id= new Long(1);
	protected List<OrdenReaprovicionamientoDTO> data=new ArrayList<OrdenReaprovicionamientoDTO>();

	public OrdenReaprovicionamientoDTO createOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO ordenReaprovicionamiento){
		id++;
		ordenReaprovicionamiento.setId(id);
		return ordenReaprovicionamiento;
    }

	public List<OrdenReaprovicionamientoDTO> getOrdenReaprovicionamientos(){
		return data; 
	}

	public OrdenReaprovicionamientoDTO getOrdenReaprovicionamiento(Long id){
		for(OrdenReaprovicionamientoDTO data1:data){
			if(data1.getId().equals(id)){
				return data1;
			}
		}
		return null;
	}

	public void deleteOrdenReaprovicionamiento(Long id){
	    OrdenReaprovicionamientoDTO delete=null;
		for(OrdenReaprovicionamientoDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updateOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO ordenReaprovicionamiento){
	    OrdenReaprovicionamientoDTO delete=null;
		for(OrdenReaprovicionamientoDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(ordenReaprovicionamiento);
		} 
	}	
}