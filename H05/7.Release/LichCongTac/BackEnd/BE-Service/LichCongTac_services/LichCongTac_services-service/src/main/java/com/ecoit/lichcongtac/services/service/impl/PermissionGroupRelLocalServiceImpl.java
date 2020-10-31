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

package com.ecoit.lichcongtac.services.service.impl;

import com.ecoit.lichcongtac.services.model.PermissionGroupRel;
import com.ecoit.lichcongtac.services.service.base.PermissionGroupRelLocalServiceBaseImpl;
import com.ecoit.lichcongtac.services.service.persistence.PermissionGroupRelPK;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the permission group rel local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.lichcongtac.services.service.PermissionGroupRelLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermissionGroupRelLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.lichcongtac.services.model.PermissionGroupRel",
	service = AopService.class
)
public class PermissionGroupRelLocalServiceImpl
	extends PermissionGroupRelLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.lichcongtac.services.service.PermissionGroupRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.lichcongtac.services.service.PermissionGroupRelLocalServiceUtil</code>.
	 */


	public List<PermissionGroupRel> getByGroupId(long userGroupId) {
		return permissionGroupRelPersistence.findByGroup(userGroupId);
	}
	
	public boolean checkPermission(long userGroupId, int permission) {
		try {
			PermissionGroupRel relation = this.permissionGroupRelPersistence.findByPrimaryKey(new PermissionGroupRelPK(userGroupId, permission));
			if (relation == null) return false;
			else return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public void createPermissionGroupRel(long userGroupId, int permission) {
		PermissionGroupRelPK primaryKey = new PermissionGroupRelPK(userGroupId, permission);
		PermissionGroupRel groupPermissionRel = permissionGroupRelPersistence.create(primaryKey);
		permissionGroupRelPersistence.update(groupPermissionRel);
	}
}