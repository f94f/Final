
package co.edu.uniandes.csw.ordenreaprovicionamiento.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.ordenreaprovicionamiento.logic.dto.OrdenReaprovicionamientoDTO;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.api._IOrdenReaprovicionamientoPersistence;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.converter.OrdenReaprovicionamientoConverter;
import co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.entity.OrdenReaprovicionamientoEntity;

public abstract class _OrdenReaprovicionamientoPersistence implements _IOrdenReaprovicionamientoPersistence {

	@PersistenceContext(unitName="OrdenReaprovicionamientoPU")
	protected EntityManager entityManager;
	
	public OrdenReaprovicionamientoDTO createOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO ordenReaprovicionamiento) {
		OrdenReaprovicionamientoEntity entity=OrdenReaprovicionamientoConverter.persistenceDTO2Entity(ordenReaprovicionamiento);
		entityManager.persist(entity);
		return OrdenReaprovicionamientoConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<OrdenReaprovicionamientoDTO> getOrdenReaprovicionamientos() {
		Query q = entityManager.createQuery("select u from OrdenReaprovicionamientoEntity u");
		return OrdenReaprovicionamientoConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public OrdenReaprovicionamientoDTO getOrdenReaprovicionamiento(Long id) {
		return OrdenReaprovicionamientoConverter.entity2PersistenceDTO(entityManager.find(OrdenReaprovicionamientoEntity.class, id));
	}

	public void deleteOrdenReaprovicionamiento(Long id) {
		OrdenReaprovicionamientoEntity entity=entityManager.find(OrdenReaprovicionamientoEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateOrdenReaprovicionamiento(OrdenReaprovicionamientoDTO detail) {
		OrdenReaprovicionamientoEntity entity=entityManager.merge(OrdenReaprovicionamientoConverter.persistenceDTO2Entity(detail));
		OrdenReaprovicionamientoConverter.entity2PersistenceDTO(entity);
	}

}