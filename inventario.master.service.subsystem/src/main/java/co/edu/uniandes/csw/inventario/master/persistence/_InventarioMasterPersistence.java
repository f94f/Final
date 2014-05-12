package co.edu.uniandes.csw.inventario.master.persistence;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.inventario.master.persistence.entity.InventarioItemEntity;
import co.edu.uniandes.csw.item.persistence.converter.ItemConverter;
import co.edu.uniandes.csw.inventario.logic.dto.InventarioDTO;
import co.edu.uniandes.csw.inventario.master.logic.dto.InventarioMasterDTO;
import co.edu.uniandes.csw.inventario.master.persistence.api._IInventarioMasterPersistence;
import co.edu.uniandes.csw.inventario.persistence.api.IInventarioPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _InventarioMasterPersistence implements _IInventarioMasterPersistence {

    @PersistenceContext(unitName = "InventarioMasterPU")
    protected EntityManager entityManager;
    
    @Inject
    protected IInventarioPersistence inventarioPersistence;  

    public InventarioMasterDTO getInventario(Long inventarioId) {
        InventarioMasterDTO inventarioMasterDTO = new InventarioMasterDTO();
        InventarioDTO inventario = inventarioPersistence.getInventario(inventarioId);
        inventarioMasterDTO.setInventarioEntity(inventario);
        inventarioMasterDTO.setListItem(getItemListForInventario(inventarioId));
        return inventarioMasterDTO;
    }

    public InventarioItemEntity createInventarioItem(InventarioItemEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteInventarioItem(Long inventarioId, Long itemId) {
        Query q = entityManager.createNamedQuery("InventarioItemEntity.deleteInventarioItem");
        q.setParameter("inventarioId", inventarioId);
        q.setParameter("itemId", itemId);
        q.executeUpdate();
    }

    public List<ItemDTO> getItemListForInventario(Long inventarioId) {
        ArrayList<ItemDTO> resp = new ArrayList<ItemDTO>();
        Query q = entityManager.createNamedQuery("InventarioItemEntity.getItemListForInventario");
        q.setParameter("inventarioId", inventarioId);
        List<InventarioItemEntity> qResult =  q.getResultList();
        for (InventarioItemEntity inventarioItemEntity : qResult) { 
            if(inventarioItemEntity.getItemEntity()==null){
                entityManager.refresh(inventarioItemEntity);
            }
            resp.add(ItemConverter.entity2PersistenceDTO(inventarioItemEntity.getItemEntity()));
        }
        return resp;
    }

}
