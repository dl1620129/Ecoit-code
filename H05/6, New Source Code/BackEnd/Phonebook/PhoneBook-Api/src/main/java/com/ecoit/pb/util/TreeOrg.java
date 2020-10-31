package com.ecoit.pb.util;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import organizationalStructure.service.model.organization;
import organizationalStructure.service.service.organizationLocalServiceUtil;

public class TreeOrg {
	public final static int NODE_CHILD = 0;
	public final static int NODE_PARENT = 1;
	
	public ArrayNode getNodes(long parentId, long groupId, int chooseNode, String name, int start,
			int limit) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<organization> allNode = organizationLocalServiceUtil.getNode(parentId, groupId,name, start, limit);
		for (organization organization : allNode) {
			ObjectNode object = mapper.createObjectNode();
	
			long organId = organization.getOrganizationId();
			ArrayNode node = getNodes(organId, groupId, -1, name, start, limit);
			object.put("organizationId",organId );
			object.put("name", organization.getName() );
			object.putPOJO("child", node);
			
			arr.add(object);

		}
		try {
			if (chooseNode == NODE_CHILD) {
				ArrayNode arrr = mapper.createArrayNode();
				ObjectNode object = mapper.createObjectNode();
				organization organization = organizationLocalServiceUtil.getorganization(parentId);
				object.put("organizationId", organization.getOrganizationId());
				object.put("name", organization.getName() );
				object.putPOJO("child", arr);
				arrr.add(object);
				return arrr;
			}
		} catch (Exception e) {
		}

		return arr;
	}
}
