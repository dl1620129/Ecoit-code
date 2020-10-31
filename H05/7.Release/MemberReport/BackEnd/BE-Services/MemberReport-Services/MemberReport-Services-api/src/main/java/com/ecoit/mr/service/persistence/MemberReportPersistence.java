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

import com.ecoit.mr.exception.NoSuchMemberReportException;
import com.ecoit.mr.model.MemberReport;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the member report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberReportUtil
 * @generated
 */
@ProviderType
public interface MemberReportPersistence extends BasePersistence<MemberReport> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MemberReportUtil} to access the member report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the member reports where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching member reports
	 */
	public java.util.List<MemberReport> findByUuid(String uuid);

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
	public java.util.List<MemberReport> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<MemberReport> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator);

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
	public java.util.List<MemberReport> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first member report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public MemberReport findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
				orderByComparator)
		throws NoSuchMemberReportException;

	/**
	 * Returns the first member report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public MemberReport fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator);

	/**
	 * Returns the last member report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public MemberReport findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
				orderByComparator)
		throws NoSuchMemberReportException;

	/**
	 * Returns the last member report in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public MemberReport fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator);

	/**
	 * Returns the member reports before and after the current member report in the ordered set where uuid = &#63;.
	 *
	 * @param memberReportId the primary key of the current member report
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member report
	 * @throws NoSuchMemberReportException if a member report with the primary key could not be found
	 */
	public MemberReport[] findByUuid_PrevAndNext(
			long memberReportId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
				orderByComparator)
		throws NoSuchMemberReportException;

	/**
	 * Removes all the member reports where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of member reports where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching member reports
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the member report where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMemberReportException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public MemberReport findByUUID_G(String uuid, long groupId)
		throws NoSuchMemberReportException;

	/**
	 * Returns the member report where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public MemberReport fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the member report where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public MemberReport fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the member report where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the member report that was removed
	 */
	public MemberReport removeByUUID_G(String uuid, long groupId)
		throws NoSuchMemberReportException;

	/**
	 * Returns the number of member reports where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching member reports
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the member reports where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching member reports
	 */
	public java.util.List<MemberReport> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<MemberReport> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<MemberReport> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator);

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
	public java.util.List<MemberReport> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first member report in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public MemberReport findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
				orderByComparator)
		throws NoSuchMemberReportException;

	/**
	 * Returns the first member report in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public MemberReport fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator);

	/**
	 * Returns the last member report in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public MemberReport findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
				orderByComparator)
		throws NoSuchMemberReportException;

	/**
	 * Returns the last member report in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public MemberReport fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator);

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
	public MemberReport[] findByUuid_C_PrevAndNext(
			long memberReportId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
				orderByComparator)
		throws NoSuchMemberReportException;

	/**
	 * Removes all the member reports where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of member reports where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching member reports
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the member reports where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching member reports
	 */
	public java.util.List<MemberReport> findByUnit(long unitId);

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
	public java.util.List<MemberReport> findByUnit(
		long unitId, int start, int end);

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
	public java.util.List<MemberReport> findByUnit(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator);

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
	public java.util.List<MemberReport> findByUnit(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first member report in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public MemberReport findByUnit_First(
			long unitId,
			com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
				orderByComparator)
		throws NoSuchMemberReportException;

	/**
	 * Returns the first member report in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public MemberReport fetchByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator);

	/**
	 * Returns the last member report in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report
	 * @throws NoSuchMemberReportException if a matching member report could not be found
	 */
	public MemberReport findByUnit_Last(
			long unitId,
			com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
				orderByComparator)
		throws NoSuchMemberReportException;

	/**
	 * Returns the last member report in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member report, or <code>null</code> if a matching member report could not be found
	 */
	public MemberReport fetchByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator);

	/**
	 * Returns the member reports before and after the current member report in the ordered set where unitId = &#63;.
	 *
	 * @param memberReportId the primary key of the current member report
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member report
	 * @throws NoSuchMemberReportException if a member report with the primary key could not be found
	 */
	public MemberReport[] findByUnit_PrevAndNext(
			long memberReportId, long unitId,
			com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
				orderByComparator)
		throws NoSuchMemberReportException;

	/**
	 * Removes all the member reports where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	public void removeByUnit(long unitId);

	/**
	 * Returns the number of member reports where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching member reports
	 */
	public int countByUnit(long unitId);

	/**
	 * Caches the member report in the entity cache if it is enabled.
	 *
	 * @param memberReport the member report
	 */
	public void cacheResult(MemberReport memberReport);

	/**
	 * Caches the member reports in the entity cache if it is enabled.
	 *
	 * @param memberReports the member reports
	 */
	public void cacheResult(java.util.List<MemberReport> memberReports);

	/**
	 * Creates a new member report with the primary key. Does not add the member report to the database.
	 *
	 * @param memberReportId the primary key for the new member report
	 * @return the new member report
	 */
	public MemberReport create(long memberReportId);

	/**
	 * Removes the member report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberReportId the primary key of the member report
	 * @return the member report that was removed
	 * @throws NoSuchMemberReportException if a member report with the primary key could not be found
	 */
	public MemberReport remove(long memberReportId)
		throws NoSuchMemberReportException;

	public MemberReport updateImpl(MemberReport memberReport);

	/**
	 * Returns the member report with the primary key or throws a <code>NoSuchMemberReportException</code> if it could not be found.
	 *
	 * @param memberReportId the primary key of the member report
	 * @return the member report
	 * @throws NoSuchMemberReportException if a member report with the primary key could not be found
	 */
	public MemberReport findByPrimaryKey(long memberReportId)
		throws NoSuchMemberReportException;

	/**
	 * Returns the member report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberReportId the primary key of the member report
	 * @return the member report, or <code>null</code> if a member report with the primary key could not be found
	 */
	public MemberReport fetchByPrimaryKey(long memberReportId);

	/**
	 * Returns all the member reports.
	 *
	 * @return the member reports
	 */
	public java.util.List<MemberReport> findAll();

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
	public java.util.List<MemberReport> findAll(int start, int end);

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
	public java.util.List<MemberReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator);

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
	public java.util.List<MemberReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MemberReport>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the member reports from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of member reports.
	 *
	 * @return the number of member reports
	 */
	public int countAll();

}