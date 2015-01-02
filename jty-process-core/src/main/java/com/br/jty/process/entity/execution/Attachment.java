package com.br.jty.process.entity.execution;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Attachment {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="ATTACHMENT_ID")
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private Blob document;

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

	public Blob getDocument() {
		return document;
	}

	public void setDocument(Blob document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "Attachment [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	
	
	
}
