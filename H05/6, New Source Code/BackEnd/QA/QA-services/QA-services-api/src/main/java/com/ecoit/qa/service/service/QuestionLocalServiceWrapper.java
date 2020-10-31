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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link QuestionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuestionLocalService
 * @generated
 */
public class QuestionLocalServiceWrapper
	implements QuestionLocalService, ServiceWrapper<QuestionLocalService> {

	public QuestionLocalServiceWrapper(
		QuestionLocalService questionLocalService) {

		_questionLocalService = questionLocalService;
	}

	/**
	 * Adds the question to the database. Also notifies the appropriate model listeners.
	 *
	 * @param question the question
	 * @return the question that was added
	 */
	@Override
	public com.ecoit.qa.service.model.Question addQuestion(
		com.ecoit.qa.service.model.Question question) {

		return _questionLocalService.addQuestion(question);
	}

	@Override
	public int countByCategoryId(long categoryId) {
		return _questionLocalService.countByCategoryId(categoryId);
	}

	@Override
	public int countByStatus(int status, long groupId, String locale) {
		return _questionLocalService.countByStatus(status, groupId, locale);
	}

	@Override
	public int countQuestions(
			long groupId, String locale, long categoryId, String searchKey,
			int status)
		throws Exception {

		return _questionLocalService.countQuestions(
			groupId, locale, categoryId, searchKey, status);
	}

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param questionId the primary key for the new question
	 * @return the new question
	 */
	@Override
	public com.ecoit.qa.service.model.Question createQuestion(long questionId) {
		return _questionLocalService.createQuestion(questionId);
	}

	@Override
	public com.ecoit.qa.service.model.Question createUpdateQuestion(
			long groupId, String locale, long userId, long questionId,
			String title, String email, String content, String phoneNumber,
			String address, java.util.List<Long> attachmentIdsList,
			long categoryId, String name, int status)
		throws Exception {

		return _questionLocalService.createUpdateQuestion(
			groupId, locale, userId, questionId, title, email, content,
			phoneNumber, address, attachmentIdsList, categoryId, name, status);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _questionLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the question
	 * @return the question that was removed
	 * @throws PortalException if a question with the primary key could not be found
	 */
	@Override
	public com.ecoit.qa.service.model.Question deleteQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _questionLocalService.deleteQuestion(questionId);
	}

	/**
	 * Deletes the question from the database. Also notifies the appropriate model listeners.
	 *
	 * @param question the question
	 * @return the question that was removed
	 */
	@Override
	public com.ecoit.qa.service.model.Question deleteQuestion(
		com.ecoit.qa.service.model.Question question) {

		return _questionLocalService.deleteQuestion(question);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _questionLocalService.dynamicQuery();
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

		return _questionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _questionLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _questionLocalService.dynamicQuery(
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

		return _questionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _questionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.qa.service.model.Question fetchQuestion(long questionId) {
		return _questionLocalService.fetchQuestion(questionId);
	}

	/**
	 * Returns the question matching the UUID and group.
	 *
	 * @param uuid the question's UUID
	 * @param groupId the primary key of the group
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public com.ecoit.qa.service.model.Question fetchQuestionByUuidAndGroupId(
		String uuid, long groupId) {

		return _questionLocalService.fetchQuestionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _questionLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.qa.service.model.Question> getAllQuestions(
			long groupId, String locale, long categoryId, String searchKey,
			int start, int limit, int status)
		throws Exception {

		return _questionLocalService.getAllQuestions(
			groupId, locale, categoryId, searchKey, start, limit, status);
	}

	@Override
	public java.util.List<com.ecoit.qa.service.model.Question> getByCategoryId(
		long categoryId) {

		return _questionLocalService.getByCategoryId(categoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _questionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _questionLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.qa.service.model.Question> getMostPopular(
			long groupId, String locale, int status, int limit)
		throws Exception {

		return _questionLocalService.getMostPopular(
			groupId, locale, status, limit);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _questionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _questionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the question with the primary key.
	 *
	 * @param questionId the primary key of the question
	 * @return the question
	 * @throws PortalException if a question with the primary key could not be found
	 */
	@Override
	public com.ecoit.qa.service.model.Question getQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _questionLocalService.getQuestion(questionId);
	}

	@Override
	public com.ecoit.qa.service.model.Question getQuestionByStatusAndId(
		int status, long questionId) {

		return _questionLocalService.getQuestionByStatusAndId(
			status, questionId);
	}

	/**
	 * Returns the question matching the UUID and group.
	 *
	 * @param uuid the question's UUID
	 * @param groupId the primary key of the group
	 * @return the matching question
	 * @throws PortalException if a matching question could not be found
	 */
	@Override
	public com.ecoit.qa.service.model.Question getQuestionByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _questionLocalService.getQuestionByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ecoit.qa.service.model.Question> getQuestions(
		int start, int end) {

		return _questionLocalService.getQuestions(start, end);
	}

	/**
	 * Returns all the questions matching the UUID and company.
	 *
	 * @param uuid the UUID of the questions
	 * @param companyId the primary key of the company
	 * @return the matching questions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ecoit.qa.service.model.Question>
		getQuestionsByUuidAndCompanyId(String uuid, long companyId) {

		return _questionLocalService.getQuestionsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.ecoit.qa.service.model.Question>
		getQuestionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ecoit.qa.service.model.Question> orderByComparator) {

		return _questionLocalService.getQuestionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 */
	@Override
	public int getQuestionsCount() {
		return _questionLocalService.getQuestionsCount();
	}

	/**
	 * Updates the question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param question the question
	 * @return the question that was updated
	 */
	@Override
	public com.ecoit.qa.service.model.Question updateQuestion(
		com.ecoit.qa.service.model.Question question) {

		return _questionLocalService.updateQuestion(question);
	}

	@Override
	public void updateStatus(long questionId, int statusDoc, long userId)
		throws Exception {

		_questionLocalService.updateStatus(questionId, statusDoc, userId);
	}

	@Override
	public void updateView(long questionId) {
		_questionLocalService.updateView(questionId);
	}

	@Override
	public QuestionLocalService getWrappedService() {
		return _questionLocalService;
	}

	@Override
	public void setWrappedService(QuestionLocalService questionLocalService) {
		_questionLocalService = questionLocalService;
	}

	private QuestionLocalService _questionLocalService;

}