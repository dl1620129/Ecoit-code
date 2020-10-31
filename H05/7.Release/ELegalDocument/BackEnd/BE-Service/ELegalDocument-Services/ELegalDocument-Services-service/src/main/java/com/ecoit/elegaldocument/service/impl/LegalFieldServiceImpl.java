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
import com.ecoit.elegaldocument.service.base.LegalFieldServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the legal field remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ecoit.elegaldocument.service.LegalFieldService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Liverpool
 * @see LegalFieldServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=ecoit_doc",
		"json.web.service.context.path=LegalField" }, service = AopService.class)
public class LegalFieldServiceImpl extends LegalFieldServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>com.ecoit.elegaldocument.service.LegalFieldServiceUtil</code> to access
	 * the legal field remote service.
	 */

	public LegalField findByPrimaryKey(long fieldid) throws Exception {
		return this.legalFieldPersistence.findByFieldId(fieldid);
	}

	public LegalField addLegalField(long groupid, long companyid, long userid, long createdbyuser, String name,
			String description, String language, boolean statusfield, boolean rssable, int position) throws Exception {

		long legFieldID = CounterLocalServiceUtil.increment(LegalField.class.getName());
		LegalField field = null;
		try {
			field = this.findByPrimaryKey(legFieldID);
		} catch (Exception ex) {
			field = null;
		}
		if (field != null) {
			legFieldID = this.getCountDocumentBySQL("Select max(fieldid) from ecoit_doc_legalfield") + 1;
			field = null;
		}
		field = this.legalFieldPersistence.create(legFieldID);
		field.setGroupId(groupid);
		field.setCompanyId(companyid);
		// field.setUserId(getUserId());
		field.setCreatedByUser(getUserId());
		field.setCreatedDate(new Date());
		field.setName(name);
		field.setDescription(description);
		field.setLanguage(language);
		field.setRssable(rssable);
		field.setStatusField(statusfield);
		field.setPosition(position);
		field = this.legalFieldPersistence.update(field);
		return field;
	}

	public LegalField addLegalField(long fieldId, long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language, boolean statusfield, boolean rssable, int position)
			throws Exception {

		LegalField field = this.legalFieldPersistence.create(fieldId);
		field.setGroupId(groupid);
		field.setCompanyId(companyid);
		// field.setUserId(getUserId());
		field.setCreatedByUser(getUserId());
		field.setCreatedDate(new Date());
		field.setName(name);
		field.setDescription(description);
		field.setLanguage(language);
		field.setRssable(rssable);
		field.setStatusField(statusfield);
		field.setPosition(position);
		field = this.legalFieldPersistence.update(field);
		return field;
	}

	public LegalField updateLegalField(long legFieldID, long groupid, long companyid, long userid, long modifiedbyuser,
			String name, String description, String language, boolean statusfield, boolean rssable, int position)
			throws Exception {
		LegalField fiel = this.legalFieldPersistence.fetchByPrimaryKey(legFieldID);
		fiel.setGroupId(groupid);
		fiel.setCompanyId(companyid);
		fiel.setUserId(userid);
		fiel.setModifiedByUser(getUserId());
		fiel.setName(name);
		fiel.setDescription(description);
		fiel.setLanguage(language);
		fiel.setStatusField(statusfield);
		fiel.setRssable(rssable);
		fiel.setPosition(position);
		fiel = this.legalFieldPersistence.update(fiel);
		return fiel;
	}

	public LegalField updateLegalField(LegalField param) throws Exception {
		return this.legalFieldPersistence.update(param);
	}

	public List<LegalField> findAll(long groupId, long companyId) throws Exception {
		List<LegalField> list = new ArrayList<LegalField>();
		list = this.legalFieldPersistence.findByFindAll(groupId, companyId);
		return list;
	}

	public List<LegalField> findAll(long groupId, long companyId, String language) throws Exception {
		List<LegalField> list = new ArrayList<LegalField>();
		list = this.legalFieldPersistence.findByG_C_L(groupId, companyId, language);
		return list;
	}


	public int countAll(long groupId, long companyId) throws Exception {
		return this.legalFieldPersistence.findByFindAll(groupId, companyId).size();
	}

	public void removeFieldDB(long fiID) throws Exception {
		this.legalFieldPersistence.remove(fiID);
	}


	public boolean checkStatusByPrimaryKey(long FieldID) throws Exception {
		LegalField fil = this.legalFieldPersistence.findByPrimaryKey(FieldID);
		return fil.getStatusField();
	}

	public List<LegalField> findByStatusFIELD(long groupId, long companyId, boolean statusFIELD) throws Exception {
		List<LegalField> list = new ArrayList<LegalField>();
		list = this.legalFieldPersistence.findByFindGroup(groupId, companyId, statusFIELD);
		return list;

	}

	public List<LegalField> findByStatus(long groupId, long companyId, boolean statusField) throws Exception {
		List<LegalField> list = new ArrayList<LegalField>();
		list = this.legalFieldPersistence.findByFindGroup(groupId, companyId, statusField);
		return list;

	}

	public List<LegalField> findByStatus(long groupId, long companyId, String language, boolean statusField)
			throws Exception {
		List<LegalField> list = new ArrayList<LegalField>();
		list = this.legalFieldPersistence.findByG_C_L_S(groupId, companyId, language, statusField);
		return list;

	}

	public LegalField getFieldId(long fieldId) throws Exception {
		return this.legalFieldPersistence.findByPrimaryKey(fieldId);
	}

	public List<LegalField> getDocumentBySQL(String sql, int start, int end) {
		return this.getDocumentBySQL(sql, start, end);
	}

	public int getCountDocumentBySQL(String sql) throws SystemException {

		Long count = 0L;
		Session session = null;
		try {
			session = this.legalFieldPersistence.openSession();
			SQLQuery q = session.createSQLQuery(sql);
			Iterator<java.math.BigInteger> itr = q.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			if (count == null) {
				count = Long.valueOf(0);
			}

			if (session != null)
				session.close();
		}

		// System.out.println("----------------------------------------------------------------------------------------------------------");
		return count.intValue();
	}

	public List<Long> getAllChild(long groupId, String language) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalField> listField = new ArrayList<LegalField>();
		Session session = null;
		try {
			session = this.legalFieldPersistence.openSession();
			String sql = "select * from ecoit_doc_LegalField where groupid=" + groupId + " and language='" + language
					+ "' order by position asc";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("LegalField", LegalFieldImpl.class);
			listField = (List<LegalField>) query.list();
			if (listField != null && listField.size() > 0) {
				for (int i = 0; i < listField.size(); i++) {
					result.add(listField.get(i).getFieldId());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.legalFieldPersistence.closeSession(session);
		}
		return result;
	}
}