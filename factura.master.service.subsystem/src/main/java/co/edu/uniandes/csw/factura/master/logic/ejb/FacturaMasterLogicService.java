package co.edu.uniandes.csw.factura.master.logic.ejb;

import co.edu.uniandes.csw.factura.master.logic.api.IFacturaMasterLogicService;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Default
@Stateless
@LocalBean
public class FacturaMasterLogicService extends _FacturaMasterLogicService implements IFacturaMasterLogicService {

}