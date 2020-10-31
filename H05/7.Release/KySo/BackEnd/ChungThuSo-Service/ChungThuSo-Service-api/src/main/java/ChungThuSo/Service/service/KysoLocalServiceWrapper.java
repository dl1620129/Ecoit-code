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

package ChungThuSo.Service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link KysoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see KysoLocalService
 * @generated
 */
@ProviderType
public class KysoLocalServiceWrapper
	implements KysoLocalService, ServiceWrapper<KysoLocalService> {

	public KysoLocalServiceWrapper(KysoLocalService kysoLocalService) {
		_kysoLocalService = kysoLocalService;
	}

	/**
	 * Adds the kyso to the database. Also notifies the appropriate model listeners.
	 *
	 * @param kyso the kyso
	 * @return the kyso that was added
	 */
	@Override
	public ChungThuSo.Service.model.Kyso addKyso(
		ChungThuSo.Service.model.Kyso kyso) {

		return _kysoLocalService.addKyso(kyso);
	}

	/**
	 * Creates a new kyso with the primary key. Does not add the kyso to the database.
	 *
	 * @param kysoId the primary key for the new kyso
	 * @return the new kyso
	 */
	@Override
	public ChungThuSo.Service.model.Kyso createKyso(long kysoId) {
		return _kysoLocalService.createKyso(kysoId);
	}

	/**
	 * Deletes the kyso from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kyso the kyso
	 * @return the kyso that was removed
	 */
	@Override
	public ChungThuSo.Service.model.Kyso deleteKyso(
		ChungThuSo.Service.model.Kyso kyso) {

		return _kysoLocalService.deleteKyso(kyso);
	}

	/**
	 * Deletes the kyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso that was removed
	 * @throws PortalException if a kyso with the primary key could not be found
	 */
	@Override
	public ChungThuSo.Service.model.Kyso deleteKyso(long kysoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kysoLocalService.deleteKyso(kysoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kysoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kysoLocalService.dynamicQuery();
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

		return _kysoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChungThuSo.Service.model.impl.KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _kysoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChungThuSo.Service.model.impl.KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _kysoLocalService.dynamicQuery(
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

		return _kysoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _kysoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ChungThuSo.Service.model.Kyso fetchKyso(long kysoId) {
		return _kysoLocalService.fetchKyso(kysoId);
	}

	/**
	 * Returns the kyso matching the UUID and group.
	 *
	 * @param uuid the kyso's UUID
	 * @param groupId the primary key of the group
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Override
	public ChungThuSo.Service.model.Kyso fetchKysoByUuidAndGroupId(
		String uuid, long groupId) {

		return _kysoLocalService.fetchKysoByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public ChungThuSo.Service.model.Kyso findBygetByScreenName(String sn) {
		return _kysoLocalService.findBygetByScreenName(sn);
	}

	@Override
	public ChungThuSo.Service.model.Kyso findBygetBySerialNumber(
		String serialNumber) {

		return _kysoLocalService.findBygetBySerialNumber(serialNumber);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _kysoLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountSerialNumber(long groupId, String serialNumber)
		throws Exception {

		return _kysoLocalService.getCountSerialNumber(groupId, serialNumber);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _kysoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _kysoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the kyso with the primary key.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso
	 * @throws PortalException if a kyso with the primary key could not be found
	 */
	@Override
	public ChungThuSo.Service.model.Kyso getKyso(long kysoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kysoLocalService.getKyso(kysoId);
	}

	/**
	 * Returns the kyso matching the UUID and group.
	 *
	 * @param uuid the kyso's UUID
	 * @param groupId the primary key of the group
	 * @return the matching kyso
	 * @throws PortalException if a matching kyso could not be found
	 */
	@Override
	public ChungThuSo.Service.model.Kyso getKysoByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kysoLocalService.getKysoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the kysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChungThuSo.Service.model.impl.KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @return the range of kysos
	 */
	@Override
	public java.util.List<ChungThuSo.Service.model.Kyso> getKysos(
		int start, int end) {

		return _kysoLocalService.getKysos(start, end);
	}

	/**
	 * Returns all the kysos matching the UUID and company.
	 *
	 * @param uuid the UUID of the kysos
	 * @param companyId the primary key of the company
	 * @return the matching kysos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ChungThuSo.Service.model.Kyso>
		getKysosByUuidAndCompanyId(String uuid, long companyId) {

		return _kysoLocalService.getKysosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of kysos matching the UUID and company.
	 *
	 * @param uuid the UUID of the kysos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching kysos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ChungThuSo.Service.model.Kyso>
		getKysosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ChungThuSo.Service.model.Kyso> orderByComparator) {

		return _kysoLocalService.getKysosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of kysos.
	 *
	 * @return the number of kysos
	 */
	@Override
	public int getKysosCount() {
		return _kysoLocalService.getKysosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _kysoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kysoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the kyso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param kyso the kyso
	 * @return the kyso that was updated
	 */
	@Override
	public ChungThuSo.Service.model.Kyso updateKyso(
		ChungThuSo.Service.model.Kyso kyso) {

		return _kysoLocalService.updateKyso(kyso);
	}

	@Override
	public KysoLocalService getWrappedService() {
		return _kysoLocalService;
	}

	@Override
	public void setWrappedService(KysoLocalService kysoLocalService) {
		_kysoLocalService = kysoLocalService;
	}

	private KysoLocalService _kysoLocalService;

}