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

import com.ecoit.elegaldocument.model.DocumentAttachments;

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
 * The persistence utility for the document attachments service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.DocumentAttachmentsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see DocumentAttachmentsPersistence
 * @generated
 */
public class DocumentAttachmentsUtil {

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
	public static void clearCache(DocumentAttachments documentAttachments) {
		getPersistence().clearCache(documentAttachments);
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
	public static Map<Serializable, DocumentAttachments> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocumentAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentAttachments> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentAttachments update(
		DocumentAttachments documentAttachments) {

		return getPersistence().update(documentAttachments);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentAttachments update(
		DocumentAttachments documentAttachments,
		ServiceContext serviceContext) {

		return getPersistence().update(documentAttachments, serviceContext);
	}

	/**
	 * Returns all the document attachmentses where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching document attachmentses
	 */
	public static List<DocumentAttachments> findBydocId(long docId) {
		return getPersistence().findBydocId(docId);
	}

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
	public static List<DocumentAttachments> findBydocId(
		long docId, int start, int end) {

		return getPersistence().findBydocId(docId, start, end);
	}

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
	public static List<DocumentAttachments> findBydocId(
		long docId, int start, int end,
		OrderByComparator<DocumentAttachments> orderByComparator) {

		return getPersistence().findBydocId(
			docId, start, end, orderByComparator);
	}

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
	public static List<DocumentAttachments> findBydocId(
		long docId, int start, int end,
		OrderByComparator<DocumentAttachments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydocId(
			docId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document attachments
	 * @throws NoSuchDocumentAttachmentsException if a matching document attachments could not be found
	 */
	public static DocumentAttachments findBydocId_First(
			long docId,
			OrderByComparator<DocumentAttachments> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDocumentAttachmentsException {

		return getPersistence().findBydocId_First(docId, orderByComparator);
	}

	/**
	 * Returns the first document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	public static DocumentAttachments fetchBydocId_First(
		long docId, OrderByComparator<DocumentAttachments> orderByComparator) {

		return getPersistence().fetchBydocId_First(docId, orderByComparator);
	}

	/**
	 * Returns the last document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document attachments
	 * @throws NoSuchDocumentAttachmentsException if a matching document attachments could not be found
	 */
	public static DocumentAttachments findBydocId_Last(
			long docId,
			OrderByComparator<DocumentAttachments> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDocumentAttachmentsException {

		return getPersistence().findBydocId_Last(docId, orderByComparator);
	}

	/**
	 * Returns the last document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	public static DocumentAttachments fetchBydocId_Last(
		long docId, OrderByComparator<DocumentAttachments> orderByComparator) {

		return getPersistence().fetchBydocId_Last(docId, orderByComparator);
	}

	/**
	 * Returns the document attachmentses before and after the current document attachments in the ordered set where docId = &#63;.
	 *
	 * @param attachmentId the primary key of the current document attachments
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document attachments
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	public static DocumentAttachments[] findBydocId_PrevAndNext(
			long attachmentId, long docId,
			OrderByComparator<DocumentAttachments> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDocumentAttachmentsException {

		return getPersistence().findBydocId_PrevAndNext(
			attachmentId, docId, orderByComparator);
	}

	/**
	 * Removes all the document attachmentses where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public static void removeBydocId(long docId) {
		getPersistence().removeBydocId(docId);
	}

	/**
	 * Returns the number of document attachmentses where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching document attachmentses
	 */
	public static int countBydocId(long docId) {
		return getPersistence().countBydocId(docId);
	}

	/**
	 * Returns the document attachments where attachmentId = &#63; or throws a <code>NoSuchDocumentAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching document attachments
	 * @throws NoSuchDocumentAttachmentsException if a matching document attachments could not be found
	 */
	public static DocumentAttachments findByAttachment(long attachmentId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDocumentAttachmentsException {

		return getPersistence().findByAttachment(attachmentId);
	}

	/**
	 * Returns the document attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	public static DocumentAttachments fetchByAttachment(long attachmentId) {
		return getPersistence().fetchByAttachment(attachmentId);
	}

	/**
	 * Returns the document attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	public static DocumentAttachments fetchByAttachment(
		long attachmentId, boolean useFinderCache) {

		return getPersistence().fetchByAttachment(attachmentId, useFinderCache);
	}

	/**
	 * Removes the document attachments where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @return the document attachments that was removed
	 */
	public static DocumentAttachments removeByAttachment(long attachmentId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDocumentAttachmentsException {

		return getPersistence().removeByAttachment(attachmentId);
	}

	/**
	 * Returns the number of document attachmentses where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching document attachmentses
	 */
	public static int countByAttachment(long attachmentId) {
		return getPersistence().countByAttachment(attachmentId);
	}

	/**
	 * Caches the document attachments in the entity cache if it is enabled.
	 *
	 * @param documentAttachments the document attachments
	 */
	public static void cacheResult(DocumentAttachments documentAttachments) {
		getPersistence().cacheResult(documentAttachments);
	}

	/**
	 * Caches the document attachmentses in the entity cache if it is enabled.
	 *
	 * @param documentAttachmentses the document attachmentses
	 */
	public static void cacheResult(
		List<DocumentAttachments> documentAttachmentses) {

		getPersistence().cacheResult(documentAttachmentses);
	}

	/**
	 * Creates a new document attachments with the primary key. Does not add the document attachments to the database.
	 *
	 * @param attachmentId the primary key for the new document attachments
	 * @return the new document attachments
	 */
	public static DocumentAttachments create(long attachmentId) {
		return getPersistence().create(attachmentId);
	}

	/**
	 * Removes the document attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments that was removed
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	public static DocumentAttachments remove(long attachmentId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDocumentAttachmentsException {

		return getPersistence().remove(attachmentId);
	}

	public static DocumentAttachments updateImpl(
		DocumentAttachments documentAttachments) {

		return getPersistence().updateImpl(documentAttachments);
	}

	/**
	 * Returns the document attachments with the primary key or throws a <code>NoSuchDocumentAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	public static DocumentAttachments findByPrimaryKey(long attachmentId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDocumentAttachmentsException {

		return getPersistence().findByPrimaryKey(attachmentId);
	}

	/**
	 * Returns the document attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments, or <code>null</code> if a document attachments with the primary key could not be found
	 */
	public static DocumentAttachments fetchByPrimaryKey(long attachmentId) {
		return getPersistence().fetchByPrimaryKey(attachmentId);
	}

	/**
	 * Returns all the document attachmentses.
	 *
	 * @return the document attachmentses
	 */
	public static List<DocumentAttachments> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DocumentAttachments> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DocumentAttachments> findAll(
		int start, int end,
		OrderByComparator<DocumentAttachments> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DocumentAttachments> findAll(
		int start, int end,
		OrderByComparator<DocumentAttachments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the document attachmentses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of document attachmentses.
	 *
	 * @return the number of document attachmentses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentAttachmentsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DocumentAttachmentsPersistence, DocumentAttachmentsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DocumentAttachmentsPersistence.class);

		ServiceTracker
			<DocumentAttachmentsPersistence, DocumentAttachmentsPersistence>
				serviceTracker =
					new ServiceTracker
						<DocumentAttachmentsPersistence,
						 DocumentAttachmentsPersistence>(
							 bundle.getBundleContext(),
							 DocumentAttachmentsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}