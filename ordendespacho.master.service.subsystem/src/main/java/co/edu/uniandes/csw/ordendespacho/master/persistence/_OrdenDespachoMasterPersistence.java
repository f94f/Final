package co.edu.uniandes.csw.ordendespacho.master.persistence;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.ordendespacho.master.persistence.entity.OrdenDespachoItemEntity;
import co.edu.uniandes.csw.item.persistence.converter.ItemConverter;
import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.ordendespacho.master.logic.dto.OrdenDespachoMasterDTO;
import co.edu.uniandes.csw.ordendespacho.master.persistence.api._IOrdenDespachoMasterPersistence;
import co.edu.uniandes.csw.ordendespacho.persistence.api.IOrdenDespachoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _OrdenDespachoMasterPersistence implements _IOrdenDespachoMasterPersistence {

    @PersistenceContext(unitName = "OrdenDespachoMasterPU")
    protected EntityManager entityManager;
    
    @Inject
    protected IOrdenDespachoPersistence ordendespachoPersistence;  

    public OrdenDespachoMasterDTO getOrdenDespacho(Long ordendespachoId) {
        OrdenDespachoMasterDTO ordendespachoMasterDTO = new OrdenDespachoMasterDTO();
        OrdenDespachoDTO ordendespacho = ordendespachoPersistence.getOrdenDespacho(ordendespachoId);
        ordendespachoMasterDTO.setOrdenDespachoEntity(ordendespacho);
        ordendespachoMasterDTO.setListItem(getItemListForOrdenDespacho(ordendespachoId));
        return ordendespachoMasterDTO;
    }

    public OrdenDespachoItemEntity createOrdenDespachoItem(OrdenDespachoItemEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteOrdenDespachoItem(Long ordendespachoId, Long itemId) {
        Query q = entityManager.createNamedQuery("OrdenDespachoItemEntity.deleteOrdenDespachoItem");
        q.setParameter("ordendespachoId", ordendespachoId);
        q.setParameter("itemId", itemId);
        q.executeUpdate();
    }

    public List<ItemDTO> getItemListForOrdenDespacho(Long ordendespachoId) {
        ArrayList<ItemDTO> resp = new ArrayList<ItemDTO>();
        Query q = entityManager.createNamedQuery("OrdenDespachoItemEntity.getItemListForOrdenDespacho");
        q.setParameter("ordendespachoId", ordendespachoId);
        List<OrdenDespachoItemEntity> qResult =  q.getResultList();
        for (OrdenDespachoItemEntity ordendespachoItemEntity : qResult) { 
            if(ordendespachoItemEntity.getItemEntity()==null){
                entityManager.refresh(ordendespachoItemEntity);
            }
            resp.add(ItemConverter.entity2PersistenceDTO(ordendespachoItemEntity.getItemEntity()));
        }
        return resp;
    }

}
