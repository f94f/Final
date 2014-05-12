
package co.edu.uniandes.csw.factura.logic.api;

import java.util.List; 

import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;

public interface _IFacturaLogicService {

	public FacturaDTO createFactura(FacturaDTO detail);
	public List<FacturaDTO> getFacturas();
	public FacturaDTO getFactura(Long id);
	public void deleteFactura(Long id);
	public void updateFactura(FacturaDTO detail);
	
}