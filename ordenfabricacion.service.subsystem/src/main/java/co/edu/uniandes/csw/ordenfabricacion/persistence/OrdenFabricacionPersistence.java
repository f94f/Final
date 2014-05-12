
package co.edu.uniandes.csw.ordenfabricacion.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.ordenfabricacion.persistence.api.IOrdenFabricacionPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class OrdenFabricacionPersistence extends _OrdenFabricacionPersistence  implements IOrdenFabricacionPersistence {

}