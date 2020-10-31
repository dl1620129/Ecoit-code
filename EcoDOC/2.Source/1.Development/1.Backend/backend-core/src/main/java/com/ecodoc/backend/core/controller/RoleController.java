package com.ecodoc.backend.core.controller;

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
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.service.IService;
import com.ecodoc.backend.core.service.PositionRoleService;
import com.ecodoc.backend.core.service.RoleService;
import com.ecodoc.backend.core.service.UserRoleService;
import com.ecodoc.backend.core.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role> {
	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PositionRoleService posRoleService;

	@Override
	public IService<Role> getService() {
		// TODO Auto-generated method stub
		return roleService;
	}

	@PostMapping("/add")
	public ResponseEntity<Role> create(@RequestBody Role module) {
		try {
			return new ResponseEntity<Role>(getService().save(module), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/updateRole/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody Role input) {
		Role data = getService().findByClientIdAndId(getClientId(), Long.valueOf(id));
		if (data != null) {
			data.setName(input.getName());
			data = getService().save(data);
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("/getUserActiveByRole/{roleId}")
	public ResponseEntity<?> getUserActiveByRole(@PathVariable long roleId) {
		List<User> data = userRoleService.findUserByRoleIdAndActive(roleId, true);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping("/getPositionActiveByRole/{roleId}")
	public ResponseEntity<?> getPositionActiveByRole(@PathVariable long roleId) {
		List<Category> data = posRoleService.findPositionByRoleIdAndActiveAndClientId(roleId, true, BussinessCommon.getClientId());
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
