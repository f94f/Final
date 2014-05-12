package co.edu.uniandes.csw.factura.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class FacturaOrdenDespachoEntityId implements Serializable{

    private Long facturaId;
    private Long ordenDespachoId;

    @Override
    public int hashCode() {
        return (int) (facturaId + ordenDespachoId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof FacturaOrdenDespachoEntityId) {
            FacturaOrdenDespachoEntityId otherId = (FacturaOrdenDespachoEntityId) object;
            return (otherId.facturaId == this.facturaId) && (otherId.ordenDespachoId == this.ordenDespachoId);
        }
        return false;
    }

}
