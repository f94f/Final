package co.edu.uniandes.csw.factura.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class FacturaOrdenFabricacionEntityId implements Serializable{

    private Long facturaId;
    private Long ordenFabricacionId;

    @Override
    public int hashCode() {
        return (int) (facturaId + ordenFabricacionId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof FacturaOrdenFabricacionEntityId) {
            FacturaOrdenFabricacionEntityId otherId = (FacturaOrdenFabricacionEntityId) object;
            return (otherId.facturaId == this.facturaId) && (otherId.ordenFabricacionId == this.ordenFabricacionId);
        }
        return false;
    }

}
