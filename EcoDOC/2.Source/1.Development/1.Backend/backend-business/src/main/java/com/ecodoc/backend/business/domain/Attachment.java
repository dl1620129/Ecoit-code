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
@Table(name = "ATTACHMENT", schema = "ecodoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment extends BaseModel{
	private String name;
	private String type;
	private Long size;

	@Column(name = "document_id")
	private Long documentId;

	public String getDisplayName() {
		return FilesStorageService.origin(this.name);
	}
}