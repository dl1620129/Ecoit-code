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

import com.ecoit.elegaldocument.model.LegalOrg;

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
 * Provides the remote service interface for LegalOrg. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Liverpool
 * @see LegalOrgServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LegalOrgService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalOrgServiceUtil} to access the legal org remote service. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalOrgServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public LegalOrg addLegalOrg(
			long orgId, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statusorg, boolean rssable, int position,
			long parentid)
		throws Exception;

	public LegalOrg addLegalOrg(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language, boolean statusorg,
			boolean rssable, int position, long parentid)
		throws Exception;

	public int countAll(long groupId, long companyId) throws Exception;

	public List<LegalOrg> findAll(long groupId, long companyId)
		throws Exception;

	public List<LegalOrg> findAll(long groupId, long companyId, String language)
		throws Exception;

	public LegalOrg findByPrimaryKey(long legalorgid) throws Exception;

	public List<LegalOrg> findByStatus(
			long groupId, long companyId, boolean OrgStatus)
		throws Exception;

	public List<LegalOrg> findByStatus(
			long groupId, long companyId, String language, boolean statusOrg)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getAllChild(long parentId) throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getAllChild(long parentId, long groupId, long companyId)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getAllChild(
			long parentId, long groupId, long companyId, boolean statusType)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getAllChild(
			long parentId, long groupId, long companyId, String language,
			boolean statusOrg)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getAllChild(long parentId, long groupId, String language)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountDocumentBySQL(String sql) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LegalOrg> getDocumentBySQL(String sql, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMax(String lang, long groupId, long parentId, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getNodeCount(
			long parentId, long groupId, String language, String name)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LegalOrg getOrg(long orgId) throws Exception;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public void removeLegalOrg(long orgId) throws Exception;

	public LegalOrg updateImplLegalOrg(LegalOrg param) throws Exception;

	public LegalOrg updateImplLegalOrg(
			long orgId, String name, String description, String language,
			boolean statusorg, boolean rssable, int position, long parentid)
		throws Exception;

}