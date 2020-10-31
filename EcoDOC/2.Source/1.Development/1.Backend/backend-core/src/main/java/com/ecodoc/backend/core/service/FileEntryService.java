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

	private FileEntry findbyName(String name) {
		List<FileEntry> list = iFileEntryRepository.findByName(BussinessCommon.getClientId(), true, name);
		return list.isEmpty() ? null : list.get(0);
	}

	private void checkName(String name) {
		FileEntry fileEntry = findbyName(name);
		if (fileEntry != null)
			throw new RestFieldExceptionHandler("name", Message.FOLDER_NAME_EXIST);
	}
	private void checkTonTai(Long id) {
		long countId = iFileEntryRepository.checkFileById(BussinessCommon.getClientId(), id);
		if(countId<1) throw new RestExceptionHandler(Message.FOLDER_NOT_EXIST);
	}
	public FileEntry addFileEntry(FileEntry fileEntry) {
		System.out.println(fileEntry);
		if (fileEntry.getName() == null)
			throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		checkName(fileEntry.getName());
		fileEntry.setCreateDate(new Date());
		fileEntry.setUpdateDate(new Date());
		fileEntry.setCreateBy(BussinessCommon.getUserId());
		fileEntry.setUpdateBy(BussinessCommon.getUserId());
		return iFileEntryRepository.save(fileEntry);
	}

	public FileEntry updateFileEntry(Long id, FileEntry fileEntry) {
		FileEntry fileEntryOld = iFileEntryRepository.findById(id).get();
		if (!fileEntryOld.getName().equals(fileEntry.getName())) {
			checkName(fileEntry.getName());
		}
		fileEntry.setUpdateDate(new Date());
		fileEntry.setUpdateBy(BussinessCommon.getUserId());
		return iFileEntryRepository.save(fileEntry);
	}

	public FileEntry activeFileEntry(Long id) {
		checkTonTai(id);
		FileEntry fileEntryOld = iFileEntryRepository.findById(id).get();
		fileEntryOld.setActive(true); 
		return iFileEntryRepository.save(fileEntryOld);
	}

	public FileEntry unActiveFileEntry(Long id) {
		checkTonTai(id);
		FileEntry fileEntryOld = iFileEntryRepository.findById(id).get();
		fileEntryOld.setActive(false);
		return iFileEntryRepository.save(fileEntryOld);
	}
}
