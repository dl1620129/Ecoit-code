package com.ecodoc.backend.business.dto;

import com.ecodoc.backend.business.domain.BpmnModel.TYPE_DOCUMENT;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BpmnSearchDto {
	private Long id;
	private Boolean active;
	private String name;
	private TYPE_DOCUMENT typeDocument;
	private Long orgId;
	private String orgName;
}
