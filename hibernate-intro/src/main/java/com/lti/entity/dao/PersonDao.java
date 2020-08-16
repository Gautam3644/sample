package com.lti.entity.dao;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.lti.entity.Passport;
import com.lti.entity.Person;

public class PersonDao extends GenericDao {

	public List<Person> fetchByPassportExpiryDate(LocalDate date) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select person from Person as person join person.passport as passport where passport.expiredate <= :date";
		Query q = em.createQuery(jpql); 
		q.setParameter("date", date);
		List<Person> list = q.getResultList();
		
		em.close();
		emf.close();
		
		return list;
	}
	
	public Passport fetchPassport(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select passport from Passport as passport join passport.person as person	";
		Query q = em.createQuery(jpql); 
		q.setParameter("name", name);
		
		Passport p = (Passport) q.getSingleResult();
		
		em.close();
		emf.close();
		
		return p;
	}
	
	public List<String[]> fetchNameAndPassportNo() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select person.name, passport.passportNo from Person as person join person.passport as passport";
		Query q = em.createQuery(jpql); 
		List<String[]> list = q.getResultList();
		
		em.close();
		emf.close();
		
		return list;
	}
	
	public void update(Person person) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(person);

		tx.commit();

		em.close();
		emf.close();
	}
	
	
}
