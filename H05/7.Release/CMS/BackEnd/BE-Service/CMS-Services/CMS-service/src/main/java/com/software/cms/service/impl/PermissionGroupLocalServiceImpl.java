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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.software.cms.model.GroupUser;
import com.software.cms.model.PermissionGroup;
import com.software.cms.model.impl.PermissionGroupImpl;
import com.software.cms.service.GroupCategoryLocalServiceUtil;
import com.software.cms.service.GroupUserLocalServiceUtil;
import com.software.cms.service.GroupUserUsersLocalServiceUtil;
import com.software.cms.service.PermissionGroupLocalServiceUtil;
import com.software.cms.service.base.PermissionGroupLocalServiceBaseImpl;
import com.software.cms.service.persistence.PermissionGroupPK;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the permission group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.software.cms.service.PermissionGroupLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see PermissionGroupLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.software.cms.model.PermissionGroup",
	service = AopService.class
)
public class PermissionGroupLocalServiceImpl
	extends PermissionGroupLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.software.cms.service.PermissionGroupLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.software.cms.service.PermissionGroupLocalServiceUtil</code>.
	 */
	public void addPermissionGroup(long groupId, long groupUserId, long permission) {
		PermissionGroupPK primKey = new PermissionGroupPK(permission, groupUserId);
		PermissionGroup permissionGroup = PermissionGroupLocalServiceUtil.createPermissionGroup(primKey);
		permissionGroup.setGroupId(groupId);
		try {
			this.permissionGroupLocalService.addPermissionGroup(permissionGroup);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateCreateGroupUser(long scopeGroupId,String locale, long groupUserId, String groupName,
			String description, String[] users, String permissions[], String categories[])throws Exception {
		GroupUser group = null;

			if (groupUserId <=0) {
				groupUserId = counterLocalService.increment();
				group = groupUserPersistence.create(groupUserId);
			}
			else {
				group = GroupUserLocalServiceUtil.getGroupUser(groupUserId);
				System.out.println("group: "+ group.getName());
			}
			group.setName(groupName);
			group.setDescription(description);
			group.setLanguage(locale);
			group.setGroupId(scopeGroupId);
			groupUserPersistence.update(group);
			// add user to group
			groupUserUsersPersistence.removeByGroup_GroupUser(scopeGroupId, group.getGroupUserId());
			for (String user : users) {
				GroupUserUsersLocalServiceUtil.addGroupUserUsers(scopeGroupId, group.getGroupUserId(), Long.parseLong(user));
			}
			// add permission to group
			permissionGroupPersistence.removeByGroup_GroupUser(scopeGroupId, group.getGroupUserId());
			for (String permission : permissions) {
				PermissionGroupLocalServiceUtil.addPermissionGroup(scopeGroupId, group.getGroupUserId(), Long.parseLong(permission));
			}
			// add category to group
			groupCategoryPersistence.removeByGroupUser(groupUserId);
			for (String category : categories) {
				GroupCategoryLocalServiceUtil.addGroupCategory(group.getGroupUserId(), Long.parseLong(category));
			}
		
	}

	/**
	 *
	 * @param groupId
	 * @param groupUserId
	 * @return
	 */
	public List<PermissionGroup> findByGroup_GroupUser(long groupId, long groupUserId) {
		List<PermissionGroup> result = new ArrayList<PermissionGroup>();
		try {
			result.addAll(this.permissionGroupPersistence.findByGroup_GroupUser(groupId, groupUserId));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public void removeByGroup_GroupUser(long groupId, long groupUserId) {
		try {
			this.permissionGroupPersistence.removeByGroup_GroupUser(groupId, groupUserId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasPermissionGroup(long permission, long groupUserId) {
		boolean result=false;
		Session session=null;
		try {
			session = this.permissionGroupPersistence.openSession();
			String sql = "select * from soft_cms_permissiongroup where permissionid = ? AND groupuserid=?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_cms_permissiongroup", PermissionGroupImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(permission);
			qPos.add(groupUserId);
			List<PermissionGroup> users = query.list();
			
			if (users != null && users.size()>0) result= true;
			
		} catch (Exception e) {
		}
        finally{
        	this.permissionGroupPersistence.closeSession(session);
        	//if(session!=null)	session.close();
        }
		
		return result;
	}
	public PermissionGroup create(){
		return new PermissionGroupImpl();
	}
}