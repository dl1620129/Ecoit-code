package com.ecodoc.backend.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EcoDOC
 * 
 */
@Entity
@Table(name = "PERMISSION", schema = "ecodoc", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "sys_module_id", "sys_role_id" }) })
@Getter
@Setter
public class Permission extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "ecodoc.permission_id_seq", sequenceName = "ecodoc.permission_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecodoc.permission_id_seq")
	private Long id;

	@Column(name = "sys_module_id")
	private Long moduleId;
	@Column(name = "sys_role_id")
	private Long roleId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sys_module_id",insertable = false, updatable = false)
	private Module module;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sys_role_id",insertable = false, updatable = false)
	private Role role;
}
