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

package LinkManager.Service.service.persistence.impl;

import LinkManager.Service.exception.NoSuchGroupLinkException;
import LinkManager.Service.model.GroupLink;
import LinkManager.Service.model.impl.GroupLinkImpl;
import LinkManager.Service.model.impl.GroupLinkModelImpl;
import LinkManager.Service.service.persistence.GroupLinkPersistence;
import LinkManager.Service.service.persistence.impl.constants.portalPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the group link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GroupLinkPersistence.class)
@ProviderType
public class GroupLinkPersistenceImpl
	extends BasePersistenceImpl<GroupLink> implements GroupLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GroupLinkUtil</code> to access the group link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GroupLinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public GroupLinkPersistenceImpl() {
		setModelClass(GroupLink.class);

		setModelImplClass(GroupLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the group link in the entity cache if it is enabled.
	 *
	 * @param groupLink the group link
	 */
	@Override
	public void cacheResult(GroupLink groupLink) {
		entityCache.putResult(
			entityCacheEnabled, GroupLinkImpl.class, groupLink.getPrimaryKey(),
			groupLink);

		groupLink.resetOriginalValues();
	}

	/**
	 * Caches the group links in the entity cache if it is enabled.
	 *
	 * @param groupLinks the group links
	 */
	@Override
	public void cacheResult(List<GroupLink> groupLinks) {
		for (GroupLink groupLink : groupLinks) {
			if (entityCache.getResult(
					entityCacheEnabled, GroupLinkImpl.class,
					groupLink.getPrimaryKey()) == null) {

				cacheResult(groupLink);
			}
			else {
				groupLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all group links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GroupLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the group link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GroupLink groupLink) {
		entityCache.removeResult(
			entityCacheEnabled, GroupLinkImpl.class, groupLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GroupLink> groupLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GroupLink groupLink : groupLinks) {
			entityCache.removeResult(
				entityCacheEnabled, GroupLinkImpl.class,
				groupLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new group link with the primary key. Does not add the group link to the database.
	 *
	 * @param linksgroupid the primary key for the new group link
	 * @return the new group link
	 */
	@Override
	public GroupLink create(long linksgroupid) {
		GroupLink groupLink = new GroupLinkImpl();

		groupLink.setNew(true);
		groupLink.setPrimaryKey(linksgroupid);

		return groupLink;
	}

	/**
	 * Removes the group link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linksgroupid the primary key of the group link
	 * @return the group link that was removed
	 * @throws NoSuchGroupLinkException if a group link with the primary key could not be found
	 */
	@Override
	public GroupLink remove(long linksgroupid) throws NoSuchGroupLinkException {
		return remove((Serializable)linksgroupid);
	}

	/**
	 * Removes the group link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the group link
	 * @return the group link that was removed
	 * @throws NoSuchGroupLinkException if a group link with the primary key could not be found
	 */
	@Override
	public GroupLink remove(Serializable primaryKey)
		throws NoSuchGroupLinkException {

		Session session = null;

		try {
			session = openSession();

			GroupLink groupLink = (GroupLink)session.get(
				GroupLinkImpl.class, primaryKey);

			if (groupLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGroupLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(groupLink);
		}
		catch (NoSuchGroupLinkException nsee) {
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
	protected GroupLink removeImpl(GroupLink groupLink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(groupLink)) {
				groupLink = (GroupLink)session.get(
					GroupLinkImpl.class, groupLink.getPrimaryKeyObj());
			}

			if (groupLink != null) {
				session.delete(groupLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (groupLink != null) {
			clearCache(groupLink);
		}

		return groupLink;
	}

	@Override
	public GroupLink updateImpl(GroupLink groupLink) {
		boolean isNew = groupLink.isNew();

		Session session = null;

		try {
			session = openSession();

			if (groupLink.isNew()) {
				session.save(groupLink);

				groupLink.setNew(false);
			}
			else {
				groupLink = (GroupLink)session.merge(groupLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, GroupLinkImpl.class, groupLink.getPrimaryKey(),
			groupLink, false);

		groupLink.resetOriginalValues();

		return groupLink;
	}

	/**
	 * Returns the group link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the group link
	 * @return the group link
	 * @throws NoSuchGroupLinkException if a group link with the primary key could not be found
	 */
	@Override
	public GroupLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGroupLinkException {

		GroupLink groupLink = fetchByPrimaryKey(primaryKey);

		if (groupLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGroupLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return groupLink;
	}

	/**
	 * Returns the group link with the primary key or throws a <code>NoSuchGroupLinkException</code> if it could not be found.
	 *
	 * @param linksgroupid the primary key of the group link
	 * @return the group link
	 * @throws NoSuchGroupLinkException if a group link with the primary key could not be found
	 */
	@Override
	public GroupLink findByPrimaryKey(long linksgroupid)
		throws NoSuchGroupLinkException {

		return findByPrimaryKey((Serializable)linksgroupid);
	}

	/**
	 * Returns the group link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linksgroupid the primary key of the group link
	 * @return the group link, or <code>null</code> if a group link with the primary key could not be found
	 */
	@Override
	public GroupLink fetchByPrimaryKey(long linksgroupid) {
		return fetchByPrimaryKey((Serializable)linksgroupid);
	}

	/**
	 * Returns all the group links.
	 *
	 * @return the group links
	 */
	@Override
	public List<GroupLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of group links
	 * @param end the upper bound of the range of group links (not inclusive)
	 * @return the range of group links
	 */
	@Override
	public List<GroupLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the group links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of group links
	 * @param end the upper bound of the range of group links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group links
	 */
	@Deprecated
	@Override
	public List<GroupLink> findAll(
		int start, int end, OrderByComparator<GroupLink> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of group links
	 * @param end the upper bound of the range of group links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group links
	 */
	@Override
	public List<GroupLink> findAll(
		int start, int end, OrderByComparator<GroupLink> orderByComparator) {

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

		List<GroupLink> list = (List<GroupLink>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GROUPLINK);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GROUPLINK;

				if (pagination) {
					sql = sql.concat(GroupLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GroupLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GroupLink>)QueryUtil.list(
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
	 * Removes all the group links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GroupLink groupLink : findAll()) {
			remove(groupLink);
		}
	}

	/**
	 * Returns the number of group links.
	 *
	 * @return the number of group links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GROUPLINK);

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
		return "linksgroupid";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GROUPLINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GroupLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the group link persistence.
	 */
	@Activate
	public void activate() {
		GroupLinkModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GroupLinkModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GroupLinkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = portalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.LinkManager.Service.model.GroupLink"),
			true);
	}

	@Override
	@Reference(
		target = portalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = portalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_GROUPLINK =
		"SELECT groupLink FROM GroupLink groupLink";

	private static final String _SQL_COUNT_GROUPLINK =
		"SELECT COUNT(groupLink) FROM GroupLink groupLink";

	private static final String _ORDER_BY_ENTITY_ALIAS = "groupLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GroupLink exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		GroupLinkPersistenceImpl.class);

	static {
		try {
			Class.forName(portalPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}