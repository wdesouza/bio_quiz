package br.org.quiz.database.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceConnection {

	private static PersistenceConnection instance;
	private final String PERSISTENCE_UNIT = "quiz"; 
	private EntityManagerFactory generatedFactory;
	
	private PersistenceConnection() {
		generatedFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}
	
	public static PersistenceConnection getInstance() {
		if(instance == null)
			instance = new PersistenceConnection();
		return instance;
	}

	public EntityManager createManager() {
		return generatedFactory.createEntityManager();
	}
	
	
	public void cleanCache() {
		generatedFactory.getCache().evictAll();
	}
}
