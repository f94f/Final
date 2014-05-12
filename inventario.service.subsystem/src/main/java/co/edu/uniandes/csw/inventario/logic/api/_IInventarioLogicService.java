
package co.edu.uniandes.csw.inventario.logic.api;

import java.util.List; 

import co.edu.uniandes.csw.inventario.logic.dto.InventarioDTO;

public interface _IInventarioLogicService {

	public InventarioDTO createInventario(InventarioDTO detail);
	public List<InventarioDTO> getInventarios();
	public InventarioDTO getInventario(Long id);
	public void deleteInventario(Long id);
	public void updateInventario(InventarioDTO detail);
	
}