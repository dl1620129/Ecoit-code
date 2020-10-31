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
 * Provides the local service utility for EcmsGURelation. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.EcmsGURelationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see EcmsGURelationLocalService
 * @generated
 */
public class EcmsGURelationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.EcmsGURelationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ecms gu relation to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGURelation the ecms gu relation
	 * @return the ecms gu relation that was added
	 */
	public static com.ecoit.elegaldocument.model.EcmsGURelation
		addEcmsGURelation(
			com.ecoit.elegaldocument.model.EcmsGURelation ecmsGURelation) {

		return getService().addEcmsGURelation(ecmsGURelation);
	}

	/**
	 * Creates a new ecms gu relation with the primary key. Does not add the ecms gu relation to the database.
	 *
	 * @param ecmsGURelationPK the primary key for the new ecms gu relation
	 * @return the new ecms gu relation
	 */
	public static com.ecoit.elegaldocument.model.EcmsGURelation
		createEcmsGURelation(
			com.ecoit.elegaldocument.service.persistence.EcmsGURelationPK
				ecmsGURelationPK) {

		return getService().createEcmsGURelation(ecmsGURelationPK);
	}

	/**
	 * Deletes the ecms gu relation from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGURelation the ecms gu relation
	 * @return the ecms gu relation that was removed
	 */
	public static com.ecoit.elegaldocument.model.EcmsGURelation
		deleteEcmsGURelation(
			com.ecoit.elegaldocument.model.EcmsGURelation ecmsGURelation) {

		return getService().deleteEcmsGURelation(ecmsGURelation);
	}

	/**
	 * Deletes the ecms gu relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation that was removed
	 * @throws PortalException if a ecms gu relation with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.EcmsGURelation
			deleteEcmsGURelation(
				com.ecoit.elegaldocument.service.persistence.EcmsGURelationPK
					ecmsGURelationPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEcmsGURelation(ecmsGURelationPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsGURelationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsGURelationModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.EcmsGURelation
		fetchEcmsGURelation(
			com.ecoit.elegaldocument.service.persistence.EcmsGURelationPK
				ecmsGURelationPK) {

		return getService().fetchEcmsGURelation(ecmsGURelationPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ecms gu relation with the primary key.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation
	 * @throws PortalException if a ecms gu relation with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.EcmsGURelation
			getEcmsGURelation(
				com.ecoit.elegaldocument.service.persistence.EcmsGURelationPK
					ecmsGURelationPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEcmsGURelation(ecmsGURelationPK);
	}

	/**
	 * Returns a range of all the ecms gu relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @return the range of ecms gu relations
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.EcmsGURelation>
		getEcmsGURelations(int start, int end) {

		return getService().getEcmsGURelations(start, end);
	}

	/**
	 * Returns the number of ecms gu relations.
	 *
	 * @return the number of ecms gu relations
	 */
	public static int getEcmsGURelationsCount() {
		return getService().getEcmsGURelationsCount();
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
	 * Updates the ecms gu relation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGURelation the ecms gu relation
	 * @return the ecms gu relation that was updated
	 */
	public static com.ecoit.elegaldocument.model.EcmsGURelation
		updateEcmsGURelation(
			com.ecoit.elegaldocument.model.EcmsGURelation ecmsGURelation) {

		return getService().updateEcmsGURelation(ecmsGURelation);
	}

	public static EcmsGURelationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EcmsGURelationLocalService, EcmsGURelationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EcmsGURelationLocalService.class);

		ServiceTracker<EcmsGURelationLocalService, EcmsGURelationLocalService>
			serviceTracker =
				new ServiceTracker
					<EcmsGURelationLocalService, EcmsGURelationLocalService>(
						bundle.getBundleContext(),
						EcmsGURelationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}