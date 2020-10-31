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

package organizationalStructure.service.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import organizationalStructure.service.model.UserOrganization;
import organizationalStructure.service.service.base.UserOrganizationLocalServiceBaseImpl;
import organizationalStructure.service.service.persistence.UserOrganizationPK;

/**
 * The implementation of the user organization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>organizationalStructure.service.service.UserOrganizationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOrganizationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=organizationalStructure.service.model.UserOrganization",
	service = AopService.class
)
public class UserOrganizationLocalServiceImpl
	extends UserOrganizationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>organizationalStructure.service.service.UserOrganizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>organizationalStructure.service.service.UserOrganizationLocalServiceUtil</code>.
	 */
	public void createUserOrganization(long userId, long organizationId) {
		UserOrganization userOrg = userOrganizationPersistence.create(new UserOrganizationPK(userId, organizationId));
		userOrganizationPersistence.update(userOrg);
	}
	
	public List<UserOrganization> getByUser(long userId) {
		List<UserOrganization> organizationsList = new ArrayList<UserOrganization>();
		try {
			organizationsList = userOrganizationPersistence.findByUser(userId);
		} catch (Exception e) {
			
		}
		return organizationsList;
	}
	
	public List<UserOrganization> getByOrganization(long organizationId) {
		List<UserOrganization> organizationsList = new ArrayList<UserOrganization>();
		try {
			organizationsList = userOrganizationPersistence.findByOrganization(organizationId);
		} catch (Exception e) {
			
		}
		return organizationsList;
	}
	
	public void deleteByUserId(long userId) {
		userOrganizationPersistence.removeByUser(userId);
	}
}