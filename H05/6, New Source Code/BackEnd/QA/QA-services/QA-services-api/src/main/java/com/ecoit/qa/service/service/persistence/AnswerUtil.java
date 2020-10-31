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

import com.ecoit.qa.service.model.Answer;

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
 * The persistence utility for the answer service. This utility wraps <code>com.ecoit.qa.service.service.persistence.impl.AnswerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnswerPersistence
 * @generated
 */
public class AnswerUtil {

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
	public static void clearCache(Answer answer) {
		getPersistence().clearCache(answer);
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
	public static Map<Serializable, Answer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Answer> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Answer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Answer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Answer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Answer update(Answer answer) {
		return getPersistence().update(answer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Answer update(Answer answer, ServiceContext serviceContext) {
		return getPersistence().update(answer, serviceContext);
	}

	/**
	 * Returns the answer where questionId = &#63; or throws a <code>NoSuchAnswerException</code> if it could not be found.
	 *
	 * @param questionId the question ID
	 * @return the matching answer
	 * @throws NoSuchAnswerException if a matching answer could not be found
	 */
	public static Answer findByQuestion(long questionId)
		throws com.ecoit.qa.service.exception.NoSuchAnswerException {

		return getPersistence().findByQuestion(questionId);
	}

	/**
	 * Returns the answer where questionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param questionId the question ID
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public static Answer fetchByQuestion(long questionId) {
		return getPersistence().fetchByQuestion(questionId);
	}

	/**
	 * Returns the answer where questionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param questionId the question ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public static Answer fetchByQuestion(
		long questionId, boolean useFinderCache) {

		return getPersistence().fetchByQuestion(questionId, useFinderCache);
	}

	/**
	 * Removes the answer where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @return the answer that was removed
	 */
	public static Answer removeByQuestion(long questionId)
		throws com.ecoit.qa.service.exception.NoSuchAnswerException {

		return getPersistence().removeByQuestion(questionId);
	}

	/**
	 * Returns the number of answers where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching answers
	 */
	public static int countByQuestion(long questionId) {
		return getPersistence().countByQuestion(questionId);
	}

	/**
	 * Caches the answer in the entity cache if it is enabled.
	 *
	 * @param answer the answer
	 */
	public static void cacheResult(Answer answer) {
		getPersistence().cacheResult(answer);
	}

	/**
	 * Caches the answers in the entity cache if it is enabled.
	 *
	 * @param answers the answers
	 */
	public static void cacheResult(List<Answer> answers) {
		getPersistence().cacheResult(answers);
	}

	/**
	 * Creates a new answer with the primary key. Does not add the answer to the database.
	 *
	 * @param answerId the primary key for the new answer
	 * @return the new answer
	 */
	public static Answer create(long answerId) {
		return getPersistence().create(answerId);
	}

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answerId the primary key of the answer
	 * @return the answer that was removed
	 * @throws NoSuchAnswerException if a answer with the primary key could not be found
	 */
	public static Answer remove(long answerId)
		throws com.ecoit.qa.service.exception.NoSuchAnswerException {

		return getPersistence().remove(answerId);
	}

	public static Answer updateImpl(Answer answer) {
		return getPersistence().updateImpl(answer);
	}

	/**
	 * Returns the answer with the primary key or throws a <code>NoSuchAnswerException</code> if it could not be found.
	 *
	 * @param answerId the primary key of the answer
	 * @return the answer
	 * @throws NoSuchAnswerException if a answer with the primary key could not be found
	 */
	public static Answer findByPrimaryKey(long answerId)
		throws com.ecoit.qa.service.exception.NoSuchAnswerException {

		return getPersistence().findByPrimaryKey(answerId);
	}

	/**
	 * Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answerId the primary key of the answer
	 * @return the answer, or <code>null</code> if a answer with the primary key could not be found
	 */
	public static Answer fetchByPrimaryKey(long answerId) {
		return getPersistence().fetchByPrimaryKey(answerId);
	}

	/**
	 * Returns all the answers.
	 *
	 * @return the answers
	 */
	public static List<Answer> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @return the range of answers
	 */
	public static List<Answer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of answers
	 */
	public static List<Answer> findAll(
		int start, int end, OrderByComparator<Answer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of answers
	 */
	public static List<Answer> findAll(
		int start, int end, OrderByComparator<Answer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the answers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of answers.
	 *
	 * @return the number of answers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AnswerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnswerPersistence, AnswerPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AnswerPersistence.class);

		ServiceTracker<AnswerPersistence, AnswerPersistence> serviceTracker =
			new ServiceTracker<AnswerPersistence, AnswerPersistence>(
				bundle.getBundleContext(), AnswerPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}