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

package com.ecoit.cms.config.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PortletConfigService}.
 *
 * @author Brian Wing Shun Chan
 * @see PortletConfigService
 * @generated
 */
public class PortletConfigServiceWrapper
	implements PortletConfigService, ServiceWrapper<PortletConfigService> {

	public PortletConfigServiceWrapper(
		PortletConfigService portletConfigService) {

		_portletConfigService = portletConfigService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _portletConfigService.getOSGiServiceIdentifier();
	}

	@Override
	public PortletConfigService getWrappedService() {
		return _portletConfigService;
	}

	@Override
	public void setWrappedService(PortletConfigService portletConfigService) {
		_portletConfigService = portletConfigService;
	}

	private PortletConfigService _portletConfigService;

}