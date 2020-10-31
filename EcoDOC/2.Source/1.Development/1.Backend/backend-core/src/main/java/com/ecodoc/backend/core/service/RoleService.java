package com.ecodoc.backend.core.service;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.repository.IRoleRepository;

/**
 * @author EcoDOC
 * 
 */
@Service
public class RoleService extends BaseService<Role> {

	@Autowired
	UserRoleService urService;

	@Autowired 
	private UserService userService;

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public IRepository<Role> getRepository() {
		return roleRepository;
	}

	public Role findRoleByNameAndClientId(String role, Long clientId) {
		return roleRepository.findByClientIdAndName(clientId, role);
	}

	public boolean isVanThuVBDen(User user) {
		 return userService.checkUserIdByModuleCodeAndClientId(user.getId(), Arrays.asList(ModuleCodeEnum.DOC_OUT_LIST.getName()), user.getClientId());
	}

	public boolean isVanThuVBDenByOrg(User user, long org) {
		 return userService.checkUserIdByModuleCodeAndOrgAndClientId(user.getId(), org, Arrays.asList(ModuleCodeEnum.DOC_OUT_LIST.getName()), user.getClientId());
	}
	
	public boolean isSupervisor(User user) {
		 return userService.checkUserIdByModuleCodeAndClientId(user.getId(), Arrays.asList(ModuleCodeEnum.TRACK_DOC_IN.getName(), ModuleCodeEnum.TRACK_DOC_OUT.getName()), user.getClientId());
	}

	public boolean isVanThuVBDi(User user) {
		return userService.checkUserIdByModuleCodeAndClientId(user.getId(), Arrays.asList(ModuleCodeEnum.DRAFT_ISSUED.getName()), user.getClientId());
	}

	public boolean isVanThuVBDiByOrg(User user, long org) {
		return userService.checkUserIdByModuleCodeAndOrgAndClientId(user.getId(), org, Arrays.asList(ModuleCodeEnum.DRAFT_ISSUED.getName()), user.getClientId());
	}

	public boolean existUserInModule(String code) {
		User user = BussinessCommon.getUser();
		if (user.getCurrentRole() == null || user.getCurrentRole().equals(0L)) {
			if (roleRepository.existUserInModuleByUser(user.getId(), code)) return true;
			return roleRepository.existUserInModuleByPosition(user.getId(), code);
		}
		return roleRepository.existRoleByModuleCode(user.getCurrentRole(), Arrays.asList(code), BussinessCommon.getClientId());
	}

	public List<User> getListVanThuVBDenByOrg(Long orgId) {
		return userService.getListUserByModuleCodeAndOrgAndClientId(Arrays.asList(ModuleCodeEnum.DOC_OUT_LIST.getName()), orgId, BussinessCommon.getClientId());
	}
	
	public List<Long> getListIdsVanThuVBDenByOrg(Long orgId) {
		return userService.getListUserIdByModuleCodeAndOrgAndClientId(Arrays.asList(ModuleCodeEnum.DOC_OUT_LIST.getName()), orgId, BussinessCommon.getClientId());
	}

	public List<Role> getRoleHaveModuleByUser(ModuleCodeEnum code, User user){
		return roleRepository.getRoleHaveModuleByUserAndActiveAndClientId(code.getName(), user.getId(), user.getPosition(), true, BussinessCommon.getClientId());
	}
}
