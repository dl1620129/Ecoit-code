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

import com.ecoit.elegaldocument.service.EcmsGroupServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>EcmsGroupServiceUtil</code> service
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
 * @see EcmsGroupServiceSoap
 * @generated
 */
public class EcmsGroupServiceHttp {

	public static com.ecoit.elegaldocument.model.EcmsGroup addGroup(
			HttpPrincipal httpPrincipal, String groupName,
			String groupDesciption, long groupId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsGroupServiceUtil.class, "addGroup",
				_addGroupParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupName, groupDesciption, groupId);

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

			return (com.ecoit.elegaldocument.model.EcmsGroup)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.EcmsGroup updateGroup(
			HttpPrincipal httpPrincipal, long groupId, String groupName,
			String groupDesciption)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsGroupServiceUtil.class, "updateGroup",
				_updateGroupParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, groupName, groupDesciption);

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

			return (com.ecoit.elegaldocument.model.EcmsGroup)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void updateGroup(
			HttpPrincipal httpPrincipal,
			com.ecoit.elegaldocument.model.EcmsGroup group)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsGroupServiceUtil.class, "updateGroup",
				_updateGroupParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, group);

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

	public static void deleteGroup(HttpPrincipal httpPrincipal, long groupId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsGroupServiceUtil.class, "deleteGroup",
				_deleteGroupParameterTypes3);

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

	public static java.util.List<com.ecoit.elegaldocument.model.EcmsGroup>
			findAll(HttpPrincipal httpPrincipal)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsGroupServiceUtil.class, "findAll", _findAllParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey);

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

			return (java.util.List<com.ecoit.elegaldocument.model.EcmsGroup>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.EcmsGroup findByPrimaryKey(
			HttpPrincipal httpPrincipal, long groupId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsGroupServiceUtil.class, "findByPrimaryKey",
				_findByPrimaryKeyParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

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

			return (com.ecoit.elegaldocument.model.EcmsGroup)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long findUserInGroup(
		HttpPrincipal httpPrincipal, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				EcmsGroupServiceUtil.class, "findUserInGroup",
				_findUserInGroupParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EcmsGroupServiceHttp.class);

	private static final Class<?>[] _addGroupParameterTypes0 = new Class[] {
		String.class, String.class, long.class
	};
	private static final Class<?>[] _updateGroupParameterTypes1 = new Class[] {
		long.class, String.class, String.class
	};
	private static final Class<?>[] _updateGroupParameterTypes2 = new Class[] {
		com.ecoit.elegaldocument.model.EcmsGroup.class
	};
	private static final Class<?>[] _deleteGroupParameterTypes3 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findAllParameterTypes4 = new Class[] {};
	private static final Class<?>[] _findByPrimaryKeyParameterTypes5 =
		new Class[] {long.class};
	private static final Class<?>[] _findUserInGroupParameterTypes6 =
		new Class[] {long.class};

}