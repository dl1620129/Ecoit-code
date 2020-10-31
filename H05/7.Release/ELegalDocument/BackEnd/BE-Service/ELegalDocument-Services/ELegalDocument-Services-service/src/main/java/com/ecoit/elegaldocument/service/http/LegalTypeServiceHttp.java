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

import com.ecoit.elegaldocument.service.LegalTypeServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>LegalTypeServiceUtil</code> service
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
 * @see LegalTypeServiceSoap
 * @generated
 */
public class LegalTypeServiceHttp {

	public static com.ecoit.elegaldocument.model.LegalType findByPrimaryKey(
			HttpPrincipal httpPrincipal, long typeID)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "findByPrimaryKey",
				_findByPrimaryKeyParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, typeID);

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

			return (com.ecoit.elegaldocument.model.LegalType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalType addType(
			HttpPrincipal httpPrincipal, long groupid, long companyid,
			long userid, long createdbyuser, String name, String description,
			String language, boolean statustype, boolean rssable, int position)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "addType", _addTypeParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupid, companyid, userid, createdbyuser, name,
				description, language, statustype, rssable, position);

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

			return (com.ecoit.elegaldocument.model.LegalType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalType addType(
			HttpPrincipal httpPrincipal, long groupid, long companyid,
			long userid, long createdbyuser, String name, String description,
			String language, boolean statustype, boolean rssable, int position,
			long parentId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "addType", _addTypeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupid, companyid, userid, createdbyuser, name,
				description, language, statustype, rssable, position, parentId);

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

			return (com.ecoit.elegaldocument.model.LegalType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalType addType(
			HttpPrincipal httpPrincipal, long typeID, long groupid,
			long companyid, long userid, long createdbyuser, String name,
			String description, String language, boolean statustype,
			boolean rssable, int position, long parentId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "addType", _addTypeParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, typeID, groupid, companyid, userid, createdbyuser,
				name, description, language, statustype, rssable, position,
				parentId);

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

			return (com.ecoit.elegaldocument.model.LegalType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalType updateType(
			HttpPrincipal httpPrincipal, long typeID, long createdbyuser,
			long modifiedbyuser, String name, String description,
			String language, boolean statustype, boolean rssable, int position)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "updateType",
				_updateTypeParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, typeID, createdbyuser, modifiedbyuser, name,
				description, language, statustype, rssable, position);

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

			return (com.ecoit.elegaldocument.model.LegalType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalType updateType(
			HttpPrincipal httpPrincipal, long typeID, long createdbyuser,
			long modifiedbyuser, String name, String description,
			String language, boolean statustype, boolean rssable, int position,
			long parentId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "updateType",
				_updateTypeParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, typeID, createdbyuser, modifiedbyuser, name,
				description, language, statustype, rssable, position, parentId);

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

			return (com.ecoit.elegaldocument.model.LegalType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalType updateCategory(
			HttpPrincipal httpPrincipal,
			com.ecoit.elegaldocument.model.LegalType param)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "updateCategory",
				_updateCategoryParameterTypes6);

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

			return (com.ecoit.elegaldocument.model.LegalType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void removeType(HttpPrincipal httpPrincipal, long typeID)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "removeType",
				_removeTypeParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, typeID);

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

	public static int countAll(
			HttpPrincipal httpPrincipal, long groupId, long companyId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "countAll",
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

	public static boolean checkStatusByPrimaryKey(
			HttpPrincipal httpPrincipal, long tID)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "checkStatusByPrimaryKey",
				_checkStatusByPrimaryKeyParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, tID);

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

	public static java.util.List<com.ecoit.elegaldocument.model.LegalType>
			findAll(HttpPrincipal httpPrincipal, long groupId, long companyId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "findAll",
				_findAllParameterTypes10);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalType>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalType>
			findAll(
				HttpPrincipal httpPrincipal, long groupId, long companyId,
				String language)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "findAll",
				_findAllParameterTypes11);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalType>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalType>
			findByStatus(
				HttpPrincipal httpPrincipal, long groupId, long companyId,
				boolean statusType)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "findByStatus",
				_findByStatusParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId, statusType);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalType>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalType>
			findByStatus(
				HttpPrincipal httpPrincipal, long groupId, long companyId,
				String language, boolean statusType)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "findByStatus",
				_findByStatusParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId, language, statusType);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalType>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ecoit.elegaldocument.model.LegalType getType(
			HttpPrincipal httpPrincipal, long typeID)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "getType",
				_getTypeParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey, typeID);

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

			return (com.ecoit.elegaldocument.model.LegalType)returnObj;
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
				LegalTypeServiceUtil.class, "getAllChild",
				_getAllChildParameterTypes15);

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
			long companyId, boolean statusType)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "getAllChild",
				_getAllChildParameterTypes16);

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

	public static java.util.List<Long> getAllChild(
			HttpPrincipal httpPrincipal, long parentId, long groupId,
			long companyId, String language, boolean statusType)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "getAllChild",
				_getAllChildParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentId, groupId, companyId, language, statusType);

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
			HttpPrincipal httpPrincipal, long parentId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "getAllChild",
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

	public static java.util.List<com.ecoit.elegaldocument.model.LegalType>
		getDocumentBySQL(
			HttpPrincipal httpPrincipal, String sql, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "getDocumentBySQL",
				_getDocumentBySQLParameterTypes19);

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

			return (java.util.List<com.ecoit.elegaldocument.model.LegalType>)
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
				LegalTypeServiceUtil.class, "getCountDocumentBySQL",
				_getCountDocumentBySQLParameterTypes20);

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
			HttpPrincipal httpPrincipal, long parentId, long groupId,
			String language)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "getAllChild",
				_getAllChildParameterTypes21);

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

	public static java.util.List<Object> getDuLieuTheoSql(
		HttpPrincipal httpPrincipal, String sqlQuery) {

		try {
			MethodKey methodKey = new MethodKey(
				LegalTypeServiceUtil.class, "getDuLieuTheoSql",
				_getDuLieuTheoSqlParameterTypes22);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, sqlQuery);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<Object>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LegalTypeServiceHttp.class);

	private static final Class<?>[] _findByPrimaryKeyParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _addTypeParameterTypes1 = new Class[] {
		long.class, long.class, long.class, long.class, String.class,
		String.class, String.class, boolean.class, boolean.class, int.class
	};
	private static final Class<?>[] _addTypeParameterTypes2 = new Class[] {
		long.class, long.class, long.class, long.class, String.class,
		String.class, String.class, boolean.class, boolean.class, int.class,
		long.class
	};
	private static final Class<?>[] _addTypeParameterTypes3 = new Class[] {
		long.class, long.class, long.class, long.class, long.class,
		String.class, String.class, String.class, boolean.class, boolean.class,
		int.class, long.class
	};
	private static final Class<?>[] _updateTypeParameterTypes4 = new Class[] {
		long.class, long.class, long.class, String.class, String.class,
		String.class, boolean.class, boolean.class, int.class
	};
	private static final Class<?>[] _updateTypeParameterTypes5 = new Class[] {
		long.class, long.class, long.class, String.class, String.class,
		String.class, boolean.class, boolean.class, int.class, long.class
	};
	private static final Class<?>[] _updateCategoryParameterTypes6 =
		new Class[] {com.ecoit.elegaldocument.model.LegalType.class};
	private static final Class<?>[] _removeTypeParameterTypes7 = new Class[] {
		long.class
	};
	private static final Class<?>[] _countAllParameterTypes8 = new Class[] {
		long.class, long.class
	};
	private static final Class<?>[] _checkStatusByPrimaryKeyParameterTypes9 =
		new Class[] {long.class};
	private static final Class<?>[] _findAllParameterTypes10 = new Class[] {
		long.class, long.class
	};
	private static final Class<?>[] _findAllParameterTypes11 = new Class[] {
		long.class, long.class, String.class
	};
	private static final Class<?>[] _findByStatusParameterTypes12 =
		new Class[] {long.class, long.class, boolean.class};
	private static final Class<?>[] _findByStatusParameterTypes13 =
		new Class[] {long.class, long.class, String.class, boolean.class};
	private static final Class<?>[] _getTypeParameterTypes14 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getAllChildParameterTypes15 = new Class[] {
		long.class, long.class, long.class
	};
	private static final Class<?>[] _getAllChildParameterTypes16 = new Class[] {
		long.class, long.class, long.class, boolean.class
	};
	private static final Class<?>[] _getAllChildParameterTypes17 = new Class[] {
		long.class, long.class, long.class, String.class, boolean.class
	};
	private static final Class<?>[] _getAllChildParameterTypes18 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getDocumentBySQLParameterTypes19 =
		new Class[] {String.class, int.class, int.class};
	private static final Class<?>[] _getCountDocumentBySQLParameterTypes20 =
		new Class[] {String.class};
	private static final Class<?>[] _getAllChildParameterTypes21 = new Class[] {
		long.class, long.class, String.class
	};
	private static final Class<?>[] _getDuLieuTheoSqlParameterTypes22 =
		new Class[] {String.class};

}