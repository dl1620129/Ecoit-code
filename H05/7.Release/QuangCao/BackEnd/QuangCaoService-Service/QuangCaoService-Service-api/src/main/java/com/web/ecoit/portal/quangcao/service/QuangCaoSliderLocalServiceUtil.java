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

package com.web.ecoit.portal.quangcao.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for QuangCaoSlider. This utility wraps
 * <code>com.web.ecoit.portal.quangcao.service.impl.QuangCaoSliderLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoSliderLocalService
 * @generated
 */
@ProviderType
public class QuangCaoSliderLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.web.ecoit.portal.quangcao.service.impl.QuangCaoSliderLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the quang cao slider to the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSlider the quang cao slider
	 * @return the quang cao slider that was added
	 */
	public static com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		addQuangCaoSlider(
			com.web.ecoit.portal.quangcao.model.QuangCaoSlider quangCaoSlider) {

		return getService().addQuangCaoSlider(quangCaoSlider);
	}

	/**
	 * Creates a new quang cao slider with the primary key. Does not add the quang cao slider to the database.
	 *
	 * @param quangCaoSliderId the primary key for the new quang cao slider
	 * @return the new quang cao slider
	 */
	public static com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		createQuangCaoSlider(long quangCaoSliderId) {

		return getService().createQuangCaoSlider(quangCaoSliderId);
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

	/**
	 * Deletes the quang cao slider with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider that was removed
	 * @throws PortalException if a quang cao slider with the primary key could not be found
	 */
	public static com.web.ecoit.portal.quangcao.model.QuangCaoSlider
			deleteQuangCaoSlider(long quangCaoSliderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteQuangCaoSlider(quangCaoSliderId);
	}

	/**
	 * Deletes the quang cao slider from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSlider the quang cao slider
	 * @return the quang cao slider that was removed
	 */
	public static com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		deleteQuangCaoSlider(
			com.web.ecoit.portal.quangcao.model.QuangCaoSlider quangCaoSlider) {

		return getService().deleteQuangCaoSlider(quangCaoSlider);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.web.ecoit.portal.quangcao.model.impl.QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.web.ecoit.portal.quangcao.model.impl.QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		fetchQuangCaoSlider(long quangCaoSliderId) {

		return getService().fetchQuangCaoSlider(quangCaoSliderId);
	}

	/**
	 * Returns the quang cao slider matching the UUID and group.
	 *
	 * @param uuid the quang cao slider's UUID
	 * @param groupId the primary key of the group
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public static com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		fetchQuangCaoSliderByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchQuangCaoSliderByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List
		<com.web.ecoit.portal.quangcao.model.QuangCaoSlider>
			findBybyQuangCaoIdAndGroupId(long quangCaoId, long groupId) {

		return getService().findBybyQuangCaoIdAndGroupId(quangCaoId, groupId);
	}

	public static com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		findBybyQuangCaoSliderIdAndGroupId(
			long quangCaoSliderId, long groupId) {

		return getService().findBybyQuangCaoSliderIdAndGroupId(
			quangCaoSliderId, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the quang cao slider with the primary key.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider
	 * @throws PortalException if a quang cao slider with the primary key could not be found
	 */
	public static com.web.ecoit.portal.quangcao.model.QuangCaoSlider
			getQuangCaoSlider(long quangCaoSliderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuangCaoSlider(quangCaoSliderId);
	}

	/**
	 * Returns the quang cao slider matching the UUID and group.
	 *
	 * @param uuid the quang cao slider's UUID
	 * @param groupId the primary key of the group
	 * @return the matching quang cao slider
	 * @throws PortalException if a matching quang cao slider could not be found
	 */
	public static com.web.ecoit.portal.quangcao.model.QuangCaoSlider
			getQuangCaoSliderByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuangCaoSliderByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the quang cao sliders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.web.ecoit.portal.quangcao.model.impl.QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @return the range of quang cao sliders
	 */
	public static java.util.List
		<com.web.ecoit.portal.quangcao.model.QuangCaoSlider> getQuangCaoSliders(
			int start, int end) {

		return getService().getQuangCaoSliders(start, end);
	}

	/**
	 * Returns the number of quang cao sliders.
	 *
	 * @return the number of quang cao sliders
	 */
	public static int getQuangCaoSlidersCount() {
		return getService().getQuangCaoSlidersCount();
	}

	/**
	 * Updates the quang cao slider in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSlider the quang cao slider
	 * @return the quang cao slider that was updated
	 */
	public static com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		updateQuangCaoSlider(
			com.web.ecoit.portal.quangcao.model.QuangCaoSlider quangCaoSlider) {

		return getService().updateQuangCaoSlider(quangCaoSlider);
	}

	public static QuangCaoSliderLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuangCaoSliderLocalService, QuangCaoSliderLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuangCaoSliderLocalService.class);

		ServiceTracker<QuangCaoSliderLocalService, QuangCaoSliderLocalService>
			serviceTracker =
				new ServiceTracker
					<QuangCaoSliderLocalService, QuangCaoSliderLocalService>(
						bundle.getBundleContext(),
						QuangCaoSliderLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}