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

package com.ecoit.elegaldocument.service.persistence;

import com.ecoit.elegaldocument.model.LegalLogger;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the legal logger service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalLoggerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalLoggerPersistence
 * @generated
 */
public class LegalLoggerUtil {

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
	public static void clearCache(LegalLogger legalLogger) {
		getPersistence().clearCache(legalLogger);
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
	public static Map<Serializable, LegalLogger> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalLogger> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalLogger> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalLogger> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalLogger update(LegalLogger legalLogger) {
		return getPersistence().update(legalLogger);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalLogger update(
		LegalLogger legalLogger, ServiceContext serviceContext) {

		return getPersistence().update(legalLogger, serviceContext);
	}

	/**
	 * Returns all the legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @return the matching legal loggers
	 */
	public static List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate) {

		return getPersistence().findByU_D(createdByUser, createdDate);
	}

	/**
	 * Returns a range of all the legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @return the range of matching legal loggers
	 */
	public static List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate, int start, int end) {

		return getPersistence().findByU_D(
			createdByUser, createdDate, start, end);
	}

	/**
	 * Returns an ordered range of all the legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal loggers
	 */
	public static List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().findByU_D(
			createdByUser, createdDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal loggers
	 */
	public static List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_D(
			createdByUser, createdDate, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public static LegalLogger findByU_D_First(
			String createdByUser, Date createdDate,
			OrderByComparator<LegalLogger> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().findByU_D_First(
			createdByUser, createdDate, orderByComparator);
	}

	/**
	 * Returns the first legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public static LegalLogger fetchByU_D_First(
		String createdByUser, Date createdDate,
		OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().fetchByU_D_First(
			createdByUser, createdDate, orderByComparator);
	}

	/**
	 * Returns the last legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public static LegalLogger findByU_D_Last(
			String createdByUser, Date createdDate,
			OrderByComparator<LegalLogger> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().findByU_D_Last(
			createdByUser, createdDate, orderByComparator);
	}

	/**
	 * Returns the last legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public static LegalLogger fetchByU_D_Last(
		String createdByUser, Date createdDate,
		OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().fetchByU_D_Last(
			createdByUser, createdDate, orderByComparator);
	}

	/**
	 * Returns the legal loggers before and after the current legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param loggerId the primary key of the current legal logger
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal logger
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	public static LegalLogger[] findByU_D_PrevAndNext(
			String loggerId, String createdByUser, Date createdDate,
			OrderByComparator<LegalLogger> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().findByU_D_PrevAndNext(
			loggerId, createdByUser, createdDate, orderByComparator);
	}

	/**
	 * Removes all the legal loggers where createdByUser = &#63; and createdDate = &#63; from the database.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 */
	public static void removeByU_D(String createdByUser, Date createdDate) {
		getPersistence().removeByU_D(createdByUser, createdDate);
	}

	/**
	 * Returns the number of legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @return the number of matching legal loggers
	 */
	public static int countByU_D(String createdByUser, Date createdDate) {
		return getPersistence().countByU_D(createdByUser, createdDate);
	}

	/**
	 * Returns all the legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @return the matching legal loggers
	 */
	public static List<LegalLogger> findByE_C(
		String entryId, String classEntry) {

		return getPersistence().findByE_C(entryId, classEntry);
	}

	/**
	 * Returns a range of all the legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @return the range of matching legal loggers
	 */
	public static List<LegalLogger> findByE_C(
		String entryId, String classEntry, int start, int end) {

		return getPersistence().findByE_C(entryId, classEntry, start, end);
	}

	/**
	 * Returns an ordered range of all the legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal loggers
	 */
	public static List<LegalLogger> findByE_C(
		String entryId, String classEntry, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().findByE_C(
			entryId, classEntry, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal loggers
	 */
	public static List<LegalLogger> findByE_C(
		String entryId, String classEntry, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByE_C(
			entryId, classEntry, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public static LegalLogger findByE_C_First(
			String entryId, String classEntry,
			OrderByComparator<LegalLogger> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().findByE_C_First(
			entryId, classEntry, orderByComparator);
	}

	/**
	 * Returns the first legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public static LegalLogger fetchByE_C_First(
		String entryId, String classEntry,
		OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().fetchByE_C_First(
			entryId, classEntry, orderByComparator);
	}

	/**
	 * Returns the last legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public static LegalLogger findByE_C_Last(
			String entryId, String classEntry,
			OrderByComparator<LegalLogger> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().findByE_C_Last(
			entryId, classEntry, orderByComparator);
	}

	/**
	 * Returns the last legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public static LegalLogger fetchByE_C_Last(
		String entryId, String classEntry,
		OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().fetchByE_C_Last(
			entryId, classEntry, orderByComparator);
	}

	/**
	 * Returns the legal loggers before and after the current legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param loggerId the primary key of the current legal logger
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal logger
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	public static LegalLogger[] findByE_C_PrevAndNext(
			String loggerId, String entryId, String classEntry,
			OrderByComparator<LegalLogger> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().findByE_C_PrevAndNext(
			loggerId, entryId, classEntry, orderByComparator);
	}

	/**
	 * Removes all the legal loggers where entryId = &#63; and classEntry = &#63; from the database.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 */
	public static void removeByE_C(String entryId, String classEntry) {
		getPersistence().removeByE_C(entryId, classEntry);
	}

	/**
	 * Returns the number of legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @return the number of matching legal loggers
	 */
	public static int countByE_C(String entryId, String classEntry) {
		return getPersistence().countByE_C(entryId, classEntry);
	}

	/**
	 * Returns all the legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal loggers
	 */
	public static List<LegalLogger> findByFindAll(
		long groupId, long companyId) {

		return getPersistence().findByFindAll(groupId, companyId);
	}

	/**
	 * Returns a range of all the legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @return the range of matching legal loggers
	 */
	public static List<LegalLogger> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindAll(groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal loggers
	 */
	public static List<LegalLogger> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal loggers
	 */
	public static List<LegalLogger> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public static LegalLogger findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalLogger> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().findByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public static LegalLogger fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public static LegalLogger findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalLogger> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().findByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public static LegalLogger fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the legal loggers before and after the current legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param loggerId the primary key of the current legal logger
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal logger
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	public static LegalLogger[] findByFindAll_PrevAndNext(
			String loggerId, long groupId, long companyId,
			OrderByComparator<LegalLogger> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().findByFindAll_PrevAndNext(
			loggerId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the legal loggers where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindAll(long groupId, long companyId) {
		getPersistence().removeByFindAll(groupId, companyId);
	}

	/**
	 * Returns the number of legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal loggers
	 */
	public static int countByFindAll(long groupId, long companyId) {
		return getPersistence().countByFindAll(groupId, companyId);
	}

	/**
	 * Caches the legal logger in the entity cache if it is enabled.
	 *
	 * @param legalLogger the legal logger
	 */
	public static void cacheResult(LegalLogger legalLogger) {
		getPersistence().cacheResult(legalLogger);
	}

	/**
	 * Caches the legal loggers in the entity cache if it is enabled.
	 *
	 * @param legalLoggers the legal loggers
	 */
	public static void cacheResult(List<LegalLogger> legalLoggers) {
		getPersistence().cacheResult(legalLoggers);
	}

	/**
	 * Creates a new legal logger with the primary key. Does not add the legal logger to the database.
	 *
	 * @param loggerId the primary key for the new legal logger
	 * @return the new legal logger
	 */
	public static LegalLogger create(String loggerId) {
		return getPersistence().create(loggerId);
	}

	/**
	 * Removes the legal logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger that was removed
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	public static LegalLogger remove(String loggerId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().remove(loggerId);
	}

	public static LegalLogger updateImpl(LegalLogger legalLogger) {
		return getPersistence().updateImpl(legalLogger);
	}

	/**
	 * Returns the legal logger with the primary key or throws a <code>NoSuchLegalLoggerException</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	public static LegalLogger findByPrimaryKey(String loggerId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException {

		return getPersistence().findByPrimaryKey(loggerId);
	}

	/**
	 * Returns the legal logger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger, or <code>null</code> if a legal logger with the primary key could not be found
	 */
	public static LegalLogger fetchByPrimaryKey(String loggerId) {
		return getPersistence().fetchByPrimaryKey(loggerId);
	}

	/**
	 * Returns all the legal loggers.
	 *
	 * @return the legal loggers
	 */
	public static List<LegalLogger> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @return the range of legal loggers
	 */
	public static List<LegalLogger> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal loggers
	 */
	public static List<LegalLogger> findAll(
		int start, int end, OrderByComparator<LegalLogger> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal loggers
	 */
	public static List<LegalLogger> findAll(
		int start, int end, OrderByComparator<LegalLogger> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal loggers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal loggers.
	 *
	 * @return the number of legal loggers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalLoggerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalLoggerPersistence, LegalLoggerPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalLoggerPersistence.class);

		ServiceTracker<LegalLoggerPersistence, LegalLoggerPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalLoggerPersistence, LegalLoggerPersistence>(
						bundle.getBundleContext(), LegalLoggerPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}