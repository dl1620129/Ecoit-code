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
import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.domain.Preferences;
import com.ecodoc.backend.core.dto.PreferencesDto;
import com.ecodoc.backend.core.exception.RestForbidden;
import com.ecodoc.backend.core.service.IService;
import com.ecodoc.backend.core.service.PreferencesService;
import com.ecodoc.backend.core.service.RoleService;

@RestController
@RequestMapping("/preferences")
public class PreferencesController {
	@Autowired
	private PreferencesService preferencesService;
	
	@Autowired
	public IService<Preferences> getService(){
		return preferencesService;
	}
	
	@Autowired
	private RoleService roleService;
	
	private void checkPermission() {
		if (roleService.existUserInModule(ModuleCodeEnum.ORG.getName())) {
			return;
		}
		throw new RestForbidden("Bạn không có quyền truy cập vào người dùng");
	}
	
	@GetMapping("/getAllPreferences")
	public ResponseEntity<?> getAllPreferences(){
		List<Preferences> data = preferencesService.getAllPreferences();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Preferences input){
		checkPermission();
		return new ResponseEntity<>(preferencesService.createPreferences(input), HttpStatus.OK);
	}
	
	//@Override
	@PostMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Preferences input) {
		checkPermission();
		return new ResponseEntity<>(preferencesService.updatePreferences(input, id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/active/{id}")
	public ResponseEntity<?> active(@PathVariable Long id) {
		checkPermission();
		Preferences data = preferencesService.findByClientIdAndId(BussinessCommon.getClientId(), id);
		if (data == null || data.getActive()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		data.setActive(true);
		preferencesService.save(data);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/deactive/{id}")
	public ResponseEntity<Preferences> deactive(@PathVariable Long id) {
		checkPermission();
		Preferences data = preferencesService.findByClientIdAndId(BussinessCommon.getClientId(), id);
		if (data == null || !data.getActive()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		data.setActive(false);
		preferencesService.save(data);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/search")
	public ResponseEntity<?> searchPreferences(@RequestBody PreferencesDto po) {
		return new ResponseEntity<>(preferencesService.searchPreferences(po), HttpStatus.OK);
	}
}
