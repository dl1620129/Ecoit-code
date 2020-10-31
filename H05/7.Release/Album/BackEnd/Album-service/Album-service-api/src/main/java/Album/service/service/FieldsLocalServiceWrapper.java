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

package Album.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link FieldsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FieldsLocalService
 * @generated
 */
@ProviderType
public class FieldsLocalServiceWrapper
	implements FieldsLocalService, ServiceWrapper<FieldsLocalService> {

	public FieldsLocalServiceWrapper(FieldsLocalService fieldsLocalService) {
		_fieldsLocalService = fieldsLocalService;
	}

	/**
	 * Adds the fields to the database. Also notifies the appropriate model listeners.
	 *
	 * @param fields the fields
	 * @return the fields that was added
	 */
	@Override
	public Album.service.model.Fields addFields(
		Album.service.model.Fields fields) {

		return _fieldsLocalService.addFields(fields);
	}

	/**
	 * Creates a new fields with the primary key. Does not add the fields to the database.
	 *
	 * @param fieldId the primary key for the new fields
	 * @return the new fields
	 */
	@Override
	public Album.service.model.Fields createFields(long fieldId) {
		return _fieldsLocalService.createFields(fieldId);
	}

	/**
	 * Deletes the fields from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fields the fields
	 * @return the fields that was removed
	 */
	@Override
	public Album.service.model.Fields deleteFields(
		Album.service.model.Fields fields) {

		return _fieldsLocalService.deleteFields(fields);
	}

	/**
	 * Deletes the fields with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields that was removed
	 * @throws PortalException if a fields with the primary key could not be found
	 */
	@Override
	public Album.service.model.Fields deleteFields(long fieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldsLocalService.deleteFields(fieldId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fieldsLocalService.dynamicQuery();
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

		return _fieldsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Album.service.model.impl.FieldsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _fieldsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Album.service.model.impl.FieldsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _fieldsLocalService.dynamicQuery(
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

		return _fieldsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fieldsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public Album.service.model.Fields fetchFields(long fieldId) {
		return _fieldsLocalService.fetchFields(fieldId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fieldsLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountAll(String name, long groupId) throws Exception {
		return _fieldsLocalService.getCountAll(name, groupId);
	}

	/**
	 * Returns the fields with the primary key.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields
	 * @throws PortalException if a fields with the primary key could not be found
	 */
	@Override
	public Album.service.model.Fields getFields(long fieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldsLocalService.getFields(fieldId);
	}

	/**
	 * Returns a range of all the fieldses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Album.service.model.impl.FieldsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fieldses
	 * @param end the upper bound of the range of fieldses (not inclusive)
	 * @return the range of fieldses
	 */
	@Override
	public java.util.List<Album.service.model.Fields> getFieldses(
		int start, int end) {

		return _fieldsLocalService.getFieldses(start, end);
	}

	/**
	 * Returns the number of fieldses.
	 *
	 * @return the number of fieldses
	 */
	@Override
	public int getFieldsesCount() {
		return _fieldsLocalService.getFieldsesCount();
	}

	@Override
	public java.util.List<Album.service.model.Fields> getFieldsTheoSQL(
		String sqlQuery) {

		return _fieldsLocalService.getFieldsTheoSQL(sqlQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fieldsLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<Album.service.model.Fields> getListFields(
			String name, int start, int limit, long groupId)
		throws Exception {

		return _fieldsLocalService.getListFields(name, start, limit, groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fieldsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the fields in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param fields the fields
	 * @return the fields that was updated
	 */
	@Override
	public Album.service.model.Fields updateFields(
		Album.service.model.Fields fields) {

		return _fieldsLocalService.updateFields(fields);
	}

	@Override
	public FieldsLocalService getWrappedService() {
		return _fieldsLocalService;
	}

	@Override
	public void setWrappedService(FieldsLocalService fieldsLocalService) {
		_fieldsLocalService = fieldsLocalService;
	}

	private FieldsLocalService _fieldsLocalService;

}