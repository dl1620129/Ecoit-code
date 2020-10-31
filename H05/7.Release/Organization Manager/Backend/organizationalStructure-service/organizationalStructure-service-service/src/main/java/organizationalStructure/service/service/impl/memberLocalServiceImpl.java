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

package organizationalStructure.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import organizationalStructure.service.model.member;
import organizationalStructure.service.model.impl.memberImpl;
import organizationalStructure.service.model.impl.organizationImpl;
import organizationalStructure.service.service.base.memberLocalServiceBaseImpl;

/**
 * The implementation of the member local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>organizationalStructure.service.service.memberLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see memberLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=organizationalStructure.service.model.member",
	service = AopService.class
)
public class memberLocalServiceImpl extends memberLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>organizationalStructure.service.service.memberLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>organizationalStructure.service.service.memberLocalServiceUtil</code>.
	 */
	public List<member> getListMember(long groupId, String fullName, int start, int limit) throws Exception{
		Session session = null;
		try {
			session= this.memberPersistence.openSession();
			String sql = "select * from portal_member where groupId=" + groupId + " ";

			
			if (!fullName.isEmpty())
				sql += " and LOWER(fullName) like LOWER('%" + fullName + "%') ";
		
			sql += " order by birthday asc  ";
			
			if (start != -1 && limit != -1) {
				sql += "offset " + start + " limit " + limit + "";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("member", memberImpl.class);
			return query.list();
		} finally {
			this.memberPersistence.closeSession(session);
		}
	}
	public int getCount(long groupId, String fullName) {

		Session session = null;
		try {
			session= this.memberPersistence.openSession();
			String sql = "select COUNT(*) from portal_member where groupId=" + groupId + " ";

			
			if (!fullName.isEmpty())
				sql += " and LOWER(fullName) like LOWER('%" + fullName + "%') ";
		
		
			
			SQLQuery query = session.createSQLQuery(sql);
			
			query.setCacheable(false);
			return Integer.parseInt(query.list().get(0).toString());
		} finally {
			this.memberPersistence.closeSession(session);
		}
	}
	public List<member> getListMemberByOrganId(long groupId, long organizationId, int start, int limit) throws Exception{
		Session session = null;
		try {
			session= this.memberPersistence.openSession();
			String sql = "select * from portal_member where groupId=" + groupId + " and organizationId= "+organizationId+" ";

			
	
			if (start != -1 && limit != -1) {
				sql += "offset " + start + " limit " + limit + "";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("member", memberImpl.class);
			return query.list();
		} finally {
			this.memberPersistence.closeSession(session);
		}
	}
	public int getCountByOrgan(long groupId, long organizationId) {

		Session session = null;
		try {
			session= this.memberPersistence.openSession();
			String sql = "select COUNT(*) from portal_member where groupId=" + groupId  + " and organizationId= "+organizationId+" ";

			
		
		
		
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			return Integer.parseInt(query.list().get(0).toString());
		} finally {
			this.memberPersistence.closeSession(session);
		}
	}
	
	
	
	
	
	
	
}