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

import com.ecoit.elegaldocument.exception.NoSuchLegalSignerException;
import com.ecoit.elegaldocument.model.LegalDSRel;
import com.ecoit.elegaldocument.model.LegalSigner;
import com.ecoit.elegaldocument.model.impl.LegalSignerImpl;
import com.ecoit.elegaldocument.service.base.LegalSignerLocalServiceBaseImpl;

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
 * The implementation of the legal signer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.LegalSignerLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see LegalSignerLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.elegaldocument.model.LegalSigner",
	service = AopService.class
)
public class LegalSignerLocalServiceImpl
	extends LegalSignerLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.elegaldocument.service.LegalSignerLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.elegaldocument.service.LegalSignerLocalServiceUtil</code>.
	 */
	
	public LegalSigner createUpdateLegalSigner(long sigId, long groupId, long companyId, long userId, String firstName, String lastName, String language, boolean statusSigner) throws Exception {
		LegalSigner legalSigner = null;
		Date now = new Date();
		if (sigId < 1) {
			sigId = counterLocalService.increment();
			legalSigner = legalSignerPersistence.create(sigId);
			legalSigner.setCreatedDate(now);
			legalSigner.setCreatedByUser(userId);
		} else {
			legalSigner = legalSignerPersistence.findBySigId(sigId);
		}
		
		legalSigner.setGroupId(groupId);
		legalSigner.setCompanyId(companyId);
		legalSigner.setUserId(userId);
		legalSigner.setFirstName(firstName);
		legalSigner.setLastName(lastName);
		legalSigner.setLanguage(language);
		legalSigner.setStatusSigner(statusSigner);
		legalSigner.setFullName(firstName + " " + lastName);
		legalSigner.setModifiedDate(now);
		legalSigner.setModifiedByUser(userId);
		
		legalSignerPersistence.update(legalSigner);
		return legalSigner;
	}
	
	public List<LegalSigner> getListLegalSigner(String name, long groupId, long companyId, int start, int limit) {
		List<LegalSigner> legalSignersList = new ArrayList<>();
		Session session = null;
		try {
			session = legalSignerPersistence.openSession();
			String sql = "SELECT * FROM ecoit_doc_legalsigner WHERE groupid = :groupId AND companyid = :companyId AND lower(fullname) like lower(:q) "
			         + "offset :start";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_legalsigner", LegalSignerImpl.class);
			query.setLong("groupId", groupId);
			query.setLong("companyId", companyId);
			query.setString("q", "%" + name + "%");
			query.setInteger("start", start);
			if (limit > 0) {
				query.setMaxResults(limit);		
			}
			
			QueryPos.getInstance(query);
			legalSignersList = query.list();
			
		} finally {
			this.legalSignerPersistence.closeSession(session);
		}
		return legalSignersList;
	}
	
	public int countTotalLegalSigner(String name, long groupId, long companyId) {
		int count = 0;
		Session session = null;
		try {
			session = legalSignerPersistence.openSession();
			String sql = "SELECT count(*) FROM ecoit_doc_legalsigner WHERE groupid = :groupId AND companyid = :companyId AND lower(fullname) like lower(:q)";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.setLong("groupId", groupId);
			query.setLong("companyId", companyId);
			query.setString("q", "%" + name + "%");
			
			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
			
		} finally {
			this.legalSignerPersistence.closeSession(session);
		}
		return count;
	}
	
	public List<LegalSigner> getByDocumentId(long documentId) {
		List<LegalDSRel> legalDSRelsList = legalDSRelPersistence.findByDoc(documentId);
		List<LegalSigner> legalSignersList = new ArrayList<>();
		if (legalSignersList != null) {
			for (LegalDSRel legalDSRel : legalDSRelsList) {
				try {
					legalSignersList.add(legalSignerPersistence.findByPrimaryKey(legalDSRel.getSigId()));
				} catch (NoSuchLegalSignerException e) {
				}
			}
		}
		return legalSignersList;
	}
}