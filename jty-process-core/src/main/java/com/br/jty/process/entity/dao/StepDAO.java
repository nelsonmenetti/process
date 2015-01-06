package com.br.jty.process.entity.dao;

import com.br.jty.process.entity.master.StepMaster;

public class StepDAO extends DAO<StepMaster>{

	
	public StepMaster find(Long id){
		return getEntityManager().find(StepMaster.class, id);
	}
}
