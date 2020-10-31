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

import organizationalStructure.service.model.organization;
import organizationalStructure.service.model.impl.organizationImpl;
import organizationalStructure.service.service.base.organizationLocalServiceBaseImpl;

/**
 * The implementation of the organization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>organizationalStructure.service.service.organizationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see organizationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=organizationalStructure.service.model.organization",
	service = AopService.class
)
public class organizationLocalServiceImpl
	extends organizationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>organizationalStructure.service.service.organizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>organizationalStructure.service.service.organizationLocalServiceUtil</code>.
	 */
	public List<organization> getNode(long parentId, long groupId, String name, int start, int limit)
			throws Exception {
		Session session = null;
		
		try {
			session = this.organizationPersistence.openSession();
			String sql = "select * from portal_organization where parentid=" + parentId + " ";
			if (!name.isEmpty())
				sql += " and LOWER(name) like LOWER('%" + name + "%') ";
		
			if (groupId > 0)
				sql += " and groupid=" + groupId + " ";
			sql += " order by thuTu asc  ";
			
			if (start != -1 && limit != -1) {
				sql += "offset " + start + " limit " + limit + "";
			}

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("organization", organizationImpl.class);
			return query.list();
		} finally {
			this.organizationPersistence.closeSession(session);
		}

	}
	public int getNodeCount(long parentId, long groupId, String name) throws Exception {
		Session session = null;
		try {
			session = this.organizationPersistence.openSession();
			String sql = "select count(*) from portal_organization where parentid=" + parentId;

		
			if (!name.isEmpty())
				sql += " and  LOWER(name) like '%" + name + "%' ";

			if (groupId > 0)
				sql += " and groupid=" + groupId + " ";
			System.out.println(sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			return Integer.parseInt(query.list().get(0).toString());
		} finally {
			this.organizationPersistence.closeSession(session);
		}

	}

	public organization findByorganCoreId(long id) {
		try {
			return organizationPersistence.findByorganCoreId(id);
		} catch (Exception e) {
			return null;
		}
	}
}