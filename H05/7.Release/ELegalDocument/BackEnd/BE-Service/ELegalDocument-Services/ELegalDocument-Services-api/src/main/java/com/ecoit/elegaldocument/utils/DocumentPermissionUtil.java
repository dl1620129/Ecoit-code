package com.ecoit.elegaldocument.utils;

import java.util.List;

import com.ecoit.elegaldocument.model.EcmsGURelation;
import com.ecoit.elegaldocument.model.EcmsGroup;
import com.ecoit.elegaldocument.service.EcmsGURelationServiceUtil;
import com.ecoit.elegaldocument.service.EcmsGroupLocalServiceUtil;
import com.ecoit.elegaldocument.service.EcmsPGRelationServiceUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class DocumentPermissionUtil {

	public static boolean checkPermissionAccessZone(long scopeGroupId, long userId, int permission) {
		boolean isPermitted = false;
		try {
			List<EcmsGURelation> ecmsGURelationsList = EcmsGURelationServiceUtil.searchByUserId(userId);
			User user = UserLocalServiceUtil.getUser(userId);
			List<Role> rolesList = user.getRoles();
			for (Role role : rolesList) {
                if (role.getName().equals("Administrator")) {
                	return true;
                }
			}
			for (EcmsGURelation guRelation : ecmsGURelationsList) {
				EcmsGroup group = EcmsGroupLocalServiceUtil.fetchEcmsGroup(guRelation.getGroupUserId());
				if (EcmsPGRelationServiceUtil.checkPermission(guRelation.getGroupUserId(), permission) && group.getGroupId() == scopeGroupId) {
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
