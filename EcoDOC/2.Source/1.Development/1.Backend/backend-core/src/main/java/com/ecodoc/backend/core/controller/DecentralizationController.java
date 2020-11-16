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

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.domain.Decentralization;
import com.ecodoc.backend.core.domain.FolderEntry;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.DecentralizationDto;
import com.ecodoc.backend.core.repository.IDecentralizationRepository;
import com.ecodoc.backend.core.repository.IUserRepository;
import com.ecodoc.backend.core.service.DecentralizationService;
import com.ecodoc.backend.core.service.FileEntryService;
import com.ecodoc.backend.core.service.FolderEntryService;
import com.ecodoc.backend.core.service.UserService;

public class DecentralizationController {
	
	@Autowired
	private FolderEntryService folderEntry;
	
	@Autowired
	private DecentralizationService decenService;
	
	@Autowired
	private IUserRepository userRepo;
	
	@PostMapping("/addDecenFolder/{folderId}")
	public ResponseEntity<?> createPermissionFolder(@PathVariable Long folderId, @RequestBody List<User> userList, @PathVariable Long permission){
		try {
			List<Decentralization> listData = new ArrayList<Decentralization>();
			if(userList != null && userList.size() > 0) {
				Decentralization item;
				List<User> userOfDecen = decenService.findUserByFolderIdAndActive(folderId, true);
				for(int i = 0; i<userList.size(); i ++) {
					if(userOfDecen != null && userOfDecen.size() >0)
					{
						for(int j = 0; j <userOfDecen.size(); j ++) {
							if(userOfDecen.get(j).getId() == userList.get(i).getId())
								break;
							if(j == userOfDecen.size() - 1) {
								item = new Decentralization();
								item.setFolderId(folderId);
								item.setActive(true);
								item.setUserId(userList.get(i).getId());
								item.setPermission(permission);
								listData.add(item);
							}
						}
					}
					else {
						item = new Decentralization();
						item.setFolderId(folderId);
						item.setActive(true);
						item.setUserId(userList.get(i).getId());
						item.setPermission(permission);
						listData.add(item);
					}
				}
				listData = decenService.saveAll(listData);
			}
			List<User> response = decenService.findUserByFolderIdAndActive(folderId, true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	@PostMapping("/addDecenFile/{fileId}")
	public ResponseEntity<?> createPermissionFile(@PathVariable Long fileId, @RequestBody List<User> userList, @PathVariable Long permission){
		try {
			List<Decentralization> listData = new ArrayList<Decentralization>();
			if(userList != null && userList.size() > 0) {
				Decentralization item;
				List<User> userOfFile = decenService.findUserbyFileIdAndActive(fileId, true);
				for(int i =0; i < userList.size(); i++) {
					if(userOfFile != null && userOfFile.size() > 0 ) {
						for(int j = 0; j <userOfFile.size(); j ++) {
							if(userOfFile.get(j).getId() == userList.get(i).getId())
								break;
							if(j == userOfFile.size() - 1) {
								item = new Decentralization();
								item.setFileId(fileId);
								item.setActive(true);
								item.setUserId(userList.get(i).getId());
								item.setPermission(permission);
								listData.add(item);
							}
						}
					}else {
						item = new Decentralization();
						item.setFileId(fileId);
						item.setActive(true);
						item.setUserId(userList.get(i).getId());
						item.setPermission(permission);
						listData.add(item);
					}
				}
				listData = decenService.saveAll(listData);
			}
			List<User> response = decenService.findUserbyFileIdAndActive(fileId, true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	@GetMapping("/activeAuthorizeFolder/{userId}/{folderId}")
	public ResponseEntity<?> activeFolder(@PathVariable Long userId, @PathVariable Long folderId){
		try {
			Decentralization item = decenService.findFolderIdAndUserAndActive(folderId, userId, true);
			if(item != null) {
				item.setActive(false);
				decenService.save(item);
			}
			List<User> data = decenService.findUserByFolderIdAndActive(userId, true);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	@GetMapping("/activeAuthorizaFile/{userId}/{fileId}")
	public ResponseEntity<?> activeFile(@PathVariable Long userId, @PathVariable Long fileId){
		try {
			Decentralization item = decenService.findFileIdAndUserAndActive(fileId, userId, true);
			if(item != null) {
				item.setActive(false);
				decenService.save(item);
			}
			List<User> data = decenService.findUserbyFileIdAndActive(userId, true);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	@PostMapping("/activeAuthorizaOrgForFolder/{orgId}/{folderId}")
	public ResponseEntity<?> createPermissionFolderByOrg(@PathVariable Long id, @PathVariable Long folderId, @PathVariable Long permission){
		try {
			List<User> userList = userRepo.findUserByOrgIdAndActive(true, BussinessCommon.getClientId(), id);
			List<Decentralization> listData = new ArrayList<Decentralization>();
			if(userList != null && userList.size() > 0) {
				Decentralization item;
				List<User> userOfDecen = decenService.findUserByFolderIdAndActive(folderId, true);
				for(int i = 0; i<userList.size(); i ++) {
					if(userOfDecen != null && userOfDecen.size() >0)
					{
						for(int j = 0; j <userOfDecen.size(); j ++) {
							if(userOfDecen.get(j).getId() == userList.get(i).getId())
								break;
							if(j == userOfDecen.size() - 1) {
								item = new Decentralization();
								item.setFolderId(folderId);
								item.setActive(true);
								item.setUserId(userList.get(i).getId());
								item.setPermission(permission);
								listData.add(item);
							}
						}
					}
					else {
						item = new Decentralization();
						item.setFolderId(folderId);
						item.setActive(true);
						item.setUserId(userList.get(i).getId());
						item.setPermission(permission);
						listData.add(item);
					}
				}
				listData = decenService.saveAll(listData);
			}
			List<User> response = decenService.findUserByFolderIdAndActive(folderId, true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/activeAuthorizaOrgForFile/{orgId}/{fileId}")
	public ResponseEntity<?> createPermissionFilerByOrg(@PathVariable Long id, @PathVariable Long fileId, @PathVariable Long permission){
		try {
			List<User> userList = userRepo.findUserByOrgIdAndActive(true, BussinessCommon.getClientId(), id);
			List<Decentralization> listData = new ArrayList<Decentralization>();
			if(userList != null && userList.size() > 0) {
				Decentralization item;
				List<User> userOfFile = decenService.findUserbyFileIdAndActive(fileId, true);
				for(int i =0; i < userList.size(); i++) {
					if(userOfFile != null && userOfFile.size() > 0 ) {
						for(int j = 0; j <userOfFile.size(); j ++) {
							if(userOfFile.get(j).getId() == userList.get(i).getId())
								break;
							if(j == userOfFile.size() - 1) {
								item = new Decentralization();
								item.setFileId(fileId);
								item.setActive(true);
								item.setUserId(userList.get(i).getId());
								item.setPermission(permission);
								listData.add(item);
							}
						}
					}else {
						item = new Decentralization();
						item.setFileId(fileId);
						item.setActive(true);
						item.setUserId(userList.get(i).getId());
						item.setPermission(permission);
						listData.add(item);
					}
				}
				listData = decenService.saveAll(listData);
			}
			List<User> response = decenService.findUserbyFileIdAndActive(fileId, true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	@PostMapping("/activeAuthorizaRoleForFolder/{roleId}/{folderId}")
	public ResponseEntity<?> createPermissionFolderByRole(@PathVariable Long roleId, @PathVariable Long folderId, @PathVariable Long permission, @PathVariable Long role){
		try {
			List<User> userList = userRepo.findUserByRoleIdAndActive(true, BussinessCommon.getClientId(), role);
			List<Decentralization> listData = new ArrayList<Decentralization>();
			if(userList != null && userList.size() > 0) {
				Decentralization item;
				List<User> userOfDecen = decenService.findUserByFolderIdAndActive(folderId, true);
				for(int i = 0; i<userList.size(); i ++) {
					if(userOfDecen != null && userOfDecen.size() >0)
					{
						for(int j = 0; j <userOfDecen.size(); j ++) {
							if(userOfDecen.get(j).getId() == userList.get(i).getId())
								break;
							if(j == userOfDecen.size() - 1) {
								item = new Decentralization();
								item.setFolderId(folderId);
								item.setActive(true);
								item.setUserId(userList.get(i).getId());
								item.setPermission(permission);
								listData.add(item);
							}
						}
					}
					else {
						item = new Decentralization();
						item.setFolderId(folderId);
						item.setActive(true);
						item.setUserId(userList.get(i).getId());
						item.setPermission(permission);
						listData.add(item);
					}
				}
				listData = decenService.saveAll(listData);
			}
			List<User> response = decenService.findUserByFolderIdAndActive(folderId, true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
