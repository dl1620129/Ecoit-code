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

package Album.service.service.persistence.impl;

import Album.service.exception.NoSuchFieldException;
import Album.service.model.Field;
import Album.service.model.impl.FieldImpl;
import Album.service.model.impl.FieldModelImpl;
import Album.service.service.persistence.FieldPersistence;
import Album.service.service.persistence.impl.constants.portal_albumPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FieldPersistence.class)
@ProviderType
public class FieldPersistenceImpl
	extends BasePersistenceImpl<Field> implements FieldPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FieldUtil</code> to access the field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FieldImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByLinhVucIdAndGroupId;
	private FinderPath _finderPathCountByLinhVucIdAndGroupId;

	/**
	 * Returns the field where fieldId = &#63; and groupId = &#63; or throws a <code>NoSuchFieldException</code> if it could not be found.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the matching field
	 * @throws NoSuchFieldException if a matching field could not be found
	 */
	@Override
	public Field findByLinhVucIdAndGroupId(long fieldId, long groupId)
		throws NoSuchFieldException {

		Field field = fetchByLinhVucIdAndGroupId(fieldId, groupId);

		if (field == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fieldId=");
			msg.append(fieldId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchFieldException(msg.toString());
		}

		return field;
	}

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
	@Override
	public Field fetchByLinhVucIdAndGroupId(
		long fieldId, long groupId, boolean useFinderCache) {

		return fetchByLinhVucIdAndGroupId(fieldId, groupId);
	}

	/**
	 * Returns the field where fieldId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching field, or <code>null</code> if a matching field could not be found
	 */
	@Override
	public Field fetchByLinhVucIdAndGroupId(long fieldId, long groupId) {
		Object[] finderArgs = new Object[] {fieldId, groupId};

		Object result = finderCache.getResult(
			_finderPathFetchByLinhVucIdAndGroupId, finderArgs, this);

		if (result instanceof Field) {
			Field field = (Field)result;

			if ((fieldId != field.getFieldId()) ||
				(groupId != field.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FIELD_WHERE);

			query.append(_FINDER_COLUMN_LINHVUCIDANDGROUPID_FIELDID_2);

			query.append(_FINDER_COLUMN_LINHVUCIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				qPos.add(groupId);

				List<Field> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByLinhVucIdAndGroupId, finderArgs,
						list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"FieldPersistenceImpl.fetchByLinhVucIdAndGroupId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Field field = list.get(0);

					result = field;

					cacheResult(field);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByLinhVucIdAndGroupId, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Field)result;
		}
	}

	/**
	 * Removes the field where fieldId = &#63; and groupId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the field that was removed
	 */
	@Override
	public Field removeByLinhVucIdAndGroupId(long fieldId, long groupId)
		throws NoSuchFieldException {

		Field field = findByLinhVucIdAndGroupId(fieldId, groupId);

		return remove(field);
	}

	/**
	 * Returns the number of fields where fieldId = &#63; and groupId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the number of matching fields
	 */
	@Override
	public int countByLinhVucIdAndGroupId(long fieldId, long groupId) {
		FinderPath finderPath = _finderPathCountByLinhVucIdAndGroupId;

		Object[] finderArgs = new Object[] {fieldId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FIELD_WHERE);

			query.append(_FINDER_COLUMN_LINHVUCIDANDGROUPID_FIELDID_2);

			query.append(_FINDER_COLUMN_LINHVUCIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LINHVUCIDANDGROUPID_FIELDID_2 =
		"field.fieldId = ? AND ";

	private static final String _FINDER_COLUMN_LINHVUCIDANDGROUPID_GROUPID_2 =
		"field.groupId = ?";

	public FieldPersistenceImpl() {
		setModelClass(Field.class);

		setModelImplClass(FieldImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the field in the entity cache if it is enabled.
	 *
	 * @param field the field
	 */
	@Override
	public void cacheResult(Field field) {
		entityCache.putResult(
			entityCacheEnabled, FieldImpl.class, field.getPrimaryKey(), field);

		finderCache.putResult(
			_finderPathFetchByLinhVucIdAndGroupId,
			new Object[] {field.getFieldId(), field.getGroupId()}, field);

		field.resetOriginalValues();
	}

	/**
	 * Caches the fields in the entity cache if it is enabled.
	 *
	 * @param fields the fields
	 */
	@Override
	public void cacheResult(List<Field> fields) {
		for (Field field : fields) {
			if (entityCache.getResult(
					entityCacheEnabled, FieldImpl.class,
					field.getPrimaryKey()) == null) {

				cacheResult(field);
			}
			else {
				field.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fields.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FieldImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the field.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Field field) {
		entityCache.removeResult(
			entityCacheEnabled, FieldImpl.class, field.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FieldModelImpl)field, true);
	}

	@Override
	public void clearCache(List<Field> fields) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Field field : fields) {
			entityCache.removeResult(
				entityCacheEnabled, FieldImpl.class, field.getPrimaryKey());

			clearUniqueFindersCache((FieldModelImpl)field, true);
		}
	}

	protected void cacheUniqueFindersCache(FieldModelImpl fieldModelImpl) {
		Object[] args = new Object[] {
			fieldModelImpl.getFieldId(), fieldModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByLinhVucIdAndGroupId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByLinhVucIdAndGroupId, args, fieldModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		FieldModelImpl fieldModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				fieldModelImpl.getFieldId(), fieldModelImpl.getGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByLinhVucIdAndGroupId, args);
			finderCache.removeResult(
				_finderPathFetchByLinhVucIdAndGroupId, args);
		}

		if ((fieldModelImpl.getColumnBitmask() &
			 _finderPathFetchByLinhVucIdAndGroupId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				fieldModelImpl.getOriginalFieldId(),
				fieldModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByLinhVucIdAndGroupId, args);
			finderCache.removeResult(
				_finderPathFetchByLinhVucIdAndGroupId, args);
		}
	}

	/**
	 * Creates a new field with the primary key. Does not add the field to the database.
	 *
	 * @param fieldId the primary key for the new field
	 * @return the new field
	 */
	@Override
	public Field create(long fieldId) {
		Field field = new FieldImpl();

		field.setNew(true);
		field.setPrimaryKey(fieldId);

		return field;
	}

	/**
	 * Removes the field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the field
	 * @return the field that was removed
	 * @throws NoSuchFieldException if a field with the primary key could not be found
	 */
	@Override
	public Field remove(long fieldId) throws NoSuchFieldException {
		return remove((Serializable)fieldId);
	}

	/**
	 * Removes the field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the field
	 * @return the field that was removed
	 * @throws NoSuchFieldException if a field with the primary key could not be found
	 */
	@Override
	public Field remove(Serializable primaryKey) throws NoSuchFieldException {
		Session session = null;

		try {
			session = openSession();

			Field field = (Field)session.get(FieldImpl.class, primaryKey);

			if (field == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFieldException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(field);
		}
		catch (NoSuchFieldException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Field removeImpl(Field field) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(field)) {
				field = (Field)session.get(
					FieldImpl.class, field.getPrimaryKeyObj());
			}

			if (field != null) {
				session.delete(field);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (field != null) {
			clearCache(field);
		}

		return field;
	}

	@Override
	public Field updateImpl(Field field) {
		boolean isNew = field.isNew();

		if (!(field instanceof FieldModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(field.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(field);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in field proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Field implementation " +
					field.getClass());
		}

		FieldModelImpl fieldModelImpl = (FieldModelImpl)field;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (field.getCreateDate() == null)) {
			if (serviceContext == null) {
				field.setCreateDate(now);
			}
			else {
				field.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!fieldModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				field.setModifiedDate(now);
			}
			else {
				field.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (field.isNew()) {
				session.save(field);

				field.setNew(false);
			}
			else {
				field = (Field)session.merge(field);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, FieldImpl.class, field.getPrimaryKey(), field,
			false);

		clearUniqueFindersCache(fieldModelImpl, false);
		cacheUniqueFindersCache(fieldModelImpl);

		field.resetOriginalValues();

		return field;
	}

	/**
	 * Returns the field with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the field
	 * @return the field
	 * @throws NoSuchFieldException if a field with the primary key could not be found
	 */
	@Override
	public Field findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFieldException {

		Field field = fetchByPrimaryKey(primaryKey);

		if (field == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFieldException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return field;
	}

	/**
	 * Returns the field with the primary key or throws a <code>NoSuchFieldException</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the field
	 * @return the field
	 * @throws NoSuchFieldException if a field with the primary key could not be found
	 */
	@Override
	public Field findByPrimaryKey(long fieldId) throws NoSuchFieldException {
		return findByPrimaryKey((Serializable)fieldId);
	}

	/**
	 * Returns the field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the field
	 * @return the field, or <code>null</code> if a field with the primary key could not be found
	 */
	@Override
	public Field fetchByPrimaryKey(long fieldId) {
		return fetchByPrimaryKey((Serializable)fieldId);
	}

	/**
	 * Returns all the fields.
	 *
	 * @return the fields
	 */
	@Override
	public List<Field> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Field> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Field> findAll(
		int start, int end, OrderByComparator<Field> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

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
	@Override
	public List<Field> findAll(
		int start, int end, OrderByComparator<Field> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Field> list = (List<Field>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FIELD);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FIELD;

				if (pagination) {
					sql = sql.concat(FieldModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Field>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Field>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the fields from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Field field : findAll()) {
			remove(field);
		}
	}

	/**
	 * Returns the number of fields.
	 *
	 * @return the number of fields
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FIELD);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "fieldId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FIELD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FieldModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the field persistence.
	 */
	@Activate
	public void activate() {
		FieldModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		FieldModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByLinhVucIdAndGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FieldImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLinhVucIdAndGroupId",
			new String[] {Long.class.getName(), Long.class.getName()},
			FieldModelImpl.FIELDID_COLUMN_BITMASK |
			FieldModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByLinhVucIdAndGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLinhVucIdAndGroupId",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(FieldImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = portal_albumPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.Album.service.model.Field"),
			true);
	}

	@Override
	@Reference(
		target = portal_albumPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = portal_albumPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FIELD =
		"SELECT field FROM Field field";

	private static final String _SQL_SELECT_FIELD_WHERE =
		"SELECT field FROM Field field WHERE ";

	private static final String _SQL_COUNT_FIELD =
		"SELECT COUNT(field) FROM Field field";

	private static final String _SQL_COUNT_FIELD_WHERE =
		"SELECT COUNT(field) FROM Field field WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "field.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Field exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Field exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FieldPersistenceImpl.class);

	static {
		try {
			Class.forName(portal_albumPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}