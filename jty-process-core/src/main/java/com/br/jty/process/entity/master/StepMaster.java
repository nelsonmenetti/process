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
public class StepMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="STEP_ID")
	private Long id;
	
	@Column
	private String name;
	
	
	@ManyToMany
	@JoinTable(name="step_master_acts")
	private List <ActivityMaster> activities ;

	@ManyToMany
	@JoinTable(name="step_master_linked_acts")
	private List <LinkedActsMaster> linkedActivities ;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ActivityMaster> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityMaster> activities) {
		this.activities = activities;
	}

	
	
	public List<LinkedActsMaster> getLinkedActivities() {
		return linkedActivities;
	}

	public void setLinkedActivities(List<LinkedActsMaster> linkedActivities) {
		this.linkedActivities = linkedActivities;
	}

		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		StepMaster other = (StepMaster) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
