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

package User.Rank.Poisition.Service.service.impl;

import User.Rank.Poisition.Service.service.base.UserPoisition_DangServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the user poisition_ dang remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>User.Rank.Poisition.Service.service.UserPoisition_DangService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisition_DangServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=portal_user",
		"json.web.service.context.path=UserPoisition_Dang"
	},
	service = AopService.class
)
public class UserPoisition_DangServiceImpl
	extends UserPoisition_DangServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>User.Rank.Poisition.Service.service.UserPoisition_DangServiceUtil</code> to access the user poisition_ dang remote service.
	 */
}