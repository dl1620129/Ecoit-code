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

import Album.service.exception.NoSuchFieldsException;
import Album.service.model.Fields;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the fields service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldsUtil
 * @generated
 */
@ProviderType
public interface FieldsPersistence extends BasePersistence<Fields> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FieldsUtil} to access the fields persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the fields where fieldId = &#63; and groupId = &#63; or throws a <code>NoSuchFieldsException</code> if it could not be found.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the matching fields
	 * @throws NoSuchFieldsException if a matching fields could not be found
	 */
	public Fields findByLinhVucIdAndGroupId(long fieldId, long groupId)
		throws NoSuchFieldsException;

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
	public Fields fetchByLinhVucIdAndGroupId(
		long fieldId, long groupId, boolean useFinderCache);

	/**
	 * Returns the fields where fieldId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fields, or <code>null</code> if a matching fields could not be found
	 */
	public Fields fetchByLinhVucIdAndGroupId(long fieldId, long groupId);

	/**
	 * Removes the fields where fieldId = &#63; and groupId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the fields that was removed
	 */
	public Fields removeByLinhVucIdAndGroupId(long fieldId, long groupId)
		throws NoSuchFieldsException;

	/**
	 * Returns the number of fieldses where fieldId = &#63; and groupId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the number of matching fieldses
	 */
	public int countByLinhVucIdAndGroupId(long fieldId, long groupId);

	/**
	 * Caches the fields in the entity cache if it is enabled.
	 *
	 * @param fields the fields
	 */
	public void cacheResult(Fields fields);

	/**
	 * Caches the fieldses in the entity cache if it is enabled.
	 *
	 * @param fieldses the fieldses
	 */
	public void cacheResult(java.util.List<Fields> fieldses);

	/**
	 * Creates a new fields with the primary key. Does not add the fields to the database.
	 *
	 * @param fieldId the primary key for the new fields
	 * @return the new fields
	 */
	public Fields create(long fieldId);

	/**
	 * Removes the fields with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields that was removed
	 * @throws NoSuchFieldsException if a fields with the primary key could not be found
	 */
	public Fields remove(long fieldId) throws NoSuchFieldsException;

	public Fields updateImpl(Fields fields);

	/**
	 * Returns the fields with the primary key or throws a <code>NoSuchFieldsException</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields
	 * @throws NoSuchFieldsException if a fields with the primary key could not be found
	 */
	public Fields findByPrimaryKey(long fieldId) throws NoSuchFieldsException;

	/**
	 * Returns the fields with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields, or <code>null</code> if a fields with the primary key could not be found
	 */
	public Fields fetchByPrimaryKey(long fieldId);

	/**
	 * Returns all the fieldses.
	 *
	 * @return the fieldses
	 */
	public java.util.List<Fields> findAll();

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
	public java.util.List<Fields> findAll(int start, int end);

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
	public java.util.List<Fields> findAll(
		int start, int end, OrderByComparator<Fields> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Fields> findAll(
		int start, int end, OrderByComparator<Fields> orderByComparator);

	/**
	 * Removes all the fieldses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fieldses.
	 *
	 * @return the number of fieldses
	 */
	public int countAll();

}