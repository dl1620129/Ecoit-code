package com.ecodoc.backend.business.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecodoc.backend.core.domain.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FIELDS_PROPERTIES", schema = "ecodoc")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class FieldProperties extends BaseModel {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "custom_type_id")
	private Long customTypeId;
	
	@Column(name = "aspect_id")
	private Long aspectId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "mandatory")
	private Boolean mandatory;
	
	@Column(name = "multiValued")
	private Boolean multiValued;
	
	@Column(name = "mandatoryEnforced")
	private Boolean mandatoryEnforced;
	
	@Column(name = "defaultValue")
	private String defaultValue;
	
	@Column(name = "dataType")
	private String dataType;
	
	@Column(name = "indexed")
	private Boolean indexed;
	
	@Column(name = "facetable")
	private String facetable;
	
	@Column(name = "indexTokenisationMode")
	private String indexTokenisationMode;

}
