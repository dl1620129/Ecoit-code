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

import com.ecoit.qa.service.model.Category;
import com.ecoit.qa.service.model.impl.CategoryImpl;
import com.ecoit.qa.service.service.base.CategoryLocalServiceBaseImpl;

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
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.qa.service.service.CategoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.qa.service.model.Category",
	service = AopService.class
)
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.qa.service.service.CategoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.qa.service.service.CategoryLocalServiceUtil</code>.
	 */
	
	public List<Category> getNode(long parentId, long groupId, int start, int limit, String searchKey) throws Exception {
		List<Category> categoriesList = new ArrayList<>();
		Session session = null;
		try {
			session = categoryPersistence.openSession();
			String sql = "SELECT * FROM ecoit_qa_category WHERE parentid = :parentId AND lower(name) LIKE lower(:searchKey) ";
			
			if (groupId > 0) {
				sql += "AND groupid = :groupId ";
			}

		    sql += "ORDER BY position ASC OFFSET :start";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_qa_category", CategoryImpl.class);
			if (groupId > 0) {
				query.setLong("groupId", groupId);
			}

			query.setLong("parentId", parentId);
			query.setInteger("start", start);
			query.setString("searchKey", "%" + searchKey + "%");
			if (limit > 0) {
				query.setMaxResults(limit);
			}
			
			QueryPos.getInstance(query);
			categoriesList = query.list();
			
			return categoriesList;
		} finally {
			categoryPersistence.closeSession(session);
		}
	}
	
	public int getNodeCount(long parentId, long groupId, String searchKey) throws Exception {
		int count = 0;
		Session session = null;
		try {
			session = categoryPersistence.openSession();
			String sql = "SELECT count(*) FROM ecoit_qa_category WHERE parentid = :parentId AND groupid = :groupId AND lower(name) LIKE lower(:searchKey)";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.setLong("groupId", groupId);
			query.setLong("parentId", parentId);
			query.setString("searchKey", "%" + searchKey + "%");

			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} finally {
			categoryPersistence.closeSession(session);
		}
		return count;
	}
	
	public int getMax(long groupId, long parentId, long companyId) {
		Session session = null;
		int max = 0;
		try {
			session = this.categoryPersistence.openSession();

			String sqlCountMax = "select count(*) from ecoit_qa_category where parentid = :parentId AND companyid = :companyId AND groupid = :groupId";
			SQLQuery queryCountMax = session.createSQLQuery(sqlCountMax);
			queryCountMax.setLong("parentId", parentId);
			queryCountMax.setLong("companyId", companyId);
			queryCountMax.setLong("groupId", groupId);
			queryCountMax.setCacheable(false);
			QueryPos.getInstance(queryCountMax);
			if (queryCountMax.list().size() > 0)
				max = Integer.parseInt(queryCountMax.list().get(0).toString());

			return max;
		} catch (Exception e) {
			max = -1;
		} finally {
			this.categoryPersistence.closeSession(session);
		}
		return max;
	}
	
	public void createUpdateCategory(long categoryId, long groupId, long companyId, long userId, String name, String description, 
			int position, long parentId) throws Exception {
		Category category = null;
		Date now = new Date();
		if (categoryId < 1) {
			categoryId = counterLocalService.increment();
			category = categoryPersistence.create(categoryId);
			category.setCreateDate(now);
			category.setCreatedByUser(userId);
		} else {
			category = categoryPersistence.findByPrimaryKey(categoryId);	
		}
		
		category.setGroupId(groupId);
		category.setCompanyId(companyId);
		category.setName(name);
		category.setDescription(description);
		category.setPosition(position);
		category.setParentId(parentId);
		category.setModifiedDate(now);
		category.setModifiedByUser(userId);
		categoryPersistence.update(category);
	}
	
	public List<Category> findAll() {
		return categoryPersistence.findAll();
	}
}