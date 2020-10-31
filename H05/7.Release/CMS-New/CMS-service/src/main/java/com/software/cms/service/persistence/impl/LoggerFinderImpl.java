package com.software.cms.service.persistence.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.software.cms.model.Logger;
import com.software.cms.model.impl.LoggerImpl;
import com.software.cms.service.persistence.LoggerFinder;

@Component(service = LoggerFinder.class)
public class LoggerFinderImpl extends LoggerFinderBaseImpl implements LoggerFinder {
	public List<Logger> getLoggerBySQL(String sql, Integer start, Integer end)
			throws SystemException {
		List<Logger> listLogger = null;
		Session session = openSession();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addEntity("Logger", LoggerImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			listLogger = (List<Logger>) QueryUtil.list(query, getDialect(),
					start, end);
		} catch (Exception e) {
			listLogger = null;
		} finally {
			closeSession(session);
		}
		return listLogger;
	}
	public List<Logger> findLogger(long groupId, String language, long userId, String type, String keyword,int start,int end) {
		List<Logger> result = new ArrayList<Logger>();
		Session session=null;
		try {
			session = openSession();
			String sql = "select * from soft_cms_logger where groupid=? AND language=? ";
			if (userId > 0) sql+=" AND userId=? ";
			if (type != null && !"".equals(type)) sql+=" AND type_=? ";
			if (keyword != null && !"".equals(keyword)) sql+=" AND lower(description) LIKE ? ";
			sql+="ORDER BY createddate DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_logger", LoggerImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			qPos.add(language);
			if (userId > 0) qPos.add(userId);
			if (type != null && !"".equals(type)) qPos.add(type);
			if (keyword != null && !"".equals(keyword)) qPos.add("%"+keyword.toLowerCase()+"%");
			result=(List<Logger>) QueryUtil.list(query, getDialect(),
					start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			closeSession(session);
		}
		return result;
	}
	public int getCountLogger(long groupId, String language, long userId, String type, String keyword) {
		Long count = 0L;
		Session session=null;
		try {
			session = openSession();
			String sql = "select count(*) from soft_cms_logger where groupid=? AND language=? ";
			if (userId > 0) sql+=" AND userId=? ";
			if (type != null && !"".equals(type)) sql+=" AND type_=? ";
			if (keyword != null && !"".equals(keyword)) sql+=" AND lower(description) LIKE ? ";
			//System.out.println("sqlCount Logger: "+sql);
			SQLQuery query = session.createSQLQuery(sql);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			qPos.add(language);
			if (userId > 0) qPos.add(userId);
			if (type != null && !"".equals(type)) qPos.add(type);
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
}
