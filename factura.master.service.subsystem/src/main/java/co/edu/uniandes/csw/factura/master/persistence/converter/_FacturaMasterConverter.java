package co.edu.uniandes.csw.factura.master.persistence.converter;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenReaprovicionamientoEntity;
import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.converter.OrdenReaprovicionamientoConverter;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenFabricacionEntity;
import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordenfabricacion.persistence.converter.OrdenFabricacionConverter;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenDespachoEntity;
import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.ordendespacho.persistence.converter.OrdenDespachoConverter;
import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.factura.master.logic.dto.FacturaMasterDTO;
import co.edu.uniandes.csw.factura.persistence.converter.FacturaConverter;
import co.edu.uniandes.csw.factura.persistence.entity.FacturaEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class _FacturaMasterConverter {

    public static FacturaMasterDTO entity2PersistenceDTO(FacturaEntity facturaEntity 
    ,List<FacturaOrdenReaprovicionamientoEntity> facturaOrdenReaprovicionamientoEntity 
    ,List<FacturaOrdenFabricacionEntity> facturaOrdenFabricacionEntity 
    ,List<FacturaOrdenDespachoEntity> facturaOrdenDespachoEntity 
    ) {
        FacturaDTO facturaDTO = FacturaConverter.entity2PersistenceDTO(facturaEntity);
        ArrayList<OrdenReaprovicionamientoDTO> ordenReaprovicionamientoEntities = new ArrayList<OrdenReaprovicionamientoDTO>(facturaOrdenReaprovicionamientoEntity.size());
        for (FacturaOrdenReaprovicionamientoEntity facturaOrdenReaprovicionamiento : facturaOrdenReaprovicionamientoEntity) {
            ordenReaprovicionamientoEntities.add(OrdenReaprovicionamientoConverter.entity2PersistenceDTO(facturaOrdenReaprovicionamiento.getOrdenReaprovicionamientoEntity()));
        }
        ArrayList<OrdenFabricacionDTO> ordenFabricacionEntities = new ArrayList<OrdenFabricacionDTO>(facturaOrdenFabricacionEntity.size());
        for (FacturaOrdenFabricacionEntity facturaOrdenFabricacion : facturaOrdenFabricacionEntity) {
            ordenFabricacionEntities.add(OrdenFabricacionConverter.entity2PersistenceDTO(facturaOrdenFabricacion.getOrdenFabricacionEntity()));
        }
        ArrayList<OrdenDespachoDTO> ordenDespachoEntities = new ArrayList<OrdenDespachoDTO>(facturaOrdenDespachoEntity.size());
        for (FacturaOrdenDespachoEntity facturaOrdenDespacho : facturaOrdenDespachoEntity) {
            ordenDespachoEntities.add(OrdenDespachoConverter.entity2PersistenceDTO(facturaOrdenDespacho.getOrdenDespachoEntity()));
        }
        FacturaMasterDTO respDTO  = new FacturaMasterDTO();
        respDTO.setFacturaEntity(facturaDTO);
        respDTO.setListOrdenReaprovicionamiento(ordenReaprovicionamientoEntities);
        respDTO.setListOrdenFabricacion(ordenFabricacionEntities);
        respDTO.setListOrdenDespacho(ordenDespachoEntities);
        return respDTO;
    }

}