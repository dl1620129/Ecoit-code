package com.ecodoc.backend.business.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecodoc.backend.business.domain.BpmnModel;
import com.ecodoc.backend.business.domain.BpmnModel.TYPE_DOCUMENT;
import com.ecodoc.backend.business.dto.BpmnSearchDto;
import com.ecodoc.backend.business.dto.UserConditionDto;
import com.ecodoc.backend.core.repository.IRepository;

@Repository
public interface IBpmnRepository extends IRepository<BpmnModel> {

	List<BpmnModel> findByClientIdAndActiveAndTypeDocument(Long clientId, boolean active, TYPE_DOCUMENT typeDocument);

	@Transactional
	@Modifying()
	@Query("UPDATE BpmnModel b SET b.active=false WHERE (:bpmnId is NULL OR b.id!=:bpmnId) AND b.clientId=:clientId AND b.typeDocument=:typeDocument AND b.orgId=:orgId")
	void updateOneActiveForBpmnId(Long clientId, TYPE_DOCUMENT typeDocument, Long orgId, Long bpmnId);

	@Query("SELECT new com.ecodoc.backend.business.dto.UserConditionDto(u.id, u.lead, u.org, u.positionModel.id, u.positionModel.name, u.positionModel.order, u.fullName, u.userName, c.orgId, c.positionId, c.userId) "
			+ "FROM User u inner join Condition c ON "
			+ "c.clientId=:clientId AND u.clientId=:clientId AND c.nodeId=:nodeId AND u.active is true "
			+ "WHERE u.active IS TRUE AND u.orgModel.active IS TRUE AND (c.userId=u.id OR (c.userId is NULL AND ("
			+ "  (c.orgId=u.org AND c.positionId is null AND u.lead is TRUE) OR (u.position=c.positionId)"
			+ ")))"
			+ "ORDER BY u.positionModel.order, LOWER(u.fullName)")
	List<UserConditionDto> getUserByNodeId(Long nodeId, Long clientId);

	@Query("SELECT new com.ecodoc.backend.business.dto.BpmnSearchDto(b.id, b.active, b.name, b.typeDocument, b.org.id, b.org.name) "
			+ "FROM BpmnModel b WHERE (:type IS NULL OR b.typeDocument=:type) "
			+ "AND b.clientId=:clientId AND (:name IS NULL OR LOWER(b.name) LIKE %:name%)")
	Page<BpmnSearchDto> search(String name, TYPE_DOCUMENT type, Long clientId, Pageable pageable);

	@Query("SELECT count(*)>0 FROM BpmnModel b WHERE b.clientId=:clientId AND LOWER(b.name)=:name AND (:id is NULL OR b.id<>:id)")
	boolean existName(String name, Long id, Long clientId);
}
