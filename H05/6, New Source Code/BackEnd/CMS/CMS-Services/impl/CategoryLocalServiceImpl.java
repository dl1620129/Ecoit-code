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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.software.cms.model.Category;
import com.software.cms.model.impl.CategoryImpl;
import com.software.cms.service.base.CategoryLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.software.cms.service.CategoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see CategoryLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.software.cms.model.Category", service = AopService.class)
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.software.cms.service.CategoryLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.software.cms.service.CategoryLocalServiceUtil</code>.
	 */

	public Category createCategory(long userId, String lang, long groupId, String title, long parentId,
			String description, int thuTu, String duongDan, String cateChild) throws Exception {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Saigon"));

		Date date = new Date();
		long categoryId = counterLocalService.increment();
		Category cate = categoryPersistence.create(categoryId);

		cate.setUuid(PortalUUIDUtil.generate());
		cate.setTitle(title);
		cate.setDescription(description);
		cate.setPath("/");
		cate.setParentId(parentId);
		cate.setActive(0);
		cate.setIsRss(true);
		cate.setThuTu(thuTu);
		cate.setLink(duongDan);
		cate.setCateChild(cateChild);
		cate.setCreatedDate(date);
		cate.setCreatedUser(userId);
		cate.setLanguage(lang);
		cate.setDisplay(true);
		cate.setGroupId(groupId);
		cate.setModifiedDate(date);
		cate.setModifiedUser(userId);

		return categoryPersistence.update(cate);

	}

	public Category updateCategory(long userId, String lang, long groupId, long parentId, long cateId, String title,
			String description, int thuTu, String duongDan, String cateChild) throws Exception {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Saigon"));

		Date date = new Date();
		Category cate = getCategory(cateId);
		cate.setTitle(title);
		cate.setDescription(description);
		cate.setPath("/");
		if (parentId != -1)
			cate.setParentId(parentId);
		cate.setThuTu(thuTu);
		cate.setLink(duongDan);
		cate.setCateChild(cateChild);
		cate.setCreatedDate(date);
		cate.setCreatedUser(userId);
		cate.setLanguage(lang);
		cate.setDisplay(true);
		cate.setGroupId(groupId);
		cate.setModifiedDate(date);
		cate.setModifiedUser(userId);

		return categoryPersistence.update(cate);
	}

	public int getMax(long userId, String lang, long groupId, long parentId) {
		Session session = null;
		int max = -1;
		try {
			session = this.categoryPersistence.openSession();
			
			String sqlCountMax = "select count(*) from soft_cms_category";
			SQLQuery queryCountMax = session.createSQLQuery(sqlCountMax);
			queryCountMax.setCacheable(false);
			QueryPos.getInstance(queryCountMax);
			if (queryCountMax.list().size() > 0)
				return Integer.parseInt(queryCountMax.list().get(0).toString());

			String sqlExists = "select count(*) from soft_cms_category where categoryid = " + parentId + "";
			SQLQuery queryEx = session.createSQLQuery(sqlExists.toString());
			queryEx.setCacheable(false);
			QueryPos.getInstance(queryEx);
			int resultEx = 0;
			if (queryEx.list().size() > 0)
				resultEx = Integer.parseInt(queryEx.list().get(0).toString());

			String sql = "select max(thutu) from soft_cms_category where \n" + "groupid = " + groupId
					+ " and language = '" + lang + "' \n" + "and  parentid = " + parentId + " group by parentid";

			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			QueryPos.getInstance(query);
			if (query.list().size() > 0 && resultEx > 0) {
				max = Integer.parseInt(query.list().get(0).toString());
			} else if (query.list().size() == 0 && resultEx > 0) {
				max = 0;
			} else if (query.list().size() > 0 && parentId == 0 && resultEx == 0) {
				max = Integer.parseInt(query.list().get(0).toString());
			}
			return max;
		} catch (Exception e) {
			max = -1;
		} finally {
			this.categoryPersistence.closeSession(session);
		}
		return max;
	}

	public List<Category> getCategoryHaveParentId(long groupid, String language, long parentid) throws SystemException {
		List<Category> tmp = new ArrayList<Category>();
		tmp = categoryPersistence.findByGroup_Language_Parent(groupid, language, parentid);
		return tmp;
	}

	public void doDeleteCategory(Category category) throws SystemException {
		deleteCategory(category);
	}

	public List<Category> searchCategoryHaveGroupLanguge(long groupId, String language, String key) {
		List<Category> list = new ArrayList<Category>();
		Session session = null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "select * from soft_cms_category where soft_cms_category.groupid = ? AND soft_cms_category.language=? AND LOWER(title) like LOWER(?)";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Category", CategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			qPos.add(language);
			qPos.add("%" + key + "%");
			list = (List<Category>) query.list();
		} catch (Exception e) {
			list = new ArrayList<Category>();
		} finally {
			this.categoryPersistence.closeSession(session);
		}
		return list;
	}

	public List<Category> searchByArticle(long articleId) {
		List<Category> result = new ArrayList<Category>();
		Session session = null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "SELECT soft_cms_category.* FROM soft_cms_category,soft_cms_categoryarticle "
					+ "WHERE soft_cms_categoryarticle.articleid = ? AND soft_cms_categoryarticle.categoryid = soft_cms_category.categoryid";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_category", CategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(articleId);
			result.addAll(query.list());
		} catch (Exception e) {
			// e.printStackTrace();
			result = new ArrayList<Category>();
		} finally {
			this.categoryPersistence.closeSession(session);
		}
		return result;
	}

	public Category ceate() {
		return new CategoryImpl();
	}

	public List<Category> getCateTheoSQL(String sqlQuery) {
		List<Category> danhSachCate = null;
		Session session = null;
		try {
			session = this.categoryPersistence.openSession();

			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.setCacheable(false);
			query.addEntity("soft_cms_category", CategoryImpl.class);
			danhSachCate = (List<Category>) query.list();
		} catch (Exception e) {
			danhSachCate = null;
		} finally {
			this.categoryPersistence.closeSession(session);
		}

		return danhSachCate;
	}

	public List<Long> getAllChild(long parentid) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<Category> list = this.categoryPersistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Iterator<Category> iterator = list.iterator(); iterator.hasNext();) {
			Category element = iterator.next();
			if (element.getParentId() == parentid)
				result.add(element.getCategoryId());
		}

		return result;
	}

	public List<Category> getNode(long parentId, long groupId, String language, String title, int start, int limit)
			throws Exception {
		Session session = null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "select * from soft_cms_category where groupid=" + groupId + " and language='" + language
					+ "' and parentid=" + parentId + " and title like '%" + title + "%' order by thutu asc  ";
			if (start != -1 && limit != -1) {
				sql += "offset " + start + " limit " + limit + "";
			}

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Category", CategoryImpl.class);
			return query.list();
		} finally {
			this.categoryPersistence.closeSession(session);
		}

	}

	public int getNodeCount(long parentId, long groupId, String language, String title) throws Exception {
		Session session = null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "select count(*) from soft_cms_category where groupid=" + groupId + " and language='"
					+ language + "' and parentid=" + parentId + " and title like '%" + title + "%' ";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			return Integer.parseInt(query.list().get(0).toString());
		} finally {
			this.categoryPersistence.closeSession(session);
		}

	}

	public List<Long> getAllChild(long parentId, long groupId, String language) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<Category> listCategory = new ArrayList<Category>();
		Session session = null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "select * from soft_cms_category where groupid=" + groupId + " and language='" + language
					+ "' and parentid=" + parentId + " order by thutu asc";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Category", CategoryImpl.class);
			listCategory = (List<Category>) query.list();
			if (listCategory != null && listCategory.size() > 0) {
				for (int i = 0; i < listCategory.size(); i++) {
					result.add(listCategory.get(i).getCategoryId());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.categoryPersistence.closeSession(session);
		}
		return result;
	}

	public List<Long> getAllChildNew(long parentId, long groupId, String language) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<Category> list = this.categoryPersistence.findByGroup_Language(groupId, language);
		for (Iterator<Category> iterator = list.iterator(); iterator.hasNext();) {
			Category element = iterator.next();
			result.add(element.getCategoryId());
		}

		return result;
	}

	public List<Category> searchByCategoryName(String name, long groupid, String language) {
		List<Category> listCategory = new ArrayList<Category>();
		Session session = null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "select * from soft_cms_category where groupid = " + groupid + " AND language = '" + language
					+ "' AND LOWER(title) like LOWER(?) limit 100";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Category", CategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add("%" + name + "%");
			listCategory = (List<Category>) query.list();
		} catch (Exception e) {
			// TODO: handle exception
			listCategory = new ArrayList<Category>();
		} finally {
			this.categoryPersistence.closeSession(session);
		}
		return listCategory;
	}

	public int getCountByLanguage(long groupId, String language) {
		Long count = 0L;
		Session session = null;
		StringBuffer sql = new StringBuffer();
		try {

			sql.append("SELECT COUNT(soft_cms_category.*) FROM soft_cms_category ");
			sql.append(" WHERE soft_cms_category.groupid = " + groupId + " AND soft_cms_category.language = '"
					+ language + "'");

			session = this.categoryPersistence.openSession();
			SQLQuery q = session.createSQLQuery(sql.toString());
			Iterator<java.math.BigInteger> itr = q.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}

		} catch (Exception e) {
			count = 0L;

		} finally {
			this.categoryPersistence.closeSession(session);
		}

		// System.out.println("----------------------------------------------------------------------------------------------------------");
		return count.intValue();
	}

	public int getMaxId() {
		Long count = 0L;
		Session session = null;
		String sql = "select max(categoryid) from soft_cms_category";
		try {
			session = this.categoryPersistence.openSession();
			SQLQuery q = session.createSQLQuery(sql);
			Iterator<java.math.BigInteger> itr = q.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}

		} catch (Exception e) {
			count = 0L;

		} finally {
			this.categoryPersistence.closeSession(session);
		}

		// System.out.println("----------------------------------------------------------------------------------------------------------");
		return count.intValue();
	}

	@Override
	public Category createCategory(long categoryId) {
		Category tg = null;
		try {
			tg = this.getCategory(categoryId);
		} catch (Exception ex) {
			tg = null;
		}
		if (tg != null) {
			categoryId = this.getMaxId() + 1;
			tg = null;
		}
		return categoryPersistence.create(categoryId);
	}

	public Category create() {
		return new CategoryImpl();
	}
}
