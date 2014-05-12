package co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.entity;

import co.edu.uniandes.csw.producto.persistence.entity.ProductoEntity;
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
@IdClass(OrdenReaprovicionamientoProductoEntityId.class)
@NamedQueries({
    @NamedQuery(name = "OrdenReaprovicionamientoProductoEntity.getProductoListForOrdenReaprovicionamiento", query = "SELECT  u FROM OrdenReaprovicionamientoProductoEntity u WHERE u.ordenreaprovicionamientoId=:ordenreaprovicionamientoId"),
    @NamedQuery(name = "OrdenReaprovicionamientoProductoEntity.deleteOrdenReaprovicionamientoProducto", query = "DELETE FROM OrdenReaprovicionamientoProductoEntity u WHERE u.productoId=:productoId and  u.ordenreaprovicionamientoId=:ordenreaprovicionamientoId")
})
public class OrdenReaprovicionamientoProductoEntity implements Serializable {

    @Id
    @Column(name = "ordenreaprovicionamientoId")
    private Long ordenreaprovicionamientoId;
    @Id
    @Column(name = "productoId")
    private Long productoId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "productoId", referencedColumnName = "id")
    @JoinFetch
    private ProductoEntity productoEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "ordenreaprovicionamientoId", referencedColumnName = "id")
    @JoinFetch
    private OrdenReaprovicionamientoEntity ordenreaprovicionamientoEntity;

    public OrdenReaprovicionamientoProductoEntity() {
    }

    public OrdenReaprovicionamientoProductoEntity(Long ordenreaprovicionamientoId, Long productoId) {
        this.ordenreaprovicionamientoId = ordenreaprovicionamientoId;
        this.productoId = productoId;
    }

    public Long getOrdenReaprovicionamientoId() {
        return ordenreaprovicionamientoId;
    }

    public void setOrdenReaprovicionamientoId(Long ordenreaprovicionamientoId) {
        this.ordenreaprovicionamientoId = ordenreaprovicionamientoId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public ProductoEntity getProductoEntity() {
        return productoEntity;
    }

    public void setProductoEntity(ProductoEntity productoEntity) {
        this.productoEntity = productoEntity;
    }

    public OrdenReaprovicionamientoEntity getOrdenReaprovicionamientoEntity() {
        return ordenreaprovicionamientoEntity;
    }

    public void setOrdenReaprovicionamientoEntity(OrdenReaprovicionamientoEntity ordenreaprovicionamientoEntity) {
        this.ordenreaprovicionamientoEntity = ordenreaprovicionamientoEntity;
    }

}
