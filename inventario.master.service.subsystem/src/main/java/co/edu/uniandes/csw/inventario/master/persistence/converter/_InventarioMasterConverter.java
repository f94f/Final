package co.edu.uniandes.csw.inventario.master.persistence.converter;
import co.edu.uniandes.csw.inventario.master.persistence.entity.InventarioItemEntity;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.item.persistence.converter.ItemConverter;
import co.edu.uniandes.csw.inventario.logic.dto.InventarioDTO;
import co.edu.uniandes.csw.inventario.master.logic.dto.InventarioMasterDTO;
import co.edu.uniandes.csw.inventario.persistence.converter.InventarioConverter;
import co.edu.uniandes.csw.inventario.persistence.entity.InventarioEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class _InventarioMasterConverter {

    public static InventarioMasterDTO entity2PersistenceDTO(InventarioEntity inventarioEntity 
    ,List<InventarioItemEntity> inventarioItemEntity 
    ) {
        InventarioDTO inventarioDTO = InventarioConverter.entity2PersistenceDTO(inventarioEntity);
        ArrayList<ItemDTO> itemEntities = new ArrayList<ItemDTO>(inventarioItemEntity.size());
        for (InventarioItemEntity inventarioItem : inventarioItemEntity) {
            itemEntities.add(ItemConverter.entity2PersistenceDTO(inventarioItem.getItemEntity()));
        }
        InventarioMasterDTO respDTO  = new InventarioMasterDTO();
        respDTO.setInventarioEntity(inventarioDTO);
        respDTO.setListItem(itemEntities);
        return respDTO;
    }

}