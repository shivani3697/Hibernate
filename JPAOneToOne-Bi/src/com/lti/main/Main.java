package com.lti.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.lti.model.Department;
import com.lti.model.Employee;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		Department dept = new Department(10,"Development");
		Employee e1 = new Employee(101,"Raghav",9000);
		Employee e2 = new Employee(102,"Sam",4000);
		Employee e3 = new Employee(103,"Tom",7000);
		Employee e4 = new Employee(104,"Ram",5000);
		
		
		dept.addEmployee(e1);
		dept.addEmployee(e2);
		dept.addEmployee(e3);
		dept.addEmployee(e4);
		
		e1.setDepartment(dept);
		e2.setDepartment(dept);
		e3.setDepartment(dept);
		e4.setDepartment(dept);
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(dept);
		entityManager.getTransaction().commit();
		
	}

}
