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
 * Provides the remote service utility for LegalField. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalFieldServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Liverpool
 * @see LegalFieldService
 * @generated
 */
public class LegalFieldServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalFieldServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ecoit.elegaldocument.model.LegalField addLegalField(
			long fieldId, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statusfield, boolean rssable, int position)
		throws Exception {

		return getService().addLegalField(
			fieldId, groupid, companyid, userid, createdbyuser, name,
			description, language, statusfield, rssable, position);
	}

	public static com.ecoit.elegaldocument.model.LegalField addLegalField(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language,
			boolean statusfield, boolean rssable, int position)
		throws Exception {

		return getService().addLegalField(
			groupid, companyid, userid, createdbyuser, name, description,
			language, statusfield, rssable, position);
	}

	public static boolean checkStatusByPrimaryKey(long FieldID)
		throws Exception {

		return getService().checkStatusByPrimaryKey(FieldID);
	}

	public static int countAll(long groupId, long companyId) throws Exception {
		return getService().countAll(groupId, companyId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findAll(long groupId, long companyId)
		throws Exception {

		return getService().findAll(groupId, companyId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findAll(long groupId, long companyId, String language)
		throws Exception {

		return getService().findAll(groupId, companyId, language);
	}

	public static com.ecoit.elegaldocument.model.LegalField findByPrimaryKey(
			long fieldid)
		throws Exception {

		return getService().findByPrimaryKey(fieldid);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findByStatus(long groupId, long companyId, boolean statusField)
		throws Exception {

		return getService().findByStatus(groupId, companyId, statusField);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findByStatus(
				long groupId, long companyId, String language,
				boolean statusField)
		throws Exception {

		return getService().findByStatus(
			groupId, companyId, language, statusField);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findByStatusFIELD(long groupId, long companyId, boolean statusFIELD)
		throws Exception {

		return getService().findByStatusFIELD(groupId, companyId, statusFIELD);
	}

	public static java.util.List<Long> getAllChild(
			long groupId, String language)
		throws Exception {

		return getService().getAllChild(groupId, language);
	}

	public static int getCountDocumentBySQL(String sql)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getCountDocumentBySQL(sql);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getDocumentBySQL(String sql, int start, int end) {

		return getService().getDocumentBySQL(sql, start, end);
	}

	public static com.ecoit.elegaldocument.model.LegalField getFieldId(
			long fieldId)
		throws Exception {

		return getService().getFieldId(fieldId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void removeFieldDB(long fiID) throws Exception {
		getService().removeFieldDB(fiID);
	}

	public static com.ecoit.elegaldocument.model.LegalField updateLegalField(
			com.ecoit.elegaldocument.model.LegalField param)
		throws Exception {

		return getService().updateLegalField(param);
	}

	public static com.ecoit.elegaldocument.model.LegalField updateLegalField(
			long legFieldID, long groupid, long companyid, long userid,
			long modifiedbyuser, String name, String description,
			String language, boolean statusfield, boolean rssable, int position)
		throws Exception {

		return getService().updateLegalField(
			legFieldID, groupid, companyid, userid, modifiedbyuser, name,
			description, language, statusfield, rssable, position);
	}

	public static LegalFieldService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalFieldService, LegalFieldService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalFieldService.class);

		ServiceTracker<LegalFieldService, LegalFieldService> serviceTracker =
			new ServiceTracker<LegalFieldService, LegalFieldService>(
				bundle.getBundleContext(), LegalFieldService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}