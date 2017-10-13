package com.cg.customer.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utility {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
		
		if(entityManager==null || !entityManager.isOpen()) {
			
			entityManager = factory.createEntityManager();
			//System.out.println(entityManager);
		}
		
		return entityManager;
	}
	
}
