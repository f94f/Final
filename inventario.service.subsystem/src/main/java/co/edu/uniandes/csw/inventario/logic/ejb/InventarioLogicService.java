
package co.edu.uniandes.csw.inventario.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.inventario.logic.api.IInventarioLogicService;

@Default
@Stateless
@LocalBean
public class InventarioLogicService extends _InventarioLogicService implements IInventarioLogicService {

}