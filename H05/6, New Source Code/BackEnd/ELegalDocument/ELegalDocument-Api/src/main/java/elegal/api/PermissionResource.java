package elegal.api;

import com.ecoit.elegaldocument.model.EcmsGroup;
import com.ecoit.elegaldocument.model.LegalField;
import com.ecoit.elegaldocument.service.EcmsGURelationServiceUtil;
import com.ecoit.elegaldocument.service.EcmsGroupLocalServiceUtil;
import com.ecoit.elegaldocument.service.EcmsPGRelationServiceUtil;
import com.ecoit.elegaldocument.service.GroupFieldLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalFieldServiceUtil;
import com.ecoit.elegaldocument.utils.DataResponse;
import com.ecoit.elegaldocument.utils.DocumentPermissionUtil;
import com.ecoit.elegaldocument.utils.ResponseCode;
import com.ecoit.elegaldocument.utils.DocumentRoleConstants;
import com.ecoit.elegaldocument.utils.DataResponse.DataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import elegal.object.PermissionGroupObject;
import elegal.object.PermissionObject;
import elegal.utils.TreeLegalType;
import elegal.utils.TreeOrg;

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
	@Path("/getall/{userId}/{scopeGroupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("userId") long userId, @PathParam("scopeGroupId") long scopeGroupId, @PathParam("locale") String locale,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("") @QueryParam("q") String q) {
		try {

			locale = HtmlUtil.escape(locale);

			if (locale.isEmpty() || scopeGroupId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			q = q.isEmpty() ? "" : q.toLowerCase();
			if (start < 0) {
				start = 0;
			}
			
			if (limit < 0) {
				limit = 0;
			}
			
			if (DocumentPermissionUtil.checkPermissionAccessZone(scopeGroupId, userId, DocumentRoleConstants.PERMISSION)) {
				List<EcmsGroup> groups = EcmsGroupLocalServiceUtil.findByGroupId(scopeGroupId, start, limit, q);
	            List<PermissionGroupObject> permissionsGroupList = new ArrayList<PermissionGroupObject>();
	            for (EcmsGroup group : groups) {
	            	PermissionGroupObject permissionGroup = new PermissionGroupObject();
	            	permissionGroup.setGroupUserId(group.getGroupUserId());
	            	permissionGroup.setGroupId(group.getGroupId());
	            	permissionGroup.setGroupName(HtmlUtil.extractText(HtmlUtil.extractText(group.getGroupName())));
	            	permissionGroup.setDescription(HtmlUtil.extractText(group.getDescription()));
	            	int total = EcmsGroupLocalServiceUtil.countMemberInGroup(group.getGroupUserId());
	            	permissionGroup.setMemberInGroup(total);
	            	permissionsGroupList.add(permissionGroup);
	            }
	            
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = mapper.createObjectNode();
	            int total = EcmsGroupLocalServiceUtil.countTotalGroup(scopeGroupId, q);
				objectNode.put("total", total);
				objectNode.putPOJO("data", permissionsGroupList);
				
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{userId}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse create(@PathParam("userId") long userId, @PathParam("groupId") long groupId, PermissionObject object) {
		try {

			String groupName = HtmlUtil.escape(object.getGroupName());
			String description = HtmlUtil.escape(object.getDescription());

			if (groupId < 0 || object.getGroupName().length() == 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.PERMISSION)) {
				EcmsGroupLocalServiceUtil.createUpdateEcmsgroup(groupId, -1, groupName, description, object.getUsers(), 
						object.getPermissions(), object.getCategories(), object.getOrganizations(), object.getFields());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update/{userId}/{groupId}/{groupUserId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse update(@PathParam("userId") long userId, @PathParam("groupUserId") long groupUserId, @PathParam("groupId") long groupId, PermissionObject object) {
		try {

			String groupName = HtmlUtil.escape(object.getGroupName());
			String description = HtmlUtil.escape(object.getDescription());

			if (groupId < 0 || object.getGroupName().length() == 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.PERMISSION)) {
				EcmsGroupLocalServiceUtil.createUpdateEcmsgroup(groupId, groupUserId, groupName, description, object.getUsers(), 
						object.getPermissions(), object.getCategories(), object.getOrganizations(), object.getFields());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/update/view/{userId}/{groupId}/{locale}/{companyId}/{groupUserId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse UpdateView(@PathParam("userId") long userId, @PathParam("groupId") long groupId,
			@PathParam("locale") String locale, @PathParam("companyId") long companyId,
			@PathParam("groupUserId") long groupUserId) {
		try {

			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || companyId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.PERMISSION)) {
				ObjectNode node = mapper.createObjectNode();
				if (groupUserId > 0) {
					EcmsGroup group = EcmsGroupLocalServiceUtil.getEcmsGroup(groupUserId);
					node.put("name", HtmlUtil.extractText(group.getGroupName()));
					node.put("description", HtmlUtil.extractText(group.getDescription()));
				} else {
					node.put("name", "");
					node.put("description", "");
				}


				ArrayNode arrPer = mapper.createArrayNode();
				for (int i = 0; i < DocumentRoleConstants.PERMISSION_ARRAY.length; i++) {
					ObjectNode nodeRole = mapper.createObjectNode();
					nodeRole.putPOJO("id", i);
					nodeRole.putPOJO("name", DocumentRoleConstants.PERMISSION_ARRAY[i]);
					boolean checked = EcmsPGRelationServiceUtil.checkPermission(groupUserId, i);
					nodeRole.putPOJO("checked", checked);
					arrPer.addPOJO(nodeRole);
				}
				
				List<Object> usersList = EcmsGroupLocalServiceUtil.getListOfUser(groupId);
				ArrayNode arrUser = mapper.createArrayNode();

				for (Object user : usersList) {
					JSONArray jsonArray = JSONFactoryUtil.createJSONArray(JSONFactoryUtil.serialize(user));
					ObjectNode nodeUser = mapper.createObjectNode();
					boolean checked = EcmsGURelationServiceUtil.isContain(groupUserId, Long.valueOf(jsonArray.getString(0)));
					nodeUser.putPOJO("id", jsonArray.getString(0));
					nodeUser.putPOJO("name", jsonArray.getString(1));
					nodeUser.putPOJO("checked", checked);
					arrUser.addPOJO(nodeUser);
				}

				//get organization tree checked
				TreeOrg treeOrg = new TreeOrg();
				ArrayNode dataTreeOrg = treeOrg.getCheckedNodes(0, groupId, companyId, locale, groupUserId);

				List<LegalField> legalFields = LegalFieldServiceUtil.findAll(groupId, companyId);
				ArrayNode arrField = mapper.createArrayNode();
				if (legalFields != null && legalFields.size() > 0) {
					for (LegalField field : legalFields) {
						if (field.getStatusField()) {
							ObjectNode nodeField = mapper.createObjectNode();
							boolean checked = GroupFieldLocalServiceUtil.hasGroupField(groupUserId, field.getFieldId());
							nodeField.putPOJO("id", field.getFieldId());
							nodeField.putPOJO("name", HtmlUtil.extractText(field.getName()));
							nodeField.putPOJO("checked", checked);
							arrField.addPOJO(nodeField);
						}
					}
				}

				TreeLegalType treeCategory = new TreeLegalType();
				ArrayNode category = treeCategory.getCheckedGroupNodes(0, groupId, companyId, locale, groupUserId);
				
				
				node.putPOJO("permissions", arrPer);
				node.putPOJO("users", arrUser);
				node.putPOJO("organs", dataTreeOrg);
				node.putPOJO("fields", arrField);
				node.putPOJO("categories", category);

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);				
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/delete/{userId}/{scopeGroupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse delete(@PathParam("scopeGroupId") long scopeGroupId, @PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
            long[] groupUserIdList = ParamUtil.getLongValues(request, "groupUserId");
			
    		if (groupUserIdList == null || groupUserIdList.length <= 0) {
    			return DataResponse.PARAM_ERROR;
    		}
    		
			if (DocumentPermissionUtil.checkPermissionAccessZone(scopeGroupId, userId, DocumentRoleConstants.PERMISSION)) {
				for (long groupUserId : groupUserIdList) {
					EcmsGroupLocalServiceUtil.removeEcmsGroup(groupUserId);
				}

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}

}
