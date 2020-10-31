package com.ecodoc.backend.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.core.domain.Permission;
import com.ecodoc.backend.core.domain.Role;

@Repository
public interface IPermissionRepository extends IRepository<Permission> {

	@Query(value = "SELECT p FROM Permission p WHERE p.clientId = :clientId and p.role in :roleList and p.active=:active")
	List<Permission> findByClientAndRole(@Param(value = "clientId") Long clientId,
			@Param(value = "roleList") List<Role> roleList, @Param(value = "active") Boolean active);

	@Query(value = "SELECT p FROM Permission p WHERE p.role.id = :roleId and p.module.id=:moduleId")
	Permission findByRoleIdAndModuleId(@Param(value = "roleId") Long roleId, @Param(value = "moduleId") Long moduleId);
}
