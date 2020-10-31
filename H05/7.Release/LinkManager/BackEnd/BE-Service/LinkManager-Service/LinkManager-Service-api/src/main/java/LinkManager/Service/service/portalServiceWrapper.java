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

package LinkManager.Service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link portalService}.
 *
 * @author Brian Wing Shun Chan
 * @see portalService
 * @generated
 */
@ProviderType
public class portalServiceWrapper
	implements portalService, ServiceWrapper<portalService> {

	public portalServiceWrapper(portalService portalService) {
		_portalService = portalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _portalService.getOSGiServiceIdentifier();
	}

	@Override
	public portalService getWrappedService() {
		return _portalService;
	}

	@Override
	public void setWrappedService(portalService portalService) {
		_portalService = portalService;
	}

	private portalService _portalService;

}