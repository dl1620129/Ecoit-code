package com.ecodoc.backend.business.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecodoc.backend.core.domain.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "FIELDS_TYPE", schema = "ecodoc")
@NoArgsConstructor
@AllArgsConstructor
public class FieldsType extends BaseModel{
	
	@Column(name = "parentName")
	private String parentName;
	
	@Column(name = "name")
	private String name;

	@Column(name = "description") 
	private String description;
	
	@Column(name = "title") 
	private String title;
	
	
}
