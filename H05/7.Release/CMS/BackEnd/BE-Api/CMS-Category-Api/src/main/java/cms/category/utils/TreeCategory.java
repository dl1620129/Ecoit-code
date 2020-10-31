package cms.category.utils;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.software.cms.model.Category;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.util.PermissionUtil;

import cms.category.object.TreeCategoryObject;

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
	public List<TreeCategoryObject> getNodes(long userId, long parentId, long groupId, String language, int chooseNode, String title, int start,
			int limit, boolean isArticle) throws Exception {
		List<TreeCategoryObject> treeList = new ArrayList<>();
		List<Category> allNode = CategoryLocalServiceUtil.getNode(parentId, groupId, language, title, start, limit);
		for (Category category : allNode) {
			long child = Long.parseLong(category.getCateChild());

	        if (!isArticle || PermissionUtil.checkPermissionCategory(userId, category.getCategoryId())) {
	        	TreeCategoryObject object = new TreeCategoryObject();
				if (child == 0) {
					long cateId = category.getCategoryId();
					List<TreeCategoryObject> childList = getNodes(userId, cateId, groupId, language, -1, title, start, limit, isArticle);			
					object.setTitle(HtmlUtil.extractText(category.getTitle()));
					object.setCateId(cateId);
					object.setParentId(category.getParentId());
					object.setOrderNumber(category.getThuTu());
					object.setCreateDate(category.getCreatedDate().getTime());
					object.setLink(category.getLink());
					object.setDescription(HtmlUtil.extractText(category.getDescription()));
					object.setChild(childList);
					treeList.add(object);
				} else if (child == -1) {
					object.setTitle(HtmlUtil.extractText(category.getTitle()));
					object.setCateId(category.getCategoryId());
					object.setParentId(category.getParentId());
					object.setOrderNumber(category.getThuTu());
					object.setCreateDate(category.getCreatedDate().getTime());
					object.setLink(category.getLink());
					object.setDescription(HtmlUtil.extractText(category.getDescription()));
					object.setChild(new ArrayList<TreeCategoryObject>());
					treeList.add(object);
				}
	        }
		}
		try {
			if (chooseNode == NODE_CHILD) {
				/*ArrayNode arrr = mapper.createArrayNode();
				ObjectNode object = mapper.createObjectNode();

				object.put("title", category.getTitle());
				object.put("cateId", category.getCategoryId());
				object.put("parentId", category.getParentId());
				object.put("orderNumber", category.getThuTu());
				object.put("createDate", category.getCreatedDate().getTime());
				object.put("link", category.getLink());
				object.put("description", category.getDescription());
				object.putPOJO("child", arr);
				arrr.add(object);*/
				
				List<TreeCategoryObject> arrr = new ArrayList<>();
				TreeCategoryObject object = new TreeCategoryObject();
				Category category = CategoryLocalServiceUtil.getCategory(parentId);
				object.setTitle(HtmlUtil.extractText(category.getTitle()));
				object.setCateId(category.getCategoryId());
				object.setParentId(category.getParentId());
				object.setOrderNumber(category.getThuTu());
				object.setCreateDate(category.getCreatedDate().getTime());
				object.setLink(category.getLink());
				object.setDescription(HtmlUtil.extractText(category.getDescription()));
				object.setChild(treeList);
				arrr.add(object);
				return arrr;
			}
		} catch (Exception e) {
		}

		return treeList;
	}

	public List<TreeCategoryObject> filterNodes(String searchKey, List<TreeCategoryObject> originalList) {
		List<TreeCategoryObject> filteredList = new ArrayList<TreeCategoryObject>();
		for (TreeCategoryObject object : originalList) {
			boolean isAdd = false;
			if (object.getTitle().toLowerCase().contains(searchKey.toLowerCase())) {
				isAdd = true;
			}
			
			List<TreeCategoryObject> newChildList = filterNodes(searchKey, object.getChild());		
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
