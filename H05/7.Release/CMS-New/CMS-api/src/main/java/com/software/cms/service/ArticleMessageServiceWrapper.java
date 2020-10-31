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

package com.software.cms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ArticleMessageService}.
 *
 * @author DungNV
 * @see ArticleMessageService
 * @generated
 */
public class ArticleMessageServiceWrapper
	implements ArticleMessageService, ServiceWrapper<ArticleMessageService> {

	public ArticleMessageServiceWrapper(
		ArticleMessageService articleMessageService) {

		_articleMessageService = articleMessageService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _articleMessageService.getOSGiServiceIdentifier();
	}

	@Override
	public ArticleMessageService getWrappedService() {
		return _articleMessageService;
	}

	@Override
	public void setWrappedService(ArticleMessageService articleMessageService) {
		_articleMessageService = articleMessageService;
	}

	private ArticleMessageService _articleMessageService;

}