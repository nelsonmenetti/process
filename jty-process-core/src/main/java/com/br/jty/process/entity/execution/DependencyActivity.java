package com.br.jty.process.entity.execution;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class DependencyActivity extends Activity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany
	private List<DependencyActivity> orderedActivityDependencies ;
	
	public List<DependencyActivity> getOrderedActivityDependencies() {
		return orderedActivityDependencies;
	}
	public void setOrderedActivityDependencies(
			List<DependencyActivity> orderedActivityDependencies) {
		this.orderedActivityDependencies = orderedActivityDependencies;
	}
	
	
}
