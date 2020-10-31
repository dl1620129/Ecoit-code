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

import com.ecoit.lichcongtac.services.model.ColumnGroupRel;
import com.ecoit.lichcongtac.services.service.base.ColumnGroupRelLocalServiceBaseImpl;
import com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the column group rel local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.lichcongtac.services.service.ColumnGroupRelLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ColumnGroupRelLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.lichcongtac.services.model.ColumnGroupRel",
	service = AopService.class
)
public class ColumnGroupRelLocalServiceImpl
	extends ColumnGroupRelLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.lichcongtac.services.service.ColumnGroupRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.lichcongtac.services.service.ColumnGroupRelLocalServiceUtil</code>.
	 */
	
	public List<ColumnGroupRel> getByGroupId(long groupId) {
		return columnGroupRelPersistence.findByGroup(groupId);
	}
	
	public boolean checkPermission(long userGroupId, int columnId) {
		try {
			ColumnGroupRel relation = this.columnGroupRelPersistence.findByPrimaryKey(new ColumnGroupRelPK(userGroupId, columnId));
			if (relation == null) return false;
			else return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public void createColumnGroupRel(long userGroupId, int columnId) {
		ColumnGroupRelPK primaryKey = new ColumnGroupRelPK(userGroupId, columnId);
		ColumnGroupRel columnPermissionRel = columnGroupRelPersistence.create(primaryKey);
		columnGroupRelPersistence.update(columnPermissionRel);
	}
}