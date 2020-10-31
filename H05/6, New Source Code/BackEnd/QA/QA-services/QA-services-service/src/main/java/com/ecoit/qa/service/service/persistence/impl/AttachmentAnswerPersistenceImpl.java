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

import com.ecoit.qa.service.exception.NoSuchAttachmentAnswerException;
import com.ecoit.qa.service.model.AttachmentAnswer;
import com.ecoit.qa.service.model.impl.AttachmentAnswerImpl;
import com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl;
import com.ecoit.qa.service.service.persistence.AttachmentAnswerPK;
import com.ecoit.qa.service.service.persistence.AttachmentAnswerPersistence;
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
 * The persistence implementation for the attachment answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AttachmentAnswerPersistence.class)
public class AttachmentAnswerPersistenceImpl
	extends BasePersistenceImpl<AttachmentAnswer>
	implements AttachmentAnswerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AttachmentAnswerUtil</code> to access the attachment answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AttachmentAnswerImpl.class.getName();

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
	 * Returns all the attachment answers where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching attachment answers
	 */
	@Override
	public List<AttachmentAnswer> findByAttachmentId(long attachmentId) {
		return findByAttachmentId(
			attachmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AttachmentAnswer> findByAttachmentId(
		long attachmentId, int start, int end) {

		return findByAttachmentId(attachmentId, start, end, null);
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
	@Override
	public List<AttachmentAnswer> findByAttachmentId(
		long attachmentId, int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		return findByAttachmentId(
			attachmentId, start, end, orderByComparator, true);
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
	@Override
	public List<AttachmentAnswer> findByAttachmentId(
		long attachmentId, int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator,
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

		List<AttachmentAnswer> list = null;

		if (useFinderCache) {
			list = (List<AttachmentAnswer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AttachmentAnswer attachmentAnswer : list) {
					if (attachmentId != attachmentAnswer.getAttachmentId()) {
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

			query.append(_SQL_SELECT_ATTACHMENTANSWER_WHERE);

			query.append(_FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(AttachmentAnswerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

				list = (List<AttachmentAnswer>)QueryUtil.list(
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
	 * Returns the first attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	@Override
	public AttachmentAnswer findByAttachmentId_First(
			long attachmentId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws NoSuchAttachmentAnswerException {

		AttachmentAnswer attachmentAnswer = fetchByAttachmentId_First(
			attachmentId, orderByComparator);

		if (attachmentAnswer != null) {
			return attachmentAnswer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attachmentId=");
		msg.append(attachmentId);

		msg.append("}");

		throw new NoSuchAttachmentAnswerException(msg.toString());
	}

	/**
	 * Returns the first attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	@Override
	public AttachmentAnswer fetchByAttachmentId_First(
		long attachmentId,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		List<AttachmentAnswer> list = findByAttachmentId(
			attachmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	@Override
	public AttachmentAnswer findByAttachmentId_Last(
			long attachmentId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws NoSuchAttachmentAnswerException {

		AttachmentAnswer attachmentAnswer = fetchByAttachmentId_Last(
			attachmentId, orderByComparator);

		if (attachmentAnswer != null) {
			return attachmentAnswer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attachmentId=");
		msg.append(attachmentId);

		msg.append("}");

		throw new NoSuchAttachmentAnswerException(msg.toString());
	}

	/**
	 * Returns the last attachment answer in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	@Override
	public AttachmentAnswer fetchByAttachmentId_Last(
		long attachmentId,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		int count = countByAttachmentId(attachmentId);

		if (count == 0) {
			return null;
		}

		List<AttachmentAnswer> list = findByAttachmentId(
			attachmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AttachmentAnswer[] findByAttachmentId_PrevAndNext(
			AttachmentAnswerPK attachmentAnswerPK, long attachmentId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws NoSuchAttachmentAnswerException {

		AttachmentAnswer attachmentAnswer = findByPrimaryKey(
			attachmentAnswerPK);

		Session session = null;

		try {
			session = openSession();

			AttachmentAnswer[] array = new AttachmentAnswerImpl[3];

			array[0] = getByAttachmentId_PrevAndNext(
				session, attachmentAnswer, attachmentId, orderByComparator,
				true);

			array[1] = attachmentAnswer;

			array[2] = getByAttachmentId_PrevAndNext(
				session, attachmentAnswer, attachmentId, orderByComparator,
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

	protected AttachmentAnswer getByAttachmentId_PrevAndNext(
		Session session, AttachmentAnswer attachmentAnswer, long attachmentId,
		OrderByComparator<AttachmentAnswer> orderByComparator,
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

		query.append(_SQL_SELECT_ATTACHMENTANSWER_WHERE);

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
			query.append(AttachmentAnswerModelImpl.ORDER_BY_JPQL);
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
						attachmentAnswer)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AttachmentAnswer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachment answers where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 */
	@Override
	public void removeByAttachmentId(long attachmentId) {
		for (AttachmentAnswer attachmentAnswer :
				findByAttachmentId(
					attachmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(attachmentAnswer);
		}
	}

	/**
	 * Returns the number of attachment answers where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching attachment answers
	 */
	@Override
	public int countByAttachmentId(long attachmentId) {
		FinderPath finderPath = _finderPathCountByAttachmentId;

		Object[] finderArgs = new Object[] {attachmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ATTACHMENTANSWER_WHERE);

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
		"attachmentAnswer.id.attachmentId = ?";

	private FinderPath _finderPathWithPaginationFindByAnswerId;
	private FinderPath _finderPathWithoutPaginationFindByAnswerId;
	private FinderPath _finderPathCountByAnswerId;

	/**
	 * Returns all the attachment answers where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @return the matching attachment answers
	 */
	@Override
	public List<AttachmentAnswer> findByAnswerId(long answerId) {
		return findByAnswerId(
			answerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AttachmentAnswer> findByAnswerId(
		long answerId, int start, int end) {

		return findByAnswerId(answerId, start, end, null);
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
	@Override
	public List<AttachmentAnswer> findByAnswerId(
		long answerId, int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		return findByAnswerId(answerId, start, end, orderByComparator, true);
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
	@Override
	public List<AttachmentAnswer> findByAnswerId(
		long answerId, int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAnswerId;
				finderArgs = new Object[] {answerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAnswerId;
			finderArgs = new Object[] {answerId, start, end, orderByComparator};
		}

		List<AttachmentAnswer> list = null;

		if (useFinderCache) {
			list = (List<AttachmentAnswer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AttachmentAnswer attachmentAnswer : list) {
					if (answerId != attachmentAnswer.getAnswerId()) {
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

			query.append(_SQL_SELECT_ATTACHMENTANSWER_WHERE);

			query.append(_FINDER_COLUMN_ANSWERID_ANSWERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(AttachmentAnswerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(answerId);

				list = (List<AttachmentAnswer>)QueryUtil.list(
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
	 * Returns the first attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	@Override
	public AttachmentAnswer findByAnswerId_First(
			long answerId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws NoSuchAttachmentAnswerException {

		AttachmentAnswer attachmentAnswer = fetchByAnswerId_First(
			answerId, orderByComparator);

		if (attachmentAnswer != null) {
			return attachmentAnswer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("answerId=");
		msg.append(answerId);

		msg.append("}");

		throw new NoSuchAttachmentAnswerException(msg.toString());
	}

	/**
	 * Returns the first attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	@Override
	public AttachmentAnswer fetchByAnswerId_First(
		long answerId, OrderByComparator<AttachmentAnswer> orderByComparator) {

		List<AttachmentAnswer> list = findByAnswerId(
			answerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer
	 * @throws NoSuchAttachmentAnswerException if a matching attachment answer could not be found
	 */
	@Override
	public AttachmentAnswer findByAnswerId_Last(
			long answerId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws NoSuchAttachmentAnswerException {

		AttachmentAnswer attachmentAnswer = fetchByAnswerId_Last(
			answerId, orderByComparator);

		if (attachmentAnswer != null) {
			return attachmentAnswer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("answerId=");
		msg.append(answerId);

		msg.append("}");

		throw new NoSuchAttachmentAnswerException(msg.toString());
	}

	/**
	 * Returns the last attachment answer in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment answer, or <code>null</code> if a matching attachment answer could not be found
	 */
	@Override
	public AttachmentAnswer fetchByAnswerId_Last(
		long answerId, OrderByComparator<AttachmentAnswer> orderByComparator) {

		int count = countByAnswerId(answerId);

		if (count == 0) {
			return null;
		}

		List<AttachmentAnswer> list = findByAnswerId(
			answerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AttachmentAnswer[] findByAnswerId_PrevAndNext(
			AttachmentAnswerPK attachmentAnswerPK, long answerId,
			OrderByComparator<AttachmentAnswer> orderByComparator)
		throws NoSuchAttachmentAnswerException {

		AttachmentAnswer attachmentAnswer = findByPrimaryKey(
			attachmentAnswerPK);

		Session session = null;

		try {
			session = openSession();

			AttachmentAnswer[] array = new AttachmentAnswerImpl[3];

			array[0] = getByAnswerId_PrevAndNext(
				session, attachmentAnswer, answerId, orderByComparator, true);

			array[1] = attachmentAnswer;

			array[2] = getByAnswerId_PrevAndNext(
				session, attachmentAnswer, answerId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AttachmentAnswer getByAnswerId_PrevAndNext(
		Session session, AttachmentAnswer attachmentAnswer, long answerId,
		OrderByComparator<AttachmentAnswer> orderByComparator,
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

		query.append(_SQL_SELECT_ATTACHMENTANSWER_WHERE);

		query.append(_FINDER_COLUMN_ANSWERID_ANSWERID_2);

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
			query.append(AttachmentAnswerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(answerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						attachmentAnswer)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AttachmentAnswer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachment answers where answerId = &#63; from the database.
	 *
	 * @param answerId the answer ID
	 */
	@Override
	public void removeByAnswerId(long answerId) {
		for (AttachmentAnswer attachmentAnswer :
				findByAnswerId(
					answerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(attachmentAnswer);
		}
	}

	/**
	 * Returns the number of attachment answers where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @return the number of matching attachment answers
	 */
	@Override
	public int countByAnswerId(long answerId) {
		FinderPath finderPath = _finderPathCountByAnswerId;

		Object[] finderArgs = new Object[] {answerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ATTACHMENTANSWER_WHERE);

			query.append(_FINDER_COLUMN_ANSWERID_ANSWERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(answerId);

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

	private static final String _FINDER_COLUMN_ANSWERID_ANSWERID_2 =
		"attachmentAnswer.id.answerId = ?";

	public AttachmentAnswerPersistenceImpl() {
		setModelClass(AttachmentAnswer.class);

		setModelImplClass(AttachmentAnswerImpl.class);
		setModelPKClass(AttachmentAnswerPK.class);
	}

	/**
	 * Caches the attachment answer in the entity cache if it is enabled.
	 *
	 * @param attachmentAnswer the attachment answer
	 */
	@Override
	public void cacheResult(AttachmentAnswer attachmentAnswer) {
		entityCache.putResult(
			entityCacheEnabled, AttachmentAnswerImpl.class,
			attachmentAnswer.getPrimaryKey(), attachmentAnswer);

		attachmentAnswer.resetOriginalValues();
	}

	/**
	 * Caches the attachment answers in the entity cache if it is enabled.
	 *
	 * @param attachmentAnswers the attachment answers
	 */
	@Override
	public void cacheResult(List<AttachmentAnswer> attachmentAnswers) {
		for (AttachmentAnswer attachmentAnswer : attachmentAnswers) {
			if (entityCache.getResult(
					entityCacheEnabled, AttachmentAnswerImpl.class,
					attachmentAnswer.getPrimaryKey()) == null) {

				cacheResult(attachmentAnswer);
			}
			else {
				attachmentAnswer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attachment answers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AttachmentAnswerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attachment answer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttachmentAnswer attachmentAnswer) {
		entityCache.removeResult(
			entityCacheEnabled, AttachmentAnswerImpl.class,
			attachmentAnswer.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AttachmentAnswer> attachmentAnswers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AttachmentAnswer attachmentAnswer : attachmentAnswers) {
			entityCache.removeResult(
				entityCacheEnabled, AttachmentAnswerImpl.class,
				attachmentAnswer.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, AttachmentAnswerImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new attachment answer with the primary key. Does not add the attachment answer to the database.
	 *
	 * @param attachmentAnswerPK the primary key for the new attachment answer
	 * @return the new attachment answer
	 */
	@Override
	public AttachmentAnswer create(AttachmentAnswerPK attachmentAnswerPK) {
		AttachmentAnswer attachmentAnswer = new AttachmentAnswerImpl();

		attachmentAnswer.setNew(true);
		attachmentAnswer.setPrimaryKey(attachmentAnswerPK);

		return attachmentAnswer;
	}

	/**
	 * Removes the attachment answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer that was removed
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	@Override
	public AttachmentAnswer remove(AttachmentAnswerPK attachmentAnswerPK)
		throws NoSuchAttachmentAnswerException {

		return remove((Serializable)attachmentAnswerPK);
	}

	/**
	 * Removes the attachment answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attachment answer
	 * @return the attachment answer that was removed
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	@Override
	public AttachmentAnswer remove(Serializable primaryKey)
		throws NoSuchAttachmentAnswerException {

		Session session = null;

		try {
			session = openSession();

			AttachmentAnswer attachmentAnswer = (AttachmentAnswer)session.get(
				AttachmentAnswerImpl.class, primaryKey);

			if (attachmentAnswer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttachmentAnswerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(attachmentAnswer);
		}
		catch (NoSuchAttachmentAnswerException noSuchEntityException) {
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
	protected AttachmentAnswer removeImpl(AttachmentAnswer attachmentAnswer) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attachmentAnswer)) {
				attachmentAnswer = (AttachmentAnswer)session.get(
					AttachmentAnswerImpl.class,
					attachmentAnswer.getPrimaryKeyObj());
			}

			if (attachmentAnswer != null) {
				session.delete(attachmentAnswer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (attachmentAnswer != null) {
			clearCache(attachmentAnswer);
		}

		return attachmentAnswer;
	}

	@Override
	public AttachmentAnswer updateImpl(AttachmentAnswer attachmentAnswer) {
		boolean isNew = attachmentAnswer.isNew();

		if (!(attachmentAnswer instanceof AttachmentAnswerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(attachmentAnswer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					attachmentAnswer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in attachmentAnswer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AttachmentAnswer implementation " +
					attachmentAnswer.getClass());
		}

		AttachmentAnswerModelImpl attachmentAnswerModelImpl =
			(AttachmentAnswerModelImpl)attachmentAnswer;

		Session session = null;

		try {
			session = openSession();

			if (attachmentAnswer.isNew()) {
				session.save(attachmentAnswer);

				attachmentAnswer.setNew(false);
			}
			else {
				attachmentAnswer = (AttachmentAnswer)session.merge(
					attachmentAnswer);
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
				attachmentAnswerModelImpl.getAttachmentId()
			};

			finderCache.removeResult(_finderPathCountByAttachmentId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAttachmentId, args);

			args = new Object[] {attachmentAnswerModelImpl.getAnswerId()};

			finderCache.removeResult(_finderPathCountByAnswerId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAnswerId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((attachmentAnswerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAttachmentId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					attachmentAnswerModelImpl.getOriginalAttachmentId()
				};

				finderCache.removeResult(_finderPathCountByAttachmentId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAttachmentId, args);

				args = new Object[] {
					attachmentAnswerModelImpl.getAttachmentId()
				};

				finderCache.removeResult(_finderPathCountByAttachmentId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAttachmentId, args);
			}

			if ((attachmentAnswerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAnswerId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					attachmentAnswerModelImpl.getOriginalAnswerId()
				};

				finderCache.removeResult(_finderPathCountByAnswerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAnswerId, args);

				args = new Object[] {attachmentAnswerModelImpl.getAnswerId()};

				finderCache.removeResult(_finderPathCountByAnswerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAnswerId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, AttachmentAnswerImpl.class,
			attachmentAnswer.getPrimaryKey(), attachmentAnswer, false);

		attachmentAnswer.resetOriginalValues();

		return attachmentAnswer;
	}

	/**
	 * Returns the attachment answer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attachment answer
	 * @return the attachment answer
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	@Override
	public AttachmentAnswer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttachmentAnswerException {

		AttachmentAnswer attachmentAnswer = fetchByPrimaryKey(primaryKey);

		if (attachmentAnswer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttachmentAnswerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return attachmentAnswer;
	}

	/**
	 * Returns the attachment answer with the primary key or throws a <code>NoSuchAttachmentAnswerException</code> if it could not be found.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer
	 * @throws NoSuchAttachmentAnswerException if a attachment answer with the primary key could not be found
	 */
	@Override
	public AttachmentAnswer findByPrimaryKey(
			AttachmentAnswerPK attachmentAnswerPK)
		throws NoSuchAttachmentAnswerException {

		return findByPrimaryKey((Serializable)attachmentAnswerPK);
	}

	/**
	 * Returns the attachment answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer, or <code>null</code> if a attachment answer with the primary key could not be found
	 */
	@Override
	public AttachmentAnswer fetchByPrimaryKey(
		AttachmentAnswerPK attachmentAnswerPK) {

		return fetchByPrimaryKey((Serializable)attachmentAnswerPK);
	}

	/**
	 * Returns all the attachment answers.
	 *
	 * @return the attachment answers
	 */
	@Override
	public List<AttachmentAnswer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AttachmentAnswer> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AttachmentAnswer> findAll(
		int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AttachmentAnswer> findAll(
		int start, int end,
		OrderByComparator<AttachmentAnswer> orderByComparator,
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

		List<AttachmentAnswer> list = null;

		if (useFinderCache) {
			list = (List<AttachmentAnswer>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ATTACHMENTANSWER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTACHMENTANSWER;

				sql = sql.concat(AttachmentAnswerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<AttachmentAnswer>)QueryUtil.list(
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
	 * Removes all the attachment answers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AttachmentAnswer attachmentAnswer : findAll()) {
			remove(attachmentAnswer);
		}
	}

	/**
	 * Returns the number of attachment answers.
	 *
	 * @return the number of attachment answers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ATTACHMENTANSWER);

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
		return "attachmentAnswerPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ATTACHMENTANSWER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AttachmentAnswerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the attachment answer persistence.
	 */
	@Activate
	public void activate() {
		AttachmentAnswerModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AttachmentAnswerModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AttachmentAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AttachmentAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByAttachmentId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AttachmentAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAttachmentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAttachmentId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AttachmentAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAttachmentId",
			new String[] {Long.class.getName()},
			AttachmentAnswerModelImpl.ATTACHMENTID_COLUMN_BITMASK);

		_finderPathCountByAttachmentId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttachmentId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByAnswerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AttachmentAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAnswerId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAnswerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AttachmentAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAnswerId",
			new String[] {Long.class.getName()},
			AttachmentAnswerModelImpl.ANSWERID_COLUMN_BITMASK);

		_finderPathCountByAnswerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAnswerId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AttachmentAnswerImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.qa.service.model.AttachmentAnswer"),
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

	private static final String _SQL_SELECT_ATTACHMENTANSWER =
		"SELECT attachmentAnswer FROM AttachmentAnswer attachmentAnswer";

	private static final String _SQL_SELECT_ATTACHMENTANSWER_WHERE =
		"SELECT attachmentAnswer FROM AttachmentAnswer attachmentAnswer WHERE ";

	private static final String _SQL_COUNT_ATTACHMENTANSWER =
		"SELECT COUNT(attachmentAnswer) FROM AttachmentAnswer attachmentAnswer";

	private static final String _SQL_COUNT_ATTACHMENTANSWER_WHERE =
		"SELECT COUNT(attachmentAnswer) FROM AttachmentAnswer attachmentAnswer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "attachmentAnswer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AttachmentAnswer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AttachmentAnswer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AttachmentAnswerPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"attachmentId", "answerId"});

	static {
		try {
			Class.forName(ecoit_qaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}