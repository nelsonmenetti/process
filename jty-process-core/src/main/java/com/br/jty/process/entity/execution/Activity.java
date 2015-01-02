package com.br.jty.process.entity.execution;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.jty.process.entity.CostCenter;
import com.br.jty.process.entity.SLA;
import com.br.jty.process.entity.User;
import com.br.jty.process.entity.master.ActivityMaster;

@Table
@Entity
public class Activity implements Serializable {
	
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
	private String description;
	
	
	@ManyToOne
	@JoinColumn (name="RESP_ID")
	private User responsible;
		
	@ManyToOne
	@JoinColumn (name="SLA_ID")
	private SLA SLA;
	
	@Column
	private String status ;
	
	@Column
	private String result;
	
	@ManyToOne
	@JoinColumn (name="COSTCENTER_ID")
	private CostCenter costCenter;
	
	@ManyToMany
	@JoinTable(name="activity_atachment")
	private List<Attachment> attachments;
	
	@ManyToMany
	@JoinTable(name="activity_message")	
	private List<Message> messages;

	@ManyToOne
	@JoinColumn (name="STEP_ID")
	private Step step;
	
	@OneToOne
	@JoinColumn (name="MASTER_ID")
	private ActivityMaster master;

	public ActivityMaster getMaster() {
		return master;
	}

	public void setMaster(ActivityMaster master) {
		this.master = master;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getResponsible() {
		return responsible;
	}

	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}

	public SLA getSLA() {
		return SLA;
	}

	public void setSLA(SLA sLA) {
		SLA = sLA;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", description="
				+ description + ", responsible=" + responsible + ", SLA=" + SLA
				+ ", status=" + status + ", result=" + result + ", costCenter="
				+ costCenter + ", attachments=" + attachments + ", messages="
				+ messages + ", step=" + step + "]";
	}
}
