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

package User.Rank.Poisition.Service.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for UserPoisition_Dang. This utility wraps
 * <code>User.Rank.Poisition.Service.service.impl.UserPoisition_DangServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisition_DangService
 * @generated
 */
@ProviderType
public class UserPoisition_DangServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>User.Rank.Poisition.Service.service.impl.UserPoisition_DangServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static UserPoisition_DangService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserPoisition_DangService, UserPoisition_DangService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			UserPoisition_DangService.class);

		ServiceTracker<UserPoisition_DangService, UserPoisition_DangService>
			serviceTracker =
				new ServiceTracker
					<UserPoisition_DangService, UserPoisition_DangService>(
						bundle.getBundleContext(),
						UserPoisition_DangService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}