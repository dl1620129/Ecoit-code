package com.ecodoc.backend.core.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.core.domain.Category;

@Repository
public interface ICategoryRepository extends IRepository<Category>, ICategoryRepositoryCustom {

	@Query("SELECT c FROM Category c WHERE c.clientId=:clientId AND c.name=:name AND c.categoryType.code=:code")
	Category findByClientIdAndNameAndCode(Long clientId, String name, String code);

	Category findByClientIdAndName(Long clientId, String name);

	Category findBySyncCode(Long sysnCode);

	List<Category> findByClientIdAndCategoryTypeId(Long clientId, long categoryTypeId, Sort sort);

	@Query("select c from Category c where c.categoryTypeId in (:categoryTypeIds) and c.clientId = :clientId and c.active = :active ORDER BY order")
	List<Category> findByClientIdAndCategoryTypeIdAndActive(Long clientId, Long[] categoryTypeIds, boolean active);

	List<Category> findByClientIdAndCategoryTypeIdAndActive(Long clientId, long categoryTypeId, boolean active,
			Sort sort);

	@Query(value = "SELECT c FROM Category c WHERE"
			+ " (:name IS NULL OR LOWER(c.name) LIKE %:name%)"
	        + " AND (:id is null or c.id = :id)"
			+ " AND (:categoryTypeId is null or c.categoryTypeId = :categoryTypeId)"
			+ " AND (:clientId is null or c.clientId = :clientId)"
			+ " AND (coalesce(:active, null) IS NULL or c.active = :active)")
	Page<Category> findByClientIdAndCategoryTypeId(String name, Boolean active, Long id,
			Long categoryTypeId, Long clientId, Pageable page);

	@Query("select max(c.order) from Category c where c.clientId = :clientId and c.categoryTypeId = :categoryTypeId")
	Long getMaxOrderByCategoryType(Long clientId, long categoryTypeId);

	@Query(value = "select c from Category c join CategoryType t on c.categoryTypeId = t.id "
			+ "where c.clientId = :clientId and t.clientId =:clientId and t.code = :code and t.active = true and c.active = true")
	List<Category> findByClientIdAndCategoryCodeAndOrgId(String code, Long clientId);

	@Query("select c from Category c where ((:type is null) or c.categoryTypeId = (:type)) and c.clientId = :clientId and c.name = :name")
	List<Category> findByClientIdAndNameAndCategoryTypeId(Long clientId, String name, Long type);

	@Query("select c from Category c where c.categoryTypeId in (:categoryType) and c.clientId = :clientId and c.isLdap = :isLdap")
	List<Category> findByClientIdAndCategoryTypeIdAndLDAP(long clientId, long categoryType, boolean isLdap);
}
