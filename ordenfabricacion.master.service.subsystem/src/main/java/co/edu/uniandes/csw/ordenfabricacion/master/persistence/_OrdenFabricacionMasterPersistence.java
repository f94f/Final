package co.edu.uniandes.csw.ordenfabricacion.master.persistence;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.ordenfabricacion.master.persistence.entity.OrdenFabricacionProductoEntity;
import co.edu.uniandes.csw.producto.persistence.converter.ProductoConverter;
import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordenfabricacion.master.logic.dto.OrdenFabricacionMasterDTO;
import co.edu.uniandes.csw.ordenfabricacion.master.persistence.api._IOrdenFabricacionMasterPersistence;
import co.edu.uniandes.csw.ordenfabricacion.persistence.api.IOrdenFabricacionPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _OrdenFabricacionMasterPersistence implements _IOrdenFabricacionMasterPersistence {

    @PersistenceContext(unitName = "OrdenFabricacionMasterPU")
    protected EntityManager entityManager;
    
    @Inject
    protected IOrdenFabricacionPersistence ordenfabricacionPersistence;  

    public OrdenFabricacionMasterDTO getOrdenFabricacion(Long ordenfabricacionId) {
        OrdenFabricacionMasterDTO ordenfabricacionMasterDTO = new OrdenFabricacionMasterDTO();
        OrdenFabricacionDTO ordenfabricacion = ordenfabricacionPersistence.getOrdenFabricacion(ordenfabricacionId);
        ordenfabricacionMasterDTO.setOrdenFabricacionEntity(ordenfabricacion);
        ordenfabricacionMasterDTO.setListProducto(getProductoListForOrdenFabricacion(ordenfabricacionId));
        return ordenfabricacionMasterDTO;
    }

    public OrdenFabricacionProductoEntity createOrdenFabricacionProducto(OrdenFabricacionProductoEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteOrdenFabricacionProducto(Long ordenfabricacionId, Long productoId) {
        Query q = entityManager.createNamedQuery("OrdenFabricacionProductoEntity.deleteOrdenFabricacionProducto");
        q.setParameter("ordenfabricacionId", ordenfabricacionId);
        q.setParameter("productoId", productoId);
        q.executeUpdate();
    }

    public List<ProductoDTO> getProductoListForOrdenFabricacion(Long ordenfabricacionId) {
        ArrayList<ProductoDTO> resp = new ArrayList<ProductoDTO>();
        Query q = entityManager.createNamedQuery("OrdenFabricacionProductoEntity.getProductoListForOrdenFabricacion");
        q.setParameter("ordenfabricacionId", ordenfabricacionId);
        List<OrdenFabricacionProductoEntity> qResult =  q.getResultList();
        for (OrdenFabricacionProductoEntity ordenfabricacionProductoEntity : qResult) { 
            if(ordenfabricacionProductoEntity.getProductoEntity()==null){
                entityManager.refresh(ordenfabricacionProductoEntity);
            }
            resp.add(ProductoConverter.entity2PersistenceDTO(ordenfabricacionProductoEntity.getProductoEntity()));
        }
        return resp;
    }

}
