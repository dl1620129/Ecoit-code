package com.ecodoc.backend.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "DOCUMENT", schema = "ecodoc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Document extends BaseModel {
	@Column(name = "name")
	private String name;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "nodeId")
	private String nodeId;
	
	@Column(name = "bpmnId")
	private Long bpmnid;
	
	@Column(name = "author")
	private String author;
	
	@OneToOne
	@JoinColumn(name = "fileEntry_id", insertable = false, updatable = false)
	private FileEntry fileEntry;

	@Column(name = "fileEntry_id")
	private Long fileEntryId;

}
