package co.edu.uniandes.csw.ordendespacho.master.persistence.entity;

import co.edu.uniandes.csw.item.persistence.entity.ItemEntity;
import co.edu.uniandes.csw.ordendespacho.persistence.entity.OrdenDespachoEntity;
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
@IdClass(OrdenDespachoItemEntityId.class)
@NamedQueries({
    @NamedQuery(name = "OrdenDespachoItemEntity.getItemListForOrdenDespacho", query = "SELECT  u FROM OrdenDespachoItemEntity u WHERE u.ordendespachoId=:ordendespachoId"),
    @NamedQuery(name = "OrdenDespachoItemEntity.deleteOrdenDespachoItem", query = "DELETE FROM OrdenDespachoItemEntity u WHERE u.itemId=:itemId and  u.ordendespachoId=:ordendespachoId")
})
public class OrdenDespachoItemEntity implements Serializable {

    @Id
    @Column(name = "ordendespachoId")
    private Long ordendespachoId;
    @Id
    @Column(name = "itemId")
    private Long itemId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "itemId", referencedColumnName = "id")
    @JoinFetch
    private ItemEntity itemEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "ordendespachoId", referencedColumnName = "id")
    @JoinFetch
    private OrdenDespachoEntity ordendespachoEntity;

    public OrdenDespachoItemEntity() {
    }

    public OrdenDespachoItemEntity(Long ordendespachoId, Long itemId) {
        this.ordendespachoId = ordendespachoId;
        this.itemId = itemId;
    }

    public Long getOrdenDespachoId() {
        return ordendespachoId;
    }

    public void setOrdenDespachoId(Long ordendespachoId) {
        this.ordendespachoId = ordendespachoId;
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

    public OrdenDespachoEntity getOrdenDespachoEntity() {
        return ordendespachoEntity;
    }

    public void setOrdenDespachoEntity(OrdenDespachoEntity ordendespachoEntity) {
        this.ordendespachoEntity = ordendespachoEntity;
    }

}
