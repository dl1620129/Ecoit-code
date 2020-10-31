package elegal.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ecoit.elegaldocument.model.LegalType;
import com.ecoit.elegaldocument.service.GroupCategoryLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDTypeRelLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalTypeLocalServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;

public class TreeLegalType {

	public ArrayNode getLegalTypeNodes(long parentId, long groupId, long companyId, String language, String name, int start,
			int limit) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<LegalType> legalTypesList = LegalTypeLocalServiceUtil.getNode(parentId, groupId, companyId, language, name, start, limit);
		for (LegalType legaltype : legalTypesList) {
			long typeId = legaltype.getTypeId();
			ArrayNode node = getLegalTypeNodes(typeId, groupId, companyId, language, name, 0, -1);
			Map<String, Object> map = legaltype.getModelAttributes();
			ObjectNode object = mapper.convertValue(map, ObjectNode.class);
			object.putPOJO("child", node);
			arr.add(object);
		}
		return arr;
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
	
	public ArrayNode getCheckedGroupNodes(long parentId, long groupId, long companyId, String language, long groupUserId) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<LegalType> allNode = LegalTypeLocalServiceUtil.getNode(parentId, groupId, companyId, language, "", 0, -1);
		for (LegalType legaltype : allNode) {
			if (legaltype.getStatusType()) {
				long typeId = legaltype.getTypeId();
				ArrayNode node = getCheckedGroupNodes(typeId, groupId, companyId, language, groupUserId);
				ObjectNode object = mapper.createObjectNode();
				object.put("typeId", legaltype.getTypeId());
				object.put("name", HtmlUtil.extractText(legaltype.getName()));
				object.put("description", HtmlUtil.extractText(legaltype.getDescription()));
				object.put("parentId", legaltype.getParentId());
				object.put("position", legaltype.getPosition());
				boolean checked = GroupCategoryLocalServiceUtil.hasGroupCategory(groupUserId, typeId);
				object.putPOJO("checked", checked);
				object.putPOJO("child", node);
				arr.add(object);
			}
		}
		return arr;
	}
	
	public ArrayNode getCheckedDocumentNodes(long parentId, long groupId, long companyId, String language, long docId, long userId) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<LegalType> allNode = LegalTypeLocalServiceUtil.getNode(parentId, groupId, companyId, language, "", 0, -1);
		for (LegalType legaltype : allNode) {
			if (PermissionUtil.userHasType(userId, legaltype.getTypeId())) {
				long typeId = legaltype.getTypeId();
				ArrayNode node = getCheckedDocumentNodes(typeId, groupId, companyId, language, docId, userId);
				ObjectNode object = mapper.createObjectNode();
				object.put("typeId", legaltype.getTypeId());
				object.put("name", HtmlUtil.extractText(legaltype.getName()));
				object.put("description", HtmlUtil.extractText(legaltype.getDescription()));
				object.put("parentId", legaltype.getParentId());
				object.put("position", legaltype.getPosition());
				boolean checked = LegalDTypeRelLocalServiceUtil.hasDocumentType(docId, typeId);
				object.putPOJO("checked", checked);
				object.putPOJO("child", node);
				arr.add(object);
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
