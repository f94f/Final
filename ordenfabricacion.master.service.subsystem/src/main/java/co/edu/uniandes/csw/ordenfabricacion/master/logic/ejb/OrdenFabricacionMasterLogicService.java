package co.edu.uniandes.csw.ordenfabricacion.master.logic.ejb;

import co.edu.uniandes.csw.ordenfabricacion.master.logic.api.IOrdenFabricacionMasterLogicService;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Default
@Stateless
@LocalBean
public class OrdenFabricacionMasterLogicService extends _OrdenFabricacionMasterLogicService implements IOrdenFabricacionMasterLogicService {

}