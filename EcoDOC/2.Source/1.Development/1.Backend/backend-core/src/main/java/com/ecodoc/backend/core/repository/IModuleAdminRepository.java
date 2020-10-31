package com.ecodoc.backend.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.domain.ModuleAdmin;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.ModuleAdminDto;

import io.lettuce.core.dynamic.annotation.Param;

public interface IModuleAdminRepository extends IRepository<ModuleAdmin> {


	@Query("Select md from ModuleAdmin md where (:clientId is null or  md.clientId = :clientId) ORDER BY md.name ASC")
	List<ModuleAdmin> getAll(@Param(value = "clientId") Long clientId);

	@Query("SELECT md FROM ModuleAdmin md WHERE "
			+ " (:#{#mao.name} is null or lower(md.name) like %:#{#mao.name}%) "
			+ " and (:#{#mao.code} is null or lower(md.code) like %:#{#mao.code}%) "
			+ " and ((:#{#mao.startDateSearch} <= md.createDate) and (:#{#mao.endDateSearch} >= md.createDate))"
			+ " and (:#{#mao.id} is null or md.id =:#{#mao.id}) "
			+ " and (:#{#mao.active} is null or md.active =:#{#mao.active}) "
			+ " and md.clientId = :clientId ")
	List<ModuleAdmin> searchModuleAdmin(ModuleAdminDto mao, Long clientId);
}
