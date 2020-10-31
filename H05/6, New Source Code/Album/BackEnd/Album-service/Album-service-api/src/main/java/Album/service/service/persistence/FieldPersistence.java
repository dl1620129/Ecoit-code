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

import Album.service.exception.NoSuchFieldException;
import Album.service.model.Field;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldUtil
 * @generated
 */
@ProviderType
public interface FieldPersistence extends BasePersistence<Field> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FieldUtil} to access the field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the field where fieldId = &#63; and groupId = &#63; or throws a <code>NoSuchFieldException</code> if it could not be found.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the matching field
	 * @throws NoSuchFieldException if a matching field could not be found
	 */
	public Field findByLinhVucIdAndGroupId(long fieldId, long groupId)
		throws NoSuchFieldException;

	/**
	 * Returns the field where fieldId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByLinhVucIdAndGroupId(long,long)}
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching field, or <code>null</code> if a matching field could not be found
	 */
	@Deprecated
	public Field fetchByLinhVucIdAndGroupId(
		long fieldId, long groupId, boolean useFinderCache);

	/**
	 * Returns the field where fieldId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching field, or <code>null</code> if a matching field could not be found
	 */
	public Field fetchByLinhVucIdAndGroupId(long fieldId, long groupId);

	/**
	 * Removes the field where fieldId = &#63; and groupId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the field that was removed
	 */
	public Field removeByLinhVucIdAndGroupId(long fieldId, long groupId)
		throws NoSuchFieldException;

	/**
	 * Returns the number of fields where fieldId = &#63; and groupId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the number of matching fields
	 */
	public int countByLinhVucIdAndGroupId(long fieldId, long groupId);

	/**
	 * Caches the field in the entity cache if it is enabled.
	 *
	 * @param field the field
	 */
	public void cacheResult(Field field);

	/**
	 * Caches the fields in the entity cache if it is enabled.
	 *
	 * @param fields the fields
	 */
	public void cacheResult(java.util.List<Field> fields);

	/**
	 * Creates a new field with the primary key. Does not add the field to the database.
	 *
	 * @param fieldId the primary key for the new field
	 * @return the new field
	 */
	public Field create(long fieldId);

	/**
	 * Removes the field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the field
	 * @return the field that was removed
	 * @throws NoSuchFieldException if a field with the primary key could not be found
	 */
	public Field remove(long fieldId) throws NoSuchFieldException;

	public Field updateImpl(Field field);

	/**
	 * Returns the field with the primary key or throws a <code>NoSuchFieldException</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the field
	 * @return the field
	 * @throws NoSuchFieldException if a field with the primary key could not be found
	 */
	public Field findByPrimaryKey(long fieldId) throws NoSuchFieldException;

	/**
	 * Returns the field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the field
	 * @return the field, or <code>null</code> if a field with the primary key could not be found
	 */
	public Field fetchByPrimaryKey(long fieldId);

	/**
	 * Returns all the fields.
	 *
	 * @return the fields
	 */
	public java.util.List<Field> findAll();

	/**
	 * Returns a range of all the fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fields
	 * @param end the upper bound of the range of fields (not inclusive)
	 * @return the range of fields
	 */
	public java.util.List<Field> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of fields
	 * @param end the upper bound of the range of fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fields
	 */
	@Deprecated
	public java.util.List<Field> findAll(
		int start, int end, OrderByComparator<Field> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fields
	 * @param end the upper bound of the range of fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fields
	 */
	public java.util.List<Field> findAll(
		int start, int end, OrderByComparator<Field> orderByComparator);

	/**
	 * Removes all the fields from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fields.
	 *
	 * @return the number of fields
	 */
	public int countAll();

}