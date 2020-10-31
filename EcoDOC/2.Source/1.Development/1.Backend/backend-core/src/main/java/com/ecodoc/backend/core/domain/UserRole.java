package com.ecodoc.backend.core.domain;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EcoDOC
 * 
 */
@Entity
@Table(name = "SYS_USER_ROLE", schema = "ecodoc", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "sys_user_id", "sys_role_id" }) })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "ecodoc.sys_user_role_id_seq", sequenceName = "ecodoc.sys_user_role_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecodoc.sys_user_role_id_seq")
	private Long id;

	@Column(name = "sys_user_id")
	private Long userId;

	@Column(name = "sys_role_id")
	private Long roleId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sys_user_id", insertable = false, updatable = false)
	private User user;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sys_role_id", insertable = false, updatable = false)
	private Role role;
}
