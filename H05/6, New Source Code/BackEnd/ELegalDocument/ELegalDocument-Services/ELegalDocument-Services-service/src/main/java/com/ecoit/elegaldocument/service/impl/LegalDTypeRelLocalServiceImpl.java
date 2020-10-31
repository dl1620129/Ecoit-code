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

import com.ecoit.elegaldocument.model.LegalDTypeRel;
import com.ecoit.elegaldocument.model.impl.LegalDTypeRelImpl;
import com.ecoit.elegaldocument.service.base.LegalDTypeRelLocalServiceBaseImpl;
import com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the legal d type rel local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.LegalDTypeRelLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see LegalDTypeRelLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.elegaldocument.model.LegalDTypeRel",
	service = AopService.class
)
public class LegalDTypeRelLocalServiceImpl
	extends LegalDTypeRelLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.elegaldocument.service.LegalDTypeRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.elegaldocument.service.LegalDTypeRelLocalServiceUtil</code>.
	 */
	
	public void createLegalDTypeRel(long docId, long typeId) {
		LegalDTypeRelPK primaryKey = new LegalDTypeRelPK();
		primaryKey.setDocId(docId);
		primaryKey.setTypeId(typeId);
		LegalDTypeRel legalDTypeRel  = legalDTypeRelPersistence.create(primaryKey);
		try {
			legalDTypeRelPersistence.update(legalDTypeRel);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean hasDocumentType(long docId, long typeId) {
		boolean result = false;
		Session session = null;
		try {
			session = this.legalDTypeRelPersistence.openSession();
			String sql = "select * from ecoit_doc_legaldtyperel where docid = :docId AND typeid = :typeId";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_doc_legaldtyperel", LegalDTypeRelImpl.class);
			query.setLong("docId", docId);
			query.setLong("typeId", typeId);
			List<LegalDTypeRel> users = query.list();

			if (users != null && users.size() > 0)
				result = true;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			this.legalDTypeRelPersistence.closeSession(session);
		}
		return result;
	}
	
	public List<LegalDTypeRel> getByDocId(long docId) {
		return legalDTypeRelPersistence.findByDoc(docId);
	}
	
	public void removeByTypeId(long typeId) {
		legalDTypeRelPersistence.removeByType(typeId);
	}
	
	public List<LegalDTypeRel> getByTypeId(long typeId) {
		return legalDTypeRelPersistence.findByType(typeId);
	}
}