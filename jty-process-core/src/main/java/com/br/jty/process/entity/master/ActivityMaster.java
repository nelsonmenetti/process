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
		
	@ManyToOne
	@JoinColumn (name="COSTCENTER_ID")
	private CostCenter costCenter;
	
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


	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public StepMaster getStep() {
		return step;
	}

	public void setStep(StepMaster step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "ActivityMaster [id=" + id + ", name=" + name + ", description="
				+ description + ", department=" + department + ", SLA=" + SLA
				+", costCenter="+ costCenter + ", step=" + step + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SLA == null) ? 0 : SLA.hashCode());
		result = prime * result
				+ ((costCenter == null) ? 0 : costCenter.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((step == null) ? 0 : step.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityMaster other = (ActivityMaster) obj;
		if (SLA == null) {
			if (other.SLA != null)
				return false;
		} else if (!SLA.equals(other.SLA))
			return false;
		if (costCenter == null) {
			if (other.costCenter != null)
				return false;
		} else if (!costCenter.equals(other.costCenter))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (step == null) {
			if (other.step != null)
				return false;
		} else if (!step.equals(other.step))
			return false;
		return true;
	}
	
	
}
