package co.edu.uniandes.csw.ordendespacho.master.logic.ejb;

import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.item.persistence.api.IItemPersistence;
import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.ordendespacho.master.logic.api._IOrdenDespachoMasterLogicService;
import co.edu.uniandes.csw.ordendespacho.master.logic.dto.OrdenDespachoMasterDTO;
import co.edu.uniandes.csw.ordendespacho.master.persistence.api.IOrdenDespachoMasterPersistence;
import co.edu.uniandes.csw.ordendespacho.master.persistence.entity.OrdenDespachoItemEntity;
import co.edu.uniandes.csw.ordendespacho.persistence.api.IOrdenDespachoPersistence;
import javax.inject.Inject;

public abstract class _OrdenDespachoMasterLogicService implements _IOrdenDespachoMasterLogicService {

    @Inject
    protected IOrdenDespachoPersistence ordendespachoPersistance;
    @Inject
    protected IOrdenDespachoMasterPersistence ordendespachoMasterPersistance;
    @Inject
    protected IItemPersistence itemPersistance;

    public OrdenDespachoMasterDTO createMasterOrdenDespacho(OrdenDespachoMasterDTO ordendespacho) {
        OrdenDespachoDTO persistedOrdenDespachoDTO = ordendespachoPersistance.createOrdenDespacho(ordendespacho.getOrdenDespachoEntity());
        if (ordendespacho.getCreateItem() != null) {
            for (ItemDTO itemDTO : ordendespacho.getCreateItem()) {
                ItemDTO persistedItemDTO = itemPersistance.createItem(itemDTO);
                OrdenDespachoItemEntity ordendespachoItemEntity = new OrdenDespachoItemEntity(persistedOrdenDespachoDTO.getId(), persistedItemDTO.getId());
                ordendespachoMasterPersistance.createOrdenDespachoItem(ordendespachoItemEntity);
            }
        }
        return ordendespacho;
    }

    public OrdenDespachoMasterDTO getMasterOrdenDespacho(Long id) {
        return ordendespachoMasterPersistance.getOrdenDespacho(id);
    }

    public void deleteMasterOrdenDespacho(Long id) {
        ordendespachoPersistance.deleteOrdenDespacho(id);
    }

    public void updateMasterOrdenDespacho(OrdenDespachoMasterDTO ordendespacho) {
        ordendespachoPersistance.updateOrdenDespacho(ordendespacho.getOrdenDespachoEntity());

        //---- FOR RELATIONSHIP
        // persist new item
        if (ordendespacho.getCreateItem() != null) {
            for (ItemDTO itemDTO : ordendespacho.getCreateItem()) {
                OrdenDespachoItemEntity ordendespachoItemEntity = new OrdenDespachoItemEntity(ordendespacho.getOrdenDespachoEntity().getId(), itemDTO.getId());
                ordendespachoMasterPersistance.createOrdenDespachoItem(ordendespachoItemEntity);
            }
        }
        // update item
        if (ordendespacho.getUpdateItem() != null) {
            for (ItemDTO itemDTO : ordendespacho.getUpdateItem()) {
                itemPersistance.updateItem(itemDTO);
            }
        }
        // delete item
        if (ordendespacho.getDeleteItem() != null) {
            for (ItemDTO itemDTO : ordendespacho.getDeleteItem()) {
                ordendespachoMasterPersistance.deleteOrdenDespachoItem(ordendespacho.getOrdenDespachoEntity().getId(), itemDTO.getId());
            }
        }
    }
}
