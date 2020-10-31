package com.ecoit.qa.service.utils;

import java.util.List;

import com.ecoit.qa.service.model.GroupUserUser;
import com.ecoit.qa.service.service.GroupUserPermissionLocalServiceUtil;
import com.ecoit.qa.service.service.GroupUserUserLocalServiceUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class QuestionPermissionUtil {
	public static boolean checkPermissionAccessZone(long userId, int permission) {
		boolean isPermitted = false;
		try {
			List<GroupUserUser> groupUserUsersList = GroupUserUserLocalServiceUtil.searchByUserId(userId);
			User user = UserLocalServiceUtil.getUser(userId);
			List<Role> rolesList = user.getRoles();
			for (Role role : rolesList) {
                if (role.getName().equals("Administrator")) {
                	return true;
                }
			}
			for (GroupUserUser groupUserUser : groupUserUsersList) {
				if (GroupUserPermissionLocalServiceUtil.checkPermission(groupUserUser.getGroupUserId(), permission)) {
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
