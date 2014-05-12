package co.edu.uniandes.csw.factura.master.persistence.entity;

import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.entity.OrdenReaprovicionamientoEntity;
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
@IdClass(FacturaOrdenReaprovicionamientoEntityId.class)
@NamedQueries({
    @NamedQuery(name = "FacturaOrdenReaprovicionamientoEntity.getOrdenReaprovicionamientoListForFactura", query = "SELECT  u FROM FacturaOrdenReaprovicionamientoEntity u WHERE u.facturaId=:facturaId"),
    @NamedQuery(name = "FacturaOrdenReaprovicionamientoEntity.deleteFacturaOrdenReaprovicionamiento", query = "DELETE FROM FacturaOrdenReaprovicionamientoEntity u WHERE u.ordenReaprovicionamientoId=:ordenReaprovicionamientoId and  u.facturaId=:facturaId")
})
public class FacturaOrdenReaprovicionamientoEntity implements Serializable {

    @Id
    @Column(name = "facturaId")
    private Long facturaId;
    @Id
    @Column(name = "ordenReaprovicionamientoId")
    private Long ordenReaprovicionamientoId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "ordenReaprovicionamientoId", referencedColumnName = "id")
    @JoinFetch
    private OrdenReaprovicionamientoEntity ordenReaprovicionamientoEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "facturaId", referencedColumnName = "id")
    @JoinFetch
    private FacturaEntity facturaEntity;

    public FacturaOrdenReaprovicionamientoEntity() {
    }

    public FacturaOrdenReaprovicionamientoEntity(Long facturaId, Long ordenReaprovicionamientoId) {
        this.facturaId = facturaId;
        this.ordenReaprovicionamientoId = ordenReaprovicionamientoId;
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public Long getOrdenReaprovicionamientoId() {
        return ordenReaprovicionamientoId;
    }

    public void setOrdenReaprovicionamientoId(Long ordenReaprovicionamientoId) {
        this.ordenReaprovicionamientoId = ordenReaprovicionamientoId;
    }

    public OrdenReaprovicionamientoEntity getOrdenReaprovicionamientoEntity() {
        return ordenReaprovicionamientoEntity;
    }

    public void setOrdenReaprovicionamientoEntity(OrdenReaprovicionamientoEntity ordenReaprovicionamientoEntity) {
        this.ordenReaprovicionamientoEntity = ordenReaprovicionamientoEntity;
    }

    public FacturaEntity getFacturaEntity() {
        return facturaEntity;
    }

    public void setFacturaEntity(FacturaEntity facturaEntity) {
        this.facturaEntity = facturaEntity;
    }

}
