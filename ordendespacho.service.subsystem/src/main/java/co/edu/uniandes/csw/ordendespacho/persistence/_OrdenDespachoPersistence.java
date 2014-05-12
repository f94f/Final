
package co.edu.uniandes.csw.ordendespacho.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.ordendespacho.logic.dto.OrdenDespachoDTO;
import co.edu.uniandes.csw.ordendespacho.persistence.api._IOrdenDespachoPersistence;
import co.edu.uniandes.csw.ordendespacho.persistence.converter.OrdenDespachoConverter;
import co.edu.uniandes.csw.ordendespacho.persistence.entity.OrdenDespachoEntity;

public abstract class _OrdenDespachoPersistence implements _IOrdenDespachoPersistence {

	@PersistenceContext(unitName="OrdenDespachoPU")
	protected EntityManager entityManager;
	
	public OrdenDespachoDTO createOrdenDespacho(OrdenDespachoDTO ordenDespacho) {
		OrdenDespachoEntity entity=OrdenDespachoConverter.persistenceDTO2Entity(ordenDespacho);
		entityManager.persist(entity);
		return OrdenDespachoConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<OrdenDespachoDTO> getOrdenDespachos() {
		Query q = entityManager.createQuery("select u from OrdenDespachoEntity u");
		return OrdenDespachoConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public OrdenDespachoDTO getOrdenDespacho(Long id) {
		return OrdenDespachoConverter.entity2PersistenceDTO(entityManager.find(OrdenDespachoEntity.class, id));
	}

	public void deleteOrdenDespacho(Long id) {
		OrdenDespachoEntity entity=entityManager.find(OrdenDespachoEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateOrdenDespacho(OrdenDespachoDTO detail) {
		OrdenDespachoEntity entity=entityManager.merge(OrdenDespachoConverter.persistenceDTO2Entity(detail));
		OrdenDespachoConverter.entity2PersistenceDTO(entity);
	}

}