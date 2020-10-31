package cms.category.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.software.cms.model.Article;
import com.software.cms.model.Category;
import com.software.cms.model.CategoryArticle;
import com.software.cms.model.Comment;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.CategoryArticleLocalServiceUtil;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.cms.service.CommentLocalServiceUtil;
import com.software.cms.service.GroupCategoryLocalServiceUtil;
import com.software.util.DataResponse;
import com.software.util.DataResponse.DataType;
import com.software.util.PermissionUtil;
import com.software.util.ResponseCode;
import com.software.util.RoleConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import cms.category.object.CategoryObject;
import cms.category.object.TreeCategoryObject;
import cms.category.utils.TreeCategory;

public class CategoryResource {

	private static CategoryResource instance = null;

	public static CategoryResource getInstance() {
		if (instance == null) {
			instance = new CategoryResource();
		}
		return instance;
	}

	@GET
	@Path("/getall/{groupId}/{locale}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetAll(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("parentId") long parentId,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("") @QueryParam("q") String q, @DefaultValue("false") @QueryParam("isArticle") boolean isArticle) {
		try {
			locale = HtmlUtil.escape(locale);
			q = HtmlUtil.escape(q).trim();

			if (groupId < 0 || userId < 0 || parentId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			boolean accessZone = PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.EDIT_CATEGORY, groupId);

			if (isArticle) {
				accessZone = true;
			}
			
			if (accessZone) {
				TreeCategory treeCategory = new TreeCategory();
				List<TreeCategoryObject> data = treeCategory.getNodes(userId, 0, groupId, locale, treeCategory.NODE_PARENT, "", -1, -1, isArticle);
				List<TreeCategoryObject> filteredList = new ArrayList<>();
				if (!q.equalsIgnoreCase("")) {
					filteredList = treeCategory.filterNodes(q, data);
				} else {
					filteredList = data;
				}
				/*int total = CategoryLocalServiceUtil.getNodeCount(0, groupId, locale, q);
				objectNode.put("total", total);
				objectNode.putPOJO("data", data);*/

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, filteredList,
						DataType.JSON_STR);
			} else {
				return DataResponse.NOT_ACCESS;
			}
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/update/view/{groupId}/{locale}/{userId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse UpdateView(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("parentId") long parentId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || userId < 0 || parentId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			boolean accessZone = PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.EDIT_CATEGORY, groupId);
			if (accessZone) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode object = mapper.createObjectNode();
				List<Category> allNode = CategoryLocalServiceUtil.getNode(parentId, groupId, locale, "", 0, 1);
				for (Category category : allNode) {
					object.put("title", category.getTitle());
					object.put("cateId", category.getCategoryId());
					object.put("parentId", category.getParentId());
					object.put("orderNumber", category.getThuTu());
					object.put("createDate", category.getCreatedDate().getTime());
					object.put("description", category.getDescription());
					object.put("link", category.getLink());
					object.put("thutu", category.getThuTu());
				}
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, object, DataType.JSON_STR);
			} else {
				return DataResponse.NOT_ACCESS;
			}
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/get/{groupId}/{locale}/{userId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetCategory(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("parentId") long parentId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || userId < 0 || parentId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			boolean accessZone = PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.EDIT_CATEGORY, groupId);
			if (accessZone) {
				TreeCategory treeCategory = new TreeCategory();
				List<TreeCategoryObject> node = new ArrayList<TreeCategoryObject>();

				if (parentId == 0) {
					node = treeCategory.getNodes(userId, parentId, groupId, locale, treeCategory.NODE_PARENT, "", -1, -1, false);
				} else {
					node = treeCategory.getNodes(userId, parentId, groupId, locale, treeCategory.NODE_CHILD, "", -1, -1, false);
				}
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
			} else {
				return DataResponse.NOT_ACCESS;
			}
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@POST
	@Path("/create/{groupId}/{locale}/{userId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse CreateCategory(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("parentId") long parentId, CategoryObject cateObject) {
		try {
			locale = HtmlUtil.escape(locale);
			String title = HtmlUtil.escape(cateObject.getTitle());

			String description = HtmlUtil.escape(cateObject.getDescription());
			int thuTu = cateObject.getThutu();
			String duongDan = HtmlUtil.escape(cateObject.getLink());

			if (groupId < 0 || userId < 0 || parentId < 0 || locale.isEmpty() || title.isEmpty() || thuTu < 0) {
				return DataResponse.PARAM_ERROR;
			}

			long categoryId = CounterLocalServiceUtil.increment(Category.class.getName());
			Category cate = CategoryLocalServiceUtil.createCategory(categoryId);
			Date date = new Date();
			cate.setUuid(PortalUUIDUtil.generate());
			cate.setTitle(title);
			cate.setDescription(description);
			cate.setPath("/");
			cate.setParentId(parentId);
			cate.setActive(0);
			cate.setIsRss(true);
			cate.setThuTu(thuTu);
			cate.setLink(duongDan);
			cate.setCreatedDate(date);
			cate.setCreatedUser(userId);
			cate.setLanguage(locale);
			cate.setDisplay(true);
			cate.setGroupId(groupId);
			cate.setModifiedDate(date);
			cate.setModifiedUser(userId);
			cate.setCateChild("-1");
			CategoryLocalServiceUtil.updateCategory(cate);
			if (parentId > 0) {
				Category category = CategoryLocalServiceUtil.getCategory(parentId);
				category.setCateChild("0");
				CategoryLocalServiceUtil.updateCategory(category);
				cateObject.setCategoryId(parentId);
			}
			cateObject.setCategoryId(categoryId);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, cateObject, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@PUT
	@Path("/update/{groupId}/{locale}/{userId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse UpdateCategory(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("parentId") long parentId, CategoryObject cateObject) {
		try {
			locale = HtmlUtil.escape(locale);
			String title = HtmlUtil.escape(cateObject.getTitle());

			String description = HtmlUtil.escape(cateObject.getDescription());
			int thuTu = cateObject.getThutu();
			String duongDan = HtmlUtil.escape(cateObject.getLink());
			long cateId = cateObject.getCategoryId();

			if (groupId < 0 || userId < 0 || parentId < 0 || cateId < 0 || locale.isEmpty() || title.isEmpty()
					|| thuTu < 0) {
				return DataResponse.PARAM_ERROR;
			}

			Category cate = CategoryLocalServiceUtil.getCategory(cateId);
			Date date = new Date();
			cate.setTitle(title);
			cate.setDescription(description);
			cate.setParentId(parentId);
			cate.setThuTu(thuTu);
			cate.setLink(duongDan);
			cate.setLanguage(locale);
			cate.setGroupId(groupId);
			cate.setModifiedDate(date);
			cate.setModifiedUser(userId);
			CategoryLocalServiceUtil.updateCategory(cate);

			if (parentId > 0) {
				Category category = CategoryLocalServiceUtil.getCategory(parentId);
				category.setCateChild("0");
				CategoryLocalServiceUtil.updateCategory(category);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/get/max-order-number/{groupId}/{locale}/{userId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetMaxOrderNumber(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("parentId") long parentId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || userId < 0 || parentId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			int max = CategoryLocalServiceUtil.getMax(userId, locale, groupId, parentId);
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node = mapper.createObjectNode();
			node.put("maxOrderNumber", max);
			if (max >= 0) {
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
			} else {
				return DataResponse.FAILED;
			}
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@DELETE
	@Path("/delete/{groupId}/{locale}/{userId}/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse DeleteCategory(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("categoryId") long categoryId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || userId < 0 || categoryId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			long articleId = 0;
			if (categoryId == 0) {
				List<CategoryArticle> lCA = CategoryArticleLocalServiceUtil.findByCategory(categoryId);
				if (lCA != null && lCA.size() > 0) {
					for (CategoryArticle ca : lCA) {
						articleId = ca.getArticleId();
						if (PermissionUtil.checkPermissionArticle(userId, articleId) && PermissionUtil
								.checkPermissionAccessZone(userId, RoleConstants.ARTICLE_REMOVE, groupId)) {
							try {
								Article article = ArticleLocalServiceUtil.getArticle(articleId);
								String imageId = article.getImage().trim();
								if (!imageId.equals("") && !imageId.equals("0")) {
									try {
										DLAppLocalServiceUtil.deleteFileEntry(Long.parseLong(imageId));
									} catch (Exception ex) {
										return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED,
												ex.getMessage(), DataType.JSON_STR);
									}
								}
								ArticleLocalServiceUtil.deleteArticle(articleId);
								List<Comment> comm = CommentLocalServiceUtil.findByArticleId(groupId, articleId);
								for (int i = 0; i < comm.size(); i++) {
									CommentLocalServiceUtil.deleteComment(comm.get(i));
								}

							} catch (Exception e) {
								return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
										DataType.JSON_STR);
							}
						}
					}
					CategoryArticleLocalServiceUtil.removeByCategory(categoryId);
				}
				CategoryLocalServiceUtil.deleteCategory(categoryId);
			} else {
				int countArticle = CategoryArticleLocalServiceUtil.getCountById(categoryId);
				if (countArticle <= 0) {
					List<Long> listCates = new ArrayList<>();
					TreeCategory treeCategory = new TreeCategory();
					if (categoryId == 0) {
						listCates = treeCategory.getListCategory(categoryId, groupId, locale, treeCategory.NODE_PARENT,
								"", -1, -1);
					} else {
						listCates = treeCategory.getListCategory(categoryId, groupId, locale, treeCategory.NODE_CHILD,
								"", -1, -1);
					}

					if (listCates != null || listCates.size() > 0) {

						for (Long cateId : listCates) {
							GroupCategoryLocalServiceUtil.removeByCategoryId(cateId);
							CategoryLocalServiceUtil.deleteCategory(cateId);
						}
					}
				}
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

}
