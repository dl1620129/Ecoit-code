package com.ecodoc.backend.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SYS_FILEENTRY", schema = "ecodoc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileEntry extends BaseModel {
	@Column(name = "name")
	private String name;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "extension")
	private String extension;
	@Column(name = "minetype")
	private String minetype;
	@Column(name = "fileId")
	private String fileId;
	@Column(name = "folderId")
	private String folderId;
	@Column(name = "luongId")
	private Long luongId;  
}
