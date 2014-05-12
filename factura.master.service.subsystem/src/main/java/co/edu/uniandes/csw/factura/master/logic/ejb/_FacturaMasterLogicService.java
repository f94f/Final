package co.edu.uniandes.csw.factura.master.logic.ejb;

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.api.IOrdenReaprovicionamientoPersistence;
import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordenfabricacion.persistence.api.IOrdenFabricacionPersistence;
import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.ordendespacho.persistence.api.IOrdenDespachoPersistence;
import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.factura.master.logic.api._IFacturaMasterLogicService;
import co.edu.uniandes.csw.factura.master.logic.dto.FacturaMasterDTO;
import co.edu.uniandes.csw.factura.master.persistence.api.IFacturaMasterPersistence;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenReaprovicionamientoEntity;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenFabricacionEntity;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenDespachoEntity;
import co.edu.uniandes.csw.factura.persistence.api.IFacturaPersistence;
import javax.inject.Inject;

public abstract class _FacturaMasterLogicService implements _IFacturaMasterLogicService {

    @Inject
    protected IFacturaPersistence facturaPersistance;
    @Inject
    protected IFacturaMasterPersistence facturaMasterPersistance;
    @Inject
    protected IOrdenReaprovicionamientoPersistence ordenReaprovicionamientoPersistance;
    @Inject
    protected IOrdenFabricacionPersistence ordenFabricacionPersistance;
    @Inject
    protected IOrdenDespachoPersistence ordenDespachoPersistance;

    public FacturaMasterDTO createMasterFactura(FacturaMasterDTO factura) {
        FacturaDTO persistedFacturaDTO = facturaPersistance.createFactura(factura.getFacturaEntity());
        if (factura.getCreateOrdenReaprovicionamiento() != null) {
            for (OrdenReaprovicionamientoDTO ordenReaprovicionamientoDTO : factura.getCreateOrdenReaprovicionamiento()) {
                OrdenReaprovicionamientoDTO persistedOrdenReaprovicionamientoDTO = ordenReaprovicionamientoPersistance.createOrdenReaprovicionamiento(ordenReaprovicionamientoDTO);
                FacturaOrdenReaprovicionamientoEntity facturaOrdenReaprovicionamientoEntity = new FacturaOrdenReaprovicionamientoEntity(persistedFacturaDTO.getId(), persistedOrdenReaprovicionamientoDTO.getId());
                facturaMasterPersistance.createFacturaOrdenReaprovicionamiento(facturaOrdenReaprovicionamientoEntity);
            }
        }
        if (factura.getCreateOrdenFabricacion() != null) {
            for (OrdenFabricacionDTO ordenFabricacionDTO : factura.getCreateOrdenFabricacion()) {
                OrdenFabricacionDTO persistedOrdenFabricacionDTO = ordenFabricacionPersistance.createOrdenFabricacion(ordenFabricacionDTO);
                FacturaOrdenFabricacionEntity facturaOrdenFabricacionEntity = new FacturaOrdenFabricacionEntity(persistedFacturaDTO.getId(), persistedOrdenFabricacionDTO.getId());
                facturaMasterPersistance.createFacturaOrdenFabricacion(facturaOrdenFabricacionEntity);
            }
        }
        if (factura.getCreateOrdenDespacho() != null) {
            for (OrdenDespachoDTO ordenDespachoDTO : factura.getCreateOrdenDespacho()) {
                OrdenDespachoDTO persistedOrdenDespachoDTO = ordenDespachoPersistance.createOrdenDespacho(ordenDespachoDTO);
                FacturaOrdenDespachoEntity facturaOrdenDespachoEntity = new FacturaOrdenDespachoEntity(persistedFacturaDTO.getId(), persistedOrdenDespachoDTO.getId());
                facturaMasterPersistance.createFacturaOrdenDespacho(facturaOrdenDespachoEntity);
            }
        }
        return factura;
    }

    public FacturaMasterDTO getMasterFactura(Long id) {
        return facturaMasterPersistance.getFactura(id);
    }

    public void deleteMasterFactura(Long id) {
        facturaPersistance.deleteFactura(id);
    }

    public void updateMasterFactura(FacturaMasterDTO factura) {
        facturaPersistance.updateFactura(factura.getFacturaEntity());

        //---- FOR RELATIONSHIP
        // persist new ordenReaprovicionamiento
        if (factura.getCreateOrdenReaprovicionamiento() != null) {
            for (OrdenReaprovicionamientoDTO ordenReaprovicionamientoDTO : factura.getCreateOrdenReaprovicionamiento()) {
                OrdenReaprovicionamientoDTO persistedOrdenReaprovicionamientoDTO = ordenReaprovicionamientoPersistance.createOrdenReaprovicionamiento(ordenReaprovicionamientoDTO);
                FacturaOrdenReaprovicionamientoEntity facturaOrdenReaprovicionamientoEntity = new FacturaOrdenReaprovicionamientoEntity(factura.getFacturaEntity().getId(), persistedOrdenReaprovicionamientoDTO.getId());
                facturaMasterPersistance.createFacturaOrdenReaprovicionamiento(facturaOrdenReaprovicionamientoEntity);
            }
        }
        // update ordenReaprovicionamiento
        if (factura.getUpdateOrdenReaprovicionamiento() != null) {
            for (OrdenReaprovicionamientoDTO ordenReaprovicionamientoDTO : factura.getUpdateOrdenReaprovicionamiento()) {
                ordenReaprovicionamientoPersistance.updateOrdenReaprovicionamiento(ordenReaprovicionamientoDTO);
            }
        }
        // delete ordenReaprovicionamiento
        if (factura.getDeleteOrdenReaprovicionamiento() != null) {
            for (OrdenReaprovicionamientoDTO ordenReaprovicionamientoDTO : factura.getDeleteOrdenReaprovicionamiento()) {
                facturaMasterPersistance.deleteFacturaOrdenReaprovicionamiento(factura.getFacturaEntity().getId(), ordenReaprovicionamientoDTO.getId());
                ordenReaprovicionamientoPersistance.deleteOrdenReaprovicionamiento(ordenReaprovicionamientoDTO.getId());
            }
        }
        // persist new ordenFabricacion
        if (factura.getCreateOrdenFabricacion() != null) {
            for (OrdenFabricacionDTO ordenFabricacionDTO : factura.getCreateOrdenFabricacion()) {
                OrdenFabricacionDTO persistedOrdenFabricacionDTO = ordenFabricacionPersistance.createOrdenFabricacion(ordenFabricacionDTO);
                FacturaOrdenFabricacionEntity facturaOrdenFabricacionEntity = new FacturaOrdenFabricacionEntity(factura.getFacturaEntity().getId(), persistedOrdenFabricacionDTO.getId());
                facturaMasterPersistance.createFacturaOrdenFabricacion(facturaOrdenFabricacionEntity);
            }
        }
        // update ordenFabricacion
        if (factura.getUpdateOrdenFabricacion() != null) {
            for (OrdenFabricacionDTO ordenFabricacionDTO : factura.getUpdateOrdenFabricacion()) {
                ordenFabricacionPersistance.updateOrdenFabricacion(ordenFabricacionDTO);
            }
        }
        // delete ordenFabricacion
        if (factura.getDeleteOrdenFabricacion() != null) {
            for (OrdenFabricacionDTO ordenFabricacionDTO : factura.getDeleteOrdenFabricacion()) {
                facturaMasterPersistance.deleteFacturaOrdenFabricacion(factura.getFacturaEntity().getId(), ordenFabricacionDTO.getId());
                ordenFabricacionPersistance.deleteOrdenFabricacion(ordenFabricacionDTO.getId());
            }
        }
        // persist new ordenDespacho
        if (factura.getCreateOrdenDespacho() != null) {
            for (OrdenDespachoDTO ordenDespachoDTO : factura.getCreateOrdenDespacho()) {
                OrdenDespachoDTO persistedOrdenDespachoDTO = ordenDespachoPersistance.createOrdenDespacho(ordenDespachoDTO);
                FacturaOrdenDespachoEntity facturaOrdenDespachoEntity = new FacturaOrdenDespachoEntity(factura.getFacturaEntity().getId(), persistedOrdenDespachoDTO.getId());
                facturaMasterPersistance.createFacturaOrdenDespacho(facturaOrdenDespachoEntity);
            }
        }
        // update ordenDespacho
        if (factura.getUpdateOrdenDespacho() != null) {
            for (OrdenDespachoDTO ordenDespachoDTO : factura.getUpdateOrdenDespacho()) {
                ordenDespachoPersistance.updateOrdenDespacho(ordenDespachoDTO);
            }
        }
        // delete ordenDespacho
        if (factura.getDeleteOrdenDespacho() != null) {
            for (OrdenDespachoDTO ordenDespachoDTO : factura.getDeleteOrdenDespacho()) {
                facturaMasterPersistance.deleteFacturaOrdenDespacho(factura.getFacturaEntity().getId(), ordenDespachoDTO.getId());
                ordenDespachoPersistance.deleteOrdenDespacho(ordenDespachoDTO.getId());
            }
        }
    }
}
