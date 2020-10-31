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

package com.ecoit.elegaldocument.service.http;

import com.ecoit.elegaldocument.service.EcmsPGRelationServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>EcmsPGRelationServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Liverpool
 * @see EcmsPGRelationServiceSoap
 * @generated
 */
public class EcmsPGRelationServiceHttp {

	public static com.ecoit.elegaldocument.model.EcmsPGRelation addPermission(
			HttpPrincipal httpPrincipal, long groupId, int permission)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsPGRelationServiceUtil.class, "addPermission",
				_addPermissionParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, permission);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ecoit.elegaldocument.model.EcmsPGRelation)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void removeByGroupId(
			HttpPrincipal httpPrincipal, long groupId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsPGRelationServiceUtil.class, "removeByGroupId",
				_removeByGroupIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void removeByPermission(
			HttpPrincipal httpPrincipal, int permissionId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsPGRelationServiceUtil.class, "removeByPermission",
				_removeByPermissionParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, permissionId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.EcmsPGRelation>
			findByGroupUserId(HttpPrincipal httpPrincipal, long groupUserId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsPGRelationServiceUtil.class, "findByGroupUserId",
				_findByGroupUserIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupUserId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.ecoit.elegaldocument.model.EcmsPGRelation>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.EcmsPGRelation>
			findByPermission(HttpPrincipal httpPrincipal, int permission)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsPGRelationServiceUtil.class, "findByPermission",
				_findByPermissionParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, permission);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.ecoit.elegaldocument.model.EcmsPGRelation>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static boolean checkPermission(
		HttpPrincipal httpPrincipal, long groupId, int permission) {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsPGRelationServiceUtil.class, "checkPermission",
				_checkPermissionParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, permission);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		EcmsPGRelationServiceHttp.class);

	private static final Class<?>[] _addPermissionParameterTypes0 =
		new Class[] {long.class, int.class};
	private static final Class<?>[] _removeByGroupIdParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _removeByPermissionParameterTypes2 =
		new Class[] {int.class};
	private static final Class<?>[] _findByGroupUserIdParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _findByPermissionParameterTypes4 =
		new Class[] {int.class};
	private static final Class<?>[] _checkPermissionParameterTypes5 =
		new Class[] {long.class, int.class};

}