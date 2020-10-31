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

import com.ecoit.elegaldocument.exception.NoSuchLegalTypeException;
import com.ecoit.elegaldocument.model.LegalDTypeRel;
import com.ecoit.elegaldocument.model.LegalType;
import com.ecoit.elegaldocument.model.impl.LegalTypeImpl;
import com.ecoit.elegaldocument.service.base.LegalTypeLocalServiceBaseImpl;
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
 * The implementation of the legal type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.LegalTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see LegalTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.elegaldocument.model.LegalType",
	service = AopService.class
)
public class LegalTypeLocalServiceImpl extends LegalTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.elegaldocument.service.LegalTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.elegaldocument.service.LegalTypeLocalServiceUtil</code>.
	 */
	
	public List<LegalType> getNode(long parentId, long groupId, long companyId, String language, String name, int start, int limit)
			throws Exception {
		Session session = null;
		try {
			session = this.legalTypePersistence.openSession();
			String sql = "select * from ecoit_doc_legaltype where groupid = :groupId and language = :language"
			        + " AND companyid = :companyId AND parentid = :parentId AND lower(name) like lower(:name) order by position, createddate asc offset :start";

			SQLQuery query = session.createSQLQuery(sql);
			query.setLong("groupId", groupId);
			query.setString("language", language);
			query.setLong("companyId", companyId);
			query.setLong("parentId", parentId);
			query.setString("name", "%" + name + "%");
			query.setInteger("start", start);
			if (limit > 0) {
				query.setMaxResults(limit);
			}

			query.setCacheable(false);
			query.addEntity(" LegalType", LegalTypeImpl.class);
			return query.list();
		} finally {
			this.legalTypePersistence.closeSession(session);
		}
	}
	
	public int getNodeCount(long parentId, long groupId, long companyId, String language, String name) {
		Session session = null;
		int count = 0;
		try {
			session = this.legalTypePersistence.openSession();
			String sql = "select count(*) from ecoit_doc_legaltype where groupid = :groupId and language = :language"
			        + " AND companyid = :companyId AND parentid = :parentId AND lower(name) like lower(:name)";
			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			query.setLong("groupId", groupId);
			query.setString("language", language);
			query.setLong("companyId", companyId);
			query.setLong("parentId", parentId);
			query.setString("name", "%" + name + "%");
			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} catch (Exception e) {
			count = 0;
		} finally {
			this.ecmsGroupPersistence.closeSession(session);
		}
		return count;
	}
	
	public void createUpdateLegalType(long legalTypeId, long groupId, long companyId, long userId, String name, String description, 
			String language, boolean statusType, int position, long parentId) throws Exception {
		LegalType legalType = null;
		Date now = new Date();
		if (legalTypeId < 1) {
			legalTypeId = counterLocalService.increment();
			legalType = legalTypePersistence.create(legalTypeId);
			legalType.setCreatedDate(now);
			legalType.setCreatedByUser(userId);
		} else {
			legalType = legalTypePersistence.findByTypeId(legalTypeId);	
		}
		
		legalType.setGroupId(groupId);
		legalType.setCompanyId(companyId);
		legalType.setLanguage(language);
		legalType.setName(name);
		legalType.setDescription(description);
		legalType.setStatusType(statusType);
		legalType.setPosition(position);
		legalType.setParentId(parentId);
		legalType.setRssable(false);
		legalType.setModifiedDate(now);
		legalType.setModifiedByUser(userId);
		legalTypePersistence.update(legalType);
	}
	
	public int getMax(String lang, long groupId, long parentId, long companyId) {
		Session session = null;
		int max = 0;
		try {
			session = this.legalTypePersistence.openSession();

			String sqlCountMax = "select MAX(position) from ecoit_doc_legaltype where parentid = :parentId AND companyid = :companyId AND groupid = :groupId";
			SQLQuery queryCountMax = session.createSQLQuery(sqlCountMax);
			queryCountMax.setLong("parentId", parentId);
			queryCountMax.setLong("companyId", companyId);
			queryCountMax.setLong("groupId", groupId);
			queryCountMax.setCacheable(false);
			QueryPos.getInstance(queryCountMax);
			if (queryCountMax.list().size() > 0)
				max = Integer.parseInt(queryCountMax.list().get(0).toString());

			return max;
		} catch (Exception e) {
			max = 0;
		} finally {
			this.legalTypePersistence.closeSession(session);
		}
		return max;
	}
	
	public List<LegalType> getAllTypes() {
		Session session = null;
		try {
			session = this.legalTypePersistence.openSession();
			String sql = "select * from ecoit_doc_legaltype order by position, createddate asc ";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("LegalType", LegalTypeImpl.class);
			return query.list();
		} finally {
			this.legalTypePersistence.closeSession(session);
		}
	}
	
	public List<LegalType> getPublishTypes(long parentId, String language, boolean statusType, long groupId) {
		Session session = null;
		try {
			session = this.legalTypePersistence.openSession();
			String sql = "select * from ecoit_doc_legaltype WHERE parentid = :parentId AND language = :language AND statustype = :statusType AND groupid = :groupId "
					+ "order by position, createddate asc";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.setString("language", language);
			query.setLong("parentId", parentId);
			query.setLong("groupId", groupId);
			query.setBoolean("statusType", statusType);
			query.addEntity("LegalType", LegalTypeImpl.class);
			return query.list();
		} finally {
			this.legalTypePersistence.closeSession(session);
		}
	}
	
	public List<LegalType> getByDocumentId(long documentId) {
		List<LegalDTypeRel> legalDTypeRelsList = legalDTypeRelPersistence.findByDoc(documentId);
		List<LegalType> legalTypesList = new ArrayList<>();
		if (legalDTypeRelsList != null) {
			for (LegalDTypeRel legalDTypeRel : legalDTypeRelsList) {
				try {
					legalTypesList.add(legalTypePersistence.findByTypeId(legalDTypeRel.getTypeId()));
				} catch (NoSuchLegalTypeException e) {
				}
			}
		}
		return legalTypesList;
	}
}