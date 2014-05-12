package co.edu.uniandes.csw.inventario.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.inventario.logic.api.IInventarioLogicService;
import co.edu.uniandes.csw.inventario.logic.dto.InventarioDTO;


public abstract class _InventarioService {

	@Inject
	protected IInventarioLogicService inventarioLogicService;
	
	@POST
	public InventarioDTO createInventario(InventarioDTO inventario){
		return inventarioLogicService.createInventario(inventario);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteInventario(@PathParam("id") Long id){
		inventarioLogicService.deleteInventario(id);
	}
	
	@GET
	public List<InventarioDTO> getInventarios(){
		return inventarioLogicService.getInventarios();
	}
	
	@GET
	@Path("{id}")
	public InventarioDTO getInventario(@PathParam("id") Long id){
		return inventarioLogicService.getInventario(id);
	}
	
	@PUT
    @Path("{id}")
	public void updateInventario(@PathParam("id") Long id, InventarioDTO inventario){
		inventarioLogicService.updateInventario(inventario);
	}
	
}