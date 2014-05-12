package co.edu.uniandes.csw.ordenfabricacion.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class OrdenFabricacionProductoEntityId implements Serializable{

    private Long ordenfabricacionId;
    private Long productoId;

    @Override
    public int hashCode() {
        return (int) (ordenfabricacionId + productoId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof OrdenFabricacionProductoEntityId) {
            OrdenFabricacionProductoEntityId otherId = (OrdenFabricacionProductoEntityId) object;
            return (otherId.ordenfabricacionId == this.ordenfabricacionId) && (otherId.productoId == this.productoId);
        }
        return false;
    }

}
