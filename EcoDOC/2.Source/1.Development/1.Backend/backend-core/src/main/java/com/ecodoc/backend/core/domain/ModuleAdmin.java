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
@Table(name = "SYS_MODULE", schema = "ecodoc")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ModuleAdmin extends BaseModel {
	
	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;
	
//	Đường dẫn
	@Column(name = "router_path")
	private String routerPath;
	
	@Column(name = "fa_icon")
	private String faIcon;
	
//	Đường dẫn source
	@Column(name = "component_name")
	private String componentName;
	
	
	@Column(name = "parent_id")
	private Long parentId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_default")
	private boolean isDefault;
	
	@Column(name = "is_parent")
	private boolean isParent;
	
	@Column(name = "expanded")
	private boolean expanded;
	
	@Column(name = "order_number")
	private Integer order;
	
	public void set(ModuleAdmin mda) {
		this.name = BussinessCommon.cutCharacter(mda.getName(), Constant.MDA_NAME_LENGTH, true, "name", Constant.MDA_NAME);
		this.code = BussinessCommon.cutCharacter(mda.getCode(), Constant.MDA_CODE_LENGTH, true, "code", Constant.MDA_CODE);
		this.routerPath = BussinessCommon.cutCharacter(mda.getRouterPath(), Constant.MDA_ROUTER_PATH_LENGTH, false, "router_path", Constant.MDA_ROUTER_PATH);
		this.faIcon = mda.getFaIcon() == null ? null : BussinessCommon.cutCharacter(mda.getFaIcon(), Constant.MDA_ICON_LENGTH, false, "fa_icon", Constant.MDA_ICON);
		this.componentName = mda.getComponentName() == null ? null : BussinessCommon.cutCharacter(mda.getComponentName(), Constant.MDA_COMPONENT_NAME_LENGTH, false, "component_name", Constant.MDA_COMPONENT_NAME);
		this.parentId = mda.getParentId() == null ? null : mda.getParentId();
		this.isParent = mda.getParentId() == null ? true : false;
		this.expanded = mda.getParentId() == null ? true : false;
		this.description = mda.getDescription() == null ? null : BussinessCommon.cutCharacter(mda.getDescription(), Constant.MDA_DESCRIPTION_LENGTH, false, "description", Constant.MDA_DESCRIPTION);
		this.setActive(mda.getActive());
		//this.order = BussinessCommon.required(org.getOrder(), "order", Constant.ORG_ORDER_NUMBER);
		this.order = mda.getOrder() == null || mda.getOrder().intValue() == 0 ? 1 : mda.getOrder();
	}
}
