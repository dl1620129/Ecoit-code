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

import com.ecoit.elegaldocument.model.LegalType;
import com.ecoit.elegaldocument.model.impl.LegalTypeImpl;
import com.ecoit.elegaldocument.service.base.LegalTypeServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the legal type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ecoit.elegaldocument.service.LegalTypeService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Liverpool
 * @see LegalTypeServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=ecoit_doc",
		"json.web.service.context.path=LegalType" }, service = AopService.class)
public class LegalTypeServiceImpl extends LegalTypeServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>com.ecoit.elegaldocument.service.LegalTypeServiceUtil</code> to access
	 * the legal type remote service.
	 */

	
	public LegalType findByPrimaryKey(long typeID) throws Exception {
		return this.legalTypePersistence.findByTypeId(typeID);
	}

	/* Add Legal Type */
	
	public LegalType addType(long groupid, long companyid, long userid, long createdbyuser, String name,
			String description, String language, boolean statustype, boolean rssable, int position) throws Exception {
		long legTypeID = CounterLocalServiceUtil.increment(LegalType.class.getName());
		LegalType type = null;
		try {
			type = this.findByPrimaryKey(legTypeID);
		} catch (Exception ex) {
			type = null;
		}
		if (type != null) {
			legTypeID = this.getCountDocumentBySQL("Select max(typeid) from ecoit_doc_legaltype") + 1;
			type = null;
		}
		type = this.legalTypePersistence.create(legTypeID);
		type.setGroupId(groupid);
		type.setCompanyId(companyid);
		type.setCreatedByUser(getUserId());
		type.setCreatedDate(new Date());
		type.setName(name);
		type.setDescription(description);
		type.setLanguage(language);
		type.setStatusType(statustype);
		type.setRssable(rssable);
		type.setPosition(position);
		type = this.legalTypePersistence.update(type);
		return type;
	}

	public LegalType addType(long groupid, long companyid, long userid, long createdbyuser, String name,
			String description, String language, boolean statustype, boolean rssable, int position, long parentId)
			throws Exception {
		long legTypeID = CounterLocalServiceUtil.increment(LegalType.class.getName());
		LegalType type = null;
		try {
			type = this.findByPrimaryKey(legTypeID);
		} catch (Exception ex) {
			type = null;
		}
		if (type != null) {
			legTypeID = this.getCountDocumentBySQL("Select max(typeid) from ecoit_doc_legaltype") + 1;
			type = null;
		}
		type = this.legalTypePersistence.create(legTypeID);
		type.setGroupId(groupid);
		type.setCompanyId(companyid);
		type.setCreatedByUser(getUserId());
		type.setCreatedDate(new Date());
		type.setName(name);
		type.setDescription(description);
		type.setLanguage(language);
		type.setStatusType(statustype);
		type.setRssable(rssable);
		type.setPosition(position);
		type.setParentId(parentId);
		type = this.legalTypePersistence.update(type);
		return type;
	}

	public LegalType addType(long typeID, long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language, boolean statustype, boolean rssable, int position,
			long parentId) throws Exception {
		LegalType type = this.legalTypePersistence.create(typeID);
		type.setGroupId(groupid);
		type.setCompanyId(companyid);
		type.setCreatedByUser(getUserId());
		type.setCreatedDate(new Date());
		type.setName(name);
		type.setDescription(description);
		type.setLanguage(language);
		type.setStatusType(statustype);
		type.setRssable(rssable);
		type.setPosition(position);
		type.setParentId(parentId);
		type = this.legalTypePersistence.update(type);
		return type;
	}

	/* Update LegalType */
	
	public LegalType updateType(long typeID, long createdbyuser, long modifiedbyuser, String name,
			String description, String language, boolean statustype, boolean rssable, int position) throws Exception {
		LegalType t = this.legalTypePersistence.findByPrimaryKey(typeID);
		t.setModifiedByUser(getUserId());
		t.setModifiedDate(new Date());
		t.setName(name);
		t.setDescription(description);
		t.setLanguage(language);
		t.setStatusType(statustype);
		t.setRssable(rssable);
		t.setPosition(position);
		t = this.legalTypePersistence.update(t);
		return t;
	}

	public LegalType updateType(long typeID, long createdbyuser, long modifiedbyuser, String name,
			String description, String language, boolean statustype, boolean rssable, int position, long parentId)
			throws Exception {
		LegalType t = this.legalTypePersistence.findByPrimaryKey(typeID);
		t.setModifiedByUser(getUserId());
		t.setModifiedDate(new Date());
		t.setName(name);
		t.setDescription(description);
		t.setLanguage(language);
		t.setStatusType(statustype);
		t.setRssable(rssable);
		t.setPosition(position);
		t.setParentId(parentId);
		t = this.legalTypePersistence.update(t);
		return t;
	}

	
	public LegalType updateCategory(LegalType param) throws Exception {
		return this.legalTypePersistence.update(param);

	}

	
	public void removeType(long typeID) throws Exception {
		this.legalTypePersistence.remove(typeID);
	}

	
	public int countAll(long groupId, long companyId) throws Exception {
		return this.legalTypePersistence.findByFindAll(groupId, companyId).size();
	}

	
	public boolean checkStatusByPrimaryKey(long tID) throws Exception {
		LegalType l = this.legalTypePersistence.findByPrimaryKey(tID);
		return l.getStatusType();
	}

	
	public List<LegalType> findAll(long groupId, long companyId) throws Exception {
		List<LegalType> list = new ArrayList<LegalType>();
		list = this.legalTypePersistence.findByFindAll(groupId, companyId);
		return list;
	}

	public List<LegalType> findAll(long groupId, long companyId, String language) throws Exception {
		List<LegalType> list = new ArrayList<LegalType>();
		list = this.legalTypePersistence.findByG_C_L(groupId, companyId, language);
		return list;
	}

	public List<LegalType> findByStatus(long groupId, long companyId, boolean statusType) throws Exception {
		List<LegalType> list = new ArrayList<LegalType>();
		list = this.legalTypePersistence.findByFindGroup(groupId, companyId, statusType);
		return list;

	}

	public List<LegalType> findByStatus(long groupId, long companyId, String language, boolean statusType)
			throws Exception {
		List<LegalType> list = new ArrayList<LegalType>();
		list = this.legalTypePersistence.findByG_C_L_S(groupId, companyId, language, statusType);
		return list;

	}

	public LegalType getType(long typeID) throws Exception {
		return this.legalTypePersistence.findByPrimaryKey(typeID);
	}

	public List<Long> getAllChild(long parentId, long groupId, long companyId) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalType> list = this.legalTypePersistence.findByG_C_P(groupId, companyId, parentId);
		for (Iterator<LegalType> iterator = list.iterator(); iterator.hasNext();) {
			LegalType element = iterator.next();
			result.add(element.getTypeId());
		}

		return result;
	}

	public List<Long> getAllChild(long parentId, long groupId, long companyId, boolean statusType) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalType> list = this.legalTypePersistence.findByFindGroupCompanyParent(groupId, companyId, parentId,
				statusType);
		for (Iterator<LegalType> iterator = list.iterator(); iterator.hasNext();) {
			LegalType element = iterator.next();
			result.add(element.getTypeId());
		}

		return result;
	}

	public List<Long> getAllChild(long parentId, long groupId, long companyId, String language, boolean statusType)
			throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalType> list = this.legalTypePersistence.findByG_C_L_P_S(groupId, companyId, language, parentId,
				statusType);
		for (Iterator<LegalType> iterator = list.iterator(); iterator.hasNext();) {
			LegalType element = iterator.next();
			result.add(element.getTypeId());
		}

		return result;
	}

	public List<Long> getAllChild(long parentId) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalType> list = this.legalTypePersistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Iterator<LegalType> iterator = list.iterator(); iterator.hasNext();) {
			LegalType element = iterator.next();
			if (element.getParentId() == parentId)
				result.add(element.getTypeId());
		}
		return result;
	}

	public List<LegalType> getDocumentBySQL(String sql, int start, int end) {
		return this.getDocumentBySQL(sql, start, end);
	}

	public int getCountDocumentBySQL(String sql) throws SystemException {

		Long count = 0L;
		Session session = null;
		try {
			session = this.legalTypePersistence.openSession();
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

	public List<Long> getAllChild(long parentId, long groupId, String language) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalType> listCategory = new ArrayList<LegalType>();
		Session session = null;
		try {
			session = this.legalTypePersistence.openSession();
			String sql = "select * from ecoit_doc_legaltype where groupid=" + groupId + " and language='" + language
					+ "' and parentid=" + parentId + " and statustype = true order by position asc";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("LegalType", LegalTypeImpl.class);
			listCategory = (List<LegalType>) query.list();
			if (listCategory != null && listCategory.size() > 0) {
				for (int i = 0; i < listCategory.size(); i++) {
					result.add(listCategory.get(i).getTypeId());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.legalTypePersistence.closeSession(session);
		}
		return result;
	}

	public List<Object> getDuLieuTheoSql(String sqlQuery) {
		List<Object> results = new ArrayList<Object>();
		Session session = null;
		try {
			session = this.legalTypePersistence.openSession();

			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.setCacheable(false);
			results = (List<Object>) query.list();
		} catch (Exception e) {
			results = null;
		} finally {
			this.legalTypePersistence.closeSession(session);
		}

		return results;
	}
}