package com.lti.entity.dao;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Person;
import com.lti.entity.Transaction;

public class AccountDao extends GenericDao {

	public List<Transaction> fetchMiniStatement(int accno) {

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("hibernate-intro");
			em = emf.createEntityManager();

			// selet * from(select * from TBL_TRS where accno = :ct orderBy dateandTime)
			// where rownum<=5;
			String jpql = "select tx from Transaction tx where tx.account.accno = :no order by tx.timeAndDate desc";
			Query q = em.createQuery(jpql);
			q.setParameter("no", accno);
			q.setMaxResults(5);
			List<Transaction> list = q.getResultList();

			return list;

		}

		finally {

			em.close();
			emf.close();
		}
	}
}
