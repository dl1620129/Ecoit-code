package com.ecodoc.backend.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EcoDOC
 * 
 */
@Entity
@Table(name = "SYS_MODULE", schema = "ecodoc")
@Getter
@Setter
public class Module extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;
	@Column(name = "fa_icon")
	private String faIcon;
	@Column(name = "code")
	private String code;
	@Column(name = "description")
	private String description;
	@Column(name = "is_default")
	private Boolean isDefault;
	@Column(name = "order_number")
	private Long orderNumber;
	@Column(name = "router_path")
	private String routerPath;
	@Column(name = "parent_id")
	private Long parentId;
	@Column(name = "component_name")
	private String componentName;
	@Column(name = "is_parent")
	private Boolean isParent;
	@Transient
	private List<Module> subModule;	
	@Transient
	private Boolean isChecked;
	@Column(name = "expanded")
	private Boolean expanded;
	
	@PrePersist
	public void prePersist() {
		if (this.expanded == null) {
			this.expanded = false;
		}
	}
}
