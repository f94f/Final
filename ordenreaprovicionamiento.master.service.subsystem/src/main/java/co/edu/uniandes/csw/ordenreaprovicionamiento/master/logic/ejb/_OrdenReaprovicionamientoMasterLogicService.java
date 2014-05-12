package co.edu.uniandes.csw.ordenreaprovicionamiento.master.logic.ejb;

import co.edu.uniandes.csw.proveedor.logic.dto.ProveedorDTO;
import co.edu.uniandes.csw.proveedor.persistence.api.IProveedorPersistence;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.producto.persistence.api.IProductoPersistence;
import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.logic.api._IOrdenReaprovicionamientoMasterLogicService;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.logic.dto.OrdenReaprovicionamientoMasterDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.api.IOrdenReaprovicionamientoMasterPersistence;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.entity.OrdenReaprovicionamientoProveedorEntity;
import co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.entity.OrdenReaprovicionamientoProductoEntity;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.api.IOrdenReaprovicionamientoPersistence;
import javax.inject.Inject;

public abstract class _OrdenReaprovicionamientoMasterLogicService implements _IOrdenReaprovicionamientoMasterLogicService {

    @Inject
    protected IOrdenReaprovicionamientoPersistence ordenreaprovicionamientoPersistance;
    @Inject
    protected IOrdenReaprovicionamientoMasterPersistence ordenreaprovicionamientoMasterPersistance;
    @Inject
    protected IProveedorPersistence proveedorPersistance;
    @Inject
    protected IProductoPersistence productoPersistance;

    public OrdenReaprovicionamientoMasterDTO createMasterOrdenReaprovicionamiento(OrdenReaprovicionamientoMasterDTO ordenreaprovicionamiento) {
        OrdenReaprovicionamientoDTO persistedOrdenReaprovicionamientoDTO = ordenreaprovicionamientoPersistance.createOrdenReaprovicionamiento(ordenreaprovicionamiento.getOrdenReaprovicionamientoEntity());
        if (ordenreaprovicionamiento.getCreateProveedor() != null) {
            for (ProveedorDTO proveedorDTO : ordenreaprovicionamiento.getCreateProveedor()) {
                ProveedorDTO persistedProveedorDTO = proveedorPersistance.createProveedor(proveedorDTO);
                OrdenReaprovicionamientoProveedorEntity ordenreaprovicionamientoProveedorEntity = new OrdenReaprovicionamientoProveedorEntity(persistedOrdenReaprovicionamientoDTO.getId(), persistedProveedorDTO.getId());
                ordenreaprovicionamientoMasterPersistance.createOrdenReaprovicionamientoProveedor(ordenreaprovicionamientoProveedorEntity);
            }
        }
        if (ordenreaprovicionamiento.getCreateProducto() != null) {
            for (ProductoDTO productoDTO : ordenreaprovicionamiento.getCreateProducto()) {
                ProductoDTO persistedProductoDTO = productoPersistance.createProducto(productoDTO);
                OrdenReaprovicionamientoProductoEntity ordenreaprovicionamientoProductoEntity = new OrdenReaprovicionamientoProductoEntity(persistedOrdenReaprovicionamientoDTO.getId(), persistedProductoDTO.getId());
                ordenreaprovicionamientoMasterPersistance.createOrdenReaprovicionamientoProducto(ordenreaprovicionamientoProductoEntity);
            }
        }
        return ordenreaprovicionamiento;
    }

    public OrdenReaprovicionamientoMasterDTO getMasterOrdenReaprovicionamiento(Long id) {
        return ordenreaprovicionamientoMasterPersistance.getOrdenReaprovicionamiento(id);
    }

    public void deleteMasterOrdenReaprovicionamiento(Long id) {
        ordenreaprovicionamientoPersistance.deleteOrdenReaprovicionamiento(id);
    }

    public void updateMasterOrdenReaprovicionamiento(OrdenReaprovicionamientoMasterDTO ordenreaprovicionamiento) {
        ordenreaprovicionamientoPersistance.updateOrdenReaprovicionamiento(ordenreaprovicionamiento.getOrdenReaprovicionamientoEntity());

        //---- FOR RELATIONSHIP
        // persist new proveedor
        if (ordenreaprovicionamiento.getCreateProveedor() != null) {
            for (ProveedorDTO proveedorDTO : ordenreaprovicionamiento.getCreateProveedor()) {
                OrdenReaprovicionamientoProveedorEntity ordenreaprovicionamientoProveedorEntity = new OrdenReaprovicionamientoProveedorEntity(ordenreaprovicionamiento.getOrdenReaprovicionamientoEntity().getId(), proveedorDTO.getId());
                ordenreaprovicionamientoMasterPersistance.createOrdenReaprovicionamientoProveedor(ordenreaprovicionamientoProveedorEntity);
            }
        }
        // update proveedor
        if (ordenreaprovicionamiento.getUpdateProveedor() != null) {
            for (ProveedorDTO proveedorDTO : ordenreaprovicionamiento.getUpdateProveedor()) {
                proveedorPersistance.updateProveedor(proveedorDTO);
            }
        }
        // delete proveedor
        if (ordenreaprovicionamiento.getDeleteProveedor() != null) {
            for (ProveedorDTO proveedorDTO : ordenreaprovicionamiento.getDeleteProveedor()) {
                ordenreaprovicionamientoMasterPersistance.deleteOrdenReaprovicionamientoProveedor(ordenreaprovicionamiento.getOrdenReaprovicionamientoEntity().getId(), proveedorDTO.getId());
            }
        }
        // persist new producto
        if (ordenreaprovicionamiento.getCreateProducto() != null) {
            for (ProductoDTO productoDTO : ordenreaprovicionamiento.getCreateProducto()) {
                OrdenReaprovicionamientoProductoEntity ordenreaprovicionamientoProductoEntity = new OrdenReaprovicionamientoProductoEntity(ordenreaprovicionamiento.getOrdenReaprovicionamientoEntity().getId(), productoDTO.getId());
                ordenreaprovicionamientoMasterPersistance.createOrdenReaprovicionamientoProducto(ordenreaprovicionamientoProductoEntity);
            }
        }
        // update producto
        if (ordenreaprovicionamiento.getUpdateProducto() != null) {
            for (ProductoDTO productoDTO : ordenreaprovicionamiento.getUpdateProducto()) {
                productoPersistance.updateProducto(productoDTO);
            }
        }
        // delete producto
        if (ordenreaprovicionamiento.getDeleteProducto() != null) {
            for (ProductoDTO productoDTO : ordenreaprovicionamiento.getDeleteProducto()) {
                ordenreaprovicionamientoMasterPersistance.deleteOrdenReaprovicionamientoProducto(ordenreaprovicionamiento.getOrdenReaprovicionamientoEntity().getId(), productoDTO.getId());
            }
        }
    }
}
