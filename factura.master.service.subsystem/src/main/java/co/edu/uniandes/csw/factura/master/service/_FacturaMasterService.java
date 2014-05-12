package co.edu.uniandes.csw.factura.master.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.factura.master.logic.api.IFacturaMasterLogicService;
import co.edu.uniandes.csw.factura.master.logic.dto.FacturaMasterDTO;

public abstract class _FacturaMasterService {

    @Inject
    protected IFacturaMasterLogicService facturaLogicService;

    @POST
    public FacturaMasterDTO createFactura(FacturaMasterDTO factura) {
        return facturaLogicService.createMasterFactura(factura);
    }

    @DELETE
    @Path("{id}")
    public void deleteFactura(@PathParam("id") Long id) {
        facturaLogicService.deleteMasterFactura(id);
    }
    
    @GET
    @Path("{id}")
    public FacturaMasterDTO getFactura(@PathParam("id") Long id) {
        return facturaLogicService.getMasterFactura(id);
    }

    @PUT
    @Path("{id}")
    public void updateFactura(@PathParam("id") Long id, FacturaMasterDTO factura) {
        facturaLogicService.updateMasterFactura(factura);
    }

}
