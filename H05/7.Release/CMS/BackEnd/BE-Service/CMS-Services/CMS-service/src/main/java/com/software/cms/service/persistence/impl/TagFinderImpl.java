package com.software.cms.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.software.cms.model.Tag;
import com.software.cms.model.impl.TagImpl;
import com.software.cms.service.persistence.TagFinder;

import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(service = TagFinder.class)
public class TagFinderImpl extends TagFinderBaseImpl implements TagFinder {
	public List<Tag> getListTag(String sql, Integer start, Integer end)
			throws SystemException {
		List<Tag> listTag = null;
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Tag", TagImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			listTag = (List<Tag>) QueryUtil.list(query, getDialect(),
					start, end);
		} catch (Exception e) {
			listTag = null;
		} finally {
			closeSession(session);
		}
		return listTag;
	}
	public int getCountByTag(String sql){
		Long count = 0L;
		Session session = null;
		try{
			session = openSession();
			SQLQuery q = session.createSQLQuery(sql);
			Iterator<java.math.BigInteger> itr = q.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}
			
		} catch (Exception e) {
			count = 0L;
		}finally {
			if (count == null) {
				count = Long.valueOf(0);
			}
			if(session!=null)closeSession(session);
		}
		
		return count.intValue();
	}
}
