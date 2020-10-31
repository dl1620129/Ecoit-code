package com.ecodoc.backend.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Constant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SYS_PREFERENCES", schema = "ecodoc")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Preferences extends BaseModel {
	
	@Column(name = "org_id")
	private int orgId;

	@Column(name = "extension")
	private String extension;
	
	@Column(name = "max_size")
	private int maxSize;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "pre_type")
	private String preType;
	
	public void set(Preferences p) {
		this.name = BussinessCommon.cutCharacter(p.getName(), Constant.PRE_NAME_LENGTH, true, "name", Constant.PRE_NAME);
		this.orgId = p.getOrgId();
		this.setClientId(BussinessCommon.getClientId());
		this.extension = BussinessCommon.cutCharacter(p.getExtension(), Constant.PRE_EXTENSION_LENGTH, true, "extension", Constant.PRE_EXTENSION);
		this.maxSize = p.getMaxSize();
		this.setActive(p.getActive());
	}
}
