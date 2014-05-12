package co.edu.uniandes.csw.ordendespacho.master.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.ordendespacho.master.logic.api.IOrdenDespachoMasterLogicService;
import co.edu.uniandes.csw.ordendespacho.master.logic.dto.OrdenDespachoMasterDTO;

public abstract class _OrdenDespachoMasterService {

    @Inject
    protected IOrdenDespachoMasterLogicService ordendespachoLogicService;

    @POST
    public OrdenDespachoMasterDTO createOrdenDespacho(OrdenDespachoMasterDTO ordendespacho) {
        return ordendespachoLogicService.createMasterOrdenDespacho(ordendespacho);
    }

    @DELETE
    @Path("{id}")
    public void deleteOrdenDespacho(@PathParam("id") Long id) {
        ordendespachoLogicService.deleteMasterOrdenDespacho(id);
    }
    
    @GET
    @Path("{id}")
    public OrdenDespachoMasterDTO getOrdenDespacho(@PathParam("id") Long id) {
        return ordendespachoLogicService.getMasterOrdenDespacho(id);
    }

    @PUT
    @Path("{id}")
    public void updateOrdenDespacho(@PathParam("id") Long id, OrdenDespachoMasterDTO ordendespacho) {
        ordendespachoLogicService.updateMasterOrdenDespacho(ordendespacho);
    }

}
