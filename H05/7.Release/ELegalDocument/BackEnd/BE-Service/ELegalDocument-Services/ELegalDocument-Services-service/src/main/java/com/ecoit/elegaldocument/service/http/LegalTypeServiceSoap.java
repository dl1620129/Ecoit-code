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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>LegalTypeServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.ecoit.elegaldocument.model.LegalTypeSoap</code>. If the method in the
 * service utility returns a
 * <code>com.ecoit.elegaldocument.model.LegalType</code>, that is translated to a
 * <code>com.ecoit.elegaldocument.model.LegalTypeSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Liverpool
 * @see LegalTypeServiceHttp
 * @generated
 */
public class LegalTypeServiceSoap {

	public static com.ecoit.elegaldocument.model.LegalTypeSoap findByPrimaryKey(
			long typeID)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalType returnValue =
				LegalTypeServiceUtil.findByPrimaryKey(typeID);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap addType(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language,
			boolean statustype, boolean rssable, int position)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalType returnValue =
				LegalTypeServiceUtil.addType(
					groupid, companyid, userid, createdbyuser, name,
					description, language, statustype, rssable, position);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap addType(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language,
			boolean statustype, boolean rssable, int position, long parentId)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalType returnValue =
				LegalTypeServiceUtil.addType(
					groupid, companyid, userid, createdbyuser, name,
					description, language, statustype, rssable, position,
					parentId);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap addType(
			long typeID, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statustype, boolean rssable, int position,
			long parentId)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalType returnValue =
				LegalTypeServiceUtil.addType(
					typeID, groupid, companyid, userid, createdbyuser, name,
					description, language, statustype, rssable, position,
					parentId);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap updateType(
			long typeID, long createdbyuser, long modifiedbyuser, String name,
			String description, String language, boolean statustype,
			boolean rssable, int position)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalType returnValue =
				LegalTypeServiceUtil.updateType(
					typeID, createdbyuser, modifiedbyuser, name, description,
					language, statustype, rssable, position);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap updateType(
			long typeID, long createdbyuser, long modifiedbyuser, String name,
			String description, String language, boolean statustype,
			boolean rssable, int position, long parentId)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalType returnValue =
				LegalTypeServiceUtil.updateType(
					typeID, createdbyuser, modifiedbyuser, name, description,
					language, statustype, rssable, position, parentId);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap updateCategory(
			com.ecoit.elegaldocument.model.LegalTypeSoap param)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalType returnValue =
				LegalTypeServiceUtil.updateCategory(
					com.ecoit.elegaldocument.model.impl.LegalTypeModelImpl.
						toModel(param));

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void removeType(long typeID) throws RemoteException {
		try {
			LegalTypeServiceUtil.removeType(typeID);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int countAll(long groupId, long companyId)
		throws RemoteException {

		try {
			int returnValue = LegalTypeServiceUtil.countAll(groupId, companyId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static boolean checkStatusByPrimaryKey(long tID)
		throws RemoteException {

		try {
			boolean returnValue = LegalTypeServiceUtil.checkStatusByPrimaryKey(
				tID);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap[] findAll(
			long groupId, long companyId)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalType>
				returnValue = LegalTypeServiceUtil.findAll(groupId, companyId);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap[] findAll(
			long groupId, long companyId, String language)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalType>
				returnValue = LegalTypeServiceUtil.findAll(
					groupId, companyId, language);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap[] findByStatus(
			long groupId, long companyId, boolean statusType)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalType>
				returnValue = LegalTypeServiceUtil.findByStatus(
					groupId, companyId, statusType);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap[] findByStatus(
			long groupId, long companyId, String language, boolean statusType)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalType>
				returnValue = LegalTypeServiceUtil.findByStatus(
					groupId, companyId, language, statusType);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap getType(
			long typeID)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalType returnValue =
				LegalTypeServiceUtil.getType(typeID);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Long[] getAllChild(
			long parentId, long groupId, long companyId)
		throws RemoteException {

		try {
			java.util.List<Long> returnValue = LegalTypeServiceUtil.getAllChild(
				parentId, groupId, companyId);

			return returnValue.toArray(new Long[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Long[] getAllChild(
			long parentId, long groupId, long companyId, boolean statusType)
		throws RemoteException {

		try {
			java.util.List<Long> returnValue = LegalTypeServiceUtil.getAllChild(
				parentId, groupId, companyId, statusType);

			return returnValue.toArray(new Long[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Long[] getAllChild(
			long parentId, long groupId, long companyId, String language,
			boolean statusType)
		throws RemoteException {

		try {
			java.util.List<Long> returnValue = LegalTypeServiceUtil.getAllChild(
				parentId, groupId, companyId, language, statusType);

			return returnValue.toArray(new Long[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Long[] getAllChild(long parentId) throws RemoteException {
		try {
			java.util.List<Long> returnValue = LegalTypeServiceUtil.getAllChild(
				parentId);

			return returnValue.toArray(new Long[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalTypeSoap[]
			getDocumentBySQL(String sql, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalType>
				returnValue = LegalTypeServiceUtil.getDocumentBySQL(
					sql, start, end);

			return com.ecoit.elegaldocument.model.LegalTypeSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getCountDocumentBySQL(String sql) throws RemoteException {
		try {
			int returnValue = LegalTypeServiceUtil.getCountDocumentBySQL(sql);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Long[] getAllChild(
			long parentId, long groupId, String language)
		throws RemoteException {

		try {
			java.util.List<Long> returnValue = LegalTypeServiceUtil.getAllChild(
				parentId, groupId, language);

			return returnValue.toArray(new Long[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LegalTypeServiceSoap.class);

}