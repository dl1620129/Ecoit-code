package com.ecodoc.backend.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.core.domain.Module;
import com.ecodoc.backend.core.domain.Role;


@Repository
public interface IModuleRepository extends IRepository<Module> {

	@Query(value = "SELECT distinct p.module FROM Permission p WHERE p.role in :roleList and p.active=:active and p.module.active=:active and ((:parentId is null and p.module.parentId is null) or p.module.parentId=:parentId) order by p.module.orderNumber DESC")
	List<Module> findByActiveAndRoleAndParentId(@Param(value = "roleList") List<Role> roleList,
			@Param(value = "active") Boolean active, @Param(value = "parentId") Long parentId);
	
	@Query(value = "SELECT p.module FROM Permission p WHERE p.roleId in :roleList and p.active=:active and p.module.active=:active and ((:parentId is null and p.module.parentId is null) or p.module.parentId=:parentId) order by p.module.orderNumber DESC")
	List<Module> findByActiveAndRoleIdAndParentId(@Param(value = "roleList") List<Long> roleList,
			@Param(value = "active") Boolean active, @Param(value = "parentId") Long parentId);

	@Query(value = "SELECT m FROM Module m WHERE m.active=:active and (m.isDefault=true or (m.isDefault=false and m.clientId=:clientId)) order by m.name")
	List<Module> findByActiveAndClientId(@Param(value = "active") Boolean active,
			@Param(value = "clientId") Long clientId);
	
	@Query(value = "SELECT m FROM Module m WHERE m.active=:active and (m.isDefault=true or (m.isDefault=false and m.clientId=:clientId)) and ((:parentId is null and m.parentId is null) or m.parentId=:parentId) order by m.name")
	List<Module> findByClientIdAndParentId(@Param(value = "active") Boolean active,
			@Param(value = "clientId") Long clientId, @Param(value = "parentId") Long parentId);

	List<Module> findByActiveAndParentId(Boolean active, Long parentId);
	
	Module findByActiveAndId(Boolean active, Long id);

	@Query("SELECT count(*)>0 FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.roleId = :roleId AND p.module.code = :code AND p.role.active = :active AND p.module.active = :active")
	boolean existModuleByRoleId(String code, long roleId, boolean active, Long clientId);
}
