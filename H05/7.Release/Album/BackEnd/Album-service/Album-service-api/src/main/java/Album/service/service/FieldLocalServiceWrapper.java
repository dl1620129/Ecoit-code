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
 * Provides a wrapper for {@link FieldLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FieldLocalService
 * @generated
 */
@ProviderType
public class FieldLocalServiceWrapper
	implements FieldLocalService, ServiceWrapper<FieldLocalService> {

	public FieldLocalServiceWrapper(FieldLocalService fieldLocalService) {
		_fieldLocalService = fieldLocalService;
	}

	/**
	 * Adds the field to the database. Also notifies the appropriate model listeners.
	 *
	 * @param field the field
	 * @return the field that was added
	 */
	@Override
	public Album.service.model.Field addField(Album.service.model.Field field) {
		return _fieldLocalService.addField(field);
	}

	/**
	 * Creates a new field with the primary key. Does not add the field to the database.
	 *
	 * @param fieldId the primary key for the new field
	 * @return the new field
	 */
	@Override
	public Album.service.model.Field createField(long fieldId) {
		return _fieldLocalService.createField(fieldId);
	}

	/**
	 * Deletes the field from the database. Also notifies the appropriate model listeners.
	 *
	 * @param field the field
	 * @return the field that was removed
	 */
	@Override
	public Album.service.model.Field deleteField(
		Album.service.model.Field field) {

		return _fieldLocalService.deleteField(field);
	}

	/**
	 * Deletes the field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the field
	 * @return the field that was removed
	 * @throws PortalException if a field with the primary key could not be found
	 */
	@Override
	public Album.service.model.Field deleteField(long fieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldLocalService.deleteField(fieldId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fieldLocalService.dynamicQuery();
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

		return _fieldLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Album.service.model.impl.FieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _fieldLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Album.service.model.impl.FieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _fieldLocalService.dynamicQuery(
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

		return _fieldLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fieldLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public Album.service.model.Field fetchField(long fieldId) {
		return _fieldLocalService.fetchField(fieldId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fieldLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountAll(String name, long groupId) throws Exception {
		return _fieldLocalService.getCountAll(name, groupId);
	}

	/**
	 * Returns the field with the primary key.
	 *
	 * @param fieldId the primary key of the field
	 * @return the field
	 * @throws PortalException if a field with the primary key could not be found
	 */
	@Override
	public Album.service.model.Field getField(long fieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldLocalService.getField(fieldId);
	}

	/**
	 * Returns a range of all the fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Album.service.model.impl.FieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fields
	 * @param end the upper bound of the range of fields (not inclusive)
	 * @return the range of fields
	 */
	@Override
	public java.util.List<Album.service.model.Field> getFields(
		int start, int end) {

		return _fieldLocalService.getFields(start, end);
	}

	/**
	 * Returns the number of fields.
	 *
	 * @return the number of fields
	 */
	@Override
	public int getFieldsCount() {
		return _fieldLocalService.getFieldsCount();
	}

	@Override
	public java.util.List<Album.service.model.Field> getFieldTheoSQL(
		String sqlQuery) {

		return _fieldLocalService.getFieldTheoSQL(sqlQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fieldLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<Album.service.model.Field> getListFields(
		String name, int start, int limit, long groupId) {

		return _fieldLocalService.getListFields(name, start, limit, groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fieldLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param field the field
	 * @return the field that was updated
	 */
	@Override
	public Album.service.model.Field updateField(
		Album.service.model.Field field) {

		return _fieldLocalService.updateField(field);
	}

	@Override
	public FieldLocalService getWrappedService() {
		return _fieldLocalService;
	}

	@Override
	public void setWrappedService(FieldLocalService fieldLocalService) {
		_fieldLocalService = fieldLocalService;
	}

	private FieldLocalService _fieldLocalService;

}