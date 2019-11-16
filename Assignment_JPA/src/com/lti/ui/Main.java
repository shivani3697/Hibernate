package com.lti.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Author;




public class Main {
	
	
	public static void main(String[] args) {
	int ans=0;
	
		int ch , id; 
		String fname,mname,lname;
		long phno= 0;
		System.out.println("MENU: \n 1. Insert Record \n 2. View Record \n 3. Update Record \n 4 Delete Record");
		System.out.println("\n Enter your choice");
		Scanner sc = new Scanner(System.in);
		ch = sc.nextInt();
		if(ch==1)
		{
			System.out.println("Enter id");
			id = sc.nextInt();
			
			System.out.println("Enter first name");
			fname = sc.next();
			
			System.out.println("Enter middle name");
			mname = sc.next();
			
			System.out.println("Enter last name");
			lname = sc.next();
			
			System.out.println("Enter phone number");
			phno = sc.nextLong();
			
			Author author = new Author(id,fname,mname,lname,phno);
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
			EntityManager entityManager = factory.createEntityManager(); 
			
			entityManager.getTransaction().begin();
			entityManager.persist(author);		//equivalant as insert operation
			entityManager.getTransaction().commit();
			System.out.println("Author object saved");
			
		}
		if(ch==2)
		{
			System.out.println("Enter the id number to view record");
			id = sc.nextInt();
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
			EntityManager entityManager = factory.createEntityManager(); 
			Author author = entityManager.find(Author.class,id);
			System.out.println(author);
		
		}
		if (ch==3)
		{
			System.out.println("Enter Id to update");
			id = sc.nextInt();
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
			EntityManager entityManager = factory.createEntityManager(); 
			Author author = entityManager.find(Author.class,id);
			System.out.println("Enter phone number to update");
			phno = sc.nextLong();
			author.setPhoneNo(phno);
			
			System.out.println("After updating object:");
			entityManager.getTransaction().begin();
			entityManager.merge(author);			//update query
			entityManager.getTransaction().commit();
			
		}
		if (ch == 4)
		{
			
			System.out.println("Enter id to remove");
			id = sc.nextInt();
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
			EntityManager entityManager = factory.createEntityManager(); 
			entityManager.getTransaction().begin();
			entityManager.remove(id);			//delete operation
			
			Author author = entityManager.find(Author.class,id);
			entityManager.getTransaction().commit();
		}
		
	

	}

}