package co.edu.uniandes.csw.ordendespacho.master.persistence.api;

import co.edu.uniandes.csw.ordendespacho.master.persistence.entity.OrdenDespachoItemEntity;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.ordendespacho.master.logic.dto.OrdenDespachoMasterDTO;
import java.util.List;

public interface _IOrdenDespachoMasterPersistence {

    public OrdenDespachoItemEntity createOrdenDespachoItem(OrdenDespachoItemEntity entity);

    public void deleteOrdenDespachoItem(Long ordendespachoId, Long itemId);
    
    public List<ItemDTO> getItemListForOrdenDespacho(Long ordendespachoId);
    
    public OrdenDespachoMasterDTO getOrdenDespacho(Long ordendespachoId);

}
