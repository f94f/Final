package co.edu.uniandes.csw.ordendespacho.master.logic.dto;

import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class _OrdenDespachoMasterDTO {

 
    @XmlAttribute(name = "ordendespachoEntity")
    protected OrdenDespachoDTO ordendespachoEntity;
    protected Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public OrdenDespachoDTO getOrdenDespachoEntity() {
        return ordendespachoEntity;
    }

    public void setOrdenDespachoEntity(OrdenDespachoDTO ordendespachoEntity) {
        this.ordendespachoEntity = ordendespachoEntity;
    }
    
    public List<ItemDTO> createItem;
    public List<ItemDTO> updateItem;
    public List<ItemDTO> deleteItem;
    public List<ItemDTO> listItem;	
	
	
	
    public List<ItemDTO> getCreateItem(){ return createItem; };
    public void setCreateItem(List<ItemDTO> createItem){ this.createItem=createItem; };
    public List<ItemDTO> getUpdateItem(){ return updateItem; };
    public void setUpdateItem(List<ItemDTO> updateItem){ this.updateItem=updateItem; };
    public List<ItemDTO> getDeleteItem(){ return deleteItem; };
    public void setDeleteItem(List<ItemDTO> deleteItem){ this.deleteItem=deleteItem; };
    public List<ItemDTO> getListItem(){ return listItem; };
    public void setListItem(List<ItemDTO> listItem){ this.listItem=listItem; };	
	
	
}

