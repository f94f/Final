package co.edu.uniandes.csw.inventario.master.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.inventario.master.logic.api.IInventarioMasterLogicService;
import co.edu.uniandes.csw.inventario.master.logic.dto.InventarioMasterDTO;

public abstract class _InventarioMasterService {

    @Inject
    protected IInventarioMasterLogicService inventarioLogicService;

    @POST
    public InventarioMasterDTO createInventario(InventarioMasterDTO inventario) {
        return inventarioLogicService.createMasterInventario(inventario);
    }

    @DELETE
    @Path("{id}")
    public void deleteInventario(@PathParam("id") Long id) {
        inventarioLogicService.deleteMasterInventario(id);
    }
    
    @GET
    @Path("{id}")
    public InventarioMasterDTO getInventario(@PathParam("id") Long id) {
        return inventarioLogicService.getMasterInventario(id);
    }

    @PUT
    @Path("{id}")
    public void updateInventario(@PathParam("id") Long id, InventarioMasterDTO inventario) {
        inventarioLogicService.updateMasterInventario(inventario);
    }

}
