package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<Entity, ID extends Serializable> {
	
	private Class <Entity> entity;

	@Autowired
	private SessionFactory sessionFactory;

	public AbstractDAO(Class <Entity> entity) {
		this.entity = entity;
	}

	protected final Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void save(Entity object) {
		getSession().saveOrUpdate(object);
	}

	public void delete(Entity object) {
		getSession().delete(object);
	}

	public void deleteByID(ID id) {
		final Entity entity = findByID(id);

		delete(entity);
	}

	/**
	 * TODO: Replace Session.get() since it's deprecated
	 */

	@SuppressWarnings("deprecation")
	public Entity findByID(ID id) {
		return (Entity) getSession().get(this.entity, id);
	}

	/**
	 * TODO: Find a better way to return Lists, avoiding type safety warnings (remove @SuppressWarnings)
	 * * Maybe using Criterias?
	 */

	@SuppressWarnings("unchecked")
	public List<Entity> findAll() {
		return getSession().createQuery("from" + this.entity.getName()).list();
	}
}
