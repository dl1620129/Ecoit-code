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

package com.ecoit.elegaldocument.service.persistence.impl;

import com.ecoit.elegaldocument.exception.NoSuchLegalConfigurationFileException;
import com.ecoit.elegaldocument.model.LegalConfigurationFile;
import com.ecoit.elegaldocument.model.impl.LegalConfigurationFileImpl;
import com.ecoit.elegaldocument.model.impl.LegalConfigurationFileModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalConfigurationFilePersistence;
import com.ecoit.elegaldocument.service.persistence.impl.constants.ecoit_docPersistenceConstants;

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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the legal configuration file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalConfigurationFilePersistence.class)
public class LegalConfigurationFilePersistenceImpl
	extends BasePersistenceImpl<LegalConfigurationFile>
	implements LegalConfigurationFilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalConfigurationFileUtil</code> to access the legal configuration file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalConfigurationFileImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByKey;
	private FinderPath _finderPathCountByKey;

	/**
	 * Returns the legal configuration file where keyId = &#63; or throws a <code>NoSuchLegalConfigurationFileException</code> if it could not be found.
	 *
	 * @param keyId the key ID
	 * @return the matching legal configuration file
	 * @throws NoSuchLegalConfigurationFileException if a matching legal configuration file could not be found
	 */
	@Override
	public LegalConfigurationFile findByKey(String keyId)
		throws NoSuchLegalConfigurationFileException {

		LegalConfigurationFile legalConfigurationFile = fetchByKey(keyId);

		if (legalConfigurationFile == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("keyId=");
			msg.append(keyId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalConfigurationFileException(msg.toString());
		}

		return legalConfigurationFile;
	}

	/**
	 * Returns the legal configuration file where keyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param keyId the key ID
	 * @return the matching legal configuration file, or <code>null</code> if a matching legal configuration file could not be found
	 */
	@Override
	public LegalConfigurationFile fetchByKey(String keyId) {
		return fetchByKey(keyId, true);
	}

	/**
	 * Returns the legal configuration file where keyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param keyId the key ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal configuration file, or <code>null</code> if a matching legal configuration file could not be found
	 */
	@Override
	public LegalConfigurationFile fetchByKey(
		String keyId, boolean useFinderCache) {

		keyId = Objects.toString(keyId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {keyId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByKey, finderArgs, this);
		}

		if (result instanceof LegalConfigurationFile) {
			LegalConfigurationFile legalConfigurationFile =
				(LegalConfigurationFile)result;

			if (!Objects.equals(keyId, legalConfigurationFile.getKeyId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGALCONFIGURATIONFILE_WHERE);

			boolean bindKeyId = false;

			if (keyId.isEmpty()) {
				query.append(_FINDER_COLUMN_KEY_KEYID_3);
			}
			else {
				bindKeyId = true;

				query.append(_FINDER_COLUMN_KEY_KEYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKeyId) {
					qPos.add(keyId);
				}

				List<LegalConfigurationFile> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByKey, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {keyId};
							}

							_log.warn(
								"LegalConfigurationFilePersistenceImpl.fetchByKey(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalConfigurationFile legalConfigurationFile = list.get(0);

					result = legalConfigurationFile;

					cacheResult(legalConfigurationFile);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByKey, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LegalConfigurationFile)result;
		}
	}

	/**
	 * Removes the legal configuration file where keyId = &#63; from the database.
	 *
	 * @param keyId the key ID
	 * @return the legal configuration file that was removed
	 */
	@Override
	public LegalConfigurationFile removeByKey(String keyId)
		throws NoSuchLegalConfigurationFileException {

		LegalConfigurationFile legalConfigurationFile = findByKey(keyId);

		return remove(legalConfigurationFile);
	}

	/**
	 * Returns the number of legal configuration files where keyId = &#63;.
	 *
	 * @param keyId the key ID
	 * @return the number of matching legal configuration files
	 */
	@Override
	public int countByKey(String keyId) {
		keyId = Objects.toString(keyId, "");

		FinderPath finderPath = _finderPathCountByKey;

		Object[] finderArgs = new Object[] {keyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALCONFIGURATIONFILE_WHERE);

			boolean bindKeyId = false;

			if (keyId.isEmpty()) {
				query.append(_FINDER_COLUMN_KEY_KEYID_3);
			}
			else {
				bindKeyId = true;

				query.append(_FINDER_COLUMN_KEY_KEYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKeyId) {
					qPos.add(keyId);
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

	private static final String _FINDER_COLUMN_KEY_KEYID_2 =
		"legalConfigurationFile.keyId = ?";

	private static final String _FINDER_COLUMN_KEY_KEYID_3 =
		"(legalConfigurationFile.keyId IS NULL OR legalConfigurationFile.keyId = '')";

	public LegalConfigurationFilePersistenceImpl() {
		setModelClass(LegalConfigurationFile.class);

		setModelImplClass(LegalConfigurationFileImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the legal configuration file in the entity cache if it is enabled.
	 *
	 * @param legalConfigurationFile the legal configuration file
	 */
	@Override
	public void cacheResult(LegalConfigurationFile legalConfigurationFile) {
		entityCache.putResult(
			entityCacheEnabled, LegalConfigurationFileImpl.class,
			legalConfigurationFile.getPrimaryKey(), legalConfigurationFile);

		finderCache.putResult(
			_finderPathFetchByKey,
			new Object[] {legalConfigurationFile.getKeyId()},
			legalConfigurationFile);

		legalConfigurationFile.resetOriginalValues();
	}

	/**
	 * Caches the legal configuration files in the entity cache if it is enabled.
	 *
	 * @param legalConfigurationFiles the legal configuration files
	 */
	@Override
	public void cacheResult(
		List<LegalConfigurationFile> legalConfigurationFiles) {

		for (LegalConfigurationFile legalConfigurationFile :
				legalConfigurationFiles) {

			if (entityCache.getResult(
					entityCacheEnabled, LegalConfigurationFileImpl.class,
					legalConfigurationFile.getPrimaryKey()) == null) {

				cacheResult(legalConfigurationFile);
			}
			else {
				legalConfigurationFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal configuration files.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalConfigurationFileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal configuration file.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalConfigurationFile legalConfigurationFile) {
		entityCache.removeResult(
			entityCacheEnabled, LegalConfigurationFileImpl.class,
			legalConfigurationFile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(LegalConfigurationFileModelImpl)legalConfigurationFile, true);
	}

	@Override
	public void clearCache(
		List<LegalConfigurationFile> legalConfigurationFiles) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalConfigurationFile legalConfigurationFile :
				legalConfigurationFiles) {

			entityCache.removeResult(
				entityCacheEnabled, LegalConfigurationFileImpl.class,
				legalConfigurationFile.getPrimaryKey());

			clearUniqueFindersCache(
				(LegalConfigurationFileModelImpl)legalConfigurationFile, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalConfigurationFileImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalConfigurationFileModelImpl legalConfigurationFileModelImpl) {

		Object[] args = new Object[] {
			legalConfigurationFileModelImpl.getKeyId()
		};

		finderCache.putResult(
			_finderPathCountByKey, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByKey, args, legalConfigurationFileModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		LegalConfigurationFileModelImpl legalConfigurationFileModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalConfigurationFileModelImpl.getKeyId()
			};

			finderCache.removeResult(_finderPathCountByKey, args);
			finderCache.removeResult(_finderPathFetchByKey, args);
		}

		if ((legalConfigurationFileModelImpl.getColumnBitmask() &
			 _finderPathFetchByKey.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalConfigurationFileModelImpl.getOriginalKeyId()
			};

			finderCache.removeResult(_finderPathCountByKey, args);
			finderCache.removeResult(_finderPathFetchByKey, args);
		}
	}

	/**
	 * Creates a new legal configuration file with the primary key. Does not add the legal configuration file to the database.
	 *
	 * @param keyId the primary key for the new legal configuration file
	 * @return the new legal configuration file
	 */
	@Override
	public LegalConfigurationFile create(String keyId) {
		LegalConfigurationFile legalConfigurationFile =
			new LegalConfigurationFileImpl();

		legalConfigurationFile.setNew(true);
		legalConfigurationFile.setPrimaryKey(keyId);

		return legalConfigurationFile;
	}

	/**
	 * Removes the legal configuration file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file that was removed
	 * @throws NoSuchLegalConfigurationFileException if a legal configuration file with the primary key could not be found
	 */
	@Override
	public LegalConfigurationFile remove(String keyId)
		throws NoSuchLegalConfigurationFileException {

		return remove((Serializable)keyId);
	}

	/**
	 * Removes the legal configuration file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal configuration file
	 * @return the legal configuration file that was removed
	 * @throws NoSuchLegalConfigurationFileException if a legal configuration file with the primary key could not be found
	 */
	@Override
	public LegalConfigurationFile remove(Serializable primaryKey)
		throws NoSuchLegalConfigurationFileException {

		Session session = null;

		try {
			session = openSession();

			LegalConfigurationFile legalConfigurationFile =
				(LegalConfigurationFile)session.get(
					LegalConfigurationFileImpl.class, primaryKey);

			if (legalConfigurationFile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalConfigurationFileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalConfigurationFile);
		}
		catch (NoSuchLegalConfigurationFileException noSuchEntityException) {
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
	protected LegalConfigurationFile removeImpl(
		LegalConfigurationFile legalConfigurationFile) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalConfigurationFile)) {
				legalConfigurationFile = (LegalConfigurationFile)session.get(
					LegalConfigurationFileImpl.class,
					legalConfigurationFile.getPrimaryKeyObj());
			}

			if (legalConfigurationFile != null) {
				session.delete(legalConfigurationFile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalConfigurationFile != null) {
			clearCache(legalConfigurationFile);
		}

		return legalConfigurationFile;
	}

	@Override
	public LegalConfigurationFile updateImpl(
		LegalConfigurationFile legalConfigurationFile) {

		boolean isNew = legalConfigurationFile.isNew();

		if (!(legalConfigurationFile instanceof
				LegalConfigurationFileModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalConfigurationFile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					legalConfigurationFile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalConfigurationFile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalConfigurationFile implementation " +
					legalConfigurationFile.getClass());
		}

		LegalConfigurationFileModelImpl legalConfigurationFileModelImpl =
			(LegalConfigurationFileModelImpl)legalConfigurationFile;

		Session session = null;

		try {
			session = openSession();

			if (legalConfigurationFile.isNew()) {
				session.save(legalConfigurationFile);

				legalConfigurationFile.setNew(false);
			}
			else {
				legalConfigurationFile = (LegalConfigurationFile)session.merge(
					legalConfigurationFile);
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
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, LegalConfigurationFileImpl.class,
			legalConfigurationFile.getPrimaryKey(), legalConfigurationFile,
			false);

		clearUniqueFindersCache(legalConfigurationFileModelImpl, false);
		cacheUniqueFindersCache(legalConfigurationFileModelImpl);

		legalConfigurationFile.resetOriginalValues();

		return legalConfigurationFile;
	}

	/**
	 * Returns the legal configuration file with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal configuration file
	 * @return the legal configuration file
	 * @throws NoSuchLegalConfigurationFileException if a legal configuration file with the primary key could not be found
	 */
	@Override
	public LegalConfigurationFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalConfigurationFileException {

		LegalConfigurationFile legalConfigurationFile = fetchByPrimaryKey(
			primaryKey);

		if (legalConfigurationFile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalConfigurationFileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalConfigurationFile;
	}

	/**
	 * Returns the legal configuration file with the primary key or throws a <code>NoSuchLegalConfigurationFileException</code> if it could not be found.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file
	 * @throws NoSuchLegalConfigurationFileException if a legal configuration file with the primary key could not be found
	 */
	@Override
	public LegalConfigurationFile findByPrimaryKey(String keyId)
		throws NoSuchLegalConfigurationFileException {

		return findByPrimaryKey((Serializable)keyId);
	}

	/**
	 * Returns the legal configuration file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file, or <code>null</code> if a legal configuration file with the primary key could not be found
	 */
	@Override
	public LegalConfigurationFile fetchByPrimaryKey(String keyId) {
		return fetchByPrimaryKey((Serializable)keyId);
	}

	/**
	 * Returns all the legal configuration files.
	 *
	 * @return the legal configuration files
	 */
	@Override
	public List<LegalConfigurationFile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal configuration files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalConfigurationFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal configuration files
	 * @param end the upper bound of the range of legal configuration files (not inclusive)
	 * @return the range of legal configuration files
	 */
	@Override
	public List<LegalConfigurationFile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal configuration files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalConfigurationFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal configuration files
	 * @param end the upper bound of the range of legal configuration files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal configuration files
	 */
	@Override
	public List<LegalConfigurationFile> findAll(
		int start, int end,
		OrderByComparator<LegalConfigurationFile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal configuration files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalConfigurationFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal configuration files
	 * @param end the upper bound of the range of legal configuration files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal configuration files
	 */
	@Override
	public List<LegalConfigurationFile> findAll(
		int start, int end,
		OrderByComparator<LegalConfigurationFile> orderByComparator,
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

		List<LegalConfigurationFile> list = null;

		if (useFinderCache) {
			list = (List<LegalConfigurationFile>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALCONFIGURATIONFILE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALCONFIGURATIONFILE;

				sql = sql.concat(LegalConfigurationFileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalConfigurationFile>)QueryUtil.list(
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
	 * Removes all the legal configuration files from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalConfigurationFile legalConfigurationFile : findAll()) {
			remove(legalConfigurationFile);
		}
	}

	/**
	 * Returns the number of legal configuration files.
	 *
	 * @return the number of legal configuration files
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
					_SQL_COUNT_LEGALCONFIGURATIONFILE);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "keyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALCONFIGURATIONFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalConfigurationFileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal configuration file persistence.
	 */
	@Activate
	public void activate() {
		LegalConfigurationFileModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		LegalConfigurationFileModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalConfigurationFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalConfigurationFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalConfigurationFileImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByKey", new String[] {String.class.getName()},
			LegalConfigurationFileModelImpl.KEYID_COLUMN_BITMASK);

		_finderPathCountByKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalConfigurationFileImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalConfigurationFile"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_LEGALCONFIGURATIONFILE =
		"SELECT legalConfigurationFile FROM LegalConfigurationFile legalConfigurationFile";

	private static final String _SQL_SELECT_LEGALCONFIGURATIONFILE_WHERE =
		"SELECT legalConfigurationFile FROM LegalConfigurationFile legalConfigurationFile WHERE ";

	private static final String _SQL_COUNT_LEGALCONFIGURATIONFILE =
		"SELECT COUNT(legalConfigurationFile) FROM LegalConfigurationFile legalConfigurationFile";

	private static final String _SQL_COUNT_LEGALCONFIGURATIONFILE_WHERE =
		"SELECT COUNT(legalConfigurationFile) FROM LegalConfigurationFile legalConfigurationFile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"legalConfigurationFile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalConfigurationFile exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalConfigurationFile exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalConfigurationFilePersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}