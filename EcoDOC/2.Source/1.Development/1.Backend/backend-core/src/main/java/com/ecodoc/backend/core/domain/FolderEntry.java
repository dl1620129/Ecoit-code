package com.ecodoc.backend.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Constant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "folder_entry", schema = "ecodoc")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FolderEntry extends BaseModel {
	@Column(name = "name")
	private String name;
	
	@Column(name = "title")
	private String title;	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "nodeId")
	private String nodeId;
	
	@Column(name = "parentNodeId")
	private String parentNodeId;
	
	public void set(FolderEntry fe) {
		this.name = BussinessCommon.cutCharacter(fe.getName(), Constant.FOLDERENTRY_NAME_LENGTH, true, "name", Constant.FOLDERENTRY_NAME);
		this.nodeId = BussinessCommon.cutCharacter(fe.getNodeId(), Constant.FOLDERENTRY_NODEID_LENGTH, true, "nodeId", Constant.FOLDERENTRY_NODEID);
		this.parentNodeId = BussinessCommon.cutCharacter(fe.getParentNodeId(), Constant.FOLDERENTRY_PARENTID_LENGTH, true, "parentNodeId", Constant.FOLDERENTRY_PARENTID);
	
	}
}
