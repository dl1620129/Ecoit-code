package com.ecodoc.backend.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.domain.ModuleAdmin;
import com.ecodoc.backend.core.dto.ModuleAdminDto;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestFieldExceptionHandler;
import com.ecodoc.backend.core.repository.IModuleAdminRepository;
import com.ecodoc.backend.core.repository.IRepository;

@Service
public class ModuleAdminService extends BaseService<ModuleAdmin> {
	@Autowired
	private IModuleAdminRepository moduleAdminRepository;

	@Override
	public IRepository<ModuleAdmin> getRepository() {
		return moduleAdminRepository;
	}
	
	public List<ModuleAdmin> getAllModule() {
		return moduleAdminRepository.getAll(BussinessCommon.getClientId());
	}
	
	public ModuleAdmin createModuleAdmin(ModuleAdmin moduleAdmin) {
		if (moduleAdmin == null) throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		moduleAdmin.set(moduleAdmin);
		moduleAdmin.setCreateBy(BussinessCommon.getUserId());
		moduleAdmin.setUpdateBy(BussinessCommon.getUserId());
		moduleAdmin.setCreateDate(new Date());
		moduleAdmin.setUpdateDate(new Date());
		return moduleAdminRepository.save(moduleAdmin);
	}
	
	public ModuleAdmin updateModuleAdmin(ModuleAdmin moduleAdmin, Long id) {
		ModuleAdmin old = findByClientIdAndId(BussinessCommon.getClientId(), id);
		if (old == null) throw new RestExceptionHandler(Message.NOT_FOUND_MODULE);
		old.set(moduleAdmin);
		old.setUpdateBy(BussinessCommon.getUserId());
		old.setUpdateDate(new Date());
		return moduleAdminRepository.save(old);
	}
	
	public List<ModuleAdmin> searchModuleAdmin(ModuleAdminDto mao) {
 		return moduleAdminRepository.searchModuleAdmin(mao.convert(mao), BussinessCommon.getClientId());
	}
}
