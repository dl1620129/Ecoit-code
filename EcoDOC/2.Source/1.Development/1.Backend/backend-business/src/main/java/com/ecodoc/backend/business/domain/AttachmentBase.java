package com.ecodoc.backend.business.domain;

import javax.persistence.MappedSuperclass;

import org.springframework.web.multipart.MultipartFile;

import com.ecodoc.backend.core.domain.BaseModel;
import com.ecodoc.backend.core.service.FilesStorageService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class AttachmentBase extends BaseModel {
	private static final long serialVersionUID = 1L;

	private String name;
	private String type;
	private Long size;

	public String getDisplayName() {
		return FilesStorageService.origin(this.name);
	}

	public AttachmentBase(MultipartFile file) {
		this.type = file.getContentType();
		this.size = file.getSize();
	}

}
