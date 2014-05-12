 
package co.edu.uniandes.csw.ordendespacho.master.logic.api;

import co.edu.uniandes.csw.ordendespacho.master.logic.dto.OrdenDespachoMasterDTO;

public interface _IOrdenDespachoMasterLogicService {

	public OrdenDespachoMasterDTO createMasterOrdenDespacho(OrdenDespachoMasterDTO detail);
    public void updateMasterOrdenDespacho(OrdenDespachoMasterDTO detail);
	public void deleteMasterOrdenDespacho(Long id); 
	public OrdenDespachoMasterDTO getMasterOrdenDespacho(Long id);
        
}