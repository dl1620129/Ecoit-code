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

import com.ecoit.elegaldocument.model.LegalSuggestDocument;
import com.ecoit.elegaldocument.model.impl.LegalSuggestDocumentImpl;
import com.ecoit.elegaldocument.service.base.LegalSuggestDocumentLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the legal suggest document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.LegalSuggestDocumentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see LegalSuggestDocumentLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.elegaldocument.model.LegalSuggestDocument",
	service = AopService.class
)
public class LegalSuggestDocumentLocalServiceImpl
	extends LegalSuggestDocumentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.elegaldocument.service.LegalSuggestDocumentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.elegaldocument.service.LegalSuggestDocumentLocalServiceUtil</code>.
	 */
	
	public void createUpdateSuggestion(long legalSuggestId, long docId, long groupId, String language, long userId, String userName, String email, String title, String content, boolean isApproved) {
		LegalSuggestDocument legalSuggest = null;
		Date now = new Date();
		if (legalSuggestId < 1) {
			legalSuggestId = counterLocalService.increment();
			legalSuggest = legalSuggestDocumentPersistence.create(legalSuggestId);
			legalSuggest.setCreatedDate(now);
		} else {
			legalSuggest = legalSuggestDocumentPersistence.fetchByPrimaryKey(legalSuggestId);
		}
		
		legalSuggest.setApproved(isApproved);
		legalSuggest.setGroupId(groupId);
		legalSuggest.setLanguage(language);
		legalSuggest.setModifiedByUser(userId);
		legalSuggest.setModifiedDate(now);
		legalSuggest.setVisitorName(userName);
		legalSuggest.setVisitorEmail(email);
		legalSuggest.setTitle(title);
		legalSuggest.setContent(content);
		legalSuggest.setDocId(docId);
		legalSuggestDocumentPersistence.update(legalSuggest);
	}
	
	public void approvedSuggestion(long sugId, boolean approved, long userId) {
		LegalSuggestDocument legalSuggest = legalSuggestDocumentPersistence.fetchByPrimaryKey(sugId);
		legalSuggest.setApproved(approved);
		legalSuggest.setApprovedByUser(userId);
		legalSuggest.setApprovedDate(new Date());
		legalSuggestDocumentPersistence.update(legalSuggest);
	}
	 
	public List<LegalSuggestDocument> getSuggestions(long docId, String language, int start, int limit) {
		Session session = null;
		try {
			session = this.legalSuggestDocumentPersistence.openSession();
			String sql = "select * from ecoit_doc_legalsuggestdocument where docid = :docId and language = :language order by modifieddate desc offset :start";

			SQLQuery query = session.createSQLQuery(sql);
			query.setLong("docId", docId);
			query.setString("language", language);
			query.setInteger("start", start);
			if (limit > 0) {
				query.setMaxResults(limit);
			}

			query.setCacheable(false);
			query.addEntity("ecoit_doc_legalsuggestdocument", LegalSuggestDocumentImpl.class);
			return query.list();
		} finally {
			this.legalSuggestDocumentPersistence.closeSession(session);
		}
	}
	
	public List<LegalSuggestDocument> getApprovedSuggestions(long docId, String language, boolean isApproved, int start, int limit) {
		Session session = null;
		try {
			session = this.legalSuggestDocumentPersistence.openSession();
			String sql = "select * from ecoit_doc_legalsuggestdocument where docid = :docId and language = :language AND approved = :isApproved order by modifieddate desc offset :start";

			SQLQuery query = session.createSQLQuery(sql);
			query.setLong("docId", docId);
			query.setString("language", language);
			query.setBoolean("isApproved", isApproved);
			query.setInteger("start", start);
			if (limit > 0) {
				query.setMaxResults(limit);
			}

			query.setCacheable(false);
			query.addEntity("ecoit_doc_legalsuggestdocument", LegalSuggestDocumentImpl.class);
			return query.list();
		} finally {
			this.legalSuggestDocumentPersistence.closeSession(session);
		}
	}
	
	public int countSuggestions(long docId, String language) {
		Session session = null;
		int count = 0;
		try {
			session = this.legalSuggestDocumentPersistence.openSession();
			String sql = "select count(*) from ecoit_doc_legalsuggestdocument where docid = :docId and language = :language";

			SQLQuery query = session.createSQLQuery(sql);
			query.setLong("docId", docId);
			query.setString("language", language);

			query.setCacheable(false);
			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} finally {
			this.legalSuggestDocumentPersistence.closeSession(session);
		}
		return count;
	}
	
	public void removeByDocId(long docId) {
		legalSuggestDocumentPersistence.removeBySuggByDocId(docId);
	}
}