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

package com.ecoit.qa.service.service.persistence.impl;

import com.ecoit.qa.service.exception.NoSuchAttachmentQuestionException;
import com.ecoit.qa.service.model.AttachmentQuestion;
import com.ecoit.qa.service.model.impl.AttachmentQuestionImpl;
import com.ecoit.qa.service.model.impl.AttachmentQuestionModelImpl;
import com.ecoit.qa.service.service.persistence.AttachmentQuestionPK;
import com.ecoit.qa.service.service.persistence.AttachmentQuestionPersistence;
import com.ecoit.qa.service.service.persistence.impl.constants.ecoit_qaPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the attachment question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AttachmentQuestionPersistence.class)
public class AttachmentQuestionPersistenceImpl
	extends BasePersistenceImpl<AttachmentQuestion>
	implements AttachmentQuestionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AttachmentQuestionUtil</code> to access the attachment question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AttachmentQuestionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByAttachmentId;
	private FinderPath _finderPathWithoutPaginationFindByAttachmentId;
	private FinderPath _finderPathCountByAttachmentId;

	/**
	 * Returns all the attachment questions where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching attachment questions
	 */
	@Override
	public List<AttachmentQuestion> findByAttachmentId(long attachmentId) {
		return findByAttachmentId(
			attachmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AttachmentQuestion> findByAttachmentId(
		long attachmentId, int start, int end) {

		return findByAttachmentId(attachmentId, start, end, null);
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
	@Override
	public List<AttachmentQuestion> findByAttachmentId(
		long attachmentId, int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return findByAttachmentId(
			attachmentId, start, end, orderByComparator, true);
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
	@Override
	public List<AttachmentQuestion> findByAttachmentId(
		long attachmentId, int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAttachmentId;
				finderArgs = new Object[] {attachmentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAttachmentId;
			finderArgs = new Object[] {
				attachmentId, start, end, orderByComparator
			};
		}

		List<AttachmentQuestion> list = null;

		if (useFinderCache) {
			list = (List<AttachmentQuestion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AttachmentQuestion attachmentQuestion : list) {
					if (attachmentId != attachmentQuestion.getAttachmentId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ATTACHMENTQUESTION_WHERE);

			query.append(_FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(AttachmentQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

				list = (List<AttachmentQuestion>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	@Override
	public AttachmentQuestion findByAttachmentId_First(
			long attachmentId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws NoSuchAttachmentQuestionException {

		AttachmentQuestion attachmentQuestion = fetchByAttachmentId_First(
			attachmentId, orderByComparator);

		if (attachmentQuestion != null) {
			return attachmentQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attachmentId=");
		msg.append(attachmentId);

		msg.append("}");

		throw new NoSuchAttachmentQuestionException(msg.toString());
	}

	/**
	 * Returns the first attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	@Override
	public AttachmentQuestion fetchByAttachmentId_First(
		long attachmentId,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		List<AttachmentQuestion> list = findByAttachmentId(
			attachmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	@Override
	public AttachmentQuestion findByAttachmentId_Last(
			long attachmentId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws NoSuchAttachmentQuestionException {

		AttachmentQuestion attachmentQuestion = fetchByAttachmentId_Last(
			attachmentId, orderByComparator);

		if (attachmentQuestion != null) {
			return attachmentQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attachmentId=");
		msg.append(attachmentId);

		msg.append("}");

		throw new NoSuchAttachmentQuestionException(msg.toString());
	}

	/**
	 * Returns the last attachment question in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	@Override
	public AttachmentQuestion fetchByAttachmentId_Last(
		long attachmentId,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		int count = countByAttachmentId(attachmentId);

		if (count == 0) {
			return null;
		}

		List<AttachmentQuestion> list = findByAttachmentId(
			attachmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AttachmentQuestion[] findByAttachmentId_PrevAndNext(
			AttachmentQuestionPK attachmentQuestionPK, long attachmentId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws NoSuchAttachmentQuestionException {

		AttachmentQuestion attachmentQuestion = findByPrimaryKey(
			attachmentQuestionPK);

		Session session = null;

		try {
			session = openSession();

			AttachmentQuestion[] array = new AttachmentQuestionImpl[3];

			array[0] = getByAttachmentId_PrevAndNext(
				session, attachmentQuestion, attachmentId, orderByComparator,
				true);

			array[1] = attachmentQuestion;

			array[2] = getByAttachmentId_PrevAndNext(
				session, attachmentQuestion, attachmentId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AttachmentQuestion getByAttachmentId_PrevAndNext(
		Session session, AttachmentQuestion attachmentQuestion,
		long attachmentId,
		OrderByComparator<AttachmentQuestion> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTACHMENTQUESTION_WHERE);

		query.append(_FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AttachmentQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(attachmentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						attachmentQuestion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AttachmentQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachment questions where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 */
	@Override
	public void removeByAttachmentId(long attachmentId) {
		for (AttachmentQuestion attachmentQuestion :
				findByAttachmentId(
					attachmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(attachmentQuestion);
		}
	}

	/**
	 * Returns the number of attachment questions where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching attachment questions
	 */
	@Override
	public int countByAttachmentId(long attachmentId) {
		FinderPath finderPath = _finderPathCountByAttachmentId;

		Object[] finderArgs = new Object[] {attachmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ATTACHMENTQUESTION_WHERE);

			query.append(_FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2 =
		"attachmentQuestion.id.attachmentId = ?";

	private FinderPath _finderPathWithPaginationFindByQuestionId;
	private FinderPath _finderPathWithoutPaginationFindByQuestionId;
	private FinderPath _finderPathCountByQuestionId;

	/**
	 * Returns all the attachment questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching attachment questions
	 */
	@Override
	public List<AttachmentQuestion> findByQuestionId(long questionId) {
		return findByQuestionId(
			questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AttachmentQuestion> findByQuestionId(
		long questionId, int start, int end) {

		return findByQuestionId(questionId, start, end, null);
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
	@Override
	public List<AttachmentQuestion> findByQuestionId(
		long questionId, int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return findByQuestionId(
			questionId, start, end, orderByComparator, true);
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
	@Override
	public List<AttachmentQuestion> findByQuestionId(
		long questionId, int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByQuestionId;
				finderArgs = new Object[] {questionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByQuestionId;
			finderArgs = new Object[] {
				questionId, start, end, orderByComparator
			};
		}

		List<AttachmentQuestion> list = null;

		if (useFinderCache) {
			list = (List<AttachmentQuestion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AttachmentQuestion attachmentQuestion : list) {
					if (questionId != attachmentQuestion.getQuestionId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ATTACHMENTQUESTION_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(AttachmentQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				list = (List<AttachmentQuestion>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	@Override
	public AttachmentQuestion findByQuestionId_First(
			long questionId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws NoSuchAttachmentQuestionException {

		AttachmentQuestion attachmentQuestion = fetchByQuestionId_First(
			questionId, orderByComparator);

		if (attachmentQuestion != null) {
			return attachmentQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchAttachmentQuestionException(msg.toString());
	}

	/**
	 * Returns the first attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	@Override
	public AttachmentQuestion fetchByQuestionId_First(
		long questionId,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		List<AttachmentQuestion> list = findByQuestionId(
			questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question
	 * @throws NoSuchAttachmentQuestionException if a matching attachment question could not be found
	 */
	@Override
	public AttachmentQuestion findByQuestionId_Last(
			long questionId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws NoSuchAttachmentQuestionException {

		AttachmentQuestion attachmentQuestion = fetchByQuestionId_Last(
			questionId, orderByComparator);

		if (attachmentQuestion != null) {
			return attachmentQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchAttachmentQuestionException(msg.toString());
	}

	/**
	 * Returns the last attachment question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment question, or <code>null</code> if a matching attachment question could not be found
	 */
	@Override
	public AttachmentQuestion fetchByQuestionId_Last(
		long questionId,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		int count = countByQuestionId(questionId);

		if (count == 0) {
			return null;
		}

		List<AttachmentQuestion> list = findByQuestionId(
			questionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AttachmentQuestion[] findByQuestionId_PrevAndNext(
			AttachmentQuestionPK attachmentQuestionPK, long questionId,
			OrderByComparator<AttachmentQuestion> orderByComparator)
		throws NoSuchAttachmentQuestionException {

		AttachmentQuestion attachmentQuestion = findByPrimaryKey(
			attachmentQuestionPK);

		Session session = null;

		try {
			session = openSession();

			AttachmentQuestion[] array = new AttachmentQuestionImpl[3];

			array[0] = getByQuestionId_PrevAndNext(
				session, attachmentQuestion, questionId, orderByComparator,
				true);

			array[1] = attachmentQuestion;

			array[2] = getByQuestionId_PrevAndNext(
				session, attachmentQuestion, questionId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AttachmentQuestion getByQuestionId_PrevAndNext(
		Session session, AttachmentQuestion attachmentQuestion, long questionId,
		OrderByComparator<AttachmentQuestion> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTACHMENTQUESTION_WHERE);

		query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AttachmentQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(questionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						attachmentQuestion)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AttachmentQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachment questions where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 */
	@Override
	public void removeByQuestionId(long questionId) {
		for (AttachmentQuestion attachmentQuestion :
				findByQuestionId(
					questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(attachmentQuestion);
		}
	}

	/**
	 * Returns the number of attachment questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching attachment questions
	 */
	@Override
	public int countByQuestionId(long questionId) {
		FinderPath finderPath = _finderPathCountByQuestionId;

		Object[] finderArgs = new Object[] {questionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ATTACHMENTQUESTION_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 =
		"attachmentQuestion.id.questionId = ?";

	public AttachmentQuestionPersistenceImpl() {
		setModelClass(AttachmentQuestion.class);

		setModelImplClass(AttachmentQuestionImpl.class);
		setModelPKClass(AttachmentQuestionPK.class);
	}

	/**
	 * Caches the attachment question in the entity cache if it is enabled.
	 *
	 * @param attachmentQuestion the attachment question
	 */
	@Override
	public void cacheResult(AttachmentQuestion attachmentQuestion) {
		entityCache.putResult(
			entityCacheEnabled, AttachmentQuestionImpl.class,
			attachmentQuestion.getPrimaryKey(), attachmentQuestion);

		attachmentQuestion.resetOriginalValues();
	}

	/**
	 * Caches the attachment questions in the entity cache if it is enabled.
	 *
	 * @param attachmentQuestions the attachment questions
	 */
	@Override
	public void cacheResult(List<AttachmentQuestion> attachmentQuestions) {
		for (AttachmentQuestion attachmentQuestion : attachmentQuestions) {
			if (entityCache.getResult(
					entityCacheEnabled, AttachmentQuestionImpl.class,
					attachmentQuestion.getPrimaryKey()) == null) {

				cacheResult(attachmentQuestion);
			}
			else {
				attachmentQuestion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attachment questions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AttachmentQuestionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attachment question.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttachmentQuestion attachmentQuestion) {
		entityCache.removeResult(
			entityCacheEnabled, AttachmentQuestionImpl.class,
			attachmentQuestion.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AttachmentQuestion> attachmentQuestions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AttachmentQuestion attachmentQuestion : attachmentQuestions) {
			entityCache.removeResult(
				entityCacheEnabled, AttachmentQuestionImpl.class,
				attachmentQuestion.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, AttachmentQuestionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new attachment question with the primary key. Does not add the attachment question to the database.
	 *
	 * @param attachmentQuestionPK the primary key for the new attachment question
	 * @return the new attachment question
	 */
	@Override
	public AttachmentQuestion create(
		AttachmentQuestionPK attachmentQuestionPK) {

		AttachmentQuestion attachmentQuestion = new AttachmentQuestionImpl();

		attachmentQuestion.setNew(true);
		attachmentQuestion.setPrimaryKey(attachmentQuestionPK);

		return attachmentQuestion;
	}

	/**
	 * Removes the attachment question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentQuestionPK the primary key of the attachment question
	 * @return the attachment question that was removed
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	@Override
	public AttachmentQuestion remove(AttachmentQuestionPK attachmentQuestionPK)
		throws NoSuchAttachmentQuestionException {

		return remove((Serializable)attachmentQuestionPK);
	}

	/**
	 * Removes the attachment question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attachment question
	 * @return the attachment question that was removed
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	@Override
	public AttachmentQuestion remove(Serializable primaryKey)
		throws NoSuchAttachmentQuestionException {

		Session session = null;

		try {
			session = openSession();

			AttachmentQuestion attachmentQuestion =
				(AttachmentQuestion)session.get(
					AttachmentQuestionImpl.class, primaryKey);

			if (attachmentQuestion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttachmentQuestionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(attachmentQuestion);
		}
		catch (NoSuchAttachmentQuestionException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AttachmentQuestion removeImpl(
		AttachmentQuestion attachmentQuestion) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attachmentQuestion)) {
				attachmentQuestion = (AttachmentQuestion)session.get(
					AttachmentQuestionImpl.class,
					attachmentQuestion.getPrimaryKeyObj());
			}

			if (attachmentQuestion != null) {
				session.delete(attachmentQuestion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (attachmentQuestion != null) {
			clearCache(attachmentQuestion);
		}

		return attachmentQuestion;
	}

	@Override
	public AttachmentQuestion updateImpl(
		AttachmentQuestion attachmentQuestion) {

		boolean isNew = attachmentQuestion.isNew();

		if (!(attachmentQuestion instanceof AttachmentQuestionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(attachmentQuestion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					attachmentQuestion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in attachmentQuestion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AttachmentQuestion implementation " +
					attachmentQuestion.getClass());
		}

		AttachmentQuestionModelImpl attachmentQuestionModelImpl =
			(AttachmentQuestionModelImpl)attachmentQuestion;

		Session session = null;

		try {
			session = openSession();

			if (attachmentQuestion.isNew()) {
				session.save(attachmentQuestion);

				attachmentQuestion.setNew(false);
			}
			else {
				attachmentQuestion = (AttachmentQuestion)session.merge(
					attachmentQuestion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				attachmentQuestionModelImpl.getAttachmentId()
			};

			finderCache.removeResult(_finderPathCountByAttachmentId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAttachmentId, args);

			args = new Object[] {attachmentQuestionModelImpl.getQuestionId()};

			finderCache.removeResult(_finderPathCountByQuestionId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByQuestionId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((attachmentQuestionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAttachmentId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					attachmentQuestionModelImpl.getOriginalAttachmentId()
				};

				finderCache.removeResult(_finderPathCountByAttachmentId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAttachmentId, args);

				args = new Object[] {
					attachmentQuestionModelImpl.getAttachmentId()
				};

				finderCache.removeResult(_finderPathCountByAttachmentId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAttachmentId, args);
			}

			if ((attachmentQuestionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByQuestionId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					attachmentQuestionModelImpl.getOriginalQuestionId()
				};

				finderCache.removeResult(_finderPathCountByQuestionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByQuestionId, args);

				args = new Object[] {
					attachmentQuestionModelImpl.getQuestionId()
				};

				finderCache.removeResult(_finderPathCountByQuestionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByQuestionId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, AttachmentQuestionImpl.class,
			attachmentQuestion.getPrimaryKey(), attachmentQuestion, false);

		attachmentQuestion.resetOriginalValues();

		return attachmentQuestion;
	}

	/**
	 * Returns the attachment question with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attachment question
	 * @return the attachment question
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	@Override
	public AttachmentQuestion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttachmentQuestionException {

		AttachmentQuestion attachmentQuestion = fetchByPrimaryKey(primaryKey);

		if (attachmentQuestion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttachmentQuestionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return attachmentQuestion;
	}

	/**
	 * Returns the attachment question with the primary key or throws a <code>NoSuchAttachmentQuestionException</code> if it could not be found.
	 *
	 * @param attachmentQuestionPK the primary key of the attachment question
	 * @return the attachment question
	 * @throws NoSuchAttachmentQuestionException if a attachment question with the primary key could not be found
	 */
	@Override
	public AttachmentQuestion findByPrimaryKey(
			AttachmentQuestionPK attachmentQuestionPK)
		throws NoSuchAttachmentQuestionException {

		return findByPrimaryKey((Serializable)attachmentQuestionPK);
	}

	/**
	 * Returns the attachment question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentQuestionPK the primary key of the attachment question
	 * @return the attachment question, or <code>null</code> if a attachment question with the primary key could not be found
	 */
	@Override
	public AttachmentQuestion fetchByPrimaryKey(
		AttachmentQuestionPK attachmentQuestionPK) {

		return fetchByPrimaryKey((Serializable)attachmentQuestionPK);
	}

	/**
	 * Returns all the attachment questions.
	 *
	 * @return the attachment questions
	 */
	@Override
	public List<AttachmentQuestion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AttachmentQuestion> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AttachmentQuestion> findAll(
		int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AttachmentQuestion> findAll(
		int start, int end,
		OrderByComparator<AttachmentQuestion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AttachmentQuestion> list = null;

		if (useFinderCache) {
			list = (List<AttachmentQuestion>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ATTACHMENTQUESTION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTACHMENTQUESTION;

				sql = sql.concat(AttachmentQuestionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<AttachmentQuestion>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the attachment questions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AttachmentQuestion attachmentQuestion : findAll()) {
			remove(attachmentQuestion);
		}
	}

	/**
	 * Returns the number of attachment questions.
	 *
	 * @return the number of attachment questions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ATTACHMENTQUESTION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "attachmentQuestionPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ATTACHMENTQUESTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AttachmentQuestionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the attachment question persistence.
	 */
	@Activate
	public void activate() {
		AttachmentQuestionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AttachmentQuestionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			AttachmentQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			AttachmentQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByAttachmentId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			AttachmentQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAttachmentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAttachmentId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			AttachmentQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAttachmentId",
			new String[] {Long.class.getName()},
			AttachmentQuestionModelImpl.ATTACHMENTID_COLUMN_BITMASK);

		_finderPathCountByAttachmentId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttachmentId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByQuestionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			AttachmentQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuestionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByQuestionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			AttachmentQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuestionId",
			new String[] {Long.class.getName()},
			AttachmentQuestionModelImpl.QUESTIONID_COLUMN_BITMASK);

		_finderPathCountByQuestionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AttachmentQuestionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_qaPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.qa.service.model.AttachmentQuestion"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_qaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_qaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ATTACHMENTQUESTION =
		"SELECT attachmentQuestion FROM AttachmentQuestion attachmentQuestion";

	private static final String _SQL_SELECT_ATTACHMENTQUESTION_WHERE =
		"SELECT attachmentQuestion FROM AttachmentQuestion attachmentQuestion WHERE ";

	private static final String _SQL_COUNT_ATTACHMENTQUESTION =
		"SELECT COUNT(attachmentQuestion) FROM AttachmentQuestion attachmentQuestion";

	private static final String _SQL_COUNT_ATTACHMENTQUESTION_WHERE =
		"SELECT COUNT(attachmentQuestion) FROM AttachmentQuestion attachmentQuestion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "attachmentQuestion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AttachmentQuestion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AttachmentQuestion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AttachmentQuestionPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"attachmentId", "questionId"});

	static {
		try {
			Class.forName(ecoit_qaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}