package com.ecoit.lichcongtac.api;

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

import com.ecoit.lichcongtac.object.PermissionGroupObject;
import com.ecoit.lichcongtac.object.PermissionObject;
import com.ecoit.lichcongtac.services.model.UserPermissionGroup;
import com.ecoit.lichcongtac.services.service.ColumnGroupRelLocalServiceUtil;
import com.ecoit.lichcongtac.services.service.PermissionGroupRelLocalServiceUtil;
import com.ecoit.lichcongtac.services.service.UserGroupRelLocalServiceUtil;
import com.ecoit.lichcongtac.services.service.UserPermissionGroupLocalServiceUtil;
import com.ecoit.lichcongtac.util.DataResponse;
import com.ecoit.lichcongtac.util.DataResponse.DataType;
import com.ecoit.lichcongtac.util.LichCongTacRoleConstants;
import com.ecoit.lichcongtac.util.PermissionUtil;
import com.ecoit.lichcongtac.util.ResponseCode;
import com.ecoit.lichcongtac.util.XuatLichColumnConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;


@Path("/permission")
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
	@Path("/getall/{scopeGroupId}/{userId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("scopeGroupId") long scopeGroupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @DefaultValue("10") @QueryParam("limit") int limit, 
			@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("") @QueryParam("q") String q) {
		try {

			locale = HtmlUtil.escape(locale);
            q = HtmlUtil.escape(q);
			if (locale.isEmpty() || scopeGroupId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			if (start < 0) {
				start = 0;
			}
			
			if (limit < 0) {
				limit = 0;
			}
			
			if (PermissionUtil.checkPermissionAccessZone(userId, LichCongTacRoleConstants.PERMISSION)) {
				List<UserPermissionGroup> groups = UserPermissionGroupLocalServiceUtil.findBySearchKey(scopeGroupId, start, limit, q);
	            List<PermissionGroupObject> permissionsGroupList = new ArrayList<PermissionGroupObject>();
	            for (UserPermissionGroup group : groups) {
	            	PermissionGroupObject permissionGroup = new PermissionGroupObject();
	            	permissionGroup.setGroupUserId(group.getUserPermissionGroupId());
	            	permissionGroup.setGroupId(group.getGroupId());
	            	permissionGroup.setGroupName(group.getGroupName());
	            	permissionGroup.setDescription(group.getDescription());
	            	int total = UserGroupRelLocalServiceUtil.countMemberInGroup(group.getUserPermissionGroupId());
	            	permissionGroup.setMemberInGroup(total);
	            	permissionsGroupList.add(permissionGroup);
	            }
	            
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = mapper.createObjectNode();
	            int total = UserPermissionGroupLocalServiceUtil.countTotalGroup(scopeGroupId, q);
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
			
			if (PermissionUtil.checkPermissionAccessZone(userId, LichCongTacRoleConstants.PERMISSION)) {
				UserPermissionGroupLocalServiceUtil.createUpdateGroupUser(userId, groupId, -1, groupName, description, object.getUsers(), 
						object.getPermissions(), object.getColumns());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
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
			
			if (PermissionUtil.checkPermissionAccessZone(userId, LichCongTacRoleConstants.PERMISSION)) {
				UserPermissionGroupLocalServiceUtil.createUpdateGroupUser(userId, groupId, groupUserId, groupName, description, object.getUsers(), 
						object.getPermissions(), object.getColumns());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
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

			if (PermissionUtil.checkPermissionAccessZone(userId, LichCongTacRoleConstants.PERMISSION)) {
				ObjectNode node = mapper.createObjectNode();
				if (groupUserId > 0) {
					UserPermissionGroup group = UserPermissionGroupLocalServiceUtil.getUserPermissionGroup(groupUserId);
					node.put("name", group.getGroupName());
					node.put("description", group.getDescription());
				} else {
					node.put("name", "");
					node.put("description", "");
				}


				ArrayNode arrPer = mapper.createArrayNode();
				for (int i = 0; i < LichCongTacRoleConstants.PERMISSION_ARRAY.length; i++) {
					ObjectNode nodeRole = mapper.createObjectNode();
					nodeRole.putPOJO("id", i);
					nodeRole.putPOJO("name", LichCongTacRoleConstants.PERMISSION_ARRAY[i]);
					boolean checked = PermissionGroupRelLocalServiceUtil.checkPermission(groupUserId, i);
					nodeRole.putPOJO("checked", checked);
					arrPer.addPOJO(nodeRole);
				}
				
				//cột excel xuất bản
				ArrayNode arrCol = mapper.createArrayNode();
				for (int i = 0; i < XuatLichColumnConstants.COLUMN_PERMISSION_ARRAY.length; i++) {
					ObjectNode nodeRole = mapper.createObjectNode();
					nodeRole.putPOJO("id", i);
					nodeRole.putPOJO("name", XuatLichColumnConstants.COLUMN_PERMISSION_ARRAY[i]);
					boolean checked = ColumnGroupRelLocalServiceUtil.checkPermission(groupUserId, i);
					nodeRole.putPOJO("checked", checked);
					arrCol.addPOJO(nodeRole);
				}
				
				
				List<Object> usersList = UserPermissionGroupLocalServiceUtil.getListOfUser(groupId);
				ArrayNode arrUser = mapper.createArrayNode();
				
				for (Object user : usersList) {
					JSONArray jsonArray = JSONFactoryUtil.createJSONArray(JSONFactoryUtil.serialize(user));
					ObjectNode nodeUser = mapper.createObjectNode();
					boolean checked = UserGroupRelLocalServiceUtil.isContain(groupUserId, jsonArray.getLong(0));
					nodeUser.putPOJO("id", jsonArray.getString(0));
					nodeUser.putPOJO("name", jsonArray.getString(1));
					nodeUser.putPOJO("checked", checked);
					arrUser.addPOJO(nodeUser);
				}
				
				node.putPOJO("permissions", arrPer);
				node.putPOJO("users", arrUser);
				node.putPOJO("columns", arrCol);
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/delete/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse delete(@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
            long[] groupUserIdList = ParamUtil.getLongValues(request, "groupUserId");
			
    		if (groupUserIdList == null || groupUserIdList.length <= 0) {
    			return DataResponse.PARAM_ERROR;
    		}
    		if (PermissionUtil.checkPermissionAccessZone(userId, LichCongTacRoleConstants.PERMISSION)) {
        		for (long groupUserId : groupUserIdList) {		
        			UserPermissionGroupLocalServiceUtil.removeGroupUser(groupUserId);       			
        		}
        		return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
    		}

			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}
}
