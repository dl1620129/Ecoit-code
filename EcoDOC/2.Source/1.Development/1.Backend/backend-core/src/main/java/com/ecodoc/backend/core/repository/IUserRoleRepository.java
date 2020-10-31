package com.ecodoc.backend.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.domain.UserRole;

/**
 * @author EcoDOC
 * 
 */
@Repository
public interface IUserRoleRepository extends IRepository<UserRole> {

	@Query(value = "SELECT ur.user FROM UserRole ur WHERE ur.role.id=:roleId and ur.user.active=true and ur.active=:active and ur.clientId=:clientId order by ur.user.fullName")
	List<User> findByRoleIdAndActive(@Param(value = "roleId") long roleId, @Param(value = "active") boolean active, Long clientId);

	@Query(value = "SELECT DISTINCT ur.role FROM UserRole ur WHERE ur.user.id=:userId and ur.user.active=true and ur.active=:active and ur.role.active=true and ur.clientId=:clientId order by ur.role.name")
	List<Role> findRoleByUserIdAndActive(@Param(value = "userId") Long userId, @Param(value = "active") boolean active, Long clientId);

	@Query(value = "SELECT DISTINCT ur.roleId FROM UserRole ur WHERE ur.userId=:userId and ur.user.active=true and ur.active=:active and ur.role.active=true and ur.clientId=:clientId")
	List<Long> findRoleIdByUserIdAndActive(@Param(value = "userId") Long userId, @Param(value = "active") boolean active, Long clientId);
	
	@Query(value = "SELECT ur FROM UserRole ur WHERE ur.role.id=:roleId and ur.user.id=:userId and ur.active=:active and ur.clientId =:clientId order by ur.user.fullName")
	UserRole findByRoleIdAndUserIdAndActive(@Param(value = "roleId") long roleId, @Param(value = "userId") long userId,
			@Param(value = "active") boolean active, Long clientId);

	@Query(value = "SELECT ur.role FROM UserRole ur WHERE ur.user.userName=:userName and ur.clientId=:clientId")
	List<Role> findRoleByUserName(@Param(value = "userName") String userName, Long clientId);
	
	@Query(value = "SELECT ur FROM UserRole ur WHERE ur.userId in (:userIds) and ur.roleId =:roleId and ur.clientId =:clientId and ur.active = true")
	List<UserRole> findRoleByListUserId(List<Long> userIds, Long roleId, Long clientId);

}
