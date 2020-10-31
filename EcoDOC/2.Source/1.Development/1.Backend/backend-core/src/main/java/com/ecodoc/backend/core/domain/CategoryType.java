package com.ecodoc.backend.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ecodoc.backend.core.common.BussinessCommon;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name = "SYS_CATEGORY_TYPE", schema = "ecodoc")
@JsonIgnoreProperties({ "createDate", "updateDate", "createBy", "updateBy", "client","isDefault" })
public class CategoryType extends BaseModel{

	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String name;
	
	private String code;
	
	@Column(name = "super_admin")
	private boolean superAdmin;
	
	@Column(name = "is_default")
	private Boolean isDefault;
	
	public void setName(String name) {
		BussinessCommon.validLengthData(name, "Tên loại danh mục", 50);
		this.name = name;
	}
}