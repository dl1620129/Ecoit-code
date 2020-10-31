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

import com.ecoit.qa.service.exception.NoSuchAttachmentQuestionException;
import com.ecoit.qa.service.model.AttachmentQuestion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the attachment question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentQuestionUtil
 * @generated
 */
@ProviderType
public interface AttachmentQuestionPersistence
	extends BasePersistence<AttachmentQuestion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttachmentQuestionUtil} to access the attachment question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the attachment questions where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching attachment questions
	 */
	public java.util.List<AttachmentQuestion> findByAttachmentId(
		long attachmentId);

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
	public java.util.List<AttachmentQuestion> findByAttachmentId(
		long attachmentId, int start, int end);

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
	public java.util.List<AttachmentQuestion> findByAttachmentId(
		long attachmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
			orderByComparator);

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
	public java.util.List<AttachmentQuestion> findByAttachmentId(
		long attachmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	public AttachmentQuestion findByAttachmentId_First(
			long attachmentId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
				orderByComparator)
		throws NoSuchAttachmentQuestionException;

	/**
	 * Returns the first attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	public AttachmentQuestion fetchByAttachmentId_First(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
			orderByComparator);

	/**
	 * Returns the last attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	public AttachmentQuestion findByAttachmentId_Last(
			long attachmentId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
				orderByComparator)
		throws NoSuchAttachmentQuestionException;

	/**
	 * Returns the last attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	public AttachmentQuestion fetchByAttachmentId_Last(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
			orderByComparator);

	/**
	 * Returns the attachment questions before and after the current attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentQuestionPK the primary key of the current attachment question
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment question
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	public AttachmentQuestion[] findByAttachmentId_PrevAndNext(
			AttachmentQuestionPK attachmentQuestionPK, long attachmentId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
				orderByComparator)
		throws NoSuchAttachmentQuestionException;

	/**
	 * Removes all the attachment questions where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 */
	public void removeByAttachmentId(long attachmentId);

	/**
	 * Returns the number of attachment questions where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching attachment questions
	 */
	public int countByAttachmentId(long attachmentId);

	/**
	 * Returns all the attachment questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching attachment questions
	 */
	public java.util.List<AttachmentQuestion> findByQuestionId(long questionId);

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
	public java.util.List<AttachmentQuestion> findByQuestionId(
		long questionId, int start, int end);

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
	public java.util.List<AttachmentQuestion> findByQuestionId(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
			orderByComparator);

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
	public java.util.List<AttachmentQuestion> findByQuestionId(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	public AttachmentQuestion findByQuestionId_First(
			long questionId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
				orderByComparator)
		throws NoSuchAttachmentQuestionException;

	/**
	 * Returns the first attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	public AttachmentQuestion fetchByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
			orderByComparator);

	/**
	 * Returns the last attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	public AttachmentQuestion findByQuestionId_Last(
			long questionId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
				orderByComparator)
		throws NoSuchAttachmentQuestionException;

	/**
	 * Returns the last attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	public AttachmentQuestion fetchByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
			orderByComparator);

	/**
	 * Returns the attachment questions before and after the current attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param attachmentQuestionPK the primary key of the current attachment question
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment question
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	public AttachmentQuestion[] findByQuestionId_PrevAndNext(
			AttachmentQuestionPK attachmentQuestionPK, long questionId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
				orderByComparator)
		throws NoSuchAttachmentQuestionException;

	/**
	 * Removes all the attachment questions where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 */
	public void removeByQuestionId(long questionId);

	/**
	 * Returns the number of attachment questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching attachment questions
	 */
	public int countByQuestionId(long questionId);

	/**
	 * Caches the attachment question in the entity cache if it is enabled.
	 *
	 * @param attachmentQuestion the attachment question
	 */
	public void cacheResult(AttachmentQuestion attachmentQuestion);

	/**
	 * Caches the attachment questions in the entity cache if it is enabled.
	 *
	 * @param attachmentQuestions the attachment questions
	 */
	public void cacheResult(
		java.util.List<AttachmentQuestion> attachmentQuestions);

	/**
	 * Creates a new attachment question with the primary key. Does not add the attachment question to the database.
	 *
	 * @param attachmentQuestionPK the primary key for the new attachment question
	 * @return the new attachment question
	 */
	public AttachmentQuestion create(AttachmentQuestionPK attachmentQuestionPK);

	/**
	 * Removes the attachment question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentQuestionPK the primary key of the attachment question
	 * @return the attachment question that was removed
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	public AttachmentQuestion remove(AttachmentQuestionPK attachmentQuestionPK)
		throws NoSuchAttachmentQuestionException;

	public AttachmentQuestion updateImpl(AttachmentQuestion attachmentQuestion);

	/**
	 * Returns the attachment question with the primary key or throws a <code>NoSuchAttachmentQuestionException</code> if it could not be found.
	 *
	 * @param attachmentQuestionPK the primary key of the attachment question
	 * @return the attachment question
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	public AttachmentQuestion findByPrimaryKey(
			AttachmentQuestionPK attachmentQuestionPK)
		throws NoSuchAttachmentQuestionException;

	/**
	 * Returns the attachment question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentQuestionPK the primary key of the attachment question
	 * @return the attachment question, or <code>null</code> if a attachment question with the primary key could not be found
	 */
	public AttachmentQuestion fetchByPrimaryKey(
		AttachmentQuestionPK attachmentQuestionPK);

	/**
	 * Returns all the attachment questions.
	 *
	 * @return the attachment questions
	 */
	public java.util.List<AttachmentQuestion> findAll();

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
	public java.util.List<AttachmentQuestion> findAll(int start, int end);

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
	public java.util.List<AttachmentQuestion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
			orderByComparator);

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
	public java.util.List<AttachmentQuestion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentQuestion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the attachment questions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of attachment questions.
	 *
	 * @return the number of attachment questions
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}