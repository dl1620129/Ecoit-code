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

package User.Rank.Poisition.Service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link UserPoisitionService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisitionService
 * @generated
 */
@ProviderType
public class UserPoisitionServiceWrapper
	implements UserPoisitionService, ServiceWrapper<UserPoisitionService> {

	public UserPoisitionServiceWrapper(
		UserPoisitionService userPoisitionService) {

		_userPoisitionService = userPoisitionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userPoisitionService.getOSGiServiceIdentifier();
	}

	@Override
	public UserPoisitionService getWrappedService() {
		return _userPoisitionService;
	}

	@Override
	public void setWrappedService(UserPoisitionService userPoisitionService) {
		_userPoisitionService = userPoisitionService;
	}

	private UserPoisitionService _userPoisitionService;

}