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

import com.ecoit.elegaldocument.model.LegalSigner;

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
 * The persistence utility for the legal signer service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalSignerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalSignerPersistence
 * @generated
 */
public class LegalSignerUtil {

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
	public static void clearCache(LegalSigner legalSigner) {
		getPersistence().clearCache(legalSigner);
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
	public static Map<Serializable, LegalSigner> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalSigner> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalSigner> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalSigner> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalSigner update(LegalSigner legalSigner) {
		return getPersistence().update(legalSigner);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalSigner update(
		LegalSigner legalSigner, ServiceContext serviceContext) {

		return getPersistence().update(legalSigner, serviceContext);
	}

	/**
	 * Returns the legal signer where sigId = &#63; or throws a <code>NoSuchLegalSignerException</code> if it could not be found.
	 *
	 * @param sigId the sig ID
	 * @return the matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findBySigId(long sigId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findBySigId(sigId);
	}

	/**
	 * Returns the legal signer where sigId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sigId the sig ID
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchBySigId(long sigId) {
		return getPersistence().fetchBySigId(sigId);
	}

	/**
	 * Returns the legal signer where sigId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sigId the sig ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchBySigId(long sigId, boolean useFinderCache) {
		return getPersistence().fetchBySigId(sigId, useFinderCache);
	}

	/**
	 * Removes the legal signer where sigId = &#63; from the database.
	 *
	 * @param sigId the sig ID
	 * @return the legal signer that was removed
	 */
	public static LegalSigner removeBySigId(long sigId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().removeBySigId(sigId);
	}

	/**
	 * Returns the number of legal signers where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the number of matching legal signers
	 */
	public static int countBySigId(long sigId) {
		return getPersistence().countBySigId(sigId);
	}

	/**
	 * Returns all the legal signers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal signers
	 */
	public static List<LegalSigner> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the legal signers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public static List<LegalSigner> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByGroupId_First(
			long groupId, OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByGroupId_First(
		long groupId, OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByGroupId_Last(
			long groupId, OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public static LegalSigner[] findByGroupId_PrevAndNext(
			long sigId, long groupId,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByGroupId_PrevAndNext(
			sigId, groupId, orderByComparator);
	}

	/**
	 * Removes all the legal signers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of legal signers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal signers
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the legal signer where groupId = &#63; and sigId = &#63; or throws a <code>NoSuchLegalSignerException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByG_S(long groupId, long sigId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByG_S(groupId, sigId);
	}

	/**
	 * Returns the legal signer where groupId = &#63; and sigId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByG_S(long groupId, long sigId) {
		return getPersistence().fetchByG_S(groupId, sigId);
	}

	/**
	 * Returns the legal signer where groupId = &#63; and sigId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByG_S(
		long groupId, long sigId, boolean useFinderCache) {

		return getPersistence().fetchByG_S(groupId, sigId, useFinderCache);
	}

	/**
	 * Removes the legal signer where groupId = &#63; and sigId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the legal signer that was removed
	 */
	public static LegalSigner removeByG_S(long groupId, long sigId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().removeByG_S(groupId, sigId);
	}

	/**
	 * Returns the number of legal signers where groupId = &#63; and sigId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the number of matching legal signers
	 */
	public static int countByG_S(long groupId, long sigId) {
		return getPersistence().countByG_S(groupId, sigId);
	}

	/**
	 * Returns all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal signers
	 */
	public static List<LegalSigner> findByG_L(long groupId, String language) {
		return getPersistence().findByG_L(groupId, language);
	}

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public static List<LegalSigner> findByG_L(
		long groupId, String language, int start, int end) {

		return getPersistence().findByG_L(groupId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public static LegalSigner[] findByG_L_PrevAndNext(
			long sigId, long groupId, String language,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByG_L_PrevAndNext(
			sigId, groupId, language, orderByComparator);
	}

	/**
	 * Removes all the legal signers where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public static void removeByG_L(long groupId, String language) {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	 * Returns the number of legal signers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal signers
	 */
	public static int countByG_L(long groupId, String language) {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	 * Returns all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @return the matching legal signers
	 */
	public static List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner) {

		return getPersistence().findByG_L_S(groupId, language, statusSigner);
	}

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public static List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner, int start,
		int end) {

		return getPersistence().findByG_L_S(
			groupId, language, statusSigner, start, end);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().findByG_L_S(
			groupId, language, statusSigner, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_S(
			groupId, language, statusSigner, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByG_L_S_First(
			long groupId, String language, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByG_L_S_First(
			groupId, language, statusSigner, orderByComparator);
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByG_L_S_First(
		long groupId, String language, boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByG_L_S_First(
			groupId, language, statusSigner, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByG_L_S_Last(
			long groupId, String language, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByG_L_S_Last(
			groupId, language, statusSigner, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByG_L_S_Last(
		long groupId, String language, boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByG_L_S_Last(
			groupId, language, statusSigner, orderByComparator);
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public static LegalSigner[] findByG_L_S_PrevAndNext(
			long sigId, long groupId, String language, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByG_L_S_PrevAndNext(
			sigId, groupId, language, statusSigner, orderByComparator);
	}

	/**
	 * Removes all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 */
	public static void removeByG_L_S(
		long groupId, String language, boolean statusSigner) {

		getPersistence().removeByG_L_S(groupId, language, statusSigner);
	}

	/**
	 * Returns the number of legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @return the number of matching legal signers
	 */
	public static int countByG_L_S(
		long groupId, String language, boolean statusSigner) {

		return getPersistence().countByG_L_S(groupId, language, statusSigner);
	}

	/**
	 * Returns all the legal signers where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @return the matching legal signers
	 */
	public static List<LegalSigner> findByStatusSIGN(boolean statusSigner) {
		return getPersistence().findByStatusSIGN(statusSigner);
	}

	/**
	 * Returns a range of all the legal signers where statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public static List<LegalSigner> findByStatusSIGN(
		boolean statusSigner, int start, int end) {

		return getPersistence().findByStatusSIGN(statusSigner, start, end);
	}

	/**
	 * Returns an ordered range of all the legal signers where statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByStatusSIGN(
		boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().findByStatusSIGN(
			statusSigner, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal signers where statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByStatusSIGN(
		boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatusSIGN(
			statusSigner, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByStatusSIGN_First(
			boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByStatusSIGN_First(
			statusSigner, orderByComparator);
	}

	/**
	 * Returns the first legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByStatusSIGN_First(
		boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByStatusSIGN_First(
			statusSigner, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByStatusSIGN_Last(
			boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByStatusSIGN_Last(
			statusSigner, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByStatusSIGN_Last(
		boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByStatusSIGN_Last(
			statusSigner, orderByComparator);
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public static LegalSigner[] findByStatusSIGN_PrevAndNext(
			long sigId, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByStatusSIGN_PrevAndNext(
			sigId, statusSigner, orderByComparator);
	}

	/**
	 * Removes all the legal signers where statusSigner = &#63; from the database.
	 *
	 * @param statusSigner the status signer
	 */
	public static void removeByStatusSIGN(boolean statusSigner) {
		getPersistence().removeByStatusSIGN(statusSigner);
	}

	/**
	 * Returns the number of legal signers where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @return the number of matching legal signers
	 */
	public static int countByStatusSIGN(boolean statusSigner) {
		return getPersistence().countByStatusSIGN(statusSigner);
	}

	/**
	 * Returns all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @return the matching legal signers
	 */
	public static List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusSigner);
	}

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public static List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner, int start,
		int end) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusSigner, start, end);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusSigner, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusSigner, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByFindGroup_First(
			long groupId, long companyId, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByFindGroup_First(
			groupId, companyId, statusSigner, orderByComparator);
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByFindGroup_First(
		long groupId, long companyId, boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByFindGroup_First(
			groupId, companyId, statusSigner, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByFindGroup_Last(
			long groupId, long companyId, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByFindGroup_Last(
			groupId, companyId, statusSigner, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByFindGroup_Last(
			groupId, companyId, statusSigner, orderByComparator);
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public static LegalSigner[] findByFindGroup_PrevAndNext(
			long sigId, long groupId, long companyId, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByFindGroup_PrevAndNext(
			sigId, groupId, companyId, statusSigner, orderByComparator);
	}

	/**
	 * Removes all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 */
	public static void removeByFindGroup(
		long groupId, long companyId, boolean statusSigner) {

		getPersistence().removeByFindGroup(groupId, companyId, statusSigner);
	}

	/**
	 * Returns the number of legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @return the number of matching legal signers
	 */
	public static int countByFindGroup(
		long groupId, long companyId, boolean statusSigner) {

		return getPersistence().countByFindGroup(
			groupId, companyId, statusSigner);
	}

	/**
	 * Returns all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal signers
	 */
	public static List<LegalSigner> findByFindAll(
		long groupId, long companyId) {

		return getPersistence().findByFindAll(groupId, companyId);
	}

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public static List<LegalSigner> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindAll(groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public static List<LegalSigner> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public static LegalSigner findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public static LegalSigner fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public static LegalSigner[] findByFindAll_PrevAndNext(
			long sigId, long groupId, long companyId,
			OrderByComparator<LegalSigner> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByFindAll_PrevAndNext(
			sigId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the legal signers where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindAll(long groupId, long companyId) {
		getPersistence().removeByFindAll(groupId, companyId);
	}

	/**
	 * Returns the number of legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal signers
	 */
	public static int countByFindAll(long groupId, long companyId) {
		return getPersistence().countByFindAll(groupId, companyId);
	}

	/**
	 * Caches the legal signer in the entity cache if it is enabled.
	 *
	 * @param legalSigner the legal signer
	 */
	public static void cacheResult(LegalSigner legalSigner) {
		getPersistence().cacheResult(legalSigner);
	}

	/**
	 * Caches the legal signers in the entity cache if it is enabled.
	 *
	 * @param legalSigners the legal signers
	 */
	public static void cacheResult(List<LegalSigner> legalSigners) {
		getPersistence().cacheResult(legalSigners);
	}

	/**
	 * Creates a new legal signer with the primary key. Does not add the legal signer to the database.
	 *
	 * @param sigId the primary key for the new legal signer
	 * @return the new legal signer
	 */
	public static LegalSigner create(long sigId) {
		return getPersistence().create(sigId);
	}

	/**
	 * Removes the legal signer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer that was removed
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public static LegalSigner remove(long sigId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().remove(sigId);
	}

	public static LegalSigner updateImpl(LegalSigner legalSigner) {
		return getPersistence().updateImpl(legalSigner);
	}

	/**
	 * Returns the legal signer with the primary key or throws a <code>NoSuchLegalSignerException</code> if it could not be found.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public static LegalSigner findByPrimaryKey(long sigId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalSignerException {

		return getPersistence().findByPrimaryKey(sigId);
	}

	/**
	 * Returns the legal signer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer, or <code>null</code> if a legal signer with the primary key could not be found
	 */
	public static LegalSigner fetchByPrimaryKey(long sigId) {
		return getPersistence().fetchByPrimaryKey(sigId);
	}

	/**
	 * Returns all the legal signers.
	 *
	 * @return the legal signers
	 */
	public static List<LegalSigner> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of legal signers
	 */
	public static List<LegalSigner> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal signers
	 */
	public static List<LegalSigner> findAll(
		int start, int end, OrderByComparator<LegalSigner> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal signers
	 */
	public static List<LegalSigner> findAll(
		int start, int end, OrderByComparator<LegalSigner> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal signers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal signers.
	 *
	 * @return the number of legal signers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalSignerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalSignerPersistence, LegalSignerPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalSignerPersistence.class);

		ServiceTracker<LegalSignerPersistence, LegalSignerPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalSignerPersistence, LegalSignerPersistence>(
						bundle.getBundleContext(), LegalSignerPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}