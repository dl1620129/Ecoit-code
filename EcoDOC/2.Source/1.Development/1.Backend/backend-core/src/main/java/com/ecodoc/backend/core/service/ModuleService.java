package com.ecodoc.backend.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.domain.Module;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.repository.IModuleRepository;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.repository.IUserRoleRepository;

/**
 * @author EcoDOC
 * 
 */
@Service
public class ModuleService extends BaseService<Module> {

	@Autowired
	private IModuleRepository moduleRepository;

	@Autowired
	private IUserRoleRepository userRoleRepository;

	@Override
	public IRepository<Module> getRepository() {
		return moduleRepository;
	}

	@Override
	public List<Module> findByClientId(Long clientId) {
		return moduleRepository.findByActiveAndClientId(true, clientId);
	}

	/**
	 * Lấy danh sách chức năng dưới dạng tree, được map theo danh sách vai trò
	 * @param roleList
	 * @param parentId
	 * @return
	 */
	public List<Module> findByRoleList(List<Role> roleList, Long parentId) {
		List<Module> result = moduleRepository.findByActiveAndRoleAndParentId(roleList, true, parentId);
		if (result != null && result.size() > 0) {
			for (int i = 0; i < result.size(); i++) {
				result.get(i).setSubModule(findByRoleList(roleList, result.get(i).getId()));
			}
		}
		return result;
	}

	/**
	 * Lấy danh chức năng được phân quyền theo userId.
	 * @param userId
	 * @return
	 */
	public List<Module> findByUserId(Long userId) {
		List<Role> roleOfUser=userRoleRepository.findRoleByUserIdAndActive(userId, true, BussinessCommon.getClientId());
		List<Module> result = moduleRepository.findByActiveAndRoleAndParentId(roleOfUser, true, null);
		if (result != null && result.size() > 0) {
			for (int i = 0; i < result.size(); i++) {
				result.get(i).setSubModule(findByRoleList(roleOfUser, result.get(i).getId()));
			}
		}
		return result;
	}

	public List<Module> findByRoleIdList(List<Long> roleList, Long parentId) {
		List<Module> result = moduleRepository.findByActiveAndRoleIdAndParentId(roleList, true, parentId);
		if (result != null && result.size() > 0) {
			for (int i = 0; i < result.size(); i++) {
				result.get(i).setSubModule(findByRoleIdList(roleList, result.get(i).getId()));
			}
		}
		return result;
	}

	public List<Module> findByClientIdAndParentId(Long clientId, Long parentId) {
		List<Module> result = moduleRepository.findByClientIdAndParentId(true, clientId, parentId);
		if (result != null && result.size() > 0) {
			for (int i = 0; i < result.size(); i++) {
				result.get(i).setSubModule(findByClientIdAndParentId(clientId, result.get(i).getId()));
			}
		}
		return result;
	}

	public List<Module> findByActiveAndParentId(Boolean active, Long parentId) {
		List<Module> result = moduleRepository.findByActiveAndParentId(active, parentId);
		if (result != null && result.size() > 0) {
			for (int i = 0; i < result.size(); i++) {
				result.get(i).setSubModule(findByActiveAndParentId(active, result.get(i).getId()));
			}
		}
		return result;
	}

	public Module findByActiveAndId(Boolean active, Long id) {
		Module m = moduleRepository.findByActiveAndId(active, id);
		if (m.getIsParent()) {
			m.setSubModule(findByActiveAndParentId(true, id));
		}
		return m;
	}

	public boolean existModuleByRoleId(ModuleCodeEnum code, long roleId) {
		return moduleRepository.existModuleByRoleId(code.getName(), roleId, true, BussinessCommon.getClientId());
	}
}
