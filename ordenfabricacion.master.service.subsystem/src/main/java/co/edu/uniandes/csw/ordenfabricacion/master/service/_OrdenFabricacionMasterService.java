package co.edu.uniandes.csw.ordenfabricacion.master.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.ordenfabricacion.master.logic.api.IOrdenFabricacionMasterLogicService;
import co.edu.uniandes.csw.ordenfabricacion.master.logic.dto.OrdenFabricacionMasterDTO;

public abstract class _OrdenFabricacionMasterService {

    @Inject
    protected IOrdenFabricacionMasterLogicService ordenfabricacionLogicService;

    @POST
    public OrdenFabricacionMasterDTO createOrdenFabricacion(OrdenFabricacionMasterDTO ordenfabricacion) {
        return ordenfabricacionLogicService.createMasterOrdenFabricacion(ordenfabricacion);
    }

    @DELETE
    @Path("{id}")
    public void deleteOrdenFabricacion(@PathParam("id") Long id) {
        ordenfabricacionLogicService.deleteMasterOrdenFabricacion(id);
    }
    
    @GET
    @Path("{id}")
    public OrdenFabricacionMasterDTO getOrdenFabricacion(@PathParam("id") Long id) {
        return ordenfabricacionLogicService.getMasterOrdenFabricacion(id);
    }

    @PUT
    @Path("{id}")
    public void updateOrdenFabricacion(@PathParam("id") Long id, OrdenFabricacionMasterDTO ordenfabricacion) {
        ordenfabricacionLogicService.updateMasterOrdenFabricacion(ordenfabricacion);
    }

}
