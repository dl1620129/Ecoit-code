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

package LinkManager.Service.service.impl;

import LinkManager.Service.model.Category;
import LinkManager.Service.model.Clip;
import LinkManager.Service.model.impl.CategoryImpl;
import LinkManager.Service.model.impl.ClipImpl;
import LinkManager.Service.service.base.CategoryLocalServiceBaseImpl;

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
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>LinkManager.Service.service.CategoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=LinkManager.Service.model.Category",
	service = AopService.class
)
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>LinkManager.Service.service.CategoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>LinkManager.Service.service.CategoryLocalServiceUtil</code>.
	 */
	public List<Category> getListCategory(String name, long groupId,int start, int limit) throws Exception{
		List<Category> listCategory= new ArrayList<Category>();
		Session session= null;
		try {
			session= this.categoryPersistence.openSession();
			String sql = "select * from portal_category where groupid=" + groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(title) LIKE LOWER('%" + name + "%') ";
			}
			sql+="ORDER BY id_ DESC  ";
			if (start >-1 && limit > 0) {
				sql += " offset " + start + " limit " + limit + "";
			}

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_category", CategoryImpl.class);
			listCategory = query.list();

		} finally {
			this.clipPersistence.closeSession(session);
		}
		return listCategory;
	}
	public int getCountbyCategory(String name, long groupId) throws Exception{
		int total=-1;
		Session session=null;
		try {
			session= this.clipPersistence.openSession();
			String sql = "select COUNT(*) from portal_category where groupid=" + groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(title) LIKE LOWER('%" + name + "%') ";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			if(query.list().size()>0) {
				total = Integer.parseInt(query.list().get(0).toString());
			}
		} finally {
			this.clipPersistence.closeSession(session);
		}
		
		return total;
	}
	public  String getTitle(long groupId, long categoryId) throws Exception {
		String title="";
		Session session=null;
		try {
			session= this.clipPersistence.openSession();
			String sql = "select t.title from portal_category t where groupid=" + groupId+" and id_ =" +categoryId;
			
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
		
			title = query.list().toString();
			
		} finally {
			this.clipPersistence.closeSession(session);
		}
		return title;
	}
	public  List<Category> getTitleCate(long groupId, long categoryId) throws Exception {
		List<Category> listTitle= new ArrayList<Category>();
		Session session=null;
		try {
			session= this.clipPersistence.openSession();
			String sql = "select * from portal_category t where t.groupid=" + groupId+" and t.id_ =" +categoryId;
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
		
			query.addEntity("portal_category", CategoryImpl.class);
			listTitle = query.list();
			
		} finally {
			this.clipPersistence.closeSession(session);
		}
		return listTitle;
	}
	
}