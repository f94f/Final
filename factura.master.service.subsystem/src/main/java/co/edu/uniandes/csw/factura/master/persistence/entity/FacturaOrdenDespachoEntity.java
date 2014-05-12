package co.edu.uniandes.csw.factura.master.persistence.entity;

import co.edu.uniandes.csw.ordendespacho.persistence.entity.OrdenDespachoEntity;
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
@IdClass(FacturaOrdenDespachoEntityId.class)
@NamedQueries({
    @NamedQuery(name = "FacturaOrdenDespachoEntity.getOrdenDespachoListForFactura", query = "SELECT  u FROM FacturaOrdenDespachoEntity u WHERE u.facturaId=:facturaId"),
    @NamedQuery(name = "FacturaOrdenDespachoEntity.deleteFacturaOrdenDespacho", query = "DELETE FROM FacturaOrdenDespachoEntity u WHERE u.ordenDespachoId=:ordenDespachoId and  u.facturaId=:facturaId")
})
public class FacturaOrdenDespachoEntity implements Serializable {

    @Id
    @Column(name = "facturaId")
    private Long facturaId;
    @Id
    @Column(name = "ordenDespachoId")
    private Long ordenDespachoId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "ordenDespachoId", referencedColumnName = "id")
    @JoinFetch
    private OrdenDespachoEntity ordenDespachoEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "facturaId", referencedColumnName = "id")
    @JoinFetch
    private FacturaEntity facturaEntity;

    public FacturaOrdenDespachoEntity() {
    }

    public FacturaOrdenDespachoEntity(Long facturaId, Long ordenDespachoId) {
        this.facturaId = facturaId;
        this.ordenDespachoId = ordenDespachoId;
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public Long getOrdenDespachoId() {
        return ordenDespachoId;
    }

    public void setOrdenDespachoId(Long ordenDespachoId) {
        this.ordenDespachoId = ordenDespachoId;
    }

    public OrdenDespachoEntity getOrdenDespachoEntity() {
        return ordenDespachoEntity;
    }

    public void setOrdenDespachoEntity(OrdenDespachoEntity ordenDespachoEntity) {
        this.ordenDespachoEntity = ordenDespachoEntity;
    }

    public FacturaEntity getFacturaEntity() {
        return facturaEntity;
    }

    public void setFacturaEntity(FacturaEntity facturaEntity) {
        this.facturaEntity = facturaEntity;
    }

}
