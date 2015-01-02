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

	@Override
	public String toString() {
		return "ProcessMaster [id=" + id + ", name=" + name + ", pertainTo="
				+ pertainTo + ", steps=" + steps + "]";
	}
}
