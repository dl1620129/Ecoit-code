package com.ecodoc.backend.core.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.SignerDto;
import com.ecodoc.backend.core.dto.UserDto;
import com.ecodoc.backend.core.dto.UserIdOrgIdDto;
import com.ecodoc.backend.core.dto.UserInfoDto;
import com.ecodoc.backend.core.dto.UserTreeDto;

/**
 * @author EcoDOC
 * 
 */
@Repository
public interface IUserRepository extends IRepository<User> {

	User findByUserNameAndActive(String userName, boolean active);

	User findByUserNameAndPasswordAndActive(String userName, String password, boolean active);

	User findByUserNameAndClientId(String userName, Long clientId);
	
	@Query("SELECT u FROM User u  WHERE u.serialToken = :serialToken AND u.active = true")
	User findBySerialTokenAndActiveTrue(String serialToken);

	@Query("SELECT new com.ecodoc.backend.core.dto.UserIdOrgIdDto(u.id, u.org) FROM User u WHERE u.id in :ids and u.active is TRUE and u.clientId=:clientId")
	List<UserIdOrgIdDto> findIdAndOrgId(Long[] ids, Long clientId);

	@Query("SELECT u FROM User u where u.id in (:ids) and u.clientId = :clientId")
	List<User> findByListUserNameAndClientId(Long[] ids, Long clientId);

	List<User> findByOrgAndClientId(Long orgId, Long clientId);

	List<User> findByClientIdAndPosition(Long clientId, Long positionId);

	@Query("SELECT u FROM User u "
			+"WHERE (:fullName is null OR lower(u.fullName) like %:fullName%) "
			+"AND (:userName is null OR lower(u.userName) like %:userName%) "
			+"AND (:email is null OR lower(u.email) like %:email%) "
			+"AND (:phone is null OR lower(u.phone) like %:phone%) "
			+"AND (:gender is null OR u.gender is :gender) "
			+"AND (:indentity is null OR lower(u.indentity) like %:indentity%) "
			+"AND (:title is null OR lower(u.title) like %:title%) "
			+"AND (:employeeId is null OR u.employeeId = :employeeId) "
			+"AND (:employeeCode is null OR lower(u.employeeCode) like %:employeeCode%) "
			+"AND (:salt is null OR lower(u.salt) like %:salt%) "
			+"AND (:org is null OR u.org = :org) "
			+"AND (:position is null OR u.position = :position) "
			+"AND (:lead is null OR u.lead is :lead) "
			+"AND (:clientId is null or u.clientId = :clientId) "
			+"AND (coalesce(:birthday, null) is null OR u.birthday = :birthday)")
	Page<User> findUser(@Param(value = "fullName") String fullName,
			@Param(value = "userName") String userName,
			@Param(value = "email") String email,
			@Param(value = "phone") String phone,
			@Param(value = "gender") Long gender,
			@Param(value = "indentity") String indentity,
			@Param(value = "title") String title,
			@Param(value = "employeeId") Long employeeId,
			@Param(value = "employeeCode") String employeeCode,
			@Param(value = "salt") String salt,
			@Param(value = "org") Long org,
			@Param(value = "position") Long position,
			@Param(value = "lead") Boolean lead,
			@Param(value = "birthday") Date birthday,
			@Param(value = "clientId") Long clientId,
			Pageable pageable);

	@Query("Select u from User u where (:clientId is null or u.clientId = :clientId)")
	Page<User> getAllUser(@Param(value = "clientId") Long clientId, Pageable pageable);

	@Query("Select new com.ecodoc.backend.core.dto.UserInfoDto(u.id, u.fullName, u.userName, u.lead, u.title, u.position, u.org) from User u "
			+ "where (:clientId is null or u.clientId = :clientId) and u.lead = :lead")
	List<UserInfoDto> getAllUserByLead(Long clientId, Boolean lead);

	@Query("Select u from User u join Category c on u.position = c.id where (lower(u.fullName) like %:textSearch% "
			+ " OR lower(u.userName) like %:textSearch% " + "OR lower(u.email) like %:textSearch%) "
			+ "AND u.active=true AND u.clientId=:clientId ORDER BY c.order DESC")
	List<User> searchUserActive(@Param(value = "textSearch") String textSearch, @Param(value = "clientId") Long clientId);

	@Query("Select new com.ecodoc.backend.core.dto.SignerDto(0, u.id, u.fullName, u.orgModel.name, u.positionModel.name, u.phone) "
			+ "from User u where (lower(u.fullName) like %:textSearch% "
			+ " OR lower(u.userName) like %:textSearch% " + "OR lower(u.email) like %:textSearch%) "
			+ "AND u.active=true AND u.clientId=:clientId ORDER BY coalesce(u.positionModel.order, 0), u.fullName")
	List<SignerDto> searchUserSign(@Param(value = "textSearch") String textSearch, @Param(value = "clientId") Long clientId);

	@Query("Select u.userName from User u where u.id = :id")
	String getUserNameById(@Param(value = "id") Long id);

//	@Query("SELECT u FROM User u where u.userName in (:users) and u.clientId = :clientId")
//	List<User> findByListUserIdAndClientId(String[] users, Long clientId);

	@Query("Select u.fullName from User u where u.id = :userId and u.clientId =:clientId")
	String getFullNameById(Long userId, Long clientId);

	@Query("SELECT new com.ecodoc.backend.core.dto.UserDto(u.id, u.userName, u.fullName) FROM User u where u.clientId = :clientId and u.active=true")
	List<UserDto> getAllUserDtoByActive(Long clientId);

	@Query("SELECT u FROM User u WHERE u.id IN (:listIds)")
	List<User> findByIds(Long[] listIds);

	@Query("SELECT u.id FROM User u WHERE u.clientId = :clientId and u.active = :active")
	List<Long> getIdList(Long clientId, Boolean active);

	@Query("SELECT u FROM User u WHERE u.clientId = :clientId and u.active = :active and ((:listIds) is null or u.id in (:listIds))")
	List<User> findByIds(List<Long> listIds, Long clientId, Boolean active);

	@Query("SELECT u.id FROM User u WHERE u.org IN (:org) AND u.lead = true")
	List<Long> getListLeadUserIdByOrg(List<Long> org);

	@Query("SELECT u.userName FROM User u WHERE u.clientId = :clientId and lower(u.fullName) like %:key% and u.active = true")
	List<String> findUserNameByKeys(String key, Long clientId);

	@Query("SELECT u.id FROM User u WHERE u.clientId = :clientId and lower(u.fullName) like %:key% and u.active = true")
	List<Long> findIdByKeys(String key, Long clientId);

	@Query("SELECT new com.ecodoc.backend.core.dto.UserTreeDto(u.id, u.org, u.positionModel, u.fullName, u.userName, u.lead) "
			+ "FROM User u WHERE u.clientId=:clientId AND u.active is TRUE "
			+ "ORDER BY coalesce(u.positionModel.order, 0), u.fullName")
	List<UserTreeDto> getAllOrder(Long clientId);

	@Query("SELECT new com.ecodoc.backend.core.dto.UserTreeDto(u.id, u.org, u.positionModel, u.fullName, u.userName, u.lead) "
			+ "FROM User u WHERE u.id IN "
			+ "(SELECT DISTINCT u1.id FROM User u1 LEFT JOIN PositionRole pr ON pr.active is true AND u1.position = pr.position "
			+ "LEFT JOIN UserRole ur ON ur.active is true AND u1.id = ur.userId "
			+ "INNER JOIN Permission p ON p.active is true AND (p.roleId = pr.roleId OR p.roleId = ur.roleId) "
			+ "WHERE 1=1 AND p.module.code = :code AND u1.clientId=:clientId AND u1.active is TRUE "
			+ "GROUP BY u1.id) "
			+ "ORDER BY coalesce(u.positionModel.order, 0), u.fullName")
	List<UserTreeDto> getAllOrder1(String code, Long clientId);

	List<User> findByPositionInAndActiveAndClientIdOrderByFullName(List<Long> listPos, boolean active, Long clientId);

	@Transactional
	@Modifying()
	@Query("UPDATE User u SET u.currentRole = :roleId WHERE u.id = :userId and u.clientId=:clientId")
	void setCurrentRole(long userId, long roleId, Long clientId);

	@Query("SELECT count(*)>0 FROM User u WHERE u.id IN (SELECT u1.id FROM User u1 INNER JOIN UserRole ur ON u1.id = ur.userId AND ur.roleId = :roleId AND ur.active = :active AND ur.clientId = :clientId WHERE u1.active = :active AND u1.id = :userId) "
			+ "OR u.id IN (SELECT u2.id FROM User u2 INNER JOIN PositionRole pr ON u2.position = pr.posId AND pr.roleId = :roleId AND pr.active = :active AND pr.clientId = :clientId WHERE u2.active = :active AND u2.id = :userId)")
	boolean existUserByRoleIdAndActiveAndClientId(long userId, long roleId, boolean active, long clientId);

	@Query("SELECT u FROM User u WHERE u.id IN (SELECT u1.id FROM User u1 INNER JOIN UserRole ur ON u1.id = ur.userId AND ur.roleId = :roleId AND ur.active = :active AND ur.clientId = :clientId WHERE u1.active = :active) "
			+ "OR u.id IN (SELECT u2.id FROM User u2 INNER JOIN PositionRole pr ON u2.position = pr.posId AND pr.roleId = :roleId AND pr.active = :active AND pr.clientId = :clientId WHERE u2.active = :active)")
	List<User> findUserByRoleIdAndActiveAndClientId(long roleId, boolean active, long clientId);

	@Query("SELECT u FROM User u WHERE u.active = :active AND u.clientId = :clientId AND (u.id IN "
			+ "(SELECT ur.userId FROM UserRole ur WHERE ur.active = :active AND ur.clientId = :clientId AND ur.role.active = :active AND ur.role.clientId = :clientId AND ur.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))) "
			+ "OR u.position IN "
			+ "(SELECT pr.posId FROM PositionRole pr WHERE pr.active = :active AND pr.clientId = :clientId AND pr.role.active = :active AND pr.role.clientId = :clientId AND pr.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))))")
	List<User> getListUserByModuleCodeAndActiveAndClientId(List<String> code, Boolean active, long clientId);

	@Query("SELECT u.id FROM User u WHERE u.active = :active AND u.clientId = :clientId AND (u.id IN "
			+ "(SELECT ur.userId FROM UserRole ur WHERE ur.active = :active AND ur.clientId = :clientId AND ur.role.active = :active AND ur.role.clientId = :clientId AND ur.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))) "
			+ "OR u.position IN "
			+ "(SELECT pr.posId FROM PositionRole pr WHERE pr.active = :active AND pr.clientId = :clientId AND pr.role.active = :active AND pr.role.clientId = :clientId AND pr.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))))")
	List<Long> getListUserIdByModuleCodeAndActiveAndClientId(List<String> code, Boolean active, long clientId);

	@Query("SELECT count(*)>0 FROM User u WHERE u.id = :userId AND u.active = :active AND u.clientId = :clientId AND (u.id IN "
			+ "(SELECT ur.userId FROM UserRole ur WHERE ur.active = :active AND ur.clientId = :clientId AND ur.role.active = :active AND ur.role.clientId = :clientId AND ur.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))) "
			+ "OR u.position IN "
			+ "(SELECT pr.posId FROM PositionRole pr WHERE pr.active = :active AND pr.clientId = :clientId AND pr.role.active = :active AND pr.role.clientId = :clientId AND pr.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))))")
	boolean checkUserIdByModuleCodeAndActiveAndClientId(long userId, List<String> code, Boolean active, long clientId);

	@Query("SELECT u FROM User u WHERE u.active = :active AND u.clientId = :clientId AND u.org = :orgId AND (u.id IN "
			+ "(SELECT ur.userId FROM UserRole ur WHERE ur.active = :active AND ur.clientId = :clientId AND ur.role.active = :active AND ur.role.clientId = :clientId AND ur.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))) "
			+ "OR u.position IN "
			+ "(SELECT pr.posId FROM PositionRole pr WHERE pr.active = :active AND pr.clientId = :clientId AND pr.role.active = :active AND pr.role.clientId = :clientId AND pr.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))))")
	List<User> getListUserByModuleCodeAndOrgAndClientIdAndActive(List<String> code, long orgId, long clientId, boolean active);

	@Query("SELECT u.id FROM User u WHERE u.active = :active AND u.clientId = :clientId AND u.org = :orgId AND (u.id IN "
			+ "(SELECT ur.userId FROM UserRole ur WHERE ur.active = :active AND ur.clientId = :clientId AND ur.role.active = :active AND ur.role.clientId = :clientId AND ur.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))) "
			+ "OR u.position IN "
			+ "(SELECT pr.posId FROM PositionRole pr WHERE pr.active = :active AND pr.clientId = :clientId AND pr.role.active = :active AND pr.role.clientId = :clientId AND pr.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))))")
	List<Long> getListUserIdByModuleCodeAndOrgAndClientIdAndActive(List<String> code, long orgId, long clientId, boolean active);

	@Query("SELECT u.userName FROM User u WHERE u.active = :active AND u.clientId = :clientId AND u.org = :orgId AND (u.id IN "
			+ "(SELECT ur.userId FROM UserRole ur WHERE ur.active = :active AND ur.clientId = :clientId AND ur.role.active = :active AND ur.role.clientId = :clientId AND ur.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))) "
			+ "OR u.position IN "
			+ "(SELECT pr.posId FROM PositionRole pr WHERE pr.active = :active AND pr.clientId = :clientId AND pr.role.active = :active AND pr.role.clientId = :clientId AND pr.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))))")
	List<String> getListUserNameByModuleCodeAndOrgAndClientIdAndActive(List<String> code, long orgId, long clientId, boolean active);

	@Query("SELECT count(*)>0 FROM User u WHERE u.id = :userId AND u.active = :active AND u.clientId = :clientId AND u.org = :orgId AND (u.id IN "
			+ "(SELECT ur.userId FROM UserRole ur WHERE ur.active = :active AND ur.clientId = :clientId AND ur.role.active = :active AND ur.role.clientId = :clientId AND ur.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))) "
			+ "OR u.position IN "
			+ "(SELECT pr.posId FROM PositionRole pr WHERE pr.active = :active AND pr.clientId = :clientId AND pr.role.active = :active AND pr.role.clientId = :clientId AND pr.roleId IN "
			+ "(SELECT p.roleId FROM Permission p WHERE p.active = :active AND p.clientId = :clientId AND p.module.active = :active AND p.module.code IN (:code))))")
	boolean checkUserIdByModuleCodeAndOrgAndActiveAndClientId(long userId, long orgId, List<String> code, boolean active, long clientId);

	@Query("SELECT u.org FROM User u WHERE u.userName = :userName AND u.active = :active AND u.clientId = :clientId")
	long findOrgIdByUserNameAndActiveAndClientId(String userName, boolean active, Long clientId);

	@Query("SELECT r FROM Role r WHERE r.active = :active AND r.clientId = :clientId AND (r.id IN "
			+ "(SELECT ur.roleId FROM UserRole ur WHERE ur.active = :active AND ur.clientId = :clientId AND ur.userId = :userId) "
			+ "OR r.id IN "
			+ "(SELECT pr.roleId FROM PositionRole pr WHERE pr.active = :active AND pr.clientId = :clientId AND pr.posId = :posId))")
	List<Role> findRoleByUserIdAndActive(Long userId, Long posId, boolean active, long clientId);

	@Query("SELECT r.id FROM Role r WHERE r.active = :active AND r.clientId = :clientId AND (r.id IN "
			+ "(SELECT ur.roleId FROM UserRole ur WHERE ur.active = :active AND ur.clientId = :clientId AND ur.userId = :userId) "
			+ "OR r.id IN "
			+ "(SELECT pr.roleId FROM PositionRole pr WHERE pr.active = :active AND pr.clientId = :clientId AND pr.posId = :posId))")
	List<Long> findRoleIdByUserIdAndActive(Long userId, Long posId, boolean active, long clientId);

	@Query("Select u from User u join Category c on u.position = c.id where (lower(u.fullName) like %:textSearch% "
			+ " OR lower(u.userName) like %:textSearch% " + "OR lower(u.email) like %:textSearch%) "
			+ " AND u.org IN (:orgIds)"
			+ " AND u.clientId =:clientId AND u.active=true "
			+ " ORDER BY c.order DESC ")
	List<User> findUserByOrgInAndClientIdAndActive(@Param(value = "orgIds")List<Long> orgIds,@Param(value = "textSearch")String textSearch,@Param(value = "clientId") Long clientId);

	@Query("SELECT u FROM User u WHERE u.active = true AND u.clientId = :clientId AND u.lead = true AND u.id NOT IN (:exceptUserList) "
			+ " AND u.org IN (SELECT u1.org FROM User u1 WHERE u1.active = true AND u1.clientId = :clientId AND u1.id IN (:userIds))")
	List<User> getLeadByListUserId(List<Long> userIds, List<Long> exceptUserList, Long clientId);

	@Query("SELECT u FROM User u WHERE u.active = true AND u.clientId = :clientId AND u.lead = true AND u.org IN (:orgArr)")
	List<User> getListLead(Long[] orgArr, Long clientId);

	@Query("SELECT u FROM User u WHERE (:active is null OR u.active = :active) AND (:orgId is null OR u.org = :orgId) AND (:posId is null OR u.position = :posId) AND u.clientId=:clientId")
	List<User> findListUserByOrgAndPositionIdAndActive(Long orgId, Long posId, Boolean active, Long clientId);

	@Query("SELECT u FROM User u WHERE (:active is null OR u.active = :active) AND (:orgId is null OR u.org = :orgId) AND u.position IN (:posId) AND u.clientId=:clientId")
	List<User> findListUserByOrgAndPositionIdInAndActive(Long orgId, Set<Long> posId, Boolean active, Long clientId);
	
	
	
	@Query("SELECT u FROM User u WHERE u.clientId = :clientId AND u.isLdap = :isLdap")
	List<User> findByClientIdAndLDAP(Long clientId, boolean isLdap);
	
	@Query("SELECT u FROM User u WHERE u.active=:active AND u.clientId=:clientId AND (u.id IN "
			+ "(SELECT ur.userId FROM UserRole ur WHERE ur.active=:active AND ur.clientId=:clientId AND ur.roleId=:roleId))")
	List<User> findUserIdByRoleIdAndActive(Long roleId, boolean active, Long clientId);
	
	@Query("SELECT u FROM User u WHERE u.active =:active AND u.clientId=:clientId AND (u.org IN (SELECT org.id FROM Organization org WHERE org.id=:id))")
	List<User> findUserByOrgIdAndActive(boolean active, Long clientId, Long id);
	
	@Query("SELECT u FROM User u WHERE u.active =:active AND u.clientId=:clientId AND (u.id IN"
			+ " (SELECT ur.user FROM UserRole ur WHERE ur.active=:active AND ur.role=:role))")
	List<User> findUserByRoleIdAndActive(boolean active, Long clientId, Long role);
	
}
