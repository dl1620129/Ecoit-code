package com.ecodoc.backend.core.domain;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ecodoc.backend.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SYS_USER", schema = "ecodoc", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "client_id", "user_name" }) })
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "password", "salt", "expiryPass", "lastLogin", "changePass", "createDate", "updateDate",
		"createBy", "updateBy" })
public class User extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Column(name = "full_name", length = 100)
	private String fullName;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password", length = 100)
	private String password;

	private Date birthday;

	@Column(length = 100)
	private String email;

	@Column(length = 20)
	private String phone;

	@Column(name = "gender")
	private Long gender;

	@Column(length = 20)
	private String indentity;

	@Column(length = 50)
	private String title;

	@Column(length = 100)
	private String photo;

	private String signature;

	@Column(name = "phone_ca")
	private String phoneCA;

	@Column(name = "phone_ca_provider")
	private String phoneCAProvider;

	@Column(name = "serial_token")
	private String serialToken;

	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "employee_code")
	private String employeeCode;

	@Column(name = "change_pass")
	private Boolean changePass;

	@Column(name = "expiry_pass")
	private Date expiryPass;

	@Column(name = "last_login")
	private Date lastLogin;

	@Column(name = "salt")
	private String salt;
	
	@Column(name = "name_token")
	private String nameToken;
	
	@Column(name = "org_token")
	private String orgToken;
	
	@Column(name = "start_time_token")
	private String startTimeToken;
	
	@Column(name = "expired_time_token")
	private String expiredTimeToken;

	@Transient
	private List<Role> roles;

	@Transient
	private Collection<Module> authorize;

	@Column(name = "org_id", nullable = false)
	private Long org;

	@Column(name = "position_id")
	private Long position;

	@ManyToOne
	@JoinColumn(name = "org_id", insertable = false, updatable = false)
	private Organization orgModel;

	@ManyToOne
	@JoinColumn(name = "position_id", insertable = false, updatable = false)
	private Category positionModel;

	@Column(name = "lead")
	private boolean lead;

	@Column(name = "is_ldap")
	private boolean isLdap;

	@Column(name = "default_role")
	private Long defaultRole;

	@Column(name = "curr_role")
	private Long currentRole;

	@Column(name = "address")
	private String address;

	@Override
	public boolean equals(Object anObject) {
		if (!(anObject instanceof User)) {
			return false;
		}
		User otherObject = (User) anObject;
		return otherObject.getId().equals(this.getId());
	}

	public void setUser(User nUser) {
		this.fullName = getValue(nUser.fullName, this.fullName);
		this.userName = getValue(nUser.userName, this.userName);
		this.birthday = getValue(nUser.birthday, this.birthday);
		this.email = getValue(nUser.email, this.email);
		this.phone = getValue(nUser.phone, this.phone);
		this.gender = getValue(nUser.gender, this.gender);
		this.indentity = getValue(nUser.indentity, this.indentity);
		this.title = getValue(nUser.title, this.title);
		this.photo = getValue(nUser.photo, this.photo);
		this.signature = getValue(nUser.signature, this.signature);
		this.phoneCA = getValue(nUser.phoneCA, this.phoneCA);
		this.phoneCAProvider = getValue(nUser.phoneCAProvider, this.phoneCAProvider);
		this.serialToken = getValue(nUser.serialToken, this.serialToken);
		this.employeeId = getValue(nUser.employeeId, this.employeeId);
		this.employeeCode = getValue(nUser.employeeCode, this.employeeCode);
		this.org = getValue(nUser.org, this.org);
		this.position = getValue(nUser.position, this.position);
		this.lead = nUser.lead;
		this.isLdap = nUser.isLdap;
		this.address = getValue(nUser.address, this.address);
		this.nameToken = getValue(nUser.nameToken, this.nameToken);
		this.orgToken = getValue(nUser.orgToken, this.orgToken);
		this.startTimeToken = getValue(nUser.startTimeToken, this.startTimeToken);
		this.expiredTimeToken = getValue(nUser.expiredTimeToken, this.expiredTimeToken);
	}
	
	public void setUserLess(User nUser) {
		this.birthday = getValue(nUser.birthday, this.birthday);
		this.email = getValue(nUser.email, this.email);
		this.phone = getValue(nUser.phone, this.phone);
		this.gender = getValue(nUser.gender, this.gender);
		this.photo = getValue(nUser.photo, this.photo);
		this.address = getValue(nUser.address, this.address);
		this.nameToken = getValue(nUser.nameToken, this.nameToken);
		this.orgToken = getValue(nUser.orgToken, this.orgToken);
		this.startTimeToken = getValue(nUser.startTimeToken, this.startTimeToken);
		this.expiredTimeToken = getValue(nUser.expiredTimeToken, this.expiredTimeToken);
	}

	private String getValue(String nVal, String oVal) {
		if (!StringUtils.isNullOrEmpty(nVal) && !nVal.equals(oVal)) {
			return nVal;
		}

		return oVal;
	}

	private Date getValue(Date nVal, Date oVal) {
		if (nVal != null && !nVal.equals(oVal)) {
			return nVal;
		}

		return oVal;
	}

	private Long getValue(Long nVal, Long oVal) {
		if (nVal != null && !nVal.equals(oVal)) {
			return nVal;
		}

		return oVal;
	}
}
