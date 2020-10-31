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
 * Provides the local service utility for LegalField. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalFieldLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalFieldLocalService
 * @generated
 */
public class LegalFieldLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalFieldLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal field to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalField the legal field
	 * @return the legal field that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalField addLegalField(
		com.ecoit.elegaldocument.model.LegalField legalField) {

		return getService().addLegalField(legalField);
	}

	public static int countTotalLegalField(
		long groupId, String language, long companyId, String name) {

		return getService().countTotalLegalField(
			groupId, language, companyId, name);
	}

	/**
	 * Creates a new legal field with the primary key. Does not add the legal field to the database.
	 *
	 * @param fieldId the primary key for the new legal field
	 * @return the new legal field
	 */
	public static com.ecoit.elegaldocument.model.LegalField createLegalField(
		long fieldId) {

		return getService().createLegalField(fieldId);
	}

	public static void createUpdateLegalField(
			long userId, long scopeGroupId, String language, long companyId,
			long fieldId, String name, String description,
			boolean isStatusField, int position)
		throws Exception {

		getService().createUpdateLegalField(
			userId, scopeGroupId, language, companyId, fieldId, name,
			description, isStatusField, position);
	}

	/**
	 * Deletes the legal field from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalField the legal field
	 * @return the legal field that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalField deleteLegalField(
		com.ecoit.elegaldocument.model.LegalField legalField) {

		return getService().deleteLegalField(legalField);
	}

	/**
	 * Deletes the legal field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field that was removed
	 * @throws PortalException if a legal field with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalField deleteLegalField(
			long fieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalField(fieldId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFieldModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFieldModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalField fetchLegalField(
		long fieldId) {

		return getService().fetchLegalField(fieldId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getAllFields() {

		return getService().getAllFields();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal field with the primary key.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field
	 * @throws PortalException if a legal field with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalField getLegalField(
			long fieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalField(fieldId);
	}

	/**
	 * Returns a range of all the legal fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of legal fields
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getLegalFields(int start, int end) {

		return getService().getLegalFields(start, end);
	}

	/**
	 * Returns the number of legal fields.
	 *
	 * @return the number of legal fields
	 */
	public static int getLegalFieldsCount() {
		return getService().getLegalFieldsCount();
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getListLegalField(
			String name, long groupId, String language, long companyId,
			int start, int limit) {

		return getService().getListLegalField(
			name, groupId, language, companyId, start, limit);
	}

	public static int getMax(String language, long groupId, long companyId) {
		return getService().getMax(language, groupId, companyId);
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

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getPublishFields(String language, boolean statusField, long groupId) {

		return getService().getPublishFields(language, statusField, groupId);
	}

	/**
	 * Updates the legal field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalField the legal field
	 * @return the legal field that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalField updateLegalField(
		com.ecoit.elegaldocument.model.LegalField legalField) {

		return getService().updateLegalField(legalField);
	}

	public static LegalFieldLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalFieldLocalService, LegalFieldLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalFieldLocalService.class);

		ServiceTracker<LegalFieldLocalService, LegalFieldLocalService>
			serviceTracker =
				new ServiceTracker
					<LegalFieldLocalService, LegalFieldLocalService>(
						bundle.getBundleContext(), LegalFieldLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}