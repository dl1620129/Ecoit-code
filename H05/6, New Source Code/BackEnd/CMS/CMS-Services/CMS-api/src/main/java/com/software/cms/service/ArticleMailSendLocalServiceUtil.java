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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ArticleMailSend. This utility wraps
 * <code>com.software.cms.service.impl.ArticleMailSendLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author DungNV
 * @see ArticleMailSendLocalService
 * @generated
 */
public class ArticleMailSendLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.software.cms.service.impl.ArticleMailSendLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the article mail send to the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleMailSend the article mail send
	 * @return the article mail send that was added
	 */
	public static com.software.cms.model.ArticleMailSend addArticleMailSend(
		com.software.cms.model.ArticleMailSend articleMailSend) {

		return getService().addArticleMailSend(articleMailSend);
	}

	public static com.software.cms.model.ArticleMailSend create() {
		return getService().create();
	}

	/**
	 * Creates a new article mail send with the primary key. Does not add the article mail send to the database.
	 *
	 * @param mailSendId the primary key for the new article mail send
	 * @return the new article mail send
	 */
	public static com.software.cms.model.ArticleMailSend createArticleMailSend(
		long mailSendId) {

		return getService().createArticleMailSend(mailSendId);
	}

	/**
	 * Deletes the article mail send from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleMailSend the article mail send
	 * @return the article mail send that was removed
	 */
	public static com.software.cms.model.ArticleMailSend deleteArticleMailSend(
		com.software.cms.model.ArticleMailSend articleMailSend) {

		return getService().deleteArticleMailSend(articleMailSend);
	}

	/**
	 * Deletes the article mail send with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send that was removed
	 * @throws PortalException if a article mail send with the primary key could not be found
	 */
	public static com.software.cms.model.ArticleMailSend deleteArticleMailSend(
			long mailSendId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteArticleMailSend(mailSendId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.software.cms.model.ArticleMailSend fetchArticleMailSend(
		long mailSendId) {

		return getService().fetchArticleMailSend(mailSendId);
	}

	/**
	 * Returns the article mail send matching the UUID and group.
	 *
	 * @param uuid the article mail send's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	public static com.software.cms.model.ArticleMailSend
		fetchArticleMailSendByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchArticleMailSendByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the article mail send with the primary key.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send
	 * @throws PortalException if a article mail send with the primary key could not be found
	 */
	public static com.software.cms.model.ArticleMailSend getArticleMailSend(
			long mailSendId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getArticleMailSend(mailSendId);
	}

	/**
	 * Returns the article mail send matching the UUID and group.
	 *
	 * @param uuid the article mail send's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article mail send
	 * @throws PortalException if a matching article mail send could not be found
	 */
	public static com.software.cms.model.ArticleMailSend
			getArticleMailSendByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getArticleMailSendByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.software.cms.model.ArticleMailSend>
		getArticleMailSends(int start, int end) {

		return getService().getArticleMailSends(start, end);
	}

	/**
	 * Returns the number of article mail sends.
	 *
	 * @return the number of article mail sends
	 */
	public static int getArticleMailSendsCount() {
		return getService().getArticleMailSendsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the article mail send in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param articleMailSend the article mail send
	 * @return the article mail send that was updated
	 */
	public static com.software.cms.model.ArticleMailSend updateArticleMailSend(
		com.software.cms.model.ArticleMailSend articleMailSend) {

		return getService().updateArticleMailSend(articleMailSend);
	}

	public static ArticleMailSendLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ArticleMailSendLocalService, ArticleMailSendLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ArticleMailSendLocalService.class);

		ServiceTracker<ArticleMailSendLocalService, ArticleMailSendLocalService>
			serviceTracker =
				new ServiceTracker
					<ArticleMailSendLocalService, ArticleMailSendLocalService>(
						bundle.getBundleContext(),
						ArticleMailSendLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}