package com.ecodoc.backend.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.domain.Category;
import com.ecodoc.backend.core.domain.Module;
import com.ecodoc.backend.core.domain.Permission;
import com.ecodoc.backend.core.domain.PositionRole;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.domain.UserRole;
import com.ecodoc.backend.core.repository.IPermissionRepository;
import com.ecodoc.backend.core.service.ModuleService;
import com.ecodoc.backend.core.service.PermissionService;
import com.ecodoc.backend.core.service.PositionRoleService;
import com.ecodoc.backend.core.service.UserRoleService;

/**
 * @author EcoDOC
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private IPermissionRepository permissionRepository;

	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private PositionRoleService posRoleService;

	@Autowired
	private UserRoleService userRoleService;

	@GetMapping("/inactiveAuthorizeUser/{roleId}/{userId}")
	public ResponseEntity<?> active(@PathVariable long roleId, @PathVariable long userId) {
		try {
			UserRole roleDetail = userRoleService.findByRoleIdAndUserIdAndActive(roleId, userId, true);
			if (roleDetail != null) {
				roleDetail.setActive(false);
				userRoleService.save(roleDetail);
			}
			List<User> data = userRoleService.findUserByRoleIdAndActive(roleId, true);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/inactiveAuthorizePosition/{roleId}/{posId}")
	public ResponseEntity<?> inactiveAuthorizePosition(@PathVariable long roleId, @PathVariable long posId) {
		try {
			PositionRole roleDetail = posRoleService.findByRoleIdAndPosIdAndActiveAndClientId(roleId, posId, true, BussinessCommon.getClientId());
			if (roleDetail != null) {
				roleDetail.setActive(false);
				posRoleService.save(roleDetail);
			}
			List<Category> data = posRoleService.findPositionByRoleIdAndActiveAndClientId(roleId, true, BussinessCommon.getClientId());
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/addAuthorizeUserList/{roleId}")
	public ResponseEntity<?> createMulti(@PathVariable long roleId, @RequestBody List<User> userList) {
		try {
			// Target description: Insert users to roleId
			// Step1: Only insert user does not exist in roleId
			// Step2: Return all user of roleId

			List<UserRole> listData = new ArrayList<UserRole>();
			if (userList != null && userList.size() > 0) {
				UserRole item;
				List<User> userOfRole = userRoleService.findUserByRoleIdAndActive(roleId, true);
				for (int i = 0; i < userList.size(); i++) {
					if (userOfRole != null && userOfRole.size() > 0) {
						for (int j = 0; j < userOfRole.size(); j++) {
							if (userOfRole.get(j).getId() == userList.get(i).getId())
								break;
							// last item
							if (j == userOfRole.size() - 1) {
								item = new UserRole();
								item.setRoleId(roleId);
								item.setActive(true);
								item.setUserId(userList.get(i).getId());
								listData.add(item);
							}
						}
					} else {
						item = new UserRole();
						item.setRoleId(roleId);
						item.setActive(true);
						item.setUserId(userList.get(i).getId());
						listData.add(item);
					}
				}
				listData = userRoleService.saveAll(listData);
			}
			List<User> response = userRoleService.findUserByRoleIdAndActive(roleId, true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/addAuthorizePositionList/{roleId}")
	public ResponseEntity<?> addAuthorizePositionList(@PathVariable long roleId, @RequestBody List<Category> posList) {
		try {
			List<PositionRole> listData = new ArrayList<PositionRole>();
			List<Category> posOfRole = posRoleService.findPositionByRoleIdAndActiveAndClientId(roleId, true, BussinessCommon.getClientId());
			if (posList != null && posList.size() > 0) {
				PositionRole item;
				//List<Category> posOfRole = posRoleService.findPositionByRoleIdAndActiveAndClientId(roleId, true, BussinessCommon.getClientId());
				for (int i = 0; i < posList.size(); i++) {
					if (posOfRole != null && posOfRole.size() > 0) {
						for (int j = 0; j < posOfRole.size(); j++) {
							if (posOfRole.get(j).getId().equals(posList.get(i).getId()))
								break;
							// last item
							if (j == posOfRole.size() - 1) {
								item = new PositionRole();
								item.setRoleId(roleId);
								item.setActive(true);
								item.setPosId(posList.get(i).getId());
								listData.add(item);
							}
						}
					}else {
						item = new PositionRole();
						item.setRoleId(roleId);
						item.setActive(true);
						item.setPosId(posList.get(i).getId());
						listData.add(item);
					}
				}
				listData = posRoleService.saveAll(listData);
			}
			//List<User> response = userRoleService.findUserByRoleIdAndActive(roleId, true);
			List<Category> response = posRoleService.findPositionByRoleIdAndActiveAndClientId(roleId, true, BussinessCommon.getClientId());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/updateAuthorizeModule/{roleId}")
	public ResponseEntity<?> create(@PathVariable long roleId, @RequestBody List<Module> modules) {
		try {
			// Target description: Active/inactive module of role
			// Step1: Insert or update permission record.
			// Step2: Insert or update permission of module child (the sample module parent)
			
			if (modules != null && modules.size() > 0) {
				Permission item;
				for (int i = 0; i < modules.size(); i++) {
					item = permissionService.findByRoleIdAndModuleId(roleId, modules.get(i).getId());
					if (item == null) {
						item = new Permission();
						item.setRoleId(roleId);
						item.setModuleId(modules.get(i).getId());
					}
					if (modules.get(i).getIsChecked() != null) {
						item.setActive(modules.get(i).getIsChecked());
					} else {
						item.setActive(false);
					}
					if (modules.get(i).getIsParent()) {
						updateActivePermission(roleId, modules.get(i).getSubModule());
					}
					permissionService.save(item);
				}
			}
			List<Long> roleList = new ArrayList<Long>();
			roleList.add(roleId);
			List<Module> moduleOfRole = moduleService.findByRoleIdList(roleList, null);
			return new ResponseEntity<>(moduleOfRole, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	private void updateActivePermission(long roleId, List<Module> modules) {
		if (modules != null && modules.size() > 0) {
			Permission item;
			for (int i = 0; i < modules.size(); i++) {
				item = permissionRepository.findByRoleIdAndModuleId(roleId, modules.get(i).getId());
				if (item == null) {
					item = new Permission();
					if (modules.get(i).getIsChecked() != null) {
						item.setActive(modules.get(i).getIsChecked());
					} else {
						item.setActive(false);
					}
					item.setRoleId(roleId);
					item.setModuleId(modules.get(i).getId());
				} else if (item != null) {
					if (modules.get(i).getIsChecked() != null) {
						item.setActive(modules.get(i).getIsChecked());
					} else {
						item.setActive(false);
					}
				}
				if (modules.get(i).getIsParent()) {
					updateActivePermission(roleId, modules.get(i).getSubModule());
				}
				permissionService.save(item);
			}
		}
	}

}
