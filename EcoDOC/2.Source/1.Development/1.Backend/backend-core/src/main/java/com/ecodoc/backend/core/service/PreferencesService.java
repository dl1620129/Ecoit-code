package com.ecodoc.backend.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.domain.Preferences;
import com.ecodoc.backend.core.dto.PreferencesDto;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.repository.IPreferencesRepository;
import com.ecodoc.backend.core.repository.IRepository;

@Service
public class PreferencesService extends BaseService<Preferences>{

	@Autowired
	private IPreferencesRepository preferencesRepository;
	
	@Override
	public IRepository<Preferences> getRepository() {
		return preferencesRepository;
	}
	
	public List<Preferences> getAllPreferences() {
		return preferencesRepository.getAll(BussinessCommon.getClientId());
	}
	
	public Preferences createPreferences(Preferences preferences) {
		if (preferences == null) throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		preferences.set(preferences);
		preferences.setId(100L);
		preferences.setCreateBy(BussinessCommon.getUserId());
		preferences.setUpdateBy(BussinessCommon.getUserId());
		preferences.setCreateDate(new Date());
		preferences.setUpdateDate(new Date());
		return preferencesRepository.save(preferences);
	}
	
	public Preferences updatePreferences(Preferences preferences, Long id) {
		Preferences old = findByClientIdAndId(BussinessCommon.getClientId(), id);
		if (old == null) throw new RestExceptionHandler(Message.NOT_FOUND_MODULE);
		old.set(preferences);
		preferences.setUpdateBy(BussinessCommon.getUserId());
		preferences.setUpdateDate(new Date());
		return preferencesRepository.save(old);
	}

	public List<Preferences> searchPreferences(PreferencesDto po){
		return preferencesRepository.searchPreferences(po.convert(po), BussinessCommon.getClientId());
	}
	
}
