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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EcoDOC
 * 
 */
@Entity
@Table(name = "SYS_POSITION_ROLE", schema = "ecodoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionRole extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "ecodoc.sys_position_role_id_seq", sequenceName = "ecodoc.sys_position_role_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecodoc.sys_position_role_id_seq")
	private Long id;

	@Column(name = "sys_position_id")
	private Long posId;

	@Column(name = "sys_role_id")
	private Long roleId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sys_position_id", insertable = false, updatable = false)
	private Category position;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sys_role_id", insertable = false, updatable = false)
	private Role role;
}
