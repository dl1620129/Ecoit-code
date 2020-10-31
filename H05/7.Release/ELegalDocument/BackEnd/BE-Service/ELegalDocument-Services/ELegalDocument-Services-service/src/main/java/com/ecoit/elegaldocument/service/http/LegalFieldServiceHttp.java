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

import com.ecoit.elegaldocument.service.LegalFieldServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>LegalFieldServiceUtil</code> service
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
 * @see LegalFieldServiceSoap
 * @generated
 */
public class LegalFieldServiceHttp {

	public static com.ecoit.elegaldocument.model.LegalField findByPrimaryKey(
			HttpPrincipal httpPrincipal, long fieldid)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "findByPrimaryKey",
				_findByPrimaryKeyParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, fieldid);

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

			return (com.ecoit.elegaldocument.model.LegalField)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalField addLegalField(
			HttpPrincipal httpPrincipal, long groupid, long companyid,
			long userid, long createdbyuser, String name, String description,
			String language, boolean statusfield, boolean rssable, int position)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "addLegalField",
				_addLegalFieldParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupid, companyid, userid, createdbyuser, name,
				description, language, statusfield, rssable, position);

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

			return (com.ecoit.elegaldocument.model.LegalField)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalField addLegalField(
			HttpPrincipal httpPrincipal, long fieldId, long groupid,
			long companyid, long userid, long createdbyuser, String name,
			String description, String language, boolean statusfield,
			boolean rssable, int position)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "addLegalField",
				_addLegalFieldParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fieldId, groupid, companyid, userid, createdbyuser,
				name, description, language, statusfield, rssable, position);

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

			return (com.ecoit.elegaldocument.model.LegalField)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalField updateLegalField(
			HttpPrincipal httpPrincipal, long legFieldID, long groupid,
			long companyid, long userid, long modifiedbyuser, String name,
			String description, String language, boolean statusfield,
			boolean rssable, int position)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "updateLegalField",
				_updateLegalFieldParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, legFieldID, groupid, companyid, userid,
				modifiedbyuser, name, description, language, statusfield,
				rssable, position);

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

			return (com.ecoit.elegaldocument.model.LegalField)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalField updateLegalField(
			HttpPrincipal httpPrincipal,
			com.ecoit.elegaldocument.model.LegalField param)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "updateLegalField",
				_updateLegalFieldParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, param);

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

			return (com.ecoit.elegaldocument.model.LegalField)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findAll(HttpPrincipal httpPrincipal, long groupId, long companyId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "findAll",
				_findAllParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalField>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findAll(
				HttpPrincipal httpPrincipal, long groupId, long companyId,
				String language)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "findAll",
				_findAllParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId, language);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalField>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int countAll(
			HttpPrincipal httpPrincipal, long groupId, long companyId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "countAll",
				_countAllParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId);

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

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void removeFieldDB(HttpPrincipal httpPrincipal, long fiID)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "removeFieldDB",
				_removeFieldDBParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, fiID);

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

	public static boolean checkStatusByPrimaryKey(
			HttpPrincipal httpPrincipal, long FieldID)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "checkStatusByPrimaryKey",
				_checkStatusByPrimaryKeyParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, FieldID);

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

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findByStatusFIELD(
				HttpPrincipal httpPrincipal, long groupId, long companyId,
				boolean statusFIELD)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "findByStatusFIELD",
				_findByStatusFIELDParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId, statusFIELD);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalField>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findByStatus(
				HttpPrincipal httpPrincipal, long groupId, long companyId,
				boolean statusField)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "findByStatus",
				_findByStatusParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId, statusField);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalField>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
			findByStatus(
				HttpPrincipal httpPrincipal, long groupId, long companyId,
				String language, boolean statusField)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "findByStatus",
				_findByStatusParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId, language, statusField);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalField>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalField getFieldId(
			HttpPrincipal httpPrincipal, long fieldId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "getFieldId",
				_getFieldIdParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey, fieldId);

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

			return (com.ecoit.elegaldocument.model.LegalField)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getDocumentBySQL(
			HttpPrincipal httpPrincipal, String sql, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "getDocumentBySQL",
				_getDocumentBySQLParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, sql, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.ecoit.elegaldocument.model.LegalField>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getCountDocumentBySQL(
			HttpPrincipal httpPrincipal, String sql)
		throws com.liferay.portal.kernel.exception.SystemException {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "getCountDocumentBySQL",
				_getCountDocumentBySQLParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(methodKey, sql);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.SystemException) {

					throw (com.liferay.portal.kernel.exception.SystemException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<Long> getAllChild(
			HttpPrincipal httpPrincipal, long groupId, String language)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalFieldServiceUtil.class, "getAllChild",
				_getAllChildParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, language);

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

			return (java.util.List<Long>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		LegalFieldServiceHttp.class);

	private static final Class<?>[] _findByPrimaryKeyParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _addLegalFieldParameterTypes1 =
		new Class[] {
			long.class, long.class, long.class, long.class, String.class,
			String.class, String.class, boolean.class, boolean.class, int.class
		};
	private static final Class<?>[] _addLegalFieldParameterTypes2 =
		new Class[] {
			long.class, long.class, long.class, long.class, long.class,
			String.class, String.class, String.class, boolean.class,
			boolean.class, int.class
		};
	private static final Class<?>[] _updateLegalFieldParameterTypes3 =
		new Class[] {
			long.class, long.class, long.class, long.class, long.class,
			String.class, String.class, String.class, boolean.class,
			boolean.class, int.class
		};
	private static final Class<?>[] _updateLegalFieldParameterTypes4 =
		new Class[] {com.ecoit.elegaldocument.model.LegalField.class};
	private static final Class<?>[] _findAllParameterTypes5 = new Class[] {
		long.class, long.class
	};
	private static final Class<?>[] _findAllParameterTypes6 = new Class[] {
		long.class, long.class, String.class
	};
	private static final Class<?>[] _countAllParameterTypes7 = new Class[] {
		long.class, long.class
	};
	private static final Class<?>[] _removeFieldDBParameterTypes8 =
		new Class[] {long.class};
	private static final Class<?>[] _checkStatusByPrimaryKeyParameterTypes9 =
		new Class[] {long.class};
	private static final Class<?>[] _findByStatusFIELDParameterTypes10 =
		new Class[] {long.class, long.class, boolean.class};
	private static final Class<?>[] _findByStatusParameterTypes11 =
		new Class[] {long.class, long.class, boolean.class};
	private static final Class<?>[] _findByStatusParameterTypes12 =
		new Class[] {long.class, long.class, String.class, boolean.class};
	private static final Class<?>[] _getFieldIdParameterTypes13 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getDocumentBySQLParameterTypes14 =
		new Class[] {String.class, int.class, int.class};
	private static final Class<?>[] _getCountDocumentBySQLParameterTypes15 =
		new Class[] {String.class};
	private static final Class<?>[] _getAllChildParameterTypes16 = new Class[] {
		long.class, String.class
	};

}