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

package com.ecoit.qa.service.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AttachmentAnswer. This utility wraps
 * <code>com.ecoit.qa.service.service.impl.AttachmentAnswerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentAnswerLocalService
 * @generated
 */
public class AttachmentAnswerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.qa.service.service.impl.AttachmentAnswerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the attachment answer to the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was added
	 */
	public static com.ecoit.qa.service.model.AttachmentAnswer
		addAttachmentAnswer(
			com.ecoit.qa.service.model.AttachmentAnswer attachmentAnswer) {

		return getService().addAttachmentAnswer(attachmentAnswer);
	}

	/**
	 * Creates a new attachment answer with the primary key. Does not add the attachment answer to the database.
	 *
	 * @param attachmentAnswerPK the primary key for the new attachment answer
	 * @return the new attachment answer
	 */
	public static com.ecoit.qa.service.model.AttachmentAnswer
		createAttachmentAnswer(
			com.ecoit.qa.service.service.persistence.AttachmentAnswerPK
				attachmentAnswerPK) {

		return getService().createAttachmentAnswer(attachmentAnswerPK);
	}

	public static void createAttachmentAnswer(
		long answerId, long attachmentId) {

		getService().createAttachmentAnswer(answerId, attachmentId);
	}

	/**
	 * Deletes the attachment answer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was removed
	 */
	public static com.ecoit.qa.service.model.AttachmentAnswer
		deleteAttachmentAnswer(
			com.ecoit.qa.service.model.AttachmentAnswer attachmentAnswer) {

		return getService().deleteAttachmentAnswer(attachmentAnswer);
	}

	/**
	 * Deletes the attachment answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer that was removed
	 * @throws PortalException if a attachment answer with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.AttachmentAnswer
			deleteAttachmentAnswer(
				com.ecoit.qa.service.service.persistence.AttachmentAnswerPK
					attachmentAnswerPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAttachmentAnswer(attachmentAnswerPK);
	}

	public static void deleteByAnswerId(long answerId) {
		getService().deleteByAnswerId(answerId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
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

	public static com.ecoit.qa.service.model.AttachmentAnswer
		fetchAttachmentAnswer(
			com.ecoit.qa.service.service.persistence.AttachmentAnswerPK
				attachmentAnswerPK) {

		return getService().fetchAttachmentAnswer(attachmentAnswerPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the attachment answer with the primary key.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer
	 * @throws PortalException if a attachment answer with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.AttachmentAnswer
			getAttachmentAnswer(
				com.ecoit.qa.service.service.persistence.AttachmentAnswerPK
					attachmentAnswerPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAttachmentAnswer(attachmentAnswerPK);
	}

	/**
	 * Returns a range of all the attachment answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @return the range of attachment answers
	 */
	public static java.util.List<com.ecoit.qa.service.model.AttachmentAnswer>
		getAttachmentAnswers(int start, int end) {

		return getService().getAttachmentAnswers(start, end);
	}

	/**
	 * Returns the number of attachment answers.
	 *
	 * @return the number of attachment answers
	 */
	public static int getAttachmentAnswersCount() {
		return getService().getAttachmentAnswersCount();
	}

	public static java.util.List<com.ecoit.qa.service.model.AttachmentAnswer>
		getByAnswerId(long answerId) {

		return getService().getByAnswerId(answerId);
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
	 * Updates the attachment answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was updated
	 */
	public static com.ecoit.qa.service.model.AttachmentAnswer
		updateAttachmentAnswer(
			com.ecoit.qa.service.model.AttachmentAnswer attachmentAnswer) {

		return getService().updateAttachmentAnswer(attachmentAnswer);
	}

	public static AttachmentAnswerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AttachmentAnswerLocalService, AttachmentAnswerLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AttachmentAnswerLocalService.class);

		ServiceTracker
			<AttachmentAnswerLocalService, AttachmentAnswerLocalService>
				serviceTracker =
					new ServiceTracker
						<AttachmentAnswerLocalService,
						 AttachmentAnswerLocalService>(
							 bundle.getBundleContext(),
							 AttachmentAnswerLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}