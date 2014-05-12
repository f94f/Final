
package co.edu.uniandes.csw.inventario.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.inventario.logic.dto.InventarioDTO;
import co.edu.uniandes.csw.inventario.persistence.api._IInventarioPersistence;
import co.edu.uniandes.csw.inventario.persistence.converter.InventarioConverter;
import co.edu.uniandes.csw.inventario.persistence.entity.InventarioEntity;

public abstract class _InventarioPersistence implements _IInventarioPersistence {

	@PersistenceContext(unitName="InventarioPU")
	protected EntityManager entityManager;
	
	public InventarioDTO createInventario(InventarioDTO inventario) {
		InventarioEntity entity=InventarioConverter.persistenceDTO2Entity(inventario);
		entityManager.persist(entity);
		return InventarioConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<InventarioDTO> getInventarios() {
		Query q = entityManager.createQuery("select u from InventarioEntity u");
		return InventarioConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public InventarioDTO getInventario(Long id) {
		return InventarioConverter.entity2PersistenceDTO(entityManager.find(InventarioEntity.class, id));
	}

	public void deleteInventario(Long id) {
		InventarioEntity entity=entityManager.find(InventarioEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateInventario(InventarioDTO detail) {
		InventarioEntity entity=entityManager.merge(InventarioConverter.persistenceDTO2Entity(detail));
		InventarioConverter.entity2PersistenceDTO(entity);
	}

}