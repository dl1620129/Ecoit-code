package com.ecodoc.backend.core.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.domain.CategoryType;
import com.ecodoc.backend.core.domain.ModuleAdmin;
import com.ecodoc.backend.core.dto.ModuleAdminDto;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestForbidden;
import com.ecodoc.backend.core.service.IService;
import com.ecodoc.backend.core.service.ModuleAdminService;
import com.ecodoc.backend.core.service.RoleService;
import com.ecodoc.backend.util.StringUtils;

@RestController
@RequestMapping("/module-admin")
public class ModuleAdminController{// extends BaseController<ModelAdmin> {
	
	@Autowired
	private ModuleAdminService moduleAdminService;
	
	@Autowired
	public IService<ModuleAdmin> getService(){
		return moduleAdminService;
	}
	
	@Autowired
	private RoleService roleService;
	
	private void checkPermission() {
		if (roleService.existUserInModule(ModuleCodeEnum.ORG.getName())) {
			return;
		}
		throw new RestForbidden("Bạn không có quyền truy cập vào người dùng");
	}
	
	@GetMapping("/getAllModuleAdmin")
	public ResponseEntity<?> getAllModuleAdmin() {
		List<ModuleAdmin> data = moduleAdminService.getAllModule();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ModuleAdmin input){
		checkPermission();
		return new ResponseEntity<>(moduleAdminService.createModuleAdmin(input), HttpStatus.OK);
	}
	
	//@Override
	@PostMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ModuleAdmin input) {
		checkPermission();
		return new ResponseEntity<>(moduleAdminService.updateModuleAdmin(input, id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/active/{id}")
	public ResponseEntity<?> active(@PathVariable Long id) {
		checkPermission();
		ModuleAdmin data = moduleAdminService.findByClientIdAndId(BussinessCommon.getClientId(), id);
		if (data == null || data.getActive()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		data.setActive(true);
		moduleAdminService.save(data);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/deactive/{id}")
	public ResponseEntity<ModuleAdmin> deactive(@PathVariable Long id) {
		checkPermission();
		ModuleAdmin data = moduleAdminService.findByClientIdAndId(BussinessCommon.getClientId(), id);
		if (data == null || !data.getActive()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		data.setActive(false);
		moduleAdminService.save(data);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/search")
	public ResponseEntity<?> searchModuleAdmin(@RequestBody ModuleAdminDto mao) {
		return new ResponseEntity<>(moduleAdminService.searchModuleAdmin(mao), HttpStatus.OK);
	}
}
