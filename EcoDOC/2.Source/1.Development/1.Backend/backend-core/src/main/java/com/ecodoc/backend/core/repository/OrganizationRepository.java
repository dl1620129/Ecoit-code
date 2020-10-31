package com.ecodoc.backend.core.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.core.domain.Organization;
import com.ecodoc.backend.core.dto.OrgDto;
import com.ecodoc.backend.core.dto.OrgParent;

/**
 * @author EcoDOC
 * 
 */
@Repository
public interface OrganizationRepository extends IRepository<Organization> {

	@Query(value = "SELECT c FROM Organization c WHERE :code is null or c.code = :code")
	Organization findByCode(@Param(value = "code") Long code);
	
	@Query(value = "SELECT c FROM Organization c WHERE (:name is null or c.name = :name) and (:clientId is null or c.clientId = :clientId) and (:parentId is null or c.parentId = :parentId)")
	Organization findByNameAndClientIdAndParentId(String name, Long clientId, Long parentId);

	@Query("SELECT org FROM Organization org "
			+ "WHERE org.clientId=:clientId AND ((:parentId is NULL AND org.parentId is NULL) OR org.parentId=:parentId) AND (:active is null or org.active=:active)")
	List<Organization> findByClientIdAndParentIdAndActive(@Param(value = "clientId") Long clientId,
			@Param(value = "parentId") Long parentId, @Param(value = "active") Boolean active, Sort sort);

	@Query("SELECT org.id FROM Organization org "
			+ "WHERE org.clientId=:clientId AND ((:parentId is NULL AND org.parentId is NULL) OR org.parentId=:parentId) AND (:active is null or org.active=:active)")
	List<Long> findByClientIdAndParentIdAndActive(@Param(value = "clientId") Long clientId,
			@Param(value = "parentId") Long parentId, @Param(value = "active") Boolean active);

	@Query("SELECT p.parentId FROM Organization p WHERE p.id=:orgId and p.clientId = :clientId")
	Long getParentId(@Param("orgId") Long orgId, Long clientId);

	@Query("SELECT p FROM Organization p WHERE p.id=:orgId and p.clientId = :clientId")
	Organization getParentIdObj(@Param("orgId") Long orgId, @Param(value = "clientId") Long clientId);
	
	@Query("select o from Organization o where ((:orgIds) is null or o.id in (:orgIds)) and o.clientId = :clientId and o.active = :active ")
	List<Organization> getNameByIdList(Long clientId, List<Long> orgIds, Boolean active);

	@Query("select o.id from Organization o where o.clientId = :clientId and o.active = :active")
	List<Long> getIdList(Long clientId, Boolean active);

	@Query("SELECT count(*)>0 FROM Organization o INNER JOIN User u ON o.id = :orgId AND o.id = u.org AND u.active is true AND u.clientId=:clientId")
	boolean existUserByOrgId(Long orgId, Long clientId);

	@Query("SELECT count(*)>0 FROM Organization o INNER JOIN Organization c ON o.id = :orgId AND o.id = c.parentId AND c.active is true AND c.clientId=:clientId ")
	boolean existChildByOrgId(Long orgId, Long clientId);

	@Query("SELECT count(*)>0 FROM Organization o LEFT JOIN Organization p ON o.parentId=p.id "
			+ "WHERE o.id=:orgId AND p.active is FALSE AND o.clientId=:clientId AND p.clientId=:clientId")
	boolean hasInActiveParent(Long orgId, Long clientId);

	boolean existsByIdAndActiveAndClientId(Long id, boolean active, Long clientId);

	@Query("SELECT new com.ecodoc.backend.core.dto.OrgParent(o.parentId, o.id, o.name) FROM Organization o WHERE o.clientId = :clientId AND o.active IS TRUE")
	List<OrgParent> getParentChild(Long clientId);

	@Query("SELECT p FROM Organization p WHERE p.name = :name and p.active = true and p.clientId = :clientId and (p.parentId is null or p.parentId =:parentId)")
	List<Organization> findByNameAndParentId(String name, Long parentId, Long clientId);

	@Query("SELECT p FROM Organization p WHERE p.phone = :phone and p.active = true and p.clientId = :clientId and (p.parentId is null or p.parentId =:parentId)")
	List<Organization> findByPhoneAndParentId(String phone, Long parentId, Long clientId);

	@Query("SELECT p FROM Organization p WHERE "
			+ " (:#{#dto.phone} is null or p.phone like %:#{#dto.phone}%) "
			+ " and (:#{#dto.name} is null or lower(p.name) like %:#{#dto.name}%) "
			+ " and (:#{#dto.address} is null or lower(p.address) like %:#{#dto.address}%) "
			+ " and (:#{#dto.email} is null or lower(p.email) like %:#{#dto.email}%) "
			+ " and (:#{#dto.parentId} is null or p.parentId =:#{#dto.parentId}) "
			+ " and (:#{#dto.orgType} is null or p.orgType =:#{#dto.orgType}) "
			+ " and (:#{#dto.id} is null or p.id =:#{#dto.id}) "
			+ " and (:#{#dto.active} is null or p.active =:#{#dto.active}) "
			+ " and p.clientId = :clientId ")
	Page<Organization> search(OrgDto dto, Long clientId, Pageable castToPageable);

	@Query("SELECT p FROM Organization p WHERE p.clientId =:clientId and p.isLdap = :isLdap")
	List<Organization> findByClientIdAndLDAP(long clientId, boolean isLdap);
	
	Organization findByClientIdAndActiveAndParentId(Long clientId, Boolean active, Long parentId);
}
