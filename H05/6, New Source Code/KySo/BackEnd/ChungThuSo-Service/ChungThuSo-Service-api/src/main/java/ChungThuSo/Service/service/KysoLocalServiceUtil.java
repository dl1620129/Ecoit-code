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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Kyso. This utility wraps
 * <code>ChungThuSo.Service.service.impl.KysoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see KysoLocalService
 * @generated
 */
@ProviderType
public class KysoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ChungThuSo.Service.service.impl.KysoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the kyso to the database. Also notifies the appropriate model listeners.
	 *
	 * @param kyso the kyso
	 * @return the kyso that was added
	 */
	public static ChungThuSo.Service.model.Kyso addKyso(
		ChungThuSo.Service.model.Kyso kyso) {

		return getService().addKyso(kyso);
	}

	/**
	 * Creates a new kyso with the primary key. Does not add the kyso to the database.
	 *
	 * @param kysoId the primary key for the new kyso
	 * @return the new kyso
	 */
	public static ChungThuSo.Service.model.Kyso createKyso(long kysoId) {
		return getService().createKyso(kysoId);
	}

	/**
	 * Deletes the kyso from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kyso the kyso
	 * @return the kyso that was removed
	 */
	public static ChungThuSo.Service.model.Kyso deleteKyso(
		ChungThuSo.Service.model.Kyso kyso) {

		return getService().deleteKyso(kyso);
	}

	/**
	 * Deletes the kyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso that was removed
	 * @throws PortalException if a kyso with the primary key could not be found
	 */
	public static ChungThuSo.Service.model.Kyso deleteKyso(long kysoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteKyso(kysoId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChungThuSo.Service.model.impl.KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChungThuSo.Service.model.impl.KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static ChungThuSo.Service.model.Kyso fetchKyso(long kysoId) {
		return getService().fetchKyso(kysoId);
	}

	/**
	 * Returns the kyso matching the UUID and group.
	 *
	 * @param uuid the kyso's UUID
	 * @param groupId the primary key of the group
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public static ChungThuSo.Service.model.Kyso fetchKysoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchKysoByUuidAndGroupId(uuid, groupId);
	}

	public static ChungThuSo.Service.model.Kyso findBygetByScreenName(
		String sn) {

		return getService().findBygetByScreenName(sn);
	}

	public static ChungThuSo.Service.model.Kyso findBygetBySerialNumber(
		String serialNumber) {

		return getService().findBygetBySerialNumber(serialNumber);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static int getCountSerialNumber(long groupId, String serialNumber)
		throws Exception {

		return getService().getCountSerialNumber(groupId, serialNumber);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the kyso with the primary key.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso
	 * @throws PortalException if a kyso with the primary key could not be found
	 */
	public static ChungThuSo.Service.model.Kyso getKyso(long kysoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getKyso(kysoId);
	}

	/**
	 * Returns the kyso matching the UUID and group.
	 *
	 * @param uuid the kyso's UUID
	 * @param groupId the primary key of the group
	 * @return the matching kyso
	 * @throws PortalException if a matching kyso could not be found
	 */
	public static ChungThuSo.Service.model.Kyso getKysoByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getKysoByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<ChungThuSo.Service.model.Kyso> getKysos(
		int start, int end) {

		return getService().getKysos(start, end);
	}

	/**
	 * Returns all the kysos matching the UUID and company.
	 *
	 * @param uuid the UUID of the kysos
	 * @param companyId the primary key of the company
	 * @return the matching kysos, or an empty list if no matches were found
	 */
	public static java.util.List<ChungThuSo.Service.model.Kyso>
		getKysosByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getKysosByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<ChungThuSo.Service.model.Kyso>
		getKysosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ChungThuSo.Service.model.Kyso> orderByComparator) {

		return getService().getKysosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of kysos.
	 *
	 * @return the number of kysos
	 */
	public static int getKysosCount() {
		return getService().getKysosCount();
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
	 * Updates the kyso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param kyso the kyso
	 * @return the kyso that was updated
	 */
	public static ChungThuSo.Service.model.Kyso updateKyso(
		ChungThuSo.Service.model.Kyso kyso) {

		return getService().updateKyso(kyso);
	}

	public static KysoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<KysoLocalService, KysoLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(KysoLocalService.class);

		ServiceTracker<KysoLocalService, KysoLocalService> serviceTracker =
			new ServiceTracker<KysoLocalService, KysoLocalService>(
				bundle.getBundleContext(), KysoLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}