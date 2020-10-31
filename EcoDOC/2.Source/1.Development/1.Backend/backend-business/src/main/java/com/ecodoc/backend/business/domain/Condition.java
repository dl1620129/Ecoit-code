package com.ecodoc.backend.business.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ecodoc.backend.core.domain.BaseModel;
import com.ecodoc.backend.core.domain.Category;
import com.ecodoc.backend.core.domain.Organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CONDITION", schema = "ecodoc")
@JsonIgnoreProperties({"id", "clientId", "createDate", "updateDate", "createBy", "updateBy"})
public class Condition extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Column(name = "org_id")
	private Long orgId;
	@ManyToOne
	@JoinColumn(name = "org_id", updatable = false, insertable = false)
	private Organization org;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "node_id")
	@JsonIgnore
	@ToString.Exclude
	private NodeModel node;
	@Column(name = "node_id", updatable = false, insertable = false)
	private Long nodeId;

	@Column(name = "position_id")
	private Long positionId;
	@ManyToOne
	@JoinColumn(name = "position_id", updatable = false, insertable = false)
	private Category position;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "is_allow_config")
	private Boolean allowConfig = true;

	public void setAllowConfig(Boolean allowConfig) {
		if (allowConfig == null) {
			allowConfig = true;
		}
		this.allowConfig = allowConfig;
	}

	public void clone(Condition condition) {
		this.orgId = condition.orgId;
		this.positionId = condition.positionId;
		this.userId = condition.userId;
		this.allowConfig = condition.allowConfig;
	}

	public boolean valid() {
		return this.orgId != null || this.positionId != null || this.userId != null;
	}
}
