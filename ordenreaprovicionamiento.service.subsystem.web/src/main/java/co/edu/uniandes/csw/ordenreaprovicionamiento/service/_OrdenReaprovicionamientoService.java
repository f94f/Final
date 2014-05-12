package co.edu.uniandes.csw.ordenreaprovicionamiento.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.api.IOrdenReaprovicionamientoLogicService;
import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;


public abstract class _OrdenReaprovicionamientoService {

	@Inject
	protected IOrdenReaprovicionamientoLogicService ordenReaprovicionamientoLogicService;
	
	@POST
	public OrdenReaprovicionamientoDTO createOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO ordenReaprovicionamiento){
		return ordenReaprovicionamientoLogicService.createOrdenReaprovicionamiento(ordenReaprovicionamiento);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteOrdenReaprovicionamiento(@PathParam("id") Long id){
		ordenReaprovicionamientoLogicService.deleteOrdenReaprovicionamiento(id);
	}
	
	@GET
	public List<OrdenReaprovicionamientoDTO> getOrdenReaprovicionamientos(){
		return ordenReaprovicionamientoLogicService.getOrdenReaprovicionamientos();
	}
	
	@GET
	@Path("{id}")
	public OrdenReaprovicionamientoDTO getOrdenReaprovicionamiento(@PathParam("id") Long id){
		return ordenReaprovicionamientoLogicService.getOrdenReaprovicionamiento(id);
	}
	
	@PUT
    @Path("{id}")
	public void updateOrdenReaprovicionamiento(@PathParam("id") Long id, OrdenReaprovicionamientoDTO ordenReaprovicionamiento){
		ordenReaprovicionamientoLogicService.updateOrdenReaprovicionamiento(ordenReaprovicionamiento);
	}
	
}