package com.br.jty.process.entity.execution;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.jty.process.entity.master.StepMaster;


@Table
@Entity
public class Step implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="STEP_ID")
	private Long id;
	
	@ManyToMany
	@JoinTable(name="step_acts")
	private List <Activity> activities ;
	
	@OneToOne
	private StepMaster master;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public StepMaster getMaster() {
		return master;
	}

	public void setMaster(StepMaster master) {
		this.master = master;
	}
	
}
