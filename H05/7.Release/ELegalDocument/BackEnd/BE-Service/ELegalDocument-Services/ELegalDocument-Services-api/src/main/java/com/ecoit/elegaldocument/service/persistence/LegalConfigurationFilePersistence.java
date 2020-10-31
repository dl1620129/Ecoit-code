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

import com.ecoit.elegaldocument.exception.NoSuchLegalConfigurationFileException;
import com.ecoit.elegaldocument.model.LegalConfigurationFile;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal configuration file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalConfigurationFileUtil
 * @generated
 */
@ProviderType
public interface LegalConfigurationFilePersistence
	extends BasePersistence<LegalConfigurationFile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalConfigurationFileUtil} to access the legal configuration file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the legal configuration file where keyId = &#63; or throws a <code>NoSuchLegalConfigurationFileException</code> if it could not be found.
	 *
	 * @param keyId the key ID
	 * @return the matching legal configuration file
	 * @throws NoSuchLegalConfigurationFileException if a matching legal configuration file could not be found
	 */
	public LegalConfigurationFile findByKey(String keyId)
		throws NoSuchLegalConfigurationFileException;

	/**
	 * Returns the legal configuration file where keyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param keyId the key ID
	 * @return the matching legal configuration file, or <code>null</code> if a matching legal configuration file could not be found
	 */
	public LegalConfigurationFile fetchByKey(String keyId);

	/**
	 * Returns the legal configuration file where keyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param keyId the key ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal configuration file, or <code>null</code> if a matching legal configuration file could not be found
	 */
	public LegalConfigurationFile fetchByKey(
		String keyId, boolean useFinderCache);

	/**
	 * Removes the legal configuration file where keyId = &#63; from the database.
	 *
	 * @param keyId the key ID
	 * @return the legal configuration file that was removed
	 */
	public LegalConfigurationFile removeByKey(String keyId)
		throws NoSuchLegalConfigurationFileException;

	/**
	 * Returns the number of legal configuration files where keyId = &#63;.
	 *
	 * @param keyId the key ID
	 * @return the number of matching legal configuration files
	 */
	public int countByKey(String keyId);

	/**
	 * Caches the legal configuration file in the entity cache if it is enabled.
	 *
	 * @param legalConfigurationFile the legal configuration file
	 */
	public void cacheResult(LegalConfigurationFile legalConfigurationFile);

	/**
	 * Caches the legal configuration files in the entity cache if it is enabled.
	 *
	 * @param legalConfigurationFiles the legal configuration files
	 */
	public void cacheResult(
		java.util.List<LegalConfigurationFile> legalConfigurationFiles);

	/**
	 * Creates a new legal configuration file with the primary key. Does not add the legal configuration file to the database.
	 *
	 * @param keyId the primary key for the new legal configuration file
	 * @return the new legal configuration file
	 */
	public LegalConfigurationFile create(String keyId);

	/**
	 * Removes the legal configuration file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file that was removed
	 * @throws NoSuchLegalConfigurationFileException if a legal configuration file with the primary key could not be found
	 */
	public LegalConfigurationFile remove(String keyId)
		throws NoSuchLegalConfigurationFileException;

	public LegalConfigurationFile updateImpl(
		LegalConfigurationFile legalConfigurationFile);

	/**
	 * Returns the legal configuration file with the primary key or throws a <code>NoSuchLegalConfigurationFileException</code> if it could not be found.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file
	 * @throws NoSuchLegalConfigurationFileException if a legal configuration file with the primary key could not be found
	 */
	public LegalConfigurationFile findByPrimaryKey(String keyId)
		throws NoSuchLegalConfigurationFileException;

	/**
	 * Returns the legal configuration file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file, or <code>null</code> if a legal configuration file with the primary key could not be found
	 */
	public LegalConfigurationFile fetchByPrimaryKey(String keyId);

	/**
	 * Returns all the legal configuration files.
	 *
	 * @return the legal configuration files
	 */
	public java.util.List<LegalConfigurationFile> findAll();

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
	public java.util.List<LegalConfigurationFile> findAll(int start, int end);

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
	public java.util.List<LegalConfigurationFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalConfigurationFile>
			orderByComparator);

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
	public java.util.List<LegalConfigurationFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalConfigurationFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal configuration files from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal configuration files.
	 *
	 * @return the number of legal configuration files
	 */
	public int countAll();

}