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
import com.software.cms.model.Tag;
import com.software.cms.model.impl.TagImpl;
import com.software.cms.service.base.TagLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the tag local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.software.cms.service.TagLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see TagLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.software.cms.model.Tag",
	service = AopService.class
)
public class TagLocalServiceImpl extends TagLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.software.cms.service.TagLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.software.cms.service.TagLocalServiceUtil</code>.
	 */
	public List<Tag> getListTag(String sql, int start, int end){
		try {
			return tagFinder.getListTag(sql, start, end);
		} catch (Exception e) {
			return null;
		}
	}
	public int getCountByTag(String sql) {
		try {
			return tagFinder.getCountByTag(sql);
		} catch (Exception e) {
			return 0;
		}
	}
	public List<Tag> searchTagByGroupIdAndLanguage(long groupId, String language) {
		try {
			return this.tagPersistence.findByGroup_Language(groupId, language);
		} catch (SystemException e) {
			return new ArrayList<Tag>();
		}
	}
	public List<Tag> searchByTagName(String name,long groupid,String language) {
		List<Tag> listTag = new ArrayList<Tag>();
		Session session=null;
		try {
			session = this.tagPersistence.openSession();
			String sql = "select * from soft_cms_tag where groupid = "+groupid+" AND language = '"+language+"' AND  LOWER(tagname) like LOWER('%"+name+"%') limit 50";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Tag", TagImpl.class);
			listTag=(List<Tag>)query.list();
		} catch (Exception e) {
		}
		finally{
			this.tagPersistence.closeSession(session);
		}
		return listTag;
	}
	public List<Tag> searchByArticle(long articleId) {
		List<Tag> result = new ArrayList<Tag>();
		Session session=null;
		try {
			session = this.tagPersistence.openSession();
			String sql = "SELECT soft_cms_tag.* FROM ecoit_cms_tag,ecoit_cms_articletag " +
					"WHERE soft_cms_articletag.articleid = ? AND ecoit_cms_articletag.tagid = ecoit_cms_tag.tagid";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_tag", TagImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(articleId);
			result.addAll(query.list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.tagPersistence.closeSession(session);
		}
		return result;
	}
	public int getCountByTagName(long groupId, String language, String tagname){
		Long count = 0L;
		Session session = null;
		StringBuffer sql = new StringBuffer();
		try {

			sql.append("SELECT COUNT(soft_cms_tag.*) FROM soft_cms_tag ");
			sql.append(" WHERE soft_cms_tag.groupid = " + groupId
					+ " AND soft_cms_tag.language = '" + language + "'"
					+ " AND lower(soft_cms_tag.tagname) like '%" + tagname.toLowerCase()+"%'");
            session = this.tagPersistence.openSession();
			SQLQuery q = session.createSQLQuery(sql.toString());
			Iterator<java.math.BigInteger> itr = q.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}
			
		} catch (Exception e) {
			count = 0L;
			
		} finally {
			this.tagPersistence.closeSession(session);
		}

		// System.out.println("----------------------------------------------------------------------------------------------------------");
		return count.intValue();
	}
	public int getMaxId(String sql){
		Long count = 0L;
		Session session = null;
		try {
            session = this.tagPersistence.openSession();
			SQLQuery q = session.createSQLQuery(sql);
			Iterator<java.math.BigInteger> itr = q.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}
			
		} catch (Exception e) {
			count = 0L;
			
		} finally {
			this.tagPersistence.closeSession(session);
		}

		// System.out.println("----------------------------------------------------------------------------------------------------------");
		return count.intValue();
	}
	public Tag create(){
		return new TagImpl();
	}
}