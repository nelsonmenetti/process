package com.br.jty.process.entity.master;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class LinkedActsMaster implements Serializable {

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
	
	@OneToMany
	private List<ActivityMaster> orderedActivityDependencies ;

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

	public List<ActivityMaster> getOrderedActivityDependencies() {
		return orderedActivityDependencies;
	}

	public void setOrderedActivityDependencies(
			List<ActivityMaster> orderedActivityDependencies) {
		this.orderedActivityDependencies = orderedActivityDependencies;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((orderedActivityDependencies == null) ? 0
						: orderedActivityDependencies.hashCode());
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
		LinkedActsMaster other = (LinkedActsMaster) obj;
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
		if (orderedActivityDependencies == null) {
			if (other.orderedActivityDependencies != null)
				return false;
		} else if (!orderedActivityDependencies
				.equals(other.orderedActivityDependencies))
			return false;		
		return true;
	}
	
	
}
