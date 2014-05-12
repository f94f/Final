package co.edu.uniandes.csw.factura.master.logic.dto;

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class _FacturaMasterDTO {

 
    @XmlAttribute(name = "facturaEntity")
    protected FacturaDTO facturaEntity;
    protected Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public FacturaDTO getFacturaEntity() {
        return facturaEntity;
    }

    public void setFacturaEntity(FacturaDTO facturaEntity) {
        this.facturaEntity = facturaEntity;
    }
    
    public List<OrdenReaprovicionamientoDTO> createOrdenReaprovicionamiento;
    public List<OrdenReaprovicionamientoDTO> updateOrdenReaprovicionamiento;
    public List<OrdenReaprovicionamientoDTO> deleteOrdenReaprovicionamiento;
    public List<OrdenReaprovicionamientoDTO> listOrdenReaprovicionamiento;	
    public List<OrdenFabricacionDTO> createOrdenFabricacion;
    public List<OrdenFabricacionDTO> updateOrdenFabricacion;
    public List<OrdenFabricacionDTO> deleteOrdenFabricacion;
    public List<OrdenFabricacionDTO> listOrdenFabricacion;	
    public List<OrdenDespachoDTO> createOrdenDespacho;
    public List<OrdenDespachoDTO> updateOrdenDespacho;
    public List<OrdenDespachoDTO> deleteOrdenDespacho;
    public List<OrdenDespachoDTO> listOrdenDespacho;	
	
	
	
    public List<OrdenReaprovicionamientoDTO> getCreateOrdenReaprovicionamiento(){ return createOrdenReaprovicionamiento; };
    public void setCreateOrdenReaprovicionamiento(List<OrdenReaprovicionamientoDTO> createOrdenReaprovicionamiento){ this.createOrdenReaprovicionamiento=createOrdenReaprovicionamiento; };
    public List<OrdenReaprovicionamientoDTO> getUpdateOrdenReaprovicionamiento(){ return updateOrdenReaprovicionamiento; };
    public void setUpdateOrdenReaprovicionamiento(List<OrdenReaprovicionamientoDTO> updateOrdenReaprovicionamiento){ this.updateOrdenReaprovicionamiento=updateOrdenReaprovicionamiento; };
    public List<OrdenReaprovicionamientoDTO> getDeleteOrdenReaprovicionamiento(){ return deleteOrdenReaprovicionamiento; };
    public void setDeleteOrdenReaprovicionamiento(List<OrdenReaprovicionamientoDTO> deleteOrdenReaprovicionamiento){ this.deleteOrdenReaprovicionamiento=deleteOrdenReaprovicionamiento; };
    public List<OrdenReaprovicionamientoDTO> getListOrdenReaprovicionamiento(){ return listOrdenReaprovicionamiento; };
    public void setListOrdenReaprovicionamiento(List<OrdenReaprovicionamientoDTO> listOrdenReaprovicionamiento){ this.listOrdenReaprovicionamiento=listOrdenReaprovicionamiento; };	
    public List<OrdenFabricacionDTO> getCreateOrdenFabricacion(){ return createOrdenFabricacion; };
    public void setCreateOrdenFabricacion(List<OrdenFabricacionDTO> createOrdenFabricacion){ this.createOrdenFabricacion=createOrdenFabricacion; };
    public List<OrdenFabricacionDTO> getUpdateOrdenFabricacion(){ return updateOrdenFabricacion; };
    public void setUpdateOrdenFabricacion(List<OrdenFabricacionDTO> updateOrdenFabricacion){ this.updateOrdenFabricacion=updateOrdenFabricacion; };
    public List<OrdenFabricacionDTO> getDeleteOrdenFabricacion(){ return deleteOrdenFabricacion; };
    public void setDeleteOrdenFabricacion(List<OrdenFabricacionDTO> deleteOrdenFabricacion){ this.deleteOrdenFabricacion=deleteOrdenFabricacion; };
    public List<OrdenFabricacionDTO> getListOrdenFabricacion(){ return listOrdenFabricacion; };
    public void setListOrdenFabricacion(List<OrdenFabricacionDTO> listOrdenFabricacion){ this.listOrdenFabricacion=listOrdenFabricacion; };	
    public List<OrdenDespachoDTO> getCreateOrdenDespacho(){ return createOrdenDespacho; };
    public void setCreateOrdenDespacho(List<OrdenDespachoDTO> createOrdenDespacho){ this.createOrdenDespacho=createOrdenDespacho; };
    public List<OrdenDespachoDTO> getUpdateOrdenDespacho(){ return updateOrdenDespacho; };
    public void setUpdateOrdenDespacho(List<OrdenDespachoDTO> updateOrdenDespacho){ this.updateOrdenDespacho=updateOrdenDespacho; };
    public List<OrdenDespachoDTO> getDeleteOrdenDespacho(){ return deleteOrdenDespacho; };
    public void setDeleteOrdenDespacho(List<OrdenDespachoDTO> deleteOrdenDespacho){ this.deleteOrdenDespacho=deleteOrdenDespacho; };
    public List<OrdenDespachoDTO> getListOrdenDespacho(){ return listOrdenDespacho; };
    public void setListOrdenDespacho(List<OrdenDespachoDTO> listOrdenDespacho){ this.listOrdenDespacho=listOrdenDespacho; };	
	
	
}

