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

package com.software.cms.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.software.cms.model.GroupUser;
import com.software.cms.model.impl.GroupUserImpl;
import com.software.cms.service.base.GroupUserLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the group user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.software.cms.service.GroupUserLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see GroupUserLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.software.cms.model.GroupUser",
	service = AopService.class
)
public class GroupUserLocalServiceImpl extends GroupUserLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.software.cms.service.GroupUserLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.software.cms.service.GroupUserLocalServiceUtil</code>.
	 */
	public GroupUser addGroupUser(String name,String description, ServiceContext serviceContext) {
		long groupId = serviceContext.getScopeGroupId();
		String languageId = serviceContext.getLanguageId();
		long groupUserId = counterLocalService.increment();
		GroupUser groupUser = groupUserPersistence.create(groupUserId);
		groupUser.setName(name);
		groupUser.setGroupId(groupId);
		groupUser.setLanguage(languageId);
		groupUser.setDescription(description);
		groupUser.setExpandoBridgeAttributes(serviceContext);
		groupUser = groupUserPersistence.update(groupUser);
		return groupUser;
		
	}
	public List<GroupUser> findByGroup_Language(long groupId, String language) {
		List<GroupUser> groups = new ArrayList<GroupUser>();
		try {
			groups.addAll(this.groupUserPersistence.findByGroup_Language(groupId, language));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return groups;
	}
	
	public GroupUser create(){
		return new GroupUserImpl();
	}
}