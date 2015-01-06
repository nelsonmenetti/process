package com.br.jty.process.business.master;

import java.util.ArrayList;
import java.util.List;

import com.br.jty.process.business.exception.IllegalParameterException;
import com.br.jty.process.entity.CostCenter;
import com.br.jty.process.entity.Department;
import com.br.jty.process.entity.SLA;
import com.br.jty.process.entity.dao.ActivityMasterDAO;
import com.br.jty.process.entity.dao.CostCenterDAO;
import com.br.jty.process.entity.dao.DepartmentDAO;
import com.br.jty.process.entity.dao.LinkedActsMasterDAO;
import com.br.jty.process.entity.dao.SLADAO;
import com.br.jty.process.entity.master.ActivityMaster;
import com.br.jty.process.entity.master.LinkedActsMaster;

public class ActivityMasterBusiness {

	private ActivityMasterDAO activityMasterDAO = new ActivityMasterDAO();
	private LinkedActsMasterDAO linkedActivityMasterDAO = new LinkedActsMasterDAO();
	private SLADAO SLADAO = new SLADAO();
	private DepartmentDAO departmentDAO = new DepartmentDAO();
	private CostCenterDAO costCenterDAO= new CostCenterDAO();

	public ActivityMaster findActivity(Long id) throws IllegalParameterException{
		if(id == null){
			StringBuilder message =new StringBuilder();
			message.append("Id nulo \n");				
			throw new IllegalParameterException(message.toString()); 
		}
		ActivityMaster result = activityMasterDAO.find(id);
		return result;
	}
	
	public List<ActivityMaster> findActivitiesByName(String name) throws IllegalParameterException{
		if(name == null){
			StringBuilder message =new StringBuilder();
			message.append("Name nulo \n");				
			throw new IllegalParameterException(message.toString()); 
		}
		return activityMasterDAO.find(name);
	}
	
	public LinkedActsMaster findLinkedActivities (Long id) throws IllegalParameterException{
		if(id == null){
			StringBuilder message =new StringBuilder();
			message.append("Id nulo \n");				
			throw new IllegalParameterException(message.toString()); 
		}
		LinkedActsMaster result = linkedActivityMasterDAO.find(id);
		return result;		
	}
	
	public List<LinkedActsMaster> findLinkedActivities (String name) throws IllegalParameterException{
		if(name == null){
			StringBuilder message =new StringBuilder();
			message.append("Name nulo \n");				
			throw new IllegalParameterException(message.toString()); 
		}
		return linkedActivityMasterDAO.find(name);
	}
	
	public ActivityMaster createActivity(String name,String  description,Long departmentId, Long slaId, Long costCenterId,Long  version) throws IllegalParameterException{
		boolean isSLAValid=validateSLAExists(slaId);
		boolean isDepartmenttValid=validateDepartamentExists(departmentId);
		boolean isCostCenterValid=validateCostCenterExists(costCenterId);
		boolean isCreationInputValid = isSLAValid && isDepartmenttValid && isCostCenterValid ;
		if(isCreationInputValid){
			CostCenter costCenter = new CostCenter();
			costCenter.setId(costCenterId);			
			Department department = new Department();
			department.setId(departmentId);			
			SLA sla= new SLA();
			sla.setId(slaId);
			ActivityMaster master = new ActivityMaster();
			master.setCostCenter(costCenter);
			master.setDepartment(department);
			master.setSLA(sla);
			master.setName(name);
			master.setDescription(description);
			activityMasterDAO.save(master);
			return master;
		}else{			
			StringBuilder message =new StringBuilder();
			if(!isSLAValid){
				message.append("Id de SLA  invalido\n");	
			}else if(!isDepartmenttValid){
				message.append("Id de Departamento invalido\n");					
			}else if(!isCostCenterValid){
				message.append("Id de Centro de custo invalido\n");					
			}		
			throw new IllegalParameterException(message.toString());  
		}
	}	

	public void editActivity(String name,String  description,Long departmentId, Long slaId, Long costCenterId,Long  version, Long activityId)throws IllegalParameterException{
		boolean isSLAValid=validateSLAExists(slaId);
		boolean isDepartmenttValid=validateDepartamentExists(departmentId);
		boolean isCostCenterValid=validateCostCenterExists(costCenterId);
		boolean activityExists=validateActivityExists(activityId);
		boolean isUpdateInputValid = isSLAValid && isDepartmenttValid && isCostCenterValid && activityExists;
		if(isUpdateInputValid){
			CostCenter costCenter = new CostCenter();
			costCenter.setId(costCenterId);			
			Department department = new Department();
			department.setId(departmentId);			
			SLA sla= new SLA();
			sla.setId(slaId);
			ActivityMaster master = new ActivityMaster();
			master.setCostCenter(costCenter);
			master.setDepartment(department);
			master.setSLA(sla);
			master.setName(name);
			master.setDescription(description);
			master.setId(activityId);
			activityMasterDAO.update(master);
		}else{			
			StringBuilder message =new StringBuilder();
			if(!isSLAValid){
				message.append("Id de SLA  invalido\n");	
			}else if(!isDepartmenttValid){
				message.append("Id de Departamento invalido\n");					
			}else if(!isCostCenterValid){
				message.append("Id de Centro de custo invalido\n");					
			}else if(!activityExists){
				message.append("Atividade nao existe\n");				
			}			
			throw new IllegalParameterException(message.toString());  
		}
	}

	public void deleteActivity(Long activityId) throws IllegalParameterException{
		boolean activityExists=validateActivityExists(activityId);
		if(activityExists){
			ActivityMaster master = new ActivityMaster();
			master.setId(activityId);
			activityMasterDAO.remove(master);
		}else{			
			StringBuilder message =new StringBuilder();
			message.append("Atividade nao existe\n");				
			throw new IllegalParameterException(message.toString());  
		}
	}
	
	public LinkedActsMaster createLinkedActivity(String name, List<Long> activitiesIds) throws IllegalParameterException{		
		List<ActivityMaster> orderedActList = new ArrayList<ActivityMaster>();
		LinkedActsMaster master = new LinkedActsMaster();
		master.setName(name);
		master.setOrderedActivityDependencies(orderedActList);
		for(Long activityId:activitiesIds){
			ActivityMaster activity = activityMasterDAO.find(activityId);
			if(activity == null){
				StringBuilder message =new StringBuilder();
				message.append("Atividade"+activityId+"nao existe\n");				
				throw new IllegalParameterException(message.toString());
			}			
			orderedActList.add(activity);
		}		
		
		linkedActivityMasterDAO.save(master);		
		return master;
	}
	
	public void addActivityToLinkedActivity(Long dependencyActId, List<Long> activitiesIds) throws IllegalParameterException{
		LinkedActsMaster master = linkedActivityMasterDAO.find(dependencyActId);
		List<ActivityMaster> orderedActList = new ArrayList<ActivityMaster>();

		if(master != null){
			for(Long activityId:activitiesIds){
				ActivityMaster activity = activityMasterDAO.find(activityId);
				if(activity == null){
					StringBuilder message =new StringBuilder();
					message.append("Atividade"+activityId+"nao existe\n");				
					throw new IllegalParameterException(message.toString());
				}			
				orderedActList.add(activity);
			}			
			master.getOrderedActivityDependencies().addAll(orderedActList);
			linkedActivityMasterDAO.save(master);
		}else{
			StringBuilder message =new StringBuilder();
			message.append("Atividade Ligada"+dependencyActId+"nao existe\n");				
			throw new IllegalParameterException(message.toString());
		}				
	}
		
	public void removeActivityFromLinkedActivity(Long dependencyActId, List<Long> activitiesIds) throws IllegalParameterException{
		LinkedActsMaster master = linkedActivityMasterDAO.find(dependencyActId);
		List<ActivityMaster> orderedActList = new ArrayList<ActivityMaster>();

		if(master != null){
			for(Long activityId:activitiesIds){
				ActivityMaster activity = activityMasterDAO.find(activityId);
				if(activity == null){
					StringBuilder message =new StringBuilder();
					message.append("Atividade"+activityId+"nao existe\n");				
					throw new IllegalParameterException(message.toString());
				}			
				orderedActList.add(activity);
			}			
			master.getOrderedActivityDependencies().removeAll(orderedActList);
			linkedActivityMasterDAO.save(master);
		}else{
			StringBuilder message =new StringBuilder();
			message.append("Atividade Ligada"+dependencyActId+"nao existe\n");				
			throw new IllegalParameterException(message.toString());
		}				
	
	}
	
	public void deleteLinkedActivity(Long dependencyActId) throws IllegalParameterException{
		LinkedActsMaster master = linkedActivityMasterDAO.find(dependencyActId);
		if(master != null){
			linkedActivityMasterDAO.remove(master);
		}else{
			StringBuilder message =new StringBuilder();
			message.append("Atividade Ligada"+dependencyActId+"nao existe\n");				
			throw new IllegalParameterException(message.toString());
		}					
	}
		
	
	private boolean validateSLAExists(Long id){
		boolean exists = false;
		if(SLADAO.find(id) != null){
			exists=true;
		}
		return exists;
	}
	
	private boolean validateDepartamentExists(Long id){
		boolean exists = false;
		if(departmentDAO.find(id) != null){
			exists=true;
		}
		return exists;
	}
	
	private boolean validateCostCenterExists(Long id){
		boolean exists = false;
		if(costCenterDAO.find(id) != null){
			exists=true;
		}
		return exists;
	}
	
	
	
	private boolean validateActivityExists(Long id){
		boolean exists = false;
		if(activityMasterDAO.find(id) != null){
			exists=true;
		}
		return exists;
	}
	
	private boolean validateActivityUniqueForStep(String name, Long stepId){
		boolean exists = false;
		if(activityMasterDAO.find(name,stepId) != null){
			exists=true;
		}
		return exists;
	}

	public ActivityMasterDAO getActivityMasterDAO() {
		return activityMasterDAO;
	}

	public void setActivityMasterDAO(ActivityMasterDAO activityMasterDAO) {
		this.activityMasterDAO = activityMasterDAO;
	}

	public LinkedActsMasterDAO getLinkedActivityMasterDAO() {
		return linkedActivityMasterDAO;
	}

	public void setLinkedActivityMasterDAO(
			LinkedActsMasterDAO linkedActivityMasterDAO) {
		this.linkedActivityMasterDAO = linkedActivityMasterDAO;
	}

	public SLADAO getSLADAO() {
		return SLADAO;
	}

	public void setSLADAO(SLADAO sLADAO) {
		SLADAO = sLADAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public CostCenterDAO getCostCenterDAO() {
		return costCenterDAO;
	}

	public void setCostCenterDAO(CostCenterDAO costCenterDAO) {
		this.costCenterDAO = costCenterDAO;
	}

	

	
	
}
