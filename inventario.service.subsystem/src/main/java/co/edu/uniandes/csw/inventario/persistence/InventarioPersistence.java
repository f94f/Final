
package co.edu.uniandes.csw.inventario.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.inventario.persistence.api.IInventarioPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class InventarioPersistence extends _InventarioPersistence  implements IInventarioPersistence {

}