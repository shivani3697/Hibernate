package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		
		Student student = new Student();
		student.setStudentName("Sam");
		student.setAvgScore(66);
		entityManager.remove(student);
		
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		student.setAvgScore(88);
		entityManager.getTransaction().commit();
		System.out.println("Student persisted in database");
		
		
		entityManager.getTransaction().begin();
		entityManager.remove(student);
		entityManager.getTransaction().commit();
		System.out.println("Student is removed from database");
		
		
		
		
	}

}
