
package co.edu.uniandes.csw.factura.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.factura.logic.api.IFacturaLogicService;

@Default
@Stateless
@LocalBean
public class FacturaLogicService extends _FacturaLogicService implements IFacturaLogicService {

}