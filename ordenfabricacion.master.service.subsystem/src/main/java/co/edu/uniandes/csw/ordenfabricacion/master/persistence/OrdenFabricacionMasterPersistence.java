package co.edu.uniandes.csw.ordenfabricacion.master.persistence;

import javax.ejb.Stateless;

import co.edu.uniandes.csw.ordenfabricacion.master.persistence.api.IOrdenFabricacionMasterPersistence;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Default;

@Default
@Stateless 
@LocalBean
public class OrdenFabricacionMasterPersistence extends _OrdenFabricacionMasterPersistence  implements IOrdenFabricacionMasterPersistence {

}