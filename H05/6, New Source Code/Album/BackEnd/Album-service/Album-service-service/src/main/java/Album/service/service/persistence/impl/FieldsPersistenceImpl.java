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

import Album.service.exception.NoSuchFieldsException;
import Album.service.model.Fields;
import Album.service.model.impl.FieldsImpl;
import Album.service.model.impl.FieldsModelImpl;
import Album.service.service.persistence.FieldsPersistence;
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
 * The persistence implementation for the fields service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FieldsPersistence.class)
@ProviderType
public class FieldsPersistenceImpl
	extends BasePersistenceImpl<Fields> implements FieldsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FieldsUtil</code> to access the fields persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FieldsImpl.class.getName();

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
	 * Returns the fields where fieldId = &#63; and groupId = &#63; or throws a <code>NoSuchFieldsException</code> if it could not be found.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the matching fields
	 * @throws NoSuchFieldsException if a matching fields could not be found
	 */
	@Override
	public Fields findByLinhVucIdAndGroupId(long fieldId, long groupId)
		throws NoSuchFieldsException {

		Fields fields = fetchByLinhVucIdAndGroupId(fieldId, groupId);

		if (fields == null) {
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

			throw new NoSuchFieldsException(msg.toString());
		}

		return fields;
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
	@Override
	public Fields fetchByLinhVucIdAndGroupId(
		long fieldId, long groupId, boolean useFinderCache) {

		return fetchByLinhVucIdAndGroupId(fieldId, groupId);
	}

	/**
	 * Returns the fields where fieldId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fields, or <code>null</code> if a matching fields could not be found
	 */
	@Override
	public Fields fetchByLinhVucIdAndGroupId(long fieldId, long groupId) {
		Object[] finderArgs = new Object[] {fieldId, groupId};

		Object result = finderCache.getResult(
			_finderPathFetchByLinhVucIdAndGroupId, finderArgs, this);

		if (result instanceof Fields) {
			Fields fields = (Fields)result;

			if ((fieldId != fields.getFieldId()) ||
				(groupId != fields.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FIELDS_WHERE);

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

				List<Fields> list = q.list();

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
								"FieldsPersistenceImpl.fetchByLinhVucIdAndGroupId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Fields fields = list.get(0);

					result = fields;

					cacheResult(fields);
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
			return (Fields)result;
		}
	}

	/**
	 * Removes the fields where fieldId = &#63; and groupId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the fields that was removed
	 */
	@Override
	public Fields removeByLinhVucIdAndGroupId(long fieldId, long groupId)
		throws NoSuchFieldsException {

		Fields fields = findByLinhVucIdAndGroupId(fieldId, groupId);

		return remove(fields);
	}

	/**
	 * Returns the number of fieldses where fieldId = &#63; and groupId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param groupId the group ID
	 * @return the number of matching fieldses
	 */
	@Override
	public int countByLinhVucIdAndGroupId(long fieldId, long groupId) {
		FinderPath finderPath = _finderPathCountByLinhVucIdAndGroupId;

		Object[] finderArgs = new Object[] {fieldId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FIELDS_WHERE);

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
		"fields.fieldId = ? AND ";

	private static final String _FINDER_COLUMN_LINHVUCIDANDGROUPID_GROUPID_2 =
		"fields.groupId = ?";

	public FieldsPersistenceImpl() {
		setModelClass(Fields.class);

		setModelImplClass(FieldsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the fields in the entity cache if it is enabled.
	 *
	 * @param fields the fields
	 */
	@Override
	public void cacheResult(Fields fields) {
		entityCache.putResult(
			entityCacheEnabled, FieldsImpl.class, fields.getPrimaryKey(),
			fields);

		finderCache.putResult(
			_finderPathFetchByLinhVucIdAndGroupId,
			new Object[] {fields.getFieldId(), fields.getGroupId()}, fields);

		fields.resetOriginalValues();
	}

	/**
	 * Caches the fieldses in the entity cache if it is enabled.
	 *
	 * @param fieldses the fieldses
	 */
	@Override
	public void cacheResult(List<Fields> fieldses) {
		for (Fields fields : fieldses) {
			if (entityCache.getResult(
					entityCacheEnabled, FieldsImpl.class,
					fields.getPrimaryKey()) == null) {

				cacheResult(fields);
			}
			else {
				fields.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fieldses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FieldsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fields.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Fields fields) {
		entityCache.removeResult(
			entityCacheEnabled, FieldsImpl.class, fields.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FieldsModelImpl)fields, true);
	}

	@Override
	public void clearCache(List<Fields> fieldses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Fields fields : fieldses) {
			entityCache.removeResult(
				entityCacheEnabled, FieldsImpl.class, fields.getPrimaryKey());

			clearUniqueFindersCache((FieldsModelImpl)fields, true);
		}
	}

	protected void cacheUniqueFindersCache(FieldsModelImpl fieldsModelImpl) {
		Object[] args = new Object[] {
			fieldsModelImpl.getFieldId(), fieldsModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByLinhVucIdAndGroupId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByLinhVucIdAndGroupId, args, fieldsModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		FieldsModelImpl fieldsModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				fieldsModelImpl.getFieldId(), fieldsModelImpl.getGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByLinhVucIdAndGroupId, args);
			finderCache.removeResult(
				_finderPathFetchByLinhVucIdAndGroupId, args);
		}

		if ((fieldsModelImpl.getColumnBitmask() &
			 _finderPathFetchByLinhVucIdAndGroupId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				fieldsModelImpl.getOriginalFieldId(),
				fieldsModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByLinhVucIdAndGroupId, args);
			finderCache.removeResult(
				_finderPathFetchByLinhVucIdAndGroupId, args);
		}
	}

	/**
	 * Creates a new fields with the primary key. Does not add the fields to the database.
	 *
	 * @param fieldId the primary key for the new fields
	 * @return the new fields
	 */
	@Override
	public Fields create(long fieldId) {
		Fields fields = new FieldsImpl();

		fields.setNew(true);
		fields.setPrimaryKey(fieldId);

		return fields;
	}

	/**
	 * Removes the fields with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields that was removed
	 * @throws NoSuchFieldsException if a fields with the primary key could not be found
	 */
	@Override
	public Fields remove(long fieldId) throws NoSuchFieldsException {
		return remove((Serializable)fieldId);
	}

	/**
	 * Removes the fields with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fields
	 * @return the fields that was removed
	 * @throws NoSuchFieldsException if a fields with the primary key could not be found
	 */
	@Override
	public Fields remove(Serializable primaryKey) throws NoSuchFieldsException {
		Session session = null;

		try {
			session = openSession();

			Fields fields = (Fields)session.get(FieldsImpl.class, primaryKey);

			if (fields == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFieldsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fields);
		}
		catch (NoSuchFieldsException nsee) {
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
	protected Fields removeImpl(Fields fields) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fields)) {
				fields = (Fields)session.get(
					FieldsImpl.class, fields.getPrimaryKeyObj());
			}

			if (fields != null) {
				session.delete(fields);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fields != null) {
			clearCache(fields);
		}

		return fields;
	}

	@Override
	public Fields updateImpl(Fields fields) {
		boolean isNew = fields.isNew();

		if (!(fields instanceof FieldsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fields.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(fields);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fields proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Fields implementation " +
					fields.getClass());
		}

		FieldsModelImpl fieldsModelImpl = (FieldsModelImpl)fields;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (fields.getCreateDate() == null)) {
			if (serviceContext == null) {
				fields.setCreateDate(now);
			}
			else {
				fields.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!fieldsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				fields.setModifiedDate(now);
			}
			else {
				fields.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (fields.isNew()) {
				session.save(fields);

				fields.setNew(false);
			}
			else {
				fields = (Fields)session.merge(fields);
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
			entityCacheEnabled, FieldsImpl.class, fields.getPrimaryKey(),
			fields, false);

		clearUniqueFindersCache(fieldsModelImpl, false);
		cacheUniqueFindersCache(fieldsModelImpl);

		fields.resetOriginalValues();

		return fields;
	}

	/**
	 * Returns the fields with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fields
	 * @return the fields
	 * @throws NoSuchFieldsException if a fields with the primary key could not be found
	 */
	@Override
	public Fields findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFieldsException {

		Fields fields = fetchByPrimaryKey(primaryKey);

		if (fields == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFieldsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fields;
	}

	/**
	 * Returns the fields with the primary key or throws a <code>NoSuchFieldsException</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields
	 * @throws NoSuchFieldsException if a fields with the primary key could not be found
	 */
	@Override
	public Fields findByPrimaryKey(long fieldId) throws NoSuchFieldsException {
		return findByPrimaryKey((Serializable)fieldId);
	}

	/**
	 * Returns the fields with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the fields
	 * @return the fields, or <code>null</code> if a fields with the primary key could not be found
	 */
	@Override
	public Fields fetchByPrimaryKey(long fieldId) {
		return fetchByPrimaryKey((Serializable)fieldId);
	}

	/**
	 * Returns all the fieldses.
	 *
	 * @return the fieldses
	 */
	@Override
	public List<Fields> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Fields> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Fields> findAll(
		int start, int end, OrderByComparator<Fields> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<Fields> findAll(
		int start, int end, OrderByComparator<Fields> orderByComparator) {

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

		List<Fields> list = (List<Fields>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FIELDS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FIELDS;

				if (pagination) {
					sql = sql.concat(FieldsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Fields>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Fields>)QueryUtil.list(
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
	 * Removes all the fieldses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Fields fields : findAll()) {
			remove(fields);
		}
	}

	/**
	 * Returns the number of fieldses.
	 *
	 * @return the number of fieldses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FIELDS);

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
		return _SQL_SELECT_FIELDS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FieldsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fields persistence.
	 */
	@Activate
	public void activate() {
		FieldsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		FieldsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FieldsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FieldsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByLinhVucIdAndGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FieldsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLinhVucIdAndGroupId",
			new String[] {Long.class.getName(), Long.class.getName()},
			FieldsModelImpl.FIELDID_COLUMN_BITMASK |
			FieldsModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByLinhVucIdAndGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLinhVucIdAndGroupId",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(FieldsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.Album.service.model.Fields"),
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

	private static final String _SQL_SELECT_FIELDS =
		"SELECT fields FROM Fields fields";

	private static final String _SQL_SELECT_FIELDS_WHERE =
		"SELECT fields FROM Fields fields WHERE ";

	private static final String _SQL_COUNT_FIELDS =
		"SELECT COUNT(fields) FROM Fields fields";

	private static final String _SQL_COUNT_FIELDS_WHERE =
		"SELECT COUNT(fields) FROM Fields fields WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fields.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Fields exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Fields exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FieldsPersistenceImpl.class);

	static {
		try {
			Class.forName(portal_albumPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}