 
package co.edu.uniandes.csw.ordenreaprovicionamiento.master.logic.api;

import co.edu.uniandes.csw.ordenreaprovicionamiento.master.logic.dto.OrdenReaprovicionamientoMasterDTO;

public interface _IOrdenReaprovicionamientoMasterLogicService {

	public OrdenReaprovicionamientoMasterDTO createMasterOrdenReaprovicionamiento(OrdenReaprovicionamientoMasterDTO detail);
    public void updateMasterOrdenReaprovicionamiento(OrdenReaprovicionamientoMasterDTO detail);
	public void deleteMasterOrdenReaprovicionamiento(Long id); 
	public OrdenReaprovicionamientoMasterDTO getMasterOrdenReaprovicionamiento(Long id);
        
}