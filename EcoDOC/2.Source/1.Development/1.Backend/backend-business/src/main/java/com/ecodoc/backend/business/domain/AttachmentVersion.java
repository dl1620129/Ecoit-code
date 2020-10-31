package com.ecodoc.backend.business.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecodoc.backend.core.domain.BaseModel;
import com.ecodoc.backend.core.service.FilesStorageService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DOCUMENT_OUT_ATTACH_VERSION", schema = "ecodoc")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AttachmentVersion extends BaseModel{
	@Column(name = "file_name")
	private String name;
	
	@Column(name = "origin_name")
	private String originName;

	@Column(name = "file_type")
	private String type;

	@Column(name = "file_size")
	private Long size;

	@Column(name = "doc_id")
	private Long docId;
	
	@Column(name = "user_full_name")
	private String userFullName;
	
	@Column(name = "file_version")
	private int version;

	public String getDisplayName() {
		return FilesStorageService.origin(this.name);
	}
}
