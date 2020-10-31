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

package com.software.cms.service;

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

import com.software.cms.model.ArticleMailSend;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ArticleMailSend. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author DungNV
 * @see ArticleMailSendLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ArticleMailSendLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticleMailSendLocalServiceUtil} to access the article mail send local service. Add custom service methods to <code>com.software.cms.service.impl.ArticleMailSendLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the article mail send to the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleMailSend the article mail send
	 * @return the article mail send that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ArticleMailSend addArticleMailSend(ArticleMailSend articleMailSend);

	public ArticleMailSend create();

	/**
	 * Creates a new article mail send with the primary key. Does not add the article mail send to the database.
	 *
	 * @param mailSendId the primary key for the new article mail send
	 * @return the new article mail send
	 */
	@Transactional(enabled = false)
	public ArticleMailSend createArticleMailSend(long mailSendId);

	/**
	 * Deletes the article mail send from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleMailSend the article mail send
	 * @return the article mail send that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ArticleMailSend deleteArticleMailSend(
		ArticleMailSend articleMailSend);

	/**
	 * Deletes the article mail send with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send that was removed
	 * @throws PortalException if a article mail send with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ArticleMailSend deleteArticleMailSend(long mailSendId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleMailSendModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleMailSendModelImpl</code>.
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
	public ArticleMailSend fetchArticleMailSend(long mailSendId);

	/**
	 * Returns the article mail send matching the UUID and group.
	 *
	 * @param uuid the article mail send's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArticleMailSend fetchArticleMailSendByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the article mail send with the primary key.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send
	 * @throws PortalException if a article mail send with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArticleMailSend getArticleMailSend(long mailSendId)
		throws PortalException;

	/**
	 * Returns the article mail send matching the UUID and group.
	 *
	 * @param uuid the article mail send's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article mail send
	 * @throws PortalException if a matching article mail send could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArticleMailSend getArticleMailSendByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the article mail sends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @return the range of article mail sends
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ArticleMailSend> getArticleMailSends(int start, int end);

	/**
	 * Returns the number of article mail sends.
	 *
	 * @return the number of article mail sends
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getArticleMailSendsCount();

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
	 * Updates the article mail send in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param articleMailSend the article mail send
	 * @return the article mail send that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ArticleMailSend updateArticleMailSend(
		ArticleMailSend articleMailSend);

}