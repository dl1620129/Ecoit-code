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

package com.software.cms.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.software.cms.exception.NoSuchArticleMailSendException;
import com.software.cms.model.ArticleMailSend;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the article mail send service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see ArticleMailSendUtil
 * @generated
 */
@ProviderType
public interface ArticleMailSendPersistence
	extends BasePersistence<ArticleMailSend> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticleMailSendUtil} to access the article mail send persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the article mail sends where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching article mail sends
	 */
	public java.util.List<ArticleMailSend> findByUuid(String uuid);

	/**
	 * Returns a range of all the article mail sends where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @return the range of matching article mail sends
	 */
	public java.util.List<ArticleMailSend> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the article mail sends where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article mail sends
	 */
	public java.util.List<ArticleMailSend> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMailSend>
			orderByComparator);

	/**
	 * Returns an ordered range of all the article mail sends where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article mail sends
	 */
	public java.util.List<ArticleMailSend> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMailSend>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article mail send
	 * @throws NoSuchArticleMailSendException if a matching article mail send could not be found
	 */
	public ArticleMailSend findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleMailSend>
				orderByComparator)
		throws NoSuchArticleMailSendException;

	/**
	 * Returns the first article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	public ArticleMailSend fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMailSend>
			orderByComparator);

	/**
	 * Returns the last article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article mail send
	 * @throws NoSuchArticleMailSendException if a matching article mail send could not be found
	 */
	public ArticleMailSend findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleMailSend>
				orderByComparator)
		throws NoSuchArticleMailSendException;

	/**
	 * Returns the last article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	public ArticleMailSend fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMailSend>
			orderByComparator);

	/**
	 * Returns the article mail sends before and after the current article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param mailSendId the primary key of the current article mail send
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article mail send
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	public ArticleMailSend[] findByUuid_PrevAndNext(
			long mailSendId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleMailSend>
				orderByComparator)
		throws NoSuchArticleMailSendException;

	/**
	 * Removes all the article mail sends where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of article mail sends where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching article mail sends
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the article mail send where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchArticleMailSendException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article mail send
	 * @throws NoSuchArticleMailSendException if a matching article mail send could not be found
	 */
	public ArticleMailSend findByUUID_G(String uuid, long groupId)
		throws NoSuchArticleMailSendException;

	/**
	 * Returns the article mail send where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	public ArticleMailSend fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the article mail send where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	public ArticleMailSend fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the article mail send where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the article mail send that was removed
	 */
	public ArticleMailSend removeByUUID_G(String uuid, long groupId)
		throws NoSuchArticleMailSendException;

	/**
	 * Returns the number of article mail sends where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching article mail sends
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Caches the article mail send in the entity cache if it is enabled.
	 *
	 * @param articleMailSend the article mail send
	 */
	public void cacheResult(ArticleMailSend articleMailSend);

	/**
	 * Caches the article mail sends in the entity cache if it is enabled.
	 *
	 * @param articleMailSends the article mail sends
	 */
	public void cacheResult(java.util.List<ArticleMailSend> articleMailSends);

	/**
	 * Creates a new article mail send with the primary key. Does not add the article mail send to the database.
	 *
	 * @param mailSendId the primary key for the new article mail send
	 * @return the new article mail send
	 */
	public ArticleMailSend create(long mailSendId);

	/**
	 * Removes the article mail send with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send that was removed
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	public ArticleMailSend remove(long mailSendId)
		throws NoSuchArticleMailSendException;

	public ArticleMailSend updateImpl(ArticleMailSend articleMailSend);

	/**
	 * Returns the article mail send with the primary key or throws a <code>NoSuchArticleMailSendException</code> if it could not be found.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	public ArticleMailSend findByPrimaryKey(long mailSendId)
		throws NoSuchArticleMailSendException;

	/**
	 * Returns the article mail send with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send, or <code>null</code> if a article mail send with the primary key could not be found
	 */
	public ArticleMailSend fetchByPrimaryKey(long mailSendId);

	/**
	 * Returns all the article mail sends.
	 *
	 * @return the article mail sends
	 */
	public java.util.List<ArticleMailSend> findAll();

	/**
	 * Returns a range of all the article mail sends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @return the range of article mail sends
	 */
	public java.util.List<ArticleMailSend> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the article mail sends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of article mail sends
	 */
	public java.util.List<ArticleMailSend> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMailSend>
			orderByComparator);

	/**
	 * Returns an ordered range of all the article mail sends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of article mail sends
	 */
	public java.util.List<ArticleMailSend> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMailSend>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the article mail sends from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of article mail sends.
	 *
	 * @return the number of article mail sends
	 */
	public int countAll();

}