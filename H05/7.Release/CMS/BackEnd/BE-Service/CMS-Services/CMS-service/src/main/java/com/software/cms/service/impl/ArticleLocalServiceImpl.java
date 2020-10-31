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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.software.cms.model.Article;
import com.software.cms.model.impl.ArticleImpl;
import com.software.cms.service.base.ArticleLocalServiceBaseImpl;
import com.software.util.NewsWorkflowConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.software.cms.service.ArticleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see ArticleLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.software.cms.model.Article", service = AopService.class)
public class ArticleLocalServiceImpl extends ArticleLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.software.cms.service.ArticleLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.software.cms.service.ArticleLocalServiceUtil</code>.
	 */

	public List<Article> getArticleFeaturedNew(int thutu, int limit, String locale, boolean ishomepage,
			boolean isnoibat, int status, String lIds,long groupId) {
		List<Article> danhSachArticle = null;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			String sql = "select * from soft_cms_article where language='" + locale + "' AND groupId = "+ groupId
					+ " and status=" + status;

			if (ishomepage)
				sql += " and ishomepage=true ";

			if (isnoibat)
				sql += " and isnoibat=true ";

			if (thutu >= 0)
				sql += " and thutu=" + thutu;

			if (!lIds.isEmpty())
				sql += " and articleid not in(" + lIds + ")";

			sql += " order by publisheddatefrom desc,modifieddate desc ";
			if (limit >= 0) {
				sql += " limit " + limit;
			}

			SQLQuery query = session.createSQLQuery(sql);
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

	public List<Article> searchNewArticle(long groupId, int status, String keyword, String dateFrom, String dateTo)
			throws Exception {
		List<Article> danhSachArticle = null;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();

			String sql = "";
			StringBuilder builderQuery = new StringBuilder();
			builderQuery.append("select\n");
			builderQuery.append("\t*\n");
			builderQuery.append("from\n");
			builderQuery.append("\tsoft_cms_article \n");
			builderQuery.append("where\n");
			builderQuery.append("\t status = " + status + "\n");
			builderQuery.append("\t and groupid = " + groupId + "\n");
			builderQuery.append("\tand (lower(title) like lower('%" + keyword + "%')\n");
			builderQuery.append("\tor lower(summary) like lower('%" + keyword + "%'))\n");

			if (!dateFrom.isEmpty()) {
				builderQuery.append("\tand publisheddatefrom >= '"+dateFrom+"'\n");
			}

			if (!dateTo.isEmpty()) {
				builderQuery.append("\tand publisheddatefrom <= '"+dateTo+"'\n");
			}
			
			builderQuery.append("order by\n");
			builderQuery.append("\tpublisheddatefrom desc\n");

			sql += builderQuery.toString();

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_article", ArticleImpl.class);
			danhSachArticle = (List<Article>) query.list();
			return danhSachArticle;
		} finally {
			this.articlePersistence.closeSession(session);
		}
	}

	public List<Article> getArticleByCate(long groupId, long categoryId, int limit) {
		List<Article> danhSachArticle = null;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			String sql = "SELECT DISTINCT soft_cms_article.* FROM soft_cms_article "
					+ " INNER JOIN soft_cms_categoryarticle "
					+ " ON soft_cms_article.articleid = soft_cms_categoryarticle.articleid "
					+ " WHERE soft_cms_categoryarticle.categoryid = " + categoryId + " and soft_cms_article.groupid = "
					+ groupId + " AND soft_cms_article.status= " + NewsWorkflowConstants.STATUS_PUBLISH
					+ " ORDER BY soft_cms_article.publisheddatefrom DESC LIMIT " + limit;

			SQLQuery query = session.createSQLQuery(sql);
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

	public List<Article> getArticleNew(long groupId, long categoryId, int start, int limit, String artIds)
			throws Exception {
		List<Article> danhSachArticle = null;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			String sqlResultNew = "SELECT DISTINCT soft_cms_article.* FROM soft_cms_article "
					+ " INNER JOIN soft_cms_categoryarticle "
					+ " ON soft_cms_article.articleid = soft_cms_categoryarticle.articleid "
					+ " WHERE soft_cms_categoryarticle.categoryid = " + categoryId + " and soft_cms_article.groupid = "
					+ groupId + " AND soft_cms_article.status= " + NewsWorkflowConstants.STATUS_PUBLISH;
			sqlResultNew += (!artIds.equals("") ? " AND soft_cms_article.articleid not in (" + artIds + ") " : "");
			sqlResultNew += " ORDER BY soft_cms_article.publisheddatefrom DESC offset " + start + " limit " + limit
					+ "";
			SQLQuery query = session.createSQLQuery(sqlResultNew);
			query.setCacheable(false);
			query.addEntity("soft_cms_article", ArticleImpl.class);
			danhSachArticle = (List<Article>) query.list();
		} finally {
			this.articlePersistence.closeSession(session);
		}

		return danhSachArticle;
	}

	public int countArticleNew(long groupId, long categoryId, String artIds) throws Exception {
		int count = 0;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			String sqlCountNew = "SELECT count(DISTINCT soft_cms_article.articleid) FROM soft_cms_article "
					+ " INNER JOIN soft_cms_categoryarticle "
					+ " ON soft_cms_article.articleid = soft_cms_categoryarticle.articleid "
					+ " WHERE soft_cms_categoryarticle.categoryid = " + categoryId + " and soft_cms_article.groupid = "
					+ groupId + " AND soft_cms_article.status= " + NewsWorkflowConstants.STATUS_PUBLISH;
			sqlCountNew += (!artIds.equals("") ? " AND soft_cms_article.articleid not in (" + artIds + ") " : "");
			SQLQuery query = session.createSQLQuery(sqlCountNew);
			query.setCacheable(false);
			if (query.list().size() > 0) {
				count = Integer.parseInt(query.list().get(0).toString());
			}
			return count;
		} finally {
			this.articlePersistence.closeSession(session);
		}

	}

	public List<Article> getArticleTheoSQL(long groupId, long articlemainId) {
		List<Article> danhSachArticle = null;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			String sql = "SELECT * FROM soft_cms_article WHERE groupid=" + groupId + " AND articlemainid="
					+ articlemainId + " AND issubsite=TRUE";

			SQLQuery query = session.createSQLQuery(sql);
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

	public List<Article> getArticleScheduler(String date, String status) {
		List<Article> danhSachArticle = null;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			String sql = "SELECT * FROM soft_cms_article where isTimer = true AND publisheddatefrom <= '" + date
					+ "' AND status NOT IN (" + status + ")";

			SQLQuery query = session.createSQLQuery(sql);
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

	public List<Article> getArticleInvolve(long groupId, String locale, int status, String title, int start, int limit,
			String involveId) throws Exception {
		List<Article> danhSachArticle = null;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from soft_cms_article where groupid= " + groupId + " \n");
			sql.append("and lower(language)=lower('" + locale + "') \n");
			sql.append("and status=" + status + " \n");
			sql.append("and LOWER(title) like LOWER('%" + title + "%') \n");
			if (!involveId.isEmpty())
				sql.append("and articleid not in(" + involveId + ") \n");

			if (start >= 0 && limit >= 0) {
				sql.append("offset " + start + " limit " + limit + " \n");
			}

			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			query.addEntity("soft_cms_article", ArticleImpl.class);
			danhSachArticle = (List<Article>) query.list();
			return danhSachArticle;
		} finally {
			this.articlePersistence.closeSession(session);
		}
	}

	public List<Object[]> getArticleSource(String source, int limit) throws Exception {
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			if (limit <= 0) {
				limit = 10;
			}
			StringBuilder sql = new StringBuilder();
			sql.append("select articleid,source from soft_cms_article \n");
			sql.append("where LOWER(source) like LOWER('%" + source + "%') limit " + limit + "\n");

			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			return (List<Object[]>) query.list();
		} finally {
			this.articlePersistence.closeSession(session);
		}
	}

	public Article getArticleByImageId(long articleId, long imageId) throws Exception {
		Article article = null;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from soft_cms_article where image='" + imageId + "' \n");
			sql.append("and articleid=" + articleId + " \n");

			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			query.addEntity("soft_cms_article", ArticleImpl.class);
			if (query.list().size() > 0) {
				article = (Article) query.list().get(0);
			}
			return article;
		} finally {
			this.articlePersistence.closeSession(session);
		}
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
			results = null;
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

	public Article getArticleByFriendlyURLAndStatus(String friendlyUrl, int status) throws Exception {
		return this.articlePersistence.findByFriendUrlAndStatus(friendlyUrl, status);

	}

	public List<Article> getListArticleByEvent(long groupId, long articleId, long categoryId, String eventId, int start,
			int end) throws PortalException, SystemException {
		return this.articleFinder.getListArticleByEvent(groupId, articleId, categoryId, eventId, start, end);

	}

	public List<Article> findByUserNews(long groupId, String language, long userId, long status, long categoryId,
			String eventName, String tagName, String keyword, boolean inTitle, boolean inSummary, boolean inContent,
			boolean inDate, Date fromDate, Date toDate, boolean inAuthor, boolean userKiemDuyet, int start, int end)
			throws Exception {
		return this.articleFinder.findByUserNews(groupId, language, userId, status, categoryId, eventName, tagName,
				keyword, inTitle, inSummary, inContent, inDate, fromDate, toDate, inAuthor, userKiemDuyet, start, end);
	}

	public int getCountByUserNews(long groupId, String language, long userId, long status, long categoryId,
			String eventName, String tagName, String keyword, boolean inTitle, boolean inSummary, boolean inContent,
			boolean inDate, Date fromDate, Date toDate, boolean inAuthor, boolean userKiemDuyet) throws Exception {
		return this.articleFinder.getCountByUserNews(groupId, language, userId, status, categoryId, eventName, tagName,
				keyword, inTitle, inSummary, inContent, inDate, fromDate, toDate, inAuthor, userKiemDuyet);
	}

	public List<Object> getDuLieuTheoSql(String sql, int start, int end) {
		return articleFinder.getDuLieuTheoSql(sql, start, end);
	}

	public List<Article> getListArticleBySQL(String sql, int start, int end) {
		return articleFinder.getArticleBySql(sql, start, end);
	}

	public int getCountArticleBySQL(String sql) {
		return articleFinder.getCountByArticle(sql);
	}

	public int getCountArticleByCaterory(long groupId, Long categoryId, Date publishDateFrom)
			throws PortalException, SystemException {
		return this.articleFinder.getCountArticleByCaterory(groupId, categoryId, publishDateFrom);
	}

	public List<Article> getListArticleByCaterory(long groupId, Long categoryId, Date publishDateFrom, Integer start,
			Integer end) throws PortalException, SystemException {
		return this.articleFinder.getListArticleByCaterory(groupId, categoryId, publishDateFrom, start, end);

	}

	public List<Article> searchByAuthorName(String name, long groupid, String language) {
		List<Article> listAuthor = new ArrayList<Article>();
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			String sql = "select DISTINCT * from soft_cms_article where groupid = " + groupid + " AND language = '"
					+ language + "' AND LOWER(author) like LOWER(?) limit 100";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Article", ArticleImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add("%" + name + "%");
			listAuthor = (List<Article>) query.list();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.articlePersistence.closeSession(session);
		}
		return listAuthor;
	}

	public List<Article> searchBySourceName(String name, long groupid, String language) {
		List<Article> listSource = new ArrayList<Article>();
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			String sql = "select DISTINCT * from soft_cms_article where groupid = " + groupid + " AND language = '"
					+ language + "' AND LOWER(source) like LOWER(?) limit 100";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Article", ArticleImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add("%" + name + "%");
			listSource = (List<Article>) query.list();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.articlePersistence.closeSession(session);
		}
		return listSource;
	}

	public int getMaxId() {
		Long count = 0L;
		Session session = null;
		try {
			session = this.articlePersistence.openSession();
			String sql = "select max(articleid) from soft_cms_article";
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

	public Article create() {
		return new ArticleImpl();
	}
}
