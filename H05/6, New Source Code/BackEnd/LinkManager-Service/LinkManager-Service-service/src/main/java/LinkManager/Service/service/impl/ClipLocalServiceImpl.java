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

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import LinkManager.Service.model.Clip;
import LinkManager.Service.model.impl.ClipImpl;
import LinkManager.Service.service.base.ClipLocalServiceBaseImpl;

/**
 * The implementation of the clip local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>LinkManager.Service.service.ClipLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClipLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=LinkManager.Service.model.Clip",
	service = AopService.class
)
public class ClipLocalServiceImpl extends ClipLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>LinkManager.Service.service.ClipLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>LinkManager.Service.service.ClipLocalServiceUtil</code>.
	 */
	public List<Clip> getListClipDisplay(String name, long groupId,int start, int limit) throws Exception{
		List<Clip> listClip= new ArrayList<Clip>();
		Session session= null;
		try {
			session= this.clipPersistence.openSession();
			String sql = "select * from portal_clip where groupid=" + groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(title) LIKE LOWER('%" + name + "%') ";
			}
			sql+=" AND display=true ORDER BY id_ DESC  ";
			if (start >-1 && limit > 0) {
				sql += " offset " + start + " limit " + limit + "";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_clip", ClipImpl.class);
			listClip = query.list();

		} finally {
			this.clipPersistence.closeSession(session);
		}
		return listClip;
	}
	public List<Clip> getListClip(String name, long groupId,int start, int limit) throws Exception{
		List<Clip> listClip= new ArrayList<Clip>();
		Session session= null;
		try {
			session= this.clipPersistence.openSession();
			String sql = "select * from portal_clip where groupid=" + groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(title) LIKE LOWER('%" + name + "%') ";
			}
			sql+="   ORDER BY id_ DESC  ";
			if (start >-1 && limit > 0) {
				sql += " offset " + start + " limit " + limit + "";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_clip", ClipImpl.class);
			listClip = query.list();

		} finally {
			this.clipPersistence.closeSession(session);
		}
		return listClip;
	}
	public int getCount(String name, long groupId) throws Exception{
		int total=-1;
		Session session=null;
		try {
			session= this.clipPersistence.openSession();
			String sql = "select COUNT(*) from portal_clip where groupid=" + groupId;
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
	public int getCountDisplay(String name, long groupId) throws Exception{
		int total=-1;
		Session session=null;
		try {
			session= this.clipPersistence.openSession();
			String sql = "select COUNT(*) from portal_clip where groupid=" + groupId+" AND display=true";
			if (!name.isEmpty()) {
				sql += "  AND LOWER(title) LIKE LOWER('%" + name + "%') ";
			}
			System.out.println(sql);
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
	public int getCountByCategory(String name, long groupId, long categoryId) throws Exception{
		int total=-1;
		Session session=null;
		try {
			session= this.clipPersistence.openSession();
			String sql = "select COUNT(*) from portal_clip where groupid=" + groupId+" and categoryid "+categoryId;
			
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
	public List<Clip> getListByCategory(String name,long categoryId, long groupId, int start, int limit){
		List<Clip> listClipByCategory= new ArrayList<Clip>();
		Session session = null;
		try {
			session= this.clipPersistence.openSession();
			String sql = "select * from portal_clip where groupid=" + groupId+" and categoryid = "+categoryId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(title) LIKE LOWER('%" + name + "%') ";
			}
			sql+=" ORDER BY id_ DESC  ";
			if (start >-1 && limit > 0) {
				sql += " offset " + start + " limit " + limit + "";
			}
		
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_clip", ClipImpl.class);
			listClipByCategory = query.list();
		
		} finally {
			this.clipPersistence.closeSession(session);
		}
		
		return listClipByCategory;
	}
	public List<Clip> getListDetail(String name,long id, long groupId, int start, int limit){
		List<Clip> listClipByCategory= new ArrayList<Clip>();
		Session session = null;
		try {
			session= this.clipPersistence.openSession();
			String sql = "select * from portal_clip where id_ not in("+id+") and groupid=" + groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(title) LIKE LOWER('%" + name + "%') ";
			}
			sql+=" AND display=true ORDER BY id_ DESC  ";
			if (start >-1 && limit > 0) {
				sql += " offset " + start + " limit " + limit + "";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_clip", ClipImpl.class);
			listClipByCategory = query.list();
		
		} finally {
			this.clipPersistence.closeSession(session);
		}
		
		return listClipByCategory;
	}
	
	
	
	
	
	
	
	
	
	
}