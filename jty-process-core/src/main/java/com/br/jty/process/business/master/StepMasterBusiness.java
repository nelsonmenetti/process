package com.br.jty.process.business.master;

import java.util.ArrayList;
import java.util.List;

import com.br.jty.process.business.exception.IllegalParameterException;
import com.br.jty.process.entity.dao.ActivityMasterDAO;
import com.br.jty.process.entity.dao.LinkedActsMasterDAO;
import com.br.jty.process.entity.dao.StepDAO;
import com.br.jty.process.entity.master.ActivityMaster;
import com.br.jty.process.entity.master.LinkedActsMaster;

public class StepMasterBusiness {

	private StepDAO stepDAO= new StepDAO();
	private LinkedActsMasterDAO linkedActivityMasterDAO = new LinkedActsMasterDAO();
	private ActivityMasterDAO activityMasterDAO = new ActivityMasterDAO();

	public void createStep(String name, List<Long>activities, List <Long> linkedActs) throws IllegalParameterException{
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
		
		
		
	}
	
	public void updateStep(){}
	public void deleteStep(){}
	public void addActivityToStep(){}	
	public void removeActivityFromStep(){}
	public void addDepencyActivitiesToStep(){}
	public void removeDepencyActivitiesToStep(){}

}
