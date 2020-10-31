package com.ecodoc.backend.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.domain.Permission;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.repository.IPermissionRepository;
import com.ecodoc.backend.core.repository.IRepository;

@Service
public class PermissionService extends BaseService<Permission> {

	@Autowired
	private IPermissionRepository permissionRepository;

	@Override
	public IRepository<Permission> getRepository() {
		return permissionRepository;
	}

	public List<Permission> findActiveByClientAndRole(Long clientId, List<Role> roleList) {
		return permissionRepository.findByClientAndRole(clientId, roleList, true);
	}

	public Permission findByRoleIdAndModuleId(Long roleId, Long moduleId) {
		return permissionRepository.findByRoleIdAndModuleId(roleId, moduleId);
	}

}
