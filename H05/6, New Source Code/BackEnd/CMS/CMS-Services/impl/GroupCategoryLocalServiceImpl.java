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
import com.software.cms.model.GroupCategory;
import com.software.cms.model.PermissionGroup;
import com.software.cms.model.impl.GroupCategoryImpl;
import com.software.cms.service.GroupCategoryLocalServiceUtil;
import com.software.cms.service.base.GroupCategoryLocalServiceBaseImpl;
import com.software.cms.service.persistence.GroupCategoryPK;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the group category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.software.cms.service.GroupCategoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see GroupCategoryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.software.cms.model.GroupCategory",
	service = AopService.class
)
public class GroupCategoryLocalServiceImpl
	extends GroupCategoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.software.cms.service.GroupCategoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.software.cms.service.GroupCategoryLocalServiceUtil</code>.
	 */
	public void addGroupCategory(long groupUserId, long categoryId) {
		GroupCategoryPK primKey = new GroupCategoryPK(groupUserId, categoryId);
		GroupCategory groupCategory = GroupCategoryLocalServiceUtil.createGroupCategory(primKey);
		try {
			this.groupCategoryLocalService.addGroupCategory(groupCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeByGroupUserId(long groupUserId) {
		try {
			this.groupCategoryPersistence.removeByGroupUser(groupUserId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeByCategoryId(long categoryId) {
		try {
			this.groupCategoryPersistence.removeByCategory(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasGroupCategory(long groupUserId, long categoryId) {
		boolean result=false;
		Session session=null;
		try {
			session = this.groupCategoryPersistence.openSession();
			String sql = "select * from soft_cms_groupcategory where categoryid = ? AND groupuserid=?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_groupcategory", GroupCategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(categoryId);
			qPos.add(groupUserId);
			List<PermissionGroup> users = query.list();
			
			if (users != null && users.size()>0) result= true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		finally{
			this.groupCategoryPersistence.closeSession(session);
		}
		return result;
	}

	public boolean hasUserAccessCategory(long userId, long categoryId) {
		boolean result=false;
		Session session=null;
		try {
			session = this.groupCategoryPersistence.openSession();
			String sql = "select soft_cms_groupcategory.* "+
					" FROM soft_cms_groupcategory INNER JOIN soft_cms_groupuserusers ON soft_cms_groupcategory.groupuserid = soft_cms_groupuserusers.groupuserid "+
					" WHERE soft_cms_groupuserusers.userid = ? AND soft_cms_groupcategory.categoryid = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_groupcategory", GroupCategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(categoryId);
			List<GroupCategory> gcs = query.list();
			
			if (gcs != null && gcs.size()>0) result= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.groupCategoryPersistence.closeSession(session);
		}
		return result;
	}
	public List<GroupCategory> getByUserIdAndGroupId(long userId, long groupId) {
		List<GroupCategory> result=new ArrayList<GroupCategory>();
		Session session=null;
		try {
			session = this.groupCategoryPersistence.openSession();
			String sql = "select soft_cms_groupcategory.* "+
					" FROM soft_cms_groupcategory INNER JOIN soft_cms_groupuserusers ON soft_cms_groupcategory.groupuserid = soft_cms_groupuserusers.groupuserid "+
					" WHERE soft_cms_groupuserusers.userid = ? AND soft_cms_groupuserusers.groupid = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_groupcategory", GroupCategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(groupId);
			result = query.list();
		} catch (Exception e) {
			result=new ArrayList<GroupCategory>();
		}
		finally{
			this.groupCategoryPersistence.closeSession(session);
		}
		return result;
	}
	public List<GroupCategory> getByUserIdAndGroupIdAndGroupUserId(long userId, long groupId,long groupUserId) {
		List<GroupCategory> result=new ArrayList<GroupCategory>();
		Session session=null;
		try {
			session = this.groupCategoryPersistence.openSession();
			String sql = "select distinct soft_cms_groupcategory.* "+
					" FROM soft_cms_groupcategory INNER JOIN soft_cms_groupuserusers ON soft_cms_groupcategory.groupuserid = soft_cms_groupuserusers.groupuserid "+
					" WHERE soft_cms_groupuserusers.groupid = ? AND soft_cms_groupcategory.groupuserid = ?";
			        //" WHERE soft_cms_groupuserusers.userid = ? AND soft_cms_groupuserusers.groupid = ? AND soft_cms_groupcategory.groupuserid = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_groupcategory", GroupCategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			//qPos.add(userId);
			qPos.add(groupId);
			qPos.add(groupUserId);
			result = query.list();
		} catch (Exception e) {
			result=new ArrayList<GroupCategory>();
		}
		finally{
			this.groupCategoryPersistence.closeSession(session);
		}
		return result;
	}
	public List<GroupCategory> getByCategory(long categoryId) {
		List<GroupCategory> result=new ArrayList<GroupCategory>();
		Session session=null;
		try {
			session = this.groupCategoryPersistence.openSession();
			String sql = "select * from soft_cms_groupcategory where categoryid="+categoryId;
					
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_groupcategory", GroupCategoryImpl.class);
			result = query.list();
		} catch (Exception e) {
			result=new ArrayList<GroupCategory>();
		}
		finally{
			this.groupCategoryPersistence.closeSession(session);
		}
		return result;
	}
	public GroupCategory create(){
		return new GroupCategoryImpl();
	}
}