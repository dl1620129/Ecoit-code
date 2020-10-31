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
 * Provides the local service utility for EcmsPGRelation. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.EcmsPGRelationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see EcmsPGRelationLocalService
 * @generated
 */
public class EcmsPGRelationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.EcmsPGRelationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ecms pg relation to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsPGRelation the ecms pg relation
	 * @return the ecms pg relation that was added
	 */
	public static com.ecoit.elegaldocument.model.EcmsPGRelation
		addEcmsPGRelation(
			com.ecoit.elegaldocument.model.EcmsPGRelation ecmsPGRelation) {

		return getService().addEcmsPGRelation(ecmsPGRelation);
	}

	/**
	 * Creates a new ecms pg relation with the primary key. Does not add the ecms pg relation to the database.
	 *
	 * @param ecmsPGRelationPK the primary key for the new ecms pg relation
	 * @return the new ecms pg relation
	 */
	public static com.ecoit.elegaldocument.model.EcmsPGRelation
		createEcmsPGRelation(
			com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK
				ecmsPGRelationPK) {

		return getService().createEcmsPGRelation(ecmsPGRelationPK);
	}

	/**
	 * Deletes the ecms pg relation from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsPGRelation the ecms pg relation
	 * @return the ecms pg relation that was removed
	 */
	public static com.ecoit.elegaldocument.model.EcmsPGRelation
		deleteEcmsPGRelation(
			com.ecoit.elegaldocument.model.EcmsPGRelation ecmsPGRelation) {

		return getService().deleteEcmsPGRelation(ecmsPGRelation);
	}

	/**
	 * Deletes the ecms pg relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation that was removed
	 * @throws PortalException if a ecms pg relation with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.EcmsPGRelation
			deleteEcmsPGRelation(
				com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK
					ecmsPGRelationPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEcmsPGRelation(ecmsPGRelationPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsPGRelationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsPGRelationModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.EcmsPGRelation
		fetchEcmsPGRelation(
			com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK
				ecmsPGRelationPK) {

		return getService().fetchEcmsPGRelation(ecmsPGRelationPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ecms pg relation with the primary key.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation
	 * @throws PortalException if a ecms pg relation with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.EcmsPGRelation
			getEcmsPGRelation(
				com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK
					ecmsPGRelationPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEcmsPGRelation(ecmsPGRelationPK);
	}

	/**
	 * Returns a range of all the ecms pg relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @return the range of ecms pg relations
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.EcmsPGRelation>
		getEcmsPGRelations(int start, int end) {

		return getService().getEcmsPGRelations(start, end);
	}

	/**
	 * Returns the number of ecms pg relations.
	 *
	 * @return the number of ecms pg relations
	 */
	public static int getEcmsPGRelationsCount() {
		return getService().getEcmsPGRelationsCount();
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
	 * Updates the ecms pg relation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsPGRelation the ecms pg relation
	 * @return the ecms pg relation that was updated
	 */
	public static com.ecoit.elegaldocument.model.EcmsPGRelation
		updateEcmsPGRelation(
			com.ecoit.elegaldocument.model.EcmsPGRelation ecmsPGRelation) {

		return getService().updateEcmsPGRelation(ecmsPGRelation);
	}

	public static EcmsPGRelationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EcmsPGRelationLocalService, EcmsPGRelationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EcmsPGRelationLocalService.class);

		ServiceTracker<EcmsPGRelationLocalService, EcmsPGRelationLocalService>
			serviceTracker =
				new ServiceTracker
					<EcmsPGRelationLocalService, EcmsPGRelationLocalService>(
						bundle.getBundleContext(),
						EcmsPGRelationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}