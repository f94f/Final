
package co.edu.uniandes.csw.inventario.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.inventario.logic.dto.InventarioDTO;
import co.edu.uniandes.csw.inventario.logic.api._IInventarioLogicService;
import co.edu.uniandes.csw.inventario.persistence.api.IInventarioPersistence;

public abstract class _InventarioLogicService implements _IInventarioLogicService {

	@Inject
	protected IInventarioPersistence persistance;

	public InventarioDTO createInventario(InventarioDTO inventario){
		return persistance.createInventario( inventario); 
    }

	public List<InventarioDTO> getInventarios(){
		return persistance.getInventarios(); 
	}

	public InventarioDTO getInventario(Long id){
		return persistance.getInventario(id); 
	}

	public void deleteInventario(Long id){
	    persistance.deleteInventario(id); 
	}

	public void updateInventario(InventarioDTO inventario){
	    persistance.updateInventario(inventario); 
	}	
}