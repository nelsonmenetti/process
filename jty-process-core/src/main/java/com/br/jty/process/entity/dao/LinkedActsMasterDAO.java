package com.br.jty.process.entity.dao;

import java.util.List;

import javax.persistence.Query;

import com.br.jty.process.entity.master.LinkedActsMaster;

public class LinkedActsMasterDAO extends DAO<LinkedActsMaster>{

	public LinkedActsMaster find (Long id){
		return getEntityManager().find(LinkedActsMaster.class, id);
	}
	
	public List<LinkedActsMaster> find (String name){
		Query query = getEntityManager().createQuery("from LinkedActsMaster la where la.name = :name");
		query.setParameter("name", name);
		return query.getResultList();
	}
}
