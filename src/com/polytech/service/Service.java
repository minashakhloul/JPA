package com.polytech.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Service {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("remote-server");

	static EntityManager getNewEntityManager() {

		return emf.createEntityManager();
	}

	public static <Entity> void commit(CommitOperation commitOperation, Entity entity) {
		EntityManager em = getNewEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		commitOperation.apply(em, entity);
		tx.commit();
	}

	public static <Entity> void commitAll(CommitOperation commitOperation, Collection<Entity> entitis) {
		EntityManager em = getNewEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		for (Entity entity : entitis)
			commitOperation.apply(em, entity);
		tx.commit();
	}

	public static <Entity> Entity getSingleResult(Class<Entity> entityClass, String queryName, Map<String, Object> queryParameter) {
		Entity result = null;
		TypedQuery<Entity> query = getNewEntityManager().createNamedQuery(queryName, entityClass);

		if (queryParameter != null)
			for (String parameterName : queryParameter.keySet())
				query.setParameter(parameterName, queryParameter.get(parameterName));

		try {
			result = query.getSingleResult();
		} catch (NoResultException e) {
			//e.printStackTrace();
		}
		return result;
	}

	public static <Entity> List<Entity> getResultList(Class<Entity> entityClass, String queryName, Map<String, Object> queryParameter) {
		List<Entity> result = null;
		TypedQuery<Entity> query = getNewEntityManager().createNamedQuery(queryName, entityClass);

		if (queryParameter != null)
			for (String parameterName : queryParameter.keySet())
				query.setParameter(parameterName, queryParameter.get(parameterName));

		try {
			result = query.getResultList();
		} catch (NoResultException e) {
			//e.printStackTrace();
		}
		return result;
	}

	public static void load() {
		getNewEntityManager();
	}
}
