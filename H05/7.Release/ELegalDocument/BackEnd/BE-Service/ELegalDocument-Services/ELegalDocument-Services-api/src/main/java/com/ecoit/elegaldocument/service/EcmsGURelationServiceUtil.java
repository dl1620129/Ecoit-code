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
 * Provides the remote service utility for EcmsGURelation. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.EcmsGURelationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Liverpool
 * @see EcmsGURelationService
 * @generated
 */
public class EcmsGURelationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.EcmsGURelationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ecoit.elegaldocument.model.EcmsGURelation addGURelation(
			long groupUserId, long userId)
		throws Exception {

		return getService().addGURelation(groupUserId, userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static boolean isContain(long groupId, long userId) {
		return getService().isContain(groupId, userId);
	}

	public static void removeByGroup(long groupId) throws Exception {
		getService().removeByGroup(groupId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.EcmsGURelation>
			searchByGroupUser(long groupUserId)
		throws Exception {

		return getService().searchByGroupUser(groupUserId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.EcmsGURelation>
			searchByUserId(long userId)
		throws Exception {

		return getService().searchByUserId(userId);
	}

	public static EcmsGURelationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EcmsGURelationService, EcmsGURelationService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EcmsGURelationService.class);

		ServiceTracker<EcmsGURelationService, EcmsGURelationService>
			serviceTracker =
				new ServiceTracker
					<EcmsGURelationService, EcmsGURelationService>(
						bundle.getBundleContext(), EcmsGURelationService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}