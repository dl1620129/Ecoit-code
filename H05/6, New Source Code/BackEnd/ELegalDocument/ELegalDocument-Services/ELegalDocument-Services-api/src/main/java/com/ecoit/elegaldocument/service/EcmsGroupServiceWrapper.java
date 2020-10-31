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
 * Provides a wrapper for {@link EcmsGroupService}.
 *
 * @author Liverpool
 * @see EcmsGroupService
 * @generated
 */
public class EcmsGroupServiceWrapper
	implements EcmsGroupService, ServiceWrapper<EcmsGroupService> {

	public EcmsGroupServiceWrapper(EcmsGroupService ecmsGroupService) {
		_ecmsGroupService = ecmsGroupService;
	}

	@Override
	public com.ecoit.elegaldocument.model.EcmsGroup addGroup(
			String groupName, String groupDesciption, long groupId)
		throws Exception {

		return _ecmsGroupService.addGroup(groupName, groupDesciption, groupId);
	}

	@Override
	public void deleteGroup(long groupId) throws Exception {
		_ecmsGroupService.deleteGroup(groupId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.EcmsGroup> findAll()
		throws Exception {

		return _ecmsGroupService.findAll();
	}

	@Override
	public com.ecoit.elegaldocument.model.EcmsGroup findByPrimaryKey(
			long groupId)
		throws Exception {

		return _ecmsGroupService.findByPrimaryKey(groupId);
	}

	@Override
	public long findUserInGroup(long userId) {
		return _ecmsGroupService.findUserInGroup(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ecmsGroupService.getOSGiServiceIdentifier();
	}

	@Override
	public void updateGroup(com.ecoit.elegaldocument.model.EcmsGroup group)
		throws Exception {

		_ecmsGroupService.updateGroup(group);
	}

	@Override
	public com.ecoit.elegaldocument.model.EcmsGroup updateGroup(
			long groupId, String groupName, String groupDesciption)
		throws Exception {

		return _ecmsGroupService.updateGroup(
			groupId, groupName, groupDesciption);
	}

	@Override
	public EcmsGroupService getWrappedService() {
		return _ecmsGroupService;
	}

	@Override
	public void setWrappedService(EcmsGroupService ecmsGroupService) {
		_ecmsGroupService = ecmsGroupService;
	}

	private EcmsGroupService _ecmsGroupService;

}