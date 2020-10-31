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

import com.ecoit.qa.service.exception.NoSuchAttachmentAnswerException;
import com.ecoit.qa.service.model.AttachmentAnswer;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the attachment answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentAnswerUtil
 * @generated
 */
@ProviderType
public interface AttachmentAnswerPersistence
	extends BasePersistence<AttachmentAnswer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttachmentAnswerUtil} to access the attachment answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the attachment answers where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching attachment answers
	 */
	public java.util.List<AttachmentAnswer> findByAttachmentId(
		long attachmentId);

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
	public java.util.List<AttachmentAnswer> findByAttachmentId(
		long attachmentId, int start, int end);

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
	public java.util.List<AttachmentAnswer> findByAttachmentId(
		long attachmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
			orderByComparator);

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
	public java.util.List<AttachmentAnswer> findByAttachmentId(
		long attachmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	public AttachmentAnswer findByAttachmentId_First(
			long attachmentId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
				orderByComparator)
		throws NoSuchAttachmentAnswerException;

	/**
	 * Returns the first attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	public AttachmentAnswer fetchByAttachmentId_First(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
			orderByComparator);

	/**
	 * Returns the last attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	public AttachmentAnswer findByAttachmentId_Last(
			long attachmentId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
				orderByComparator)
		throws NoSuchAttachmentAnswerException;

	/**
	 * Returns the last attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	public AttachmentAnswer fetchByAttachmentId_Last(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
			orderByComparator);

	/**
	 * Returns the attachment answers before and after the current attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentAnswerPK the primary key of the current attachment answer
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment answer
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	public AttachmentAnswer[] findByAttachmentId_PrevAndNext(
			AttachmentAnswerPK attachmentAnswerPK, long attachmentId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
				orderByComparator)
		throws NoSuchAttachmentAnswerException;

	/**
	 * Removes all the attachment answers where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 */
	public void removeByAttachmentId(long attachmentId);

	/**
	 * Returns the number of attachment answers where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching attachment answers
	 */
	public int countByAttachmentId(long attachmentId);

	/**
	 * Returns all the attachment answers where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @return the matching attachment answers
	 */
	public java.util.List<AttachmentAnswer> findByAnswerId(long answerId);

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
	public java.util.List<AttachmentAnswer> findByAnswerId(
		long answerId, int start, int end);

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
	public java.util.List<AttachmentAnswer> findByAnswerId(
		long answerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
			orderByComparator);

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
	public java.util.List<AttachmentAnswer> findByAnswerId(
		long answerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	public AttachmentAnswer findByAnswerId_First(
			long answerId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
				orderByComparator)
		throws NoSuchAttachmentAnswerException;

	/**
	 * Returns the first attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	public AttachmentAnswer fetchByAnswerId_First(
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
			orderByComparator);

	/**
	 * Returns the last attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	public AttachmentAnswer findByAnswerId_Last(
			long answerId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
				orderByComparator)
		throws NoSuchAttachmentAnswerException;

	/**
	 * Returns the last attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	public AttachmentAnswer fetchByAnswerId_Last(
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
			orderByComparator);

	/**
	 * Returns the attachment answers before and after the current attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param attachmentAnswerPK the primary key of the current attachment answer
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment answer
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	public AttachmentAnswer[] findByAnswerId_PrevAndNext(
			AttachmentAnswerPK attachmentAnswerPK, long answerId,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
				orderByComparator)
		throws NoSuchAttachmentAnswerException;

	/**
	 * Removes all the attachment answers where answerId = &#63; from the database.
	 *
	 * @param answerId the answer ID
	 */
	public void removeByAnswerId(long answerId);

	/**
	 * Returns the number of attachment answers where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @return the number of matching attachment answers
	 */
	public int countByAnswerId(long answerId);

	/**
	 * Caches the attachment answer in the entity cache if it is enabled.
	 *
	 * @param attachmentAnswer the attachment answer
	 */
	public void cacheResult(AttachmentAnswer attachmentAnswer);

	/**
	 * Caches the attachment answers in the entity cache if it is enabled.
	 *
	 * @param attachmentAnswers the attachment answers
	 */
	public void cacheResult(java.util.List<AttachmentAnswer> attachmentAnswers);

	/**
	 * Creates a new attachment answer with the primary key. Does not add the attachment answer to the database.
	 *
	 * @param attachmentAnswerPK the primary key for the new attachment answer
	 * @return the new attachment answer
	 */
	public AttachmentAnswer create(AttachmentAnswerPK attachmentAnswerPK);

	/**
	 * Removes the attachment answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer that was removed
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	public AttachmentAnswer remove(AttachmentAnswerPK attachmentAnswerPK)
		throws NoSuchAttachmentAnswerException;

	public AttachmentAnswer updateImpl(AttachmentAnswer attachmentAnswer);

	/**
	 * Returns the attachment answer with the primary key or throws a <code>NoSuchAttachmentAnswerException</code> if it could not be found.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	public AttachmentAnswer findByPrimaryKey(
			AttachmentAnswerPK attachmentAnswerPK)
		throws NoSuchAttachmentAnswerException;

	/**
	 * Returns the attachment answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer, or <code>null</code> if a attachment answer with the primary key could not be found
	 */
	public AttachmentAnswer fetchByPrimaryKey(
		AttachmentAnswerPK attachmentAnswerPK);

	/**
	 * Returns all the attachment answers.
	 *
	 * @return the attachment answers
	 */
	public java.util.List<AttachmentAnswer> findAll();

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
	public java.util.List<AttachmentAnswer> findAll(int start, int end);

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
	public java.util.List<AttachmentAnswer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
			orderByComparator);

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
	public java.util.List<AttachmentAnswer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentAnswer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the attachment answers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of attachment answers.
	 *
	 * @return the number of attachment answers
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}