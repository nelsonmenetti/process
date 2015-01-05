package com.br.jty.process.entity.dao;


import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 */
public class DAO<T> {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    
    /**
     * Method save.
     * @param object T
     */
    public void save (T object){
    	entityManager.getTransaction().begin();
    	try{
    		entityManager.persist(object);
    		entityManager.getTransaction().commit();
    	}catch(EntityExistsException e){
    		entityManager.getTransaction().rollback();
    		update (object);
    	}    	    	
    }
    
    
    /**
     * Method update.
     * @param object T
     */
    public void update (T object){
    	entityManager.getTransaction().begin();
    	entityManager.merge(object);
    	entityManager.getTransaction().commit();
    }
    
    /**
     * Method remove.
     * @param object T
     */
    public void remove (T object){
    	entityManager.getTransaction().begin();
    	entityManager.remove(object);
    	entityManager.getTransaction().commit();
    }


	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}


	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
    
    
}
