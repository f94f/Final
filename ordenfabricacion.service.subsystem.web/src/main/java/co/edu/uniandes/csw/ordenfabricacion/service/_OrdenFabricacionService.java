package co.edu.uniandes.csw.ordenfabricacion.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.ordenfabricacion.logic.api.IOrdenFabricacionLogicService;
import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;


public abstract class _OrdenFabricacionService {

	@Inject
	protected IOrdenFabricacionLogicService ordenFabricacionLogicService;
	
	@POST
	public OrdenFabricacionDTO createOrdenFabricacion(OrdenFabricacionDTO ordenFabricacion){
		return ordenFabricacionLogicService.createOrdenFabricacion(ordenFabricacion);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteOrdenFabricacion(@PathParam("id") Long id){
		ordenFabricacionLogicService.deleteOrdenFabricacion(id);
	}
	
	@GET
	public List<OrdenFabricacionDTO> getOrdenFabricacions(){
		return ordenFabricacionLogicService.getOrdenFabricacions();
	}
	
	@GET
	@Path("{id}")
	public OrdenFabricacionDTO getOrdenFabricacion(@PathParam("id") Long id){
		return ordenFabricacionLogicService.getOrdenFabricacion(id);
	}
	
	@PUT
    @Path("{id}")
	public void updateOrdenFabricacion(@PathParam("id") Long id, OrdenFabricacionDTO ordenFabricacion){
		ordenFabricacionLogicService.updateOrdenFabricacion(ordenFabricacion);
	}
	
}