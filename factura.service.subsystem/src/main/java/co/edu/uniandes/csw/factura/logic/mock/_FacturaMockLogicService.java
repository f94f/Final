
package co.edu.uniandes.csw.factura.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.factura.logic.api._IFacturaLogicService;

public abstract class _FacturaMockLogicService implements _IFacturaLogicService {

	private Long id= new Long(1);
	protected List<FacturaDTO> data=new ArrayList<FacturaDTO>();

	public FacturaDTO createFactura(FacturaDTO factura){
		id++;
		factura.setId(id);
		return factura;
    }

	public List<FacturaDTO> getFacturas(){
		return data; 
	}

	public FacturaDTO getFactura(Long id){
		for(FacturaDTO data1:data){
			if(data1.getId().equals(id)){
				return data1;
			}
		}
		return null;
	}

	public void deleteFactura(Long id){
	    FacturaDTO delete=null;
		for(FacturaDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updateFactura(FacturaDTO factura){
	    FacturaDTO delete=null;
		for(FacturaDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(factura);
		} 
	}	
}