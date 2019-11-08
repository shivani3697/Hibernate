package com.lti.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Current;
import com.lti.model.Saving;




public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager=factory.createEntityManager();
		
		Saving s = new Saving (100001, "Harry", 40000 , 4.0);
		Current c = new Current(78895321,"Sam",78000,5000);
		
		entityManager.getTransaction().begin();
		entityManager.persist(s);
		entityManager.persist(c);
		entityManager.getTransaction().commit();
	}

}
