package co.edu.uniandes.csw.inventario.master.persistence;

import javax.ejb.Stateless;

import co.edu.uniandes.csw.inventario.master.persistence.api.IInventarioMasterPersistence;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Default;

@Default
@Stateless 
@LocalBean
public class InventarioMasterPersistence extends _InventarioMasterPersistence  implements IInventarioMasterPersistence {

}