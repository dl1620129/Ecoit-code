package com.ecodoc.backend.core.dto;

import java.util.List;

import lombok.Data;

@Data
public class Calendar2OrgInfo {
	private List<Long> orgAndSub;
	private String orgName;
	private String rootOrgName;
}
