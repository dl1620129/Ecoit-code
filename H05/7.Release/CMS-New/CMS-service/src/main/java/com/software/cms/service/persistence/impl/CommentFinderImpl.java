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
import com.software.cms.model.Comment;
import com.software.cms.model.impl.CommentImpl;
import com.software.cms.service.persistence.CommentFinder;

@Component(
		service = CommentFinder.class
	)
public class CommentFinderImpl extends CommentFinderBaseImpl implements CommentFinder {
	public List<Comment> getCountCommentBySQL(String sql, Integer start, Integer end)
			throws SystemException {
		List<Comment> listComment = null;
		Session session = openSession();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addEntity("Comment", CommentImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			listComment = (List<Comment>) QueryUtil.list(query, getDialect(),
					start, end);
		} catch (Exception e) {
			listComment = null;
		} finally {
			closeSession(session);
		}
		return listComment;
	}
	public List<Comment> findComment(long groupId, String keyword,int start,int end) {
		List<Comment> result = new ArrayList<Comment>();
		Session session=null;
		try {
			session = openSession();
			String sql = "select * from soft_cms_Comment where groupid=? ";
			if (keyword != null && !"".equals(keyword)) sql+=" AND lower(content) LIKE ? ";
			sql+="ORDER BY createddate DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_Comment", CommentImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			if (keyword != null && !"".equals(keyword)) qPos.add("%"+keyword.toLowerCase()+"%");
			result=(List<Comment>) QueryUtil.list(query, getDialect(),
					start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			closeSession(session);
		}
		return result;
	}
	public int getCountBySQL(long groupId, String keyword)
			throws SystemException {
		Long count = 0L;
		Session session=null;
		try {
			session = openSession();
			String sql = "select count(*) from soft_cms_Comment where groupid=?  ";
			if (keyword != null && !"".equals(keyword)) sql+=" AND lower(content) LIKE ? ";
			SQLQuery query = session.createSQLQuery(sql);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			if (keyword != null && !"".equals(keyword)) qPos.add("%"+keyword.toLowerCase()+"%");
			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}
		} catch (Exception e) {
			count = Long.valueOf(0);
		} finally {
			closeSession(session);
		}
		return count.intValue();
	}
}
