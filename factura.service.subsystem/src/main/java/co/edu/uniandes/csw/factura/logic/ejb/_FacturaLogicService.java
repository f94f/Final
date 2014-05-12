
package co.edu.uniandes.csw.factura.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.factura.logic.api._IFacturaLogicService;
import co.edu.uniandes.csw.factura.persistence.api.IFacturaPersistence;

public abstract class _FacturaLogicService implements _IFacturaLogicService {

	@Inject
	protected IFacturaPersistence persistance;

	public FacturaDTO createFactura(FacturaDTO factura){
		return persistance.createFactura( factura); 
    }

	public List<FacturaDTO> getFacturas(){
		return persistance.getFacturas(); 
	}

	public FacturaDTO getFactura(Long id){
		return persistance.getFactura(id); 
	}

	public void deleteFactura(Long id){
	    persistance.deleteFactura(id); 
	}

	public void updateFactura(FacturaDTO factura){
	    persistance.updateFactura(factura); 
	}	
}