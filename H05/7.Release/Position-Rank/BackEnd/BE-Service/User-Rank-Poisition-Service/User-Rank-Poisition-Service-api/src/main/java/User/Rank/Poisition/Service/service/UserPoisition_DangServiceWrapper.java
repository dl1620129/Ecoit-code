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
 * Provides a wrapper for {@link UserPoisition_DangService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisition_DangService
 * @generated
 */
@ProviderType
public class UserPoisition_DangServiceWrapper
	implements UserPoisition_DangService,
			   ServiceWrapper<UserPoisition_DangService> {

	public UserPoisition_DangServiceWrapper(
		UserPoisition_DangService userPoisition_DangService) {

		_userPoisition_DangService = userPoisition_DangService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userPoisition_DangService.getOSGiServiceIdentifier();
	}

	@Override
	public UserPoisition_DangService getWrappedService() {
		return _userPoisition_DangService;
	}

	@Override
	public void setWrappedService(
		UserPoisition_DangService userPoisition_DangService) {

		_userPoisition_DangService = userPoisition_DangService;
	}

	private UserPoisition_DangService _userPoisition_DangService;

}