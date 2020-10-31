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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ArticleMessageLocalService}.
 *
 * @author DungNV
 * @see ArticleMessageLocalService
 * @generated
 */
public class ArticleMessageLocalServiceWrapper
	implements ArticleMessageLocalService,
			   ServiceWrapper<ArticleMessageLocalService> {

	public ArticleMessageLocalServiceWrapper(
		ArticleMessageLocalService articleMessageLocalService) {

		_articleMessageLocalService = articleMessageLocalService;
	}

	/**
	 * Adds the article message to the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleMessage the article message
	 * @return the article message that was added
	 */
	@Override
	public com.software.cms.model.ArticleMessage addArticleMessage(
		com.software.cms.model.ArticleMessage articleMessage) {

		return _articleMessageLocalService.addArticleMessage(articleMessage);
	}

	@Override
	public com.software.cms.model.ArticleMessage create() {
		return _articleMessageLocalService.create();
	}

	/**
	 * Creates a new article message with the primary key. Does not add the article message to the database.
	 *
	 * @param messageId the primary key for the new article message
	 * @return the new article message
	 */
	@Override
	public com.software.cms.model.ArticleMessage createArticleMessage(
		long messageId) {

		return _articleMessageLocalService.createArticleMessage(messageId);
	}

	/**
	 * Deletes the article message from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleMessage the article message
	 * @return the article message that was removed
	 */
	@Override
	public com.software.cms.model.ArticleMessage deleteArticleMessage(
		com.software.cms.model.ArticleMessage articleMessage) {

		return _articleMessageLocalService.deleteArticleMessage(articleMessage);
	}

	/**
	 * Deletes the article message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message that was removed
	 * @throws PortalException if a article message with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.ArticleMessage deleteArticleMessage(
			long messageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleMessageLocalService.deleteArticleMessage(messageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleMessageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _articleMessageLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _articleMessageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _articleMessageLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _articleMessageLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _articleMessageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _articleMessageLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.ArticleMessage fetchArticleMessage(
		long messageId) {

		return _articleMessageLocalService.fetchArticleMessage(messageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _articleMessageLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the article message with the primary key.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message
	 * @throws PortalException if a article message with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.ArticleMessage getArticleMessage(
			long messageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleMessageLocalService.getArticleMessage(messageId);
	}

	/**
	 * Returns a range of all the article messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @return the range of article messages
	 */
	@Override
	public java.util.List<com.software.cms.model.ArticleMessage>
		getArticleMessages(int start, int end) {

		return _articleMessageLocalService.getArticleMessages(start, end);
	}

	/**
	 * Returns the number of article messages.
	 *
	 * @return the number of article messages
	 */
	@Override
	public int getArticleMessagesCount() {
		return _articleMessageLocalService.getArticleMessagesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _articleMessageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _articleMessageLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleMessageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the article message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param articleMessage the article message
	 * @return the article message that was updated
	 */
	@Override
	public com.software.cms.model.ArticleMessage updateArticleMessage(
		com.software.cms.model.ArticleMessage articleMessage) {

		return _articleMessageLocalService.updateArticleMessage(articleMessage);
	}

	@Override
	public ArticleMessageLocalService getWrappedService() {
		return _articleMessageLocalService;
	}

	@Override
	public void setWrappedService(
		ArticleMessageLocalService articleMessageLocalService) {

		_articleMessageLocalService = articleMessageLocalService;
	}

	private ArticleMessageLocalService _articleMessageLocalService;

}