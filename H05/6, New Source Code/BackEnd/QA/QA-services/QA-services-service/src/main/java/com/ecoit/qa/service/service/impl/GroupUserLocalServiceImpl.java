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

import com.ecoit.qa.service.model.GroupUser;
import com.ecoit.qa.service.model.impl.GroupUserImpl;
import com.ecoit.qa.service.service.GroupUserCategoryLocalServiceUtil;
import com.ecoit.qa.service.service.GroupUserPermissionLocalServiceUtil;
import com.ecoit.qa.service.service.GroupUserUserLocalServiceUtil;
import com.ecoit.qa.service.service.base.GroupUserLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the group user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.qa.service.service.GroupUserLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.qa.service.model.GroupUser",
	service = AopService.class
)
public class GroupUserLocalServiceImpl extends GroupUserLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.qa.service.service.GroupUserLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.qa.service.service.GroupUserLocalServiceUtil</code>.
	 */
	
	public void createUpdateGroupUser(long userId, long scopeGroupId, long groupUserId, String groupName, String description, String[] users,
			String[] permissions, String[] categories) throws Exception {
		GroupUser group = null;
		Date now = new Date();
		if (groupUserId < 1) {
			groupUserId = counterLocalService.increment();
			group = groupUserPersistence.create(groupUserId);
			group.setCreateDate(now);
			group.setCreatedByUser(userId);
		} else {
			group = groupUserPersistence.fetchByPrimaryKey(groupUserId);
		}
		group.setName(groupName);
		group.setDescription(description);
		group.setGroupId(scopeGroupId);
		group.setModifiedDate(now);
		group.setModifiedByUser(userId);
		groupUserPersistence.update(group);
		
		//add user to group user
		groupUserUserPersistence.removeByGroupUser(groupUserId);
		for (String user : users) {
			GroupUserUserLocalServiceUtil.createGroupUserUser(groupUserId, Long.parseLong(user));
		}
		
		groupUserPermissionPersistence.removeByGroupUser(groupUserId);
		for (String permission: permissions) {
			GroupUserPermissionLocalServiceUtil.createGroupUserPermission(groupUserId, Long.parseLong(permission));
		}
		
		groupUserCategoryPersistence.removeByGroupUser(groupUserId);
		for (String category: categories) {
			GroupUserCategoryLocalServiceUtil.createGroupUserCategory(groupUserId, Long.parseLong(category));
		}
	}
	
	public void removeGroupUser(long groupUserId) throws Exception {
		groupUserUserPersistence.removeByGroupUser(groupUserId);
		
		groupUserPermissionPersistence.removeByGroupUser(groupUserId);
		
		groupUserCategoryPersistence.removeByGroupUser(groupUserId);
		
		groupUserPersistence.remove(groupUserId);
	}
	
	public List<GroupUser> findBySearchKey(long scopeGroupId, int start, int end, String q) throws Exception {
		Session session = null;
		List<GroupUser> groupUsersList = new ArrayList<>();
		try {
			session = groupUserPersistence.openSession();
			String sql = "SELECT * FROM ecoit_qa_groupuser WHERE groupid = :groupId AND lower(name) LIKE lower(:searchKey) ORDER BY createdate OFFSET :start";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_qa_groupuser", GroupUserImpl.class);
			query.setLong("groupId", scopeGroupId);
			query.setString("searchKey", "%" + q + "%");
			query.setInteger("start", start);
			if (end > 0) {
				query.setMaxResults(end);
			}
			
			QueryPos.getInstance(query);
			groupUsersList = query.list();
			
			return groupUsersList;
		} finally {
			groupUserPersistence.closeSession(session);
		}
	}
	
	public int countTotalGroup(long groupId, String q) {
		Session session = null;
		int count = 0;
		try {
			session = this.groupUserPersistence.openSession();
			String sql = "SELECT count(*) FROM ecoit_qa_groupuser WHERE groupid = :groupId AND lower(name) like lower(:q)";
			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			query.setString("q", "%" + q + "%");
			query.setLong("groupId", groupId);
			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} catch (Exception e) {
			count = 0;
		} finally {
			this.groupUserPersistence.closeSession(session);
		}
		return count;
	}
	
	public List<Object> getListOfUser(long scopeGroupId) throws Exception {
		Session session = null;
		List<Object> groupUsersList = new ArrayList<>();
		try {
			session = groupUserPersistence.openSession();
			String sql = "SELECT CAST(A.userid AS varchar), A.screenname,A.firstname||' '||A.middlename||' '||A.lastname fullname FROM user_ A \n" + 
					"INNER JOIN users_orgs B ON A.userid = B.userid \n" + 
					"INNER JOIN organization_ C ON B.organizationid = C.organizationid\n" + 
					"WHERE (C.organizationid = (SELECT organcoreid FROM portal_organization WHERE groupid = :groupId AND parentid = 0) \n" + 
					"	OR parentorganizationid = (SELECT organcoreid FROM portal_organization WHERE groupid = :groupId AND parentid = 0))\n" + 
					"	AND A.status = 0 AND A.ldapserverid > 0\n" + 
					"ORDER BY A.screenname ASC";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.setLong("groupId", scopeGroupId);
			QueryPos.getInstance(query);
			groupUsersList = query.list();
			return groupUsersList;
		} finally {
			groupUserPersistence.closeSession(session);
		}
	}
}