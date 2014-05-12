package co.edu.uniandes.csw.ordenreaprovicionamiento.master.logic.dto;

import co.edu.uniandes.csw.proveedor.logic.dto.ProveedorDTO;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class _OrdenReaprovicionamientoMasterDTO {

 
    @XmlAttribute(name = "ordenreaprovicionamientoEntity")
    protected OrdenReaprovicionamientoDTO ordenreaprovicionamientoEntity;
    protected Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public OrdenReaprovicionamientoDTO getOrdenReaprovicionamientoEntity() {
        return ordenreaprovicionamientoEntity;
    }

    public void setOrdenReaprovicionamientoEntity(OrdenReaprovicionamientoDTO ordenreaprovicionamientoEntity) {
        this.ordenreaprovicionamientoEntity = ordenreaprovicionamientoEntity;
    }
    
    public List<ProveedorDTO> createProveedor;
    public List<ProveedorDTO> updateProveedor;
    public List<ProveedorDTO> deleteProveedor;
    public List<ProveedorDTO> listProveedor;	
    public List<ProductoDTO> createProducto;
    public List<ProductoDTO> updateProducto;
    public List<ProductoDTO> deleteProducto;
    public List<ProductoDTO> listProducto;	
	
	
	
    public List<ProveedorDTO> getCreateProveedor(){ return createProveedor; };
    public void setCreateProveedor(List<ProveedorDTO> createProveedor){ this.createProveedor=createProveedor; };
    public List<ProveedorDTO> getUpdateProveedor(){ return updateProveedor; };
    public void setUpdateProveedor(List<ProveedorDTO> updateProveedor){ this.updateProveedor=updateProveedor; };
    public List<ProveedorDTO> getDeleteProveedor(){ return deleteProveedor; };
    public void setDeleteProveedor(List<ProveedorDTO> deleteProveedor){ this.deleteProveedor=deleteProveedor; };
    public List<ProveedorDTO> getListProveedor(){ return listProveedor; };
    public void setListProveedor(List<ProveedorDTO> listProveedor){ this.listProveedor=listProveedor; };	
    public List<ProductoDTO> getCreateProducto(){ return createProducto; };
    public void setCreateProducto(List<ProductoDTO> createProducto){ this.createProducto=createProducto; };
    public List<ProductoDTO> getUpdateProducto(){ return updateProducto; };
    public void setUpdateProducto(List<ProductoDTO> updateProducto){ this.updateProducto=updateProducto; };
    public List<ProductoDTO> getDeleteProducto(){ return deleteProducto; };
    public void setDeleteProducto(List<ProductoDTO> deleteProducto){ this.deleteProducto=deleteProducto; };
    public List<ProductoDTO> getListProducto(){ return listProducto; };
    public void setListProducto(List<ProductoDTO> listProducto){ this.listProducto=listProducto; };	
	
	
}

