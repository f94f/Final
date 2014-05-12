package co.edu.uniandes.csw.inventario.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class InventarioItemEntityId implements Serializable{

    private Long inventarioId;
    private Long itemId;

    @Override
    public int hashCode() {
        return (int) (inventarioId + itemId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof InventarioItemEntityId) {
            InventarioItemEntityId otherId = (InventarioItemEntityId) object;
            return (otherId.inventarioId == this.inventarioId) && (otherId.itemId == this.itemId);
        }
        return false;
    }

}
