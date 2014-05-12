package co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.entity;

import co.edu.uniandes.csw.proveedor.persistence.entity.ProveedorEntity;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.entity.OrdenReaprovicionamientoEntity;
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
@IdClass(OrdenReaprovicionamientoProveedorEntityId.class)
@NamedQueries({
    @NamedQuery(name = "OrdenReaprovicionamientoProveedorEntity.getProveedorListForOrdenReaprovicionamiento", query = "SELECT  u FROM OrdenReaprovicionamientoProveedorEntity u WHERE u.ordenreaprovicionamientoId=:ordenreaprovicionamientoId"),
    @NamedQuery(name = "OrdenReaprovicionamientoProveedorEntity.deleteOrdenReaprovicionamientoProveedor", query = "DELETE FROM OrdenReaprovicionamientoProveedorEntity u WHERE u.proveedorId=:proveedorId and  u.ordenreaprovicionamientoId=:ordenreaprovicionamientoId")
})
public class OrdenReaprovicionamientoProveedorEntity implements Serializable {

    @Id
    @Column(name = "ordenreaprovicionamientoId")
    private Long ordenreaprovicionamientoId;
    @Id
    @Column(name = "proveedorId")
    private Long proveedorId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "proveedorId", referencedColumnName = "id")
    @JoinFetch
    private ProveedorEntity proveedorEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "ordenreaprovicionamientoId", referencedColumnName = "id")
    @JoinFetch
    private OrdenReaprovicionamientoEntity ordenreaprovicionamientoEntity;

    public OrdenReaprovicionamientoProveedorEntity() {
    }

    public OrdenReaprovicionamientoProveedorEntity(Long ordenreaprovicionamientoId, Long proveedorId) {
        this.ordenreaprovicionamientoId = ordenreaprovicionamientoId;
        this.proveedorId = proveedorId;
    }

    public Long getOrdenReaprovicionamientoId() {
        return ordenreaprovicionamientoId;
    }

    public void setOrdenReaprovicionamientoId(Long ordenreaprovicionamientoId) {
        this.ordenreaprovicionamientoId = ordenreaprovicionamientoId;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public ProveedorEntity getProveedorEntity() {
        return proveedorEntity;
    }

    public void setProveedorEntity(ProveedorEntity proveedorEntity) {
        this.proveedorEntity = proveedorEntity;
    }

    public OrdenReaprovicionamientoEntity getOrdenReaprovicionamientoEntity() {
        return ordenreaprovicionamientoEntity;
    }

    public void setOrdenReaprovicionamientoEntity(OrdenReaprovicionamientoEntity ordenreaprovicionamientoEntity) {
        this.ordenreaprovicionamientoEntity = ordenreaprovicionamientoEntity;
    }

}
