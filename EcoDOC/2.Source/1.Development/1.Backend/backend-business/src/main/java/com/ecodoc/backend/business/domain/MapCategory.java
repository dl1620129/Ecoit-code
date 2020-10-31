package com.ecodoc.backend.business.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.ecodoc.backend.core.domain.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MAP_CATEGORY", schema = "ecodoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapCategory extends BaseModel{
	@Column(name = "name")
	private String name;
	
	@Column(name = "cat_id" , unique = true)
	private Long catId;
}
