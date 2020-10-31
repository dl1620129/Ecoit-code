package com.ecodoc.backend.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.domain.UserRole;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.repository.IUserRoleRepository;

/**
 * @author EcoDOC
 * 
 */
@Service
public class UserRoleService extends BaseService<UserRole> {

	@Autowired
	private IUserRoleRepository userRoleRepository;

	@Override
	public IRepository<UserRole> getRepository() {
		return userRoleRepository;
	}

	public List<User> findUserByRoleIdAndActive(long roleId, boolean active) {
		List<User> users = userRoleRepository.findByRoleIdAndActive(roleId, active, BussinessCommon.getClientId());
		return users;
	}

	public UserRole findByRoleIdAndUserIdAndActive(Long roleId,Long userId, boolean active) {
		UserRole users = userRoleRepository.findByRoleIdAndUserIdAndActive(roleId,userId, active, BussinessCommon.getClientId());
		return users;
	}

	public List<Role> findRoleByUserIdAndActive(Long userId, boolean active) {
		List<Role> roles = userRoleRepository.findRoleByUserIdAndActive(userId, active, BussinessCommon.getClientId());
		return roles;
	}

	public List<Long> findRoleIdByUserIdAndActive(Long userId, boolean active) {
		List<Long> roles = userRoleRepository.findRoleIdByUserIdAndActive(userId, active, BussinessCommon.getClientId());
		return roles;
	}

	public List<Role> findRoleByUserName(String userName) {
		List<Role> roles = userRoleRepository.findRoleByUserName(userName, BussinessCommon.getClientId());
		return roles;
	}

	public List<UserRole> findRoleByListUserId(List<Long> userId, Long roleId) {
		List<UserRole> urList = userRoleRepository.findRoleByListUserId(userId, roleId, BussinessCommon.getClientId());
		return urList;
	}

}
