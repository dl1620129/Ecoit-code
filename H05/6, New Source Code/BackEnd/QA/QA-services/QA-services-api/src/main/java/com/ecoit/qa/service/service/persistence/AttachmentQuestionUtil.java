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

package com.ecoit.qa.service.service.persistence;

import com.ecoit.qa.service.model.AttachmentQuestion;

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
 * The persistence utility for the attachment question service. This utility wraps <code>com.ecoit.qa.service.service.persistence.impl.AttachmentQuestionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentQuestionPersistence
 * @generated
 */
public class AttachmentQuestionUtil {

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
	public static void clearCache(AttachmentQuestion attachmentQuestion) {
		getPersistence().clearCache(attachmentQuestion);
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
	public static Map<Serializable, AttachmentQuestion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AttachmentQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AttachmentQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AttachmentQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AttachmentQuestion update(
		AttachmentQuestion attachmentQuestion) {

		return getPersistence().update(attachmentQuestion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AttachmentQuestion update(
		AttachmentQuestion attachmentQuestion, ServiceContext serviceContext) {

		return getPersistence().update(attachmentQuestion, serviceContext);
	}

	/**
	 * Returns all the attachment questions where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching attachment questions
	 */
	public static List<AttachmentQuestion> findByAttachmentId(
		long attachmentId) {

		return getPersistence().findByAttachmentId(attachmentId);
	}

	/**
	 * Returns a range of all the attachment questions where attachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentQuestionModelImpl</code>.
	 * </p>
	 *
	 * @param attachmentId the attachment ID
	 * @param start the lower bound of the range of attachment questions
	 * @param end the upper bound of the range of attachment questions (not inclusive)
	 * @return the range of matching attachment questions
	 */
	public static List<AttachmentQuestion> findByAttachmentId(
		long attachmentId, int start, int end) {

		return getPersistence().findByAttachmentId(attachmentId, start, end);
	}

	/**
	 * Returns an ordered range of all the attachment questions where attachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentQuestionModelImpl</code>.
	 * </p>
	 *
	 * @param attachmentId the attachment ID
	 * @param start the lower bound of the range of attachment questions
	 * @param end the upper bound of the range of attachment questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachment questions
	 */
	public static List<AttachmentQuestion> findByAttachmentId(
		long attachmentId, int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return getPersistence().findByAttachmentId(
			attachmentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachment questions where attachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentQuestionModelImpl</code>.
	 * </p>
	 *
	 * @param attachmentId the attachment ID
	 * @param start the lower bound of the range of attachment questions
	 * @param end the upper bound of the range of attachment questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachment questions
	 */
	public static List<AttachmentQuestion> findByAttachmentId(
		long attachmentId, int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAttachmentId(
			attachmentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	public static AttachmentQuestion findByAttachmentId_First(
			long attachmentId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchAttachmentQuestionException {

		return getPersistence().findByAttachmentId_First(
			attachmentId, orderByComparator);
	}

	/**
	 * Returns the first attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	public static AttachmentQuestion fetchByAttachmentId_First(
		long attachmentId,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return getPersistence().fetchByAttachmentId_First(
			attachmentId, orderByComparator);
	}

	/**
	 * Returns the last attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	public static AttachmentQuestion findByAttachmentId_Last(
			long attachmentId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchAttachmentQuestionException {

		return getPersistence().findByAttachmentId_Last(
			attachmentId, orderByComparator);
	}

	/**
	 * Returns the last attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	public static AttachmentQuestion fetchByAttachmentId_Last(
		long attachmentId,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return getPersistence().fetchByAttachmentId_Last(
			attachmentId, orderByComparator);
	}

	/**
	 * Returns the attachment questions before and after the current attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentQuestionPK the primary key of the current attachment question
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment question
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	public static AttachmentQuestion[] findByAttachmentId_PrevAndNext(
			AttachmentQuestionPK attachmentQuestionPK, long attachmentId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchAttachmentQuestionException {

		return getPersistence().findByAttachmentId_PrevAndNext(
			attachmentQuestionPK, attachmentId, orderByComparator);
	}

	/**
	 * Removes all the attachment questions where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 */
	public static void removeByAttachmentId(long attachmentId) {
		getPersistence().removeByAttachmentId(attachmentId);
	}

	/**
	 * Returns the number of attachment questions where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching attachment questions
	 */
	public static int countByAttachmentId(long attachmentId) {
		return getPersistence().countByAttachmentId(attachmentId);
	}

	/**
	 * Returns all the attachment questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching attachment questions
	 */
	public static List<AttachmentQuestion> findByQuestionId(long questionId) {
		return getPersistence().findByQuestionId(questionId);
	}

	/**
	 * Returns a range of all the attachment questions where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentQuestionModelImpl</code>.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of attachment questions
	 * @param end the upper bound of the range of attachment questions (not inclusive)
	 * @return the range of matching attachment questions
	 */
	public static List<AttachmentQuestion> findByQuestionId(
		long questionId, int start, int end) {

		return getPersistence().findByQuestionId(questionId, start, end);
	}

	/**
	 * Returns an ordered range of all the attachment questions where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentQuestionModelImpl</code>.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of attachment questions
	 * @param end the upper bound of the range of attachment questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachment questions
	 */
	public static List<AttachmentQuestion> findByQuestionId(
		long questionId, int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return getPersistence().findByQuestionId(
			questionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachment questions where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentQuestionModelImpl</code>.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of attachment questions
	 * @param end the upper bound of the range of attachment questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachment questions
	 */
	public static List<AttachmentQuestion> findByQuestionId(
		long questionId, int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuestionId(
			questionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	public static AttachmentQuestion findByQuestionId_First(
			long questionId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchAttachmentQuestionException {

		return getPersistence().findByQuestionId_First(
			questionId, orderByComparator);
	}

	/**
	 * Returns the first attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	public static AttachmentQuestion fetchByQuestionId_First(
		long questionId,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return getPersistence().fetchByQuestionId_First(
			questionId, orderByComparator);
	}

	/**
	 * Returns the last attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	public static AttachmentQuestion findByQuestionId_Last(
			long questionId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchAttachmentQuestionException {

		return getPersistence().findByQuestionId_Last(
			questionId, orderByComparator);
	}

	/**
	 * Returns the last attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	public static AttachmentQuestion fetchByQuestionId_Last(
		long questionId,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return getPersistence().fetchByQuestionId_Last(
			questionId, orderByComparator);
	}

	/**
	 * Returns the attachment questions before and after the current attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param attachmentQuestionPK the primary key of the current attachment question
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment question
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	public static AttachmentQuestion[] findByQuestionId_PrevAndNext(
			AttachmentQuestionPK attachmentQuestionPK, long questionId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchAttachmentQuestionException {

		return getPersistence().findByQuestionId_PrevAndNext(
			attachmentQuestionPK, questionId, orderByComparator);
	}

	/**
	 * Removes all the attachment questions where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 */
	public static void removeByQuestionId(long questionId) {
		getPersistence().removeByQuestionId(questionId);
	}

	/**
	 * Returns the number of attachment questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching attachment questions
	 */
	public static int countByQuestionId(long questionId) {
		return getPersistence().countByQuestionId(questionId);
	}

	/**
	 * Caches the attachment question in the entity cache if it is enabled.
	 *
	 * @param attachmentQuestion the attachment question
	 */
	public static void cacheResult(AttachmentQuestion attachmentQuestion) {
		getPersistence().cacheResult(attachmentQuestion);
	}

	/**
	 * Caches the attachment questions in the entity cache if it is enabled.
	 *
	 * @param attachmentQuestions the attachment questions
	 */
	public static void cacheResult(
		List<AttachmentQuestion> attachmentQuestions) {

		getPersistence().cacheResult(attachmentQuestions);
	}

	/**
	 * Creates a new attachment question with the primary key. Does not add the attachment question to the database.
	 *
	 * @param attachmentQuestionPK the primary key for the new attachment question
	 * @return the new attachment question
	 */
	public static AttachmentQuestion create(
		AttachmentQuestionPK attachmentQuestionPK) {

		return getPersistence().create(attachmentQuestionPK);
	}

	/**
	 * Removes the attachment question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentQuestionPK the primary key of the attachment question
	 * @return the attachment question that was removed
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	public static AttachmentQuestion remove(
			AttachmentQuestionPK attachmentQuestionPK)
		throws com.ecoit.qa.service.exception.
			NoSuchAttachmentQuestionException {

		return getPersistence().remove(attachmentQuestionPK);
	}

	public static AttachmentQuestion updateImpl(
		AttachmentQuestion attachmentQuestion) {

		return getPersistence().updateImpl(attachmentQuestion);
	}

	/**
	 * Returns the attachment question with the primary key or throws a <code>NoSuchAttachmentQuestionException</code> if it could not be found.
	 *
	 * @param attachmentQuestionPK the primary key of the attachment question
	 * @return the attachment question
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	public static AttachmentQuestion findByPrimaryKey(
			AttachmentQuestionPK attachmentQuestionPK)
		throws com.ecoit.qa.service.exception.
			NoSuchAttachmentQuestionException {

		return getPersistence().findByPrimaryKey(attachmentQuestionPK);
	}

	/**
	 * Returns the attachment question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentQuestionPK the primary key of the attachment question
	 * @return the attachment question, or <code>null</code> if a attachment question with the primary key could not be found
	 */
	public static AttachmentQuestion fetchByPrimaryKey(
		AttachmentQuestionPK attachmentQuestionPK) {

		return getPersistence().fetchByPrimaryKey(attachmentQuestionPK);
	}

	/**
	 * Returns all the attachment questions.
	 *
	 * @return the attachment questions
	 */
	public static List<AttachmentQuestion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the attachment questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentQuestionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment questions
	 * @param end the upper bound of the range of attachment questions (not inclusive)
	 * @return the range of attachment questions
	 */
	public static List<AttachmentQuestion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the attachment questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentQuestionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment questions
	 * @param end the upper bound of the range of attachment questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attachment questions
	 */
	public static List<AttachmentQuestion> findAll(
		int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachment questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentQuestionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment questions
	 * @param end the upper bound of the range of attachment questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attachment questions
	 */
	public static List<AttachmentQuestion> findAll(
		int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the attachment questions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of attachment questions.
	 *
	 * @return the number of attachment questions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static AttachmentQuestionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AttachmentQuestionPersistence, AttachmentQuestionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AttachmentQuestionPersistence.class);

		ServiceTracker
			<AttachmentQuestionPersistence, AttachmentQuestionPersistence>
				serviceTracker =
					new ServiceTracker
						<AttachmentQuestionPersistence,
						 AttachmentQuestionPersistence>(
							 bundle.getBundleContext(),
							 AttachmentQuestionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}