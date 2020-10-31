package com.ecoit.qa.permission.api;

import java.util.ArrayList;
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

import com.ecoit.qa.permission.object.PermissionFormObject;
import com.ecoit.qa.permission.object.PermissionObject;
import com.ecoit.qa.permission.object.TreeCategory;
import com.ecoit.qa.service.model.GroupUser;
import com.ecoit.qa.service.service.GroupUserLocalServiceUtil;
import com.ecoit.qa.service.service.GroupUserPermissionLocalServiceUtil;
import com.ecoit.qa.service.service.GroupUserUserLocalServiceUtil;
import com.ecoit.qa.service.utils.DataResponse;
import com.ecoit.qa.service.utils.QuestionPermissionUtil;
import com.ecoit.qa.service.utils.DataResponse.DataType;
import com.ecoit.qa.service.utils.QuestionRoleConstants;
import com.ecoit.qa.service.utils.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;


public class PermissionResource {
	private static PermissionResource instance;

	public static PermissionResource getInstance() {
		if (instance == null) {
			instance = new PermissionResource();
		}
		return instance;
	}

	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/getall/{userId}/{scopeGroupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("userId") long userId, @PathParam("scopeGroupId") long scopeGroupId, @DefaultValue("10") 
	        @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("") @QueryParam("q") String q) {
		try {

			if (scopeGroupId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			q = q.isEmpty() ? "" : q.toLowerCase();
			if (start < 0) {
				start = 0;
			}
			
			if (limit < 0) {
				limit = 0;
			}
			
			if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.PERMISSION)) {		
				List<GroupUser> groups = GroupUserLocalServiceUtil.findBySearchKey(scopeGroupId, start, limit, q);
	            List<PermissionObject> permissionsGroupList = new ArrayList<PermissionObject>();
	            for (GroupUser group : groups) {
	            	PermissionObject permissionGroup = new PermissionObject();
	            	permissionGroup.setGroupUserId(group.getGroupUserId());
	            	permissionGroup.setGroupId(group.getGroupId());
	            	permissionGroup.setName(group.getName());
	            	permissionGroup.setDescription(group.getDescription());
	            	int total = GroupUserUserLocalServiceUtil.getUserCount(group.getGroupUserId());
	            	permissionGroup.setMemberInGroup(total);
	            	permissionsGroupList.add(permissionGroup);
	            }
	            
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = mapper.createObjectNode();
	            int total = GroupUserLocalServiceUtil.countTotalGroup(scopeGroupId, q);
				objectNode.put("total", total);
				objectNode.putPOJO("data", permissionsGroupList);
				
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse create(@PathParam("groupId") long groupId, @PathParam("userId") long userId, PermissionFormObject formObject) {
		try {

			String groupName = HtmlUtil.escape(formObject.getName());
			String description = HtmlUtil.escape(formObject.getDescription());

			if (groupId < 0 || formObject.getName().length() == 0 || userId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.PERMISSION)) {
				
				GroupUserLocalServiceUtil.createUpdateGroupUser(userId, groupId, -1, groupName, description, formObject.getUsers(), 
						formObject.getPermissions(), formObject.getCategories());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update/{groupId}/{userId}/{groupUserId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse update(@PathParam("groupUserId") long groupUserId, @PathParam("groupId") long groupId, 
			@PathParam("userId") long userId, PermissionFormObject formObject) {
		try {

			String groupName = HtmlUtil.escape(formObject.getName());
			String description = HtmlUtil.escape(formObject.getDescription());

			if (groupId < 0 || formObject.getName().length() == 0 || userId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.PERMISSION)) {
				GroupUserLocalServiceUtil.createUpdateGroupUser(userId, groupId, groupUserId, groupName, description, formObject.getUsers(), 
						formObject.getPermissions(), formObject.getCategories());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/update/view/{groupId}/{groupUserId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse UpdateView(@PathParam("groupId") long groupId,
			@PathParam("groupUserId") long groupUserId) {
		try {

			if (groupId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			ObjectNode node = mapper.createObjectNode();
			if (groupUserId > 0) {
				GroupUser group = GroupUserLocalServiceUtil.getGroupUser(groupUserId);
				node.put("name", group.getName());
				node.put("description", group.getDescription());
			} else {
				node.put("name", "");
				node.put("description", "");
			}


			ArrayNode arrPer = mapper.createArrayNode();
			for (int i = 0; i < QuestionRoleConstants.PERMISSION_ARRAY.length; i++) {
				ObjectNode nodeRole = mapper.createObjectNode();
				nodeRole.putPOJO("id", i);
				nodeRole.putPOJO("name", QuestionRoleConstants.PERMISSION_ARRAY[i]);
				boolean checked = GroupUserPermissionLocalServiceUtil.checkPermission(groupUserId, i);
				nodeRole.putPOJO("checked", checked);
				arrPer.addPOJO(nodeRole);
			}
			
			List<Object> usersList = GroupUserLocalServiceUtil.getListOfUser(groupId);
			ArrayNode arrUser = mapper.createArrayNode();

			for (Object user : usersList) {
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray(JSONFactoryUtil.serialize(user));
				ObjectNode nodeUser = mapper.createObjectNode();
				boolean checked = GroupUserUserLocalServiceUtil.hasUser(groupUserId, Long.valueOf(jsonArray.getString(0)));
				nodeUser.putPOJO("id", jsonArray.getString(0));
				nodeUser.putPOJO("name", jsonArray.getString(1));
				nodeUser.putPOJO("checked", checked);
				arrUser.addPOJO(nodeUser);
			}

			//get category tree checked
			ArrayNode dataTreeOrg = TreeCategory.getCategoryCheckedNodes(0, groupId, groupUserId);
			
			
			node.putPOJO("permissions", arrPer);
			node.putPOJO("users", arrUser);
			node.putPOJO("categories", dataTreeOrg);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/delete/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse delete(@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {

			if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.PERMISSION)) {
	            long[] groupUserIdList = ParamUtil.getLongValues(request, "groupUserId");
				
				if (groupUserIdList == null || groupUserIdList.length <= 0) {
					return DataResponse.PARAM_ERROR;
				}
	            for (long groupUserId : groupUserIdList) {
					GroupUserLocalServiceUtil.removeGroupUser(groupUserId);
	            }
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}
}
