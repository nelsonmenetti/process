package com.br.jty.process.entity.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 */
public class DAO<T> {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    
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
    
}
