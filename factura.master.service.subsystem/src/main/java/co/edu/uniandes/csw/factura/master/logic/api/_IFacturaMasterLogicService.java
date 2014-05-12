 
package co.edu.uniandes.csw.factura.master.logic.api;

import co.edu.uniandes.csw.factura.master.logic.dto.FacturaMasterDTO;

public interface _IFacturaMasterLogicService {

	public FacturaMasterDTO createMasterFactura(FacturaMasterDTO detail);
    public void updateMasterFactura(FacturaMasterDTO detail);
	public void deleteMasterFactura(Long id); 
	public FacturaMasterDTO getMasterFactura(Long id);
        
}