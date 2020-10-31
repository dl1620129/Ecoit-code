package cms.permisstion.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.software.cms.model.GroupCategory;
import com.software.cms.model.GroupUser;
import com.software.cms.model.GroupUserUsers;
import com.software.cms.model.PermissionGroup;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.cms.service.GroupCategoryLocalServiceUtil;
import com.software.cms.service.GroupUserLocalServiceUtil;
import com.software.cms.service.GroupUserUsersLocalServiceUtil;
import com.software.cms.service.PermissionGroupLocalServiceUtil;
import com.software.cms.service.persistence.GroupUserUsersPK;
import com.software.cms.service.persistence.PermissionGroupPK;
import com.software.util.DataResponse;
import com.software.util.DataResponse.DataType;
import com.software.util.ResponseCode;
import com.software.util.RoleConstants;
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

import cms.permisstion.object.PermisstionObject;
import cms.permisstion.object.PermisstionObject.PermissionsGroup;
import cms.permisstion.utils.TreeCategory;

public class PermisstionResource {

	private static PermisstionResource instance = null;

	public static PermisstionResource getInstance() {
		if (instance == null) {
			instance = new PermisstionResource();
		}
		return instance;
	}

	@GET
	@Path("/view/{scopeGroupId}/{locale}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getPermissions(@PathParam("scopeGroupId") long scopeGroupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (scopeGroupId < 0 || locale.isEmpty() || userId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			List<GroupUser> groups = null;

			try {
				groups = GroupUserLocalServiceUtil.findByGroup_Language(scopeGroupId, locale);
			} catch (Exception e) {
				groups = null;
			}

			if (groups.isEmpty()) {

				long groupUserId = CounterLocalServiceUtil.increment(GroupUser.class.getName());
				GroupUser groupUser = GroupUserLocalServiceUtil.createGroupUser(groupUserId);
				groupUser.setName("Administrator");
				groupUser.setGroupId(scopeGroupId);
				groupUser.setLanguage(locale);
				groupUser = GroupUserLocalServiceUtil.updateGroupUser(groupUser);
				// create group user user
				GroupUserUsersPK pk = new GroupUserUsersPK(groupUser.getGroupUserId(), userId);
				GroupUserUsers groupUserUsers = GroupUserUsersLocalServiceUtil.createGroupUserUsers(pk);
				groupUserUsers.setGroupId(scopeGroupId);
				GroupUserUsersLocalServiceUtil.updateGroupUserUsers(groupUserUsers);
				// create permission
				PermissionGroupPK ppk = new PermissionGroupPK(RoleConstants.PERMISSION, groupUser.getGroupUserId());
				PermissionGroup pgroup = PermissionGroupLocalServiceUtil.createPermissionGroup(ppk);
				pgroup.setGroupId(scopeGroupId);
				PermissionGroupLocalServiceUtil.updatePermissionGroup(pgroup);

			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/getall/{scopeGroupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("scopeGroupId") long scopeGroupId, @PathParam("locale") String locale,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("") @QueryParam("q") String q) {
		try {

			locale = HtmlUtil.escape(locale);
			q = HtmlUtil.escape(q);

			if (scopeGroupId < 0 || locale.isEmpty() || start < 0 || limit < 0) {
				return DataResponse.PARAM_ERROR;
			}

			q = q.isEmpty() ? "" : q.toLowerCase();
			List<GroupUser> groups = GroupUserLocalServiceUtil.findByGroup_Language(scopeGroupId, locale, start, limit,
					q);

			List<PermissionsGroup> arrPermissions = new ArrayList<PermissionsGroup>();
			for (GroupUser groupUser : groups) {
				PermisstionObject.PermissionsGroup permissionsGroup = new PermissionsGroup();
				permissionsGroup.setNameGroup(groupUser.getName());
				permissionsGroup.setDescription(groupUser.getDescription());
				int total = GroupUserLocalServiceUtil.countMemberInGroup(groupUser.getGroupId(),
						groupUser.getGroupUserId());
				permissionsGroup.setMemberInGroup(total);
				permissionsGroup.setLanguage(groupUser.getLanguage());
				permissionsGroup.setGroupId(groupUser.getGroupId());
				permissionsGroup.setGroupUserId(groupUser.getGroupUserId());
				arrPermissions.add(permissionsGroup);
			}

			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectNode = mapper.createObjectNode();
			int total = GroupUserLocalServiceUtil.countByGroup_Language(scopeGroupId, locale, q);
			objectNode.put("total", total);
			objectNode.putPOJO("data", arrPermissions);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@POST
	@Path("/create/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse create(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			PermisstionObject object) {
		try {
			locale = HtmlUtil.escape(locale);

			List<String> listU = new ArrayList<>();
			for (String u : object.getUsers()) {
				listU.add(HtmlUtil.escape(u));
			}
			String[] users = listU.toArray(new String[0]);

			List<String> listC = new ArrayList<>();
			for (String c : object.getCategories()) {
				listC.add(HtmlUtil.escape(c));
			}
			String[] categories = listC.toArray(new String[0]);

			List<String> listP = new ArrayList<>();
			for (String p : object.getPermissions()) {
				listP.add(HtmlUtil.escape(p));
			}
			String[] permissions = listP.toArray(new String[0]);

			String groupName = HtmlUtil.escape(object.getGroupName());
			String description = HtmlUtil.escape(object.getDescription());

			if (groupId < 0 || object.getGroupName().length() == 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			PermissionGroupLocalServiceUtil.updateCreateGroupUser(groupId, locale, -1, groupName, description, users,
					permissions, categories);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/update/view/{groupUserId}/{groupId}/{userId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse UpdateView(@PathParam("groupUserId") long groupUserId, @PathParam("groupId") long groupId,
			@PathParam("userId") long userId, @PathParam("locale") String locale) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupUserId < 0 || groupId < 0 || userId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			PermisstionObject.PermissionsUpdate permissionsUpdate = new PermisstionObject.PermissionsUpdate();

			GroupUser groupUser = GroupUserLocalServiceUtil.getGroupUser(groupUserId);
			String name = groupUser.getName();
			String description = groupUser.getDescription();

			List<User> lstUsers = UserLocalServiceUtil.getGroupUsers(groupId);

			permissionsUpdate.setName(name);
			permissionsUpdate.setDescription(description);

			List<PermisstionObject.PermissionsUpdate.User> arrUsers = new ArrayList<PermisstionObject.PermissionsUpdate.User>();
			for (User ugr : lstUsers) {

				PermisstionObject.PermissionsUpdate.User users = new PermisstionObject.PermissionsUpdate.User();
				boolean checked = GroupUserUsersLocalServiceUtil.hasGroupUserUsers(groupUserId, ugr.getUserId());
				users.setScreenName(ugr.getScreenName());
				users.setUserId(ugr.getUserId());
				users.setChecked(checked);
				arrUsers.add(users);
			}
			permissionsUpdate.setUsers(arrUsers);

			List<PermisstionObject.PermissionsUpdate.Permission> arrPermissions = new ArrayList<PermisstionObject.PermissionsUpdate.Permission>();
			for (int i = 0; i < RoleConstants.PERMISSION_ARRAY.length; i++) {
				PermisstionObject.PermissionsUpdate.Permission permiss = new PermisstionObject.PermissionsUpdate.Permission();
				boolean checked = PermissionGroupLocalServiceUtil.hasPermissionGroup(i, groupUserId);
				permiss.setPermissionId(i);
				permiss.setRole(RoleConstants.PERMISSION_ARRAY[i]);
				permiss.setChecked(checked);
				arrPermissions.add(permiss);
			}
			permissionsUpdate.setPermissions(arrPermissions);

			List<PermisstionObject.PermissionsUpdate.Category> arrCategorys = new ArrayList<PermisstionObject.PermissionsUpdate.Category>();
			List<GroupCategory> groupCategory = GroupCategoryLocalServiceUtil
					.getByUserIdAndGroupIdAndGroupUserId(userId, groupId, groupUserId);
			for (GroupCategory gCate : groupCategory) {
				PermisstionObject.PermissionsUpdate.Category cate = new PermisstionObject.PermissionsUpdate.Category();
				cate.setCategoryId(gCate.getCategoryId());
				cate.setCategoryName("");
				cate.setChecked(true);
				arrCategorys.add(cate);
			}
			permissionsUpdate.setCategories(arrCategorys);

			TreeCategory treeCategory = new TreeCategory();
			ArrayNode categoriesNode = treeCategory.getNodes(0, groupId, locale, treeCategory.NODE_PARENT, "", -1, -1);
			permissionsUpdate.setCategoriesNode(categoriesNode);

			return new DataResponse(ResponseCode.SUCCESSFUL, "SUCCESSFUL", permissionsUpdate, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}

	@GET
	@Path("/view/{groupId}/{locale}/users/search")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse ViewSearch(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@DefaultValue("") @QueryParam("u") String u, @DefaultValue("") @QueryParam("c") String c) {
		try {
			locale = HtmlUtil.escape(locale);
			u = HtmlUtil.escape(u);

			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			PermisstionObject.PermissionsUpdate permissionsUpdate = new PermisstionObject.PermissionsUpdate();

			List<Object[]> lstUsers = GroupUserLocalServiceUtil.getUserByNameGroup(u, groupId, locale);

			List<PermisstionObject.PermissionsUpdate.User> arrUsers = new ArrayList<PermisstionObject.PermissionsUpdate.User>();

			for (Object[] ugr : lstUsers) {
				long uId = Long.parseLong(ugr[0].toString());
				String uScreen = ugr[1].toString();
				PermisstionObject.PermissionsUpdate.User usersObj = new PermisstionObject.PermissionsUpdate.User();
				usersObj.setScreenName(uScreen);
				usersObj.setUserId(uId);
				usersObj.setChecked(false);
				arrUsers.add(usersObj);
			}
			permissionsUpdate.setUsers(arrUsers);

			List<PermisstionObject.PermissionsUpdate.Permission> arrPermission = new ArrayList<PermisstionObject.PermissionsUpdate.Permission>();
			for (int i = 0; i < RoleConstants.PERMISSION_ARRAY.length; i++) {
				PermisstionObject.PermissionsUpdate.Permission permission = new PermisstionObject.PermissionsUpdate.Permission();
				String role = RoleConstants.PERMISSION_ARRAY[i];
				permission.setRole(role);
				permission.setPermissionId(i);
				permission.setChecked(false);
				arrPermission.add(permission);
			}
			permissionsUpdate.setPermissions(arrPermission);

			TreeCategory treeCategory = new TreeCategory();
			ArrayNode categoriesNode = treeCategory.getNodes(0, groupId, locale, treeCategory.NODE_PARENT, c, -1, -1);
			permissionsUpdate.setCategoriesNode(categoriesNode);

			return new DataResponse(ResponseCode.SUCCESSFUL, "SUCCESSFUL", permissionsUpdate, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}

	@PUT
	@Path("/update/{groupUserId}/{groupId}/{locale}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataResponse update(@PathParam("groupUserId") long groupUserId, @PathParam("groupId") long groupId,
			@PathParam("locale") String locale, PermisstionObject object) {
		try {

			locale = HtmlUtil.escape(locale);
			String groupName = HtmlUtil.escape(object.getGroupName());
			String description = HtmlUtil.escape(object.getDescription());

			if (groupUserId < 0 || groupId < 0 || object.getGroupName().length() == 0 || locale.isEmpty()
					|| groupName.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			List<String> listU = new ArrayList<>();
			for (String u : object.getUsers()) {
				listU.add(HtmlUtil.escape(u));
			}
			String[] users = listU.toArray(new String[0]);

			List<String> listC = new ArrayList<>();
			for (String c : object.getCategories()) {
				listC.add(HtmlUtil.escape(c));
			}
			String[] categories = listC.toArray(new String[0]);

			List<String> listP = new ArrayList<>();
			for (String p : object.getPermissions()) {
				listP.add(HtmlUtil.escape(p));
			}
			String[] permissions = listP.toArray(new String[0]);

			PermissionGroupLocalServiceUtil.updateCreateGroupUser(groupId, locale, groupUserId, groupName, description,
					users, permissions, categories);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {

			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@DELETE
	@Path("/delete/{groupUserId}/{scopeGroupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse delete(@PathParam("groupUserId") int groupUserId, @PathParam("scopeGroupId") int scopeGroupId) {
		try {

			if (groupUserId < 0 || scopeGroupId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			GroupUserLocalServiceUtil.deleteGroupUser(groupUserId);
			GroupUserUsersLocalServiceUtil.removeByGroup_GroupUser(scopeGroupId, groupUserId);
			GroupCategoryLocalServiceUtil.removeByGroupUserId(groupUserId);
			PermissionGroupLocalServiceUtil.removeByGroup_GroupUser(scopeGroupId, groupUserId);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}

}
