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
 * Provides a wrapper for {@link LichCongTacLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LichCongTacLocalService
 * @generated
 */
public class LichCongTacLocalServiceWrapper
	implements LichCongTacLocalService,
			   ServiceWrapper<LichCongTacLocalService> {

	public LichCongTacLocalServiceWrapper(
		LichCongTacLocalService lichCongTacLocalService) {

		_lichCongTacLocalService = lichCongTacLocalService;
	}

	/**
	 * Adds the lich cong tac to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTac the lich cong tac
	 * @return the lich cong tac that was added
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichCongTac addLichCongTac(
		com.ecoit.lichcongtac.services.model.LichCongTac lichCongTac) {

		return _lichCongTacLocalService.addLichCongTac(lichCongTac);
	}

	@Override
	public int countLichCongTac(
		long organizationId, long groupId, String language, String q,
		int status, long userId, String fromDate, String toDate) {

		return _lichCongTacLocalService.countLichCongTac(
			organizationId, groupId, language, q, status, userId, fromDate,
			toDate);
	}

	/**
	 * Creates a new lich cong tac with the primary key. Does not add the lich cong tac to the database.
	 *
	 * @param lichCongTacId the primary key for the new lich cong tac
	 * @return the new lich cong tac
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichCongTac createLichCongTac(
		long lichCongTacId) {

		return _lichCongTacLocalService.createLichCongTac(lichCongTacId);
	}

	@Override
	public com.ecoit.lichcongtac.services.model.LichCongTac
			createUpdateLichCongTac(
				long lichCongTacId, String language, long groupId, long userId,
				boolean coLyDo, String lyDoTraVe, long companyId,
				long organizationId, String name, java.util.Date startDate,
				java.util.Date endDate, String organizations, String users,
				int status)
		throws Exception {

		return _lichCongTacLocalService.createUpdateLichCongTac(
			lichCongTacId, language, groupId, userId, coLyDo, lyDoTraVe,
			companyId, organizationId, name, startDate, endDate, organizations,
			users, status);
	}

	/**
	 * Deletes the lich cong tac from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTac the lich cong tac
	 * @return the lich cong tac that was removed
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichCongTac deleteLichCongTac(
		com.ecoit.lichcongtac.services.model.LichCongTac lichCongTac) {

		return _lichCongTacLocalService.deleteLichCongTac(lichCongTac);
	}

	/**
	 * Deletes the lich cong tac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac that was removed
	 * @throws PortalException if a lich cong tac with the primary key could not be found
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichCongTac deleteLichCongTac(
			long lichCongTacId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichCongTacLocalService.deleteLichCongTac(lichCongTacId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichCongTacLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lichCongTacLocalService.dynamicQuery();
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

		return _lichCongTacLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichCongTacModelImpl</code>.
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

		return _lichCongTacLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichCongTacModelImpl</code>.
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

		return _lichCongTacLocalService.dynamicQuery(
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

		return _lichCongTacLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lichCongTacLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.lichcongtac.services.model.LichCongTac fetchLichCongTac(
		long lichCongTacId) {

		return _lichCongTacLocalService.fetchLichCongTac(lichCongTacId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lichCongTacLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.ecoit.lichcongtac.services.model.LichCongTac getByStatusAndId(
		int status, long lichCongTacId) {

		return _lichCongTacLocalService.getByStatusAndId(status, lichCongTacId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lichCongTacLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lich cong tac with the primary key.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac
	 * @throws PortalException if a lich cong tac with the primary key could not be found
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichCongTac getLichCongTac(
			long lichCongTacId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichCongTacLocalService.getLichCongTac(lichCongTacId);
	}

	/**
	 * Returns a range of all the lich cong tacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @return the range of lich cong tacs
	 */
	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.LichCongTac>
		getLichCongTacs(int start, int end) {

		return _lichCongTacLocalService.getLichCongTacs(start, end);
	}

	/**
	 * Returns the number of lich cong tacs.
	 *
	 * @return the number of lich cong tacs
	 */
	@Override
	public int getLichCongTacsCount() {
		return _lichCongTacLocalService.getLichCongTacsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lichCongTacLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichCongTacLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.LichCongTac>
		searchLichCongTac(
			long organizationId, long groupId, String language, String q,
			int start, int limit, int status, long userId, String fromDate,
			String toDate) {

		return _lichCongTacLocalService.searchLichCongTac(
			organizationId, groupId, language, q, start, limit, status, userId,
			fromDate, toDate);
	}

	/**
	 * Updates the lich cong tac in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTac the lich cong tac
	 * @return the lich cong tac that was updated
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichCongTac updateLichCongTac(
		com.ecoit.lichcongtac.services.model.LichCongTac lichCongTac) {

		return _lichCongTacLocalService.updateLichCongTac(lichCongTac);
	}

	@Override
	public void updateStatus(
		long userId, int status, long lichCongTacId, boolean coLyDo,
		String lyDoTraVe) {

		_lichCongTacLocalService.updateStatus(
			userId, status, lichCongTacId, coLyDo, lyDoTraVe);
	}

	@Override
	public LichCongTacLocalService getWrappedService() {
		return _lichCongTacLocalService;
	}

	@Override
	public void setWrappedService(
		LichCongTacLocalService lichCongTacLocalService) {

		_lichCongTacLocalService = lichCongTacLocalService;
	}

	private LichCongTacLocalService _lichCongTacLocalService;

}