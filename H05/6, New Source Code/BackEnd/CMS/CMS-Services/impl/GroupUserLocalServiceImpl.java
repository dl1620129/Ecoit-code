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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.persistence.UserUtil;
import com.software.cms.model.GroupUser;
import com.software.cms.model.GroupUserUsers;
import com.software.cms.model.impl.GroupUserImpl;
import com.software.cms.model.impl.GroupUserUsersImpl;
import com.software.cms.service.base.GroupUserLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the group user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.software.cms.service.GroupUserLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see GroupUserLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.software.cms.model.GroupUser", service = AopService.class)
public class GroupUserLocalServiceImpl extends GroupUserLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.software.cms.service.GroupUserLocalService</code> via injection or
	 * a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.software.cms.service.GroupUserLocalServiceUtil</code>.
	 */
	public GroupUser addGroupUser(String name, String description, ServiceContext serviceContext) {
		long groupId = serviceContext.getScopeGroupId();
		String languageId = serviceContext.getLanguageId();
		long groupUserId = counterLocalService.increment();
		GroupUser groupUser = groupUserPersistence.create(groupUserId);
		groupUser.setName(name);
		groupUser.setGroupId(groupId);
		groupUser.setLanguage(languageId);
		groupUser.setDescription(description);
		groupUser.setExpandoBridgeAttributes(serviceContext);
		groupUser = groupUserPersistence.update(groupUser);
		return groupUser;

	}

	public List<GroupUser> findByGroup_Language(long groupId, String language) {
		List<GroupUser> groups = new ArrayList<GroupUser>();
		try {
			groups.addAll(this.groupUserPersistence.findByGroup_Language(groupId, language));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return groups;
	}

	public List<Object[]> getUserByNameGroup(String screenname, long groupId, String language) throws Exception {
		Session session = null;
		try {
			session = UserUtil.getPersistence().openSession();

			String sql = "select u.userid ,u.screenname from user_ u \n"
					+ "left join usergrouprole gu on gu.userid = u.userid \n"
					+ "where lower(u.screenname) like lower('%" + screenname + "%') and u.languageid ='" + language
					+ "' and gu.groupid = " + groupId + " group by u.userid offset 0 limit 10";

			SQLQuery query = session.createSQLQuery(sql.toString());

			return query.list();

		} finally {
			UserUtil.getPersistence().closeSession(session);
		}
	}

	public List<GroupUser> findByGroup_Language(long groupId, String language, int start, int end, String q)
			throws Exception {
		Session session = null;
		List<GroupUser> groupUsers = new ArrayList<GroupUser>();
		try {
			session = this.groupUserPersistence.openSession();

			String sql = "select * from soft_cms_groupuser where groupid = ? and language = ? ";
			if (!q.isEmpty()) {
				sql += " and lower(name) like '%" + q + "%' ";
			}

			sql += " order by groupuserid desc";

			if (start >= 0 && end > 0) {
				sql += " offset " + start + " limit " + end + "";
			}

			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			query.addEntity("soft_cms_groupuser", GroupUserImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			qPos.add(language);
			groupUsers = query.list();
			return groupUsers;
		} finally {
			this.groupUserPersistence.closeSession(session);
		}
	}

	public int countByGroup_Language(long groupId, String language, String q) {
		Session session = null;
		int count = 0;
		try {
			session = this.groupUserPersistence.openSession();

			String sql = "select count(*) from soft_cms_groupuser where groupid = ? and language = ? ";
			if (!q.isEmpty()) {
				sql += " and lower(name) like '%" + q + "%' ";
			}

			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			qPos.add(language);

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

	public int countMemberInGroup(long groupId, long groupUserId) {
		Session session = null;
		int count = 0;
		try {
			session = this.groupUserPersistence.openSession();
			String sql = "";
			if (groupId > 0 && groupUserId > 0) {
				sql = "select count(groupuserid) from soft_cms_groupuserusers where groupid = " + groupId
						+ " and groupuserid = " + groupUserId + " group by groupuserid ";
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
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

	public GroupUser create() {
		return new GroupUserImpl();
	}
}