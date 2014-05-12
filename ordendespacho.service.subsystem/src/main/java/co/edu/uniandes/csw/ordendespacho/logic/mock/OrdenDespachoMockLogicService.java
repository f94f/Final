
package co.edu.uniandes.csw.ordendespacho.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.ordendespacho.logic.api.IOrdenDespachoLogicService;

@Alternative
@Singleton
public class OrdenDespachoMockLogicService extends _OrdenDespachoMockLogicService implements IOrdenDespachoLogicService {
	
}