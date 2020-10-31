package com.ecodoc.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OrgParent {
	private Long parent;
	private Long child;
	private String name;
}
