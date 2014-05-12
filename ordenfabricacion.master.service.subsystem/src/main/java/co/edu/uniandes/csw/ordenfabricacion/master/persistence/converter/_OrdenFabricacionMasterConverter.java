package co.edu.uniandes.csw.ordenfabricacion.master.persistence.converter;
import co.edu.uniandes.csw.ordenfabricacion.master.persistence.entity.OrdenFabricacionProductoEntity;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.producto.persistence.converter.ProductoConverter;
import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordenfabricacion.master.logic.dto.OrdenFabricacionMasterDTO;
import co.edu.uniandes.csw.ordenfabricacion.persistence.converter.OrdenFabricacionConverter;
import co.edu.uniandes.csw.ordenfabricacion.persistence.entity.OrdenFabricacionEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class _OrdenFabricacionMasterConverter {

    public static OrdenFabricacionMasterDTO entity2PersistenceDTO(OrdenFabricacionEntity ordenfabricacionEntity 
    ,List<OrdenFabricacionProductoEntity> ordenfabricacionProductoEntity 
    ) {
        OrdenFabricacionDTO ordenfabricacionDTO = OrdenFabricacionConverter.entity2PersistenceDTO(ordenfabricacionEntity);
        ArrayList<ProductoDTO> productoEntities = new ArrayList<ProductoDTO>(ordenfabricacionProductoEntity.size());
        for (OrdenFabricacionProductoEntity ordenfabricacionProducto : ordenfabricacionProductoEntity) {
            productoEntities.add(ProductoConverter.entity2PersistenceDTO(ordenfabricacionProducto.getProductoEntity()));
        }
        OrdenFabricacionMasterDTO respDTO  = new OrdenFabricacionMasterDTO();
        respDTO.setOrdenFabricacionEntity(ordenfabricacionDTO);
        respDTO.setListProducto(productoEntities);
        return respDTO;
    }

}