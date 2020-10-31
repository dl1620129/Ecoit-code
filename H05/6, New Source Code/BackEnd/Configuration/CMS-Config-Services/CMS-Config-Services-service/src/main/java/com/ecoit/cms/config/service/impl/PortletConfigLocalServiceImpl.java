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

package com.ecoit.cms.config.service.impl;

import com.ecoit.cms.config.model.PortletConfig;
import com.ecoit.cms.config.model.impl.PortletConfigImpl;
import com.ecoit.cms.config.service.base.PortletConfigLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the portlet config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.cms.config.service.PortletConfigLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletConfigLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.cms.config.model.PortletConfig",
	service = AopService.class
)
public class PortletConfigLocalServiceImpl
	extends PortletConfigLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.cms.config.service.PortletConfigLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.cms.config.service.PortletConfigLocalServiceUtil</code>.
	 */
	
	public List<PortletConfig> searchConfig(String q, int start, int limit) {
		Session session = null;
		List<PortletConfig> configList = new ArrayList<>();
		try {
			session = portletConfigPersistence.openSession();
			String sql = "SELECT * FROM ecoit_config_portletconfig WHERE LOWER(portletid) LIKE LOWER(:searchKey) OFFSET :start ";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_config_portletconfig", PortletConfigImpl.class);
			query.setString("searchKey", "%" + q + "%");
			query.setInteger("start", start);
			if (limit > 0) {
				query.setMaxResults(limit);
			}
			
			
			QueryPos.getInstance(query);
			configList = query.list();
			return configList;
		} finally {
			portletConfigPersistence.closeSession(session);
		}
	}
	
	public int countConfig(String q) {
		Session session = null;
		int count = 0;
		try {
			session = portletConfigPersistence.openSession();
			String sql = "SELECT COUNT(*) FROM ecoit_config_portletconfig WHERE LOWER(portletid) LIKE LOWER(:searchKey) ";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.setString("searchKey", "%" + q + "%");
				
			Iterator<BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} finally {
			portletConfigPersistence.closeSession(session);
		}
		return count;
	}
	
}