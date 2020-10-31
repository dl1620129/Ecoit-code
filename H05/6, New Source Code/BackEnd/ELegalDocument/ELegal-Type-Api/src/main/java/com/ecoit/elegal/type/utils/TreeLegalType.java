package com.ecoit.elegal.type.utils;

import java.util.ArrayList;
import java.util.List;

import com.ecoit.elegal.type.object.TreeTypeObject;
import com.ecoit.elegaldocument.model.LegalType;
import com.ecoit.elegaldocument.service.LegalTypeLocalServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;


public class TreeLegalType {

	public List<TreeTypeObject> getLegalTypeNodes(long parentId, long groupId, long companyId, String language, String name, int start,
			int limit) throws Exception {
		List<TreeTypeObject> treeList = new ArrayList<TreeTypeObject>();
		List<LegalType> legalTypesList = LegalTypeLocalServiceUtil.getNode(parentId, groupId, companyId, language, name, start, limit);
		for (LegalType legaltype : legalTypesList) {
			long typeId = legaltype.getTypeId();
			
			TreeTypeObject treeTypeObj = new TreeTypeObject();
			treeTypeObj.setTypeId(legaltype.getTypeId());
			treeTypeObj.setName(HtmlUtil.extractText(legaltype.getName()));
			treeTypeObj.setDescription(HtmlUtil.extractText(legaltype.getDescription()));
			treeTypeObj.setParentId( legaltype.getParentId());
			treeTypeObj.setStatusType(legaltype.getStatusType());
			treeTypeObj.setPosition(legaltype.getPosition());
			List<TreeTypeObject> child = getLegalTypeNodes(typeId, groupId, companyId, language, name, 0, -1);
			treeTypeObj.setChild(child);
			treeList.add(treeTypeObj);
		}
		return treeList;
	}
	
	public List<TreeTypeObject> filterNodes(String searchKey, List<TreeTypeObject> originalList) {
		List<TreeTypeObject> filteredList = new ArrayList<TreeTypeObject>();
		for (TreeTypeObject object : originalList) {
			boolean isAdd = false;
			if (object.getName().toLowerCase().contains(searchKey.toLowerCase())) {
				isAdd = true;
			}
			
			List<TreeTypeObject> newChildList = filterNodes(searchKey, object.getChild());
			object.setChild(newChildList);
			if (newChildList.size() > 0) {
				isAdd = true;
			}
			
			if (isAdd) {
				filteredList.add(object);
			}
		}
		return filteredList;
	}
	
	public List<Long> getListLegalTypeIds(long parentId, long groupId, long companyId, String language) throws Exception {
		List<Long> arr = new ArrayList<>();
		List<LegalType> allNode = LegalTypeLocalServiceUtil.getNode(parentId, groupId, companyId, language, "", 0, -1);
		for (LegalType legaltype : allNode) {
			long typeId = legaltype.getTypeId();
			arr.add(typeId);
			List<Long> childArr = getListLegalTypeIds(typeId, groupId, companyId, language);
			for (Long childId : childArr) {
				arr.add(childId);
			}
		}
		
		return arr;
	}
	
	public ArrayNode getPublishNodes(long parentId, String language, long groupId) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<LegalType> legalTypesList = LegalTypeLocalServiceUtil.getPublishTypes(parentId, language, true, groupId);
		for (LegalType legaltype : legalTypesList) {
			long typeId = legaltype.getTypeId();
			ArrayNode node = getPublishNodes(typeId, language, groupId);
			ObjectNode object = mapper.createObjectNode();
			object.put("typeId", legaltype.getTypeId());
			object.put("name", HtmlUtil.extractText(legaltype.getName()));
			object.put("description", HtmlUtil.extractText(legaltype.getDescription()));
			object.put("statusType", legaltype.getStatusType());
			object.put("parentId", legaltype.getParentId());
			object.put("position", legaltype.getPosition());
			object.putPOJO("child", node);
			arr.add(object);
		}
		return arr;
	}
}
