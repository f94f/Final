package co.edu.uniandes.csw.inventario.master.persistence.entity;

import co.edu.uniandes.csw.item.persistence.entity.ItemEntity;
import co.edu.uniandes.csw.inventario.persistence.entity.InventarioEntity;
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
@IdClass(InventarioItemEntityId.class)
@NamedQueries({
    @NamedQuery(name = "InventarioItemEntity.getItemListForInventario", query = "SELECT  u FROM InventarioItemEntity u WHERE u.inventarioId=:inventarioId"),
    @NamedQuery(name = "InventarioItemEntity.deleteInventarioItem", query = "DELETE FROM InventarioItemEntity u WHERE u.itemId=:itemId and  u.inventarioId=:inventarioId")
})
public class InventarioItemEntity implements Serializable {

    @Id
    @Column(name = "inventarioId")
    private Long inventarioId;
    @Id
    @Column(name = "itemId")
    private Long itemId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "itemId", referencedColumnName = "id")
    @JoinFetch
    private ItemEntity itemEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "inventarioId", referencedColumnName = "id")
    @JoinFetch
    private InventarioEntity inventarioEntity;

    public InventarioItemEntity() {
    }

    public InventarioItemEntity(Long inventarioId, Long itemId) {
        this.inventarioId = inventarioId;
        this.itemId = itemId;
    }

    public Long getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(Long inventarioId) {
        this.inventarioId = inventarioId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public ItemEntity getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(ItemEntity itemEntity) {
        this.itemEntity = itemEntity;
    }

    public InventarioEntity getInventarioEntity() {
        return inventarioEntity;
    }

    public void setInventarioEntity(InventarioEntity inventarioEntity) {
        this.inventarioEntity = inventarioEntity;
    }

}
