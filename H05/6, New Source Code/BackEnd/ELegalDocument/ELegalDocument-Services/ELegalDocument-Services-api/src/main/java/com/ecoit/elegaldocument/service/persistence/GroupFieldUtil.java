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

package com.ecoit.elegaldocument.service.persistence;

import com.ecoit.elegaldocument.model.GroupField;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the group field service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.GroupFieldPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see GroupFieldPersistence
 * @generated
 */
public class GroupFieldUtil {

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
	public static void clearCache(GroupField groupField) {
		getPersistence().clearCache(groupField);
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
	public static Map<Serializable, GroupField> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GroupField> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GroupField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GroupField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GroupField> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GroupField update(GroupField groupField) {
		return getPersistence().update(groupField);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GroupField update(
		GroupField groupField, ServiceContext serviceContext) {

		return getPersistence().update(groupField, serviceContext);
	}

	/**
	 * Returns all the group fields where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group fields
	 */
	public static List<GroupField> findByGroupUser(long groupUserId) {
		return getPersistence().findByGroupUser(groupUserId);
	}

	/**
	 * Returns a range of all the group fields where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @return the range of matching group fields
	 */
	public static List<GroupField> findByGroupUser(
		long groupUserId, int start, int end) {

		return getPersistence().findByGroupUser(groupUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the group fields where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group fields
	 */
	public static List<GroupField> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupField> orderByComparator) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group fields where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group fields
	 */
	public static List<GroupField> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	public static GroupField findByGroupUser_First(
			long groupUserId, OrderByComparator<GroupField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchGroupFieldException {

		return getPersistence().findByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the first group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field, or <code>null</code> if a matching group field could not be found
	 */
	public static GroupField fetchByGroupUser_First(
		long groupUserId, OrderByComparator<GroupField> orderByComparator) {

		return getPersistence().fetchByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	public static GroupField findByGroupUser_Last(
			long groupUserId, OrderByComparator<GroupField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchGroupFieldException {

		return getPersistence().findByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field, or <code>null</code> if a matching group field could not be found
	 */
	public static GroupField fetchByGroupUser_Last(
		long groupUserId, OrderByComparator<GroupField> orderByComparator) {

		return getPersistence().fetchByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the group fields before and after the current group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupFieldPK the primary key of the current group field
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group field
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	public static GroupField[] findByGroupUser_PrevAndNext(
			GroupFieldPK groupFieldPK, long groupUserId,
			OrderByComparator<GroupField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchGroupFieldException {

		return getPersistence().findByGroupUser_PrevAndNext(
			groupFieldPK, groupUserId, orderByComparator);
	}

	/**
	 * Removes all the group fields where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public static void removeByGroupUser(long groupUserId) {
		getPersistence().removeByGroupUser(groupUserId);
	}

	/**
	 * Returns the number of group fields where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group fields
	 */
	public static int countByGroupUser(long groupUserId) {
		return getPersistence().countByGroupUser(groupUserId);
	}

	/**
	 * Returns all the group fields where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @return the matching group fields
	 */
	public static List<GroupField> findByField(long fieldid) {
		return getPersistence().findByField(fieldid);
	}

	/**
	 * Returns a range of all the group fields where fieldid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param fieldid the fieldid
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @return the range of matching group fields
	 */
	public static List<GroupField> findByField(
		long fieldid, int start, int end) {

		return getPersistence().findByField(fieldid, start, end);
	}

	/**
	 * Returns an ordered range of all the group fields where fieldid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param fieldid the fieldid
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group fields
	 */
	public static List<GroupField> findByField(
		long fieldid, int start, int end,
		OrderByComparator<GroupField> orderByComparator) {

		return getPersistence().findByField(
			fieldid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group fields where fieldid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param fieldid the fieldid
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group fields
	 */
	public static List<GroupField> findByField(
		long fieldid, int start, int end,
		OrderByComparator<GroupField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByField(
			fieldid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	public static GroupField findByField_First(
			long fieldid, OrderByComparator<GroupField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchGroupFieldException {

		return getPersistence().findByField_First(fieldid, orderByComparator);
	}

	/**
	 * Returns the first group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field, or <code>null</code> if a matching group field could not be found
	 */
	public static GroupField fetchByField_First(
		long fieldid, OrderByComparator<GroupField> orderByComparator) {

		return getPersistence().fetchByField_First(fieldid, orderByComparator);
	}

	/**
	 * Returns the last group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	public static GroupField findByField_Last(
			long fieldid, OrderByComparator<GroupField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchGroupFieldException {

		return getPersistence().findByField_Last(fieldid, orderByComparator);
	}

	/**
	 * Returns the last group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field, or <code>null</code> if a matching group field could not be found
	 */
	public static GroupField fetchByField_Last(
		long fieldid, OrderByComparator<GroupField> orderByComparator) {

		return getPersistence().fetchByField_Last(fieldid, orderByComparator);
	}

	/**
	 * Returns the group fields before and after the current group field in the ordered set where fieldid = &#63;.
	 *
	 * @param groupFieldPK the primary key of the current group field
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group field
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	public static GroupField[] findByField_PrevAndNext(
			GroupFieldPK groupFieldPK, long fieldid,
			OrderByComparator<GroupField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchGroupFieldException {

		return getPersistence().findByField_PrevAndNext(
			groupFieldPK, fieldid, orderByComparator);
	}

	/**
	 * Removes all the group fields where fieldid = &#63; from the database.
	 *
	 * @param fieldid the fieldid
	 */
	public static void removeByField(long fieldid) {
		getPersistence().removeByField(fieldid);
	}

	/**
	 * Returns the number of group fields where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @return the number of matching group fields
	 */
	public static int countByField(long fieldid) {
		return getPersistence().countByField(fieldid);
	}

	/**
	 * Caches the group field in the entity cache if it is enabled.
	 *
	 * @param groupField the group field
	 */
	public static void cacheResult(GroupField groupField) {
		getPersistence().cacheResult(groupField);
	}

	/**
	 * Caches the group fields in the entity cache if it is enabled.
	 *
	 * @param groupFields the group fields
	 */
	public static void cacheResult(List<GroupField> groupFields) {
		getPersistence().cacheResult(groupFields);
	}

	/**
	 * Creates a new group field with the primary key. Does not add the group field to the database.
	 *
	 * @param groupFieldPK the primary key for the new group field
	 * @return the new group field
	 */
	public static GroupField create(GroupFieldPK groupFieldPK) {
		return getPersistence().create(groupFieldPK);
	}

	/**
	 * Removes the group field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field that was removed
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	public static GroupField remove(GroupFieldPK groupFieldPK)
		throws com.ecoit.elegaldocument.exception.NoSuchGroupFieldException {

		return getPersistence().remove(groupFieldPK);
	}

	public static GroupField updateImpl(GroupField groupField) {
		return getPersistence().updateImpl(groupField);
	}

	/**
	 * Returns the group field with the primary key or throws a <code>NoSuchGroupFieldException</code> if it could not be found.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	public static GroupField findByPrimaryKey(GroupFieldPK groupFieldPK)
		throws com.ecoit.elegaldocument.exception.NoSuchGroupFieldException {

		return getPersistence().findByPrimaryKey(groupFieldPK);
	}

	/**
	 * Returns the group field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field, or <code>null</code> if a group field with the primary key could not be found
	 */
	public static GroupField fetchByPrimaryKey(GroupFieldPK groupFieldPK) {
		return getPersistence().fetchByPrimaryKey(groupFieldPK);
	}

	/**
	 * Returns all the group fields.
	 *
	 * @return the group fields
	 */
	public static List<GroupField> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the group fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @return the range of group fields
	 */
	public static List<GroupField> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the group fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group fields
	 */
	public static List<GroupField> findAll(
		int start, int end, OrderByComparator<GroupField> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group fields
	 */
	public static List<GroupField> findAll(
		int start, int end, OrderByComparator<GroupField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the group fields from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of group fields.
	 *
	 * @return the number of group fields
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static GroupFieldPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GroupFieldPersistence, GroupFieldPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GroupFieldPersistence.class);

		ServiceTracker<GroupFieldPersistence, GroupFieldPersistence>
			serviceTracker =
				new ServiceTracker
					<GroupFieldPersistence, GroupFieldPersistence>(
						bundle.getBundleContext(), GroupFieldPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}