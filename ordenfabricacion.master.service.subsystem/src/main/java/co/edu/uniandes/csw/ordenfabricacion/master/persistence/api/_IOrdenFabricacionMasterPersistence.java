package co.edu.uniandes.csw.ordenfabricacion.master.persistence.api;

import co.edu.uniandes.csw.ordenfabricacion.master.persistence.entity.OrdenFabricacionProductoEntity;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.ordenfabricacion.master.logic.dto.OrdenFabricacionMasterDTO;
import java.util.List;

public interface _IOrdenFabricacionMasterPersistence {

    public OrdenFabricacionProductoEntity createOrdenFabricacionProducto(OrdenFabricacionProductoEntity entity);

    public void deleteOrdenFabricacionProducto(Long ordenfabricacionId, Long productoId);
    
    public List<ProductoDTO> getProductoListForOrdenFabricacion(Long ordenfabricacionId);
    
    public OrdenFabricacionMasterDTO getOrdenFabricacion(Long ordenfabricacionId);

}
