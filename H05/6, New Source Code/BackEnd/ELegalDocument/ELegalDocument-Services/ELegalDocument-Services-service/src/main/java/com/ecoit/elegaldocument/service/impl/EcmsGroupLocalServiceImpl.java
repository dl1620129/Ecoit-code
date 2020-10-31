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

import com.ecoit.elegaldocument.model.EcmsGroup;
import com.ecoit.elegaldocument.model.impl.EcmsGroupImpl;
import com.ecoit.elegaldocument.service.EcmsGURelationServiceUtil;
import com.ecoit.elegaldocument.service.EcmsPGRelationServiceUtil;
import com.ecoit.elegaldocument.service.GroupCategoryLocalServiceUtil;
import com.ecoit.elegaldocument.service.GroupFieldLocalServiceUtil;
import com.ecoit.elegaldocument.service.GroupOrganizationLocalServiceUtil;
import com.ecoit.elegaldocument.service.base.EcmsGroupLocalServiceBaseImpl;

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
 * The implementation of the ecms group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.EcmsGroupLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see EcmsGroupLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.elegaldocument.model.EcmsGroup",
	service = AopService.class
)
public class EcmsGroupLocalServiceImpl extends EcmsGroupLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.elegaldocument.service.EcmsGroupLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.elegaldocument.service.EcmsGroupLocalServiceUtil</code>.
	 */
	
	public void createUpdateEcmsgroup(long scopeGroupId, long groupUserId, String groupName, String description, String[] users,
			String[] permissions, String[] categories, String[] organizations, String[] fields) throws Exception {
		EcmsGroup group = null;
		if (groupUserId < 1) {
			groupUserId = counterLocalService.increment();
			group = ecmsGroupPersistence.create(groupUserId);
			group.setCreatedDate(new Date());
		} else {
			group = ecmsGroupPersistence.findBygroupUserId(groupUserId);
		}
		group.setGroupName(groupName);
		group.setDescription(description);
		group.setGroupId(scopeGroupId);
		ecmsGroupPersistence.update(group);
		
		//add user to ecms group
		ecmsGURelationPersistence.removeBygroupUserId(groupUserId);
		for (String user : users) {
			EcmsGURelationServiceUtil.addGURelation(groupUserId, Long.parseLong(user));
		}
		
		ecmsPGRelationPersistence.removeBygroupUserId(groupUserId);
		for (String permission: permissions) {
			EcmsPGRelationServiceUtil.addPermission(groupUserId, Integer.parseInt(permission));
		}
		
		groupCategoryPersistence.removeByGroupUser(groupUserId);
		for (String category: categories) {
			GroupCategoryLocalServiceUtil.addGroupCategory(groupUserId, Long.parseLong(category));
		}
		
		groupOrganizationPersistence.removeByGroupUser(groupUserId);
		for (String organization: organizations) {
			GroupOrganizationLocalServiceUtil.addGroupOrganization(groupUserId, Long.parseLong(organization));
		}
		
		groupFieldPersistence.removeByGroupUser(groupUserId);
		for (String field: fields) {
			GroupFieldLocalServiceUtil.addGroupField(groupUserId, Long.parseLong(field));
		}
	}
	
	public void removeEcmsGroup(long groupUserId) throws Exception {
		ecmsGURelationPersistence.removeBygroupUserId(groupUserId);
		
		ecmsPGRelationPersistence.removeBygroupUserId(groupUserId);
		
		groupCategoryPersistence.removeByGroupUser(groupUserId);
		
		groupOrganizationPersistence.removeByGroupUser(groupUserId);
		
		groupFieldPersistence.removeByGroupUser(groupUserId);
		
		ecmsGroupPersistence.remove(groupUserId);
	}
	
	public List<EcmsGroup> findByGroupId(long groupId, int start, int end, String q) throws Exception {
		Session session = null;
		List<EcmsGroup> ecmsGroups = new ArrayList<>();
		try {
			session = ecmsGroupPersistence.openSession();
			
			String sql = "SELECT * from ecoit_doc_ecmsgroup WHERE groupid = :groupId AND lower(groupname) like lower(:q) "
					+ "ORDER BY createddate desc offset :start";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_ecmsgroup", EcmsGroupImpl.class);
			query.setLong("groupId", groupId);
			query.setString("q", "%" + q + "%");
			query.setInteger("start", start);
			if (end > 0) {
				query.setMaxResults(end);
			}
			
			QueryPos.getInstance(query);
			ecmsGroups = query.list();
			
			return ecmsGroups;
		}  finally {
			this.ecmsGroupPersistence.closeSession(session);
		}
	}
	
	public int countMemberInGroup(long groupUserId) {
		Session session = null;
		int count = 0;
		try {
			session = this.ecmsGroupPersistence.openSession();
			String sql = "SELECT count(*) FROM ecoit_doc_ecmsgurelation WHERE groupuserid = :groupUserId GROUP BY groupuserid";
			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			query.setLong("groupUserId", groupUserId);
			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} catch (Exception e) {
			count = 0;
		} finally {
			this.ecmsGroupPersistence.closeSession(session);
		}
		return count;
	}
	
	public int countTotalGroup(long groupId, String name) {
		Session session = null;
		int count = 0;
		try {
			session = this.ecmsGroupPersistence.openSession();
			String sql = "SELECT count(*) FROM ecoit_doc_ecmsgroup WHERE groupid = :groupId AND lower(groupname) like lower(:name)";
			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			query.setString("name", "%" + name + "%");
			query.setLong("groupId", groupId);
			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} catch (Exception e) {
			count = 0;
		} finally {
			this.ecmsGroupPersistence.closeSession(session);
		}
		return count;
	}
	
	public List<Object> getListOfUser(long scopeGroupId) throws Exception {
		Session session = null;
		List<Object> groupUsersList = new ArrayList<>();
		try {
			session = ecmsGroupPersistence.openSession();
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
			ecmsGroupPersistence.closeSession(session);
		}
	}
}