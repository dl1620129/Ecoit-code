package com.ecodoc.backend.core.dto;

import com.ecodoc.backend.core.common.BussinessCommon;

import lombok.Data;
@Data
public class FileentryDto {
	private String name;
	private String description;
	private String extension;
	private String minetype;
	private String folderId;
	private String fileId;
	
	public FileentryDto convert(FileentryDto filedto) {
		filedto.name= BussinessCommon.convert(filedto.name);
		filedto.description= BussinessCommon.convert(filedto.description);
		filedto.extension= BussinessCommon.convert(filedto.extension);
		filedto.minetype= BussinessCommon.convert(filedto.minetype);
		filedto.folderId= BussinessCommon.convert(filedto.folderId);
		filedto.fileId= BussinessCommon.convert(filedto.fileId);
		return filedto;
	}
}
