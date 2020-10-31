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

package com.ecoit.mr.service.impl;

import com.ecoit.mr.model.MemberReportHistory;
import com.ecoit.mr.model.UserPermissionGroup;
import com.ecoit.mr.model.impl.MemberReportHistoryImpl;
import com.ecoit.mr.model.impl.UserPermissionGroupImpl;
import com.ecoit.mr.service.base.MemberReportHistoryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the member report history local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.mr.service.MemberReportHistoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberReportHistoryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.mr.model.MemberReportHistory",
	service = AopService.class
)
public class MemberReportHistoryLocalServiceImpl
	extends MemberReportHistoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.mr.service.MemberReportHistoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.mr.service.MemberReportHistoryLocalServiceUtil</code>.
	 */
	public List<MemberReportHistory> getList( long groupId,long memberreportHistoryId, int start, int limit)
			throws Exception {
		Session session = null;
		try {
			session = this.memberReportHistoryPersistence.openSession();
			String sql = "select * from ecoit_mr_memberreporthistory where groupId=" + groupId + " and MemberReportId="+memberreportHistoryId;

			sql += " order by modifiedDate asc  ";
			
			if (start != -1 && limit != -1) {
				sql += "offset " + start + " limit " + limit + "";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_mr_memberreporthistory", MemberReportHistoryImpl.class);
			return query.list();
		} finally {
			this.memberReportHistoryPersistence.closeSession(session);
		}

	}
	public int getCount(long groupId,long memberreportHistoryId, int start, int limit) throws Exception {
		Session session = null;
		int total=-1;
		try {
			session = this.memberReportHistoryPersistence.openSession();
			String sql = "select COUNT(*) from ecoit_mr_memberreporthistory where groupId=" + groupId + " and MemberReportId="+memberreportHistoryId;
			SQLQuery query = session.createSQLQuery(sql); 
			query.setCacheable(false);
			total=  Integer.parseInt(query.list().get(0).toString());
		} catch (Exception e) {
			this.memberReportHistoryPersistence.closeSession(session);
		}
		return total;
	}
	
	
	
	
	
	
	
	
	
	
	
}