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
import com.ecoit.elegaldocument.service.base.LegalOrgServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
 * The implementation of the legal org remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ecoit.elegaldocument.service.LegalOrgService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Liverpool
 * @see LegalOrgServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=ecoit_doc",
		"json.web.service.context.path=LegalOrg" }, service = AopService.class)
public class LegalOrgServiceImpl extends LegalOrgServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>com.ecoit.elegaldocument.service.LegalOrgServiceUtil</code> to access
	 * the legal org remote service.
	 */

	public LegalOrg findByPrimaryKey(long legalorgid) throws Exception {
		return this.legalOrgPersistence.findByOrgId(legalorgid);
	}

	public LegalOrg addLegalOrg(long groupid, long companyid, long userid, long createdbyuser, String name,
			String description, String language, boolean statusorg, boolean rssable, int position, long parentid)
			throws Exception {
		long orgId = CounterLocalServiceUtil.increment(LegalOrg.class.getName());
		LegalOrg Org = null;
		try {
			Org = this.findByPrimaryKey(orgId);
		} catch (Exception ex) {
			Org = null;
		}
		if (Org != null) {
			orgId = getCountDocumentBySQL("Select max(organizationid) from ecoit_doc_legalorg") + 1;
			Org = null;
		}
		Org = this.legalOrgPersistence.create(orgId);
		Org.setGroupId(groupid);
		Org.setCompanyId(companyid);
		Org.setUserId(userid);
		Org.setCreatedByUser(getUserId());
		Org.setCreatedDate(new Date());
		Org.setName(name);
		Org.setDescription(description);
		Org.setLanguage(language);
		Org.setStatusOrg(statusorg);
		Org.setRssable(rssable);
		Org.setPosition(position);
		Org.setParentId(parentid);
		Org = this.legalOrgPersistence.updateImpl(Org);
		return Org;
	}

	public int getMax(String lang, long groupId, long parentId, long companyId) {
		Session session = null;
		int max = 0;
		try {
			session = this.legalOrgPersistence.openSession();

			String sqlCountMax = "select MAX(position) from ecoit_doc_legalorg where parentid = :parentId AND companyid=:companyId AND groupid=:groupId";
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
			this.legalOrgPersistence.closeSession(session);
		}
		return max;
	}

	public LegalOrg addLegalOrg(long orgId, long groupid, long companyid, long userid, long createdbyuser, String name,
			String description, String language, boolean statusorg, boolean rssable, int position, long parentid)
			throws Exception {
		LegalOrg Org = this.legalOrgPersistence.create(orgId);
		Org.setGroupId(groupid);
		Org.setCompanyId(companyid);
		Org.setUserId(userid);
		Org.setCreatedByUser(getUserId());
		Org.setCreatedDate(new Date());
		Org.setName(name);
		Org.setDescription(description);
		Org.setLanguage(language);
		Org.setStatusOrg(statusorg);
		Org.setRssable(rssable);
		Org.setPosition(position);
		Org.setParentId(parentid);
		Org = this.legalOrgPersistence.updateImpl(Org);
		return Org;
	}

	public LegalOrg updateImplLegalOrg(long orgId, String name, String description, String language, boolean statusorg,
			boolean rssable, int position, long parentid) throws Exception {
		LegalOrg O = this.legalOrgPersistence.findByPrimaryKey(orgId);
		O.setModifiedDate(new Date());
		O.setModifiedByUser(getUserId());
		O.setName(name);
		O.setDescription(description);
		O.setLanguage(language);
		O.setRssable(rssable);
		O.setStatusOrg(statusorg);
		O.setParentId(parentid);
		O.setPosition(position);
		O = this.legalOrgPersistence.updateImpl(O);
		return O;

	}

	public LegalOrg updateImplLegalOrg(LegalOrg param) throws Exception {
		return this.legalOrgPersistence.updateImpl(param);
	}

	public List<LegalOrg> findAll(long groupId, long companyId) throws Exception {
		List<LegalOrg> list = new ArrayList<LegalOrg>();
		list = this.legalOrgPersistence.findByFindGroup(groupId, companyId);
		return list;
	}

	public List<LegalOrg> findAll(long groupId, long companyId, String language) throws Exception {
		List<LegalOrg> list = new ArrayList<LegalOrg>();
		list = this.legalOrgPersistence.findByG_C_L(groupId, companyId, language);
		return list;
	}

	public int countAll(long groupId, long companyId) throws Exception {
		return this.legalOrgPersistence.findByFindGroup(groupId, companyId).size();
	}

	public void removeLegalOrg(long orgId) throws Exception {
		this.legalOrgPersistence.remove(orgId);
	}

	public List<Long> getAllChild(long parentId, long groupId, long companyId) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalOrg> list = this.legalOrgPersistence.findByG_C_P(groupId, companyId, parentId);
		for (Iterator<LegalOrg> iterator = list.iterator(); iterator.hasNext();) {
			LegalOrg element = iterator.next();
			result.add(element.getOrganizationId());
		}

		return result;
	}

	public List<Long> getAllChild(long parentId, long groupId, long companyId, String language, boolean statusOrg)
			throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalOrg> list = this.legalOrgPersistence.findByG_C_L_P_S(groupId, companyId, language, parentId,
				statusOrg);
		for (Iterator<LegalOrg> iterator = list.iterator(); iterator.hasNext();) {
			LegalOrg element = iterator.next();
			result.add(element.getOrganizationId());
		}

		return result;
	}

	public List<LegalOrg> findByStatus(long groupId, long companyId, boolean OrgStatus) throws Exception {
		List<LegalOrg> list = new ArrayList<LegalOrg>();
		list = this.legalOrgPersistence.findByFindAllStatus(groupId, companyId, OrgStatus);
		return list;
	}

	public List<LegalOrg> findByStatus(long groupId, long companyId, String language, boolean statusOrg)
			throws Exception {
		List<LegalOrg> list = new ArrayList<LegalOrg>();
		list = this.legalOrgPersistence.findByG_C_L_S(groupId, companyId, language, statusOrg);
		return list;
	}

	public LegalOrg getOrg(long orgId) throws Exception {
		return this.legalOrgPersistence.findByPrimaryKey(orgId);
	}

	public List<Long> getAllChild(long parentId, long groupId, long companyId, boolean statusType) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalOrg> list = this.legalOrgPersistence.findByFindGroupCompanyParent(groupId, companyId, parentId,
				statusType);
		for (Iterator<LegalOrg> iterator = list.iterator(); iterator.hasNext();) {
			LegalOrg element = iterator.next();
			result.add(element.getOrganizationId());
		}

		return result;
	}

	public List<LegalOrg> getDocumentBySQL(String sql, int start, int end) {
		return this.legalOrgService.getDocumentBySQL(sql, start, end);
	}

	public int getCountDocumentBySQL(String sql) throws SystemException {

		Long count = 0L;
		Session session = null;
		try {
			session = this.legalOrgPersistence.openSession();
			SQLQuery q = session.createSQLQuery(sql);
			Iterator<java.math.BigInteger> itr = q.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}

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

	public List<Long> getAllChild(long parentId) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalOrg> list = this.legalOrgPersistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Iterator<LegalOrg> iterator = list.iterator(); iterator.hasNext();) {
			LegalOrg element = iterator.next();
			if (element.getParentId() == parentId)
				result.add(element.getOrganizationId());
		}
		return result;
	}

	public List<Long> getAllChild(long parentId, long groupId, String language) throws Exception {
		List<Long> result = new ArrayList<Long>();
		List<LegalOrg> listCategory = new ArrayList<LegalOrg>();
		Session session = null;
		try {
			session = this.legalOrgPersistence.openSession();
			String sql = "select * from ecoit_doc_legalorg where groupid=" + groupId + " and language='" + language
					+ "' and parentid=" + parentId + " AND statusorg = true order by name asc";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("LegalOrg", LegalOrgImpl.class);
			listCategory = (List<LegalOrg>) query.list();
			if (listCategory != null && listCategory.size() > 0) {
				for (int i = 0; i < listCategory.size(); i++) {
					result.add(listCategory.get(i).getOrganizationId());
				}
			}
		} finally {
			this.legalOrgPersistence.closeSession(session);
		}
		return result;
	}

	public int getNodeCount(long parentId, long groupId, String language, String name) throws Exception {
		Session session = null;
		try {
			session = this.legalOrgPersistence.openSession();
			String sql = "select count(*) from ecoit_doc_legalorg where groupid=" + groupId + " and language='"
					+ language + "' and parentid=" + parentId + " and lower(name) like lower('%" + name + "%') ";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			return Integer.parseInt(query.list().get(0).toString());
		} finally {
			this.legalOrgPersistence.closeSession(session);
		}

	}

}