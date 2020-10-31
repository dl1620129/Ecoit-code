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

package com.ecoit.qa.service.service.impl;

import com.ecoit.qa.service.model.GroupUserUser;
import com.ecoit.qa.service.service.base.GroupUserUserLocalServiceBaseImpl;
import com.ecoit.qa.service.service.persistence.GroupUserUserPK;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the group user user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.qa.service.service.GroupUserUserLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserUserLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.qa.service.model.GroupUserUser",
	service = AopService.class
)
public class GroupUserUserLocalServiceImpl
	extends GroupUserUserLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.qa.service.service.GroupUserUserLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.qa.service.service.GroupUserUserLocalServiceUtil</code>.
	 */
	
	public void createGroupUserUser(long groupUserId, long userId) throws Exception {
		GroupUserUserPK primaryKey = new GroupUserUserPK(groupUserId, userId);
		GroupUserUser groupUserUser = groupUserUserPersistence.create(primaryKey);
		groupUserUserPersistence.update(groupUserUser);
	}
	
	public int getUserCount(long groupUserId) throws Exception {
		return groupUserUserPersistence.countByGroupUser(groupUserId);
	}
	
	public List<GroupUserUser> searchByUserId(long userId) throws Exception {
		return groupUserUserPersistence.findByUser(userId);
	}
	
	public boolean hasUser(long groupUserId, long userId) {
		try {
			GroupUserUser relation = groupUserUserPersistence.fetchByPrimaryKey(new GroupUserUserPK(groupUserId, userId));
			if (relation == null) return false;
			else return true;
		} catch (Exception ex) {
			return false;
		}
	}
}