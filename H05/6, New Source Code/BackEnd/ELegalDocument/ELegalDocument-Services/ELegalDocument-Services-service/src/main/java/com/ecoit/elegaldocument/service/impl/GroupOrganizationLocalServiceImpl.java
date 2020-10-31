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

package com.ecoit.elegaldocument.service.impl;

import com.ecoit.elegaldocument.model.EcmsGURelation;
import com.ecoit.elegaldocument.model.GroupOrganization;
import com.ecoit.elegaldocument.model.impl.GroupOrganizationImpl;
import com.ecoit.elegaldocument.service.GroupOrganizationLocalServiceUtil;
import com.ecoit.elegaldocument.service.base.GroupOrganizationLocalServiceBaseImpl;
import com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the group organization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ecoit.elegaldocument.service.GroupOrganizationLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see GroupOrganizationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.ecoit.elegaldocument.model.GroupOrganization", service = AopService.class)
public class GroupOrganizationLocalServiceImpl extends GroupOrganizationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ecoit.elegaldocument.service.GroupOrganizationLocalService</code>
	 * via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ecoit.elegaldocument.service.GroupOrganizationLocalServiceUtil</
	 * code>.
	 */

	public void addGroupOrganization(long groupUserId, long OrganizationId) {
		GroupOrganizationPK primKey = new GroupOrganizationPK(groupUserId, OrganizationId);
		GroupOrganization groupOrganization = GroupOrganizationLocalServiceUtil.createGroupOrganization(primKey);
		try {
			this.groupOrganizationLocalService.addGroupOrganization(groupOrganization);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeByGroupUserId(long groupUserId) {
		try {
			this.groupOrganizationPersistence.removeByGroupUser(groupUserId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeByOrganizationId(long OrganizationId) {
		try {
			this.groupOrganizationPersistence.removeByOrganization(OrganizationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasGroupOrganization(long groupUserId, long OrganizationId) {
		boolean result = false;
		Session session = null;
		try {
			session = this.groupOrganizationPersistence.openSession();
			String sql = "select * from ecoit_doc_groupOrganization where organizationid = ? AND groupuserid=?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_groupOrganization", GroupOrganizationImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(OrganizationId);
			qPos.add(groupUserId);
			List<EcmsGURelation> users = query.list();

			if (users != null && users.size() > 0)
				result = true;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			this.groupOrganizationPersistence.closeSession(session);
		}
		return result;
	}

	public boolean hasUserAccessOrganization(long userId, long OrganizationId) {
		boolean result = false;
		Session session = null;
		try {
			session = this.groupOrganizationPersistence.openSession();
			String sql = "select ecoit_doc_groupOrganization.* "
					+ " FROM ecoit_doc_groupOrganization INNER JOIN ecoit_doc_ecmsgurelation ON ecoit_doc_groupOrganization.groupuserid = ecoit_doc_ecmsgurelation.groupuserid "
					+ " WHERE ecoit_doc_ecmsgurelation.userid = ? AND ecoit_doc_groupOrganization.organizationid = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_groupOrganization", GroupOrganizationImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(OrganizationId);
			List<GroupOrganization> gcs = query.list();

			if (gcs != null && gcs.size() > 0)
				result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.groupOrganizationPersistence.closeSession(session);
		}
		return result;
	}

	public List<GroupOrganization> getByUserIdAndGroupId(long userId, long groupId) {
		List<GroupOrganization> result = new ArrayList<GroupOrganization>();
		Session session = null;
		try {
			session = this.groupOrganizationPersistence.openSession();
			String sql = "select ecoit_doc_groupOrganization.* "
					+ " FROM ecoit_doc_groupOrganization INNER JOIN ecoit_doc_ecmsgurelation ON ecoit_doc_groupOrganization.groupuserid = ecoit_doc_ecmsgurelation.groupuserid "
					+ " WHERE ecoit_doc_ecmsgurelation.userid = ? "; // AND ecoit_doc_ecmsgurelation.groupuserid = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_groupOrganization", GroupOrganizationImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			// qPos.add(groupId);
			result = query.list();
		} catch (Exception e) {
			result = new ArrayList<GroupOrganization>();
		} finally {
			this.groupOrganizationPersistence.closeSession(session);
		}
		return result;
	}

	public List<GroupOrganization> getByUserIdAndGroupIdAndGroupUserId(long userId, long groupId, long groupUserId) {
		List<GroupOrganization> result = new ArrayList<GroupOrganization>();
		Session session = null;
		try {
			session = this.groupOrganizationPersistence.openSession();
			String sql = "select distinct ecoit_doc_groupOrganization.* "
					+ " FROM ecoit_doc_groupOrganization INNER JOIN ecoit_doc_ecmspgrelation ON ecoit_doc_groupOrganization.groupuserid = ecoit_doc_ecmspgrelation.groupuserid "
					+ " WHERE ecoit_doc_groupOrganization.groupuserid = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_groupOrganization", GroupOrganizationImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			// qPos.add(userId);
			// qPos.add(groupId);
			qPos.add(groupUserId);
			result = query.list();
		} catch (Exception e) {
			result = new ArrayList<GroupOrganization>();
		} finally {
			this.groupOrganizationPersistence.closeSession(session);
		}
		return result;
	}

	public List<GroupOrganization> getByOrganization(long OrganizationId) {
		List<GroupOrganization> result = new ArrayList<GroupOrganization>();
		Session session = null;
		try {
			session = this.groupOrganizationPersistence.openSession();
			String sql = "select * from ecoit_doc_groupOrganization where organizationid=" + OrganizationId;

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_groupOrganization", GroupOrganizationImpl.class);
			result = query.list();
		} catch (Exception e) {
			result = new ArrayList<GroupOrganization>();
		} finally {
			this.groupOrganizationPersistence.closeSession(session);
		}
		return result;
	}
}