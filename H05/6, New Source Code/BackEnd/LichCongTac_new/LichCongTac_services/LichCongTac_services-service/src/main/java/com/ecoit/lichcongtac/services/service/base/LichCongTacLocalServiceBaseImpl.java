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

package com.ecoit.lichcongtac.services.service.base;

import com.ecoit.lichcongtac.services.model.LichCongTac;
import com.ecoit.lichcongtac.services.service.LichCongTacLocalService;
import com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPersistence;
import com.ecoit.lichcongtac.services.service.persistence.LichChiTietPersistence;
import com.ecoit.lichcongtac.services.service.persistence.LichCongTacPersistence;
import com.ecoit.lichcongtac.services.service.persistence.PermissionGroupRelPersistence;
import com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPersistence;
import com.ecoit.lichcongtac.services.service.persistence.UserPermissionGroupPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the lich cong tac local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ecoit.lichcongtac.services.service.impl.LichCongTacLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ecoit.lichcongtac.services.service.impl.LichCongTacLocalServiceImpl
 * @generated
 */
public abstract class LichCongTacLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, LichCongTacLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>LichCongTacLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.lichcongtac.services.service.LichCongTacLocalServiceUtil</code>.
	 */

	/**
	 * Adds the lich cong tac to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTac the lich cong tac
	 * @return the lich cong tac that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LichCongTac addLichCongTac(LichCongTac lichCongTac) {
		lichCongTac.setNew(true);

		return lichCongTacPersistence.update(lichCongTac);
	}

	/**
	 * Creates a new lich cong tac with the primary key. Does not add the lich cong tac to the database.
	 *
	 * @param lichCongTacId the primary key for the new lich cong tac
	 * @return the new lich cong tac
	 */
	@Override
	@Transactional(enabled = false)
	public LichCongTac createLichCongTac(long lichCongTacId) {
		return lichCongTacPersistence.create(lichCongTacId);
	}

	/**
	 * Deletes the lich cong tac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac that was removed
	 * @throws PortalException if a lich cong tac with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LichCongTac deleteLichCongTac(long lichCongTacId)
		throws PortalException {

		return lichCongTacPersistence.remove(lichCongTacId);
	}

	/**
	 * Deletes the lich cong tac from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTac the lich cong tac
	 * @return the lich cong tac that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LichCongTac deleteLichCongTac(LichCongTac lichCongTac) {
		return lichCongTacPersistence.remove(lichCongTac);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			LichCongTac.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return lichCongTacPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return lichCongTacPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return lichCongTacPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return lichCongTacPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return lichCongTacPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public LichCongTac fetchLichCongTac(long lichCongTacId) {
		return lichCongTacPersistence.fetchByPrimaryKey(lichCongTacId);
	}

	/**
	 * Returns the lich cong tac with the primary key.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac
	 * @throws PortalException if a lich cong tac with the primary key could not be found
	 */
	@Override
	public LichCongTac getLichCongTac(long lichCongTacId)
		throws PortalException {

		return lichCongTacPersistence.findByPrimaryKey(lichCongTacId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(lichCongTacLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(LichCongTac.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("lichCongTacId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			lichCongTacLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(LichCongTac.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"lichCongTacId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(lichCongTacLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(LichCongTac.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("lichCongTacId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return lichCongTacLocalService.deleteLichCongTac(
			(LichCongTac)persistedModel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return lichCongTacPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the lich cong tacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @return the range of lich cong tacs
	 */
	@Override
	public List<LichCongTac> getLichCongTacs(int start, int end) {
		return lichCongTacPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of lich cong tacs.
	 *
	 * @return the number of lich cong tacs
	 */
	@Override
	public int getLichCongTacsCount() {
		return lichCongTacPersistence.countAll();
	}

	/**
	 * Updates the lich cong tac in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTac the lich cong tac
	 * @return the lich cong tac that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LichCongTac updateLichCongTac(LichCongTac lichCongTac) {
		return lichCongTacPersistence.update(lichCongTac);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			LichCongTacLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		lichCongTacLocalService = (LichCongTacLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return LichCongTacLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return LichCongTac.class;
	}

	protected String getModelClassName() {
		return LichCongTac.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = lichCongTacPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected ColumnGroupRelPersistence columnGroupRelPersistence;

	@Reference
	protected LichChiTietPersistence lichChiTietPersistence;

	protected LichCongTacLocalService lichCongTacLocalService;

	@Reference
	protected LichCongTacPersistence lichCongTacPersistence;

	@Reference
	protected PermissionGroupRelPersistence permissionGroupRelPersistence;

	@Reference
	protected UserGroupRelPersistence userGroupRelPersistence;

	@Reference
	protected UserPermissionGroupPersistence userPermissionGroupPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}