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
 * Provides the remote service utility for EcmsPGRelation. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.EcmsPGRelationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Liverpool
 * @see EcmsPGRelationService
 * @generated
 */
public class EcmsPGRelationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.EcmsPGRelationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ecoit.elegaldocument.model.EcmsPGRelation addPermission(
			long groupId, int permission)
		throws Exception {

		return getService().addPermission(groupId, permission);
	}

	public static boolean checkPermission(long groupId, int permission) {
		return getService().checkPermission(groupId, permission);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.EcmsPGRelation>
			findByGroupUserId(long groupUserId)
		throws Exception {

		return getService().findByGroupUserId(groupUserId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.EcmsPGRelation>
			findByPermission(int permission)
		throws Exception {

		return getService().findByPermission(permission);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void removeByGroupId(long groupId) throws Exception {
		getService().removeByGroupId(groupId);
	}

	public static void removeByPermission(int permissionId) throws Exception {
		getService().removeByPermission(permissionId);
	}

	public static EcmsPGRelationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EcmsPGRelationService, EcmsPGRelationService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EcmsPGRelationService.class);

		ServiceTracker<EcmsPGRelationService, EcmsPGRelationService>
			serviceTracker =
				new ServiceTracker
					<EcmsPGRelationService, EcmsPGRelationService>(
						bundle.getBundleContext(), EcmsPGRelationService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}