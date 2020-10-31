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
 * Provides a wrapper for {@link ArticleMailSendLocalService}.
 *
 * @author DungNV
 * @see ArticleMailSendLocalService
 * @generated
 */
public class ArticleMailSendLocalServiceWrapper
	implements ArticleMailSendLocalService,
			   ServiceWrapper<ArticleMailSendLocalService> {

	public ArticleMailSendLocalServiceWrapper(
		ArticleMailSendLocalService articleMailSendLocalService) {

		_articleMailSendLocalService = articleMailSendLocalService;
	}

	/**
	 * Adds the article mail send to the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleMailSend the article mail send
	 * @return the article mail send that was added
	 */
	@Override
	public com.software.cms.model.ArticleMailSend addArticleMailSend(
		com.software.cms.model.ArticleMailSend articleMailSend) {

		return _articleMailSendLocalService.addArticleMailSend(articleMailSend);
	}

	@Override
	public com.software.cms.model.ArticleMailSend create() {
		return _articleMailSendLocalService.create();
	}

	/**
	 * Creates a new article mail send with the primary key. Does not add the article mail send to the database.
	 *
	 * @param mailSendId the primary key for the new article mail send
	 * @return the new article mail send
	 */
	@Override
	public com.software.cms.model.ArticleMailSend createArticleMailSend(
		long mailSendId) {

		return _articleMailSendLocalService.createArticleMailSend(mailSendId);
	}

	/**
	 * Deletes the article mail send from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleMailSend the article mail send
	 * @return the article mail send that was removed
	 */
	@Override
	public com.software.cms.model.ArticleMailSend deleteArticleMailSend(
		com.software.cms.model.ArticleMailSend articleMailSend) {

		return _articleMailSendLocalService.deleteArticleMailSend(
			articleMailSend);
	}

	/**
	 * Deletes the article mail send with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send that was removed
	 * @throws PortalException if a article mail send with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.ArticleMailSend deleteArticleMailSend(
			long mailSendId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleMailSendLocalService.deleteArticleMailSend(mailSendId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleMailSendLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _articleMailSendLocalService.dynamicQuery();
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

		return _articleMailSendLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _articleMailSendLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _articleMailSendLocalService.dynamicQuery(
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

		return _articleMailSendLocalService.dynamicQueryCount(dynamicQuery);
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

		return _articleMailSendLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.ArticleMailSend fetchArticleMailSend(
		long mailSendId) {

		return _articleMailSendLocalService.fetchArticleMailSend(mailSendId);
	}

	/**
	 * Returns the article mail send matching the UUID and group.
	 *
	 * @param uuid the article mail send's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	@Override
	public com.software.cms.model.ArticleMailSend
		fetchArticleMailSendByUuidAndGroupId(String uuid, long groupId) {

		return _articleMailSendLocalService.
			fetchArticleMailSendByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _articleMailSendLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the article mail send with the primary key.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send
	 * @throws PortalException if a article mail send with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.ArticleMailSend getArticleMailSend(
			long mailSendId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleMailSendLocalService.getArticleMailSend(mailSendId);
	}

	/**
	 * Returns the article mail send matching the UUID and group.
	 *
	 * @param uuid the article mail send's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article mail send
	 * @throws PortalException if a matching article mail send could not be found
	 */
	@Override
	public com.software.cms.model.ArticleMailSend
			getArticleMailSendByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleMailSendLocalService.getArticleMailSendByUuidAndGroupId(
			uuid, groupId);
	}

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
	@Override
	public java.util.List<com.software.cms.model.ArticleMailSend>
		getArticleMailSends(int start, int end) {

		return _articleMailSendLocalService.getArticleMailSends(start, end);
	}

	/**
	 * Returns the number of article mail sends.
	 *
	 * @return the number of article mail sends
	 */
	@Override
	public int getArticleMailSendsCount() {
		return _articleMailSendLocalService.getArticleMailSendsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _articleMailSendLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _articleMailSendLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleMailSendLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the article mail send in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param articleMailSend the article mail send
	 * @return the article mail send that was updated
	 */
	@Override
	public com.software.cms.model.ArticleMailSend updateArticleMailSend(
		com.software.cms.model.ArticleMailSend articleMailSend) {

		return _articleMailSendLocalService.updateArticleMailSend(
			articleMailSend);
	}

	@Override
	public ArticleMailSendLocalService getWrappedService() {
		return _articleMailSendLocalService;
	}

	@Override
	public void setWrappedService(
		ArticleMailSendLocalService articleMailSendLocalService) {

		_articleMailSendLocalService = articleMailSendLocalService;
	}

	private ArticleMailSendLocalService _articleMailSendLocalService;

}