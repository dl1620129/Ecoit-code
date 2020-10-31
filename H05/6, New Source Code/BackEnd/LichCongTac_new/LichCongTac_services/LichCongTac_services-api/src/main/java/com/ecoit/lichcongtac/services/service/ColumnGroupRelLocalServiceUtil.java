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

package com.ecoit.lichcongtac.services.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ColumnGroupRel. This utility wraps
 * <code>com.ecoit.lichcongtac.services.service.impl.ColumnGroupRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ColumnGroupRelLocalService
 * @generated
 */
public class ColumnGroupRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.lichcongtac.services.service.impl.ColumnGroupRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the column group rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRel the column group rel
	 * @return the column group rel that was added
	 */
	public static com.ecoit.lichcongtac.services.model.ColumnGroupRel
		addColumnGroupRel(
			com.ecoit.lichcongtac.services.model.ColumnGroupRel
				columnGroupRel) {

		return getService().addColumnGroupRel(columnGroupRel);
	}

	public static boolean checkPermission(long userGroupId, int columnId) {
		return getService().checkPermission(userGroupId, columnId);
	}

	/**
	 * Creates a new column group rel with the primary key. Does not add the column group rel to the database.
	 *
	 * @param columnGroupRelPK the primary key for the new column group rel
	 * @return the new column group rel
	 */
	public static com.ecoit.lichcongtac.services.model.ColumnGroupRel
		createColumnGroupRel(
			com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK
				columnGroupRelPK) {

		return getService().createColumnGroupRel(columnGroupRelPK);
	}

	public static void createColumnGroupRel(long userGroupId, int columnId) {
		getService().createColumnGroupRel(userGroupId, columnId);
	}

	/**
	 * Deletes the column group rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRel the column group rel
	 * @return the column group rel that was removed
	 */
	public static com.ecoit.lichcongtac.services.model.ColumnGroupRel
		deleteColumnGroupRel(
			com.ecoit.lichcongtac.services.model.ColumnGroupRel
				columnGroupRel) {

		return getService().deleteColumnGroupRel(columnGroupRel);
	}

	/**
	 * Deletes the column group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel that was removed
	 * @throws PortalException if a column group rel with the primary key could not be found
	 */
	public static com.ecoit.lichcongtac.services.model.ColumnGroupRel
			deleteColumnGroupRel(
				com.ecoit.lichcongtac.services.service.persistence.
					ColumnGroupRelPK columnGroupRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteColumnGroupRel(columnGroupRelPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.ColumnGroupRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.ColumnGroupRelModelImpl</code>.
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

	public static com.ecoit.lichcongtac.services.model.ColumnGroupRel
		fetchColumnGroupRel(
			com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK
				columnGroupRelPK) {

		return getService().fetchColumnGroupRel(columnGroupRelPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.ecoit.lichcongtac.services.model.ColumnGroupRel> getByGroupId(
			long groupId) {

		return getService().getByGroupId(groupId);
	}

	/**
	 * Returns the column group rel with the primary key.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel
	 * @throws PortalException if a column group rel with the primary key could not be found
	 */
	public static com.ecoit.lichcongtac.services.model.ColumnGroupRel
			getColumnGroupRel(
				com.ecoit.lichcongtac.services.service.persistence.
					ColumnGroupRelPK columnGroupRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getColumnGroupRel(columnGroupRelPK);
	}

	/**
	 * Returns a range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @return the range of column group rels
	 */
	public static java.util.List
		<com.ecoit.lichcongtac.services.model.ColumnGroupRel>
			getColumnGroupRels(int start, int end) {

		return getService().getColumnGroupRels(start, end);
	}

	/**
	 * Returns the number of column group rels.
	 *
	 * @return the number of column group rels
	 */
	public static int getColumnGroupRelsCount() {
		return getService().getColumnGroupRelsCount();
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
	 * Updates the column group rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRel the column group rel
	 * @return the column group rel that was updated
	 */
	public static com.ecoit.lichcongtac.services.model.ColumnGroupRel
		updateColumnGroupRel(
			com.ecoit.lichcongtac.services.model.ColumnGroupRel
				columnGroupRel) {

		return getService().updateColumnGroupRel(columnGroupRel);
	}

	public static ColumnGroupRelLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ColumnGroupRelLocalService, ColumnGroupRelLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ColumnGroupRelLocalService.class);

		ServiceTracker<ColumnGroupRelLocalService, ColumnGroupRelLocalService>
			serviceTracker =
				new ServiceTracker
					<ColumnGroupRelLocalService, ColumnGroupRelLocalService>(
						bundle.getBundleContext(),
						ColumnGroupRelLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}