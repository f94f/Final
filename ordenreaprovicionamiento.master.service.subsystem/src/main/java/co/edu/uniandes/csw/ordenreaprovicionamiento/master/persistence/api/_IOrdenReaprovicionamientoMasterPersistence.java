package co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.api;

import co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.entity.OrdenReaprovicionamientoProveedorEntity;
import co.edu.uniandes.csw.proveedor.logic.dto.ProveedorDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.entity.OrdenReaprovicionamientoProductoEntity;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.logic.dto.OrdenReaprovicionamientoMasterDTO;
import java.util.List;

public interface _IOrdenReaprovicionamientoMasterPersistence {

    public OrdenReaprovicionamientoProveedorEntity createOrdenReaprovicionamientoProveedor(OrdenReaprovicionamientoProveedorEntity entity);

    public void deleteOrdenReaprovicionamientoProveedor(Long ordenreaprovicionamientoId, Long proveedorId);
    
    public List<ProveedorDTO> getProveedorListForOrdenReaprovicionamiento(Long ordenreaprovicionamientoId);
    public OrdenReaprovicionamientoProductoEntity createOrdenReaprovicionamientoProducto(OrdenReaprovicionamientoProductoEntity entity);

    public void deleteOrdenReaprovicionamientoProducto(Long ordenreaprovicionamientoId, Long productoId);
    
    public List<ProductoDTO> getProductoListForOrdenReaprovicionamiento(Long ordenreaprovicionamientoId);
    
    public OrdenReaprovicionamientoMasterDTO getOrdenReaprovicionamiento(Long ordenreaprovicionamientoId);

}
