package co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence;

import javax.ejb.Stateless;

import co.edu.uniandes.csw.ordenreaprovicionamiento.master.persistence.api.IOrdenReaprovicionamientoMasterPersistence;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Default;

@Default
@Stateless 
@LocalBean
public class OrdenReaprovicionamientoMasterPersistence extends _OrdenReaprovicionamientoMasterPersistence  implements IOrdenReaprovicionamientoMasterPersistence {

}