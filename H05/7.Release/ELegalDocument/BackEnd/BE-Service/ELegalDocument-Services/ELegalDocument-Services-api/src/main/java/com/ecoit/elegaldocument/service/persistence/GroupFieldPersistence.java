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

import com.ecoit.elegaldocument.exception.NoSuchGroupFieldException;
import com.ecoit.elegaldocument.model.GroupField;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the group field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see GroupFieldUtil
 * @generated
 */
@ProviderType
public interface GroupFieldPersistence extends BasePersistence<GroupField> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GroupFieldUtil} to access the group field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the group fields where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group fields
	 */
	public java.util.List<GroupField> findByGroupUser(long groupUserId);

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
	public java.util.List<GroupField> findByGroupUser(
		long groupUserId, int start, int end);

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
	public java.util.List<GroupField> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupField>
			orderByComparator);

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
	public java.util.List<GroupField> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	public GroupField findByGroupUser_First(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupField>
				orderByComparator)
		throws NoSuchGroupFieldException;

	/**
	 * Returns the first group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field, or <code>null</code> if a matching group field could not be found
	 */
	public GroupField fetchByGroupUser_First(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupField>
			orderByComparator);

	/**
	 * Returns the last group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	public GroupField findByGroupUser_Last(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupField>
				orderByComparator)
		throws NoSuchGroupFieldException;

	/**
	 * Returns the last group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field, or <code>null</code> if a matching group field could not be found
	 */
	public GroupField fetchByGroupUser_Last(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupField>
			orderByComparator);

	/**
	 * Returns the group fields before and after the current group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupFieldPK the primary key of the current group field
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group field
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	public GroupField[] findByGroupUser_PrevAndNext(
			GroupFieldPK groupFieldPK, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupField>
				orderByComparator)
		throws NoSuchGroupFieldException;

	/**
	 * Removes all the group fields where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public void removeByGroupUser(long groupUserId);

	/**
	 * Returns the number of group fields where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group fields
	 */
	public int countByGroupUser(long groupUserId);

	/**
	 * Returns all the group fields where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @return the matching group fields
	 */
	public java.util.List<GroupField> findByField(long fieldid);

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
	public java.util.List<GroupField> findByField(
		long fieldid, int start, int end);

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
	public java.util.List<GroupField> findByField(
		long fieldid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupField>
			orderByComparator);

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
	public java.util.List<GroupField> findByField(
		long fieldid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	public GroupField findByField_First(
			long fieldid,
			com.liferay.portal.kernel.util.OrderByComparator<GroupField>
				orderByComparator)
		throws NoSuchGroupFieldException;

	/**
	 * Returns the first group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field, or <code>null</code> if a matching group field could not be found
	 */
	public GroupField fetchByField_First(
		long fieldid,
		com.liferay.portal.kernel.util.OrderByComparator<GroupField>
			orderByComparator);

	/**
	 * Returns the last group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	public GroupField findByField_Last(
			long fieldid,
			com.liferay.portal.kernel.util.OrderByComparator<GroupField>
				orderByComparator)
		throws NoSuchGroupFieldException;

	/**
	 * Returns the last group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field, or <code>null</code> if a matching group field could not be found
	 */
	public GroupField fetchByField_Last(
		long fieldid,
		com.liferay.portal.kernel.util.OrderByComparator<GroupField>
			orderByComparator);

	/**
	 * Returns the group fields before and after the current group field in the ordered set where fieldid = &#63;.
	 *
	 * @param groupFieldPK the primary key of the current group field
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group field
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	public GroupField[] findByField_PrevAndNext(
			GroupFieldPK groupFieldPK, long fieldid,
			com.liferay.portal.kernel.util.OrderByComparator<GroupField>
				orderByComparator)
		throws NoSuchGroupFieldException;

	/**
	 * Removes all the group fields where fieldid = &#63; from the database.
	 *
	 * @param fieldid the fieldid
	 */
	public void removeByField(long fieldid);

	/**
	 * Returns the number of group fields where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @return the number of matching group fields
	 */
	public int countByField(long fieldid);

	/**
	 * Caches the group field in the entity cache if it is enabled.
	 *
	 * @param groupField the group field
	 */
	public void cacheResult(GroupField groupField);

	/**
	 * Caches the group fields in the entity cache if it is enabled.
	 *
	 * @param groupFields the group fields
	 */
	public void cacheResult(java.util.List<GroupField> groupFields);

	/**
	 * Creates a new group field with the primary key. Does not add the group field to the database.
	 *
	 * @param groupFieldPK the primary key for the new group field
	 * @return the new group field
	 */
	public GroupField create(GroupFieldPK groupFieldPK);

	/**
	 * Removes the group field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field that was removed
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	public GroupField remove(GroupFieldPK groupFieldPK)
		throws NoSuchGroupFieldException;

	public GroupField updateImpl(GroupField groupField);

	/**
	 * Returns the group field with the primary key or throws a <code>NoSuchGroupFieldException</code> if it could not be found.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	public GroupField findByPrimaryKey(GroupFieldPK groupFieldPK)
		throws NoSuchGroupFieldException;

	/**
	 * Returns the group field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field, or <code>null</code> if a group field with the primary key could not be found
	 */
	public GroupField fetchByPrimaryKey(GroupFieldPK groupFieldPK);

	/**
	 * Returns all the group fields.
	 *
	 * @return the group fields
	 */
	public java.util.List<GroupField> findAll();

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
	public java.util.List<GroupField> findAll(int start, int end);

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
	public java.util.List<GroupField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupField>
			orderByComparator);

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
	public java.util.List<GroupField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the group fields from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of group fields.
	 *
	 * @return the number of group fields
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}