package co.edu.uniandes.csw.inventario.master.logic.ejb;

import co.edu.uniandes.csw.inventario.master.logic.api.IInventarioMasterLogicService;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Default
@Stateless
@LocalBean
public class InventarioMasterLogicService extends _InventarioMasterLogicService implements IInventarioMasterLogicService {

}