package com.ecodoc.backend.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecodoc.backend.business.domain.FieldProperties;
import com.ecodoc.backend.core.repository.IRepository;

public interface IRepositoryProperties extends IRepository<FieldProperties>  {
	
	@Query(value = "SELECT f FROM FieldProperties f WHERE f.customTypeId =:customTypeId and f.active =:active")
	List<FieldProperties> getAllFieldProperty(@Param(value = "customTypeId")Long customTypeId, @Param(value = "active") Boolean Active);

	@Query(value ="SELECT f FROM FieldProperties f WHERE f.clientId =:clientId and f.name =:name")
	FieldProperties getFieldProperty(@Param(value = "clientId")Long clientId, @Param(value = "name")String name);
	
	@Query(value ="SELECT f FROM FieldProperties f WHERE f.clientId =:clientId and f.name =:name and f.aspectId =:aspectId")
	FieldProperties getFieldPropertyByAspectId(@Param(value = "clientId")Long clientId, @Param(value = "name")String name, @Param(value = "aspectId")Long aspectId );
	
	@Query(value ="SELECT f FROM FieldProperties f WHERE f.clientId =:clientId and f.name =:name and f.customTypeId =:customTypeId")
	FieldProperties getFieldPropertyByCustomTypeId(@Param(value = "clientId")Long clientId, @Param(value = "name")String name, @Param(value = "customTypeId")Long customTypeId );
}
