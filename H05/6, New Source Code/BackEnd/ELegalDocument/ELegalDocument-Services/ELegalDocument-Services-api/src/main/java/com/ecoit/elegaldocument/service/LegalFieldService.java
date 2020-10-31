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

import com.ecoit.elegaldocument.model.LegalField;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for LegalField. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Liverpool
 * @see LegalFieldServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LegalFieldService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalFieldServiceUtil} to access the legal field remote service. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalFieldServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public LegalField addLegalField(
			long fieldId, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statusfield, boolean rssable, int position)
		throws Exception;

	public LegalField addLegalField(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language,
			boolean statusfield, boolean rssable, int position)
		throws Exception;

	public boolean checkStatusByPrimaryKey(long FieldID) throws Exception;

	public int countAll(long groupId, long companyId) throws Exception;

	public List<LegalField> findAll(long groupId, long companyId)
		throws Exception;

	public List<LegalField> findAll(
			long groupId, long companyId, String language)
		throws Exception;

	public LegalField findByPrimaryKey(long fieldid) throws Exception;

	public List<LegalField> findByStatus(
			long groupId, long companyId, boolean statusField)
		throws Exception;

	public List<LegalField> findByStatus(
			long groupId, long companyId, String language, boolean statusField)
		throws Exception;

	public List<LegalField> findByStatusFIELD(
			long groupId, long companyId, boolean statusFIELD)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getAllChild(long groupId, String language)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountDocumentBySQL(String sql) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LegalField> getDocumentBySQL(String sql, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LegalField getFieldId(long fieldId) throws Exception;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public void removeFieldDB(long fiID) throws Exception;

	public LegalField updateLegalField(LegalField param) throws Exception;

	public LegalField updateLegalField(
			long legFieldID, long groupid, long companyid, long userid,
			long modifiedbyuser, String name, String description,
			String language, boolean statusfield, boolean rssable, int position)
		throws Exception;

}