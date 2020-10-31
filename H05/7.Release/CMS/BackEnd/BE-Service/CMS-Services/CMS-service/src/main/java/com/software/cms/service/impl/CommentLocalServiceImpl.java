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
import com.liferay.portal.kernel.exception.SystemException;
import com.software.cms.model.Comment;
import com.software.cms.model.impl.CommentImpl;
import com.software.cms.service.base.CommentLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the comment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.software.cms.service.CommentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see CommentLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.software.cms.model.Comment", service = AopService.class)
public class CommentLocalServiceImpl extends CommentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.software.cms.service.CommentLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.software.cms.service.CommentLocalServiceUtil</code>.
	 */
	public List<Comment> searchComment(Long id) throws Exception {
		List<Comment> commentList = new ArrayList<Comment>();
		Session session = null;
		try {
			session = this.commentPersistence.openSession();
			String sql = "SELECT * FROM soft_cms_comment WHERE articleId = ? ORDER BY createddate DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Comment", CommentImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(id);
			commentList = (List<Comment>) query.list();
		} finally {
			this.commentPersistence.closeSession(session);
		}
		return commentList;
	}

	public List<Comment> findByArticleId(long groupId, long articleId) {
		try {
			return this.commentPersistence.findByGroup_Article(groupId, articleId);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Comment> findComment(long groupId, String keyword, int start, int end) {
		return this.commentFinder.findComment(groupId, keyword, start, end);
	}

	public int getCountComment(long groupId, String keyword) {
		try {
			return this.commentFinder.getCountBySQL(groupId, keyword);
		} catch (SystemException e) {
			return 0;
		}
	}

	public Comment create() {
		return new CommentImpl();
	}
}