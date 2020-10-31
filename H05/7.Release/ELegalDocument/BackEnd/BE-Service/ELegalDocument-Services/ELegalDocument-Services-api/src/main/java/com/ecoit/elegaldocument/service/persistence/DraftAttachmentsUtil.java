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

import com.ecoit.elegaldocument.model.DraftAttachments;

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
 * The persistence utility for the draft attachments service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.DraftAttachmentsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see DraftAttachmentsPersistence
 * @generated
 */
public class DraftAttachmentsUtil {

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
	public static void clearCache(DraftAttachments draftAttachments) {
		getPersistence().clearCache(draftAttachments);
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
	public static Map<Serializable, DraftAttachments> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DraftAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DraftAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DraftAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DraftAttachments> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DraftAttachments update(DraftAttachments draftAttachments) {
		return getPersistence().update(draftAttachments);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DraftAttachments update(
		DraftAttachments draftAttachments, ServiceContext serviceContext) {

		return getPersistence().update(draftAttachments, serviceContext);
	}

	/**
	 * Returns all the draft attachmentses where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @return the matching draft attachmentses
	 */
	public static List<DraftAttachments> findByDraftId(long draftId) {
		return getPersistence().findByDraftId(draftId);
	}

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
	public static List<DraftAttachments> findByDraftId(
		long draftId, int start, int end) {

		return getPersistence().findByDraftId(draftId, start, end);
	}

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
	public static List<DraftAttachments> findByDraftId(
		long draftId, int start, int end,
		OrderByComparator<DraftAttachments> orderByComparator) {

		return getPersistence().findByDraftId(
			draftId, start, end, orderByComparator);
	}

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
	public static List<DraftAttachments> findByDraftId(
		long draftId, int start, int end,
		OrderByComparator<DraftAttachments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDraftId(
			draftId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching draft attachments
	 * @throws NoSuchDraftAttachmentsException if a matching draft attachments could not be found
	 */
	public static DraftAttachments findByDraftId_First(
			long draftId, OrderByComparator<DraftAttachments> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDraftAttachmentsException {

		return getPersistence().findByDraftId_First(draftId, orderByComparator);
	}

	/**
	 * Returns the first draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	public static DraftAttachments fetchByDraftId_First(
		long draftId, OrderByComparator<DraftAttachments> orderByComparator) {

		return getPersistence().fetchByDraftId_First(
			draftId, orderByComparator);
	}

	/**
	 * Returns the last draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching draft attachments
	 * @throws NoSuchDraftAttachmentsException if a matching draft attachments could not be found
	 */
	public static DraftAttachments findByDraftId_Last(
			long draftId, OrderByComparator<DraftAttachments> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDraftAttachmentsException {

		return getPersistence().findByDraftId_Last(draftId, orderByComparator);
	}

	/**
	 * Returns the last draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	public static DraftAttachments fetchByDraftId_Last(
		long draftId, OrderByComparator<DraftAttachments> orderByComparator) {

		return getPersistence().fetchByDraftId_Last(draftId, orderByComparator);
	}

	/**
	 * Returns the draft attachmentses before and after the current draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param attachmentId the primary key of the current draft attachments
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next draft attachments
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	public static DraftAttachments[] findByDraftId_PrevAndNext(
			long attachmentId, long draftId,
			OrderByComparator<DraftAttachments> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDraftAttachmentsException {

		return getPersistence().findByDraftId_PrevAndNext(
			attachmentId, draftId, orderByComparator);
	}

	/**
	 * Removes all the draft attachmentses where draftId = &#63; from the database.
	 *
	 * @param draftId the draft ID
	 */
	public static void removeByDraftId(long draftId) {
		getPersistence().removeByDraftId(draftId);
	}

	/**
	 * Returns the number of draft attachmentses where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @return the number of matching draft attachmentses
	 */
	public static int countByDraftId(long draftId) {
		return getPersistence().countByDraftId(draftId);
	}

	/**
	 * Returns the draft attachments where attachmentId = &#63; or throws a <code>NoSuchDraftAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching draft attachments
	 * @throws NoSuchDraftAttachmentsException if a matching draft attachments could not be found
	 */
	public static DraftAttachments findByAttachment(long attachmentId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDraftAttachmentsException {

		return getPersistence().findByAttachment(attachmentId);
	}

	/**
	 * Returns the draft attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	public static DraftAttachments fetchByAttachment(long attachmentId) {
		return getPersistence().fetchByAttachment(attachmentId);
	}

	/**
	 * Returns the draft attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	public static DraftAttachments fetchByAttachment(
		long attachmentId, boolean useFinderCache) {

		return getPersistence().fetchByAttachment(attachmentId, useFinderCache);
	}

	/**
	 * Removes the draft attachments where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @return the draft attachments that was removed
	 */
	public static DraftAttachments removeByAttachment(long attachmentId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDraftAttachmentsException {

		return getPersistence().removeByAttachment(attachmentId);
	}

	/**
	 * Returns the number of draft attachmentses where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching draft attachmentses
	 */
	public static int countByAttachment(long attachmentId) {
		return getPersistence().countByAttachment(attachmentId);
	}

	/**
	 * Caches the draft attachments in the entity cache if it is enabled.
	 *
	 * @param draftAttachments the draft attachments
	 */
	public static void cacheResult(DraftAttachments draftAttachments) {
		getPersistence().cacheResult(draftAttachments);
	}

	/**
	 * Caches the draft attachmentses in the entity cache if it is enabled.
	 *
	 * @param draftAttachmentses the draft attachmentses
	 */
	public static void cacheResult(List<DraftAttachments> draftAttachmentses) {
		getPersistence().cacheResult(draftAttachmentses);
	}

	/**
	 * Creates a new draft attachments with the primary key. Does not add the draft attachments to the database.
	 *
	 * @param attachmentId the primary key for the new draft attachments
	 * @return the new draft attachments
	 */
	public static DraftAttachments create(long attachmentId) {
		return getPersistence().create(attachmentId);
	}

	/**
	 * Removes the draft attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments that was removed
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	public static DraftAttachments remove(long attachmentId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDraftAttachmentsException {

		return getPersistence().remove(attachmentId);
	}

	public static DraftAttachments updateImpl(
		DraftAttachments draftAttachments) {

		return getPersistence().updateImpl(draftAttachments);
	}

	/**
	 * Returns the draft attachments with the primary key or throws a <code>NoSuchDraftAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	public static DraftAttachments findByPrimaryKey(long attachmentId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchDraftAttachmentsException {

		return getPersistence().findByPrimaryKey(attachmentId);
	}

	/**
	 * Returns the draft attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments, or <code>null</code> if a draft attachments with the primary key could not be found
	 */
	public static DraftAttachments fetchByPrimaryKey(long attachmentId) {
		return getPersistence().fetchByPrimaryKey(attachmentId);
	}

	/**
	 * Returns all the draft attachmentses.
	 *
	 * @return the draft attachmentses
	 */
	public static List<DraftAttachments> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DraftAttachments> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DraftAttachments> findAll(
		int start, int end,
		OrderByComparator<DraftAttachments> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DraftAttachments> findAll(
		int start, int end,
		OrderByComparator<DraftAttachments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the draft attachmentses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of draft attachmentses.
	 *
	 * @return the number of draft attachmentses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DraftAttachmentsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DraftAttachmentsPersistence, DraftAttachmentsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DraftAttachmentsPersistence.class);

		ServiceTracker<DraftAttachmentsPersistence, DraftAttachmentsPersistence>
			serviceTracker =
				new ServiceTracker
					<DraftAttachmentsPersistence, DraftAttachmentsPersistence>(
						bundle.getBundleContext(),
						DraftAttachmentsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}