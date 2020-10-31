package com.ecodoc.backend.business.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.business.domain.BpmnModel.TYPE_DOCUMENT;
import com.ecodoc.backend.business.domain.NodeModel;
import com.ecodoc.backend.business.dto.BpmnActiveWrapper;
import com.ecodoc.backend.business.dto.NodeDto;
import com.ecodoc.backend.core.repository.IRepository;

@Repository
public interface INodeRepository extends IRepository<NodeModel> {

	@Query("SELECT new com.ecodoc.backend.business.dto.NodeDto(flow.next.id, flow.next.name, flow.next.type, flow.name) FROM NodeModel flow WHERE flow.prevId=:prevId")
	List<NodeDto> findAutoNextById(@Param("prevId") Long id);

	@Nullable
	@Query("SELECT new com.ecodoc.backend.business.dto.BpmnActiveWrapper(n.bpmn.active, n.bpmn.name) FROM NodeModel n WHERE n.id=:nodeId")
	BpmnActiveWrapper wrapBpmnByNodeId(Long nodeId);

	@NonNull
	@Query(" select new com.ecodoc.backend.business.dto.NodeDto(flow.next.id, flow.next.name, flow.next.type, flow.name, flow.bpmn.name) "
			+ "FROM NodeModel flow where flow.bpmn.clientId=:clientId AND flow.bpmn.active is TRUE AND "
			+ "flow.bpmn.typeDocument=:typeDocument AND flow.bpmn.orgId in :orgIds AND flow.id IN ("
			+ "select flow.id FROM NodeModel flow inner join Condition c on flow.prevId=c.nodeId where "
			+ "flow.prev.type IN ('task', 'startEvent') AND ("
			+ "c.userId=:userId OR  (c.positionId is null AND :userLead is TRUE AND c.orgId=:userOrgId) OR "
			+ "((c.orgId is NULL OR c.orgId in :orgIds) AND :userPosId = c.positionId)))")
	List<NodeDto> nextStartNodeOfBpmn(Long userId, boolean userLead, Long userPosId, Long userOrgId, Long clientId,
			Set<Long> orgIds, TYPE_DOCUMENT typeDocument);

	@NonNull
	@Query("select new com.ecodoc.backend.business.dto.NodeDto(flow.next.id, flow.next.name, flow.next.type, flow.name, flow.bpmn.name) "
			+ "FROM NodeModel flow inner join NodeModel n on flow.prevId=n.id "
			+ "where flow.bpmn.clientId=:clientId AND flow.bpmn.active is TRUE AND flow.bpmn.typeDocument=:typeDocument AND flow.bpmn.orgId IN :orgIds AND "
			+ "n.type='startEvent'")
	List<NodeDto> simpleNextStartNodeOfBpmn(Long clientId, Set<Long> orgIds, TYPE_DOCUMENT typeDocument);

	@Query("SELECT c.nodeId FROM Condition c WHERE c.active is TRUE AND c.nodeId in :setNode AND c.allowConfig is NOT FALSE AND ("
			+ "c.userId=:userId OR (c.positionId is NULL AND c.orgId=:org) OR (c.positionId=:position AND c.orgId in :setOrg))")
	Set<Long> validNode(Set<Long> setNode, Long org, Long position, Long userId, Set<Long> setOrg);
}
