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

import com.ecoit.mr.model.Unit;
import com.ecoit.mr.model.impl.UnitImpl;
import com.ecoit.mr.service.base.UnitLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the unit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.mr.service.UnitLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UnitLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.mr.model.Unit",
	service = AopService.class
)
public class UnitLocalServiceImpl extends UnitLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.mr.service.UnitLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.mr.service.UnitLocalServiceUtil</code>.
	 */
	
	
	public void updateCreateUnit(long unitId, long groupId, long companyId, long userId, String language, String name,
			String description) throws Exception {
		Unit unit = null;
		Date now = new Date();
		if (unitId <= 0) {
			unitId = counterLocalService.increment();
			unit = unitPersistence.create(unitId);
			unit.setCreateDate(now);
			unit.setCreatedByUser(userId);
		} else {
			unit = unitPersistence.fetchByPrimaryKey(unitId);
		}
		
		unit.setCompanyId(companyId);
		unit.setGroupId(groupId);
		unit.setLanguage(language);
		unit.setName(name);
		unit.setDescription(description);
		unitPersistence.update(unit);
	}
	
	public List<Unit> searchUnit(String searchKey, long groupId, long companyId, String language, int start, int limit) {
		Session session = null;
		List<Unit> unitsList = new ArrayList<>();
		try {
			session = unitPersistence.openSession();
			String sql = "SELECT * FROM ecoit_mr_unit WHERE companyid = :companyId AND groupid = :groupId AND language = :language "
					+ "AND LOWER(name) LIKE LOWER(:searchKey) ORDER BY modifieddate DESC OFFSET :start";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_mr_unit", UnitImpl.class);
			query.setInteger("start", start);
			query.setString("searchKey", "%" + searchKey + "%");
			query.setLong("groupId", groupId);
			query.setLong("companyId", companyId);
			query.setString("language", language);
			if (limit > 0) {
				query.setMaxResults(limit);
			}
			
			QueryPos.getInstance(query);
			unitsList = query.list();
			return unitsList;
		} finally {
			unitPersistence.closeSession(session);
			
		}
	}
	
	public int countUnit(String searchKey, long groupId, long companyId, String language) throws Exception {
		int count = 0;
		Session session = null;
		try {
			session = memberReportPersistence.openSession();
			String sql = "SELECT COUNT(*) FROM ecoit_mr_unit WHERE companyid = :companyId AND groupid = :groupId AND language = :language "
					+ "AND LOWER(name) LIKE LOWER(:searchKey)";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.setString("language", language);
			query.setLong("groupId", groupId);
			query.setLong("companyId", companyId);
			query.setString("searchKey", "%" + searchKey + "%");
			
			Iterator<BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} finally {
			memberReportPersistence.closeSession(session);
		}
		return count;
	}
	
}