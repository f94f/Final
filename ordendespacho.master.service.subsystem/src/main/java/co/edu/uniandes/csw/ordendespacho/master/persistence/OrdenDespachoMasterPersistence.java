package co.edu.uniandes.csw.ordendespacho.master.persistence;

import javax.ejb.Stateless;

import co.edu.uniandes.csw.ordendespacho.master.persistence.api.IOrdenDespachoMasterPersistence;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Default;

@Default
@Stateless 
@LocalBean
public class OrdenDespachoMasterPersistence extends _OrdenDespachoMasterPersistence  implements IOrdenDespachoMasterPersistence {

}