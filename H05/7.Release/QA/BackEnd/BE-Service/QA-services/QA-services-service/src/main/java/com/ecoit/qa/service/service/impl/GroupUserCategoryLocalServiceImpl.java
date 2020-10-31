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

package com.ecoit.qa.service.service.impl;

import com.ecoit.qa.service.model.GroupUserCategory;
import com.ecoit.qa.service.service.base.GroupUserCategoryLocalServiceBaseImpl;
import com.ecoit.qa.service.service.persistence.GroupUserCategoryPK;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the group user category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.qa.service.service.GroupUserCategoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserCategoryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.qa.service.model.GroupUserCategory",
	service = AopService.class
)
public class GroupUserCategoryLocalServiceImpl
	extends GroupUserCategoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.qa.service.service.GroupUserCategoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.qa.service.service.GroupUserCategoryLocalServiceUtil</code>.
	 */
	
	public void removeByGroupUserId(long groupUserId) {
		try {
			this.groupUserCategoryPersistence.removeByGroupUser(groupUserId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeByCategoryId(long categoryId) {
		try {
			this.groupUserCategoryPersistence.removeByCategory(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createGroupUserCategory(long groupUserId, long categoryId) throws Exception  {
		GroupUserCategoryPK primaryKey = new GroupUserCategoryPK(groupUserId, categoryId);
		GroupUserCategory groupUserCategory = groupUserCategoryPersistence.create(primaryKey);
		groupUserCategoryPersistence.update(groupUserCategory);
	}
	
	public boolean hasCategory(long groupUserId, long categoryId) {
		try {
			GroupUserCategory relation = groupUserCategoryPersistence.fetchByPrimaryKey(new GroupUserCategoryPK(groupUserId, categoryId));
			if (relation == null) return false;
			else return true;
		} catch (Exception ex) {
			return false;
		}
	}
}