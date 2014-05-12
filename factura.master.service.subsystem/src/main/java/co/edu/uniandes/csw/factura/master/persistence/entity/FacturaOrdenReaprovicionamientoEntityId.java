package co.edu.uniandes.csw.factura.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class FacturaOrdenReaprovicionamientoEntityId implements Serializable{

    private Long facturaId;
    private Long ordenReaprovicionamientoId;

    @Override
    public int hashCode() {
        return (int) (facturaId + ordenReaprovicionamientoId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof FacturaOrdenReaprovicionamientoEntityId) {
            FacturaOrdenReaprovicionamientoEntityId otherId = (FacturaOrdenReaprovicionamientoEntityId) object;
            return (otherId.facturaId == this.facturaId) && (otherId.ordenReaprovicionamientoId == this.ordenReaprovicionamientoId);
        }
        return false;
    }

}
