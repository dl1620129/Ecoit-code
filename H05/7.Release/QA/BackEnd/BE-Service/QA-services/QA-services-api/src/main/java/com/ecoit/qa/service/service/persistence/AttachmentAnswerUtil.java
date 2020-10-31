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

import com.ecoit.qa.service.model.AttachmentAnswer;

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
 * The persistence utility for the attachment answer service. This utility wraps <code>com.ecoit.qa.service.service.persistence.impl.AttachmentAnswerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentAnswerPersistence
 * @generated
 */
public class AttachmentAnswerUtil {

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
	public static void clearCache(AttachmentAnswer attachmentAnswer) {
		getPersistence().clearCache(attachmentAnswer);
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
	public static Map<Serializable, AttachmentAnswer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AttachmentAnswer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AttachmentAnswer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AttachmentAnswer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AttachmentAnswer update(AttachmentAnswer attachmentAnswer) {
		return getPersistence().update(attachmentAnswer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AttachmentAnswer update(
		AttachmentAnswer attachmentAnswer, ServiceContext serviceContext) {

		return getPersistence().update(attachmentAnswer, serviceContext);
	}

	/**
	 * Returns all the attachment answers where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching attachment answers
	 */
	public static List<AttachmentAnswer> findByAttachmentId(long attachmentId) {
		return getPersistence().findByAttachmentId(attachmentId);
	}

	/**
	 * Returns a range of all the attachment answers where attachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param attachmentId the attachment ID
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @return the range of matching attachment answers
	 */
	public static List<AttachmentAnswer> findByAttachmentId(
		long attachmentId, int start, int end) {

		return getPersistence().findByAttachmentId(attachmentId, start, end);
	}

	/**
	 * Returns an ordered range of all the attachment answers where attachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param attachmentId the attachment ID
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachment answers
	 */
	public static List<AttachmentAnswer> findByAttachmentId(
		long attachmentId, int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		return getPersistence().findByAttachmentId(
			attachmentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachment answers where attachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param attachmentId the attachment ID
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachment answers
	 */
	public static List<AttachmentAnswer> findByAttachmentId(
		long attachmentId, int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAttachmentId(
			attachmentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	public static AttachmentAnswer findByAttachmentId_First(
			long attachmentId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchAttachmentAnswerException {

		return getPersistence().findByAttachmentId_First(
			attachmentId, orderByComparator);
	}

	/**
	 * Returns the first attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	public static AttachmentAnswer fetchByAttachmentId_First(
		long attachmentId,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		return getPersistence().fetchByAttachmentId_First(
			attachmentId, orderByComparator);
	}

	/**
	 * Returns the last attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	public static AttachmentAnswer findByAttachmentId_Last(
			long attachmentId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchAttachmentAnswerException {

		return getPersistence().findByAttachmentId_Last(
			attachmentId, orderByComparator);
	}

	/**
	 * Returns the last attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	public static AttachmentAnswer fetchByAttachmentId_Last(
		long attachmentId,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		return getPersistence().fetchByAttachmentId_Last(
			attachmentId, orderByComparator);
	}

	/**
	 * Returns the attachment answers before and after the current attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentAnswerPK the primary key of the current attachment answer
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment answer
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	public static AttachmentAnswer[] findByAttachmentId_PrevAndNext(
			AttachmentAnswerPK attachmentAnswerPK, long attachmentId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchAttachmentAnswerException {

		return getPersistence().findByAttachmentId_PrevAndNext(
			attachmentAnswerPK, attachmentId, orderByComparator);
	}

	/**
	 * Removes all the attachment answers where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 */
	public static void removeByAttachmentId(long attachmentId) {
		getPersistence().removeByAttachmentId(attachmentId);
	}

	/**
	 * Returns the number of attachment answers where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching attachment answers
	 */
	public static int countByAttachmentId(long attachmentId) {
		return getPersistence().countByAttachmentId(attachmentId);
	}

	/**
	 * Returns all the attachment answers where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @return the matching attachment answers
	 */
	public static List<AttachmentAnswer> findByAnswerId(long answerId) {
		return getPersistence().findByAnswerId(answerId);
	}

	/**
	 * Returns a range of all the attachment answers where answerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @return the range of matching attachment answers
	 */
	public static List<AttachmentAnswer> findByAnswerId(
		long answerId, int start, int end) {

		return getPersistence().findByAnswerId(answerId, start, end);
	}

	/**
	 * Returns an ordered range of all the attachment answers where answerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachment answers
	 */
	public static List<AttachmentAnswer> findByAnswerId(
		long answerId, int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		return getPersistence().findByAnswerId(
			answerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachment answers where answerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachment answers
	 */
	public static List<AttachmentAnswer> findByAnswerId(
		long answerId, int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAnswerId(
			answerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	public static AttachmentAnswer findByAnswerId_First(
			long answerId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchAttachmentAnswerException {

		return getPersistence().findByAnswerId_First(
			answerId, orderByComparator);
	}

	/**
	 * Returns the first attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	public static AttachmentAnswer fetchByAnswerId_First(
		long answerId, OrderByComparator<AttachmentAnswer> orderByComparator) {

		return getPersistence().fetchByAnswerId_First(
			answerId, orderByComparator);
	}

	/**
	 * Returns the last attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	public static AttachmentAnswer findByAnswerId_Last(
			long answerId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchAttachmentAnswerException {

		return getPersistence().findByAnswerId_Last(
			answerId, orderByComparator);
	}

	/**
	 * Returns the last attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	public static AttachmentAnswer fetchByAnswerId_Last(
		long answerId, OrderByComparator<AttachmentAnswer> orderByComparator) {

		return getPersistence().fetchByAnswerId_Last(
			answerId, orderByComparator);
	}

	/**
	 * Returns the attachment answers before and after the current attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param attachmentAnswerPK the primary key of the current attachment answer
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment answer
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	public static AttachmentAnswer[] findByAnswerId_PrevAndNext(
			AttachmentAnswerPK attachmentAnswerPK, long answerId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchAttachmentAnswerException {

		return getPersistence().findByAnswerId_PrevAndNext(
			attachmentAnswerPK, answerId, orderByComparator);
	}

	/**
	 * Removes all the attachment answers where answerId = &#63; from the database.
	 *
	 * @param answerId the answer ID
	 */
	public static void removeByAnswerId(long answerId) {
		getPersistence().removeByAnswerId(answerId);
	}

	/**
	 * Returns the number of attachment answers where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @return the number of matching attachment answers
	 */
	public static int countByAnswerId(long answerId) {
		return getPersistence().countByAnswerId(answerId);
	}

	/**
	 * Caches the attachment answer in the entity cache if it is enabled.
	 *
	 * @param attachmentAnswer the attachment answer
	 */
	public static void cacheResult(AttachmentAnswer attachmentAnswer) {
		getPersistence().cacheResult(attachmentAnswer);
	}

	/**
	 * Caches the attachment answers in the entity cache if it is enabled.
	 *
	 * @param attachmentAnswers the attachment answers
	 */
	public static void cacheResult(List<AttachmentAnswer> attachmentAnswers) {
		getPersistence().cacheResult(attachmentAnswers);
	}

	/**
	 * Creates a new attachment answer with the primary key. Does not add the attachment answer to the database.
	 *
	 * @param attachmentAnswerPK the primary key for the new attachment answer
	 * @return the new attachment answer
	 */
	public static AttachmentAnswer create(
		AttachmentAnswerPK attachmentAnswerPK) {

		return getPersistence().create(attachmentAnswerPK);
	}

	/**
	 * Removes the attachment answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer that was removed
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	public static AttachmentAnswer remove(AttachmentAnswerPK attachmentAnswerPK)
		throws com.ecoit.qa.service.exception.NoSuchAttachmentAnswerException {

		return getPersistence().remove(attachmentAnswerPK);
	}

	public static AttachmentAnswer updateImpl(
		AttachmentAnswer attachmentAnswer) {

		return getPersistence().updateImpl(attachmentAnswer);
	}

	/**
	 * Returns the attachment answer with the primary key or throws a <code>NoSuchAttachmentAnswerException</code> if it could not be found.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	public static AttachmentAnswer findByPrimaryKey(
			AttachmentAnswerPK attachmentAnswerPK)
		throws com.ecoit.qa.service.exception.NoSuchAttachmentAnswerException {

		return getPersistence().findByPrimaryKey(attachmentAnswerPK);
	}

	/**
	 * Returns the attachment answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer, or <code>null</code> if a attachment answer with the primary key could not be found
	 */
	public static AttachmentAnswer fetchByPrimaryKey(
		AttachmentAnswerPK attachmentAnswerPK) {

		return getPersistence().fetchByPrimaryKey(attachmentAnswerPK);
	}

	/**
	 * Returns all the attachment answers.
	 *
	 * @return the attachment answers
	 */
	public static List<AttachmentAnswer> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the attachment answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @return the range of attachment answers
	 */
	public static List<AttachmentAnswer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the attachment answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attachment answers
	 */
	public static List<AttachmentAnswer> findAll(
		int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachment answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attachment answers
	 */
	public static List<AttachmentAnswer> findAll(
		int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the attachment answers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of attachment answers.
	 *
	 * @return the number of attachment answers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static AttachmentAnswerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AttachmentAnswerPersistence, AttachmentAnswerPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AttachmentAnswerPersistence.class);

		ServiceTracker<AttachmentAnswerPersistence, AttachmentAnswerPersistence>
			serviceTracker =
				new ServiceTracker
					<AttachmentAnswerPersistence, AttachmentAnswerPersistence>(
						bundle.getBundleContext(),
						AttachmentAnswerPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}