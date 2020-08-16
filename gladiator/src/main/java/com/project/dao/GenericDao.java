package com.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericDao {

	public void save(Object obj) {

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("gladiator");
			em = emf.createEntityManager();

			EntityTransaction tx = em.getTransaction();
			tx.begin();

			em.merge(obj);// merge can be used for both insert and update

			tx.commit();

		}

		finally {
			em.close();
			emf.close();
		}
	}

	//public Object fetch(Class clazz, Object pk) {
	public <T> T fetch(Class<T> clazz, Object pk) {

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("gladiator");
			em = emf.createEntityManager();

			//Object obj = em.find(clazz, pk);
			T t =em.find(clazz, pk);

			//return obj;
			return t;
		}

		finally {

			em.close();
			emf.close();
		}
	}

}

