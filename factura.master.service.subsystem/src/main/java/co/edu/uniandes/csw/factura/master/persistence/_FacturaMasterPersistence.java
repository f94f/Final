package co.edu.uniandes.csw.factura.master.persistence;
import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenReaprovicionamientoEntity;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.converter.OrdenReaprovicionamientoConverter;
import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenFabricacionEntity;
import co.edu.uniandes.csw.ordenfabricacion.persistence.converter.OrdenFabricacionConverter;
import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenDespachoEntity;
import co.edu.uniandes.csw.ordendespacho.persistence.converter.OrdenDespachoConverter;
import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.factura.master.logic.dto.FacturaMasterDTO;
import co.edu.uniandes.csw.factura.master.persistence.api._IFacturaMasterPersistence;
import co.edu.uniandes.csw.factura.persistence.api.IFacturaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _FacturaMasterPersistence implements _IFacturaMasterPersistence {

    @PersistenceContext(unitName = "FacturaMasterPU")
    protected EntityManager entityManager;
    
    @Inject
    protected IFacturaPersistence facturaPersistence;  

    public FacturaMasterDTO getFactura(Long facturaId) {
        FacturaMasterDTO facturaMasterDTO = new FacturaMasterDTO();
        FacturaDTO factura = facturaPersistence.getFactura(facturaId);
        facturaMasterDTO.setFacturaEntity(factura);
        facturaMasterDTO.setListOrdenReaprovicionamiento(getOrdenReaprovicionamientoListForFactura(facturaId));
        facturaMasterDTO.setListOrdenFabricacion(getOrdenFabricacionListForFactura(facturaId));
        facturaMasterDTO.setListOrdenDespacho(getOrdenDespachoListForFactura(facturaId));
        return facturaMasterDTO;
    }

    public FacturaOrdenReaprovicionamientoEntity createFacturaOrdenReaprovicionamiento(FacturaOrdenReaprovicionamientoEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteFacturaOrdenReaprovicionamiento(Long facturaId, Long ordenReaprovicionamientoId) {
        Query q = entityManager.createNamedQuery("FacturaOrdenReaprovicionamientoEntity.deleteFacturaOrdenReaprovicionamiento");
        q.setParameter("facturaId", facturaId);
        q.setParameter("ordenReaprovicionamientoId", ordenReaprovicionamientoId);
        q.executeUpdate();
    }

    public List<OrdenReaprovicionamientoDTO> getOrdenReaprovicionamientoListForFactura(Long facturaId) {
        ArrayList<OrdenReaprovicionamientoDTO> resp = new ArrayList<OrdenReaprovicionamientoDTO>();
        Query q = entityManager.createNamedQuery("FacturaOrdenReaprovicionamientoEntity.getOrdenReaprovicionamientoListForFactura");
        q.setParameter("facturaId", facturaId);
        List<FacturaOrdenReaprovicionamientoEntity> qResult =  q.getResultList();
        for (FacturaOrdenReaprovicionamientoEntity facturaOrdenReaprovicionamientoEntity : qResult) { 
            if(facturaOrdenReaprovicionamientoEntity.getOrdenReaprovicionamientoEntity()==null){
                entityManager.refresh(facturaOrdenReaprovicionamientoEntity);
            }
            resp.add(OrdenReaprovicionamientoConverter.entity2PersistenceDTO(facturaOrdenReaprovicionamientoEntity.getOrdenReaprovicionamientoEntity()));
        }
        return resp;
    }
    public FacturaOrdenFabricacionEntity createFacturaOrdenFabricacion(FacturaOrdenFabricacionEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteFacturaOrdenFabricacion(Long facturaId, Long ordenFabricacionId) {
        Query q = entityManager.createNamedQuery("FacturaOrdenFabricacionEntity.deleteFacturaOrdenFabricacion");
        q.setParameter("facturaId", facturaId);
        q.setParameter("ordenFabricacionId", ordenFabricacionId);
        q.executeUpdate();
    }

    public List<OrdenFabricacionDTO> getOrdenFabricacionListForFactura(Long facturaId) {
        ArrayList<OrdenFabricacionDTO> resp = new ArrayList<OrdenFabricacionDTO>();
        Query q = entityManager.createNamedQuery("FacturaOrdenFabricacionEntity.getOrdenFabricacionListForFactura");
        q.setParameter("facturaId", facturaId);
        List<FacturaOrdenFabricacionEntity> qResult =  q.getResultList();
        for (FacturaOrdenFabricacionEntity facturaOrdenFabricacionEntity : qResult) { 
            if(facturaOrdenFabricacionEntity.getOrdenFabricacionEntity()==null){
                entityManager.refresh(facturaOrdenFabricacionEntity);
            }
            resp.add(OrdenFabricacionConverter.entity2PersistenceDTO(facturaOrdenFabricacionEntity.getOrdenFabricacionEntity()));
        }
        return resp;
    }
    public FacturaOrdenDespachoEntity createFacturaOrdenDespacho(FacturaOrdenDespachoEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteFacturaOrdenDespacho(Long facturaId, Long ordenDespachoId) {
        Query q = entityManager.createNamedQuery("FacturaOrdenDespachoEntity.deleteFacturaOrdenDespacho");
        q.setParameter("facturaId", facturaId);
        q.setParameter("ordenDespachoId", ordenDespachoId);
        q.executeUpdate();
    }

    public List<OrdenDespachoDTO> getOrdenDespachoListForFactura(Long facturaId) {
        ArrayList<OrdenDespachoDTO> resp = new ArrayList<OrdenDespachoDTO>();
        Query q = entityManager.createNamedQuery("FacturaOrdenDespachoEntity.getOrdenDespachoListForFactura");
        q.setParameter("facturaId", facturaId);
        List<FacturaOrdenDespachoEntity> qResult =  q.getResultList();
        for (FacturaOrdenDespachoEntity facturaOrdenDespachoEntity : qResult) { 
            if(facturaOrdenDespachoEntity.getOrdenDespachoEntity()==null){
                entityManager.refresh(facturaOrdenDespachoEntity);
            }
            resp.add(OrdenDespachoConverter.entity2PersistenceDTO(facturaOrdenDespachoEntity.getOrdenDespachoEntity()));
        }
        return resp;
    }

}
