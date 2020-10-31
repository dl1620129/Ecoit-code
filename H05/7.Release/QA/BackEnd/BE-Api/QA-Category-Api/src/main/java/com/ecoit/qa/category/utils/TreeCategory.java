package com.ecoit.qa.category.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ecoit.qa.service.model.Category;
import com.ecoit.qa.service.service.CategoryLocalServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TreeCategory {
	public static ArrayNode getCategoryNodes(long parentId, long groupId, String name, int start,
			int limit) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<Category> categoriesList = CategoryLocalServiceUtil.getNode(parentId, groupId, start, limit, name);
		for (Category category : categoriesList) {
			long categoryId = category.getCategoryId();
			ArrayNode node = getCategoryNodes(categoryId, groupId, name, 0, -1);
			Map<String, Object> map = category.getModelAttributes();
			ObjectNode object = mapper.convertValue(map, ObjectNode.class);
			object.putPOJO("child", node);
			arr.add(object);
		}
		return arr;
	}
	
	public static List<Long> getListCategoryIds(long parentId, long groupId) throws Exception {
		List<Long> arr = new ArrayList<>();
		List<Category> allNode = CategoryLocalServiceUtil.getNode(parentId, groupId, 0, -1, "");
		for (Category category : allNode) {
			long categoryId = category.getCategoryId();
			arr.add(categoryId);
			List<Long> childArr = getListCategoryIds(categoryId, groupId);
			for (Long childId : childArr) {
				arr.add(childId);
			}
		}
		
		return arr;
	}
}
