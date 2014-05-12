
package co.edu.uniandes.csw.inventario.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.inventario.logic.api.IInventarioLogicService;

@Alternative
@Singleton
public class InventarioMockLogicService extends _InventarioMockLogicService implements IInventarioLogicService {
	
}