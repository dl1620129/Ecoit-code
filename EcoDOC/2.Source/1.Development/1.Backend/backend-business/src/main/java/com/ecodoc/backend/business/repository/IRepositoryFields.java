package com.ecodoc.backend.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.business.domain.Fields;
import com.ecodoc.backend.core.repository.IRepository;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface IRepositoryFields extends IRepository<Fields>{
	
	@Query(value = "SELECT f FROM Fields f WHERE f.clientId = :clientId")
	List<Fields> getByClienId(@Param(value = "clientId")Long clientId);
	
	@Query(value = "SELECT count(f) FROM Fields f WHERE f.clientId = :clientId and f.name=:name")
	Long getCountByName(@Param(value = "clientId")Long clientId,@Param(value = "name")String name);
	
	@Query(value = "SELECT count(f) FROM Fields f WHERE f.clientId = :clientId and f.namespacePrefix=:namespacePrefix")
	Long getCountByNamespacePrefix(@Param(value = "clientId")Long clientId,@Param(value = "namespacePrefix")String namespacePrefix);
	
	@Query(value = "SELECT count(f) FROM Fields f WHERE f.clientId = :clientId and f.namespaceUri=:namespaceUri")
	Long getCountByNamespaceUri(@Param(value = "clientId")Long clientId,@Param(value = "namespaceUri")String namespaceUri);
	
	@Query(value = "SELECT f FROM Fields f WHERE f.clientId = :clientId and f.name=:name")
	Fields getFieldsByName(@Param(value = "clientId")Long clientId,@Param(value = "name")String name);
}
