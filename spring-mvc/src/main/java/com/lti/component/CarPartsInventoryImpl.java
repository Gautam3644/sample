package com.lti.component;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.CarPart;

@Component("carpart")
public class CarPartsInventoryImpl implements CarPartsInventory {

	@PersistenceContext // @Autowired doesnt works
	private EntityManager entityManager;

	@Transactional
	public void addNewPart(CarPart carpart) {

		entityManager.persist(carpart);
	}
	
	public List<CarPart> getAvailableParts() {

		Query q =entityManager.createQuery("select cp from CarPart as cp");
		List<CarPart> list = q.getResultList();
		return list;
	}

}