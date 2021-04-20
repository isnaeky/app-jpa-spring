package com.isnaeky.demo.app.models.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.isnaeky.demo.app.models.entity.Cliente;

/*
 * Clase que implementa la interface IClienteDao
 */
//Anotacion que marca la clase como clase de persistencia de datos y como componente de spring
@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {

	// Anotacion que contiene la unidad de persistencia, inyecta el entity manager
	// toda la configuracion que se hizo
	@PersistenceContext
	// EntityManager se encarga de manejar las clases de entidades el cliclo de vida
	// la persiste dentro
	private EntityManager em;

	// Anotacion que suprime el warning
	@SuppressWarnings("unchecked")
	// Anotacion que sobreescribe el metodo
	@Override

	/*
	 * Metodo que lista o select de la tabla clientes y los retorna
	 */
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}
	
	/*
	 * Metodo para buscar un cliente de la BD
	 */
	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

	/*
	 * Metodo que guarda un cliente en la BD o actualizar dependiendo si nuestro id existe o es null
	 */
	@Override

	public void save(Cliente cliente) {
		/*
		 * Persist(Object entity) almacena un objeto entity en el contexto de
		 * persistencia y en la BD
		 */
		if (cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		} else {
			em.persist(cliente);
		}
	}

	/*
	 * Metodo para eliminar un cliente 
	 * Antes de eliminarlo busca el cliente si exite y lo elimina
	 */
	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

	/*
	 * NOTAS ** Persist(Object entity) almacena un objeto entity en el contexto de
	 * persistencia y en la BD Merge(Object entity) Actualiza las modificaciones en
	 * una entidad devolviendo un objeto entity manejando por el contexto doctrine
	 * Remove(Class<t> entity, object primarykey) busca la entidad a traves de su
	 * clave primaria
	 */

}
