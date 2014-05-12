package co.edu.uniandes.csw.inventario.master.logic.ejb;

import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.item.persistence.api.IItemPersistence;
import co.edu.uniandes.csw.inventario.logic.dto.InventarioDTO;
import co.edu.uniandes.csw.inventario.master.logic.api._IInventarioMasterLogicService;
import co.edu.uniandes.csw.inventario.master.logic.dto.InventarioMasterDTO;
import co.edu.uniandes.csw.inventario.master.persistence.api.IInventarioMasterPersistence;
import co.edu.uniandes.csw.inventario.master.persistence.entity.InventarioItemEntity;
import co.edu.uniandes.csw.inventario.persistence.api.IInventarioPersistence;
import javax.inject.Inject;

public abstract class _InventarioMasterLogicService implements _IInventarioMasterLogicService {

    @Inject
    protected IInventarioPersistence inventarioPersistance;
    @Inject
    protected IInventarioMasterPersistence inventarioMasterPersistance;
    @Inject
    protected IItemPersistence itemPersistance;

    public InventarioMasterDTO createMasterInventario(InventarioMasterDTO inventario) {
        InventarioDTO persistedInventarioDTO = inventarioPersistance.createInventario(inventario.getInventarioEntity());
        if (inventario.getCreateItem() != null) {
            for (ItemDTO itemDTO : inventario.getCreateItem()) {
                ItemDTO persistedItemDTO = itemPersistance.createItem(itemDTO);
                InventarioItemEntity inventarioItemEntity = new InventarioItemEntity(persistedInventarioDTO.getId(), persistedItemDTO.getId());
                inventarioMasterPersistance.createInventarioItem(inventarioItemEntity);
            }
        }
        return inventario;
    }

    public InventarioMasterDTO getMasterInventario(Long id) {
        return inventarioMasterPersistance.getInventario(id);
    }

    public void deleteMasterInventario(Long id) {
        inventarioPersistance.deleteInventario(id);
    }

    public void updateMasterInventario(InventarioMasterDTO inventario) {
        inventarioPersistance.updateInventario(inventario.getInventarioEntity());

        //---- FOR RELATIONSHIP
        // persist new item
        if (inventario.getCreateItem() != null) {
            for (ItemDTO itemDTO : inventario.getCreateItem()) {
                InventarioItemEntity inventarioItemEntity = new InventarioItemEntity(inventario.getInventarioEntity().getId(), itemDTO.getId());
                inventarioMasterPersistance.createInventarioItem(inventarioItemEntity);
            }
        }
        // update item
        if (inventario.getUpdateItem() != null) {
            for (ItemDTO itemDTO : inventario.getUpdateItem()) {
                itemPersistance.updateItem(itemDTO);
            }
        }
        // delete item
        if (inventario.getDeleteItem() != null) {
            for (ItemDTO itemDTO : inventario.getDeleteItem()) {
                inventarioMasterPersistance.deleteInventarioItem(inventario.getInventarioEntity().getId(), itemDTO.getId());
            }
        }
    }
}
