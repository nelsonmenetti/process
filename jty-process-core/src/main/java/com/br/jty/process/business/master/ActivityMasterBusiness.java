package com.br.jty.process.business.master;

import com.br.jty.process.business.exception.IllegalParameterException;
import com.br.jty.process.entity.CostCenter;
import com.br.jty.process.entity.Department;
import com.br.jty.process.entity.SLA;
import com.br.jty.process.entity.dao.DAO;
import com.br.jty.process.entity.master.ActivityMaster;
import com.br.jty.process.entity.master.StepMaster;

public class ActivityMasterBusiness {

	DAO<ActivityMaster> activityMasterDAO = new DAO<ActivityMaster>();
	
	public ActivityMaster createActivity(String name,String  description,Long departmentId, Long slaId, Long costCenterId,Long  version, Long stepId) throws IllegalParameterException{
		boolean isSLAValid=validateSLAExists(slaId);
		boolean isDepartmenttValid=validateDepartamentExists(departmentId);
		boolean isCostCenterValid=validateCostCenterExists(costCenterId);
		boolean isStepValid = validateStep(stepId);
		boolean isActivityUnique=validateActivityUniqueForStep(name, stepId);
		boolean isCreationInputValid = isSLAValid && isDepartmenttValid && isCostCenterValid && isActivityUnique && isStepValid;
		if(isCreationInputValid){
			CostCenter costCenter = new CostCenter();
			costCenter.setId(costCenterId);			
			Department department = new Department();
			department.setId(departmentId);			
			SLA sla= new SLA();
			sla.setId(slaId);
			StepMaster step = new StepMaster();
			step.setId(stepId);
			ActivityMaster master = new ActivityMaster();
			master.setCostCenter(costCenter);
			master.setDepartment(department);
			master.setSLA(sla);
			master.setName(name);
			master.setStep(step);
			master.setDescription(description);
			master.setStep(step);
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
			}else if(!isStepValid){
				message.append("Id do Passo invalido\n");				
			}else if(!isActivityUnique){
				message.append("Atividade nao e unica neste Passo com este nome\n");	
			}			
			throw new IllegalParameterException(message.toString());  
		}
	}	

	public void editActivity(String name,String  description,Long departmentId, Long slaId, Long costCenterId,Long  version, Long activityId)throws IllegalParameterException{
		boolean isSLAValid=validateSLAExists(slaId);
		boolean isDepartmenttValid=validateDepartamentExists(departmentId);
		boolean isCostCenterValid=validateCostCenterExists(costCenterId);
		boolean isActivityExists=validateActiviy(activityId);
		boolean isUpdateInputValid = isSLAValid && isDepartmenttValid && isCostCenterValid && isActivityExists;
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
			activityMasterDAO.update(master);
		}else{			
			StringBuilder message =new StringBuilder();
			if(!isSLAValid){
				message.append("Id de SLA  invalido\n");	
			}else if(!isDepartmenttValid){
				message.append("Id de Departamento invalido\n");					
			}else if(!isCostCenterValid){
				message.append("Id de Centro de custo invalido\n");					
			}else if(!isActivityExists){
				message.append("Atividade nao existe\n");				
			}			
			throw new IllegalParameterException(message.toString());  
		}
	}

	
	public void createDependencyActivity(){}
	public void editDependencyActivity(){}
	public void deleteActivity(){}
	public void deleteDependencyActivity(){}

	public void attachDocumentToActivity(){}
	public void removeDocumentFromActivity(){}
	
	
	
	
	
	private boolean validateSLAExists(Long id){
		return false;
	}
	
	private boolean validateDepartamentExists(Long id){
		return false;
	}
	
	private boolean validateCostCenterExists(Long id){
		return false;
	}
	
	private boolean validateStep(Long stepId){
		return false;
	}
	
	private boolean validateActiviy(Long activityId){
		return false;
	}
	
	private boolean validateActivityUniqueForStep(String name, Long stepId){
		return false;
	}


	public DAO<ActivityMaster> getActivityMasterDAO() {
		return activityMasterDAO;
	}


	public void setActivityMasterDAO(DAO<ActivityMaster> activityMasterDAO) {
		this.activityMasterDAO = activityMasterDAO;
	}
	
	
}
