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

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.software.cms.model.Article;
import com.software.cms.model.impl.ArticleImpl;
import com.software.cms.service.base.ArticleLocalServiceBaseImpl;

/**
 * The implementation of the article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.software.cms.service.ArticleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see ArticleLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.software.cms.model.Article",
	service = AopService.class
)
public class ArticleLocalServiceImpl extends ArticleLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.software.cms.service.ArticleLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.software.cms.service.ArticleLocalServiceUtil</code>.
	 */
	public List<Article> getArticleTheoSQL(String sqlQuery) {
		List<Article> danhSachArticle = null;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();

			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.setCacheable(false);
			query.addEntity("soft_cms_article", ArticleImpl.class);
			danhSachArticle = (List<Article>) query.list();
		} catch (Exception e) {
			danhSachArticle = null;
		} finally {
			this.articlePersistence.closeSession(session);
		}

		return danhSachArticle;
	}
	public List<Object> getDuLieuTheoSql(String sqlQuery) {
		List<Object> results = new ArrayList<Object>();
		Session session = null;
		try {
			session = this.articlePersistence.openSession();

			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.setCacheable(false);
			results = (List<Object>) query.list();
		} catch (Exception e) {
			results=null;
		} finally {
			this.articlePersistence.closeSession(session);
		}

		return results;
	}
	public Article getArticleByFriendlyURL(String friendlyUrl) {
		try {
			return this.articlePersistence.findByFriendUrl(friendlyUrl);
		} catch (Exception e) {
		}

		return null;
	}
	public Article getArticleByFriendlyURLAndStatus(String friendlyUrl,int status) {
		try {
			return this.articlePersistence.findByFriendUrlAndStatus(friendlyUrl, status);
		} catch (Exception e) {
		}

		return null;
	}
	public List<Article> getListArticleByEvent(long groupId,long articleId, long categoryId,
			String eventId, int start, int end) throws PortalException,
			SystemException {
		return this.articleFinder.getListArticleByEvent( groupId,articleId, categoryId,
				eventId, start, end);

	}
	public List<Article> findByUserNews(long groupId, String language, long userId,
			long status, long categoryId, String eventName, String tagName,
			String keyword, boolean inTitle, boolean inSummary,
			boolean inContent, boolean inDate, Date fromDate, Date toDate,boolean inAuthor,boolean userKiemDuyet, int start, int end) throws PortalException, SystemException{
		return this.articleFinder.findByUserNews( groupId,  language,  userId,
			 status,  categoryId,  eventName,  tagName,
			 keyword,  inTitle,  inSummary,
			 inContent,  inDate,  fromDate,  toDate,inAuthor,userKiemDuyet,  start,  end);
	}
	public int getCountByUserNews(long groupId, String language, long userId,
			long status, long categoryId, String eventName, String tagName,
			String keyword, boolean inTitle, boolean inSummary,
			boolean inContent, boolean inDate, Date fromDate, Date toDate,boolean inAuthor,boolean userKiemDuyet) throws PortalException, SystemException{
		return this.articleFinder.getCountByUserNews( groupId,  language,  userId,
			 status,  categoryId,  eventName,  tagName,
			 keyword,  inTitle,  inSummary,
			 inContent,  inDate,  fromDate,  toDate,inAuthor,userKiemDuyet);
	}
	public List<Object> getDuLieuTheoSql(String sql,int start,int end){
		return articleFinder.getDuLieuTheoSql(sql, start, end);
	}
	public List<Article> getListArticleBySQL(String sql,int start,int end){
		return articleFinder.getArticleBySql(sql, start, end);
	}
	public int getCountArticleBySQL(String sql){
		return articleFinder.getCountByArticle(sql);
	}
	public int getCountArticleByCaterory(long groupId, Long categoryId, Date publishDateFrom)
			throws PortalException, SystemException {
		return this.articleFinder.getCountArticleByCaterory(groupId, categoryId,
				publishDateFrom);
	}
	public List<Article> getListArticleByCaterory(long groupId,Long categoryId,
			Date publishDateFrom, Integer start, Integer end)
			throws PortalException, SystemException {
		return this.articleFinder.getListArticleByCaterory(groupId, categoryId,
				publishDateFrom, start, end);

	}
	public List<Article> searchByAuthorName(String name,long groupid,String language) {
		List<Article> listAuthor = new ArrayList<Article>();
		Session session =null;
		try {
			session = this.articlePersistence.openSession();
			String sql = "select DISTINCT * from soft_cms_article where groupid = "+groupid+" AND language = '"+language+"' AND LOWER(author) like LOWER(?) limit 100";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Article", ArticleImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add("%"+name+"%");
			listAuthor= (List<Article>)query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
        finally {
        	this.articlePersistence.closeSession(session);
		}
		return listAuthor;
	}
	public List<Article> searchBySourceName(String name,long groupid,String language) {
		List<Article> listSource = new ArrayList<Article>();
		Session session =null;
		try {
			session = this.articlePersistence.openSession();
			String sql = "select DISTINCT * from soft_cms_article where groupid = "+groupid+" AND language = '"+language+"' AND LOWER(source) like LOWER(?) limit 100";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Article", ArticleImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add("%"+name+"%");
			listSource= (List<Article>)query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
        finally {
        	this.articlePersistence.closeSession(session);
		}
		return listSource;
	}
	public int getMaxId(String sql){
		Long count = 0L;
		Session session = null;
		try {
            session = this.articlePersistence.openSession();
			SQLQuery q = session.createSQLQuery(sql);
			Iterator<java.math.BigInteger> itr = q.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}
			
		} catch (Exception e) {
			count = 0L;
			
		} finally {
			this.articlePersistence.closeSession(session);
		}

		// System.out.println("----------------------------------------------------------------------------------------------------------");
		return count.intValue();
	}
	public Article create(){
		return new ArticleImpl();
	}
}