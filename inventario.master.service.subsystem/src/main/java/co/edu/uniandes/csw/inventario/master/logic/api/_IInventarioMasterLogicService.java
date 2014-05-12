 
package co.edu.uniandes.csw.inventario.master.logic.api;

import co.edu.uniandes.csw.inventario.master.logic.dto.InventarioMasterDTO;

public interface _IInventarioMasterLogicService {

	public InventarioMasterDTO createMasterInventario(InventarioMasterDTO detail);
    public void updateMasterInventario(InventarioMasterDTO detail);
	public void deleteMasterInventario(Long id); 
	public InventarioMasterDTO getMasterInventario(Long id);
        
}