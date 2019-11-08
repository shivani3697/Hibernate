package com.lti.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Address;
import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager=factory.createEntityManager();
		
		Student student = new Student (1,"Erric",80.5);
		Address address = new Address("Mumbai","MH","411019");
		student.setAddress(address);
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		//entityManager.persist(address);
		entityManager.getTransaction().commit();
		
		Student student2 = entityManager.find(Student.class, student.getStudentId());
		System.out.println(student2);
	//	System.out.println(student2.getAddress());
	}

}
