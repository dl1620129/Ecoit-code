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
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.software.cms.service.CategoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see CategoryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.software.cms.model.Category",
	service = AopService.class
)
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.software.cms.service.CategoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.software.cms.service.CategoryLocalServiceUtil</code>.
	 */
	public Category prepCategory(ThemeDisplay themeDisplay, String action, int parentId, long id, String title,
			String description, int thuTu, String duongDan) throws SystemException, PortalException {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Saigon"));
		Category cate = null;
		Category catePa = null;
		Date date = new Date();
		if (action.equals("add")) {
			long categoryId = counterLocalService.increment();
			cate = categoryPersistence.create(categoryId);
		}
		
		if (action.equals("edit")) {
			cate = getCategory(id);
		}
		
		cate.setTitle(title);
		cate.setDescription(description);
		cate.setPath("/");
		
		if (action.equals("edit") && parentId > 0) {
			if (cate.getParentId() > 0) {
				
				catePa = getCategory(cate.getParentId());
				String str = "";
				
				if (!catePa.getCateChild().equals("")) {
					for (String st : catePa.getCateChild().split(",")) {
						
						if (cate.getCategoryId() != Long.valueOf(st)) {
							
							if (str.equals("")) {
								str = st;
							} else {
								str += "," + st;
								System.out.println(str);
							}
						}
					}
					
					catePa.setCateChild(str);
					categoryPersistence.update(catePa);
				}
			}
		}

		cate.setParentId(parentId);
		cate.setThuTu(thuTu);
		cate.setLink(duongDan);

		if (action.equals("add")) {
			cate.setCreatedDate(date);
			cate.setCreatedUser(themeDisplay.getUserId());
			cate.setLanguage(themeDisplay.getLocale().toString());
			cate.setDisplay(true);
			cate.setGroupId(themeDisplay.getScopeGroupId());
		}
		
		cate.setModifiedDate(date);
		cate.setModifiedUser(themeDisplay.getUserId());
		
		categoryPersistence.update(cate);
		
		return cate;
	}
	
	public List<Category> getCategoryHaveParentId(long groupid, String language, long parentid) throws SystemException {
		List<Category> tmp = new ArrayList<Category>();
		tmp = categoryPersistence.findByGroup_Language_Parent(groupid, language, parentid);
		return tmp;
	}

	public void doDeleteCategory(Category category) throws SystemException {
		deleteCategory(category);
	}

	public List<Category> searchCategory(String key) {
		List<Category> list = new ArrayList<Category>();
		Session session=null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "select * from soft_cms_category where soft_cms_article.groupid = ? AND soft_cms_article.language=? AND title like ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Category", CategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add("%"+key+"%");
			list= (List<Category>)query.list();
		} catch (Exception e) {
			list = new ArrayList<Category>();
		}
        finally{
        	this.categoryPersistence.closeSession(session);
        }
		return list;
	}

	public List<Category> searchCategoryHaveGroupLanguge(long groupId, String language, String key) {
		List<Category> list = new ArrayList<Category>();
		Session session=null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "select * from soft_cms_category where soft_cms_category.groupid = ? AND soft_cms_category.language=? AND LOWER(title) like LOWER(?)";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Category", CategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			qPos.add(language);
			qPos.add("%"+key+"%");
			list= (List<Category> )query.list();
		} catch (Exception e) {
			list = new ArrayList<Category>();
		}
		finally{
        	this.categoryPersistence.closeSession(session);
        }
		return list;
	}

	public List<Category> searchByArticle(long articleId) {
		List<Category> result = new ArrayList<Category>();
		Session session=null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "SELECT soft_cms_category.* FROM soft_cms_category,soft_cms_categoryarticle " +
					"WHERE soft_cms_categoryarticle.articleid = ? AND soft_cms_categoryarticle.categoryid = soft_cms_category.categoryid";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_category", CategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(articleId);
			result.addAll(query.list());
		} catch (Exception e) {
			//e.printStackTrace();
			result = new ArrayList<Category>();
		}
		finally{
        	this.categoryPersistence.closeSession(session);
        }
		return result;
	}
	public Category ceate(){
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
	public List<Long> getAllChild(long parentid) throws Exception
	{
		List<Long> result = new ArrayList<Long>();
		List<Category> list = this.categoryPersistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Iterator<Category> iterator = list.iterator(); iterator.hasNext();) {
			Category element = iterator.next();
			if (element.getParentId() == parentid) result.add(element.getCategoryId());
		}

		return result;
	}
	public List<Long> getAllChild(long parentId,long groupId,String language) throws Exception
	{
		List<Long> result = new ArrayList<Long>();
		List<Category> listCategory = new ArrayList<Category>();
		Session session =null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "select * from soft_cms_category where groupid="+groupId+" and language='"+language+"' and parentid="+parentId +" order by thutu asc";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Category", CategoryImpl.class);
			listCategory= (List<Category> )query.list();
			if(listCategory!=null && listCategory.size()>0){
				for(int i=0;i<listCategory.size();i++){
					result.add(listCategory.get(i).getCategoryId());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
        finally {
        	this.categoryPersistence.closeSession(session);
		}
		return result;
	}
	public List<Long> getAllChildNew(long parentId,long groupId,String language) throws Exception
	{
		List<Long> result = new ArrayList<Long>();
		List<Category> list = this.categoryPersistence.findByGroup_Language(groupId, language);
		for (Iterator<Category> iterator = list.iterator(); iterator.hasNext();) {
			Category element = iterator.next();
			result.add(element.getCategoryId());
		}

		return result;
	}
	public List<Category> searchByCategoryName(String name,long groupid, String language) {
		List<Category> listCategory = new ArrayList<Category>();
		Session session =null;
		try {
			session = this.categoryPersistence.openSession();
			String sql = "select * from soft_cms_category where groupid = "+groupid+" AND language = '"+language+"' AND LOWER(title) like LOWER(?) limit 100";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Category", CategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add("%"+name+"%");
			listCategory= (List<Category> )query.list();
		} catch (Exception e) {
			// TODO: handle exception
			listCategory = new ArrayList<Category>();
		}
        finally {
        	this.categoryPersistence.closeSession(session);
		}
		return listCategory;
	}
	public int getCountByLanguage(long groupId, String language){
		Long count = 0L;
		Session session = null;
		StringBuffer sql = new StringBuffer();
		try {

			sql.append("SELECT COUNT(soft_cms_category.*) FROM soft_cms_category ");
			sql.append(" WHERE soft_cms_category.groupid = " + groupId
					+ " AND soft_cms_category.language = '" + language + "'") ;
					
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
	public int getMaxId(){
		Long count = 0L;
		Session session = null;
		String sql="select max(categoryid) from soft_cms_category";
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
		Category tg=null;
		try{
			tg=this.getCategory(categoryId);
		}
		catch(Exception ex){
			tg=null;
		}
		if(tg!=null){
			categoryId=this.getMaxId()+1;
			tg=null;
		}
		return categoryPersistence.create(categoryId);
	}
	public Category create(){
		return new CategoryImpl();
	}
}