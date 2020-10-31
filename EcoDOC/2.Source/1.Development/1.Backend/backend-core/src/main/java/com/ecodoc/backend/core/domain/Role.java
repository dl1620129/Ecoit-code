package com.ecodoc.backend.core.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.WhereJoinTable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EcoDOC
 * 
 */
@Entity
@Table(name = "SYS_ROLE", schema = "ecodoc")
@Getter
@Setter
public class Role extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

	@Column(name = "is_default")
	private Boolean isDefault;
	
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name = "PERMISSION", schema = "ecodoc", joinColumns = {
			@JoinColumn(name = "sys_role_id") }, inverseJoinColumns = {
					@JoinColumn(name = "sys_module_id") })
	@WhereJoinTable(clause = "active=true")
	private Collection<Module> modules;
	
	@Override
    public boolean equals(Object anObject) {
        if (!(anObject instanceof Role)) {
            return false;
        }
        Role otherObject = (Role)anObject;
        return otherObject.getId().equals(this.getId());
    }
}