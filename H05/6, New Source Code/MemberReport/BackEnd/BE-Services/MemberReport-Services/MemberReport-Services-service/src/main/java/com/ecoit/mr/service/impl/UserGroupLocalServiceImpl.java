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

package com.ecoit.mr.service.impl;

import com.ecoit.mr.model.UserGroup;
import com.ecoit.mr.service.base.UserGroupLocalServiceBaseImpl;
import com.ecoit.mr.service.persistence.UserGroupPK;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the user group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.mr.service.UserGroupLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.mr.model.UserGroup",
	service = AopService.class
)
public class UserGroupLocalServiceImpl extends UserGroupLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.mr.service.UserGroupLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.mr.service.UserGroupLocalServiceUtil</code>.
	 */
	public List<UserGroup> getByUserId(long userId) {
		return userGroupPersistence.findByUser(userId);
	}
	public void createUserGroup(long userGroupId, long userId) {
		UserGroupPK primaryKey = new UserGroupPK(userId, userGroupId);
		UserGroup groupUserUser = userGroupPersistence.create(primaryKey);
		userGroupPersistence.update(groupUserUser);
	}
	public boolean isContain(long groupUserId, long userId) {
		try {
			UserGroup ugRel = userGroupPersistence.findByPrimaryKey(new UserGroupPK(userId, groupUserId));
			if (ugRel == null)
				return false;
			else
				return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public int countMemberInGroup( long userId,long userpermissiongroupid, String name) throws Exception {
		Session session = null;
		try {
			session = this.userGroupPersistence.openSession();
			String sql = "select count(userid) from ecoit_mr_usergroup where userpermissiongroupid=" + userpermissiongroupid;

//		
//			if (!name.isEmpty())
//				sql += " and  LOWER(groupName) like '%" + name + "%' ";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			return Integer.parseInt(query.list().get(0).toString());
		} finally {
			this.userGroupPersistence.closeSession(session);
		}

	}
	
}