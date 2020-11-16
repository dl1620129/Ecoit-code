package com.ecodoc.backend.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.domain.Decentralization;
import com.ecodoc.backend.core.domain.FileEntry;
import com.ecodoc.backend.core.domain.FolderEntry;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.DecentralizationDto;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.repository.IDecentralizationRepository;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.repository.IUserRepository;

import io.lettuce.core.GeoArgs.Sort;

@Service
public class DecentralizationService extends BaseService<Decentralization>{
	@Autowired
	private IDecentralizationRepository decenRepository;

	@Override
	public IRepository<Decentralization> getRepository() {
		return decenRepository;
	}
	
	public List<User> findUserByFolderIdAndActive(Long folderId, boolean active){
		List<User> result = decenRepository.findFolderIdByUserId(folderId, active, BussinessCommon.getClientId());
		return result;
	}
	
	public List<User> findUserbyFileIdAndActive(Long fileId, boolean active){
		List<User> result = decenRepository.findFileIdByUserId(fileId, active, BussinessCommon.getClientId());
		return result;
	}
	
	public Decentralization findFolderIdAndUserAndActive(Long folderId, Long userId, boolean active) {
		Decentralization user = decenRepository.findFolderIdAndUserIdAndActive(folderId, userId, active, BussinessCommon.getClientId());
		return user;
	}
	
	public Decentralization findFileIdAndUserAndActive(Long fileId, Long userId, boolean active) {
		Decentralization user = decenRepository.findFileIdAndUserIdAndActive(fileId, userId, active, BussinessCommon.getClientId());
		return user;
	}
	
	public List<FolderEntry> findFolderByUserIdAndActive(Long userId, boolean active){
		List<FolderEntry> result = decenRepository.findFolderByUserIdAndActive(userId, active, BussinessCommon.getClientId());
		return result;
	}
	
	public List<FileEntry> findFileByUserIdAndActive(Long userId, boolean active){
		List<FileEntry> result = decenRepository.findFileByUserIdAndActive(userId, active, BussinessCommon.getClientId());
		return result;
	}
	
	public List<Long> findFolderIdByUserIdAndActive(Long userId, boolean active){
		List<Long> result = decenRepository.findFolderIdByUserIdAndActive(userId, active, BussinessCommon.getClientId());
		return result;
	}
	
	public List<Long> findFileIdByUserIdAndActive(Long userId, boolean active){
		List<Long> result = decenRepository.findFileIdByUserIdAndActive(userId, active, BussinessCommon.getClientId());
		return result;
	}
	
	public List<FolderEntry> findFolderByUserName(String userName){
		List<FolderEntry> result = decenRepository.findFolderByUserName(userName, BussinessCommon.getClientId());
		return result;
	}
	
	public List<FileEntry> findFileByUserName(String userName){
		List<FileEntry> result = decenRepository.findFileByUserName(userName, BussinessCommon.getClientId());
		return result;
	}
	
	public List<Decentralization> findFolderByListUserId(List<Long> userIds, Long folderId){
		List<Decentralization> result = decenRepository.findFolderByListUserId(userIds, folderId, BussinessCommon.getClientId());
		return result;
	}
	
	public List<Decentralization> findFileByListUserId(List<Long> userIds, Long fileId){
		List<Decentralization> result = decenRepository.findFileByListUserId(userIds, fileId, BussinessCommon.getClientId());
		return result;
	}
}
