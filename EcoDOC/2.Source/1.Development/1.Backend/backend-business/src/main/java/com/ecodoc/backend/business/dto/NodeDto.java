package com.ecodoc.backend.business.dto;

import com.ecodoc.backend.business.util.NodeType;
import com.ecodoc.backend.util.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NodeDto {
	private Long id;
	private String name;
	private boolean lastNode;

	public NodeDto(Long id, String name, String type, String flowName) {
		this.id = id;
		if (StringUtils.isNullOrEmpty(flowName)) {
			this.name = name;
		} else {
			this.name = flowName;
		}
		this.lastNode = NodeType.END_EVENT.equals(type);
	}

	public NodeDto(Long id, String name, String type, String flowName, String bpmnName) {
		this(id, name, type, flowName);
		this.name = bpmnName + " - " + this.name;
	}

}
