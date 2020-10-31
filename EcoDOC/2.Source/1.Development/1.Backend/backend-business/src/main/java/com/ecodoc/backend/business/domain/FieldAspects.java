package com.ecodoc.backend.business.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecodoc.backend.core.domain.BaseModel;

import lombok.Data;

@Entity
@Table(name = "FIELDS_ASPECTS", schema = "ecodoc")
@Data
public class FieldAspects extends BaseModel {

	
	@Column(name = "name")
	private String name;
	
	@Column(name = "prefixedName")
	private String prefixedName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "type")
	private String type;
}
