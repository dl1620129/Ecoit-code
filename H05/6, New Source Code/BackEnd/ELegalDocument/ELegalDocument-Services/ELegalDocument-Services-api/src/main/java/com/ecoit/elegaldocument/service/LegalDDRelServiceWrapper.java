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

package com.ecoit.elegaldocument.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LegalDDRelService}.
 *
 * @author Liverpool
 * @see LegalDDRelService
 * @generated
 */
public class LegalDDRelServiceWrapper
	implements LegalDDRelService, ServiceWrapper<LegalDDRelService> {

	public LegalDDRelServiceWrapper(LegalDDRelService legalDDRelService) {
		_legalDDRelService = legalDDRelService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalDDRelService.getOSGiServiceIdentifier();
	}

	@Override
	public LegalDDRelService getWrappedService() {
		return _legalDDRelService;
	}

	@Override
	public void setWrappedService(LegalDDRelService legalDDRelService) {
		_legalDDRelService = legalDDRelService;
	}

	private LegalDDRelService _legalDDRelService;

}