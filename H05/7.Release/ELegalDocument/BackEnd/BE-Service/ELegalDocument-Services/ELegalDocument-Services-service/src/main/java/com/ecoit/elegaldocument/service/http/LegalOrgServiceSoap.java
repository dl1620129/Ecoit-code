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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>LegalOrgServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.ecoit.elegaldocument.model.LegalOrgSoap</code>. If the method in the
 * service utility returns a
 * <code>com.ecoit.elegaldocument.model.LegalOrg</code>, that is translated to a
 * <code>com.ecoit.elegaldocument.model.LegalOrgSoap</code>. Methods that SOAP
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
 * @see LegalOrgServiceHttp
 * @generated
 */
public class LegalOrgServiceSoap {

	public static com.ecoit.elegaldocument.model.LegalOrgSoap findByPrimaryKey(
			long legalorgid)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalOrg returnValue =
				LegalOrgServiceUtil.findByPrimaryKey(legalorgid);

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrgSoap addLegalOrg(
			long groupid, long companyid, long userid, long createdbyuser,
			String name, String description, String language, boolean statusorg,
			boolean rssable, int position, long parentid)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalOrg returnValue =
				LegalOrgServiceUtil.addLegalOrg(
					groupid, companyid, userid, createdbyuser, name,
					description, language, statusorg, rssable, position,
					parentid);

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getMax(
			String lang, long groupId, long parentId, long companyId)
		throws RemoteException {

		try {
			int returnValue = LegalOrgServiceUtil.getMax(
				lang, groupId, parentId, companyId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrgSoap addLegalOrg(
			long orgId, long groupid, long companyid, long userid,
			long createdbyuser, String name, String description,
			String language, boolean statusorg, boolean rssable, int position,
			long parentid)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalOrg returnValue =
				LegalOrgServiceUtil.addLegalOrg(
					orgId, groupid, companyid, userid, createdbyuser, name,
					description, language, statusorg, rssable, position,
					parentid);

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrgSoap
			updateImplLegalOrg(
				long orgId, String name, String description, String language,
				boolean statusorg, boolean rssable, int position, long parentid)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalOrg returnValue =
				LegalOrgServiceUtil.updateImplLegalOrg(
					orgId, name, description, language, statusorg, rssable,
					position, parentid);

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrgSoap
			updateImplLegalOrg(
				com.ecoit.elegaldocument.model.LegalOrgSoap param)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalOrg returnValue =
				LegalOrgServiceUtil.updateImplLegalOrg(
					com.ecoit.elegaldocument.model.impl.LegalOrgModelImpl.
						toModel(param));

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrgSoap[] findAll(
			long groupId, long companyId)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
				returnValue = LegalOrgServiceUtil.findAll(groupId, companyId);

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrgSoap[] findAll(
			long groupId, long companyId, String language)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
				returnValue = LegalOrgServiceUtil.findAll(
					groupId, companyId, language);

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModels(
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
			int returnValue = LegalOrgServiceUtil.countAll(groupId, companyId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void removeLegalOrg(long orgId) throws RemoteException {
		try {
			LegalOrgServiceUtil.removeLegalOrg(orgId);
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
			java.util.List<Long> returnValue = LegalOrgServiceUtil.getAllChild(
				parentId, groupId, companyId);

			return returnValue.toArray(new Long[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Long[] getAllChild(
			long parentId, long groupId, long companyId, String language,
			boolean statusOrg)
		throws RemoteException {

		try {
			java.util.List<Long> returnValue = LegalOrgServiceUtil.getAllChild(
				parentId, groupId, companyId, language, statusOrg);

			return returnValue.toArray(new Long[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrgSoap[] findByStatus(
			long groupId, long companyId, boolean OrgStatus)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
				returnValue = LegalOrgServiceUtil.findByStatus(
					groupId, companyId, OrgStatus);

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrgSoap[] findByStatus(
			long groupId, long companyId, String language, boolean statusOrg)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
				returnValue = LegalOrgServiceUtil.findByStatus(
					groupId, companyId, language, statusOrg);

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrgSoap getOrg(long orgId)
		throws RemoteException {

		try {
			com.ecoit.elegaldocument.model.LegalOrg returnValue =
				LegalOrgServiceUtil.getOrg(orgId);

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModel(
				returnValue);
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
			java.util.List<Long> returnValue = LegalOrgServiceUtil.getAllChild(
				parentId, groupId, companyId, statusType);

			return returnValue.toArray(new Long[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ecoit.elegaldocument.model.LegalOrgSoap[]
			getDocumentBySQL(String sql, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
				returnValue = LegalOrgServiceUtil.getDocumentBySQL(
					sql, start, end);

			return com.ecoit.elegaldocument.model.LegalOrgSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getCountDocumentBySQL(String sql) throws RemoteException {
		try {
			int returnValue = LegalOrgServiceUtil.getCountDocumentBySQL(sql);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Long[] getAllChild(long parentId) throws RemoteException {
		try {
			java.util.List<Long> returnValue = LegalOrgServiceUtil.getAllChild(
				parentId);

			return returnValue.toArray(new Long[returnValue.size()]);
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
			java.util.List<Long> returnValue = LegalOrgServiceUtil.getAllChild(
				parentId, groupId, language);

			return returnValue.toArray(new Long[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getNodeCount(
			long parentId, long groupId, String language, String name)
		throws RemoteException {

		try {
			int returnValue = LegalOrgServiceUtil.getNodeCount(
				parentId, groupId, language, name);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LegalOrgServiceSoap.class);

}