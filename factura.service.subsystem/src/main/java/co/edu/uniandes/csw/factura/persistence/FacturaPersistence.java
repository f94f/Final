
package co.edu.uniandes.csw.factura.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.factura.persistence.api.IFacturaPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class FacturaPersistence extends _FacturaPersistence  implements IFacturaPersistence {

}