package com.ecoit.qa.question.utils;

import java.util.List;

import com.ecoit.qa.service.model.Category;
import com.ecoit.qa.service.service.CategoryLocalServiceUtil;
import com.ecoit.qa.service.service.QuestionLocalServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CategoryUtil {
	
	public static ArrayNode getCategoryNodes(long parentId, long groupId) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<Category> categoriesList = CategoryLocalServiceUtil.getNode(parentId, groupId, 0, -1, "");
		for (Category category : categoriesList) {
			long categoryId = category.getCategoryId();
			ArrayNode node = getCategoryNodes(categoryId, groupId);
			ObjectNode object = mapper.createObjectNode();
			object.put("id", categoryId);
			object.put("name", category.getName());
			object.put("count", QuestionLocalServiceUtil.countByCategoryId(categoryId));
			object.putPOJO("child", node);
			arr.add(object);
		}
		return arr;
	}
}
