
package co.edu.uniandes.csw.ordenfabricacion.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.ordenfabricacion.logic.dto.OrdenFabricacionDTO;
import co.edu.uniandes.csw.ordenfabricacion.persistence.api._IOrdenFabricacionPersistence;
import co.edu.uniandes.csw.ordenfabricacion.persistence.converter.OrdenFabricacionConverter;
import co.edu.uniandes.csw.ordenfabricacion.persistence.entity.OrdenFabricacionEntity;

public abstract class _OrdenFabricacionPersistence implements _IOrdenFabricacionPersistence {

	@PersistenceContext(unitName="OrdenFabricacionPU")
	protected EntityManager entityManager;
	
	public OrdenFabricacionDTO createOrdenFabricacion(OrdenFabricacionDTO ordenFabricacion) {
		OrdenFabricacionEntity entity=OrdenFabricacionConverter.persistenceDTO2Entity(ordenFabricacion);
		entityManager.persist(entity);
		return OrdenFabricacionConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<OrdenFabricacionDTO> getOrdenFabricacions() {
		Query q = entityManager.createQuery("select u from OrdenFabricacionEntity u");
		return OrdenFabricacionConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public OrdenFabricacionDTO getOrdenFabricacion(Long id) {
		return OrdenFabricacionConverter.entity2PersistenceDTO(entityManager.find(OrdenFabricacionEntity.class, id));
	}

	public void deleteOrdenFabricacion(Long id) {
		OrdenFabricacionEntity entity=entityManager.find(OrdenFabricacionEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateOrdenFabricacion(OrdenFabricacionDTO detail) {
		OrdenFabricacionEntity entity=entityManager.merge(OrdenFabricacionConverter.persistenceDTO2Entity(detail));
		OrdenFabricacionConverter.entity2PersistenceDTO(entity);
	}

}