package com.br.jty.process.entity.master;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table
@Entity
public class ProcessMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="ACT_ID")
	private Long id;
	
	@Column
	String name;

	@Column
	String pertainTo;
	
	@ManyToMany
	@JoinTable(name="process_master_step")	
	List<StepMaster> steps;

	@Column
	Long version;
	
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

	public String getPertainTo() {
		return pertainTo;
	}

	public void setPertainTo(String pertainTo) {
		this.pertainTo = pertainTo;
	}

	public List<StepMaster> getSteps() {
		return steps;
	}

	public void setSteps(List<StepMaster> steps) {
		this.steps = steps;
	}
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ProcessMaster [id=" + id + ", name=" + name + ", pertainTo="
				+ pertainTo + ", steps=" + steps + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((pertainTo == null) ? 0 : pertainTo.hashCode());
		result = prime * result + ((steps == null) ? 0 : steps.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		ProcessMaster other = (ProcessMaster) obj;
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
		if (pertainTo == null) {
			if (other.pertainTo != null)
				return false;
		} else if (!pertainTo.equals(other.pertainTo))
			return false;
		if (steps == null) {
			if (other.steps != null)
				return false;
		} else if (!steps.equals(other.steps))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
}
