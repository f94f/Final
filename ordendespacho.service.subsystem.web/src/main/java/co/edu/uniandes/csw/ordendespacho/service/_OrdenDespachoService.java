package co.edu.uniandes.csw.ordendespacho.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.ordendespacho.logic.api.IOrdenDespachoLogicService;
import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;


public abstract class _OrdenDespachoService {

	@Inject
	protected IOrdenDespachoLogicService ordenDespachoLogicService;
	
	@POST
	public OrdenDespachoDTO createOrdenDespacho(OrdenDespachoDTO ordenDespacho){
		return ordenDespachoLogicService.createOrdenDespacho(ordenDespacho);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteOrdenDespacho(@PathParam("id") Long id){
		ordenDespachoLogicService.deleteOrdenDespacho(id);
	}
	
	@GET
	public List<OrdenDespachoDTO> getOrdenDespachos(){
		return ordenDespachoLogicService.getOrdenDespachos();
	}
	
	@GET
	@Path("{id}")
	public OrdenDespachoDTO getOrdenDespacho(@PathParam("id") Long id){
		return ordenDespachoLogicService.getOrdenDespacho(id);
	}
	
	@PUT
    @Path("{id}")
	public void updateOrdenDespacho(@PathParam("id") Long id, OrdenDespachoDTO ordenDespacho){
		ordenDespachoLogicService.updateOrdenDespacho(ordenDespacho);
	}
	
}