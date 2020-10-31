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

import com.ecoit.elegaldocument.exception.NoSuchDraftAttachmentsException;
import com.ecoit.elegaldocument.model.DraftAttachments;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the draft attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see DraftAttachmentsUtil
 * @generated
 */
@ProviderType
public interface DraftAttachmentsPersistence
	extends BasePersistence<DraftAttachments> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DraftAttachmentsUtil} to access the draft attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the draft attachmentses where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @return the matching draft attachmentses
	 */
	public java.util.List<DraftAttachments> findByDraftId(long draftId);

	/**
	 * Returns a range of all the draft attachmentses where draftId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param draftId the draft ID
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @return the range of matching draft attachmentses
	 */
	public java.util.List<DraftAttachments> findByDraftId(
		long draftId, int start, int end);

	/**
	 * Returns an ordered range of all the draft attachmentses where draftId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param draftId the draft ID
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching draft attachmentses
	 */
	public java.util.List<DraftAttachments> findByDraftId(
		long draftId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DraftAttachments>
			orderByComparator);

	/**
	 * Returns an ordered range of all the draft attachmentses where draftId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param draftId the draft ID
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching draft attachmentses
	 */
	public java.util.List<DraftAttachments> findByDraftId(
		long draftId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DraftAttachments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching draft attachments
	 * @throws NoSuchDraftAttachmentsException if a matching draft attachments could not be found
	 */
	public DraftAttachments findByDraftId_First(
			long draftId,
			com.liferay.portal.kernel.util.OrderByComparator<DraftAttachments>
				orderByComparator)
		throws NoSuchDraftAttachmentsException;

	/**
	 * Returns the first draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	public DraftAttachments fetchByDraftId_First(
		long draftId,
		com.liferay.portal.kernel.util.OrderByComparator<DraftAttachments>
			orderByComparator);

	/**
	 * Returns the last draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching draft attachments
	 * @throws NoSuchDraftAttachmentsException if a matching draft attachments could not be found
	 */
	public DraftAttachments findByDraftId_Last(
			long draftId,
			com.liferay.portal.kernel.util.OrderByComparator<DraftAttachments>
				orderByComparator)
		throws NoSuchDraftAttachmentsException;

	/**
	 * Returns the last draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	public DraftAttachments fetchByDraftId_Last(
		long draftId,
		com.liferay.portal.kernel.util.OrderByComparator<DraftAttachments>
			orderByComparator);

	/**
	 * Returns the draft attachmentses before and after the current draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param attachmentId the primary key of the current draft attachments
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next draft attachments
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	public DraftAttachments[] findByDraftId_PrevAndNext(
			long attachmentId, long draftId,
			com.liferay.portal.kernel.util.OrderByComparator<DraftAttachments>
				orderByComparator)
		throws NoSuchDraftAttachmentsException;

	/**
	 * Removes all the draft attachmentses where draftId = &#63; from the database.
	 *
	 * @param draftId the draft ID
	 */
	public void removeByDraftId(long draftId);

	/**
	 * Returns the number of draft attachmentses where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @return the number of matching draft attachmentses
	 */
	public int countByDraftId(long draftId);

	/**
	 * Returns the draft attachments where attachmentId = &#63; or throws a <code>NoSuchDraftAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching draft attachments
	 * @throws NoSuchDraftAttachmentsException if a matching draft attachments could not be found
	 */
	public DraftAttachments findByAttachment(long attachmentId)
		throws NoSuchDraftAttachmentsException;

	/**
	 * Returns the draft attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	public DraftAttachments fetchByAttachment(long attachmentId);

	/**
	 * Returns the draft attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	public DraftAttachments fetchByAttachment(
		long attachmentId, boolean useFinderCache);

	/**
	 * Removes the draft attachments where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @return the draft attachments that was removed
	 */
	public DraftAttachments removeByAttachment(long attachmentId)
		throws NoSuchDraftAttachmentsException;

	/**
	 * Returns the number of draft attachmentses where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching draft attachmentses
	 */
	public int countByAttachment(long attachmentId);

	/**
	 * Caches the draft attachments in the entity cache if it is enabled.
	 *
	 * @param draftAttachments the draft attachments
	 */
	public void cacheResult(DraftAttachments draftAttachments);

	/**
	 * Caches the draft attachmentses in the entity cache if it is enabled.
	 *
	 * @param draftAttachmentses the draft attachmentses
	 */
	public void cacheResult(
		java.util.List<DraftAttachments> draftAttachmentses);

	/**
	 * Creates a new draft attachments with the primary key. Does not add the draft attachments to the database.
	 *
	 * @param attachmentId the primary key for the new draft attachments
	 * @return the new draft attachments
	 */
	public DraftAttachments create(long attachmentId);

	/**
	 * Removes the draft attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments that was removed
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	public DraftAttachments remove(long attachmentId)
		throws NoSuchDraftAttachmentsException;

	public DraftAttachments updateImpl(DraftAttachments draftAttachments);

	/**
	 * Returns the draft attachments with the primary key or throws a <code>NoSuchDraftAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	public DraftAttachments findByPrimaryKey(long attachmentId)
		throws NoSuchDraftAttachmentsException;

	/**
	 * Returns the draft attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments, or <code>null</code> if a draft attachments with the primary key could not be found
	 */
	public DraftAttachments fetchByPrimaryKey(long attachmentId);

	/**
	 * Returns all the draft attachmentses.
	 *
	 * @return the draft attachmentses
	 */
	public java.util.List<DraftAttachments> findAll();

	/**
	 * Returns a range of all the draft attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @return the range of draft attachmentses
	 */
	public java.util.List<DraftAttachments> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the draft attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of draft attachmentses
	 */
	public java.util.List<DraftAttachments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DraftAttachments>
			orderByComparator);

	/**
	 * Returns an ordered range of all the draft attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of draft attachmentses
	 */
	public java.util.List<DraftAttachments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DraftAttachments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the draft attachmentses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of draft attachmentses.
	 *
	 * @return the number of draft attachmentses
	 */
	public int countAll();

}