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

package Album.service.service.persistence;

import Album.service.model.Fields;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the fields service. This utility wraps <code>Album.service.service.persistence.impl.FieldsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldsPersistence
 * @generated
 */
@ProviderType
public class FieldsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Fields fields) {
		getPersistence().clearCache(fields);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Fields> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Fields> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Fields> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Fields> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Fields> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Fields update(Fields fields) {
		return getPersistence().update(fields);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Fields update(Fields fields, ServiceContext serviceContext) {
		return getPersistence().update(fields, serviceContext);
	}

	/**
	 * Returns the fields where fieldId = &#63; and groupId = &#63; or throws a <code>NoSuchFieldsException</code> if it could not be found.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the matching fields
	 * @throws NoSuchFieldsException if a matching fields could not be found
	 */
	public static Fields findByLinhVucIdAndGroupId(long fieldId, long groupId)
		throws Album.service.exception.NoSuchFieldsException {

		return getPersistence().findByLinhVucIdAndGroupId(fieldId, groupId);
	}

	/**
	 * Returns the fields where fieldId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByLinhVucIdAndGroupId(long,long)}
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fields, or <code>null</code> if a matching fields could not be found
	 */
	@Deprecated
	public static Fields fetchByLinhVucIdAndGroupId(
		long fieldId, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByLinhVucIdAndGroupId(
			fieldId, groupId, useFinderCache);
	}

	/**
	 * Returns the fields where fieldId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fields, or <code>null</code> if a matching fields could not be found
	 */
	public static Fields fetchByLinhVucIdAndGroupId(
		long fieldId, long groupId) {

		return getPersistence().fetchByLinhVucIdAndGroupId(fieldId, groupId);
	}

	/**
	 * Removes the fields where fieldId = &#63; and groupId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the fields that was removed
	 */
	public static Fields removeByLinhVucIdAndGroupId(long fieldId, long groupId)
		throws Album.service.exception.NoSuchFieldsException {

		return getPersistence().removeByLinhVucIdAndGroupId(fieldId, groupId);
	}

	/**
	 * Returns the number of fieldses where fieldId = &#63; and groupId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the number of matching fieldses
	 */
	public static int countByLinhVucIdAndGroupId(long fieldId, long groupId) {
		return getPersistence().countByLinhVucIdAndGroupId(fieldId, groupId);
	}

	/**
	 * Caches the fields in the entity cache if it is enabled.
	 *
	 * @param fields the fields
	 */
	public static void cacheResult(Fields fields) {
		getPersistence().cacheResult(fields);
	}

	/**
	 * Caches the fieldses in the entity cache if it is enabled.
	 *
	 * @param fieldses the fieldses
	 */
	public static void cacheResult(List<Fields> fieldses) {
		getPersistence().cacheResult(fieldses);
	}

	/**
	 * Creates a new fields with the primary key. Does not add the fields to the database.
	 *
	 * @param fieldId the primary key for the new fields
	 * @return the new fields
	 */
	public static Fields create(long fieldId) {
		return getPersistence().create(fieldId);
	}

	/**
	 * Removes the fields with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields that was removed
	 * @throws NoSuchFieldsException if a fields with the primary key could not be found
	 */
	public static Fields remove(long fieldId)
		throws Album.service.exception.NoSuchFieldsException {

		return getPersistence().remove(fieldId);
	}

	public static Fields updateImpl(Fields fields) {
		return getPersistence().updateImpl(fields);
	}

	/**
	 * Returns the fields with the primary key or throws a <code>NoSuchFieldsException</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields
	 * @throws NoSuchFieldsException if a fields with the primary key could not be found
	 */
	public static Fields findByPrimaryKey(long fieldId)
		throws Album.service.exception.NoSuchFieldsException {

		return getPersistence().findByPrimaryKey(fieldId);
	}

	/**
	 * Returns the fields with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields, or <code>null</code> if a fields with the primary key could not be found
	 */
	public static Fields fetchByPrimaryKey(long fieldId) {
		return getPersistence().fetchByPrimaryKey(fieldId);
	}

	/**
	 * Returns all the fieldses.
	 *
	 * @return the fieldses
	 */
	public static List<Fields> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the fieldses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FieldsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fieldses
	 * @param end the upper bound of the range of fieldses (not inclusive)
	 * @return the range of fieldses
	 */
	public static List<Fields> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the fieldses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FieldsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of fieldses
	 * @param end the upper bound of the range of fieldses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fieldses
	 */
	@Deprecated
	public static List<Fields> findAll(
		int start, int end, OrderByComparator<Fields> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the fieldses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FieldsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fieldses
	 * @param end the upper bound of the range of fieldses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fieldses
	 */
	public static List<Fields> findAll(
		int start, int end, OrderByComparator<Fields> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the fieldses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of fieldses.
	 *
	 * @return the number of fieldses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FieldsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FieldsPersistence, FieldsPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FieldsPersistence.class);

		ServiceTracker<FieldsPersistence, FieldsPersistence> serviceTracker =
			new ServiceTracker<FieldsPersistence, FieldsPersistence>(
				bundle.getBundleContext(), FieldsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}