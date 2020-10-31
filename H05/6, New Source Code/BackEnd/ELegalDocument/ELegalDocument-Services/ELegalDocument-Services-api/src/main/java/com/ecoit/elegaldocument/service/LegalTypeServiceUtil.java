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
 * Provides the remote service utility for LegalType. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalTypeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Liverpool
 * @see LegalTypeService
 * @generated
 */
public class LegalTypeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalTypeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ecoit.elegaldocument.model.LegalType addType(
			long typeID, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statustype, boolean rssable, int position,
			long parentId)
		throws Exception {

		return getService().addType(
			typeID, groupid, companyid, userid, createdbyuser, name,
			description, language, statustype, rssable, position, parentId);
	}

	public static com.ecoit.elegaldocument.model.LegalType addType(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language,
			boolean statustype, boolean rssable, int position)
		throws Exception {

		return getService().addType(
			groupid, companyid, userid, createdbyuser, name, description,
			language, statustype, rssable, position);
	}

	public static com.ecoit.elegaldocument.model.LegalType addType(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language,
			boolean statustype, boolean rssable, int position, long parentId)
		throws Exception {

		return getService().addType(
			groupid, companyid, userid, createdbyuser, name, description,
			language, statustype, rssable, position, parentId);
	}

	public static boolean checkStatusByPrimaryKey(long tID) throws Exception {
		return getService().checkStatusByPrimaryKey(tID);
	}

	public static int countAll(long groupId, long companyId) throws Exception {
		return getService().countAll(groupId, companyId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalType>
			findAll(long groupId, long companyId)
		throws Exception {

		return getService().findAll(groupId, companyId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalType>
			findAll(long groupId, long companyId, String language)
		throws Exception {

		return getService().findAll(groupId, companyId, language);
	}

	public static com.ecoit.elegaldocument.model.LegalType findByPrimaryKey(
			long typeID)
		throws Exception {

		return getService().findByPrimaryKey(typeID);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalType>
			findByStatus(long groupId, long companyId, boolean statusType)
		throws Exception {

		return getService().findByStatus(groupId, companyId, statusType);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalType>
			findByStatus(
				long groupId, long companyId, String language,
				boolean statusType)
		throws Exception {

		return getService().findByStatus(
			groupId, companyId, language, statusType);
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
			boolean statusType)
		throws Exception {

		return getService().getAllChild(
			parentId, groupId, companyId, language, statusType);
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

	public static java.util.List<com.ecoit.elegaldocument.model.LegalType>
		getDocumentBySQL(String sql, int start, int end) {

		return getService().getDocumentBySQL(sql, start, end);
	}

	public static java.util.List<Object> getDuLieuTheoSql(String sqlQuery) {
		return getService().getDuLieuTheoSql(sqlQuery);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.ecoit.elegaldocument.model.LegalType getType(long typeID)
		throws Exception {

		return getService().getType(typeID);
	}

	public static void removeType(long typeID) throws Exception {
		getService().removeType(typeID);
	}

	public static com.ecoit.elegaldocument.model.LegalType updateCategory(
			com.ecoit.elegaldocument.model.LegalType param)
		throws Exception {

		return getService().updateCategory(param);
	}

	public static com.ecoit.elegaldocument.model.LegalType updateType(
			long typeID, long createdbyuser, long modifiedbyuser, String name,
			String description, String language, boolean statustype,
			boolean rssable, int position)
		throws Exception {

		return getService().updateType(
			typeID, createdbyuser, modifiedbyuser, name, description, language,
			statustype, rssable, position);
	}

	public static com.ecoit.elegaldocument.model.LegalType updateType(
			long typeID, long createdbyuser, long modifiedbyuser, String name,
			String description, String language, boolean statustype,
			boolean rssable, int position, long parentId)
		throws Exception {

		return getService().updateType(
			typeID, createdbyuser, modifiedbyuser, name, description, language,
			statustype, rssable, position, parentId);
	}

	public static LegalTypeService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalTypeService, LegalTypeService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalTypeService.class);

		ServiceTracker<LegalTypeService, LegalTypeService> serviceTracker =
			new ServiceTracker<LegalTypeService, LegalTypeService>(
				bundle.getBundleContext(), LegalTypeService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}