package com.ecoit.qa.permission.object;

import java.util.List;
import java.util.Map;

import com.ecoit.qa.service.model.Category;
import com.ecoit.qa.service.service.CategoryLocalServiceUtil;
import com.ecoit.qa.service.service.GroupUserCategoryLocalServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TreeCategory {
	
	public static ArrayNode getCategoryCheckedNodes(long parentId, long groupId, long groupUserId) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<Category> categoriesList = CategoryLocalServiceUtil.getNode(parentId, groupId, 0, -1, "");
		for (Category category : categoriesList) {
			long categoryId = category.getCategoryId();
			ArrayNode node = getCategoryCheckedNodes(categoryId, groupId, groupUserId);
			Map<String, Object> map = category.getModelAttributes();
			ObjectNode object = mapper.convertValue(map, ObjectNode.class);
			boolean checked = GroupUserCategoryLocalServiceUtil.hasCategory(groupUserId, categoryId);
			object.putPOJO("checked", checked);
			object.putPOJO("child", node);
			arr.add(object);
		}
		return arr;
	}
}
