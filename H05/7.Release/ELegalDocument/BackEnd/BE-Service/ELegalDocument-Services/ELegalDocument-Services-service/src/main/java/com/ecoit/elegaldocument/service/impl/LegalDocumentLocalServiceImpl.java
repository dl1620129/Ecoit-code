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

import com.ecoit.elegaldocument.model.DocumentAttachments;
import com.ecoit.elegaldocument.model.LegalDSRel;
import com.ecoit.elegaldocument.model.LegalDTypeRel;
import com.ecoit.elegaldocument.model.LegalDocument;
import com.ecoit.elegaldocument.model.impl.LegalDocumentImpl;
import com.ecoit.elegaldocument.service.LegalDSRelLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDTypeRelLocalServiceUtil;
import com.ecoit.elegaldocument.service.base.LegalDocumentLocalServiceBaseImpl;
import com.ecoit.elegaldocument.utils.DocumentRoleConstants;
import com.ecoit.elegaldocument.utils.NewsWorkflowConstants;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the legal document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.LegalDocumentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see LegalDocumentLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.elegaldocument.model.LegalDocument",
	service = AopService.class
)
public class LegalDocumentLocalServiceImpl
	extends LegalDocumentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.elegaldocument.service.LegalDocumentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.elegaldocument.service.LegalDocumentLocalServiceUtil</code>.
	 */
	
	public void updateCreateLegalDocument(LegalDocument legalDocument, List<Long> attachmentIds, long[] typeIds, List<Long> signerIds, long userId) throws Exception {
		for (long attachmentId : attachmentIds) {
			DocumentAttachments documentAttachment = documentAttachmentsPersistence.create(attachmentId);
			documentAttachment.setDocId(legalDocument.getDocId());
			documentAttachmentsPersistence.update(documentAttachment);

		}
		
		legalDTypeRelPersistence.removeByDoc(legalDocument.getDocId());
		for (long typeId : typeIds) {
			LegalDTypeRelLocalServiceUtil.createLegalDTypeRel(legalDocument.getDocId(), typeId);
		}
		
		legalDSRelPersistence.removeByDoc(legalDocument.getDocId());
		for (Long signerId : signerIds) {
			LegalDSRelLocalServiceUtil.createLegalDSRel(legalDocument.getDocId(), signerId);
		}
		
		Date now = new Date();
		switch(legalDocument.getStatusDoc()) {
		case NewsWorkflowConstants.STATUS_PENDING:
			legalDocument.setForwardedDate(now);
			legalDocument.setForwardedByUser(userId);
		    break;
		case NewsWorkflowConstants.STATUS_APPROVED:
			legalDocument.setApprovedDate(now);
			legalDocument.setApprovedByUser(userId);
		    break;
		case NewsWorkflowConstants.STATUS_PUBLISH:
			legalDocument.setPublishedDate(now);
			legalDocument.setPublishedByUser(userId);
		    break;
		}
		
		legalDocumentPersistence.update(legalDocument);
	}
	
	public List<LegalDocument> searchLegalDocument(int statusDoc, long groupId, long companyId, String language, HashMap<String, Object> searchValues) {
		Session session = null;
		List<LegalDocument> searchedLegalDocuments = new ArrayList<>();
		try {
			session = legalDocumentPersistence.openSession();
			//get list with query
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("SELECT * FROM ecoit_doc_legaldocument "
					+ "WHERE language = :language AND companyid = :companyId AND groupid = :groupId AND statusDoc = :statusDoc ");
			SQLQuery query = createSearchQuery(stringBuilder, statusDoc, groupId, companyId, language, 
					searchValues, session);
			
			query.addEntity("ecoit_doc_legaldocument", LegalDocumentImpl.class);
			searchedLegalDocuments = (List<LegalDocument>) query.list();

			if (searchValues.containsKey("typeId")) {
				List<LegalDTypeRel> legalDTypeRelsList = legalDTypeRelPersistence.findByType((Long) searchValues.get("typeId"));
				List<LegalDocument> filteredDocsList = new ArrayList<>();
				for (LegalDTypeRel legalDType : legalDTypeRelsList) {
					for (LegalDocument document : searchedLegalDocuments) {
						if (legalDType.getDocId() == document.getDocId()) {
							filteredDocsList.add(document);
						}
					}
				}
				searchedLegalDocuments = filteredDocsList;
			}
			
			if (searchValues.containsKey("sigId")) {
				List<LegalDSRel> legalDSRelsList = legalDSRelPersistence.findBySigner(((Long) searchValues.get("sigId")));
				List<LegalDocument> filteredDocsList = new ArrayList<>();
				for (LegalDSRel legalDSRel : legalDSRelsList) {
					for (LegalDocument document : searchedLegalDocuments) {
						if (legalDSRel.getDocId() == document.getDocId()) {
							filteredDocsList.add(document);
						}
					}
				}
				searchedLegalDocuments = filteredDocsList;
			}
			return searchedLegalDocuments;
		} finally {
			legalDocumentPersistence.closeSession(session);
		}
	}
	
	private SQLQuery createSearchQuery(StringBuilder baseBuilder,int statusDoc, long groupId, long companyId, String language, HashMap<String, Object> searchValues, Session session) {

		if (searchValues.containsKey("searchKey")) {
			baseBuilder.append("AND lower(summary) LIKE lower(:searchKey) ");
		}
		
		if (searchValues.containsKey("fromDate")) {
			baseBuilder.append("AND promulDate >= CAST(:fromDate AS timestamp) ");
		}

		if (searchValues.containsKey("toDate")) {
			baseBuilder.append("AND promulDate <= CAST(:toDate AS timestamp) ");
		}
		
		if (searchValues.containsKey("promulDate")) {
			baseBuilder.append("AND promuldate >= CAST(:promulDate1 AS timestamp) AND promuldate <= CAST(:promulDate2 AS timestamp) ");
		}
		
		if (searchValues.containsKey("organizationId")) {
			baseBuilder.append("AND organizationId >= :organizationId ");
		}
		
		if (searchValues.containsKey("fieldId")) {
			baseBuilder.append("AND fieldId = :fieldId ");
		}
		
		if (searchValues.containsKey("userId")) {
			baseBuilder.append("AND createdbyuser = :userId ");
		}
		
		if (searchValues.containsKey("symbol")) {
			baseBuilder.append("AND LOWER(symbol) LIKE LOWER(:symbol) ");
		}
		
		if (searchValues.containsKey("newGopY")) {
			baseBuilder.append("AND newgopy = :newGopY ");
		}
		
		if (searchValues.containsKey("start")) {
			baseBuilder.append("offset :start ");
		}
		
		baseBuilder.append("ORDER BY newgopy DESC, promuldate DESC ");
		SQLQuery query = session.createSQLQuery(baseBuilder.toString());
		query.setCacheable(false);
		query.setLong("groupId", groupId);
		query.setString("language", language);
		query.setLong("companyId", companyId);
		query.setInteger("statusDoc", statusDoc);
		if (searchValues.containsKey("searchKey")) {
			query.setString("searchKey", "%" +  (String) searchValues.get("searchKey") + "%");
		}
		
		if (searchValues.containsKey("fromDate")) {
			query.setString("fromDate", (String) searchValues.get("fromDate"));
		}

		if (searchValues.containsKey("toDate")) {
			query.setString("toDate", (String) searchValues.get("toDate"));
		}
		
		if (searchValues.containsKey("promulDate")) {
			query.setString("promulDate1", (String) searchValues.get("promulDate") + " 00:00:00");
			query.setString("promulDate2", (String) searchValues.get("promulDate") + " 23:00:00");
			System.out.println((String) searchValues.get("promulDate") + " 00:00:00");
			System.out.println((String) searchValues.get("promulDate") + " 23:00:00");
		}
		
		if (searchValues.containsKey("organizationId")) {
			query.setLong("organizationId", (Long) searchValues.get("organizationId"));
		}
		
		if (searchValues.containsKey("fieldId")) {
			query.setLong("fieldId", (Long) searchValues.get("fieldId"));
		}
		
		if (searchValues.containsKey("userId")) {
			query.setLong("userId", (Long) searchValues.get("userId"));
		}
		
		if (searchValues.containsKey("symbol")) {
			query.setString("symbol", "%" + (String) searchValues.get("symbol") + "%");
		}
		
		if (searchValues.containsKey("newGopY")) {
			query.setBoolean("newGopY", (Boolean) searchValues.get("newGopY"));
		}
		
		if (searchValues.containsKey("start")) {
			query.setInteger("start", (Integer) searchValues.get("start"));
		}
		return query;
	}
	
	public List<LegalDocument> getSuggestedDocument(long groupId, long companyId, String language, String searchKey, int statusDoc, int limit) {
		Session session = null;
		List<LegalDocument> legalDocumentsList = new ArrayList<>();
		try {
			session = legalDocumentPersistence.openSession();
			String sql = "SELECT * FROM ecoit_doc_legaldocument WHERE lower(symbol) LIKE lower(:searchKey) "
					+ "AND language = :language AND companyid = :companyId AND groupid = :groupId AND statusDoc = :statusDoc";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_legaldocument", LegalDocumentImpl.class);
			query.setLong("groupId", groupId);
			query.setString("language", language);
			query.setLong("companyId", companyId);
			query.setInteger("statusDoc", statusDoc);
			query.setString("searchKey", "%" + searchKey + "%");
			query.setMaxResults(limit);
			legalDocumentsList = (List<LegalDocument>) query.list();
			return legalDocumentsList;
		} finally {
			legalDocumentPersistence.closeSession(session);
		}
	}
	
	public void updateStatusDoc(long docId, int statusDoc, long userId) throws Exception {
		LegalDocument legalDocument = legalDocumentPersistence.findByDocId(docId);
		Date now = new Date();
		switch(statusDoc) {
		case NewsWorkflowConstants.STATUS_PENDING:
			legalDocument.setForwardedDate(now);
			legalDocument.setForwardedByUser(userId);
		    break;
		case NewsWorkflowConstants.STATUS_APPROVED:
			legalDocument.setApprovedDate(now);
			legalDocument.setApprovedByUser(userId);
		    break;
		case NewsWorkflowConstants.STATUS_PUBLISH:
			legalDocument.setPublishedDate(now);
			legalDocument.setPublishedByUser(userId);
		    break;
		}
		legalDocument.setModifiedByUser(userId);
		legalDocument.setModifiedDate(now);
		legalDocument.setStatusDoc(statusDoc);
		legalDocumentPersistence.update(legalDocument);
	}
	
	public void removeDocumentByDocId(long docId) throws Exception {
		legalDTypeRelPersistence.removeByDoc(docId);
		legalDSRelPersistence.removeByDoc(docId);
		legalDocumentPersistence.remove(docId);
	}
	
	public void resetFieldId(long fieldId) {
		List<LegalDocument> legalDocumentsList = legalDocumentPersistence.findByDoc_Field(fieldId);
		if (legalDocumentsList != null && legalDocumentsList.size() > 0) {
			for (LegalDocument legalDocument : legalDocumentsList) {
				legalDocument.setFieldId(0);
				legalDocumentPersistence.update(legalDocument);
			}
		}
	}
	
	public void resetOrganizationId(long organizationId) {
		List<LegalDocument> legalDocumentsList = legalDocumentPersistence.findByDoc_Org(organizationId);
		if (legalDocumentsList != null && legalDocumentsList.size() > 0) {
			for (LegalDocument legalDocument : legalDocumentsList) {
				legalDocument.setOrganizationId(0);
				legalDocumentPersistence.update(legalDocument);
			}
		}
	}
	
	public int getCountByStatusDoc(int statusDoc) {
		return legalDocumentPersistence.countByDOC_STATUS(statusDoc);
	}
	
	public List<LegalDocument> getLatestDocument(int isPublic, int limit, long groupId, String language) {
		Session session = null;
		List<LegalDocument> legalDocumentsList = new ArrayList<>();
		try {
			session = legalDocumentPersistence.openSession();
			String sql = "SELECT * FROM ecoit_doc_legaldocument WHERE statusdoc = :statusDoc AND language = :language AND groupid = :groupId ";
			if (isPublic > 0) {
				sql += "AND ispublic = :isPublic ";
			}
			sql += "ORDER BY publisheddate DESC ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_legaldocument", LegalDocumentImpl.class);
			if (isPublic > 0) {
				query.setInteger("isPublic", isPublic);
			}

			query.setInteger("statusDoc", NewsWorkflowConstants.STATUS_PUBLISH);
			query.setLong("groupId", groupId);
			query.setString("language", language);
			query.setMaxResults(limit);
			legalDocumentsList = (List<LegalDocument>) query.list();
			return legalDocumentsList;
		} finally {
			legalDocumentPersistence.closeSession(session);
		}
	}
	
	public List<LegalDocument> getByFieldId(long fieldId) {
		return legalDocumentPersistence.findByDoc_Field(fieldId);
	}
	
	public List<LegalDocument> getByOrgId(long orgId) {
		return legalDocumentPersistence.findByDoc_Org(orgId);
	}
	
	public void updateNewGopY(long docId, boolean newGopY) {
		LegalDocument legalDoc = legalDocumentPersistence.fetchByDocId(docId);
		if (legalDoc != null) {
			legalDoc.setNewGopY(newGopY);
			legalDocumentPersistence.update(legalDoc);
		}
	}
	
	public List<LegalDocument> getPopularDocument(int limit, long groupId, String language) {
		Session session = null;
		List<LegalDocument> legalDocumentsList = new ArrayList<>();
		try {
			session = legalDocumentPersistence.openSession();
			String sql = "SELECT * FROM ecoit_doc_legaldocument WHERE statusdoc = :statusDoc AND language = :language AND groupid = :groupId ORDER BY view DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_legaldocument", LegalDocumentImpl.class);
			query.setInteger("statusDoc", NewsWorkflowConstants.STATUS_PUBLISH);
			query.setLong("groupId", groupId);
			query.setString("language", language);
			query.setMaxResults(limit);
			legalDocumentsList = (List<LegalDocument>) query.list();
			return legalDocumentsList;
		} finally {
			legalDocumentPersistence.closeSession(session);
		}
	}
}