package com.br.jty.process.entity.dao;

import com.br.jty.process.entity.SLA;

public class SLADAO extends DAO<SLA> {

	public SLA find (Long id){
		return getEntityManager().find(SLA.class, id);
	}
}
