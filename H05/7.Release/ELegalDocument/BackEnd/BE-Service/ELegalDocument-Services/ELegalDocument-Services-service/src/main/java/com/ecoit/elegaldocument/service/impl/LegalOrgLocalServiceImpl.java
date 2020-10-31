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

import com.ecoit.elegaldocument.model.LegalOrg;
import com.ecoit.elegaldocument.model.impl.LegalOrgImpl;
import com.ecoit.elegaldocument.service.base.LegalOrgLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the legal org local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.LegalOrgLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see LegalOrgLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.elegaldocument.model.LegalOrg",
	service = AopService.class
)
public class LegalOrgLocalServiceImpl extends LegalOrgLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.elegaldocument.service.LegalOrgLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.elegaldocument.service.LegalOrgLocalServiceUtil</code>.
	 */
	

	public List<LegalOrg> getNode(long parentId, long groupId, long companyId, String language, String name, int start, int limit)
			throws Exception {
		Session session = null;
		try {
			session = this.legalOrgPersistence.openSession();
			String sql = "select * from ecoit_doc_legalorg where groupid=" + groupId + " and language='" + language
					+ "' and parentid=" + parentId + " and lower(name) like lower('%" + name
					+ "%') AND companyid=:companyId order by position, createddate asc ";
			if (start != -1 && limit != -1) {
				sql += "offset " + start + " limit " + limit + "";
			}

			SQLQuery query = session.createSQLQuery(sql);
			query.setLong("companyId", companyId);
			query.setCacheable(false);
			query.addEntity("LegalOrg", LegalOrgImpl.class);
			return query.list();
		} finally {
			this.legalOrgPersistence.closeSession(session);
		}
	}
	
	public List<LegalOrg> getAllOrganizations() {
		Session session = null;
		try {
			session = this.legalOrgPersistence.openSession();
			String sql = "select * from ecoit_doc_legalorg order by position, createddate asc";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("LegalOrg", LegalOrgImpl.class);
			return query.list();
		} finally {
			this.legalOrgPersistence.closeSession(session);
		}
	}
	
	public List<LegalOrg> getPublishOrganizations(long parentId, String language, boolean statusOrg, long groupId) {
		Session session = null;
		try {
			session = this.legalOrgPersistence.openSession();
			String sql = "select * from ecoit_doc_legalorg WHERE groupid = :groupId AND parentid = :parentId AND language = :language AND statusorg = :statusOrg "
					+ "order by position, createddate asc";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.setString("language", language);
			query.setLong("parentId", parentId);
			query.setLong("groupId", groupId);
			query.setBoolean("statusOrg", statusOrg);
			query.addEntity("LegalOrg", LegalOrgImpl.class);
			return query.list();
		} finally {
			this.legalOrgPersistence.closeSession(session);
		}
	}
}