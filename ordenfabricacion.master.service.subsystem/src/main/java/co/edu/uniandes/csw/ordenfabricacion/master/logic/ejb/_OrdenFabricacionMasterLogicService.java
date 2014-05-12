package co.edu.uniandes.csw.ordenfabricacion.master.logic.ejb;

import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.producto.persistence.api.IProductoPersistence;
import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordenfabricacion.master.logic.api._IOrdenFabricacionMasterLogicService;
import co.edu.uniandes.csw.ordenfabricacion.master.logic.dto.OrdenFabricacionMasterDTO;
import co.edu.uniandes.csw.ordenfabricacion.master.persistence.api.IOrdenFabricacionMasterPersistence;
import co.edu.uniandes.csw.ordenfabricacion.master.persistence.entity.OrdenFabricacionProductoEntity;
import co.edu.uniandes.csw.ordenfabricacion.persistence.api.IOrdenFabricacionPersistence;
import javax.inject.Inject;

public abstract class _OrdenFabricacionMasterLogicService implements _IOrdenFabricacionMasterLogicService {

    @Inject
    protected IOrdenFabricacionPersistence ordenfabricacionPersistance;
    @Inject
    protected IOrdenFabricacionMasterPersistence ordenfabricacionMasterPersistance;
    @Inject
    protected IProductoPersistence productoPersistance;

    public OrdenFabricacionMasterDTO createMasterOrdenFabricacion(OrdenFabricacionMasterDTO ordenfabricacion) {
        OrdenFabricacionDTO persistedOrdenFabricacionDTO = ordenfabricacionPersistance.createOrdenFabricacion(ordenfabricacion.getOrdenFabricacionEntity());
        if (ordenfabricacion.getCreateProducto() != null) {
            for (ProductoDTO productoDTO : ordenfabricacion.getCreateProducto()) {
                ProductoDTO persistedProductoDTO = productoPersistance.createProducto(productoDTO);
                OrdenFabricacionProductoEntity ordenfabricacionProductoEntity = new OrdenFabricacionProductoEntity(persistedOrdenFabricacionDTO.getId(), persistedProductoDTO.getId());
                ordenfabricacionMasterPersistance.createOrdenFabricacionProducto(ordenfabricacionProductoEntity);
            }
        }
        return ordenfabricacion;
    }

    public OrdenFabricacionMasterDTO getMasterOrdenFabricacion(Long id) {
        return ordenfabricacionMasterPersistance.getOrdenFabricacion(id);
    }

    public void deleteMasterOrdenFabricacion(Long id) {
        ordenfabricacionPersistance.deleteOrdenFabricacion(id);
    }

    public void updateMasterOrdenFabricacion(OrdenFabricacionMasterDTO ordenfabricacion) {
        ordenfabricacionPersistance.updateOrdenFabricacion(ordenfabricacion.getOrdenFabricacionEntity());

        //---- FOR RELATIONSHIP
        // persist new producto
        if (ordenfabricacion.getCreateProducto() != null) {
            for (ProductoDTO productoDTO : ordenfabricacion.getCreateProducto()) {
                OrdenFabricacionProductoEntity ordenfabricacionProductoEntity = new OrdenFabricacionProductoEntity(ordenfabricacion.getOrdenFabricacionEntity().getId(), productoDTO.getId());
                ordenfabricacionMasterPersistance.createOrdenFabricacionProducto(ordenfabricacionProductoEntity);
            }
        }
        // update producto
        if (ordenfabricacion.getUpdateProducto() != null) {
            for (ProductoDTO productoDTO : ordenfabricacion.getUpdateProducto()) {
                productoPersistance.updateProducto(productoDTO);
            }
        }
        // delete producto
        if (ordenfabricacion.getDeleteProducto() != null) {
            for (ProductoDTO productoDTO : ordenfabricacion.getDeleteProducto()) {
                ordenfabricacionMasterPersistance.deleteOrdenFabricacionProducto(ordenfabricacion.getOrdenFabricacionEntity().getId(), productoDTO.getId());
            }
        }
    }
}
