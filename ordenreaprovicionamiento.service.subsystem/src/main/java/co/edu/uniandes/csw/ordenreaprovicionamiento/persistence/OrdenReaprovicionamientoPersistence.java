
package co.edu.uniandes.csw.ordenreaprovicionamiento.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.api.IOrdenReaprovicionamientoPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class OrdenReaprovicionamientoPersistence extends _OrdenReaprovicionamientoPersistence  implements IOrdenReaprovicionamientoPersistence {

}