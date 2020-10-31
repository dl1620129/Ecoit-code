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

import com.ecoit.mr.model.PermissionGroup;
import com.ecoit.mr.model.UserPermissionGroup;
import com.ecoit.mr.model.impl.PermissionGroupImpl;
import com.ecoit.mr.model.impl.UserPermissionGroupImpl;
import com.ecoit.mr.service.PermissionGroupLocalServiceUtil;
import com.ecoit.mr.service.UserGroupLocalServiceUtil;
import com.ecoit.mr.service.base.UserPermissionGroupLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the user permission group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.mr.service.UserPermissionGroupLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPermissionGroupLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.mr.model.UserPermissionGroup",
	service = AopService.class
)
public class UserPermissionGroupLocalServiceImpl
	extends UserPermissionGroupLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.mr.service.UserPermissionGroupLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.mr.service.UserPermissionGroupLocalServiceUtil</code>.
	 */
	public List<UserPermissionGroup> getList( long groupId, String name, int start, int limit)
			throws Exception {
		Session session = null;
		
		try {
			session = this.userPermissionGroupPersistence.openSession();
			String sql = "select * from ecoit_mr_userpermissiongroup where groupId=" + groupId + " ";

		
			if (!name.isEmpty())
				sql += " and LOWER(groupName) like LOWER('%" + name + "%') ";

			sql += " order by userpermissiongroupid asc  ";
			
			if (start != -1 && limit != -1) {
				sql += "offset " + start + " limit " + limit + "";
			}
			System.out.println(sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_mr_userpermissiongroup", UserPermissionGroupImpl.class);
			System.out.println(query.list());
			return query.list();
		} finally {
			this.userPermissionGroupPersistence.closeSession(session);
		}

	}
	public int getTotal( long groupId, String name) throws Exception {
		Session session = null;
		try {
			session = this.userPermissionGroupPersistence.openSession();
			String sql = "select count(*) from ecoit_mr_userpermissiongroup where groupId=" + groupId;

		
			if (!name.isEmpty())
				sql += " and LOWER(groupname) like LOWER('%" + name + "%') ";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			return Integer.parseInt(query.list().get(0).toString());
		} finally {
			this.userPermissionGroupPersistence.closeSession(session);
		}

	}
	public void createUpdateGroupUser(long userId, long groupId, long groupUserId, String groupName, String description, String[] users,
			String[] permissions) throws Exception {
		UserPermissionGroup group = null;
		Date now = new Date();
		if (groupUserId < 1) {
			groupUserId = counterLocalService.increment();
			group = userPermissionGroupPersistence.create(groupUserId);
			group.setCreateDate(now);
		} else {
			group = userPermissionGroupPersistence.fetchByPrimaryKey(groupUserId);
		}
		group.setGroupName(groupName);
		group.setDescription(description);
		group.setGroupId(groupId);
		group.setModifiedDate(now);
		userPermissionGroupPersistence.update(group);
		
		//add user to group user
		userGroupPersistence.removeByGroup(groupUserId);
		for (String user : users) {
			UserGroupLocalServiceUtil.createUserGroup(groupUserId, Long.parseLong(user));
		}
		
		permissionGroupPersistence.removeByGroup(groupUserId);
		for (String permission: permissions) {
			PermissionGroupLocalServiceUtil.createPermissionGroupRel(groupUserId, Integer.parseInt(permission));
		}
	}
}