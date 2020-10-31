package com.ecodoc.backend.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.ecodoc.backend.core.domain.Preferences;
import com.ecodoc.backend.core.dto.PreferencesDto;

import io.lettuce.core.dynamic.annotation.Param;

public interface IPreferencesRepository extends IRepository<Preferences> {
	
	@Query("SELECT p FROM Preferences p WHERE (:clientId is null or p.clientId = :clientId) ORDER BY create_date ASC")
	List<Preferences> getAll(@Param(value = "clientId") Long clientId);
	
	@Query("SELECT p FROM Preferences p WHERE "
			+ " (:#{#po.name} is null or lower(p.name) like %:#{#po.name}%) "
			+ " and p.clientId = :clientId ORDER BY create_date ASC ")
	List<Preferences> searchPreferences(PreferencesDto po, Long clientId);
}
