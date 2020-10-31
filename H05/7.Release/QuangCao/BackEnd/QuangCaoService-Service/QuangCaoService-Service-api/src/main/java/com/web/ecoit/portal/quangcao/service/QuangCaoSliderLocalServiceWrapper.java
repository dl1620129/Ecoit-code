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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link QuangCaoSliderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoSliderLocalService
 * @generated
 */
@ProviderType
public class QuangCaoSliderLocalServiceWrapper
	implements QuangCaoSliderLocalService,
			   ServiceWrapper<QuangCaoSliderLocalService> {

	public QuangCaoSliderLocalServiceWrapper(
		QuangCaoSliderLocalService quangCaoSliderLocalService) {

		_quangCaoSliderLocalService = quangCaoSliderLocalService;
	}

	/**
	 * Adds the quang cao slider to the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSlider the quang cao slider
	 * @return the quang cao slider that was added
	 */
	@Override
	public com.web.ecoit.portal.quangcao.model.QuangCaoSlider addQuangCaoSlider(
		com.web.ecoit.portal.quangcao.model.QuangCaoSlider quangCaoSlider) {

		return _quangCaoSliderLocalService.addQuangCaoSlider(quangCaoSlider);
	}

	/**
	 * Creates a new quang cao slider with the primary key. Does not add the quang cao slider to the database.
	 *
	 * @param quangCaoSliderId the primary key for the new quang cao slider
	 * @return the new quang cao slider
	 */
	@Override
	public com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		createQuangCaoSlider(long quangCaoSliderId) {

		return _quangCaoSliderLocalService.createQuangCaoSlider(
			quangCaoSliderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quangCaoSliderLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the quang cao slider with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider that was removed
	 * @throws PortalException if a quang cao slider with the primary key could not be found
	 */
	@Override
	public com.web.ecoit.portal.quangcao.model.QuangCaoSlider
			deleteQuangCaoSlider(long quangCaoSliderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quangCaoSliderLocalService.deleteQuangCaoSlider(
			quangCaoSliderId);
	}

	/**
	 * Deletes the quang cao slider from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSlider the quang cao slider
	 * @return the quang cao slider that was removed
	 */
	@Override
	public com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		deleteQuangCaoSlider(
			com.web.ecoit.portal.quangcao.model.QuangCaoSlider quangCaoSlider) {

		return _quangCaoSliderLocalService.deleteQuangCaoSlider(quangCaoSlider);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quangCaoSliderLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _quangCaoSliderLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _quangCaoSliderLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _quangCaoSliderLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _quangCaoSliderLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _quangCaoSliderLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		fetchQuangCaoSlider(long quangCaoSliderId) {

		return _quangCaoSliderLocalService.fetchQuangCaoSlider(
			quangCaoSliderId);
	}

	/**
	 * Returns the quang cao slider matching the UUID and group.
	 *
	 * @param uuid the quang cao slider's UUID
	 * @param groupId the primary key of the group
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Override
	public com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		fetchQuangCaoSliderByUuidAndGroupId(String uuid, long groupId) {

		return _quangCaoSliderLocalService.fetchQuangCaoSliderByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.web.ecoit.portal.quangcao.model.QuangCaoSlider>
		findBybyQuangCaoIdAndGroupId(long quangCaoId, long groupId) {

		return _quangCaoSliderLocalService.findBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId);
	}

	@Override
	public com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		findBybyQuangCaoSliderIdAndGroupId(
			long quangCaoSliderId, long groupId) {

		return _quangCaoSliderLocalService.findBybyQuangCaoSliderIdAndGroupId(
			quangCaoSliderId, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quangCaoSliderLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quangCaoSliderLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quangCaoSliderLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quangCaoSliderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the quang cao slider with the primary key.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider
	 * @throws PortalException if a quang cao slider with the primary key could not be found
	 */
	@Override
	public com.web.ecoit.portal.quangcao.model.QuangCaoSlider getQuangCaoSlider(
			long quangCaoSliderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quangCaoSliderLocalService.getQuangCaoSlider(quangCaoSliderId);
	}

	/**
	 * Returns the quang cao slider matching the UUID and group.
	 *
	 * @param uuid the quang cao slider's UUID
	 * @param groupId the primary key of the group
	 * @return the matching quang cao slider
	 * @throws PortalException if a matching quang cao slider could not be found
	 */
	@Override
	public com.web.ecoit.portal.quangcao.model.QuangCaoSlider
			getQuangCaoSliderByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quangCaoSliderLocalService.getQuangCaoSliderByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.web.ecoit.portal.quangcao.model.QuangCaoSlider>
		getQuangCaoSliders(int start, int end) {

		return _quangCaoSliderLocalService.getQuangCaoSliders(start, end);
	}

	/**
	 * Returns the number of quang cao sliders.
	 *
	 * @return the number of quang cao sliders
	 */
	@Override
	public int getQuangCaoSlidersCount() {
		return _quangCaoSliderLocalService.getQuangCaoSlidersCount();
	}

	/**
	 * Updates the quang cao slider in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSlider the quang cao slider
	 * @return the quang cao slider that was updated
	 */
	@Override
	public com.web.ecoit.portal.quangcao.model.QuangCaoSlider
		updateQuangCaoSlider(
			com.web.ecoit.portal.quangcao.model.QuangCaoSlider quangCaoSlider) {

		return _quangCaoSliderLocalService.updateQuangCaoSlider(quangCaoSlider);
	}

	@Override
	public QuangCaoSliderLocalService getWrappedService() {
		return _quangCaoSliderLocalService;
	}

	@Override
	public void setWrappedService(
		QuangCaoSliderLocalService quangCaoSliderLocalService) {

		_quangCaoSliderLocalService = quangCaoSliderLocalService;
	}

	private QuangCaoSliderLocalService _quangCaoSliderLocalService;

}