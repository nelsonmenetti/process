package com.br.jty.process.entity.dao;

import java.util.List;

import javax.persistence.Query;

import com.br.jty.process.entity.Department;

public class DepartmentDAO extends DAO<Department>{
	
	public Department find(Long id){
		return getEntityManager().find(Department.class, id);
	}

	public List<Department> find (String name){
		Query query = getEntityManager().createQuery("from Department d where d.name = :name");
		query.setParameter("name", name);
		return query.getResultList();
	}
}
