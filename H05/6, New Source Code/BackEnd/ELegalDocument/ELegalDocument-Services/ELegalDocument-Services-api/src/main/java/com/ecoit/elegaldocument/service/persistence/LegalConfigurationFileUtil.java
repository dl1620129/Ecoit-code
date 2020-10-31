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

package com.ecoit.elegaldocument.service.persistence;

import com.ecoit.elegaldocument.model.LegalConfigurationFile;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the legal configuration file service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalConfigurationFilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalConfigurationFilePersistence
 * @generated
 */
public class LegalConfigurationFileUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		LegalConfigurationFile legalConfigurationFile) {

		getPersistence().clearCache(legalConfigurationFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, LegalConfigurationFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalConfigurationFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalConfigurationFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalConfigurationFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalConfigurationFile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalConfigurationFile update(
		LegalConfigurationFile legalConfigurationFile) {

		return getPersistence().update(legalConfigurationFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalConfigurationFile update(
		LegalConfigurationFile legalConfigurationFile,
		ServiceContext serviceContext) {

		return getPersistence().update(legalConfigurationFile, serviceContext);
	}

	/**
	 * Returns the legal configuration file where keyId = &#63; or throws a <code>NoSuchLegalConfigurationFileException</code> if it could not be found.
	 *
	 * @param keyId the key ID
	 * @return the matching legal configuration file
	 * @throws NoSuchLegalConfigurationFileException if a matching legal configuration file could not be found
	 */
	public static LegalConfigurationFile findByKey(String keyId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalConfigurationFileException {

		return getPersistence().findByKey(keyId);
	}

	/**
	 * Returns the legal configuration file where keyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param keyId the key ID
	 * @return the matching legal configuration file, or <code>null</code> if a matching legal configuration file could not be found
	 */
	public static LegalConfigurationFile fetchByKey(String keyId) {
		return getPersistence().fetchByKey(keyId);
	}

	/**
	 * Returns the legal configuration file where keyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param keyId the key ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal configuration file, or <code>null</code> if a matching legal configuration file could not be found
	 */
	public static LegalConfigurationFile fetchByKey(
		String keyId, boolean useFinderCache) {

		return getPersistence().fetchByKey(keyId, useFinderCache);
	}

	/**
	 * Removes the legal configuration file where keyId = &#63; from the database.
	 *
	 * @param keyId the key ID
	 * @return the legal configuration file that was removed
	 */
	public static LegalConfigurationFile removeByKey(String keyId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalConfigurationFileException {

		return getPersistence().removeByKey(keyId);
	}

	/**
	 * Returns the number of legal configuration files where keyId = &#63;.
	 *
	 * @param keyId the key ID
	 * @return the number of matching legal configuration files
	 */
	public static int countByKey(String keyId) {
		return getPersistence().countByKey(keyId);
	}

	/**
	 * Caches the legal configuration file in the entity cache if it is enabled.
	 *
	 * @param legalConfigurationFile the legal configuration file
	 */
	public static void cacheResult(
		LegalConfigurationFile legalConfigurationFile) {

		getPersistence().cacheResult(legalConfigurationFile);
	}

	/**
	 * Caches the legal configuration files in the entity cache if it is enabled.
	 *
	 * @param legalConfigurationFiles the legal configuration files
	 */
	public static void cacheResult(
		List<LegalConfigurationFile> legalConfigurationFiles) {

		getPersistence().cacheResult(legalConfigurationFiles);
	}

	/**
	 * Creates a new legal configuration file with the primary key. Does not add the legal configuration file to the database.
	 *
	 * @param keyId the primary key for the new legal configuration file
	 * @return the new legal configuration file
	 */
	public static LegalConfigurationFile create(String keyId) {
		return getPersistence().create(keyId);
	}

	/**
	 * Removes the legal configuration file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file that was removed
	 * @throws NoSuchLegalConfigurationFileException if a legal configuration file with the primary key could not be found
	 */
	public static LegalConfigurationFile remove(String keyId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalConfigurationFileException {

		return getPersistence().remove(keyId);
	}

	public static LegalConfigurationFile updateImpl(
		LegalConfigurationFile legalConfigurationFile) {

		return getPersistence().updateImpl(legalConfigurationFile);
	}

	/**
	 * Returns the legal configuration file with the primary key or throws a <code>NoSuchLegalConfigurationFileException</code> if it could not be found.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file
	 * @throws NoSuchLegalConfigurationFileException if a legal configuration file with the primary key could not be found
	 */
	public static LegalConfigurationFile findByPrimaryKey(String keyId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalConfigurationFileException {

		return getPersistence().findByPrimaryKey(keyId);
	}

	/**
	 * Returns the legal configuration file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file, or <code>null</code> if a legal configuration file with the primary key could not be found
	 */
	public static LegalConfigurationFile fetchByPrimaryKey(String keyId) {
		return getPersistence().fetchByPrimaryKey(keyId);
	}

	/**
	 * Returns all the legal configuration files.
	 *
	 * @return the legal configuration files
	 */
	public static List<LegalConfigurationFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal configuration files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalConfigurationFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal configuration files
	 * @param end the upper bound of the range of legal configuration files (not inclusive)
	 * @return the range of legal configuration files
	 */
	public static List<LegalConfigurationFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal configuration files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalConfigurationFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal configuration files
	 * @param end the upper bound of the range of legal configuration files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal configuration files
	 */
	public static List<LegalConfigurationFile> findAll(
		int start, int end,
		OrderByComparator<LegalConfigurationFile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal configuration files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalConfigurationFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal configuration files
	 * @param end the upper bound of the range of legal configuration files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal configuration files
	 */
	public static List<LegalConfigurationFile> findAll(
		int start, int end,
		OrderByComparator<LegalConfigurationFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal configuration files from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal configuration files.
	 *
	 * @return the number of legal configuration files
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalConfigurationFilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalConfigurationFilePersistence, LegalConfigurationFilePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalConfigurationFilePersistence.class);

		ServiceTracker
			<LegalConfigurationFilePersistence,
			 LegalConfigurationFilePersistence> serviceTracker =
				new ServiceTracker
					<LegalConfigurationFilePersistence,
					 LegalConfigurationFilePersistence>(
						 bundle.getBundleContext(),
						 LegalConfigurationFilePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}