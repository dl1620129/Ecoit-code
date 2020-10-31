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
 * Provides a wrapper for {@link EcmsGURelationService}.
 *
 * @author Liverpool
 * @see EcmsGURelationService
 * @generated
 */
public class EcmsGURelationServiceWrapper
	implements EcmsGURelationService, ServiceWrapper<EcmsGURelationService> {

	public EcmsGURelationServiceWrapper(
		EcmsGURelationService ecmsGURelationService) {

		_ecmsGURelationService = ecmsGURelationService;
	}

	@Override
	public com.ecoit.elegaldocument.model.EcmsGURelation addGURelation(
			long groupUserId, long userId)
		throws Exception {

		return _ecmsGURelationService.addGURelation(groupUserId, userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ecmsGURelationService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean isContain(long groupId, long userId) {
		return _ecmsGURelationService.isContain(groupId, userId);
	}

	@Override
	public void removeByGroup(long groupId) throws Exception {
		_ecmsGURelationService.removeByGroup(groupId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.EcmsGURelation>
			searchByGroupUser(long groupUserId)
		throws Exception {

		return _ecmsGURelationService.searchByGroupUser(groupUserId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.EcmsGURelation>
			searchByUserId(long userId)
		throws Exception {

		return _ecmsGURelationService.searchByUserId(userId);
	}

	@Override
	public EcmsGURelationService getWrappedService() {
		return _ecmsGURelationService;
	}

	@Override
	public void setWrappedService(EcmsGURelationService ecmsGURelationService) {
		_ecmsGURelationService = ecmsGURelationService;
	}

	private EcmsGURelationService _ecmsGURelationService;

}