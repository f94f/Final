package co.edu.uniandes.csw.ordenreaprovicionamiento.master.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.ordenreaprovicionamiento.master.logic.api.IOrdenReaprovicionamientoMasterLogicService;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.logic.dto.OrdenReaprovicionamientoMasterDTO;

public abstract class _OrdenReaprovicionamientoMasterService {

    @Inject
    protected IOrdenReaprovicionamientoMasterLogicService ordenreaprovicionamientoLogicService;

    @POST
    public OrdenReaprovicionamientoMasterDTO createOrdenReaprovicionamiento(OrdenReaprovicionamientoMasterDTO ordenreaprovicionamiento) {
        return ordenreaprovicionamientoLogicService.createMasterOrdenReaprovicionamiento(ordenreaprovicionamiento);
    }

    @DELETE
    @Path("{id}")
    public void deleteOrdenReaprovicionamiento(@PathParam("id") Long id) {
        ordenreaprovicionamientoLogicService.deleteMasterOrdenReaprovicionamiento(id);
    }
    
    @GET
    @Path("{id}")
    public OrdenReaprovicionamientoMasterDTO getOrdenReaprovicionamiento(@PathParam("id") Long id) {
        return ordenreaprovicionamientoLogicService.getMasterOrdenReaprovicionamiento(id);
    }

    @PUT
    @Path("{id}")
    public void updateOrdenReaprovicionamiento(@PathParam("id") Long id, OrdenReaprovicionamientoMasterDTO ordenreaprovicionamiento) {
        ordenreaprovicionamientoLogicService.updateMasterOrdenReaprovicionamiento(ordenreaprovicionamiento);
    }

}
