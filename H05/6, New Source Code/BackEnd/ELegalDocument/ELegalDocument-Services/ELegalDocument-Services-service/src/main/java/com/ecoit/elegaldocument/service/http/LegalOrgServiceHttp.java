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

import com.ecoit.elegaldocument.service.LegalOrgServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>LegalOrgServiceUtil</code> service
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
 * @see LegalOrgServiceSoap
 * @generated
 */
public class LegalOrgServiceHttp {

	public static com.ecoit.elegaldocument.model.LegalOrg findByPrimaryKey(
			HttpPrincipal httpPrincipal, long legalorgid)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "findByPrimaryKey",
				_findByPrimaryKeyParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, legalorgid);

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

			return (com.ecoit.elegaldocument.model.LegalOrg)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrg addLegalOrg(
			HttpPrincipal httpPrincipal, long groupid, long companyid,
			long userid, long createdbyuser, String name, String description,
			String language, boolean statusorg, boolean rssable, int position,
			long parentid)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "addLegalOrg",
				_addLegalOrgParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupid, companyid, userid, createdbyuser, name,
				description, language, statusorg, rssable, position, parentid);

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

			return (com.ecoit.elegaldocument.model.LegalOrg)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getMax(
		HttpPrincipal httpPrincipal, String lang, long groupId, long parentId,
		long companyId) {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "getMax", _getMaxParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, lang, groupId, parentId, companyId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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

	public static com.ecoit.elegaldocument.model.LegalOrg addLegalOrg(
			HttpPrincipal httpPrincipal, long orgId, long groupid,
			long companyid, long userid, long createdbyuser, String name,
			String description, String language, boolean statusorg,
			boolean rssable, int position, long parentid)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "addLegalOrg",
				_addLegalOrgParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, orgId, groupid, companyid, userid, createdbyuser,
				name, description, language, statusorg, rssable, position,
				parentid);

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

			return (com.ecoit.elegaldocument.model.LegalOrg)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrg updateImplLegalOrg(
			HttpPrincipal httpPrincipal, long orgId, String name,
			String description, String language, boolean statusorg,
			boolean rssable, int position, long parentid)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "updateImplLegalOrg",
				_updateImplLegalOrgParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, orgId, name, description, language, statusorg,
				rssable, position, parentid);

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

			return (com.ecoit.elegaldocument.model.LegalOrg)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrg updateImplLegalOrg(
			HttpPrincipal httpPrincipal,
			com.ecoit.elegaldocument.model.LegalOrg param)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "updateImplLegalOrg",
				_updateImplLegalOrgParameterTypes5);

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

			return (com.ecoit.elegaldocument.model.LegalOrg)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
			findAll(HttpPrincipal httpPrincipal, long groupId, long companyId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "findAll", _findAllParameterTypes6);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalOrg>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
			findAll(
				HttpPrincipal httpPrincipal, long groupId, long companyId,
				String language)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "findAll", _findAllParameterTypes7);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalOrg>)
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
				LegalOrgServiceUtil.class, "countAll",
				_countAllParameterTypes8);

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

	public static void removeLegalOrg(HttpPrincipal httpPrincipal, long orgId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "removeLegalOrg",
				_removeLegalOrgParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, orgId);

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

	public static java.util.List<Long> getAllChild(
			HttpPrincipal httpPrincipal, long parentId, long groupId,
			long companyId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "getAllChild",
				_getAllChildParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentId, groupId, companyId);

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

	public static java.util.List<Long> getAllChild(
			HttpPrincipal httpPrincipal, long parentId, long groupId,
			long companyId, String language, boolean statusOrg)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "getAllChild",
				_getAllChildParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentId, groupId, companyId, language, statusOrg);

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

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
			findByStatus(
				HttpPrincipal httpPrincipal, long groupId, long companyId,
				boolean OrgStatus)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "findByStatus",
				_findByStatusParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId, OrgStatus);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalOrg>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
			findByStatus(
				HttpPrincipal httpPrincipal, long groupId, long companyId,
				String language, boolean statusOrg)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "findByStatus",
				_findByStatusParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId, language, statusOrg);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalOrg>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrg getOrg(
			HttpPrincipal httpPrincipal, long orgId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "getOrg", _getOrgParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey, orgId);

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

			return (com.ecoit.elegaldocument.model.LegalOrg)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<Long> getAllChild(
			HttpPrincipal httpPrincipal, long parentId, long groupId,
			long companyId, boolean statusType)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "getAllChild",
				_getAllChildParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentId, groupId, companyId, statusType);

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

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
		getDocumentBySQL(
			HttpPrincipal httpPrincipal, String sql, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "getDocumentBySQL",
				_getDocumentBySQLParameterTypes16);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalOrg>)
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
				LegalOrgServiceUtil.class, "getCountDocumentBySQL",
				_getCountDocumentBySQLParameterTypes17);

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
			HttpPrincipal httpPrincipal, long parentId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "getAllChild",
				_getAllChildParameterTypes18);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentId);

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

	public static java.util.List<Long> getAllChild(
			HttpPrincipal httpPrincipal, long parentId, long groupId,
			String language)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "getAllChild",
				_getAllChildParameterTypes19);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentId, groupId, language);

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

	public static int getNodeCount(
			HttpPrincipal httpPrincipal, long parentId, long groupId,
			String language, String name)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalOrgServiceUtil.class, "getNodeCount",
				_getNodeCountParameterTypes20);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentId, groupId, language, name);

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

	private static Log _log = LogFactoryUtil.getLog(LegalOrgServiceHttp.class);

	private static final Class<?>[] _findByPrimaryKeyParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _addLegalOrgParameterTypes1 = new Class[] {
		long.class, long.class, long.class, long.class, String.class,
		String.class, String.class, boolean.class, boolean.class, int.class,
		long.class
	};
	private static final Class<?>[] _getMaxParameterTypes2 = new Class[] {
		String.class, long.class, long.class, long.class
	};
	private static final Class<?>[] _addLegalOrgParameterTypes3 = new Class[] {
		long.class, long.class, long.class, long.class, long.class,
		String.class, String.class, String.class, boolean.class, boolean.class,
		int.class, long.class
	};
	private static final Class<?>[] _updateImplLegalOrgParameterTypes4 =
		new Class[] {
			long.class, String.class, String.class, String.class, boolean.class,
			boolean.class, int.class, long.class
		};
	private static final Class<?>[] _updateImplLegalOrgParameterTypes5 =
		new Class[] {com.ecoit.elegaldocument.model.LegalOrg.class};
	private static final Class<?>[] _findAllParameterTypes6 = new Class[] {
		long.class, long.class
	};
	private static final Class<?>[] _findAllParameterTypes7 = new Class[] {
		long.class, long.class, String.class
	};
	private static final Class<?>[] _countAllParameterTypes8 = new Class[] {
		long.class, long.class
	};
	private static final Class<?>[] _removeLegalOrgParameterTypes9 =
		new Class[] {long.class};
	private static final Class<?>[] _getAllChildParameterTypes10 = new Class[] {
		long.class, long.class, long.class
	};
	private static final Class<?>[] _getAllChildParameterTypes11 = new Class[] {
		long.class, long.class, long.class, String.class, boolean.class
	};
	private static final Class<?>[] _findByStatusParameterTypes12 =
		new Class[] {long.class, long.class, boolean.class};
	private static final Class<?>[] _findByStatusParameterTypes13 =
		new Class[] {long.class, long.class, String.class, boolean.class};
	private static final Class<?>[] _getOrgParameterTypes14 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getAllChildParameterTypes15 = new Class[] {
		long.class, long.class, long.class, boolean.class
	};
	private static final Class<?>[] _getDocumentBySQLParameterTypes16 =
		new Class[] {String.class, int.class, int.class};
	private static final Class<?>[] _getCountDocumentBySQLParameterTypes17 =
		new Class[] {String.class};
	private static final Class<?>[] _getAllChildParameterTypes18 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getAllChildParameterTypes19 = new Class[] {
		long.class, long.class, String.class
	};
	private static final Class<?>[] _getNodeCountParameterTypes20 =
		new Class[] {long.class, long.class, String.class, String.class};

}