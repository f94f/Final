 
package co.edu.uniandes.csw.ordenfabricacion.master.logic.api;

import co.edu.uniandes.csw.ordenfabricacion.master.logic.dto.OrdenFabricacionMasterDTO;

public interface _IOrdenFabricacionMasterLogicService {

	public OrdenFabricacionMasterDTO createMasterOrdenFabricacion(OrdenFabricacionMasterDTO detail);
    public void updateMasterOrdenFabricacion(OrdenFabricacionMasterDTO detail);
	public void deleteMasterOrdenFabricacion(Long id); 
	public OrdenFabricacionMasterDTO getMasterOrdenFabricacion(Long id);
        
}