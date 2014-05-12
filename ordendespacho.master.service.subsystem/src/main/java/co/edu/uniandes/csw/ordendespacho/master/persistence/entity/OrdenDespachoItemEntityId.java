package co.edu.uniandes.csw.ordendespacho.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class OrdenDespachoItemEntityId implements Serializable{

    private Long ordendespachoId;
    private Long itemId;

    @Override
    public int hashCode() {
        return (int) (ordendespachoId + itemId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof OrdenDespachoItemEntityId) {
            OrdenDespachoItemEntityId otherId = (OrdenDespachoItemEntityId) object;
            return (otherId.ordendespachoId == this.ordendespachoId) && (otherId.itemId == this.itemId);
        }
        return false;
    }

}
