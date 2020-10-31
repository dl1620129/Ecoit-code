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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ColumnGroupRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ColumnGroupRelLocalService
 * @generated
 */
public class ColumnGroupRelLocalServiceWrapper
	implements ColumnGroupRelLocalService,
			   ServiceWrapper<ColumnGroupRelLocalService> {

	public ColumnGroupRelLocalServiceWrapper(
		ColumnGroupRelLocalService columnGroupRelLocalService) {

		_columnGroupRelLocalService = columnGroupRelLocalService;
	}

	/**
	 * Adds the column group rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRel the column group rel
	 * @return the column group rel that was added
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.ColumnGroupRel
		addColumnGroupRel(
			com.ecoit.lichcongtac.services.model.ColumnGroupRel
				columnGroupRel) {

		return _columnGroupRelLocalService.addColumnGroupRel(columnGroupRel);
	}

	@Override
	public boolean checkPermission(long userGroupId, int columnId) {
		return _columnGroupRelLocalService.checkPermission(
			userGroupId, columnId);
	}

	/**
	 * Creates a new column group rel with the primary key. Does not add the column group rel to the database.
	 *
	 * @param columnGroupRelPK the primary key for the new column group rel
	 * @return the new column group rel
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.ColumnGroupRel
		createColumnGroupRel(
			com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK
				columnGroupRelPK) {

		return _columnGroupRelLocalService.createColumnGroupRel(
			columnGroupRelPK);
	}

	@Override
	public void createColumnGroupRel(long userGroupId, int columnId) {
		_columnGroupRelLocalService.createColumnGroupRel(userGroupId, columnId);
	}

	/**
	 * Deletes the column group rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRel the column group rel
	 * @return the column group rel that was removed
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.ColumnGroupRel
		deleteColumnGroupRel(
			com.ecoit.lichcongtac.services.model.ColumnGroupRel
				columnGroupRel) {

		return _columnGroupRelLocalService.deleteColumnGroupRel(columnGroupRel);
	}

	/**
	 * Deletes the column group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel that was removed
	 * @throws PortalException if a column group rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.ColumnGroupRel
			deleteColumnGroupRel(
				com.ecoit.lichcongtac.services.service.persistence.
					ColumnGroupRelPK columnGroupRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnGroupRelLocalService.deleteColumnGroupRel(
			columnGroupRelPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnGroupRelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _columnGroupRelLocalService.dynamicQuery();
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

		return _columnGroupRelLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _columnGroupRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _columnGroupRelLocalService.dynamicQuery(
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

		return _columnGroupRelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _columnGroupRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.lichcongtac.services.model.ColumnGroupRel
		fetchColumnGroupRel(
			com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK
				columnGroupRelPK) {

		return _columnGroupRelLocalService.fetchColumnGroupRel(
			columnGroupRelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _columnGroupRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.ColumnGroupRel>
		getByGroupId(long groupId) {

		return _columnGroupRelLocalService.getByGroupId(groupId);
	}

	/**
	 * Returns the column group rel with the primary key.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel
	 * @throws PortalException if a column group rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.ColumnGroupRel
			getColumnGroupRel(
				com.ecoit.lichcongtac.services.service.persistence.
					ColumnGroupRelPK columnGroupRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnGroupRelLocalService.getColumnGroupRel(columnGroupRelPK);
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
	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.ColumnGroupRel>
		getColumnGroupRels(int start, int end) {

		return _columnGroupRelLocalService.getColumnGroupRels(start, end);
	}

	/**
	 * Returns the number of column group rels.
	 *
	 * @return the number of column group rels
	 */
	@Override
	public int getColumnGroupRelsCount() {
		return _columnGroupRelLocalService.getColumnGroupRelsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _columnGroupRelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _columnGroupRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _columnGroupRelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the column group rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRel the column group rel
	 * @return the column group rel that was updated
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.ColumnGroupRel
		updateColumnGroupRel(
			com.ecoit.lichcongtac.services.model.ColumnGroupRel
				columnGroupRel) {

		return _columnGroupRelLocalService.updateColumnGroupRel(columnGroupRel);
	}

	@Override
	public ColumnGroupRelLocalService getWrappedService() {
		return _columnGroupRelLocalService;
	}

	@Override
	public void setWrappedService(
		ColumnGroupRelLocalService columnGroupRelLocalService) {

		_columnGroupRelLocalService = columnGroupRelLocalService;
	}

	private ColumnGroupRelLocalService _columnGroupRelLocalService;

}