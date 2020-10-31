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
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.software.cms.model.CategoryArticle;
import com.software.cms.model.impl.CategoryArticleImpl;
import com.software.cms.service.CategoryArticleLocalServiceUtil;
import com.software.cms.service.base.CategoryArticleLocalServiceBaseImpl;
import com.software.cms.service.persistence.CategoryArticlePK;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the category article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.software.cms.service.CategoryArticleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see CategoryArticleLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.software.cms.model.CategoryArticle", service = AopService.class)
public class CategoryArticleLocalServiceImpl extends CategoryArticleLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.software.cms.service.CategoryArticleLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.software.cms.service.CategoryArticleLocalServiceUtil</code>.
	 */
	public List<CategoryArticle> findByCategory(long categoryId) {
		return categoryArticlePersistence.findByCategory(categoryId);
	}

	public void addCategoryArticle(long articleId, long categoryId,long groupId) {
		try {
			CategoryArticlePK primKey = new CategoryArticlePK(articleId, categoryId);
			CategoryArticle ca = CategoryArticleLocalServiceUtil.createCategoryArticle(primKey);
			ca.setGroupId(groupId);
			ca.setCategoryId(categoryId);
			ca.setArticleId(articleId);
			CategoryArticleLocalServiceUtil.addCategoryArticle(ca);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void removeByArticle(long article) {
		try {
			this.categoryArticlePersistence.removeByArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeByCategory(long categoryId) {
		try {
			this.categoryArticlePersistence.removeByCategory(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<CategoryArticle> getCategoryOfArticle(long idArticle) {
		List<CategoryArticle> list = new ArrayList<CategoryArticle>();
		try {
			list = categoryArticlePersistence.findByArticle(idArticle);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public List<Long> getCategoryOfArticleWithId(long id_article) {
		List<Long> list = new ArrayList<Long>();
		try {
			List<CategoryArticle> cates = categoryArticlePersistence.findByArticle(id_article);
			for (CategoryArticle cate : cates) {
				list.add(cate.getCategoryId());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

	public List<CategoryArticle> findByCatId(long catId) {
		try {
			return this.categoryArticlePersistence.findByCategory(catId);
		} catch (Exception e) {
			return new ArrayList<CategoryArticle>();
		}
	}

	public int getCountById(long catId) throws Exception {
		int count = 0;
		Session session = null;
		try {
			session = this.categoryArticlePersistence.openSession();
			String  sql = "SELECT COUNT(*) FROM soft_cms_categoryarticle where categoryid = " + catId;
			SQLQuery q = session.createSQLQuery(sql);
			
			if (q.list().size()>0) {
				count = Integer.parseInt(q.list().get(0).toString());
			}
			return count;
		} finally {
			this.categoryArticlePersistence.closeSession(session);
		}
	}

	public List<Object> getDuLieuTheoSql(String sqlQuery) {
		List<Object> results = new ArrayList<Object>();
		Session session = null;
		try {
			session = this.categoryArticlePersistence.openSession();

			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.setCacheable(false);
			results = (List<Object>) query.list();
		} catch (Exception e) {
			results = null;
		} finally {
			this.categoryArticlePersistence.closeSession(session);
		}

		return results;
	}

	public CategoryArticle create() {
		return new CategoryArticleImpl();
	}
}