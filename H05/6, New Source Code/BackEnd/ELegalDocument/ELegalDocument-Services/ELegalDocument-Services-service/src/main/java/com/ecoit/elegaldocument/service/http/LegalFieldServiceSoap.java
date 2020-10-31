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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>LegalFieldServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.ecoit.elegaldocument.model.LegalFieldSoap</code>. If the method in the
 * service utility returns a
 * <code>com.ecoit.elegaldocument.model.LegalField</code>, that is translated to a
 * <code>com.ecoit.elegaldocument.model.LegalFieldSoap</code>. Methods that SOAP
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
 * @see LegalFieldServiceHttp
 * @generated
 */
public class LegalFieldServiceSoap {

	public static com.ecoit.elegaldocument.model.LegalFieldSoap
			findByPrimaryKey(long fieldid)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalField returnValue =
				LegalFieldServiceUtil.findByPrimaryKey(fieldid);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap addLegalField(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language,
			boolean statusfield, boolean rssable, int position)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalField returnValue =
				LegalFieldServiceUtil.addLegalField(
					groupid, companyid, userid, createdbyuser, name,
					description, language, statusfield, rssable, position);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap addLegalField(
			long fieldId, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statusfield, boolean rssable, int position)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalField returnValue =
				LegalFieldServiceUtil.addLegalField(
					fieldId, groupid, companyid, userid, createdbyuser, name,
					description, language, statusfield, rssable, position);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap
			updateLegalField(
				long legFieldID, long groupid, long companyid, long userid,
				long modifiedbyuser, String name, String description,
				String language, boolean statusfield, boolean rssable,
				int position)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalField returnValue =
				LegalFieldServiceUtil.updateLegalField(
					legFieldID, groupid, companyid, userid, modifiedbyuser,
					name, description, language, statusfield, rssable,
					position);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap
			updateLegalField(
				com.ecoit.elegaldocument.model.LegalFieldSoap param)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalField returnValue =
				LegalFieldServiceUtil.updateLegalField(
					com.ecoit.elegaldocument.model.impl.LegalFieldModelImpl.
						toModel(param));

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap[] findAll(
			long groupId, long companyId)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalField>
				returnValue = LegalFieldServiceUtil.findAll(groupId, companyId);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap[] findAll(
			long groupId, long companyId, String language)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalField>
				returnValue = LegalFieldServiceUtil.findAll(
					groupId, companyId, language);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int countAll(long groupId, long companyId)
		throws RemoteException {

		try {
			int returnValue = LegalFieldServiceUtil.countAll(
				groupId, companyId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void removeFieldDB(long fiID) throws RemoteException {
		try {
			LegalFieldServiceUtil.removeFieldDB(fiID);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static boolean checkStatusByPrimaryKey(long FieldID)
		throws RemoteException {

		try {
			boolean returnValue = LegalFieldServiceUtil.checkStatusByPrimaryKey(
				FieldID);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap[]
			findByStatusFIELD(long groupId, long companyId, boolean statusFIELD)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalField>
				returnValue = LegalFieldServiceUtil.findByStatusFIELD(
					groupId, companyId, statusFIELD);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap[] findByStatus(
			long groupId, long companyId, boolean statusField)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalField>
				returnValue = LegalFieldServiceUtil.findByStatus(
					groupId, companyId, statusField);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap[] findByStatus(
			long groupId, long companyId, String language, boolean statusField)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalField>
				returnValue = LegalFieldServiceUtil.findByStatus(
					groupId, companyId, language, statusField);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap getFieldId(
			long fieldId)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalField returnValue =
				LegalFieldServiceUtil.getFieldId(fieldId);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalFieldSoap[]
			getDocumentBySQL(String sql, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalField>
				returnValue = LegalFieldServiceUtil.getDocumentBySQL(
					sql, start, end);

			return com.ecoit.elegaldocument.model.LegalFieldSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getCountDocumentBySQL(String sql) throws RemoteException {
		try {
			int returnValue = LegalFieldServiceUtil.getCountDocumentBySQL(sql);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Long[] getAllChild(long groupId, String language)
		throws RemoteException {

		try {
			java.util.List<Long> returnValue =
				LegalFieldServiceUtil.getAllChild(groupId, language);

			return returnValue.toArray(new Long[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		LegalFieldServiceSoap.class);

}