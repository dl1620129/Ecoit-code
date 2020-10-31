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
 * Provides a wrapper for {@link LegalDURelService}.
 *
 * @author Liverpool
 * @see LegalDURelService
 * @generated
 */
public class LegalDURelServiceWrapper
	implements LegalDURelService, ServiceWrapper<LegalDURelService> {

	public LegalDURelServiceWrapper(LegalDURelService legalDURelService) {
		_legalDURelService = legalDURelService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalDURelService.getOSGiServiceIdentifier();
	}

	@Override
	public LegalDURelService getWrappedService() {
		return _legalDURelService;
	}

	@Override
	public void setWrappedService(LegalDURelService legalDURelService) {
		_legalDURelService = legalDURelService;
	}

	private LegalDURelService _legalDURelService;

}