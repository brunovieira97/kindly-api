package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractDAO<Entity, ID extends Serializable> {
	
	private Class <Entity> entity;

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;


	public AbstractDAO(Class <Entity> entity) {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("kindly_persistence_unit");
		this.entityManager = this.entityManagerFactory.createEntityManager();

		this.entity = entity;
	}

	protected final EntityManager getEntityManager() {
		return this.entityManager;
	}

	protected final EntityTransaction getTransaction() {
		return getEntityManager().getTransaction();
	}

	public void save(Entity object) {
		try {
			getTransaction().begin();

			getEntityManager().persist(object);

			getTransaction().commit();

		} catch (Exception e) {
			getTransaction().rollback();

			e.printStackTrace();
		}
	}

	public void delete(Entity object) {
		try {
			getTransaction().begin();

			getEntityManager().remove(object);

			getTransaction().commit();

		} catch (Exception e) {
			getTransaction().rollback();

			e.printStackTrace();
		}
	}

	public void deleteByID(ID id) {
		final Entity entity = findByID(id);

		delete(entity);
	}

	public Entity findByID(ID id) {
		return (Entity) getEntityManager().find(this.entity, id);
	}

	public List<Entity> findAll() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(this.entity);

		Root<Entity> rootEntry = criteriaQuery.from(this.entity);
		CriteriaQuery<Entity> queryAll = criteriaQuery.select(rootEntry);
		TypedQuery<Entity> typedQuery = getEntityManager().createQuery(queryAll);

		return typedQuery.getResultList();
	}
}
