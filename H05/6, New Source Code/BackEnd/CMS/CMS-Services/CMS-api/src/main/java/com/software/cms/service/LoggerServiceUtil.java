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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Logger. This utility wraps
 * <code>com.software.cms.service.impl.LoggerServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author DungNV
 * @see LoggerService
 * @generated
 */
public class LoggerServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.software.cms.service.impl.LoggerServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static LoggerService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoggerService, LoggerService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoggerService.class);

		ServiceTracker<LoggerService, LoggerService> serviceTracker =
			new ServiceTracker<LoggerService, LoggerService>(
				bundle.getBundleContext(), LoggerService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}