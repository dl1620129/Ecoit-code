package com.ecodoc.backend.business.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ecodoc.backend.core.domain.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "FIELDS", schema = "ecodoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fields extends BaseModel {

	@Column(name = "author")
	private String author;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "namespaceUri")
	private String namespaceUri;
	
	@Column(name = "namespacePrefix")
	private String namespacePrefix;
	
	@Column(name = "status")
	private String status;
	
	@Transient  
	private List<FieldsType> listFieldType;
	
	
}
