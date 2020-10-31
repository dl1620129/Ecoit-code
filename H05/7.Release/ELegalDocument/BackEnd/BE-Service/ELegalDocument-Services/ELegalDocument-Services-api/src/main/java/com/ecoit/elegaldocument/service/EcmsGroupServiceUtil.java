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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for EcmsGroup. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.EcmsGroupServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Liverpool
 * @see EcmsGroupService
 * @generated
 */
public class EcmsGroupServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.EcmsGroupServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ecoit.elegaldocument.model.EcmsGroup addGroup(
			String groupName, String groupDesciption, long groupId)
		throws Exception {

		return getService().addGroup(groupName, groupDesciption, groupId);
	}

	public static void deleteGroup(long groupId) throws Exception {
		getService().deleteGroup(groupId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.EcmsGroup>
			findAll()
		throws Exception {

		return getService().findAll();
	}

	public static com.ecoit.elegaldocument.model.EcmsGroup findByPrimaryKey(
			long groupId)
		throws Exception {

		return getService().findByPrimaryKey(groupId);
	}

	public static long findUserInGroup(long userId) {
		return getService().findUserInGroup(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void updateGroup(
			com.ecoit.elegaldocument.model.EcmsGroup group)
		throws Exception {

		getService().updateGroup(group);
	}

	public static com.ecoit.elegaldocument.model.EcmsGroup updateGroup(
			long groupId, String groupName, String groupDesciption)
		throws Exception {

		return getService().updateGroup(groupId, groupName, groupDesciption);
	}

	public static EcmsGroupService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EcmsGroupService, EcmsGroupService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EcmsGroupService.class);

		ServiceTracker<EcmsGroupService, EcmsGroupService> serviceTracker =
			new ServiceTracker<EcmsGroupService, EcmsGroupService>(
				bundle.getBundleContext(), EcmsGroupService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}