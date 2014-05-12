package co.edu.uniandes.csw.ordendespacho.master.logic.ejb;

import co.edu.uniandes.csw.ordendespacho.master.logic.api.IOrdenDespachoMasterLogicService;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Default
@Stateless
@LocalBean
public class OrdenDespachoMasterLogicService extends _OrdenDespachoMasterLogicService implements IOrdenDespachoMasterLogicService {

}