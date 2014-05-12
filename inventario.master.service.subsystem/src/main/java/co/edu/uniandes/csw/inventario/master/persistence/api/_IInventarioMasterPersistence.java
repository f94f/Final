package co.edu.uniandes.csw.inventario.master.persistence.api;

import co.edu.uniandes.csw.inventario.master.persistence.entity.InventarioItemEntity;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.inventario.master.logic.dto.InventarioMasterDTO;
import java.util.List;

public interface _IInventarioMasterPersistence {

    public InventarioItemEntity createInventarioItem(InventarioItemEntity entity);

    public void deleteInventarioItem(Long inventarioId, Long itemId);
    
    public List<ItemDTO> getItemListForInventario(Long inventarioId);
    
    public InventarioMasterDTO getInventario(Long inventarioId);

}
