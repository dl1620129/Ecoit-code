package com.ecodoc.backend.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "SYS_CATEGORY", schema = "ecodoc", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "client_id", "name", "category_type_id" }) })
@JsonIgnoreProperties({ "createDate", "updateDate", "createBy", "updateBy", "client", "is_default" , "hibernateLazyInitializer"})
public class Category extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String name;

	@Column(name = "order_number")
	private Integer order;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_type_id", updatable = false, insertable = false)
	private CategoryType categoryType;
	@Column(name = "category_type_id", nullable = false)
	private Long categoryTypeId;

	@Column(name = "is_default")
	private Boolean isDefault;
	
	@Column(name = "sync_code")
	private Long syncCode;
	
	@Column(name = "is_ldap")
	private Boolean isLdap;
}