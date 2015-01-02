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
	
	@ManyToMany
	@JoinTable(name="step_master_acts")
	private List <ActivityMaster> activities ;

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
	
}
