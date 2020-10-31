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
import com.software.cms.model.Event;
import com.software.cms.model.impl.EventImpl;
import com.software.cms.service.base.EventLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.software.cms.service.EventLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see EventLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.software.cms.model.Event",
	service = AopService.class
)
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.software.cms.service.EventLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.software.cms.service.EventLocalServiceUtil</code>.
	 */
	public List<Event> searchEvent(long groupId, String language, String keyword) {
		List<Event> list = new ArrayList<Event>();
		Session session =null;
		try {
			session = this.eventPersistence.openSession();
			String sql = "SELECT * FROM soft_cms_event WHERE LOWER(eventName) LIKE LOWER(?) AND groupid = ? AND language = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Event", EventImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add("%"+keyword+"%");
			qPos.add(groupId);
			qPos.add(language);
			list= (List<Event>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.eventPersistence.closeSession(session);
		}
		return list;
	}
	public List<Event> findEvent(long groupId, String language, String keyword,int start,int end) {
		return this.eventFinder.findEvent(groupId, language,  keyword, start, end);
	}
	public int getCountEvent(long groupId, String language, String keyword) {
		return this.eventFinder.getCountEvent(groupId, language,  keyword);
	}
	public List<Event> getEventBySql(String sql, int start,int end) {
		return this.eventFinder.getEventBySql(sql, start, end);
	}
	public Event create(){
		return new EventImpl();
	}
}