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

package com.software.cms.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.software.cms.model.GroupUserUsers;
import com.software.cms.model.impl.GroupUserUsersImpl;
import com.software.cms.service.GroupUserUsersLocalServiceUtil;
import com.software.cms.service.base.GroupUserUsersLocalServiceBaseImpl;
import com.software.cms.service.persistence.GroupUserUsersPK;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the group user users local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.software.cms.service.GroupUserUsersLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see GroupUserUsersLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.software.cms.model.GroupUserUsers",
	service = AopService.class
)
public class GroupUserUsersLocalServiceImpl
	extends GroupUserUsersLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.software.cms.service.GroupUserUsersLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.software.cms.service.GroupUserUsersLocalServiceUtil</code>.
	 */
	public void addGroupUserUsers(long groupId, long groupUserId, long userId) {
		GroupUserUsersPK primKey = new GroupUserUsersPK(groupUserId, userId);
		GroupUserUsers groupUserUsers = this.groupUserUsersPersistence.create(primKey);
		groupUserUsers.setGroupId(groupId);
		try {
			GroupUserUsersLocalServiceUtil.addGroupUserUsers(groupUserUsers);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @param groupId
	 * @param groupUserId
	 * @return
	 */
	public List<GroupUserUsers> findByGroup_GroupUser(long groupId, long groupUserId) {
		List<GroupUserUsers> result = new ArrayList<GroupUserUsers>();
		try {
			result.addAll(this.groupUserUsersPersistence.findByGroup_GroupUser(groupId, groupUserId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *
	 * @param groupId
	 * @param groupUserId
	 */
	public void removeByGroup_GroupUser(long groupId, long groupUserId) {
		try {
			this.groupUserUsersPersistence.removeByGroup_GroupUser(groupId, groupUserId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasGroupUserUsers(long groupUserId, long userId) {
		boolean result=false;
		Session session=null;
		try {
			session = this.groupUserUsersPersistence.openSession();
			String sql = "select * from soft_cms_groupuserusers where groupuserid = ? AND userid=?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_groupuserusers", GroupUserUsersImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupUserId);
			qPos.add(userId);
			List<GroupUserUsers> users = query.list();
			if (users != null && users.size()>0) result= true;
		} catch (Exception e) {
		}
        finally{
        	this.groupUserUsersPersistence.closeSession(session);
        }
		return result;
	}

	public List<GroupUserUsers> findByUser_Group(long userId, long groupId) {
		List<GroupUserUsers> result = new ArrayList<GroupUserUsers>();
		try {
			result.addAll(this.groupUserUsersPersistence.findByGroup_User(groupId, userId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public GroupUserUsers create(){
		return new GroupUserUsersImpl();
	}
}