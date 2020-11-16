package com.ecodoc.backend.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.domain.FileEntry;
import com.ecodoc.backend.core.dto.FileentryDto;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestFieldExceptionHandler;
import com.ecodoc.backend.core.repository.IFileEntryRepository;
import com.ecodoc.backend.core.repository.IRepository;

@Service
public class FileEntryService extends BaseService<FileEntry> {

	@Autowired
	private IFileEntryRepository iFileEntryRepository;

	@Override
	public IRepository<FileEntry> getRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FileEntry> getAll() {
		return iFileEntryRepository.getAll(BussinessCommon.getClientId(), true);
	}

	public FileEntry findbyName(String name, String folderId) {
		List<FileEntry> list = iFileEntryRepository.findByName(BussinessCommon.getClientId(), true, name, folderId);
		return list.isEmpty() ? null : list.get(0);
	}

	public String checkName(String name, String folderId) {
		FileEntry fileEntry = findbyName(name, folderId);
		if (fileEntry == null) {
	        return name;
	    } else {
	        int extAt = name.lastIndexOf('.');
	        String filePart = name;
	        String ext = "";
	        if(extAt > 0) {
	            filePart = name.substring(0, extAt);
	            ext = name.substring(extAt);
	        }
	        if (filePart.indexOf("-") >=0) {
	            try {
	                int countStarts = filePart.lastIndexOf('-');
	                int count = Integer.valueOf(filePart.substring(countStarts + 1));
	                name = filePart.substring(0, countStarts + 1) + (++count) + ext;
	            } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
	                name = filePart + "-1" + ext;
	            }
	        } else {
	            name = filePart + "-1" + ext;
	        }
	        return checkName(name,folderId);
	    }
	}
	private void checkTonTai(Long id) {
		long countId = iFileEntryRepository.checkFileById(BussinessCommon.getClientId(), id);
		if (countId < 1)
			throw new RestExceptionHandler(Message.FILE_NOT_EXIST);
	}

	public FileEntry addFileEntry(FileEntry fileEntry) {
		System.out.println(fileEntry);
		if (fileEntry.getName() == null)
			throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		fileEntry.setName(checkName(fileEntry.getName(), fileEntry.getFolderId()));
		fileEntry.setDescription(fileEntry.getDescription());
		fileEntry.setTitle(fileEntry.getTitle());
		fileEntry.setCreateDate(new Date());
		fileEntry.setUpdateDate(new Date());
		fileEntry.setCreateBy(BussinessCommon.getUserId());
		fileEntry.setUpdateBy(BussinessCommon.getUserId());
		return iFileEntryRepository.save(fileEntry);
	}

	public FileEntry updateFileEntry(String fileId, FileEntry fileEntry) {
		FileEntry fileEntryOld = iFileEntryRepository.findByNodeId(BussinessCommon.getClientId(), fileId);
		if (!fileEntryOld.getName().equals(fileEntry.getName())) {
			fileEntry.setName(checkName(fileEntry.getName(), fileEntry.getFolderId()));
		}
		fileEntry.setDescription(fileEntry.getDescription());
		fileEntry.setTitle(fileEntry.getTitle());
		fileEntry.setUpdateDate(new Date());
		fileEntry.setUpdateBy(BussinessCommon.getUserId());
		return iFileEntryRepository.save(fileEntry);
	}

	public FileEntry activeFileEntry(String fileId) {

		FileEntry fileEntryOld = iFileEntryRepository.findByNodeId(BussinessCommon.getClientId(), fileId);
		if(fileEntryOld==null) {
			throw new RestExceptionHandler(Message.FILE_NOT_EXIST);
		}
		fileEntryOld.setActive(true);
		return iFileEntryRepository.save(fileEntryOld);
	}

	public FileEntry unActiveFileEntry(String fileId) {

		FileEntry fileEntryOld = iFileEntryRepository.findByNodeId(BussinessCommon.getClientId(), fileId);
		if(fileEntryOld==null) {
			throw new RestExceptionHandler(Message.FILE_NOT_EXIST);
		}
		fileEntryOld.setActive(false);
		return iFileEntryRepository.save(fileEntryOld);
	}
}
