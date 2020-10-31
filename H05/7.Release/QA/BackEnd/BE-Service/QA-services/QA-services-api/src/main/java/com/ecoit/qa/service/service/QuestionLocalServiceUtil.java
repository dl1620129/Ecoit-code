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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Question. This utility wraps
 * <code>com.ecoit.qa.service.service.impl.QuestionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuestionLocalService
 * @generated
 */
public class QuestionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.qa.service.service.impl.QuestionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the question to the database. Also notifies the appropriate model listeners.
	 *
	 * @param question the question
	 * @return the question that was added
	 */
	public static com.ecoit.qa.service.model.Question addQuestion(
		com.ecoit.qa.service.model.Question question) {

		return getService().addQuestion(question);
	}

	public static int countByCategoryId(long categoryId) {
		return getService().countByCategoryId(categoryId);
	}

	public static int countByStatus(int status, long groupId, String locale) {
		return getService().countByStatus(status, groupId, locale);
	}

	public static int countQuestions(
			long groupId, String locale, long categoryId, String searchKey,
			int status)
		throws Exception {

		return getService().countQuestions(
			groupId, locale, categoryId, searchKey, status);
	}

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param questionId the primary key for the new question
	 * @return the new question
	 */
	public static com.ecoit.qa.service.model.Question createQuestion(
		long questionId) {

		return getService().createQuestion(questionId);
	}

	public static com.ecoit.qa.service.model.Question createUpdateQuestion(
			long groupId, String locale, long userId, long questionId,
			String title, String email, String content, String phoneNumber,
			String address, java.util.List<Long> attachmentIdsList,
			long categoryId, String name, int status)
		throws Exception {

		return getService().createUpdateQuestion(
			groupId, locale, userId, questionId, title, email, content,
			phoneNumber, address, attachmentIdsList, categoryId, name, status);
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

	/**
	 * Deletes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the question
	 * @return the question that was removed
	 * @throws PortalException if a question with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.Question deleteQuestion(
			long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteQuestion(questionId);
	}

	/**
	 * Deletes the question from the database. Also notifies the appropriate model listeners.
	 *
	 * @param question the question
	 * @return the question that was removed
	 */
	public static com.ecoit.qa.service.model.Question deleteQuestion(
		com.ecoit.qa.service.model.Question question) {

		return getService().deleteQuestion(question);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.QuestionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.QuestionModelImpl</code>.
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

	public static com.ecoit.qa.service.model.Question fetchQuestion(
		long questionId) {

		return getService().fetchQuestion(questionId);
	}

	/**
	 * Returns the question matching the UUID and group.
	 *
	 * @param uuid the question's UUID
	 * @param groupId the primary key of the group
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	public static com.ecoit.qa.service.model.Question
		fetchQuestionByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchQuestionByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.ecoit.qa.service.model.Question>
			getAllQuestions(
				long groupId, String locale, long categoryId, String searchKey,
				int start, int limit, int status)
		throws Exception {

		return getService().getAllQuestions(
			groupId, locale, categoryId, searchKey, start, limit, status);
	}

	public static java.util.List<com.ecoit.qa.service.model.Question>
		getByCategoryId(long categoryId) {

		return getService().getByCategoryId(categoryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<com.ecoit.qa.service.model.Question>
			getMostPopular(long groupId, String locale, int status, int limit)
		throws Exception {

		return getService().getMostPopular(groupId, locale, status, limit);
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
	 * Returns the question with the primary key.
	 *
	 * @param questionId the primary key of the question
	 * @return the question
	 * @throws PortalException if a question with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.Question getQuestion(
			long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuestion(questionId);
	}

	public static com.ecoit.qa.service.model.Question getQuestionByStatusAndId(
		int status, long questionId) {

		return getService().getQuestionByStatusAndId(status, questionId);
	}

	/**
	 * Returns the question matching the UUID and group.
	 *
	 * @param uuid the question's UUID
	 * @param groupId the primary key of the group
	 * @return the matching question
	 * @throws PortalException if a matching question could not be found
	 */
	public static com.ecoit.qa.service.model.Question
			getQuestionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuestionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.QuestionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of questions
	 */
	public static java.util.List<com.ecoit.qa.service.model.Question>
		getQuestions(int start, int end) {

		return getService().getQuestions(start, end);
	}

	/**
	 * Returns all the questions matching the UUID and company.
	 *
	 * @param uuid the UUID of the questions
	 * @param companyId the primary key of the company
	 * @return the matching questions, or an empty list if no matches were found
	 */
	public static java.util.List<com.ecoit.qa.service.model.Question>
		getQuestionsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getQuestionsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of questions matching the UUID and company.
	 *
	 * @param uuid the UUID of the questions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching questions, or an empty list if no matches were found
	 */
	public static java.util.List<com.ecoit.qa.service.model.Question>
		getQuestionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ecoit.qa.service.model.Question> orderByComparator) {

		return getService().getQuestionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 */
	public static int getQuestionsCount() {
		return getService().getQuestionsCount();
	}

	/**
	 * Updates the question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param question the question
	 * @return the question that was updated
	 */
	public static com.ecoit.qa.service.model.Question updateQuestion(
		com.ecoit.qa.service.model.Question question) {

		return getService().updateQuestion(question);
	}

	public static void updateStatus(long questionId, int statusDoc, long userId)
		throws Exception {

		getService().updateStatus(questionId, statusDoc, userId);
	}

	public static void updateView(long questionId) {
		getService().updateView(questionId);
	}

	public static QuestionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<QuestionLocalService, QuestionLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuestionLocalService.class);

		ServiceTracker<QuestionLocalService, QuestionLocalService>
			serviceTracker =
				new ServiceTracker<QuestionLocalService, QuestionLocalService>(
					bundle.getBundleContext(), QuestionLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}