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



	@Override
	public String toString() {
		return "ActivityMaster [id=" + id + ", name=" + name + ", description="
				+ description + ", department=" + department + ", SLA=" + SLA
				+", costCenter="+ costCenter + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
