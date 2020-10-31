package cms.managerment.api;

import com.google.gson.JsonArray;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.software.cms.model.GroupCategory;
import com.software.cms.model.GroupUser;
import com.software.cms.model.GroupUserUsers;
import com.software.cms.model.PermissionGroup;
import com.software.cms.service.GroupCategoryLocalServiceUtil;
import com.software.cms.service.GroupUserLocalService;
import com.software.cms.service.GroupUserLocalServiceUtil;
import com.software.cms.service.GroupUserUsersLocalServiceUtil;
import com.software.cms.service.PermissionGroupLocalServiceUtil;
import com.software.cms.service.persistence.GroupUserUsersPK;
import com.software.cms.service.persistence.PermissionGroupPK;
import com.software.util.RoleConstants;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Reference;

import cms.managerment.object.CategoryObject;
import cms.managerment.object.ManagermentObject;
import cms.managerment.object.ManagermentObject.PermissionsGroup;
import cms.managerment.object.ManagermentObject.PermissionsUpdate;
import cms.managerment.utils.TreeCategory;
import cms.managerment.utils.response.DataResponse;
import cms.managerment.utils.response.DataResponse.DataType;
import cms.managerment.utils.response.ResponseCode;

public class ManagermentResource {

	private static ManagermentResource instance = null;

	public static ManagermentResource getInstance() {
		if (instance == null) {
			instance = new ManagermentResource();
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
			System.out.println(groups + "--");
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


}
