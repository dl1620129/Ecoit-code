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

package com.ecoit.cms.config.service.persistence.impl;

import com.ecoit.cms.config.exception.NoSuchPortletConfigException;
import com.ecoit.cms.config.model.PortletConfig;
import com.ecoit.cms.config.model.impl.PortletConfigImpl;
import com.ecoit.cms.config.model.impl.PortletConfigModelImpl;
import com.ecoit.cms.config.service.persistence.PortletConfigPersistence;
import com.ecoit.cms.config.service.persistence.impl.constants.ecoit_configPersistenceConstants;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the portlet config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PortletConfigPersistence.class)
public class PortletConfigPersistenceImpl
	extends BasePersistenceImpl<PortletConfig>
	implements PortletConfigPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PortletConfigUtil</code> to access the portlet config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PortletConfigImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the portlet configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching portlet configs
	 */
	@Override
	public List<PortletConfig> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portlet configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @return the range of matching portlet configs
	 */
	@Override
	public List<PortletConfig> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portlet configs
	 */
	@Override
	public List<PortletConfig> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PortletConfig> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the portlet configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching portlet configs
	 */
	@Override
	public List<PortletConfig> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PortletConfig> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<PortletConfig> list = null;

		if (useFinderCache) {
			list = (List<PortletConfig>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PortletConfig portletConfig : list) {
					if (!uuid.equals(portletConfig.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PORTLETCONFIG_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(PortletConfigModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				list = (List<PortletConfig>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet config
	 * @throws NoSuchPortletConfigException if a matching portlet config could not be found
	 */
	@Override
	public PortletConfig findByUuid_First(
			String uuid, OrderByComparator<PortletConfig> orderByComparator)
		throws NoSuchPortletConfigException {

		PortletConfig portletConfig = fetchByUuid_First(
			uuid, orderByComparator);

		if (portletConfig != null) {
			return portletConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPortletConfigException(msg.toString());
	}

	/**
	 * Returns the first portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet config, or <code>null</code> if a matching portlet config could not be found
	 */
	@Override
	public PortletConfig fetchByUuid_First(
		String uuid, OrderByComparator<PortletConfig> orderByComparator) {

		List<PortletConfig> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet config
	 * @throws NoSuchPortletConfigException if a matching portlet config could not be found
	 */
	@Override
	public PortletConfig findByUuid_Last(
			String uuid, OrderByComparator<PortletConfig> orderByComparator)
		throws NoSuchPortletConfigException {

		PortletConfig portletConfig = fetchByUuid_Last(uuid, orderByComparator);

		if (portletConfig != null) {
			return portletConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPortletConfigException(msg.toString());
	}

	/**
	 * Returns the last portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet config, or <code>null</code> if a matching portlet config could not be found
	 */
	@Override
	public PortletConfig fetchByUuid_Last(
		String uuid, OrderByComparator<PortletConfig> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PortletConfig> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the portlet configs before and after the current portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param portletId the primary key of the current portlet config
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portlet config
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	@Override
	public PortletConfig[] findByUuid_PrevAndNext(
			String portletId, String uuid,
			OrderByComparator<PortletConfig> orderByComparator)
		throws NoSuchPortletConfigException {

		uuid = Objects.toString(uuid, "");

		PortletConfig portletConfig = findByPrimaryKey(portletId);

		Session session = null;

		try {
			session = openSession();

			PortletConfig[] array = new PortletConfigImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, portletConfig, uuid, orderByComparator, true);

			array[1] = portletConfig;

			array[2] = getByUuid_PrevAndNext(
				session, portletConfig, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletConfig getByUuid_PrevAndNext(
		Session session, PortletConfig portletConfig, String uuid,
		OrderByComparator<PortletConfig> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETCONFIG_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PortletConfigModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						portletConfig)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PortletConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the portlet configs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PortletConfig portletConfig :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(portletConfig);
		}
	}

	/**
	 * Returns the number of portlet configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching portlet configs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTLETCONFIG_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"portletConfig.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(portletConfig.uuid IS NULL OR portletConfig.uuid = '')";

	public PortletConfigPersistenceImpl() {
		setModelClass(PortletConfig.class);

		setModelImplClass(PortletConfigImpl.class);
		setModelPKClass(String.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the portlet config in the entity cache if it is enabled.
	 *
	 * @param portletConfig the portlet config
	 */
	@Override
	public void cacheResult(PortletConfig portletConfig) {
		entityCache.putResult(
			entityCacheEnabled, PortletConfigImpl.class,
			portletConfig.getPrimaryKey(), portletConfig);

		portletConfig.resetOriginalValues();
	}

	/**
	 * Caches the portlet configs in the entity cache if it is enabled.
	 *
	 * @param portletConfigs the portlet configs
	 */
	@Override
	public void cacheResult(List<PortletConfig> portletConfigs) {
		for (PortletConfig portletConfig : portletConfigs) {
			if (entityCache.getResult(
					entityCacheEnabled, PortletConfigImpl.class,
					portletConfig.getPrimaryKey()) == null) {

				cacheResult(portletConfig);
			}
			else {
				portletConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all portlet configs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PortletConfigImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the portlet config.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortletConfig portletConfig) {
		entityCache.removeResult(
			entityCacheEnabled, PortletConfigImpl.class,
			portletConfig.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PortletConfig> portletConfigs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortletConfig portletConfig : portletConfigs) {
			entityCache.removeResult(
				entityCacheEnabled, PortletConfigImpl.class,
				portletConfig.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, PortletConfigImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new portlet config with the primary key. Does not add the portlet config to the database.
	 *
	 * @param portletId the primary key for the new portlet config
	 * @return the new portlet config
	 */
	@Override
	public PortletConfig create(String portletId) {
		PortletConfig portletConfig = new PortletConfigImpl();

		portletConfig.setNew(true);
		portletConfig.setPrimaryKey(portletId);

		String uuid = PortalUUIDUtil.generate();

		portletConfig.setUuid(uuid);

		return portletConfig;
	}

	/**
	 * Removes the portlet config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config that was removed
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	@Override
	public PortletConfig remove(String portletId)
		throws NoSuchPortletConfigException {

		return remove((Serializable)portletId);
	}

	/**
	 * Removes the portlet config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the portlet config
	 * @return the portlet config that was removed
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	@Override
	public PortletConfig remove(Serializable primaryKey)
		throws NoSuchPortletConfigException {

		Session session = null;

		try {
			session = openSession();

			PortletConfig portletConfig = (PortletConfig)session.get(
				PortletConfigImpl.class, primaryKey);

			if (portletConfig == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortletConfigException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(portletConfig);
		}
		catch (NoSuchPortletConfigException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PortletConfig removeImpl(PortletConfig portletConfig) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(portletConfig)) {
				portletConfig = (PortletConfig)session.get(
					PortletConfigImpl.class, portletConfig.getPrimaryKeyObj());
			}

			if (portletConfig != null) {
				session.delete(portletConfig);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (portletConfig != null) {
			clearCache(portletConfig);
		}

		return portletConfig;
	}

	@Override
	public PortletConfig updateImpl(PortletConfig portletConfig) {
		boolean isNew = portletConfig.isNew();

		if (!(portletConfig instanceof PortletConfigModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(portletConfig.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					portletConfig);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in portletConfig proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PortletConfig implementation " +
					portletConfig.getClass());
		}

		PortletConfigModelImpl portletConfigModelImpl =
			(PortletConfigModelImpl)portletConfig;

		if (Validator.isNull(portletConfig.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			portletConfig.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (portletConfig.isNew()) {
				session.save(portletConfig);

				portletConfig.setNew(false);
			}
			else {
				portletConfig = (PortletConfig)session.merge(portletConfig);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {portletConfigModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((portletConfigModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					portletConfigModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {portletConfigModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, PortletConfigImpl.class,
			portletConfig.getPrimaryKey(), portletConfig, false);

		portletConfig.resetOriginalValues();

		return portletConfig;
	}

	/**
	 * Returns the portlet config with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet config
	 * @return the portlet config
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	@Override
	public PortletConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPortletConfigException {

		PortletConfig portletConfig = fetchByPrimaryKey(primaryKey);

		if (portletConfig == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPortletConfigException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return portletConfig;
	}

	/**
	 * Returns the portlet config with the primary key or throws a <code>NoSuchPortletConfigException</code> if it could not be found.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	@Override
	public PortletConfig findByPrimaryKey(String portletId)
		throws NoSuchPortletConfigException {

		return findByPrimaryKey((Serializable)portletId);
	}

	/**
	 * Returns the portlet config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config, or <code>null</code> if a portlet config with the primary key could not be found
	 */
	@Override
	public PortletConfig fetchByPrimaryKey(String portletId) {
		return fetchByPrimaryKey((Serializable)portletId);
	}

	/**
	 * Returns all the portlet configs.
	 *
	 * @return the portlet configs
	 */
	@Override
	public List<PortletConfig> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portlet configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @return the range of portlet configs
	 */
	@Override
	public List<PortletConfig> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of portlet configs
	 */
	@Override
	public List<PortletConfig> findAll(
		int start, int end,
		OrderByComparator<PortletConfig> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the portlet configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of portlet configs
	 */
	@Override
	public List<PortletConfig> findAll(
		int start, int end, OrderByComparator<PortletConfig> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PortletConfig> list = null;

		if (useFinderCache) {
			list = (List<PortletConfig>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PORTLETCONFIG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTLETCONFIG;

				sql = sql.concat(PortletConfigModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<PortletConfig>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the portlet configs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PortletConfig portletConfig : findAll()) {
			remove(portletConfig);
		}
	}

	/**
	 * Returns the number of portlet configs.
	 *
	 * @return the number of portlet configs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PORTLETCONFIG);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "portletId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PORTLETCONFIG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PortletConfigModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the portlet config persistence.
	 */
	@Activate
	public void activate() {
		PortletConfigModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		PortletConfigModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PortletConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PortletConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PortletConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PortletConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			PortletConfigModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PortletConfigImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_configPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.cms.config.model.PortletConfig"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_configPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_configPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_PORTLETCONFIG =
		"SELECT portletConfig FROM PortletConfig portletConfig";

	private static final String _SQL_SELECT_PORTLETCONFIG_WHERE =
		"SELECT portletConfig FROM PortletConfig portletConfig WHERE ";

	private static final String _SQL_COUNT_PORTLETCONFIG =
		"SELECT COUNT(portletConfig) FROM PortletConfig portletConfig";

	private static final String _SQL_COUNT_PORTLETCONFIG_WHERE =
		"SELECT COUNT(portletConfig) FROM PortletConfig portletConfig WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "portletConfig.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PortletConfig exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PortletConfig exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PortletConfigPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(ecoit_configPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}