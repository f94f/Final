package co.edu.uniandes.csw.factura.master.persistence;

import javax.ejb.Stateless;

import co.edu.uniandes.csw.factura.master.persistence.api.IFacturaMasterPersistence;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Default;

@Default
@Stateless 
@LocalBean
public class FacturaMasterPersistence extends _FacturaMasterPersistence  implements IFacturaMasterPersistence {

}