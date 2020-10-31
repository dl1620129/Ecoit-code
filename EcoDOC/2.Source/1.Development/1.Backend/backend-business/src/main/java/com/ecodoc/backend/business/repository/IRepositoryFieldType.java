package com.ecodoc.backend.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.business.domain.Fields;
import com.ecodoc.backend.business.domain.FieldsType;
import com.ecodoc.backend.core.repository.IRepository;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface IRepositoryFieldType extends IRepository<FieldsType>{

	@Query(value = "SELECT f FROM FieldsType f WHERE f.clientId =:clientId")
	List<FieldsType> getAllByClientId(@Param(value = "clientId") Long clientId);
	
	@Query(value = "SELECT f FROM FieldsType f WHERE f.clientId = :clientId and f.name=:name")
	FieldsType getFieldsByName(@Param(value = "clientId")Long clientId,@Param(value = "name")String name);
}
