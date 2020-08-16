package com.lti.entity.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class CustomerDao {
	
	public void add(Customer customer) {
		//1- Create/obtain EntitymanagerFactory obj
		//in this step meta-inf/persistence.xml file will be read
		//tables get created in the db if hbm2ddl.auto has been enabled
		//schema validation is also done during this step
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		
		//2-Create/obtain EntityManager object
		EntityManager em = emf.createEntityManager();
		
		//3- Start/participate in a transaction-- DML operations should be Atomic(ACID prop.)
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//now we can perform sql operations
		em.persist(customer);//persist method generates Insert Query
		
		tx.commit();
		
		//should be in finally block
		em.close();
		emf.close();
	}
	
	public void update(Customer customer) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();
	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		em.merge(customer);
		
		tx.commit();

		em.close();
		emf.close();
	}
	
	public Customer fetch(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();
		
		//find method generates select....from tbl where pk = ?	
		Customer cust = em.find(Customer.class, id);
		
		em.close();
		emf.close();
		
		return cust;
	}
	
	public List<Customer> fetchAll(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();
		
		//JPQL/HQL
		Query q = em.createQuery(" select c from Customer c");
		List<Customer> list = q.getResultList(); 
		
		em.close();
		emf.close();
		
		return list;
	}
	
	//eg. fetch customers having gmail account	
	public List<Customer> fetch(String domain) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		// JPQL/HQL
		Query q = em.createQuery(" select c from Customer c where c.email like :dm");
		q.setParameter("dm", "%"+domain+"%");
		List<Customer> list = q.getResultList();

		em.close();
		emf.close();

		return list;
	}
	

}
