package com.ecoit.mr.api;

import java.util.ArrayList;
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

import com.ecoit.mr.model.UserPermissionGroup;
import com.ecoit.mr.object.PermissionGroupObject;
import com.ecoit.mr.object.PermissionObject;
import com.ecoit.mr.service.PermissionGroupLocalServiceUtil;
import com.ecoit.mr.service.UserGroupLocalServiceUtil;
import com.ecoit.mr.service.UserPermissionGroupLocalServiceUtil;
import com.ecoit.mr.utils.DataResponse;
import com.ecoit.mr.utils.DataResponse.DataType;
import com.ecoit.mr.utils.PermissionUtil;
import com.ecoit.mr.utils.ResponseCode;
import com.ecoit.mr.utils.RoleConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;

@Path("/permission")
public class PermissionResource {
private static PermissionResource instance = null;
ObjectMapper mapper = new ObjectMapper();
	public static PermissionResource getInstance() {
		if (instance == null) {
			instance = new PermissionResource();
		}
		return instance;
	}
	
	@GET
	@Path("/getall/{groupId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("groupId") long groupId,
			@PathParam("userId") long userId, @DefaultValue("10") @QueryParam("limit") int limit, 
			@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("") @QueryParam("q") String q) {
		try {
			
            q = HtmlUtil.escape(q);
			
			if (start < 0) {
				start = 0;
			}
			
			if (limit < 0) {
				limit = 0;
			}
			
			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.PERMISSION)) {
				List<UserPermissionGroup> groups = UserPermissionGroupLocalServiceUtil.getList(groupId, q, start, limit);
	            List<PermissionGroupObject> permissionsGroupList = new ArrayList<PermissionGroupObject>();
	            for (UserPermissionGroup group : groups) {
	            	PermissionGroupObject permissionGroup = new PermissionGroupObject();
	            	permissionGroup.setGroupUserId(group.getUserPermissionGroupId());
	            	permissionGroup.setGroupId(group.getGroupId());
	            	permissionGroup.setGroupName(HtmlUtil.extractText(group.getGroupName()));
	            	permissionGroup.setDescription(HtmlUtil.extractText(group.getDescription()));
	            	int total1 = UserGroupLocalServiceUtil.countMemberInGroup(userId, permissionGroup.getGroupUserId(), q);
	            	permissionGroup.setMemberInGroup(total1);
	            	permissionsGroupList.add(permissionGroup);
	            }
	            
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = mapper.createObjectNode();
	            int total = UserPermissionGroupLocalServiceUtil.getTotal(groupId, q);
				objectNode.put("total", total);
				objectNode.putPOJO("data", permissionsGroupList);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
	      }catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@POST
	@Path("/create/{userId}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse create(@PathParam("groupId") long groupId, @PathParam("userId") long userId, PermissionObject object) {
		try {

			String groupName = HtmlUtil.escape(object.getGroupName());
			String description = HtmlUtil.escape(object.getDescription());

			if (groupId < 0 || object.getGroupName().length() == 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.PERMISSION)) {

				UserPermissionGroupLocalServiceUtil.createUpdateGroupUser(userId, groupId, -1, groupName, description, object.getUsers(), 
						object.getPermissions());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@PUT
	@Path("/update/{userId}/{groupId}/{groupUserId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse update(@PathParam("groupUserId") long groupUserId, @PathParam("groupId") long groupId, 
			@PathParam("userId") long userId, PermissionObject object) {
		try {

			String groupName = HtmlUtil.escape(object.getGroupName());
			String description = HtmlUtil.escape(object.getDescription());

			if (groupId < 0 || object.getGroupName().length() == 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.PERMISSION)) {
				UserPermissionGroupLocalServiceUtil.createUpdateGroupUser(userId, groupId, groupUserId, groupName, description, object.getUsers(), 
						object.getPermissions());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/update/view/{userId}/{groupId}/{locale}/{companyId}/{groupUserId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse UpdateView(@PathParam("groupId") long groupId,
			@PathParam("locale") String locale, @PathParam("companyId") long companyId,
			@PathParam("groupUserId") long groupUserId, @PathParam("userId") long userId) {
		try {

			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || companyId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.PERMISSION)) {
				ObjectNode node = mapper.createObjectNode();
				if (groupUserId > 0) {
					UserPermissionGroup group = UserPermissionGroupLocalServiceUtil.getUserPermissionGroup(groupUserId);
					node.put("name", HtmlUtil.extractText(group.getGroupName()));
					node.put("description", HtmlUtil.extractText(group.getDescription()));
				} else {
					node.put("name", "");
					node.put("description", "");
				}


				ArrayNode arrPer = mapper.createArrayNode();
				for (int i = 0; i < RoleConstants.PERMISSION_ARRAY.length; i++) {
					ObjectNode nodeRole = mapper.createObjectNode();
					nodeRole.putPOJO("id", i);
					nodeRole.putPOJO("name", RoleConstants.PERMISSION_ARRAY[i]);
					boolean checked = PermissionGroupLocalServiceUtil.checkPermission(groupUserId, i);
					nodeRole.putPOJO("checked", checked);
					arrPer.addPOJO(nodeRole);
				}
				
				List<User> usersList = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				ArrayNode arrUser = mapper.createArrayNode();

				for (User user : usersList) {
					ObjectNode nodeUser = mapper.createObjectNode();
					boolean checked = UserGroupLocalServiceUtil.isContain(groupUserId, user.getUserId());
					List<Role> rolesList = user.getRoles();
					boolean isAdd = true;
					for (Role role : rolesList) {
					
	                    if (role.getName().equals("Administrator")) {
	                    	isAdd = false;
	                    }
					}
					
					if (isAdd) {
						nodeUser.putPOJO("id", user.getUserId());
						nodeUser.putPOJO("name", user.getScreenName());
						nodeUser.putPOJO("checked", checked);
						arrUser.addPOJO(nodeUser);
					}
				}
				
				node.putPOJO("permissions", arrPer);
				node.putPOJO("users", arrUser);

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@DELETE
	@Path("/delete/{userId}/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse delete(@PathParam("userId") long userId, @PathParam("id") int id,@PathParam("groupId") int groupId) {
		try {

			if (groupId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.PERMISSION)) {
				UserPermissionGroupLocalServiceUtil.deleteUserPermissionGroup(id);

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}
	
}

