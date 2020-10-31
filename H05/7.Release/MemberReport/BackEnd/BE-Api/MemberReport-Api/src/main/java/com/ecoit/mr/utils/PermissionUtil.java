package com.ecoit.mr.utils;

import java.util.List;

import com.ecoit.mr.model.UserGroup;
import com.ecoit.mr.service.PermissionGroupLocalServiceUtil;
import com.ecoit.mr.service.UserGroupLocalServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class PermissionUtil {

	public static ArrayNode getPermissionNode(long userId) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode acceptUserPermissison = mapper.createArrayNode();
		if (checkPermissionAccessZone(userId, RoleConstants.REPORT_ADD)) {
			acceptUserPermissison.add("ADD");
		}

		if (checkPermissionAccessZone(userId, RoleConstants.REPORT_EDIT)) {
			acceptUserPermissison.add("EDIT");
		}
			
		if (checkPermissionAccessZone(userId, RoleConstants.REPORT_VIEWALL)) {
			acceptUserPermissison.add("VIEWALL");
		}
		
		if (checkPermissionAccessZone(userId, RoleConstants.REPORT_REMOVE)) {
			acceptUserPermissison.add("REMOVE");
		}
		
		if (checkPermissionAccessZone(userId, RoleConstants.REPORT_PENDING)) {
			acceptUserPermissison.add("PENDING");
		}
		return acceptUserPermissison;
	}
	public static boolean checkPermissionAccessZone(long userId, int permission) {
		boolean isPermitted = false;
		try {
			List<UserGroup> userGroupationsList = UserGroupLocalServiceUtil.getByUserId(userId);
			User user = UserLocalServiceUtil.getUser(userId);
			List<Role> rolesList = user.getRoles();
			for (Role role : rolesList) {
                if (role.getName().equals("Administrator")) {
                	return true;
                }
			}
			for (UserGroup userGroup : userGroupationsList) {
				if (PermissionGroupLocalServiceUtil.checkPermission(userGroup.getUserPermissionGroupId(), permission)) {
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
