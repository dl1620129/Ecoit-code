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

package com.ecoit.qa.service.service;

import com.ecoit.qa.service.model.AttachmentAnswer;
import com.ecoit.qa.service.service.persistence.AttachmentAnswerPK;

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
 * Provides the local service interface for AttachmentAnswer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentAnswerLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AttachmentAnswerLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttachmentAnswerLocalServiceUtil} to access the attachment answer local service. Add custom service methods to <code>com.ecoit.qa.service.service.impl.AttachmentAnswerLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the attachment answer to the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AttachmentAnswer addAttachmentAnswer(
		AttachmentAnswer attachmentAnswer);

	/**
	 * Creates a new attachment answer with the primary key. Does not add the attachment answer to the database.
	 *
	 * @param attachmentAnswerPK the primary key for the new attachment answer
	 * @return the new attachment answer
	 */
	@Transactional(enabled = false)
	public AttachmentAnswer createAttachmentAnswer(
		AttachmentAnswerPK attachmentAnswerPK);

	public void createAttachmentAnswer(long answerId, long attachmentId);

	/**
	 * Deletes the attachment answer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AttachmentAnswer deleteAttachmentAnswer(
		AttachmentAnswer attachmentAnswer);

	/**
	 * Deletes the attachment answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer that was removed
	 * @throws PortalException if a attachment answer with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AttachmentAnswer deleteAttachmentAnswer(
			AttachmentAnswerPK attachmentAnswerPK)
		throws PortalException;

	public void deleteByAnswerId(long answerId);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
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
	public AttachmentAnswer fetchAttachmentAnswer(
		AttachmentAnswerPK attachmentAnswerPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the attachment answer with the primary key.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer
	 * @throws PortalException if a attachment answer with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AttachmentAnswer getAttachmentAnswer(
			AttachmentAnswerPK attachmentAnswerPK)
		throws PortalException;

	/**
	 * Returns a range of all the attachment answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @return the range of attachment answers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AttachmentAnswer> getAttachmentAnswers(int start, int end);

	/**
	 * Returns the number of attachment answers.
	 *
	 * @return the number of attachment answers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAttachmentAnswersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AttachmentAnswer> getByAnswerId(long answerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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

	/**
	 * Updates the attachment answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AttachmentAnswer updateAttachmentAnswer(
		AttachmentAnswer attachmentAnswer);

}