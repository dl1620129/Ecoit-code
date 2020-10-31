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

import com.software.cms.exception.NoSuchTagException;
import com.software.cms.model.Tag;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see TagUtil
 * @generated
 */
@ProviderType
public interface TagPersistence extends BasePersistence<Tag> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TagUtil} to access the tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the tags where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tags
	 */
	public java.util.List<Tag> findByUuid(String uuid);

	/**
	 * Returns a range of all the tags where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @return the range of matching tags
	 */
	public java.util.List<Tag> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the tags where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tags
	 */
	public java.util.List<Tag> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tag>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tags where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tags
	 */
	public java.util.List<Tag> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tag> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tag in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tag
	 * @throws NoSuchTagException if a matching tag could not be found
	 */
	public Tag findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Tag>
				orderByComparator)
		throws NoSuchTagException;

	/**
	 * Returns the first tag in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tag, or <code>null</code> if a matching tag could not be found
	 */
	public Tag fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tag>
			orderByComparator);

	/**
	 * Returns the last tag in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tag
	 * @throws NoSuchTagException if a matching tag could not be found
	 */
	public Tag findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Tag>
				orderByComparator)
		throws NoSuchTagException;

	/**
	 * Returns the last tag in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tag, or <code>null</code> if a matching tag could not be found
	 */
	public Tag fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tag>
			orderByComparator);

	/**
	 * Returns the tags before and after the current tag in the ordered set where uuid = &#63;.
	 *
	 * @param tagId the primary key of the current tag
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tag
	 * @throws NoSuchTagException if a tag with the primary key could not be found
	 */
	public Tag[] findByUuid_PrevAndNext(
			long tagId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Tag>
				orderByComparator)
		throws NoSuchTagException;

	/**
	 * Removes all the tags where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of tags where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tags
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the tag where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTagException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tag
	 * @throws NoSuchTagException if a matching tag could not be found
	 */
	public Tag findByUUID_G(String uuid, long groupId)
		throws NoSuchTagException;

	/**
	 * Returns the tag where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tag, or <code>null</code> if a matching tag could not be found
	 */
	public Tag fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the tag where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tag, or <code>null</code> if a matching tag could not be found
	 */
	public Tag fetchByUUID_G(String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the tag where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tag that was removed
	 */
	public Tag removeByUUID_G(String uuid, long groupId)
		throws NoSuchTagException;

	/**
	 * Returns the number of tags where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tags
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the tags where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching tags
	 */
	public java.util.List<Tag> findByGroup_Language(
		long groupId, String language);

	/**
	 * Returns a range of all the tags where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @return the range of matching tags
	 */
	public java.util.List<Tag> findByGroup_Language(
		long groupId, String language, int start, int end);

	/**
	 * Returns an ordered range of all the tags where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tags
	 */
	public java.util.List<Tag> findByGroup_Language(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tag>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tags where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tags
	 */
	public java.util.List<Tag> findByGroup_Language(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tag> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tag in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tag
	 * @throws NoSuchTagException if a matching tag could not be found
	 */
	public Tag findByGroup_Language_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<Tag>
				orderByComparator)
		throws NoSuchTagException;

	/**
	 * Returns the first tag in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tag, or <code>null</code> if a matching tag could not be found
	 */
	public Tag fetchByGroup_Language_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<Tag>
			orderByComparator);

	/**
	 * Returns the last tag in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tag
	 * @throws NoSuchTagException if a matching tag could not be found
	 */
	public Tag findByGroup_Language_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<Tag>
				orderByComparator)
		throws NoSuchTagException;

	/**
	 * Returns the last tag in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tag, or <code>null</code> if a matching tag could not be found
	 */
	public Tag fetchByGroup_Language_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<Tag>
			orderByComparator);

	/**
	 * Returns the tags before and after the current tag in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param tagId the primary key of the current tag
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tag
	 * @throws NoSuchTagException if a tag with the primary key could not be found
	 */
	public Tag[] findByGroup_Language_PrevAndNext(
			long tagId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<Tag>
				orderByComparator)
		throws NoSuchTagException;

	/**
	 * Removes all the tags where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByGroup_Language(long groupId, String language);

	/**
	 * Returns the number of tags where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching tags
	 */
	public int countByGroup_Language(long groupId, String language);

	/**
	 * Caches the tag in the entity cache if it is enabled.
	 *
	 * @param tag the tag
	 */
	public void cacheResult(Tag tag);

	/**
	 * Caches the tags in the entity cache if it is enabled.
	 *
	 * @param tags the tags
	 */
	public void cacheResult(java.util.List<Tag> tags);

	/**
	 * Creates a new tag with the primary key. Does not add the tag to the database.
	 *
	 * @param tagId the primary key for the new tag
	 * @return the new tag
	 */
	public Tag create(long tagId);

	/**
	 * Removes the tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagId the primary key of the tag
	 * @return the tag that was removed
	 * @throws NoSuchTagException if a tag with the primary key could not be found
	 */
	public Tag remove(long tagId) throws NoSuchTagException;

	public Tag updateImpl(Tag tag);

	/**
	 * Returns the tag with the primary key or throws a <code>NoSuchTagException</code> if it could not be found.
	 *
	 * @param tagId the primary key of the tag
	 * @return the tag
	 * @throws NoSuchTagException if a tag with the primary key could not be found
	 */
	public Tag findByPrimaryKey(long tagId) throws NoSuchTagException;

	/**
	 * Returns the tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagId the primary key of the tag
	 * @return the tag, or <code>null</code> if a tag with the primary key could not be found
	 */
	public Tag fetchByPrimaryKey(long tagId);

	/**
	 * Returns all the tags.
	 *
	 * @return the tags
	 */
	public java.util.List<Tag> findAll();

	/**
	 * Returns a range of all the tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @return the range of tags
	 */
	public java.util.List<Tag> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tags
	 */
	public java.util.List<Tag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tag>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tags
	 */
	public java.util.List<Tag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tag> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tags from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tags.
	 *
	 * @return the number of tags
	 */
	public int countAll();

}