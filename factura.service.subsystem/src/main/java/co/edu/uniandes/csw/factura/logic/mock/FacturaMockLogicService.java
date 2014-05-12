
package co.edu.uniandes.csw.factura.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.factura.logic.api.IFacturaLogicService;

@Alternative
@Singleton
public class FacturaMockLogicService extends _FacturaMockLogicService implements IFacturaLogicService {
	
}