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
 * Provides a wrapper for {@link LegalTypeService}.
 *
 * @author Liverpool
 * @see LegalTypeService
 * @generated
 */
public class LegalTypeServiceWrapper
	implements LegalTypeService, ServiceWrapper<LegalTypeService> {

	public LegalTypeServiceWrapper(LegalTypeService legalTypeService) {
		_legalTypeService = legalTypeService;
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalType addType(
			long typeID, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statustype, boolean rssable, int position,
			long parentId)
		throws Exception {

		return _legalTypeService.addType(
			typeID, groupid, companyid, userid, createdbyuser, name,
			description, language, statustype, rssable, position, parentId);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalType addType(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language,
			boolean statustype, boolean rssable, int position)
		throws Exception {

		return _legalTypeService.addType(
			groupid, companyid, userid, createdbyuser, name, description,
			language, statustype, rssable, position);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalType addType(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language,
			boolean statustype, boolean rssable, int position, long parentId)
		throws Exception {

		return _legalTypeService.addType(
			groupid, companyid, userid, createdbyuser, name, description,
			language, statustype, rssable, position, parentId);
	}

	@Override
	public boolean checkStatusByPrimaryKey(long tID) throws Exception {
		return _legalTypeService.checkStatusByPrimaryKey(tID);
	}

	@Override
	public int countAll(long groupId, long companyId) throws Exception {
		return _legalTypeService.countAll(groupId, companyId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalType> findAll(
			long groupId, long companyId)
		throws Exception {

		return _legalTypeService.findAll(groupId, companyId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalType> findAll(
			long groupId, long companyId, String language)
		throws Exception {

		return _legalTypeService.findAll(groupId, companyId, language);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalType findByPrimaryKey(
			long typeID)
		throws Exception {

		return _legalTypeService.findByPrimaryKey(typeID);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalType>
			findByStatus(long groupId, long companyId, boolean statusType)
		throws Exception {

		return _legalTypeService.findByStatus(groupId, companyId, statusType);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalType>
			findByStatus(
				long groupId, long companyId, String language,
				boolean statusType)
		throws Exception {

		return _legalTypeService.findByStatus(
			groupId, companyId, language, statusType);
	}

	@Override
	public java.util.List<Long> getAllChild(long parentId) throws Exception {
		return _legalTypeService.getAllChild(parentId);
	}

	@Override
	public java.util.List<Long> getAllChild(
			long parentId, long groupId, long companyId)
		throws Exception {

		return _legalTypeService.getAllChild(parentId, groupId, companyId);
	}

	@Override
	public java.util.List<Long> getAllChild(
			long parentId, long groupId, long companyId, boolean statusType)
		throws Exception {

		return _legalTypeService.getAllChild(
			parentId, groupId, companyId, statusType);
	}

	@Override
	public java.util.List<Long> getAllChild(
			long parentId, long groupId, long companyId, String language,
			boolean statusType)
		throws Exception {

		return _legalTypeService.getAllChild(
			parentId, groupId, companyId, language, statusType);
	}

	@Override
	public java.util.List<Long> getAllChild(
			long parentId, long groupId, String language)
		throws Exception {

		return _legalTypeService.getAllChild(parentId, groupId, language);
	}

	@Override
	public int getCountDocumentBySQL(String sql)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _legalTypeService.getCountDocumentBySQL(sql);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalType>
		getDocumentBySQL(String sql, int start, int end) {

		return _legalTypeService.getDocumentBySQL(sql, start, end);
	}

	@Override
	public java.util.List<Object> getDuLieuTheoSql(String sqlQuery) {
		return _legalTypeService.getDuLieuTheoSql(sqlQuery);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalType getType(long typeID)
		throws Exception {

		return _legalTypeService.getType(typeID);
	}

	@Override
	public void removeType(long typeID) throws Exception {
		_legalTypeService.removeType(typeID);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalType updateCategory(
			com.ecoit.elegaldocument.model.LegalType param)
		throws Exception {

		return _legalTypeService.updateCategory(param);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalType updateType(
			long typeID, long createdbyuser, long modifiedbyuser, String name,
			String description, String language, boolean statustype,
			boolean rssable, int position)
		throws Exception {

		return _legalTypeService.updateType(
			typeID, createdbyuser, modifiedbyuser, name, description, language,
			statustype, rssable, position);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalType updateType(
			long typeID, long createdbyuser, long modifiedbyuser, String name,
			String description, String language, boolean statustype,
			boolean rssable, int position, long parentId)
		throws Exception {

		return _legalTypeService.updateType(
			typeID, createdbyuser, modifiedbyuser, name, description, language,
			statustype, rssable, position, parentId);
	}

	@Override
	public LegalTypeService getWrappedService() {
		return _legalTypeService;
	}

	@Override
	public void setWrappedService(LegalTypeService legalTypeService) {
		_legalTypeService = legalTypeService;
	}

	private LegalTypeService _legalTypeService;

}