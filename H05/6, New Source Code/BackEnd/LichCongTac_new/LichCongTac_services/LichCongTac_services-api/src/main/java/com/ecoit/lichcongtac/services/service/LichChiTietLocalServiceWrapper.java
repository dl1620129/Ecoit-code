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
 * Provides a wrapper for {@link LichChiTietLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LichChiTietLocalService
 * @generated
 */
public class LichChiTietLocalServiceWrapper
	implements LichChiTietLocalService,
			   ServiceWrapper<LichChiTietLocalService> {

	public LichChiTietLocalServiceWrapper(
		LichChiTietLocalService lichChiTietLocalService) {

		_lichChiTietLocalService = lichChiTietLocalService;
	}

	/**
	 * Adds the lich chi tiet to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTiet the lich chi tiet
	 * @return the lich chi tiet that was added
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichChiTiet addLichChiTiet(
		com.ecoit.lichcongtac.services.model.LichChiTiet lichChiTiet) {

		return _lichChiTietLocalService.addLichChiTiet(lichChiTiet);
	}

	/**
	 * Creates a new lich chi tiet with the primary key. Does not add the lich chi tiet to the database.
	 *
	 * @param lichChiTietId the primary key for the new lich chi tiet
	 * @return the new lich chi tiet
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichChiTiet createLichChiTiet(
		long lichChiTietId) {

		return _lichChiTietLocalService.createLichChiTiet(lichChiTietId);
	}

	@Override
	public void createUpdateLichChiTiet(
		long lichChiTietId, long groupId, long userId, long companyId,
		String description, java.util.Date startTime, long organizationId,
		java.util.Date selectedDate, String nguoiThamDu, String nguoiChuTri,
		long lichCongTacId, String address, String note, int status,
		String language, boolean coLyDo, String lyDoTraVe) {

		_lichChiTietLocalService.createUpdateLichChiTiet(
			lichChiTietId, groupId, userId, companyId, description, startTime,
			organizationId, selectedDate, nguoiThamDu, nguoiChuTri,
			lichCongTacId, address, note, status, language, coLyDo, lyDoTraVe);
	}

	@Override
	public void deleteByLichCongTacId(long lichCongTacId) {
		_lichChiTietLocalService.deleteByLichCongTacId(lichCongTacId);
	}

	/**
	 * Deletes the lich chi tiet from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTiet the lich chi tiet
	 * @return the lich chi tiet that was removed
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichChiTiet deleteLichChiTiet(
		com.ecoit.lichcongtac.services.model.LichChiTiet lichChiTiet) {

		return _lichChiTietLocalService.deleteLichChiTiet(lichChiTiet);
	}

	/**
	 * Deletes the lich chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet that was removed
	 * @throws PortalException if a lich chi tiet with the primary key could not be found
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichChiTiet deleteLichChiTiet(
			long lichChiTietId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichChiTietLocalService.deleteLichChiTiet(lichChiTietId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichChiTietLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lichChiTietLocalService.dynamicQuery();
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

		return _lichChiTietLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichChiTietModelImpl</code>.
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

		return _lichChiTietLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichChiTietModelImpl</code>.
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

		return _lichChiTietLocalService.dynamicQuery(
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

		return _lichChiTietLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lichChiTietLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.lichcongtac.services.model.LichChiTiet fetchLichChiTiet(
		long lichChiTietId) {

		return _lichChiTietLocalService.fetchLichChiTiet(lichChiTietId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lichChiTietLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.LichChiTiet>
		getByDateAndStatus(
			String fromDate, String toDate, long groupId, String language,
			int status) {

		return _lichChiTietLocalService.getByDateAndStatus(
			fromDate, toDate, groupId, language, status);
	}

	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.LichChiTiet>
		getByLichCongTacId(long lichCongTacId) {

		return _lichChiTietLocalService.getByLichCongTacId(lichCongTacId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lichChiTietLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lich chi tiet with the primary key.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet
	 * @throws PortalException if a lich chi tiet with the primary key could not be found
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichChiTiet getLichChiTiet(
			long lichChiTietId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichChiTietLocalService.getLichChiTiet(lichChiTietId);
	}

	/**
	 * Returns a range of all the lich chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @return the range of lich chi tiets
	 */
	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.LichChiTiet>
		getLichChiTiets(int start, int end) {

		return _lichChiTietLocalService.getLichChiTiets(start, end);
	}

	/**
	 * Returns the number of lich chi tiets.
	 *
	 * @return the number of lich chi tiets
	 */
	@Override
	public int getLichChiTietsCount() {
		return _lichChiTietLocalService.getLichChiTietsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lichChiTietLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichChiTietLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.LichChiTiet>
		getPublishLichChiTiet(
			long groupId, String language, int status, int stableStatus,
			String fromDate, String toDate) {

		return _lichChiTietLocalService.getPublishLichChiTiet(
			groupId, language, status, stableStatus, fromDate, toDate);
	}

	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.LichChiTiet>
		searchLichChiTiet(
			long organizationId, long groupId, String language, int status,
			long userId, String fromDate, String toDate) {

		return _lichChiTietLocalService.searchLichChiTiet(
			organizationId, groupId, language, status, userId, fromDate,
			toDate);
	}

	/**
	 * Updates the lich chi tiet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTiet the lich chi tiet
	 * @return the lich chi tiet that was updated
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.LichChiTiet updateLichChiTiet(
		com.ecoit.lichcongtac.services.model.LichChiTiet lichChiTiet) {

		return _lichChiTietLocalService.updateLichChiTiet(lichChiTiet);
	}

	@Override
	public void updateStatus(
		long userId, int status, long lichChiTietId, boolean coLyDo,
		String lyDoTraVe) {

		_lichChiTietLocalService.updateStatus(
			userId, status, lichChiTietId, coLyDo, lyDoTraVe);
	}

	@Override
	public LichChiTietLocalService getWrappedService() {
		return _lichChiTietLocalService;
	}

	@Override
	public void setWrappedService(
		LichChiTietLocalService lichChiTietLocalService) {

		_lichChiTietLocalService = lichChiTietLocalService;
	}

	private LichChiTietLocalService _lichChiTietLocalService;

}