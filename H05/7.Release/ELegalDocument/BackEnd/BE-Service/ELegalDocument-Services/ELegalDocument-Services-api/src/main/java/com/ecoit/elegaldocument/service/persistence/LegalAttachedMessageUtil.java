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

import com.ecoit.elegaldocument.model.LegalAttachedMessage;

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
 * The persistence utility for the legal attached message service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalAttachedMessagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalAttachedMessagePersistence
 * @generated
 */
public class LegalAttachedMessageUtil {

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
	public static void clearCache(LegalAttachedMessage legalAttachedMessage) {
		getPersistence().clearCache(legalAttachedMessage);
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
	public static Map<Serializable, LegalAttachedMessage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalAttachedMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalAttachedMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalAttachedMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalAttachedMessage update(
		LegalAttachedMessage legalAttachedMessage) {

		return getPersistence().update(legalAttachedMessage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalAttachedMessage update(
		LegalAttachedMessage legalAttachedMessage,
		ServiceContext serviceContext) {

		return getPersistence().update(legalAttachedMessage, serviceContext);
	}

	/**
	 * Returns all the legal attached messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByArticle(String articleId) {
		return getPersistence().findByArticle(articleId);
	}

	/**
	 * Returns a range of all the legal attached messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByArticle(
		String articleId, int start, int end) {

		return getPersistence().findByArticle(articleId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByArticle(
		String articleId, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().findByArticle(
			articleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByArticle(
		String articleId, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByArticle(
			articleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage findByArticle_First(
			String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByArticle_First(
			articleId, orderByComparator);
	}

	/**
	 * Returns the first legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage fetchByArticle_First(
		String articleId,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().fetchByArticle_First(
			articleId, orderByComparator);
	}

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage findByArticle_Last(
			String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByArticle_Last(
			articleId, orderByComparator);
	}

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage fetchByArticle_Last(
		String articleId,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().fetchByArticle_Last(
			articleId, orderByComparator);
	}

	/**
	 * Returns the legal attached messages before and after the current legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param messageId the primary key of the current legal attached message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	public static LegalAttachedMessage[] findByArticle_PrevAndNext(
			String messageId, String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByArticle_PrevAndNext(
			messageId, articleId, orderByComparator);
	}

	/**
	 * Removes all the legal attached messages where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	public static void removeByArticle(String articleId) {
		getPersistence().removeByArticle(articleId);
	}

	/**
	 * Returns the number of legal attached messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching legal attached messages
	 */
	public static int countByArticle(String articleId) {
		return getPersistence().countByArticle(articleId);
	}

	/**
	 * Returns all the legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @return the matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId) {

		return getPersistence().findByUnRead(readMessage, articleId);
	}

	/**
	 * Returns a range of all the legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId, int start, int end) {

		return getPersistence().findByUnRead(
			readMessage, articleId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().findByUnRead(
			readMessage, articleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnRead(
			readMessage, articleId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage findByUnRead_First(
			boolean readMessage, String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByUnRead_First(
			readMessage, articleId, orderByComparator);
	}

	/**
	 * Returns the first legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage fetchByUnRead_First(
		boolean readMessage, String articleId,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().fetchByUnRead_First(
			readMessage, articleId, orderByComparator);
	}

	/**
	 * Returns the last legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage findByUnRead_Last(
			boolean readMessage, String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByUnRead_Last(
			readMessage, articleId, orderByComparator);
	}

	/**
	 * Returns the last legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage fetchByUnRead_Last(
		boolean readMessage, String articleId,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().fetchByUnRead_Last(
			readMessage, articleId, orderByComparator);
	}

	/**
	 * Returns the legal attached messages before and after the current legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param messageId the primary key of the current legal attached message
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	public static LegalAttachedMessage[] findByUnRead_PrevAndNext(
			String messageId, boolean readMessage, String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByUnRead_PrevAndNext(
			messageId, readMessage, articleId, orderByComparator);
	}

	/**
	 * Removes all the legal attached messages where readMessage = &#63; and articleId = &#63; from the database.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 */
	public static void removeByUnRead(boolean readMessage, String articleId) {
		getPersistence().removeByUnRead(readMessage, articleId);
	}

	/**
	 * Returns the number of legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @return the number of matching legal attached messages
	 */
	public static int countByUnRead(boolean readMessage, String articleId) {
		return getPersistence().countByUnRead(readMessage, articleId);
	}

	/**
	 * Returns all the legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @return the matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage) {

		return getPersistence().findByA_R(articleId, readMessage);
	}

	/**
	 * Returns a range of all the legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage, int start, int end) {

		return getPersistence().findByA_R(articleId, readMessage, start, end);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().findByA_R(
			articleId, readMessage, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByA_R(
			articleId, readMessage, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage findByA_R_First(
			String articleId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByA_R_First(
			articleId, readMessage, orderByComparator);
	}

	/**
	 * Returns the first legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage fetchByA_R_First(
		String articleId, boolean readMessage,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().fetchByA_R_First(
			articleId, readMessage, orderByComparator);
	}

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage findByA_R_Last(
			String articleId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByA_R_Last(
			articleId, readMessage, orderByComparator);
	}

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage fetchByA_R_Last(
		String articleId, boolean readMessage,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().fetchByA_R_Last(
			articleId, readMessage, orderByComparator);
	}

	/**
	 * Returns the legal attached messages before and after the current legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param messageId the primary key of the current legal attached message
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	public static LegalAttachedMessage[] findByA_R_PrevAndNext(
			String messageId, String articleId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByA_R_PrevAndNext(
			messageId, articleId, readMessage, orderByComparator);
	}

	/**
	 * Removes all the legal attached messages where articleId = &#63; and readMessage = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 */
	public static void removeByA_R(String articleId, boolean readMessage) {
		getPersistence().removeByA_R(articleId, readMessage);
	}

	/**
	 * Returns the number of legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @return the number of matching legal attached messages
	 */
	public static int countByA_R(String articleId, boolean readMessage) {
		return getPersistence().countByA_R(articleId, readMessage);
	}

	/**
	 * Returns all the legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @return the matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage) {

		return getPersistence().findByG_R(groupId, readMessage);
	}

	/**
	 * Returns a range of all the legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end) {

		return getPersistence().findByG_R(groupId, readMessage, start, end);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().findByG_R(
			groupId, readMessage, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal attached messages
	 */
	public static List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_R(
			groupId, readMessage, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage findByG_R_First(
			long groupId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByG_R_First(
			groupId, readMessage, orderByComparator);
	}

	/**
	 * Returns the first legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage fetchByG_R_First(
		long groupId, boolean readMessage,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().fetchByG_R_First(
			groupId, readMessage, orderByComparator);
	}

	/**
	 * Returns the last legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage findByG_R_Last(
			long groupId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByG_R_Last(
			groupId, readMessage, orderByComparator);
	}

	/**
	 * Returns the last legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public static LegalAttachedMessage fetchByG_R_Last(
		long groupId, boolean readMessage,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().fetchByG_R_Last(
			groupId, readMessage, orderByComparator);
	}

	/**
	 * Returns the legal attached messages before and after the current legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param messageId the primary key of the current legal attached message
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	public static LegalAttachedMessage[] findByG_R_PrevAndNext(
			String messageId, long groupId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByG_R_PrevAndNext(
			messageId, groupId, readMessage, orderByComparator);
	}

	/**
	 * Removes all the legal attached messages where groupId = &#63; and readMessage = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 */
	public static void removeByG_R(long groupId, boolean readMessage) {
		getPersistence().removeByG_R(groupId, readMessage);
	}

	/**
	 * Returns the number of legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @return the number of matching legal attached messages
	 */
	public static int countByG_R(long groupId, boolean readMessage) {
		return getPersistence().countByG_R(groupId, readMessage);
	}

	/**
	 * Caches the legal attached message in the entity cache if it is enabled.
	 *
	 * @param legalAttachedMessage the legal attached message
	 */
	public static void cacheResult(LegalAttachedMessage legalAttachedMessage) {
		getPersistence().cacheResult(legalAttachedMessage);
	}

	/**
	 * Caches the legal attached messages in the entity cache if it is enabled.
	 *
	 * @param legalAttachedMessages the legal attached messages
	 */
	public static void cacheResult(
		List<LegalAttachedMessage> legalAttachedMessages) {

		getPersistence().cacheResult(legalAttachedMessages);
	}

	/**
	 * Creates a new legal attached message with the primary key. Does not add the legal attached message to the database.
	 *
	 * @param messageId the primary key for the new legal attached message
	 * @return the new legal attached message
	 */
	public static LegalAttachedMessage create(String messageId) {
		return getPersistence().create(messageId);
	}

	/**
	 * Removes the legal attached message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message that was removed
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	public static LegalAttachedMessage remove(String messageId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().remove(messageId);
	}

	public static LegalAttachedMessage updateImpl(
		LegalAttachedMessage legalAttachedMessage) {

		return getPersistence().updateImpl(legalAttachedMessage);
	}

	/**
	 * Returns the legal attached message with the primary key or throws a <code>NoSuchLegalAttachedMessageException</code> if it could not be found.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	public static LegalAttachedMessage findByPrimaryKey(String messageId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalAttachedMessageException {

		return getPersistence().findByPrimaryKey(messageId);
	}

	/**
	 * Returns the legal attached message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message, or <code>null</code> if a legal attached message with the primary key could not be found
	 */
	public static LegalAttachedMessage fetchByPrimaryKey(String messageId) {
		return getPersistence().fetchByPrimaryKey(messageId);
	}

	/**
	 * Returns all the legal attached messages.
	 *
	 * @return the legal attached messages
	 */
	public static List<LegalAttachedMessage> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal attached messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of legal attached messages
	 */
	public static List<LegalAttachedMessage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal attached messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal attached messages
	 */
	public static List<LegalAttachedMessage> findAll(
		int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal attached messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal attached messages
	 */
	public static List<LegalAttachedMessage> findAll(
		int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal attached messages from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal attached messages.
	 *
	 * @return the number of legal attached messages
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalAttachedMessagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalAttachedMessagePersistence, LegalAttachedMessagePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalAttachedMessagePersistence.class);

		ServiceTracker
			<LegalAttachedMessagePersistence, LegalAttachedMessagePersistence>
				serviceTracker =
					new ServiceTracker
						<LegalAttachedMessagePersistence,
						 LegalAttachedMessagePersistence>(
							 bundle.getBundleContext(),
							 LegalAttachedMessagePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}