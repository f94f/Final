
package co.edu.uniandes.csw.ordenfabricacion.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.ordenfabricacion.logic.api.IOrdenFabricacionLogicService;

@Alternative
@Singleton
public class OrdenFabricacionMockLogicService extends _OrdenFabricacionMockLogicService implements IOrdenFabricacionLogicService {
	
}