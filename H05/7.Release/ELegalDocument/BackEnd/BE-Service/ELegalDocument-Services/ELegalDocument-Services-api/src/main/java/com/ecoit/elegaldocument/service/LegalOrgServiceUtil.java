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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for LegalOrg. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalOrgServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Liverpool
 * @see LegalOrgService
 * @generated
 */
public class LegalOrgServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalOrgServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ecoit.elegaldocument.model.LegalOrg addLegalOrg(
			long orgId, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statusorg, boolean rssable, int position,
			long parentid)
		throws Exception {

		return getService().addLegalOrg(
			orgId, groupid, companyid, userid, createdbyuser, name, description,
			language, statusorg, rssable, position, parentid);
	}

	public static com.ecoit.elegaldocument.model.LegalOrg addLegalOrg(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language, boolean statusorg,
			boolean rssable, int position, long parentid)
		throws Exception {

		return getService().addLegalOrg(
			groupid, companyid, userid, createdbyuser, name, description,
			language, statusorg, rssable, position, parentid);
	}

	public static int countAll(long groupId, long companyId) throws Exception {
		return getService().countAll(groupId, companyId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
			findAll(long groupId, long companyId)
		throws Exception {

		return getService().findAll(groupId, companyId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
			findAll(long groupId, long companyId, String language)
		throws Exception {

		return getService().findAll(groupId, companyId, language);
	}

	public static com.ecoit.elegaldocument.model.LegalOrg findByPrimaryKey(
			long legalorgid)
		throws Exception {

		return getService().findByPrimaryKey(legalorgid);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
			findByStatus(long groupId, long companyId, boolean OrgStatus)
		throws Exception {

		return getService().findByStatus(groupId, companyId, OrgStatus);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
			findByStatus(
				long groupId, long companyId, String language,
				boolean statusOrg)
		throws Exception {

		return getService().findByStatus(
			groupId, companyId, language, statusOrg);
	}

	public static java.util.List<Long> getAllChild(long parentId)
		throws Exception {

		return getService().getAllChild(parentId);
	}

	public static java.util.List<Long> getAllChild(
			long parentId, long groupId, long companyId)
		throws Exception {

		return getService().getAllChild(parentId, groupId, companyId);
	}

	public static java.util.List<Long> getAllChild(
			long parentId, long groupId, long companyId, boolean statusType)
		throws Exception {

		return getService().getAllChild(
			parentId, groupId, companyId, statusType);
	}

	public static java.util.List<Long> getAllChild(
			long parentId, long groupId, long companyId, String language,
			boolean statusOrg)
		throws Exception {

		return getService().getAllChild(
			parentId, groupId, companyId, language, statusOrg);
	}

	public static java.util.List<Long> getAllChild(
			long parentId, long groupId, String language)
		throws Exception {

		return getService().getAllChild(parentId, groupId, language);
	}

	public static int getCountDocumentBySQL(String sql)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getCountDocumentBySQL(sql);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
		getDocumentBySQL(String sql, int start, int end) {

		return getService().getDocumentBySQL(sql, start, end);
	}

	public static int getMax(
		String lang, long groupId, long parentId, long companyId) {

		return getService().getMax(lang, groupId, parentId, companyId);
	}

	public static int getNodeCount(
			long parentId, long groupId, String language, String name)
		throws Exception {

		return getService().getNodeCount(parentId, groupId, language, name);
	}

	public static com.ecoit.elegaldocument.model.LegalOrg getOrg(long orgId)
		throws Exception {

		return getService().getOrg(orgId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void removeLegalOrg(long orgId) throws Exception {
		getService().removeLegalOrg(orgId);
	}

	public static com.ecoit.elegaldocument.model.LegalOrg updateImplLegalOrg(
			com.ecoit.elegaldocument.model.LegalOrg param)
		throws Exception {

		return getService().updateImplLegalOrg(param);
	}

	public static com.ecoit.elegaldocument.model.LegalOrg updateImplLegalOrg(
			long orgId, String name, String description, String language,
			boolean statusorg, boolean rssable, int position, long parentid)
		throws Exception {

		return getService().updateImplLegalOrg(
			orgId, name, description, language, statusorg, rssable, position,
			parentid);
	}

	public static LegalOrgService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalOrgService, LegalOrgService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalOrgService.class);

		ServiceTracker<LegalOrgService, LegalOrgService> serviceTracker =
			new ServiceTracker<LegalOrgService, LegalOrgService>(
				bundle.getBundleContext(), LegalOrgService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}