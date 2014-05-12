package co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.converter;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.entity.OrdenReaprovicionamientoProveedorEntity;
import co.edu.uniandes.csw.proveedor.logic.dto.ProveedorDTO;
import co.edu.uniandes.csw.proveedor.persistence.converter.ProveedorConverter;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.entity.OrdenReaprovicionamientoProductoEntity;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.producto.persistence.converter.ProductoConverter;
import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.logic.dto.OrdenReaprovicionamientoMasterDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.converter.OrdenReaprovicionamientoConverter;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.entity.OrdenReaprovicionamientoEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class _OrdenReaprovicionamientoMasterConverter {

    public static OrdenReaprovicionamientoMasterDTO entity2PersistenceDTO(OrdenReaprovicionamientoEntity ordenreaprovicionamientoEntity 
    ,List<OrdenReaprovicionamientoProveedorEntity> ordenreaprovicionamientoProveedorEntity 
    ,List<OrdenReaprovicionamientoProductoEntity> ordenreaprovicionamientoProductoEntity 
    ) {
        OrdenReaprovicionamientoDTO ordenreaprovicionamientoDTO = OrdenReaprovicionamientoConverter.entity2PersistenceDTO(ordenreaprovicionamientoEntity);
        ArrayList<ProveedorDTO> proveedorEntities = new ArrayList<ProveedorDTO>(ordenreaprovicionamientoProveedorEntity.size());
        for (OrdenReaprovicionamientoProveedorEntity ordenreaprovicionamientoProveedor : ordenreaprovicionamientoProveedorEntity) {
            proveedorEntities.add(ProveedorConverter.entity2PersistenceDTO(ordenreaprovicionamientoProveedor.getProveedorEntity()));
        }
        ArrayList<ProductoDTO> productoEntities = new ArrayList<ProductoDTO>(ordenreaprovicionamientoProductoEntity.size());
        for (OrdenReaprovicionamientoProductoEntity ordenreaprovicionamientoProducto : ordenreaprovicionamientoProductoEntity) {
            productoEntities.add(ProductoConverter.entity2PersistenceDTO(ordenreaprovicionamientoProducto.getProductoEntity()));
        }
        OrdenReaprovicionamientoMasterDTO respDTO  = new OrdenReaprovicionamientoMasterDTO();
        respDTO.setOrdenReaprovicionamientoEntity(ordenreaprovicionamientoDTO);
        respDTO.setListProveedor(proveedorEntities);
        respDTO.setListProducto(productoEntities);
        return respDTO;
    }

}