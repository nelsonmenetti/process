package com.br.jty.process.entity.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.jty.process.entity.CostCenter;
import com.br.jty.process.entity.Department;
import com.br.jty.process.entity.SLA;

@Table
@Entity
public class ActivityMaster implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="ACT_ID")
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	
	@ManyToOne
	@JoinColumn (name="DEPT_ID")
	private Department department;
		
	@ManyToOne
	@JoinColumn (name="SLA_ID")
	private SLA SLA;
	
	@Column
	private String status ;
	
	@Column
	private String result;
	
	@ManyToOne
	@JoinColumn (name="COSTCENTER_ID")
	private CostCenter costCenter;
	
	@Column
	private Long version;
	
	@ManyToOne
	StepMaster step;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public SLA getSLA() {
		return SLA;
	}

	public void setSLA(SLA sLA) {
		SLA = sLA;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public StepMaster getStep() {
		return step;
	}

	public void setStep(StepMaster step) {
		this.step = step;
	}
	
}
