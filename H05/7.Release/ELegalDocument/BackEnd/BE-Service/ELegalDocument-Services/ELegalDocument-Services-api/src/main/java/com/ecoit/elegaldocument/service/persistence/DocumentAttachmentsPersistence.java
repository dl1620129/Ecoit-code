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

import com.ecoit.elegaldocument.exception.NoSuchDocumentAttachmentsException;
import com.ecoit.elegaldocument.model.DocumentAttachments;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the document attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see DocumentAttachmentsUtil
 * @generated
 */
@ProviderType
public interface DocumentAttachmentsPersistence
	extends BasePersistence<DocumentAttachments> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentAttachmentsUtil} to access the document attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the document attachmentses where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching document attachmentses
	 */
	public java.util.List<DocumentAttachments> findBydocId(long docId);

	/**
	 * Returns a range of all the document attachmentses where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @return the range of matching document attachmentses
	 */
	public java.util.List<DocumentAttachments> findBydocId(
		long docId, int start, int end);

	/**
	 * Returns an ordered range of all the document attachmentses where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document attachmentses
	 */
	public java.util.List<DocumentAttachments> findBydocId(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentAttachments>
			orderByComparator);

	/**
	 * Returns an ordered range of all the document attachmentses where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document attachmentses
	 */
	public java.util.List<DocumentAttachments> findBydocId(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentAttachments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document attachments
	 * @throws NoSuchDocumentAttachmentsException if a matching document attachments could not be found
	 */
	public DocumentAttachments findBydocId_First(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DocumentAttachments> orderByComparator)
		throws NoSuchDocumentAttachmentsException;

	/**
	 * Returns the first document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	public DocumentAttachments fetchBydocId_First(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentAttachments>
			orderByComparator);

	/**
	 * Returns the last document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document attachments
	 * @throws NoSuchDocumentAttachmentsException if a matching document attachments could not be found
	 */
	public DocumentAttachments findBydocId_Last(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DocumentAttachments> orderByComparator)
		throws NoSuchDocumentAttachmentsException;

	/**
	 * Returns the last document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	public DocumentAttachments fetchBydocId_Last(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentAttachments>
			orderByComparator);

	/**
	 * Returns the document attachmentses before and after the current document attachments in the ordered set where docId = &#63;.
	 *
	 * @param attachmentId the primary key of the current document attachments
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document attachments
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	public DocumentAttachments[] findBydocId_PrevAndNext(
			long attachmentId, long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DocumentAttachments> orderByComparator)
		throws NoSuchDocumentAttachmentsException;

	/**
	 * Removes all the document attachmentses where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public void removeBydocId(long docId);

	/**
	 * Returns the number of document attachmentses where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching document attachmentses
	 */
	public int countBydocId(long docId);

	/**
	 * Returns the document attachments where attachmentId = &#63; or throws a <code>NoSuchDocumentAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching document attachments
	 * @throws NoSuchDocumentAttachmentsException if a matching document attachments could not be found
	 */
	public DocumentAttachments findByAttachment(long attachmentId)
		throws NoSuchDocumentAttachmentsException;

	/**
	 * Returns the document attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	public DocumentAttachments fetchByAttachment(long attachmentId);

	/**
	 * Returns the document attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	public DocumentAttachments fetchByAttachment(
		long attachmentId, boolean useFinderCache);

	/**
	 * Removes the document attachments where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @return the document attachments that was removed
	 */
	public DocumentAttachments removeByAttachment(long attachmentId)
		throws NoSuchDocumentAttachmentsException;

	/**
	 * Returns the number of document attachmentses where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching document attachmentses
	 */
	public int countByAttachment(long attachmentId);

	/**
	 * Caches the document attachments in the entity cache if it is enabled.
	 *
	 * @param documentAttachments the document attachments
	 */
	public void cacheResult(DocumentAttachments documentAttachments);

	/**
	 * Caches the document attachmentses in the entity cache if it is enabled.
	 *
	 * @param documentAttachmentses the document attachmentses
	 */
	public void cacheResult(
		java.util.List<DocumentAttachments> documentAttachmentses);

	/**
	 * Creates a new document attachments with the primary key. Does not add the document attachments to the database.
	 *
	 * @param attachmentId the primary key for the new document attachments
	 * @return the new document attachments
	 */
	public DocumentAttachments create(long attachmentId);

	/**
	 * Removes the document attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments that was removed
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	public DocumentAttachments remove(long attachmentId)
		throws NoSuchDocumentAttachmentsException;

	public DocumentAttachments updateImpl(
		DocumentAttachments documentAttachments);

	/**
	 * Returns the document attachments with the primary key or throws a <code>NoSuchDocumentAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	public DocumentAttachments findByPrimaryKey(long attachmentId)
		throws NoSuchDocumentAttachmentsException;

	/**
	 * Returns the document attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments, or <code>null</code> if a document attachments with the primary key could not be found
	 */
	public DocumentAttachments fetchByPrimaryKey(long attachmentId);

	/**
	 * Returns all the document attachmentses.
	 *
	 * @return the document attachmentses
	 */
	public java.util.List<DocumentAttachments> findAll();

	/**
	 * Returns a range of all the document attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @return the range of document attachmentses
	 */
	public java.util.List<DocumentAttachments> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the document attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document attachmentses
	 */
	public java.util.List<DocumentAttachments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentAttachments>
			orderByComparator);

	/**
	 * Returns an ordered range of all the document attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document attachmentses
	 */
	public java.util.List<DocumentAttachments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentAttachments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the document attachmentses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of document attachmentses.
	 *
	 * @return the number of document attachmentses
	 */
	public int countAll();

}