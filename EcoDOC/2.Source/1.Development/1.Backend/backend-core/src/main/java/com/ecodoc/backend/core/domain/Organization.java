package com.ecodoc.backend.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ecodoc.backend.core.config.Constant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ecodoc.backend.core.common.BussinessCommon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SYS_ORGANIZATION", schema = "ecodoc", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "client_id", "name", "parent_id" }) })
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "createDate", "updateDate", "createBy", "updateBy" })
public class Organization extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "address")
	private String address;
	@Column(name = "level")
	private int level;
	@Column(name = "parent_id")
	private Long parentId;
	@Column(name="email")
	private String email;
	@Column(name="shortcut")
	private String shortcut;
	@Column(name="note")
	private String note;
	
	@Column(name="org_type")
	private Long orgType;
	@ManyToOne
	@JoinColumn(name = "org_type", insertable = false, updatable = false)
	private Category orgTypeModel;
	
//	@OneToOne(optional = true, fetch = FetchType.EAGER)
//	@JoinColumn(name = "parent_id", insertable = false, updatable = false)
//	private Organization parentOrg;
	@Column(name = "expiry_date")
	private Date expiryDate;
	@JoinColumn(name = "id_cat")
	private Long idCat;
	@Column(name = "root_id")
	private Long rootId;
	@Column(name = "order_number")
	private Integer order;
	@Column(name = "is_ldap")
	private Boolean isLdap;

	@Column(name = "code")
	private Long code;

	@Column(name = "org_id_sync")
	private Long orgIdSync;

	public void set(Organization org) {
		this.name = BussinessCommon.cutCharacter(org.getName(), Constant.ORG_NAME_LENGTH, true, "name", Constant.ORG_NAME);
		this.email = BussinessCommon.cutCharacter(org.getEmail(), Constant.ORG_EMAIL_LENGTH, false, "email", Constant.ORG_EMAIL_NAME);
		this.phone = BussinessCommon.cutCharacter(org.getPhone(), Constant.ORG_PHONE_LENGTH, false, "phone", Constant.ORG_PHONE_NAME);
		this.address = BussinessCommon.cutCharacter(org.getAddress(), Constant.ORG_ADDRESS_LENGTH, false, "address", Constant.ORG_ADDRESS_NAME);
		this.orgType = BussinessCommon.required(org.getOrgType(), "orgType", Constant.ORG_TYPE_NAME);
		this.setActive(org.getActive());
		//this.order = BussinessCommon.required(org.getOrder(), "order", Constant.ORG_ORDER_NUMBER);
		this.order = org.getOrder() == null || org.getOrder().intValue() == 0 ? 1 : org.getOrder();
	}
}
