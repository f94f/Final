package co.edu.uniandes.csw.factura.master.persistence.api;

import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenReaprovicionamientoEntity;
import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenFabricacionEntity;
import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.factura.master.persistence.entity.FacturaOrdenDespachoEntity;
import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.factura.master.logic.dto.FacturaMasterDTO;
import java.util.List;

public interface _IFacturaMasterPersistence {

    public FacturaOrdenReaprovicionamientoEntity createFacturaOrdenReaprovicionamiento(FacturaOrdenReaprovicionamientoEntity entity);

    public void deleteFacturaOrdenReaprovicionamiento(Long facturaId, Long ordenReaprovicionamientoId);
    
    public List<OrdenReaprovicionamientoDTO> getOrdenReaprovicionamientoListForFactura(Long facturaId);
    public FacturaOrdenFabricacionEntity createFacturaOrdenFabricacion(FacturaOrdenFabricacionEntity entity);

    public void deleteFacturaOrdenFabricacion(Long facturaId, Long ordenFabricacionId);
    
    public List<OrdenFabricacionDTO> getOrdenFabricacionListForFactura(Long facturaId);
    public FacturaOrdenDespachoEntity createFacturaOrdenDespacho(FacturaOrdenDespachoEntity entity);

    public void deleteFacturaOrdenDespacho(Long facturaId, Long ordenDespachoId);
    
    public List<OrdenDespachoDTO> getOrdenDespachoListForFactura(Long facturaId);
    
    public FacturaMasterDTO getFactura(Long facturaId);

}
