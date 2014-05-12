package co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class OrdenReaprovicionamientoProductoEntityId implements Serializable{

    private Long ordenreaprovicionamientoId;
    private Long productoId;

    @Override
    public int hashCode() {
        return (int) (ordenreaprovicionamientoId + productoId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof OrdenReaprovicionamientoProductoEntityId) {
            OrdenReaprovicionamientoProductoEntityId otherId = (OrdenReaprovicionamientoProductoEntityId) object;
            return (otherId.ordenreaprovicionamientoId == this.ordenreaprovicionamientoId) && (otherId.productoId == this.productoId);
        }
        return false;
    }

}
