package com.ecoit.lichcongtac.util;

import java.util.List;

import com.ecoit.lichcongtac.services.model.UserGroupRel;
import com.ecoit.lichcongtac.services.service.ColumnGroupRelLocalServiceUtil;
import com.ecoit.lichcongtac.services.service.PermissionGroupRelLocalServiceUtil;
import com.ecoit.lichcongtac.services.service.UserGroupRelLocalServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class PermissionUtil {
	
	public static ArrayNode getPermissionNode(long userId) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode acceptUserPermissison = mapper.createArrayNode();
		if (checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_ADD)) {
			acceptUserPermissison.add("ADD");
		}

		if (checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_EDIT)) {
			acceptUserPermissison.add("EDIT");
		}
		
		if (checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_APPROVED)) {
			acceptUserPermissison.add("APPROVED");
		}
			
		if (checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_PUBLISH)) {
			acceptUserPermissison.add("PUBLISH");
		}
		
		if (checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_APPROVED_RETURN)) {
			acceptUserPermissison.add("DENIEDAPPROVE");
		}
			
		if (checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_PUBLISH_RETURN)) {
			acceptUserPermissison.add("DENIEDPUBLISH");
		}
		
		if (checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_REMOVE)) {
			acceptUserPermissison.add("REMOVE");
		}
		
		if (checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_PENDING)) {
			acceptUserPermissison.add("PENDING");
		}
		
		if (checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_VIEW_ALL)) {
			acceptUserPermissison.add("VIEW_ALL");
		}
		
		if (checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_CO_DINH)) {
			acceptUserPermissison.add("CO_DINH");
		}
		return acceptUserPermissison;
	}
	
	public static boolean checkPermissionAccessZone(long userId, int permission) {
		boolean isPermitted = false;
		try {
			List<UserGroupRel> userGroupRelationsList = UserGroupRelLocalServiceUtil.getByUserId(userId);
			User user = UserLocalServiceUtil.getUser(userId);
			List<Role> rolesList = user.getRoles();
			for (Role role : rolesList) {
                if (role.getName().equals("Administrator")) {
                	return true;
                }
			}
			for (UserGroupRel userGroupRel : userGroupRelationsList) {
				if (PermissionGroupRelLocalServiceUtil.checkPermission(userGroupRel.getUserPermissionGroupId(), permission)) {
					isPermitted = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return isPermitted;
	}
	
	public static boolean checkColumnPermission(long userId, int column) {
		boolean isPermitted = false;
		try {
			List<UserGroupRel> userGroupRelationsList = UserGroupRelLocalServiceUtil.getByUserId(userId);
			User user = UserLocalServiceUtil.getUser(userId);
			List<Role> rolesList = user.getRoles();
			for (Role role : rolesList) {
                if (role.getName().equals("Administrator")) {
                	return true;
                }
			}
			
			for (UserGroupRel userGroupRel : userGroupRelationsList) {
				if (ColumnGroupRelLocalServiceUtil.checkPermission(userGroupRel.getUserPermissionGroupId(), column)) {
					isPermitted = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return isPermitted;
	}
}
