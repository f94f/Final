package co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class OrdenReaprovicionamientoProveedorEntityId implements Serializable{

    private Long ordenreaprovicionamientoId;
    private Long proveedorId;

    @Override
    public int hashCode() {
        return (int) (ordenreaprovicionamientoId + proveedorId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof OrdenReaprovicionamientoProveedorEntityId) {
            OrdenReaprovicionamientoProveedorEntityId otherId = (OrdenReaprovicionamientoProveedorEntityId) object;
            return (otherId.ordenreaprovicionamientoId == this.ordenreaprovicionamientoId) && (otherId.proveedorId == this.proveedorId);
        }
        return false;
    }

}
