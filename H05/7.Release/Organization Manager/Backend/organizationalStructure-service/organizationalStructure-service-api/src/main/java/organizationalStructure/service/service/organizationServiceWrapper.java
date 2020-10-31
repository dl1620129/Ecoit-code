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

package organizationalStructure.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link organizationService}.
 *
 * @author Brian Wing Shun Chan
 * @see organizationService
 * @generated
 */
public class organizationServiceWrapper
	implements organizationService, ServiceWrapper<organizationService> {

	public organizationServiceWrapper(organizationService organizationService) {
		_organizationService = organizationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _organizationService.getOSGiServiceIdentifier();
	}

	@Override
	public organizationService getWrappedService() {
		return _organizationService;
	}

	@Override
	public void setWrappedService(organizationService organizationService) {
		_organizationService = organizationService;
	}

	private organizationService _organizationService;

}