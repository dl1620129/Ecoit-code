package cms.webview.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.software.cms.model.Category;
import com.software.cms.service.CategoryLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

public class TreeCategory {

	public final static int NODE_CHILD = 0;
	public final static int NODE_PARENT = 1;

	/***
	 * @param parentId   0 node 1 || > 0 get child
	 * @param groupId
	 * @param language
	 * @param chooseNode if parent 0 chooseNode = -1 || chooseNode = 0 get child
	 * @return
	 * @throws Exception
	 */
	public ArrayNode getNodes(long parentId, long groupId, String language, int chooseNode, String title, int start,
			int limit) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();

		List<Category> allNode = CategoryLocalServiceUtil.getNode(parentId, groupId, language, title, start, limit);
		for (Category category : allNode) {
			long child = Long.parseLong(category.getCateChild());
			ObjectNode object = mapper.createObjectNode();
			if (child == 0) {
				long cateId = category.getCategoryId();
				ArrayNode node = getNodes(cateId, groupId, language, -1, "", start, limit);
				object.put("title", category.getTitle());
				object.put("cateId", cateId);
				object.put("parentId", category.getParentId());
				object.put("orderNumber", category.getThuTu());
				object.put("createDate", category.getCreatedDate().getTime());
				object.put("link", category.getLink());
				object.put("description", category.getDescription());
				object.putPOJO("child", node);
				arr.add(object);
			} else if (child == -1) {
				object.put("title", category.getTitle());
				object.put("cateId", category.getCategoryId());
				object.put("parentId", category.getParentId());
				object.put("orderNumber", category.getThuTu());
				object.put("createDate", category.getCreatedDate().getTime());
				object.put("link", category.getLink());
				object.put("description", category.getDescription());
				object.putPOJO("child", mapper.createArrayNode());
				arr.add(object);
			}
		}
		try {
			if (chooseNode == NODE_CHILD) {
				ArrayNode arrr = mapper.createArrayNode();
				ObjectNode object = mapper.createObjectNode();
				Category category = CategoryLocalServiceUtil.getCategory(parentId);
				object.put("title", category.getTitle());
				object.put("cateId", category.getCategoryId());
				object.put("parentId", category.getParentId());
				object.put("orderNumber", category.getThuTu());
				object.put("createDate", category.getCreatedDate().getTime());
				object.put("link", category.getLink());
				object.put("description", category.getDescription());
				object.putPOJO("child", arr);
				arrr.add(object);
				return arrr;
			}
		} catch (Exception e) {
		}

		return arr;
	}

	public List<Long> getListCategory(long parentId, long groupId, String language, int chooseNode, String title,
			int start, int limit) throws Exception {
		List<Long> arr = new ArrayList<>();

		List<Category> allNode = CategoryLocalServiceUtil.getNode(parentId, groupId, language, title, start, limit);
		for (Category category : allNode) {
			long child = Long.parseLong(category.getCateChild());
			if (child == 0) {
				long cateId = category.getCategoryId();
				getListCategory(cateId, groupId, language, -1, title, start, limit);
				arr.add(cateId);
			} else if (child == -1) {
				arr.add(category.getCategoryId());
			}
		}
		try {
			if (chooseNode == NODE_CHILD) {
				List<Long> arrr = new ArrayList<>();
				Category category = CategoryLocalServiceUtil.getCategory(parentId);
				arrr.add(category.getCategoryId());
				return arrr;
			}
		} catch (Exception e) {
		}

		return arr;
	}
}
