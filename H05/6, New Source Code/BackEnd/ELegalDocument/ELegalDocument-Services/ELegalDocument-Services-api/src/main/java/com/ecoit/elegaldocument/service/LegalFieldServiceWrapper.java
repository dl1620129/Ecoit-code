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
 * Provides a wrapper for {@link LegalFieldService}.
 *
 * @author Liverpool
 * @see LegalFieldService
 * @generated
 */
public class LegalFieldServiceWrapper
	implements LegalFieldService, ServiceWrapper<LegalFieldService> {

	public LegalFieldServiceWrapper(LegalFieldService legalFieldService) {
		_legalFieldService = legalFieldService;
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalField addLegalField(
			long fieldId, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statusfield, boolean rssable, int position)
		throws Exception {

		return _legalFieldService.addLegalField(
			fieldId, groupid, companyid, userid, createdbyuser, name,
			description, language, statusfield, rssable, position);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalField addLegalField(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language,
			boolean statusfield, boolean rssable, int position)
		throws Exception {

		return _legalFieldService.addLegalField(
			groupid, companyid, userid, createdbyuser, name, description,
			language, statusfield, rssable, position);
	}

	@Override
	public boolean checkStatusByPrimaryKey(long FieldID) throws Exception {
		return _legalFieldService.checkStatusByPrimaryKey(FieldID);
	}

	@Override
	public int countAll(long groupId, long companyId) throws Exception {
		return _legalFieldService.countAll(groupId, companyId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalField> findAll(
			long groupId, long companyId)
		throws Exception {

		return _legalFieldService.findAll(groupId, companyId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalField> findAll(
			long groupId, long companyId, String language)
		throws Exception {

		return _legalFieldService.findAll(groupId, companyId, language);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalField findByPrimaryKey(
			long fieldid)
		throws Exception {

		return _legalFieldService.findByPrimaryKey(fieldid);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findByStatus(long groupId, long companyId, boolean statusField)
		throws Exception {

		return _legalFieldService.findByStatus(groupId, companyId, statusField);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findByStatus(
				long groupId, long companyId, String language,
				boolean statusField)
		throws Exception {

		return _legalFieldService.findByStatus(
			groupId, companyId, language, statusField);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findByStatusFIELD(long groupId, long companyId, boolean statusFIELD)
		throws Exception {

		return _legalFieldService.findByStatusFIELD(
			groupId, companyId, statusFIELD);
	}

	@Override
	public java.util.List<Long> getAllChild(long groupId, String language)
		throws Exception {

		return _legalFieldService.getAllChild(groupId, language);
	}

	@Override
	public int getCountDocumentBySQL(String sql)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _legalFieldService.getCountDocumentBySQL(sql);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getDocumentBySQL(String sql, int start, int end) {

		return _legalFieldService.getDocumentBySQL(sql, start, end);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalField getFieldId(long fieldId)
		throws Exception {

		return _legalFieldService.getFieldId(fieldId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalFieldService.getOSGiServiceIdentifier();
	}

	@Override
	public void removeFieldDB(long fiID) throws Exception {
		_legalFieldService.removeFieldDB(fiID);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalField updateLegalField(
			com.ecoit.elegaldocument.model.LegalField param)
		throws Exception {

		return _legalFieldService.updateLegalField(param);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalField updateLegalField(
			long legFieldID, long groupid, long companyid, long userid,
			long modifiedbyuser, String name, String description,
			String language, boolean statusfield, boolean rssable, int position)
		throws Exception {

		return _legalFieldService.updateLegalField(
			legFieldID, groupid, companyid, userid, modifiedbyuser, name,
			description, language, statusfield, rssable, position);
	}

	@Override
	public LegalFieldService getWrappedService() {
		return _legalFieldService;
	}

	@Override
	public void setWrappedService(LegalFieldService legalFieldService) {
		_legalFieldService = legalFieldService;
	}

	private LegalFieldService _legalFieldService;

}