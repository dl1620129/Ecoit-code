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

package com.ecoit.elegaldocument.service;

import com.ecoit.elegaldocument.model.LegalSuggestDocument;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for LegalSuggestDocument. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Liverpool
 * @see LegalSuggestDocumentLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LegalSuggestDocumentLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalSuggestDocumentLocalServiceUtil} to access the legal suggest document local service. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalSuggestDocumentLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the legal suggest document to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 * @return the legal suggest document that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LegalSuggestDocument addLegalSuggestDocument(
		LegalSuggestDocument legalSuggestDocument);

	public void approvedSuggestion(long sugId, boolean approved, long userId);

	public int countSuggestions(long docId, String language);

	/**
	 * Creates a new legal suggest document with the primary key. Does not add the legal suggest document to the database.
	 *
	 * @param sugId the primary key for the new legal suggest document
	 * @return the new legal suggest document
	 */
	@Transactional(enabled = false)
	public LegalSuggestDocument createLegalSuggestDocument(long sugId);

	public void createUpdateSuggestion(
		long legalSuggestId, long docId, long groupId, String language,
		long userId, String userName, String email, String title,
		String content, boolean isApproved);

	/**
	 * Deletes the legal suggest document from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 * @return the legal suggest document that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public LegalSuggestDocument deleteLegalSuggestDocument(
		LegalSuggestDocument legalSuggestDocument);

	/**
	 * Deletes the legal suggest document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document that was removed
	 * @throws PortalException if a legal suggest document with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public LegalSuggestDocument deleteLegalSuggestDocument(long sugId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LegalSuggestDocument fetchLegalSuggestDocument(long sugId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LegalSuggestDocument> getApprovedSuggestions(
		long docId, String language, boolean isApproved, int start, int limit);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the legal suggest document with the primary key.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document
	 * @throws PortalException if a legal suggest document with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LegalSuggestDocument getLegalSuggestDocument(long sugId)
		throws PortalException;

	/**
	 * Returns a range of all the legal suggest documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of legal suggest documents
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LegalSuggestDocument> getLegalSuggestDocuments(
		int start, int end);

	/**
	 * Returns the number of legal suggest documents.
	 *
	 * @return the number of legal suggest documents
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLegalSuggestDocumentsCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LegalSuggestDocument> getSuggestions(
		long docId, String language, int start, int limit);

	public void removeByDocId(long docId);

	/**
	 * Updates the legal suggest document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 * @return the legal suggest document that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LegalSuggestDocument updateLegalSuggestDocument(
		LegalSuggestDocument legalSuggestDocument);

}