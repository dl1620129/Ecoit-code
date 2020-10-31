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

package com.ecoit.elegaldocument.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LegalOrgService}.
 *
 * @author Liverpool
 * @see LegalOrgService
 * @generated
 */
public class LegalOrgServiceWrapper
	implements LegalOrgService, ServiceWrapper<LegalOrgService> {

	public LegalOrgServiceWrapper(LegalOrgService legalOrgService) {
		_legalOrgService = legalOrgService;
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalOrg addLegalOrg(
			long orgId, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statusorg, boolean rssable, int position,
			long parentid)
		throws Exception {

		return _legalOrgService.addLegalOrg(
			orgId, groupid, companyid, userid, createdbyuser, name, description,
			language, statusorg, rssable, position, parentid);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalOrg addLegalOrg(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language, boolean statusorg,
			boolean rssable, int position, long parentid)
		throws Exception {

		return _legalOrgService.addLegalOrg(
			groupid, companyid, userid, createdbyuser, name, description,
			language, statusorg, rssable, position, parentid);
	}

	@Override
	public int countAll(long groupId, long companyId) throws Exception {
		return _legalOrgService.countAll(groupId, companyId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalOrg> findAll(
			long groupId, long companyId)
		throws Exception {

		return _legalOrgService.findAll(groupId, companyId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalOrg> findAll(
			long groupId, long companyId, String language)
		throws Exception {

		return _legalOrgService.findAll(groupId, companyId, language);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalOrg findByPrimaryKey(
			long legalorgid)
		throws Exception {

		return _legalOrgService.findByPrimaryKey(legalorgid);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalOrg> findByStatus(
			long groupId, long companyId, boolean OrgStatus)
		throws Exception {

		return _legalOrgService.findByStatus(groupId, companyId, OrgStatus);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalOrg> findByStatus(
			long groupId, long companyId, String language, boolean statusOrg)
		throws Exception {

		return _legalOrgService.findByStatus(
			groupId, companyId, language, statusOrg);
	}

	@Override
	public java.util.List<Long> getAllChild(long parentId) throws Exception {
		return _legalOrgService.getAllChild(parentId);
	}

	@Override
	public java.util.List<Long> getAllChild(
			long parentId, long groupId, long companyId)
		throws Exception {

		return _legalOrgService.getAllChild(parentId, groupId, companyId);
	}

	@Override
	public java.util.List<Long> getAllChild(
			long parentId, long groupId, long companyId, boolean statusType)
		throws Exception {

		return _legalOrgService.getAllChild(
			parentId, groupId, companyId, statusType);
	}

	@Override
	public java.util.List<Long> getAllChild(
			long parentId, long groupId, long companyId, String language,
			boolean statusOrg)
		throws Exception {

		return _legalOrgService.getAllChild(
			parentId, groupId, companyId, language, statusOrg);
	}

	@Override
	public java.util.List<Long> getAllChild(
			long parentId, long groupId, String language)
		throws Exception {

		return _legalOrgService.getAllChild(parentId, groupId, language);
	}

	@Override
	public int getCountDocumentBySQL(String sql)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _legalOrgService.getCountDocumentBySQL(sql);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
		getDocumentBySQL(String sql, int start, int end) {

		return _legalOrgService.getDocumentBySQL(sql, start, end);
	}

	@Override
	public int getMax(
		String lang, long groupId, long parentId, long companyId) {

		return _legalOrgService.getMax(lang, groupId, parentId, companyId);
	}

	@Override
	public int getNodeCount(
			long parentId, long groupId, String language, String name)
		throws Exception {

		return _legalOrgService.getNodeCount(parentId, groupId, language, name);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalOrg getOrg(long orgId)
		throws Exception {

		return _legalOrgService.getOrg(orgId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalOrgService.getOSGiServiceIdentifier();
	}

	@Override
	public void removeLegalOrg(long orgId) throws Exception {
		_legalOrgService.removeLegalOrg(orgId);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalOrg updateImplLegalOrg(
			com.ecoit.elegaldocument.model.LegalOrg param)
		throws Exception {

		return _legalOrgService.updateImplLegalOrg(param);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalOrg updateImplLegalOrg(
			long orgId, String name, String description, String language,
			boolean statusorg, boolean rssable, int position, long parentid)
		throws Exception {

		return _legalOrgService.updateImplLegalOrg(
			orgId, name, description, language, statusorg, rssable, position,
			parentid);
	}

	@Override
	public LegalOrgService getWrappedService() {
		return _legalOrgService;
	}

	@Override
	public void setWrappedService(LegalOrgService legalOrgService) {
		_legalOrgService = legalOrgService;
	}

	private LegalOrgService _legalOrgService;

}