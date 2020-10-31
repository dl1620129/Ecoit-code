package com.ecoit.qa.category.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.ecoit.qa.category.object.CategoryObject;
import com.ecoit.qa.category.utils.TreeCategory;
import com.ecoit.qa.service.model.Category;
import com.ecoit.qa.service.model.Question;
import com.ecoit.qa.service.service.CategoryLocalServiceUtil;
import com.ecoit.qa.service.service.GroupUserCategoryLocalServiceUtil;
import com.ecoit.qa.service.service.QuestionLocalServiceUtil;
import com.ecoit.qa.service.utils.DataResponse;
import com.ecoit.qa.service.utils.ResponseCode;
import com.ecoit.qa.service.utils.DataResponse.DataType;
import com.ecoit.qa.service.utils.QuestionPermissionUtil;
import com.ecoit.qa.service.utils.QuestionRoleConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class CategoryResource {
	private static CategoryResource instance = null;
	
	public static CategoryResource getInstance() {
		if (instance == null) {
			instance = new CategoryResource();
		}
		return instance;
	}
	
	ObjectMapper mapper = new ObjectMapper();
	@GET
	@Path("/getall/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("groupId") long groupId, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("") @QueryParam("q") String q) {
		try {
			q = HtmlUtil.escape(q);
			if (groupId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = TreeCategory.getCategoryNodes(0, groupId, q, start, limit);
			int count = CategoryLocalServiceUtil.getNodeCount(0, groupId, q);
		    ObjectNode objectNode = mapper.createObjectNode();  
		    objectNode.putPOJO("categories", arrayNode);
		    objectNode.putPOJO("total", count);
		    
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);		
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/item/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getItem(@PathParam("categoryId") long categoryId) {
		try {
			if (categoryId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			Category category = CategoryLocalServiceUtil.getCategory(categoryId);
			CategoryObject object = new CategoryObject();
			object.setCategoryId(categoryId);
			object.setName(category.getName());
			object.setDescription(category.getDescription());
			object.setPosition(category.getPosition());
			object.setParentId(category.getParentId());		
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, object, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse create(@PathParam("groupId") long groupId, @PathParam("userId") long userId, @PathParam("companyId") long companyId, CategoryObject categoryObject) {
		try {
			if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.EDIT_CATEGORY)) {
				if (groupId < 0 || companyId < 0) {
					return DataResponse.PARAM_ERROR;
				}
				
				String name = HtmlUtil.escape(categoryObject.getName());
				String description = HtmlUtil.escape(categoryObject.getDescription());
				int position = categoryObject.getPosition();
				long parentId = categoryObject.getParentId();
				
				CategoryLocalServiceUtil.createUpdateCategory(0, groupId, companyId, userId, name, description, position, parentId);
				
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/max-order-number/{groupId}/{companyId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getMaxOrderNumber(@PathParam("groupId") long groupId,
			@PathParam("parentId") long parentId, @PathParam("companyId") long companyId) {
		try {

			if (groupId < 0 || parentId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			int max = CategoryLocalServiceUtil.getMax(groupId, parentId, companyId);
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
	
	@PUT
	@Path("/update/{groupId}/{userId}/{companyId}/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse update(@PathParam("groupId") long groupId, @PathParam("userId") long userId, @PathParam("companyId") long companyId, 
			@PathParam("categoryId") long categoryId, CategoryObject categoryObject) {
		try {
			if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.EDIT_CATEGORY)) {
				if (groupId < 0 || companyId < 0) {
					return DataResponse.PARAM_ERROR;
				}
				
				String name = HtmlUtil.escape(categoryObject.getName());
				String description = HtmlUtil.escape(categoryObject.getDescription());
				int position = categoryObject.getPosition();
				long parentId = categoryObject.getParentId();
				
				CategoryLocalServiceUtil.createUpdateCategory(categoryId, groupId, companyId, userId, name, description, position, parentId);
				
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/delete/{groupId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse Delete(@PathParam("groupId") long groupId,
			@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
			if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.EDIT_CATEGORY)) {
	            long[] categoryIdList = ParamUtil.getLongValues(request, "categoryId");
				
				if (groupId < 0 || categoryIdList == null || categoryIdList.length <= 0) {
					return DataResponse.PARAM_ERROR;
				}
	            
				for (long categoryId : categoryIdList) {
					List<Question> questionList = QuestionLocalServiceUtil.getByCategoryId(categoryId);
					if (questionList.size() > 0 && questionList != null) {
						return new DataResponse(ResponseCode.CONFLICT_ERROR, ResponseCode.CONFLICT_ERROR, "", DataType.JSON_STR);
					}
					
					//check existing question with child category
					List<Long> listCategoryIds = TreeCategory.getListCategoryIds(categoryId, groupId);
					if (listCategoryIds != null && listCategoryIds.size() > 0) {
						List<Question> childQuestionList = QuestionLocalServiceUtil.getByCategoryId(categoryId);
						if (childQuestionList.size() > 0 && childQuestionList != null) {
							return new DataResponse(ResponseCode.CONFLICT_ERROR, ResponseCode.CONFLICT_ERROR, "", DataType.JSON_STR);
						}
					}

					if (listCategoryIds != null && listCategoryIds.size() > 0) {
						for (Long childCategoryId : listCategoryIds) {
							CategoryLocalServiceUtil.deleteCategory(childCategoryId);
							GroupUserCategoryLocalServiceUtil.removeByCategoryId(childCategoryId);
						}
					}
					CategoryLocalServiceUtil.deleteCategory(categoryId);
					GroupUserCategoryLocalServiceUtil.removeByCategoryId(categoryId);
				}
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/getall-category/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("groupId") long groupId) {
		try {
			ArrayNode arrayNode = TreeCategory.getCategoryNodes(0, groupId, "", 0, -1);
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);		
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
