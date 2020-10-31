package com.ecodoc.backend.business.dto;

import java.util.List;

import com.ecodoc.backend.core.domain.Module;

import lombok.Data;

@Data
public class RoleModuleDto {
	private long roleId;
	private List<Module> listModule;
}
