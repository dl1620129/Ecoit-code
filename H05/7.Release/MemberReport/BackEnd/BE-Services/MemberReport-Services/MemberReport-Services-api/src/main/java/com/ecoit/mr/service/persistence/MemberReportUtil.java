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

package com.ecoit.mr.service.persistence;

import com.ecoit.mr.model.MemberReport;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the member report service. This utility wraps <code>com.ecoit.mr.service.persistence.impl.MemberReportPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberReportPersistence
 * @generated
 */
public class MemberReportUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(MemberReport memberReport) {
		getPersistence().clearCache(memberReport);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, MemberReport> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MemberReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MemberReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MemberReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MemberReport update(MemberReport memberReport) {
		return getPersistence().update(memberReport);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MemberReport update(
		MemberReport memberReport, ServiceContext serviceContext) {

		return getPersistence().update(memberReport, serviceContext);
	}

	/**
	 * Returns all the member reports where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching member reports
	 */
	public static List<MemberReport> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the member reports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @return the range of matching member reports
	 */
	public static List<MemberReport> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the member reports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching member reports
	 */
	public static List<MemberReport> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the member reports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching member reports
	 */
	public static List<MemberReport> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MemberReport> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first member report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public static MemberReport findByUuid_First(
			String uuid, OrderByComparator<MemberReport> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first member report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public static MemberReport fetchByUuid_First(
		String uuid, OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last member report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public static MemberReport findByUuid_Last(
			String uuid, OrderByComparator<MemberReport> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last member report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public static MemberReport fetchByUuid_Last(
		String uuid, OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the member reports before and after the current member report in the ordered set where uuid = &#63;.
	 *
	 * @param memberReportId the primary key of the current member report
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member report
	 * @throws NoSuchMemberReportException if a member report with the primary key could not be found
	 */
	public static MemberReport[] findByUuid_PrevAndNext(
			long memberReportId, String uuid,
			OrderByComparator<MemberReport> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByUuid_PrevAndNext(
			memberReportId, uuid, orderByComparator);
	}

	/**
	 * Removes all the member reports where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of member reports where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching member reports
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the member report where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMemberReportException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public static MemberReport findByUUID_G(String uuid, long groupId)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the member report where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public static MemberReport fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the member report where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public static MemberReport fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the member report where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the member report that was removed
	 */
	public static MemberReport removeByUUID_G(String uuid, long groupId)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of member reports where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching member reports
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the member reports where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching member reports
	 */
	public static List<MemberReport> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the member reports where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @return the range of matching member reports
	 */
	public static List<MemberReport> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the member reports where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching member reports
	 */
	public static List<MemberReport> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the member reports where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching member reports
	 */
	public static List<MemberReport> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MemberReport> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first member report in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public static MemberReport findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MemberReport> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first member report in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public static MemberReport fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last member report in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public static MemberReport findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MemberReport> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last member report in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public static MemberReport fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the member reports before and after the current member report in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param memberReportId the primary key of the current member report
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member report
	 * @throws NoSuchMemberReportException if a member report with the primary key could not be found
	 */
	public static MemberReport[] findByUuid_C_PrevAndNext(
			long memberReportId, String uuid, long companyId,
			OrderByComparator<MemberReport> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByUuid_C_PrevAndNext(
			memberReportId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the member reports where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of member reports where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching member reports
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the member reports where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching member reports
	 */
	public static List<MemberReport> findByUnit(long unitId) {
		return getPersistence().findByUnit(unitId);
	}

	/**
	 * Returns a range of all the member reports where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @return the range of matching member reports
	 */
	public static List<MemberReport> findByUnit(
		long unitId, int start, int end) {

		return getPersistence().findByUnit(unitId, start, end);
	}

	/**
	 * Returns an ordered range of all the member reports where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching member reports
	 */
	public static List<MemberReport> findByUnit(
		long unitId, int start, int end,
		OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().findByUnit(
			unitId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the member reports where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching member reports
	 */
	public static List<MemberReport> findByUnit(
		long unitId, int start, int end,
		OrderByComparator<MemberReport> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnit(
			unitId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first member report in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public static MemberReport findByUnit_First(
			long unitId, OrderByComparator<MemberReport> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByUnit_First(unitId, orderByComparator);
	}

	/**
	 * Returns the first member report in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public static MemberReport fetchByUnit_First(
		long unitId, OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().fetchByUnit_First(unitId, orderByComparator);
	}

	/**
	 * Returns the last member report in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public static MemberReport findByUnit_Last(
			long unitId, OrderByComparator<MemberReport> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByUnit_Last(unitId, orderByComparator);
	}

	/**
	 * Returns the last member report in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public static MemberReport fetchByUnit_Last(
		long unitId, OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().fetchByUnit_Last(unitId, orderByComparator);
	}

	/**
	 * Returns the member reports before and after the current member report in the ordered set where unitId = &#63;.
	 *
	 * @param memberReportId the primary key of the current member report
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member report
	 * @throws NoSuchMemberReportException if a member report with the primary key could not be found
	 */
	public static MemberReport[] findByUnit_PrevAndNext(
			long memberReportId, long unitId,
			OrderByComparator<MemberReport> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByUnit_PrevAndNext(
			memberReportId, unitId, orderByComparator);
	}

	/**
	 * Removes all the member reports where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	public static void removeByUnit(long unitId) {
		getPersistence().removeByUnit(unitId);
	}

	/**
	 * Returns the number of member reports where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching member reports
	 */
	public static int countByUnit(long unitId) {
		return getPersistence().countByUnit(unitId);
	}

	/**
	 * Caches the member report in the entity cache if it is enabled.
	 *
	 * @param memberReport the member report
	 */
	public static void cacheResult(MemberReport memberReport) {
		getPersistence().cacheResult(memberReport);
	}

	/**
	 * Caches the member reports in the entity cache if it is enabled.
	 *
	 * @param memberReports the member reports
	 */
	public static void cacheResult(List<MemberReport> memberReports) {
		getPersistence().cacheResult(memberReports);
	}

	/**
	 * Creates a new member report with the primary key. Does not add the member report to the database.
	 *
	 * @param memberReportId the primary key for the new member report
	 * @return the new member report
	 */
	public static MemberReport create(long memberReportId) {
		return getPersistence().create(memberReportId);
	}

	/**
	 * Removes the member report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberReportId the primary key of the member report
	 * @return the member report that was removed
	 * @throws NoSuchMemberReportException if a member report with the primary key could not be found
	 */
	public static MemberReport remove(long memberReportId)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().remove(memberReportId);
	}

	public static MemberReport updateImpl(MemberReport memberReport) {
		return getPersistence().updateImpl(memberReport);
	}

	/**
	 * Returns the member report with the primary key or throws a <code>NoSuchMemberReportException</code> if it could not be found.
	 *
	 * @param memberReportId the primary key of the member report
	 * @return the member report
	 * @throws NoSuchMemberReportException if a member report with the primary key could not be found
	 */
	public static MemberReport findByPrimaryKey(long memberReportId)
		throws com.ecoit.mr.exception.NoSuchMemberReportException {

		return getPersistence().findByPrimaryKey(memberReportId);
	}

	/**
	 * Returns the member report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberReportId the primary key of the member report
	 * @return the member report, or <code>null</code> if a member report with the primary key could not be found
	 */
	public static MemberReport fetchByPrimaryKey(long memberReportId) {
		return getPersistence().fetchByPrimaryKey(memberReportId);
	}

	/**
	 * Returns all the member reports.
	 *
	 * @return the member reports
	 */
	public static List<MemberReport> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the member reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @return the range of member reports
	 */
	public static List<MemberReport> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the member reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of member reports
	 */
	public static List<MemberReport> findAll(
		int start, int end, OrderByComparator<MemberReport> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the member reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of member reports
	 */
	public static List<MemberReport> findAll(
		int start, int end, OrderByComparator<MemberReport> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the member reports from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of member reports.
	 *
	 * @return the number of member reports
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MemberReportPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MemberReportPersistence, MemberReportPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MemberReportPersistence.class);

		ServiceTracker<MemberReportPersistence, MemberReportPersistence>
			serviceTracker =
				new ServiceTracker
					<MemberReportPersistence, MemberReportPersistence>(
						bundle.getBundleContext(),
						MemberReportPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}