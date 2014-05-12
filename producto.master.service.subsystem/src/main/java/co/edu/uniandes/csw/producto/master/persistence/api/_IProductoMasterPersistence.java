package co.edu.uniandes.csw.producto.master.persistence.api;

import co.edu.uniandes.csw.producto.master.persistence.entity.ProductoItemEntity;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.producto.master.logic.dto.ProductoMasterDTO;
import java.util.List;

public interface _IProductoMasterPersistence {

    public ProductoItemEntity createProductoItem(ProductoItemEntity entity);

    public void deleteProductoItem(Long productoId, Long itemId);
    
    public List<ItemDTO> getItemListForProducto(Long productoId);
    
    public ProductoMasterDTO getProducto(Long productoId);

}
