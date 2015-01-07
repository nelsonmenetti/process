package com.br.jty.process.business.master;

import java.util.ArrayList;
import java.util.List;

import com.br.jty.process.business.exception.IllegalParameterException;
import com.br.jty.process.entity.dao.ProcessMasterDAO;
import com.br.jty.process.entity.dao.StepMasterDAO;
import com.br.jty.process.entity.master.ProcessMaster;
import com.br.jty.process.entity.master.StepMaster;

public class ProcessMasterBusiness {
	
	
	private StepMasterDAO stepMasterDAO = new StepMasterDAO();
	private ProcessMasterDAO processMasterDAO = new ProcessMasterDAO();
	
	public ProcessMaster createProcess(String name , String description ,Long version,List<Long> steps) throws IllegalParameterException{
		ProcessMaster process = new ProcessMaster();
		process.setName(name);
		process.setDescription(description);
		process.setVersion(version);
		process.setSteps(new ArrayList<StepMaster>());
		for(Long stepid:steps){
			StepMaster step = stepMasterDAO.find(stepid);
			if(step==null){
				StringBuilder message =new StringBuilder();
				message.append("Passo nao existe "+stepid+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{
				process.getSteps().add(step);
			}
		}
		processMasterDAO.save(process);
		return process;
	}
	public ProcessMaster addStepToProcess(Long processId, List<Long> steps) throws IllegalParameterException{
		ProcessMaster process = processMasterDAO.find(processId);
		if(process == null){
			StringBuilder message =new StringBuilder();
			message.append("Processo nao existe "+processId+" \n");				
			throw new IllegalParameterException(message.toString()); 
		}
		
		for(Long stepid:steps){
			StepMaster step = stepMasterDAO.find(stepid);
			if(step==null){
				StringBuilder message =new StringBuilder();
				message.append("Passo nao existe "+stepid+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{
				if(!process.getSteps().contains(step)){
					process.getSteps().add(step);
				}
			}
		}
		processMasterDAO.save(process);
		return process;

	}
	public ProcessMaster removeStepFromProcess(Long processId, List<Long> steps) throws IllegalParameterException{
		ProcessMaster process = processMasterDAO.find(processId);
		if(process == null){
			StringBuilder message =new StringBuilder();
			message.append("Processo nao existe "+processId+" \n");				
			throw new IllegalParameterException(message.toString()); 
		}
		
		for(Long stepid:steps){
			StepMaster step = stepMasterDAO.find(stepid);
			if(step==null){
				StringBuilder message =new StringBuilder();
				message.append("Passo nao existe "+stepid+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{
				if(process.getSteps().contains(step)){
					process.getSteps().remove(step);
				}
			}
		}
		processMasterDAO.save(process);
		return process;
	}	
	
	public ProcessMaster editProcess(Long processId,String name ,String description ,List<Long> steps) throws IllegalParameterException{
		ProcessMaster process = processMasterDAO.find(processId);
		if(process == null){
			StringBuilder message =new StringBuilder();
			message.append("Processo nao existe "+processId+" \n");				
			throw new IllegalParameterException(message.toString()); 
		}
		process.setName(name);
		process.setDescription(description);
		process.setSteps(new ArrayList<StepMaster>());
		for(Long stepid:steps){
			StepMaster step = stepMasterDAO.find(stepid);
			if(step==null){
				StringBuilder message =new StringBuilder();
				message.append("Passo nao existe "+stepid+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{
				process.getSteps().add(step);
			}
		}
		processMasterDAO.save(process);
		return process;
		
	}
	
	public void deleteProcess(Long processId) throws IllegalParameterException{
		ProcessMaster process = processMasterDAO.find(processId);
		if(process == null){
			StringBuilder message =new StringBuilder();
			message.append("Processo nao existe "+processId+" \n");				
			throw new IllegalParameterException(message.toString()); 
		}
		processMasterDAO.remove(process);
	}
	
}
