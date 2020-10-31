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

package com.ecoit.elegaldocument.service.impl;

import com.ecoit.elegaldocument.model.LegalField;
import com.ecoit.elegaldocument.model.impl.LegalFieldImpl;
import com.ecoit.elegaldocument.service.base.LegalFieldLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the legal field local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.LegalFieldLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see LegalFieldLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.elegaldocument.model.LegalField",
	service = AopService.class
)
public class LegalFieldLocalServiceImpl extends LegalFieldLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.elegaldocument.service.LegalFieldLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.elegaldocument.service.LegalFieldLocalServiceUtil</code>.
	 */
	
	public List<LegalField> getListLegalField(String name, long groupId, String language, long companyId, int start, int limit) {
		List<LegalField> legalFieldsList = new ArrayList<>();
		Session session = null;
		try {
			session = this.legalFieldPersistence.openSession();
			String sql = "SELECT * FROM ecoit_doc_legalfield WHERE groupid = :groupId AND companyid = :companyId AND language = :language AND lower(name) like lower(:q) "
			         + "order by position, createddate asc offset :start";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_legalfield", LegalFieldImpl.class);
			query.setLong("groupId", groupId);
			query.setLong("companyId", companyId);
			query.setString("language", language);
			query.setString("q", "%" + name + "%");
			query.setInteger("start", start);
			if (limit > 0) {
				query.setMaxResults(limit);		
			}
			
			QueryPos.getInstance(query);
			legalFieldsList = query.list();
			
		} finally {
			this.legalFieldPersistence.closeSession(session);
		}
		return legalFieldsList;
	}
	
	public int countTotalLegalField(long groupId, String language, long companyId, String name) {
		Session session = null;
		int count = 0;
		try {
			session = this.legalFieldPersistence.openSession();
			String sql = "SELECT count(*) FROM ecoit_doc_legalfield WHERE groupid = :groupId AND companyid = :companyId AND language = :language AND lower(name) like lower(:name)";
			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			query.setLong("groupId", groupId);
			query.setLong("companyId", companyId);
			query.setString("language", language);
			query.setString("name", "%" + name + "%");
			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} catch (Exception e) {
			count = 0;
		} finally {
			this.legalFieldPersistence.closeSession(session);
		}
		return count;
	}
	
	public void createUpdateLegalField(long userId, long scopeGroupId, String language, long companyId, long fieldId, String name, String description, boolean isStatusField,
			int position) throws Exception {
		LegalField legalField = null;
		Date now = new Date();
		if (fieldId < 1) {
			fieldId = counterLocalService.increment();
			legalField = legalFieldPersistence.create(fieldId);

			legalField.setCreatedDate(now);
			legalField.setCreatedByUser(userId);
		} else {
			legalField = legalFieldPersistence.fetchByFieldId(fieldId);
		}
		
		legalField.setGroupId(scopeGroupId);
		legalField.setLanguage(language);
		legalField.setCompanyId(companyId);
		legalField.setFieldId(fieldId);
		legalField.setName(name);
		legalField.setDescription(description);
		legalField.setStatusField(isStatusField);
		legalField.setPosition(position);
		legalField.setModifiedDate(now);
		legalField.setModifiedByUser(userId);
		legalFieldPersistence.update(legalField);
	}
	
	public int getMax(String language, long groupId, long companyId) {
		Session session = null;
		int max = 0;
		try {
			session = this.legalFieldPersistence.openSession();

			String sqlCountMax = "SELECT MAX(position) FROM ecoit_doc_legalfield WHERE groupid = :groupId AND companyid = :companyId AND language = :language";
			SQLQuery queryCountMax = session.createSQLQuery(sqlCountMax);
			queryCountMax.setLong("groupId", groupId);
			queryCountMax.setLong("companyId", companyId);
			queryCountMax.setString("language", language);
			queryCountMax.setCacheable(false);
			QueryPos.getInstance(queryCountMax);
			if (queryCountMax.list().size() > 0)
				max = Integer.parseInt(queryCountMax.list().get(0).toString());

			return max;
		} catch (Exception e) {
			max = 0;
		} finally {
			this.legalFieldPersistence.closeSession(session);
		}
		return max;
	}
	
	public List<LegalField> getAllFields() {
		Session session = null;
		try {
			session = this.legalFieldPersistence.openSession();
			String sql = "select * from ecoit_doc_legalfield order by position, createddate asc";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("LegalField", LegalFieldImpl.class);
			return query.list();
		} finally {
			this.legalFieldPersistence.closeSession(session);
		}
	}
	
	public List<LegalField> getPublishFields(String language, boolean statusField, long groupId) {
		Session session = null;
		try {
			session = this.legalFieldPersistence.openSession();
			String sql = "select * from ecoit_doc_legalfield WHERE language = :language AND statusfield = :statusField AND groupid = :groupId "
					+ "order by position, createddate asc";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("LegalField", LegalFieldImpl.class);
			query.setLong("groupId", groupId);
			query.setBoolean("statusField", statusField);
			query.setString("language", language);
			return query.list();
		} finally {
			this.legalFieldPersistence.closeSession(session);
		}
	}
}