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

import com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException;
import com.ecoit.elegaldocument.model.LegalLogger;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal logger service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalLoggerUtil
 * @generated
 */
@ProviderType
public interface LegalLoggerPersistence extends BasePersistence<LegalLogger> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalLoggerUtil} to access the legal logger persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @return the matching legal loggers
	 */
	public java.util.List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate);

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
	public java.util.List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate, int start, int end);

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
	public java.util.List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator);

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
	public java.util.List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public LegalLogger findByU_D_First(
			String createdByUser, Date createdDate,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
				orderByComparator)
		throws NoSuchLegalLoggerException;

	/**
	 * Returns the first legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public LegalLogger fetchByU_D_First(
		String createdByUser, Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator);

	/**
	 * Returns the last legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public LegalLogger findByU_D_Last(
			String createdByUser, Date createdDate,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
				orderByComparator)
		throws NoSuchLegalLoggerException;

	/**
	 * Returns the last legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public LegalLogger fetchByU_D_Last(
		String createdByUser, Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator);

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
	public LegalLogger[] findByU_D_PrevAndNext(
			String loggerId, String createdByUser, Date createdDate,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
				orderByComparator)
		throws NoSuchLegalLoggerException;

	/**
	 * Removes all the legal loggers where createdByUser = &#63; and createdDate = &#63; from the database.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 */
	public void removeByU_D(String createdByUser, Date createdDate);

	/**
	 * Returns the number of legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @return the number of matching legal loggers
	 */
	public int countByU_D(String createdByUser, Date createdDate);

	/**
	 * Returns all the legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @return the matching legal loggers
	 */
	public java.util.List<LegalLogger> findByE_C(
		String entryId, String classEntry);

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
	public java.util.List<LegalLogger> findByE_C(
		String entryId, String classEntry, int start, int end);

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
	public java.util.List<LegalLogger> findByE_C(
		String entryId, String classEntry, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator);

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
	public java.util.List<LegalLogger> findByE_C(
		String entryId, String classEntry, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public LegalLogger findByE_C_First(
			String entryId, String classEntry,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
				orderByComparator)
		throws NoSuchLegalLoggerException;

	/**
	 * Returns the first legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public LegalLogger fetchByE_C_First(
		String entryId, String classEntry,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator);

	/**
	 * Returns the last legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public LegalLogger findByE_C_Last(
			String entryId, String classEntry,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
				orderByComparator)
		throws NoSuchLegalLoggerException;

	/**
	 * Returns the last legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public LegalLogger fetchByE_C_Last(
		String entryId, String classEntry,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator);

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
	public LegalLogger[] findByE_C_PrevAndNext(
			String loggerId, String entryId, String classEntry,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
				orderByComparator)
		throws NoSuchLegalLoggerException;

	/**
	 * Removes all the legal loggers where entryId = &#63; and classEntry = &#63; from the database.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 */
	public void removeByE_C(String entryId, String classEntry);

	/**
	 * Returns the number of legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @return the number of matching legal loggers
	 */
	public int countByE_C(String entryId, String classEntry);

	/**
	 * Returns all the legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal loggers
	 */
	public java.util.List<LegalLogger> findByFindAll(
		long groupId, long companyId);

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
	public java.util.List<LegalLogger> findByFindAll(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<LegalLogger> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator);

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
	public java.util.List<LegalLogger> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public LegalLogger findByFindAll_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
				orderByComparator)
		throws NoSuchLegalLoggerException;

	/**
	 * Returns the first legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public LegalLogger fetchByFindAll_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator);

	/**
	 * Returns the last legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	public LegalLogger findByFindAll_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
				orderByComparator)
		throws NoSuchLegalLoggerException;

	/**
	 * Returns the last legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	public LegalLogger fetchByFindAll_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator);

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
	public LegalLogger[] findByFindAll_PrevAndNext(
			String loggerId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
				orderByComparator)
		throws NoSuchLegalLoggerException;

	/**
	 * Removes all the legal loggers where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal loggers
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Caches the legal logger in the entity cache if it is enabled.
	 *
	 * @param legalLogger the legal logger
	 */
	public void cacheResult(LegalLogger legalLogger);

	/**
	 * Caches the legal loggers in the entity cache if it is enabled.
	 *
	 * @param legalLoggers the legal loggers
	 */
	public void cacheResult(java.util.List<LegalLogger> legalLoggers);

	/**
	 * Creates a new legal logger with the primary key. Does not add the legal logger to the database.
	 *
	 * @param loggerId the primary key for the new legal logger
	 * @return the new legal logger
	 */
	public LegalLogger create(String loggerId);

	/**
	 * Removes the legal logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger that was removed
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	public LegalLogger remove(String loggerId)
		throws NoSuchLegalLoggerException;

	public LegalLogger updateImpl(LegalLogger legalLogger);

	/**
	 * Returns the legal logger with the primary key or throws a <code>NoSuchLegalLoggerException</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	public LegalLogger findByPrimaryKey(String loggerId)
		throws NoSuchLegalLoggerException;

	/**
	 * Returns the legal logger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger, or <code>null</code> if a legal logger with the primary key could not be found
	 */
	public LegalLogger fetchByPrimaryKey(String loggerId);

	/**
	 * Returns all the legal loggers.
	 *
	 * @return the legal loggers
	 */
	public java.util.List<LegalLogger> findAll();

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
	public java.util.List<LegalLogger> findAll(int start, int end);

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
	public java.util.List<LegalLogger> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator);

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
	public java.util.List<LegalLogger> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLogger>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal loggers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal loggers.
	 *
	 * @return the number of legal loggers
	 */
	public int countAll();

}