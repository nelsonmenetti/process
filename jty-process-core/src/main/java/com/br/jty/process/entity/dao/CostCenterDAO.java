package com.br.jty.process.entity.dao;

import java.util.List;

import javax.persistence.Query;

import com.br.jty.process.entity.CostCenter;

public class CostCenterDAO extends DAO<CostCenter>{

	public CostCenter find (Long id){
		return getEntityManager().find(CostCenter.class, id);
	}
	
	public List<CostCenter> find (String name){
		Query query = getEntityManager().createQuery("from CostCenter cc where cc.name = :name");
		query.setParameter("name", name);
		return query.getResultList();
	}
}
