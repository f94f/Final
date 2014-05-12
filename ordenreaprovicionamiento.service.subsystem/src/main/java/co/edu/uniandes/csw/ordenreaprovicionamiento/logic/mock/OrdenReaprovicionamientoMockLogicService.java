
package co.edu.uniandes.csw.ordenreaprovicionamiento.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.api.IOrdenReaprovicionamientoLogicService;

@Alternative
@Singleton
public class OrdenReaprovicionamientoMockLogicService extends _OrdenReaprovicionamientoMockLogicService implements IOrdenReaprovicionamientoLogicService {
	
}