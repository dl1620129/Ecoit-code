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

package com.ecoit.mr.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UnitLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UnitLocalService
 * @generated
 */
public class UnitLocalServiceWrapper
	implements ServiceWrapper<UnitLocalService>, UnitLocalService {

	public UnitLocalServiceWrapper(UnitLocalService unitLocalService) {
		_unitLocalService = unitLocalService;
	}

	/**
	 * Adds the unit to the database. Also notifies the appropriate model listeners.
	 *
	 * @param unit the unit
	 * @return the unit that was added
	 */
	@Override
	public com.ecoit.mr.model.Unit addUnit(com.ecoit.mr.model.Unit unit) {
		return _unitLocalService.addUnit(unit);
	}

	@Override
	public int countUnit(
			String searchKey, long groupId, long companyId, String language)
		throws Exception {

		return _unitLocalService.countUnit(
			searchKey, groupId, companyId, language);
	}

	/**
	 * Creates a new unit with the primary key. Does not add the unit to the database.
	 *
	 * @param unitId the primary key for the new unit
	 * @return the new unit
	 */
	@Override
	public com.ecoit.mr.model.Unit createUnit(long unitId) {
		return _unitLocalService.createUnit(unitId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _unitLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit that was removed
	 * @throws PortalException if a unit with the primary key could not be found
	 */
	@Override
	public com.ecoit.mr.model.Unit deleteUnit(long unitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _unitLocalService.deleteUnit(unitId);
	}

	/**
	 * Deletes the unit from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unit the unit
	 * @return the unit that was removed
	 */
	@Override
	public com.ecoit.mr.model.Unit deleteUnit(com.ecoit.mr.model.Unit unit) {
		return _unitLocalService.deleteUnit(unit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _unitLocalService.dynamicQuery();
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

		return _unitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UnitModelImpl</code>.
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

		return _unitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UnitModelImpl</code>.
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

		return _unitLocalService.dynamicQuery(
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

		return _unitLocalService.dynamicQueryCount(dynamicQuery);
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

		return _unitLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ecoit.mr.model.Unit fetchUnit(long unitId) {
		return _unitLocalService.fetchUnit(unitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _unitLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _unitLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _unitLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _unitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the unit with the primary key.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit
	 * @throws PortalException if a unit with the primary key could not be found
	 */
	@Override
	public com.ecoit.mr.model.Unit getUnit(long unitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _unitLocalService.getUnit(unitId);
	}

	/**
	 * Returns a range of all the units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UnitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of units
	 * @param end the upper bound of the range of units (not inclusive)
	 * @return the range of units
	 */
	@Override
	public java.util.List<com.ecoit.mr.model.Unit> getUnits(
		int start, int end) {

		return _unitLocalService.getUnits(start, end);
	}

	/**
	 * Returns the number of units.
	 *
	 * @return the number of units
	 */
	@Override
	public int getUnitsCount() {
		return _unitLocalService.getUnitsCount();
	}

	@Override
	public java.util.List<com.ecoit.mr.model.Unit> searchUnit(
		String searchKey, long groupId, long companyId, String language,
		int start, int limit) {

		return _unitLocalService.searchUnit(
			searchKey, groupId, companyId, language, start, limit);
	}

	@Override
	public void updateCreateUnit(
			long unitId, long groupId, long companyId, long userId,
			String language, String name, String description)
		throws Exception {

		_unitLocalService.updateCreateUnit(
			unitId, groupId, companyId, userId, language, name, description);
	}

	/**
	 * Updates the unit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param unit the unit
	 * @return the unit that was updated
	 */
	@Override
	public com.ecoit.mr.model.Unit updateUnit(com.ecoit.mr.model.Unit unit) {
		return _unitLocalService.updateUnit(unit);
	}

	@Override
	public UnitLocalService getWrappedService() {
		return _unitLocalService;
	}

	@Override
	public void setWrappedService(UnitLocalService unitLocalService) {
		_unitLocalService = unitLocalService;
	}

	private UnitLocalService _unitLocalService;

}