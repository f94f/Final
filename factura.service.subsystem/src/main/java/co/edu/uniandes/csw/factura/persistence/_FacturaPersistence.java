
package co.edu.uniandes.csw.factura.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.factura.persistence.api._IFacturaPersistence;
import co.edu.uniandes.csw.factura.persistence.converter.FacturaConverter;
import co.edu.uniandes.csw.factura.persistence.entity.FacturaEntity;

public abstract class _FacturaPersistence implements _IFacturaPersistence {

	@PersistenceContext(unitName="FacturaPU")
	protected EntityManager entityManager;
	
	public FacturaDTO createFactura(FacturaDTO factura) {
		FacturaEntity entity=FacturaConverter.persistenceDTO2Entity(factura);
		entityManager.persist(entity);
		return FacturaConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<FacturaDTO> getFacturas() {
		Query q = entityManager.createQuery("select u from FacturaEntity u");
		return FacturaConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public FacturaDTO getFactura(Long id) {
		return FacturaConverter.entity2PersistenceDTO(entityManager.find(FacturaEntity.class, id));
	}

	public void deleteFactura(Long id) {
		FacturaEntity entity=entityManager.find(FacturaEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateFactura(FacturaDTO detail) {
		FacturaEntity entity=entityManager.merge(FacturaConverter.persistenceDTO2Entity(detail));
		FacturaConverter.entity2PersistenceDTO(entity);
	}

}