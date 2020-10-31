package com.software.cms.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.software.cms.model.Event;
import com.software.cms.model.impl.EventImpl;
import com.software.cms.service.persistence.EventFinder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(service = EventFinder.class)
public class EventFinderImpl extends EventFinderBaseImpl implements EventFinder {
	
	public List<Event> findEvent(long groupId, String language,String keyword,int start,int limit) {
		List<Event> result = new ArrayList<Event>();
		Session session=null;
		try {
			session = openSession();
			String sql = "select * from soft_cms_event where groupid=? AND language=? ";
			if (keyword != null && !"".equals(keyword)) sql+=" AND lower(eventname) LIKE ? ";
			sql+="ORDER BY eventid DESC";
			if(start>=0 && limit >=0) {
				sql += " offset "+start+" limit "+limit+"";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_event", EventImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			qPos.add(language);
			if (keyword != null && !"".equals(keyword)) qPos.add("%"+keyword.toLowerCase()+"%");
			result=(List<Event>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			closeSession(session);
		}
		return result;
	}
	public int getCountEvent(long groupId, String language, String keyword) {
		Long count = 0L;
		Session session=null;
		try {
			session = openSession();
			String sql = "select count(*) from soft_cms_event where groupid=? AND language=? ";
			if (keyword != null && !"".equals(keyword)) sql+=" AND lower(eventname) LIKE ? ";
			//System.out.println("sqlCount Logger: "+sql);
			SQLQuery query = session.createSQLQuery(sql);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			qPos.add(language);
			if (keyword != null && !"".equals(keyword)) qPos.add("%"+keyword.toLowerCase()+"%");
			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}
			//System.out.println("countLogger: "+count);
		} catch (Exception e) {
			count = Long.valueOf(0);
		}
		finally{
			closeSession(session);
		}
		return count.intValue();
	}
	public List<Event> getEventBySql(String sql, int start, int end)
			 {
		List<Event> listEvent = null;
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Event", EventImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			listEvent = (List<Event>) QueryUtil.list(query, getDialect(),
					start, end);
		} catch (Exception e) {
			listEvent = null;
		} finally {
			closeSession(session);
		}
		return listEvent;
	}
}
