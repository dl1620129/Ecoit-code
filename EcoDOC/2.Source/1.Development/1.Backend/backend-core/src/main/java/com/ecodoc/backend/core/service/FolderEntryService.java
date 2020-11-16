package com.ecodoc.backend.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.domain.FolderEntry;
import com.ecodoc.backend.core.domain.ModuleAdmin;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.repository.IFolderEntryRepository;
import com.ecodoc.backend.core.repository.IRepository;

@Service
public class FolderEntryService  extends BaseService<FolderEntry> {
	@Autowired
	private IFolderEntryRepository folderEntryRepository;

	@Override
	public IRepository<FolderEntry> getRepository() {
		return folderEntryRepository;
	}

	public List<FolderEntry> getAllFolderEntry() {
		return folderEntryRepository.getAllFolderEntry(BussinessCommon.getClientId());
	}
	
	public FolderEntry createFolderEntry(FolderEntry folderEntry) {
		if (folderEntry == null) throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		folderEntry.set(folderEntry);
		folderEntry.setActive(true);
		folderEntry.setTitle(folderEntry.getTitle());
		folderEntry.setDescription(folderEntry.getDescription());
		folderEntry.setCreateBy(BussinessCommon.getUserId());
		folderEntry.setUpdateBy(BussinessCommon.getUserId());
		folderEntry.setCreateDate(new Date());
		folderEntry.setUpdateDate(new Date());
		return folderEntryRepository.save(folderEntry);
	}
	
	public FolderEntry updateFolderEntry(FolderEntry folderEntry, String nodeId) {
		FolderEntry old = folderEntryRepository.findByClientIdAndNodeId(BussinessCommon.getClientId(), nodeId);
		if (old == null) throw new RestExceptionHandler(Message.NOT_FOUND_FOLDER_ENTRY);
		old.setActive(old.getActive());
		old.set(folderEntry);
		old.setTitle(folderEntry.getTitle());
		old.setDescription(folderEntry.getDescription());
		old.setUpdateBy(BussinessCommon.getUserId());
		old.setUpdateDate(new Date());
		return folderEntryRepository.save(old); 
	}
}
