
package co.edu.uniandes.csw.ordenreaprovicionamiento.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.api.IOrdenReaprovicionamientoLogicService;

@Default
@Stateless
@LocalBean
public class OrdenReaprovicionamientoLogicService extends _OrdenReaprovicionamientoLogicService implements IOrdenReaprovicionamientoLogicService {

}