package com.lti.entity.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.lti.entity.Address;
import com.lti.entity.Employee;

public class EmployeeDao {
	
	public void add(Address addr) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(addr);

		tx.commit();

		em.close();
		emf.close();
	}
	
	public void add(Employee employee) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();
		
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(employee);
		
		tx.commit();
		
		em.close();
		emf.close();
	}

	public void update(Employee employee) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(employee);

		tx.commit();

		em.close();
		emf.close();
	}
	
	public Employee fetch(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		// find method generates select....from tbl where pk = ?
		Employee emp = em.find(Employee.class, id);

		em.close();
		emf.close();

		return emp;
	}
	
	public List<Employee> fetchAll() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		// JPQL/HQL
		Query q = em.createQuery(" select e from Employee e");
		List<Employee> list = q.getResultList();

		em.close();
		emf.close();

		return list;
	}
	
	public List<Employee> fetchByPsno(int psno) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		// JPQL/HQL
		Query q = em.createQuery(" select e from Employee e where e.psno = :pn");
		q.setParameter("pn", psno);
		List<Employee> list = q.getResultList();

		em.close();
		emf.close();

		return list;
	}
	
	public List<Employee> fetchBySalary(double salary) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		// JPQL/HQL
		Query q = em.createQuery(" select e from Employee e where e.salary >= :sal");
		q.setParameter("sal", salary);
		List<Employee> list = q.getResultList();

		em.close();
		emf.close();

		return list;
	}
	
	public List<Employee> fetchByjoiningYear(int year) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		// JPQL/HQL
		Query q = em.createQuery(" select e from Employee e where year(e.dateofjoining) = :yr");
		q.setParameter("yr", year);
		List<Employee> list = q.getResultList();

		em.close();
		emf.close();

		return list;
	}
	
	public List<Employee> fetchByCity(String city) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		// JPQL/HQL
		//sql-select e.* from tbl_emp e inner join tbl_addr a on e.addr_id=a.id where city='Dehradun';
		Query q = em.createQuery(" select e from Employee e join e.address addr where addr.city = :ct");
		q.setParameter("ct", city);
		List<Employee> list = q.getResultList();

		em.close();
		emf.close();

		return list;
	}
}
