package com.br.jty.process.business.master;

import java.util.ArrayList;
import java.util.List;

import com.br.jty.process.business.exception.IllegalParameterException;
import com.br.jty.process.entity.dao.ActivityMasterDAO;
import com.br.jty.process.entity.dao.LinkedActsMasterDAO;
import com.br.jty.process.entity.dao.StepMasterDAO;
import com.br.jty.process.entity.master.ActivityMaster;
import com.br.jty.process.entity.master.LinkedActsMaster;
import com.br.jty.process.entity.master.StepMaster;

public class StepMasterBusiness {

	private StepMasterDAO stepDAO= new StepMasterDAO();
	private LinkedActsMasterDAO linkedActivityMasterDAO = new LinkedActsMasterDAO();
	private ActivityMasterDAO activityMasterDAO = new ActivityMasterDAO();

	public void createStep(String name, List<Long>activities, List <Long> linkedActs) throws IllegalParameterException{
		StepMaster step = new StepMaster();
		List<ActivityMaster> acts = new ArrayList<ActivityMaster>();
		List<LinkedActsMaster> linked = new ArrayList<LinkedActsMaster>();
		
		for(Long actId:activities){
			ActivityMaster act = activityMasterDAO.find(actId);
			if(act==null){
				StringBuilder message =new StringBuilder();
				message.append("Atividade nao existe "+actId+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{
				acts.add(act);
			}
		}		
		for(Long linkedActId:linkedActs){
			LinkedActsMaster link=  linkedActivityMasterDAO.find(linkedActId);
			
			if(link==null){
				StringBuilder message =new StringBuilder();
				message.append("Atividade ligada nao existe "+linkedActId+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{
				linked.add(link);
			}
		}
		step.setName(name);
		step.setActivities(acts);
		step.setLinkedActivities(linked);		
		stepDAO.save(step);
	}
	
	public void updateStep(Long stepId,String name, List<Long>activities, List <Long> linkedActs) throws IllegalParameterException{
		StepMaster step = stepDAO.find(stepId);
		List<ActivityMaster> acts = new ArrayList<ActivityMaster>();
		List<LinkedActsMaster> linked = new ArrayList<LinkedActsMaster>();
		
		if( step == null){
			StringBuilder message =new StringBuilder();
			message.append("Passo nao existe "+stepId+" \n");				
			throw new IllegalParameterException(message.toString()); 			
		}
		
		for(Long actId:activities){
			ActivityMaster act = activityMasterDAO.find(actId);
			if(act==null){
				StringBuilder message =new StringBuilder();
				message.append("Atividade nao existe "+actId+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{
				acts.add(act);
			}
		}		
		for(Long linkedActId:linkedActs){
			LinkedActsMaster link=  linkedActivityMasterDAO.find(linkedActId);
			
			if(link==null){
				StringBuilder message =new StringBuilder();
				message.append("Atividade ligada nao existe "+linkedActId+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{
				linked.add(link);
			}
		}
		step.setName(name);
		step.setActivities(acts);
		step.setLinkedActivities(linked);		
		stepDAO.update(step);		
	}
	
	public void deleteStep(Long stepId) throws IllegalParameterException{
		StepMaster step = stepDAO.find(stepId);
		if( step == null){
			StringBuilder message =new StringBuilder();
			message.append("Passo nao existe "+stepId+" \n");				
			throw new IllegalParameterException(message.toString()); 			
		}
		stepDAO.remove(step);
	}
	
	public void addActivitiesToStep(Long stepId,List<Long>activities) throws IllegalParameterException{
		StepMaster step = stepDAO.find(stepId);
		if( step == null){
			StringBuilder message =new StringBuilder();
			message.append("Passo nao existe "+stepId+" \n");				
			throw new IllegalParameterException(message.toString()); 			
		}
		for(Long actId:activities){
			ActivityMaster act = activityMasterDAO.find(actId);
			if(act==null){
				StringBuilder message =new StringBuilder();
				message.append("Atividade nao existe "+actId+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{				
				if(!step.getActivities().contains(act)){
					step.getActivities().add(act);
				}
			}
		}
		stepDAO.save(step);
	}	
	public void removeActivityFromStep(Long stepId,List<Long>activities) throws IllegalParameterException{
		StepMaster step = stepDAO.find(stepId);
		if( step == null){
			StringBuilder message =new StringBuilder();
			message.append("Passo nao existe "+stepId+" \n");				
			throw new IllegalParameterException(message.toString()); 			
		}
		for(Long actId:activities){
			ActivityMaster act = activityMasterDAO.find(actId);
			if(act==null){
				StringBuilder message =new StringBuilder();
				message.append("Atividade nao existe "+actId+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{				
				if(step.getActivities().contains(act)){
					step.getActivities().remove(act);
				}
			}
		}
		stepDAO.save(step);
	}
	
	public void addLinkedActivitiesToStep(Long stepId,List <Long> linkedActs) throws IllegalParameterException{
		StepMaster step = stepDAO.find(stepId);
		if( step == null){
			StringBuilder message =new StringBuilder();
			message.append("Passo nao existe "+stepId+" \n");				
			throw new IllegalParameterException(message.toString()); 			
		}
		for(Long linkedId:linkedActs){
			LinkedActsMaster act = linkedActivityMasterDAO.find(linkedId);
			if(act==null){
				StringBuilder message =new StringBuilder();
				message.append("Atividade ligada nao existe "+linkedId+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{				
				if(!step.getLinkedActivities().contains(act)){
					step.getLinkedActivities().add(act);
				}
			}
		}
		stepDAO.save(step);
		
	}
	public void removeLinkedActivitiesToStep(Long stepId,List <Long> linkedActs) throws IllegalParameterException{
		StepMaster step = stepDAO.find(stepId);
		if( step == null){
			StringBuilder message =new StringBuilder();
			message.append("Passo nao existe "+stepId+" \n");				
			throw new IllegalParameterException(message.toString()); 			
		}
		for(Long linkedId:linkedActs){
			LinkedActsMaster act = linkedActivityMasterDAO.find(linkedId);
			if(act==null){
				StringBuilder message =new StringBuilder();
				message.append("Atividade ligada nao existe "+linkedId+" \n");				
				throw new IllegalParameterException(message.toString()); 
			}
			else{				
				if(step.getLinkedActivities().contains(act)){
					step.getLinkedActivities().remove(act);
				}
			}
		}
		stepDAO.save(step);
	}

}
