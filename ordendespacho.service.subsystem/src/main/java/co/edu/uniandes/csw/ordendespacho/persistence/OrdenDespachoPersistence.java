
package co.edu.uniandes.csw.ordendespacho.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.ordendespacho.persistence.api.IOrdenDespachoPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class OrdenDespachoPersistence extends _OrdenDespachoPersistence  implements IOrdenDespachoPersistence {

}