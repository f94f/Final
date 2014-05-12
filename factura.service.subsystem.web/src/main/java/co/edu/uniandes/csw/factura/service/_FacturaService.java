package co.edu.uniandes.csw.factura.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.factura.logic.api.IFacturaLogicService;
import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;


public abstract class _FacturaService {

	@Inject
	protected IFacturaLogicService facturaLogicService;
	
	@POST
	public FacturaDTO createFactura(FacturaDTO factura){
		return facturaLogicService.createFactura(factura);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteFactura(@PathParam("id") Long id){
		facturaLogicService.deleteFactura(id);
	}
	
	@GET
	public List<FacturaDTO> getFacturas(){
		return facturaLogicService.getFacturas();
	}
	
	@GET
	@Path("{id}")
	public FacturaDTO getFactura(@PathParam("id") Long id){
		return facturaLogicService.getFactura(id);
	}
	
	@PUT
    @Path("{id}")
	public void updateFactura(@PathParam("id") Long id, FacturaDTO factura){
		facturaLogicService.updateFactura(factura);
	}
	
}