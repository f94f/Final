package co.edu.uniandes.csw.ordendespacho.master.persistence.converter;
import co.edu.uniandes.csw.ordendespacho.master.persistence.entity.OrdenDespachoItemEntity;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.item.persistence.converter.ItemConverter;
import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.ordendespacho.master.logic.dto.OrdenDespachoMasterDTO;
import co.edu.uniandes.csw.ordendespacho.persistence.converter.OrdenDespachoConverter;
import co.edu.uniandes.csw.ordendespacho.persistence.entity.OrdenDespachoEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class _OrdenDespachoMasterConverter {

    public static OrdenDespachoMasterDTO entity2PersistenceDTO(OrdenDespachoEntity ordendespachoEntity 
    ,List<OrdenDespachoItemEntity> ordendespachoItemEntity 
    ) {
        OrdenDespachoDTO ordendespachoDTO = OrdenDespachoConverter.entity2PersistenceDTO(ordendespachoEntity);
        ArrayList<ItemDTO> itemEntities = new ArrayList<ItemDTO>(ordendespachoItemEntity.size());
        for (OrdenDespachoItemEntity ordendespachoItem : ordendespachoItemEntity) {
            itemEntities.add(ItemConverter.entity2PersistenceDTO(ordendespachoItem.getItemEntity()));
        }
        OrdenDespachoMasterDTO respDTO  = new OrdenDespachoMasterDTO();
        respDTO.setOrdenDespachoEntity(ordendespachoDTO);
        respDTO.setListItem(itemEntities);
        return respDTO;
    }

}