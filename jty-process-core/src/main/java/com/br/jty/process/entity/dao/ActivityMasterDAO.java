package com.br.jty.process.entity.dao;

import java.util.List;

import javax.persistence.Query;

import com.br.jty.process.entity.master.ActivityMaster;

public class ActivityMasterDAO extends DAO<ActivityMaster>{

	public ActivityMaster find (Long id){
		return getEntityManager().find(ActivityMaster.class, id);
	}
	
	public List<ActivityMaster> find (String name){
		Query query = getEntityManager().createQuery("from ActivityMaster am where am.name = :name");
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	public ActivityMaster find (String name, Long stepId){
		Query query = getEntityManager().createQuery("from ActivityMaster am where am.name = :name and am.step.id= :stepId");
		query.setParameter("name", name);
		query.setParameter("stepId", stepId);
		return (ActivityMaster) query.getSingleResult();
	}	

}
