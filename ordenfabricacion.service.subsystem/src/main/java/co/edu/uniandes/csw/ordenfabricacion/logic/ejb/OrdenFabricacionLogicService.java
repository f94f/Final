
package co.edu.uniandes.csw.ordenfabricacion.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.ordenfabricacion.logic.api.IOrdenFabricacionLogicService;

@Default
@Stateless
@LocalBean
public class OrdenFabricacionLogicService extends _OrdenFabricacionLogicService implements IOrdenFabricacionLogicService {

}