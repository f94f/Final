package co.edu.uniandes.csw.factura.master.persistence.entity;

import co.edu.uniandes.csw.ordenfabricacion.persistence.entity.OrdenFabricacionEntity;
import co.edu.uniandes.csw.factura.persistence.entity.FacturaEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.eclipse.persistence.annotations.JoinFetch;

@Entity
@IdClass(FacturaOrdenFabricacionEntityId.class)
@NamedQueries({
    @NamedQuery(name = "FacturaOrdenFabricacionEntity.getOrdenFabricacionListForFactura", query = "SELECT  u FROM FacturaOrdenFabricacionEntity u WHERE u.facturaId=:facturaId"),
    @NamedQuery(name = "FacturaOrdenFabricacionEntity.deleteFacturaOrdenFabricacion", query = "DELETE FROM FacturaOrdenFabricacionEntity u WHERE u.ordenFabricacionId=:ordenFabricacionId and  u.facturaId=:facturaId")
})
public class FacturaOrdenFabricacionEntity implements Serializable {

    @Id
    @Column(name = "facturaId")
    private Long facturaId;
    @Id
    @Column(name = "ordenFabricacionId")
    private Long ordenFabricacionId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "ordenFabricacionId", referencedColumnName = "id")
    @JoinFetch
    private OrdenFabricacionEntity ordenFabricacionEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "facturaId", referencedColumnName = "id")
    @JoinFetch
    private FacturaEntity facturaEntity;

    public FacturaOrdenFabricacionEntity() {
    }

    public FacturaOrdenFabricacionEntity(Long facturaId, Long ordenFabricacionId) {
        this.facturaId = facturaId;
        this.ordenFabricacionId = ordenFabricacionId;
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public Long getOrdenFabricacionId() {
        return ordenFabricacionId;
    }

    public void setOrdenFabricacionId(Long ordenFabricacionId) {
        this.ordenFabricacionId = ordenFabricacionId;
    }

    public OrdenFabricacionEntity getOrdenFabricacionEntity() {
        return ordenFabricacionEntity;
    }

    public void setOrdenFabricacionEntity(OrdenFabricacionEntity ordenFabricacionEntity) {
        this.ordenFabricacionEntity = ordenFabricacionEntity;
    }

    public FacturaEntity getFacturaEntity() {
        return facturaEntity;
    }

    public void setFacturaEntity(FacturaEntity facturaEntity) {
        this.facturaEntity = facturaEntity;
    }

}
