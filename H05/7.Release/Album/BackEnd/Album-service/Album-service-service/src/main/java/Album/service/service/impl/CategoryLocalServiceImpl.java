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

package Album.service.service.impl;

import Album.service.model.Category;
import Album.service.model.impl.CategoryImpl;
import Album.service.service.base.CategoryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>Album.service.service.CategoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=Album.service.model.Category",
	service = AopService.class
)
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>Album.service.service.CategoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>Album.service.service.CategoryLocalServiceUtil</code>.
	 */
public List<Category> getListCategory(String name, int start, int limit, long groupId) throws Exception{
	
		List<Category> listCategory= new ArrayList<Category>();
		Session session = null;
		session = this.categoryPersistence.openSession();
		try {	
			String sql = "select * from portal_album_category where groupid=" + groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(name) LIKE LOWER('%" + name + "%') ";
			}
			sql+=" ORDER BY thutu ASC  ";
			if (start >-1 && limit >0) {
				sql += " offset " + start + " limit " + limit + "";
			}
		
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_album_category", CategoryImpl.class);
			
			listCategory = query.list();
		}finally {
			this.categoryPersistence.closeSession(session);
		}
		return listCategory;
	}
public List<Category> getListDetail(String name,long id, int start, int limit, long groupId) throws Exception{
	
	List<Category> listCategory= new ArrayList<Category>();
	Session session = null;
	session = this.categoryPersistence.openSession();
	try {	
		String sql = "select * from portal_album_category where categoryid not in("+id+") and  groupid=" + groupId;
		if (!name.isEmpty()) {
			sql += " AND LOWER(name) LIKE LOWER('%" + name + "%') ";
		}
		sql+=" ORDER BY thutu ASC  ";
		if (start >-1 && limit >0) {
			sql += " offset " + start + " limit " + limit + "";
		}
	
		SQLQuery query= session.createSQLQuery(sql);
		query.setCacheable(false);
		query.addEntity("portal_album_category", CategoryImpl.class);
		
		listCategory = query.list();
	}finally {
		this.categoryPersistence.closeSession(session);
	}
	return listCategory;
}
	public int getCountAll(String name,long groupId) throws Exception  {
		int total=-1;
		Session session= null;
		
		try {
	
			
			session= this.categoryPersistence.openSession();
			String sql="select COUNT(*) from portal_album_category where groupid= "+groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(name) LIKE LOWER('%" + name + "%') ";
			}
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			if(query.list().size()>0) {
				total= Integer.parseInt(query.list().get(0).toString());
			}
			return total;
		} finally {
			this.categoryPersistence.closeSession(session);
		} 
	}
}