/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ecoit.lichcongtac.services.service.impl;

import com.ecoit.lichcongtac.services.model.UserGroupRel;
import com.ecoit.lichcongtac.services.service.base.UserGroupRelLocalServiceBaseImpl;
import com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPK;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the user group rel local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.lichcongtac.services.service.UserGroupRelLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupRelLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.lichcongtac.services.model.UserGroupRel",
	service = AopService.class
)
public class UserGroupRelLocalServiceImpl
	extends UserGroupRelLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.lichcongtac.services.service.UserGroupRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.lichcongtac.services.service.UserGroupRelLocalServiceUtil</code>.
	 */
	
	public List<UserGroupRel> getByUserId(long userId) {
		return userGroupRelPersistence.findByUser(userId);
	}
	
	public int countMemberInGroup(long userGroupId) {
		int count = 0;
		try {
			count = userGroupRelPersistence.findByGroup(userGroupId).size();
		} catch (Exception e){
			
		}
		return count;
	}
	
	public void createUserGroupRel(long userGroupId, long userId) {
		UserGroupRelPK primaryKey = new UserGroupRelPK(userId, userGroupId);
		UserGroupRel groupUserUser = userGroupRelPersistence.create(primaryKey);
		userGroupRelPersistence.update(groupUserUser);
	}
	
	public boolean isContain(long groupUserId, long userId) {
		try {
			UserGroupRel ugRel = userGroupRelPersistence.findByPrimaryKey(new UserGroupRelPK(userId, groupUserId));
			if (ugRel == null)
				return false;
			else
				return true;
		} catch (Exception ex) {
			return false;
		}
	}
}