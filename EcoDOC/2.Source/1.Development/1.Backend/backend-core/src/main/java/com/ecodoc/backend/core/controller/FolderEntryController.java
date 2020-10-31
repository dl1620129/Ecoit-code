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
import com.ecodoc.backend.core.domain.FolderEntry;
import com.ecodoc.backend.core.exception.RestForbidden;
import com.ecodoc.backend.core.service.FolderEntryService;
import com.ecodoc.backend.core.service.RoleService;

@RestController
@RequestMapping("/folder-entry")
public class FolderEntryController {

	@Autowired
	private FolderEntryService folderEntryService;

	@Autowired
	private RoleService roleService;

	private void checkPermission() {
		if (roleService.existUserInModule(ModuleCodeEnum.ORG.getName())) {
			return;
		}
		throw new RestForbidden("Bạn không có quyền truy cập vào người dùng");
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllFolderEntry() {
		List<FolderEntry> data = folderEntryService.getAllFolderEntry();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createFolderEntry(@RequestBody FolderEntry input) {
		checkPermission();
		return new ResponseEntity<>(folderEntryService.createFolderEntry(input), HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FolderEntry input) {
		checkPermission();
		return new ResponseEntity<>(folderEntryService.updateFolderEntry(input, id), HttpStatus.OK);
	}

	@PostMapping(value = "/active")
	public ResponseEntity<?> active(@RequestBody Long[] ids) {
		checkPermission();
		for (Long id : ids) {
			FolderEntry data = folderEntryService.findByClientIdAndId(BussinessCommon.getClientId(), id);
			System.out.println(data.getActive());
			if (data == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			data.setActive(true);
			folderEntryService.save(data);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/deactive")
	public ResponseEntity<FolderEntry> deactive(@RequestBody Long[] ids) {
		checkPermission();
		for (Long id : ids) {
			FolderEntry data = folderEntryService.findByClientIdAndId(BussinessCommon.getClientId(), id);
			if (data == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			data.setActive(false);
			folderEntryService.save(data);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
