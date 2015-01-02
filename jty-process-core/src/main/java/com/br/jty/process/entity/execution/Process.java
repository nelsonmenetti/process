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

import com.br.jty.process.entity.master.ProcessMaster;

@Table
@Entity
public class Process implements Serializable{

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
	private String pertainTo;
	
	@ManyToMany
	@JoinTable(name="process_step")	
	private List<Step> steps;

	@OneToOne
	private ProcessMaster master;
	
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

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public ProcessMaster getMaster() {
		return master;
	}

	public void setMaster(ProcessMaster master) {
		this.master = master;
	}

	@Override
	public String toString() {
		return "Process [id=" + id + ", name=" + name + ", pertainTo="
				+ pertainTo + ", steps=" + steps + "]";
	}
}
