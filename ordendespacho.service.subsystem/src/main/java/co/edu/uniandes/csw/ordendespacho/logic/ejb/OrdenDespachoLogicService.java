
package co.edu.uniandes.csw.ordendespacho.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.ordendespacho.logic.api.IOrdenDespachoLogicService;

@Default
@Stateless
@LocalBean
public class OrdenDespachoLogicService extends _OrdenDespachoLogicService implements IOrdenDespachoLogicService {

}