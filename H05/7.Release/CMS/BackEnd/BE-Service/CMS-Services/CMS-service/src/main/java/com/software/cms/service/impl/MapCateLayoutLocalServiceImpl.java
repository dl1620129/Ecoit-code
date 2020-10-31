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
import com.software.cms.model.GroupUserUsers;
import com.software.cms.model.MapCateLayout;
import com.software.cms.model.impl.GroupUserUsersImpl;
import com.software.cms.model.impl.MapCateLayoutImpl;
import com.software.cms.service.base.MapCateLayoutLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the map cate layout local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.software.cms.service.MapCateLayoutLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see MapCateLayoutLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.software.cms.model.MapCateLayout", service = AopService.class)
public class MapCateLayoutLocalServiceImpl extends MapCateLayoutLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.software.cms.service.MapCateLayoutLocalService</code> via injection
	 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.software.cms.service.MapCateLayoutLocalServiceUtil</code>.
	 */
	public MapCateLayout getFriendsUrlByCategoryId(long categoryId) {
		try {
			return this.mapCateLayoutPersistence.findByCategoryId(categoryId);
		} catch (Exception e) {
		}

		return null;
	}

	public MapCateLayout getMapCateLayoutByCategoryIdAndType(long categoryId, int type) {
		try {
			return this.mapCateLayoutPersistence.findByCategoryIdAndType(categoryId, type);
		} catch (Exception e) {
		}

		return null;
	}

	public List<MapCateLayout> getListMapCateLayoutByType(long groupId, int type) {
		try {
			return this.mapCateLayoutPersistence.findByByType(groupId, type);
		} catch (Exception e) {
		}

		return null;
	}

	public MapCateLayout getCategoryIdByLayoutIdAndType(long layoutId, int type) {
		try {
			return this.mapCateLayoutPersistence.findByByLayoutIdAndType(layoutId, type);
		} catch (Exception e) {
		}

		return null;
	}

	public int checkExits(long categoryId, int type) {
		int count = 0;
		try {
			count = mapCateLayoutPersistence.findByCheckCategoryIdAndType(categoryId, type).size();
		} catch (Exception e) {
			count = 0;
		}
		return count;
	}

	public List<MapCateLayout> getListMapCateLayout(long groupId, long companyId, int start, int limit) throws Exception {
		Session session = null;
		try {
			session = this.mapCateLayoutPersistence.openSession();
			String sql = "select * from soft_cms_mapcatelayout where groupid = " + groupId + "";
			if (companyId > 0) {
				sql += " and companyid = " + companyId + "";
			}
			sql += " offset " + start + " limit " + limit + "";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_mapcatelayout", MapCateLayoutImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			return (List<MapCateLayout>) query.list();
		} finally {
			this.mapCateLayoutPersistence.closeSession(session);
		}
	}
	
	public int countMapCateLayout(long groupId, long companyId) throws Exception {
		Session session = null;
		int count = -1;
		try {
			session = this.mapCateLayoutPersistence.openSession();
			String sql = "select count(*) from soft_cms_mapcatelayout where groupid = " + groupId + "";
			if (companyId > 0) {
				sql += " and companyid = " + companyId + "";
			}

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(query);
			if(query.list().size()>0) {
				count = Integer.parseInt(query.list().get(0).toString());
			}
			return count;
		} finally {
			this.mapCateLayoutPersistence.closeSession(session);
		}
	}
	

	public MapCateLayout create() {
		return new MapCateLayoutImpl();
	}
}