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
 * Provides a wrapper for {@link EcmsPGRelationService}.
 *
 * @author Liverpool
 * @see EcmsPGRelationService
 * @generated
 */
public class EcmsPGRelationServiceWrapper
	implements EcmsPGRelationService, ServiceWrapper<EcmsPGRelationService> {

	public EcmsPGRelationServiceWrapper(
		EcmsPGRelationService ecmsPGRelationService) {

		_ecmsPGRelationService = ecmsPGRelationService;
	}

	@Override
	public com.ecoit.elegaldocument.model.EcmsPGRelation addPermission(
			long groupId, int permission)
		throws Exception {

		return _ecmsPGRelationService.addPermission(groupId, permission);
	}

	@Override
	public boolean checkPermission(long groupId, int permission) {
		return _ecmsPGRelationService.checkPermission(groupId, permission);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.EcmsPGRelation>
			findByGroupUserId(long groupUserId)
		throws Exception {

		return _ecmsPGRelationService.findByGroupUserId(groupUserId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.EcmsPGRelation>
			findByPermission(int permission)
		throws Exception {

		return _ecmsPGRelationService.findByPermission(permission);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ecmsPGRelationService.getOSGiServiceIdentifier();
	}

	@Override
	public void removeByGroupId(long groupId) throws Exception {
		_ecmsPGRelationService.removeByGroupId(groupId);
	}

	@Override
	public void removeByPermission(int permissionId) throws Exception {
		_ecmsPGRelationService.removeByPermission(permissionId);
	}

	@Override
	public EcmsPGRelationService getWrappedService() {
		return _ecmsPGRelationService;
	}

	@Override
	public void setWrappedService(EcmsPGRelationService ecmsPGRelationService) {
		_ecmsPGRelationService = ecmsPGRelationService;
	}

	private EcmsPGRelationService _ecmsPGRelationService;

}