package com.br.jty.process.entity.dao;

import com.br.jty.process.entity.master.ProcessMaster;

public class ProcessMasterDAO extends DAO<ProcessMaster>{

	public ProcessMaster find (Long id){
		return getEntityManager().find(ProcessMaster.class, id);
	}
}
