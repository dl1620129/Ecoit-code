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

import com.ecoit.lichcongtac.services.model.UserGroupRel;
import com.ecoit.lichcongtac.services.service.UserGroupRelService;
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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the user group rel remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ecoit.lichcongtac.services.service.impl.UserGroupRelServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ecoit.lichcongtac.services.service.impl.UserGroupRelServiceImpl
 * @generated
 */
public abstract class UserGroupRelServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, UserGroupRelService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>UserGroupRelService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.lichcongtac.services.service.UserGroupRelServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			UserGroupRelService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		userGroupRelService = (UserGroupRelService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return UserGroupRelService.class.getName();
	}

	protected Class<?> getModelClass() {
		return UserGroupRel.class;
	}

	protected String getModelClassName() {
		return UserGroupRel.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = userGroupRelPersistence.getDataSource();

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

	@Reference
	protected LichCongTacPersistence lichCongTacPersistence;

	@Reference
	protected PermissionGroupRelPersistence permissionGroupRelPersistence;

	@Reference
	protected com.ecoit.lichcongtac.services.service.UserGroupRelLocalService
		userGroupRelLocalService;

	protected UserGroupRelService userGroupRelService;

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
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}