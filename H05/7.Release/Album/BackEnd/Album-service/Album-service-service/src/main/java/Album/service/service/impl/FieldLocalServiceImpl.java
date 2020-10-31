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

import Album.service.model.Field;
import Album.service.model.impl.FieldImpl;
import Album.service.service.base.FieldLocalServiceBaseImpl;


import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the field local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>Album.service.service.FieldLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=Album.service.model.Field",
	service = AopService.class
)
public class FieldLocalServiceImpl extends FieldLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>Album.service.service.FieldLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>Album.service.service.FieldLocalServiceUtil</code>.
	 */
	public List<Field> getFieldTheoSQL(String sqlQuery) {
		List<Field> danhSachField = null;
		Session session = null;
		try {
			session = this.fieldPersistence.openSession();

			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.setCacheable(false);
			query.addEntity("Field", FieldImpl.class);
			danhSachField = (List<Field>) query.list();
		} catch (Exception e) {
			danhSachField = null;
		} finally {
			this.fieldPersistence.closeSession(session);
		}

		return danhSachField;
	}
		public List<Field> getListFields(String name, int start, int limit, long groupId){
		
			List<Field> listField= new ArrayList<Field>();
			Session session = null;
			try {
				session = this.fieldPersistence.openSession();
				String sql = "select * from portal_album_Fields where groupid=" + groupId;
				if (!name.isEmpty()) {
					sql += " AND LOWER(name) LIKE LOWER('%" + name + "%') ";
				}
				if (start >-1 && limit >0) {
					sql += " offset " + start + " limit " + limit + "";
				}
			
				SQLQuery query= session.createSQLQuery(sql);
				query.setCacheable(false);
				query.addEntity("portal_album_Field", FieldImpl.class);
				
				listField = query.list();
			}catch (Exception e) {
				 listField= new ArrayList<Field>();
			}finally {
				this.fieldPersistence.closeSession(session);
			}
			return listField;
		}
		public int getCountAll(String name,long groupId) throws Exception  {
			int total=-1;
			Session session= null;
			
			try {
				session= this.fieldPersistence.openSession();
				String sql="select COUNT(*) from portal_album_Fields where groupid= "+groupId;
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
				this.fieldPersistence.closeSession(session);
			} 
		}
}