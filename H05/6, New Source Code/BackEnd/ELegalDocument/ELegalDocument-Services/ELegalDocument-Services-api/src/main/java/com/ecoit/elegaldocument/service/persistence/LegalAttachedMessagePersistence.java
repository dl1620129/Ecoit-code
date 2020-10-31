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

import com.ecoit.elegaldocument.exception.NoSuchLegalAttachedMessageException;
import com.ecoit.elegaldocument.model.LegalAttachedMessage;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal attached message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalAttachedMessageUtil
 * @generated
 */
@ProviderType
public interface LegalAttachedMessagePersistence
	extends BasePersistence<LegalAttachedMessage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalAttachedMessageUtil} to access the legal attached message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal attached messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching legal attached messages
	 */
	public java.util.List<LegalAttachedMessage> findByArticle(String articleId);

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
	public java.util.List<LegalAttachedMessage> findByArticle(
		String articleId, int start, int end);

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
	public java.util.List<LegalAttachedMessage> findByArticle(
		String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

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
	public java.util.List<LegalAttachedMessage> findByArticle(
		String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage findByArticle_First(
			String articleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Returns the first legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage fetchByArticle_First(
		String articleId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage findByArticle_Last(
			String articleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage fetchByArticle_Last(
		String articleId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

	/**
	 * Returns the legal attached messages before and after the current legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param messageId the primary key of the current legal attached message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	public LegalAttachedMessage[] findByArticle_PrevAndNext(
			String messageId, String articleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Removes all the legal attached messages where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	public void removeByArticle(String articleId);

	/**
	 * Returns the number of legal attached messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching legal attached messages
	 */
	public int countByArticle(String articleId);

	/**
	 * Returns all the legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @return the matching legal attached messages
	 */
	public java.util.List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId);

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
	public java.util.List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId, int start, int end);

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
	public java.util.List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

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
	public java.util.List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage findByUnRead_First(
			boolean readMessage, String articleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Returns the first legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage fetchByUnRead_First(
		boolean readMessage, String articleId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

	/**
	 * Returns the last legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage findByUnRead_Last(
			boolean readMessage, String articleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Returns the last legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage fetchByUnRead_Last(
		boolean readMessage, String articleId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

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
	public LegalAttachedMessage[] findByUnRead_PrevAndNext(
			String messageId, boolean readMessage, String articleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Removes all the legal attached messages where readMessage = &#63; and articleId = &#63; from the database.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 */
	public void removeByUnRead(boolean readMessage, String articleId);

	/**
	 * Returns the number of legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @return the number of matching legal attached messages
	 */
	public int countByUnRead(boolean readMessage, String articleId);

	/**
	 * Returns all the legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @return the matching legal attached messages
	 */
	public java.util.List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage);

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
	public java.util.List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage, int start, int end);

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
	public java.util.List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

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
	public java.util.List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage findByA_R_First(
			String articleId, boolean readMessage,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Returns the first legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage fetchByA_R_First(
		String articleId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage findByA_R_Last(
			String articleId, boolean readMessage,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage fetchByA_R_Last(
		String articleId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

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
	public LegalAttachedMessage[] findByA_R_PrevAndNext(
			String messageId, String articleId, boolean readMessage,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Removes all the legal attached messages where articleId = &#63; and readMessage = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 */
	public void removeByA_R(String articleId, boolean readMessage);

	/**
	 * Returns the number of legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @return the number of matching legal attached messages
	 */
	public int countByA_R(String articleId, boolean readMessage);

	/**
	 * Returns all the legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @return the matching legal attached messages
	 */
	public java.util.List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage);

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
	public java.util.List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end);

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
	public java.util.List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

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
	public java.util.List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage findByG_R_First(
			long groupId, boolean readMessage,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Returns the first legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage fetchByG_R_First(
		long groupId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

	/**
	 * Returns the last legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage findByG_R_Last(
			long groupId, boolean readMessage,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Returns the last legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	public LegalAttachedMessage fetchByG_R_Last(
		long groupId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

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
	public LegalAttachedMessage[] findByG_R_PrevAndNext(
			String messageId, long groupId, boolean readMessage,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Removes all the legal attached messages where groupId = &#63; and readMessage = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 */
	public void removeByG_R(long groupId, boolean readMessage);

	/**
	 * Returns the number of legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @return the number of matching legal attached messages
	 */
	public int countByG_R(long groupId, boolean readMessage);

	/**
	 * Caches the legal attached message in the entity cache if it is enabled.
	 *
	 * @param legalAttachedMessage the legal attached message
	 */
	public void cacheResult(LegalAttachedMessage legalAttachedMessage);

	/**
	 * Caches the legal attached messages in the entity cache if it is enabled.
	 *
	 * @param legalAttachedMessages the legal attached messages
	 */
	public void cacheResult(
		java.util.List<LegalAttachedMessage> legalAttachedMessages);

	/**
	 * Creates a new legal attached message with the primary key. Does not add the legal attached message to the database.
	 *
	 * @param messageId the primary key for the new legal attached message
	 * @return the new legal attached message
	 */
	public LegalAttachedMessage create(String messageId);

	/**
	 * Removes the legal attached message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message that was removed
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	public LegalAttachedMessage remove(String messageId)
		throws NoSuchLegalAttachedMessageException;

	public LegalAttachedMessage updateImpl(
		LegalAttachedMessage legalAttachedMessage);

	/**
	 * Returns the legal attached message with the primary key or throws a <code>NoSuchLegalAttachedMessageException</code> if it could not be found.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	public LegalAttachedMessage findByPrimaryKey(String messageId)
		throws NoSuchLegalAttachedMessageException;

	/**
	 * Returns the legal attached message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message, or <code>null</code> if a legal attached message with the primary key could not be found
	 */
	public LegalAttachedMessage fetchByPrimaryKey(String messageId);

	/**
	 * Returns all the legal attached messages.
	 *
	 * @return the legal attached messages
	 */
	public java.util.List<LegalAttachedMessage> findAll();

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
	public java.util.List<LegalAttachedMessage> findAll(int start, int end);

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
	public java.util.List<LegalAttachedMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator);

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
	public java.util.List<LegalAttachedMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalAttachedMessage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal attached messages from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal attached messages.
	 *
	 * @return the number of legal attached messages
	 */
	public int countAll();

}