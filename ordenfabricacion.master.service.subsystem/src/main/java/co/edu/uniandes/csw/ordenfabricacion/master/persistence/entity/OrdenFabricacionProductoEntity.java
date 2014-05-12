package co.edu.uniandes.csw.ordenfabricacion.master.persistence.entity;

import co.edu.uniandes.csw.producto.persistence.entity.ProductoEntity;
import co.edu.uniandes.csw.ordenfabricacion.persistence.entity.OrdenFabricacionEntity;
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
@IdClass(OrdenFabricacionProductoEntityId.class)
@NamedQueries({
    @NamedQuery(name = "OrdenFabricacionProductoEntity.getProductoListForOrdenFabricacion", query = "SELECT  u FROM OrdenFabricacionProductoEntity u WHERE u.ordenfabricacionId=:ordenfabricacionId"),
    @NamedQuery(name = "OrdenFabricacionProductoEntity.deleteOrdenFabricacionProducto", query = "DELETE FROM OrdenFabricacionProductoEntity u WHERE u.productoId=:productoId and  u.ordenfabricacionId=:ordenfabricacionId")
})
public class OrdenFabricacionProductoEntity implements Serializable {

    @Id
    @Column(name = "ordenfabricacionId")
    private Long ordenfabricacionId;
    @Id
    @Column(name = "productoId")
    private Long productoId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "productoId", referencedColumnName = "id")
    @JoinFetch
    private ProductoEntity productoEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "ordenfabricacionId", referencedColumnName = "id")
    @JoinFetch
    private OrdenFabricacionEntity ordenfabricacionEntity;

    public OrdenFabricacionProductoEntity() {
    }

    public OrdenFabricacionProductoEntity(Long ordenfabricacionId, Long productoId) {
        this.ordenfabricacionId = ordenfabricacionId;
        this.productoId = productoId;
    }

    public Long getOrdenFabricacionId() {
        return ordenfabricacionId;
    }

    public void setOrdenFabricacionId(Long ordenfabricacionId) {
        this.ordenfabricacionId = ordenfabricacionId;
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

    public OrdenFabricacionEntity getOrdenFabricacionEntity() {
        return ordenfabricacionEntity;
    }

    public void setOrdenFabricacionEntity(OrdenFabricacionEntity ordenfabricacionEntity) {
        this.ordenfabricacionEntity = ordenfabricacionEntity;
    }

}
