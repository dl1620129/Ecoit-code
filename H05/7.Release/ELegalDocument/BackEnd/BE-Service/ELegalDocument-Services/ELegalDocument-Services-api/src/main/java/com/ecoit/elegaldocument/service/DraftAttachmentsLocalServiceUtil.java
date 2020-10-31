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

package com.ecoit.elegaldocument.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for DraftAttachments. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.DraftAttachmentsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see DraftAttachmentsLocalService
 * @generated
 */
public class DraftAttachmentsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.DraftAttachmentsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the draft attachments to the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftAttachments the draft attachments
	 * @return the draft attachments that was added
	 */
	public static com.ecoit.elegaldocument.model.DraftAttachments
		addDraftAttachments(
			com.ecoit.elegaldocument.model.DraftAttachments draftAttachments) {

		return getService().addDraftAttachments(draftAttachments);
	}

	/**
	 * Creates a new draft attachments with the primary key. Does not add the draft attachments to the database.
	 *
	 * @param attachmentId the primary key for the new draft attachments
	 * @return the new draft attachments
	 */
	public static com.ecoit.elegaldocument.model.DraftAttachments
		createDraftAttachments(long attachmentId) {

		return getService().createDraftAttachments(attachmentId);
	}

	/**
	 * Deletes the draft attachments from the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftAttachments the draft attachments
	 * @return the draft attachments that was removed
	 */
	public static com.ecoit.elegaldocument.model.DraftAttachments
		deleteDraftAttachments(
			com.ecoit.elegaldocument.model.DraftAttachments draftAttachments) {

		return getService().deleteDraftAttachments(draftAttachments);
	}

	/**
	 * Deletes the draft attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments that was removed
	 * @throws PortalException if a draft attachments with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.DraftAttachments
			deleteDraftAttachments(long attachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDraftAttachments(attachmentId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ecoit.elegaldocument.model.DraftAttachments
		fetchDraftAttachments(long attachmentId) {

		return getService().fetchDraftAttachments(attachmentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the draft attachments with the primary key.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments
	 * @throws PortalException if a draft attachments with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.DraftAttachments
			getDraftAttachments(long attachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDraftAttachments(attachmentId);
	}

	/**
	 * Returns a range of all the draft attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @return the range of draft attachmentses
	 */
	public static java.util.List
		<com.ecoit.elegaldocument.model.DraftAttachments> getDraftAttachmentses(
			int start, int end) {

		return getService().getDraftAttachmentses(start, end);
	}

	/**
	 * Returns the number of draft attachmentses.
	 *
	 * @return the number of draft attachmentses
	 */
	public static int getDraftAttachmentsesCount() {
		return getService().getDraftAttachmentsesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the draft attachments in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param draftAttachments the draft attachments
	 * @return the draft attachments that was updated
	 */
	public static com.ecoit.elegaldocument.model.DraftAttachments
		updateDraftAttachments(
			com.ecoit.elegaldocument.model.DraftAttachments draftAttachments) {

		return getService().updateDraftAttachments(draftAttachments);
	}

	public static DraftAttachmentsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DraftAttachmentsLocalService, DraftAttachmentsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DraftAttachmentsLocalService.class);

		ServiceTracker
			<DraftAttachmentsLocalService, DraftAttachmentsLocalService>
				serviceTracker =
					new ServiceTracker
						<DraftAttachmentsLocalService,
						 DraftAttachmentsLocalService>(
							 bundle.getBundleContext(),
							 DraftAttachmentsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}