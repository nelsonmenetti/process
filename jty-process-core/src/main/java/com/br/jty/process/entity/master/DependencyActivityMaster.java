package com.br.jty.process.entity.master;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class DependencyActivityMaster extends ActivityMaster {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany
	private List<DependencyActivityMaster> orderedActivityDependencies ;
	
	public List<DependencyActivityMaster> getOrderedActivityDependencies() {
		return orderedActivityDependencies;
	}
	public void setOrderedActivityDependencies(
			List<DependencyActivityMaster> orderedActivityDependencies) {
		this.orderedActivityDependencies = orderedActivityDependencies;
	}
	
}
