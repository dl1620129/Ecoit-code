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
import com.ecoit.elegaldocument.model.GroupField;
import com.ecoit.elegaldocument.model.impl.GroupFieldImpl;
import com.ecoit.elegaldocument.service.GroupFieldLocalServiceUtil;
import com.ecoit.elegaldocument.service.base.GroupFieldLocalServiceBaseImpl;
import com.ecoit.elegaldocument.service.persistence.GroupFieldPK;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the group field local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.GroupFieldLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see GroupFieldLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.elegaldocument.model.GroupField",
	service = AopService.class
)
public class GroupFieldLocalServiceImpl extends GroupFieldLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.elegaldocument.service.GroupFieldLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.elegaldocument.service.GroupFieldLocalServiceUtil</code>.
	 */
	public void addGroupField(long groupUserId, long FieldId) {
		GroupFieldPK primKey = new GroupFieldPK(groupUserId, FieldId);
		GroupField groupField = GroupFieldLocalServiceUtil.createGroupField(primKey);
		try {
			this.groupFieldLocalService.addGroupField(groupField);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeByGroupUserId(long groupUserId) {
		try {
			this.groupFieldPersistence.removeByGroupUser(groupUserId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeByFieldId(long FieldId) {
		try {
			this.groupFieldPersistence.removeByField(FieldId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasGroupField(long groupUserId, long FieldId) {
		boolean result=false;
		Session session=null;
		try {
			session = this.groupFieldPersistence.openSession();
			String sql = "select * from ecoit_doc_groupField where fieldid = ? AND groupuserid=?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_groupField", GroupFieldImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(FieldId);
			qPos.add(groupUserId);
			List<EcmsGURelation> users = query.list();
			
			if (users != null && users.size()>0) result= true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		finally{
			this.groupFieldPersistence.closeSession(session);
		}
		return result;
	}

	public boolean hasUserAccessField(long userId, long FieldId) {
		boolean result=false;
		Session session=null;
		try {
			session = this.groupFieldPersistence.openSession();
			String sql = "select ecoit_doc_groupField.* "+
					" FROM ecoit_doc_groupField INNER JOIN ecoit_doc_ecmsgurelation ON ecoit_doc_groupField.groupuserid = ecoit_doc_ecmsgurelation.groupuserid "+
					" WHERE ecoit_doc_ecmsgurelation.userid = ? AND ecoit_doc_groupField.fieldid = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_groupField", GroupFieldImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(FieldId);
			List<GroupField> gcs = query.list();
			
			if (gcs != null && gcs.size()>0) result= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.groupFieldPersistence.closeSession(session);
		}
		return result;
	}
	public List<GroupField> getByUserIdAndGroupId(long userId, long groupId) {
		List<GroupField> result=new ArrayList<GroupField>();
		Session session=null;
		try {
			session = this.groupFieldPersistence.openSession();
			String sql = "select ecoit_doc_groupField.* "+
					" FROM ecoit_doc_groupField INNER JOIN ecoit_doc_ecmsgurelation ON ecoit_doc_groupField.groupuserid = ecoit_doc_ecmsgurelation.groupuserid "+
					" WHERE ecoit_doc_ecmsgurelation.userid = ? ";//AND ecoit_doc_ecmsgurelation.groupuserid = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_groupField", GroupFieldImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			//qPos.add(groupId);
			result = query.list();
		} catch (Exception e) {
			result=new ArrayList<GroupField>();
		}
		finally{
			this.groupFieldPersistence.closeSession(session);
		}
		return result;
	}
	public List<GroupField> getByUserIdAndGroupIdAndGroupUserId(long userId, long groupId,long groupUserId) {
		List<GroupField> result=new ArrayList<GroupField>();
		Session session=null;
		try {
			session = this.groupFieldPersistence.openSession();
			String sql = "select distinct ecoit_doc_groupField.* "+
					" FROM ecoit_doc_groupField INNER JOIN ecoit_doc_ecmspgrelation ON ecoit_doc_groupField.groupuserid = ecoit_doc_ecmspgrelation.groupuserid "+
					" WHERE ecoit_doc_groupField.groupuserid = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_groupField", GroupFieldImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			//qPos.add(userId);
			//qPos.add(groupId);
			qPos.add(groupUserId);
			result = query.list();
		} catch (Exception e) {
			result=new ArrayList<GroupField>();
		}
		finally{
			this.groupFieldPersistence.closeSession(session);
		}
		return result;
	}
	public List<GroupField> getByField(long FieldId) {
		List<GroupField> result=new ArrayList<GroupField>();
		Session session=null;
		try {
			session = this.groupFieldPersistence.openSession();
			String sql = "select * from ecoit_doc_groupField where fieldid="+FieldId;
					
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_groupField", GroupFieldImpl.class);
			result = query.list();
		} catch (Exception e) {
			result=new ArrayList<GroupField>();
		}
		finally{
			this.groupFieldPersistence.closeSession(session);
		}
		return result;
	}
}