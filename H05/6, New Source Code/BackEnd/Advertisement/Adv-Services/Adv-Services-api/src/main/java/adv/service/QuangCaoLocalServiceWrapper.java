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

package adv.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link QuangCaoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoLocalService
 * @generated
 */
public class QuangCaoLocalServiceWrapper
	implements QuangCaoLocalService, ServiceWrapper<QuangCaoLocalService> {

	public QuangCaoLocalServiceWrapper(
		QuangCaoLocalService quangCaoLocalService) {

		_quangCaoLocalService = quangCaoLocalService;
	}

	/**
	 * Adds the quang cao to the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCao the quang cao
	 * @return the quang cao that was added
	 */
	@Override
	public adv.model.QuangCao addQuangCao(adv.model.QuangCao quangCao) {
		return _quangCaoLocalService.addQuangCao(quangCao);
	}

	@Override
	public int countAbv(long groupId, String locale, String q)
		throws Exception {

		return _quangCaoLocalService.countAbv(groupId, locale, q);
	}

	/**
	 * Creates a new quang cao with the primary key. Does not add the quang cao to the database.
	 *
	 * @param quangCaoId the primary key for the new quang cao
	 * @return the new quang cao
	 */
	@Override
	public adv.model.QuangCao createQuangCao(long quangCaoId) {
		return _quangCaoLocalService.createQuangCao(quangCaoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quangCaoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the quang cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao that was removed
	 * @throws PortalException if a quang cao with the primary key could not be found
	 */
	@Override
	public adv.model.QuangCao deleteQuangCao(long quangCaoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quangCaoLocalService.deleteQuangCao(quangCaoId);
	}

	/**
	 * Deletes the quang cao from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCao the quang cao
	 * @return the quang cao that was removed
	 */
	@Override
	public adv.model.QuangCao deleteQuangCao(adv.model.QuangCao quangCao) {
		return _quangCaoLocalService.deleteQuangCao(quangCao);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quangCaoLocalService.dynamicQuery();
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

		return _quangCaoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adv.model.impl.QuangCaoModelImpl</code>.
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

		return _quangCaoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adv.model.impl.QuangCaoModelImpl</code>.
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

		return _quangCaoLocalService.dynamicQuery(
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

		return _quangCaoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _quangCaoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public adv.model.QuangCao fetchQuangCao(long quangCaoId) {
		return _quangCaoLocalService.fetchQuangCao(quangCaoId);
	}

	/**
	 * Returns the quang cao matching the UUID and group.
	 *
	 * @param uuid the quang cao's UUID
	 * @param groupId the primary key of the group
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Override
	public adv.model.QuangCao fetchQuangCaoByUuidAndGroupId(
		String uuid, long groupId) {

		return _quangCaoLocalService.fetchQuangCaoByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quangCaoLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<adv.model.QuangCao> getAllAdv(
			long groupId, int start, int limit, String locale, String q)
		throws Exception {

		return _quangCaoLocalService.getAllAdv(
			groupId, start, limit, locale, q);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quangCaoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quangCaoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quangCaoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the quang cao with the primary key.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao
	 * @throws PortalException if a quang cao with the primary key could not be found
	 */
	@Override
	public adv.model.QuangCao getQuangCao(long quangCaoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quangCaoLocalService.getQuangCao(quangCaoId);
	}

	/**
	 * Returns the quang cao matching the UUID and group.
	 *
	 * @param uuid the quang cao's UUID
	 * @param groupId the primary key of the group
	 * @return the matching quang cao
	 * @throws PortalException if a matching quang cao could not be found
	 */
	@Override
	public adv.model.QuangCao getQuangCaoByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quangCaoLocalService.getQuangCaoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adv.model.impl.QuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @return the range of quang caos
	 */
	@Override
	public java.util.List<adv.model.QuangCao> getQuangCaos(int start, int end) {
		return _quangCaoLocalService.getQuangCaos(start, end);
	}

	/**
	 * Returns the number of quang caos.
	 *
	 * @return the number of quang caos
	 */
	@Override
	public int getQuangCaosCount() {
		return _quangCaoLocalService.getQuangCaosCount();
	}

	/**
	 * Updates the quang cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param quangCao the quang cao
	 * @return the quang cao that was updated
	 */
	@Override
	public adv.model.QuangCao updateQuangCao(adv.model.QuangCao quangCao) {
		return _quangCaoLocalService.updateQuangCao(quangCao);
	}

	@Override
	public QuangCaoLocalService getWrappedService() {
		return _quangCaoLocalService;
	}

	@Override
	public void setWrappedService(QuangCaoLocalService quangCaoLocalService) {
		_quangCaoLocalService = quangCaoLocalService;
	}

	private QuangCaoLocalService _quangCaoLocalService;

}