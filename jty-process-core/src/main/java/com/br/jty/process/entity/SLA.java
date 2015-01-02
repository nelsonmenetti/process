package com.br.jty.process.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class SLA {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="SLA_ID")
	private Long id;
	@Column
	private Long maxWorkingHoursToDone;
	@Column
	private Date initialDate;
	@Column
	private Date finalDate;
	@Column
	private Long hoursDuetoFinish;
	@Column
	private Long hoursSpentInTask;
	@Column
	private Long hoursOverdue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMaxWorkingHoursToDone() {
		return maxWorkingHoursToDone;
	}
	public void setMaxWorkingHoursToDone(Long maxWorkingHoursToDone) {
		this.maxWorkingHoursToDone = maxWorkingHoursToDone;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	public Long getHoursDuetoFinish() {
		return hoursDuetoFinish;
	}
	public void setHoursDuetoFinish(Long hoursDuetoFinish) {
		this.hoursDuetoFinish = hoursDuetoFinish;
	}
	public Long getHoursSpentInTask() {
		return hoursSpentInTask;
	}
	public void setHoursSpentInTask(Long hoursSpentInTask) {
		this.hoursSpentInTask = hoursSpentInTask;
	}
	public Long getHoursOverdue() {
		return hoursOverdue;
	}
	public void setHoursOverdue(Long hoursOverdue) {
		this.hoursOverdue = hoursOverdue;
	}
	
	
}
