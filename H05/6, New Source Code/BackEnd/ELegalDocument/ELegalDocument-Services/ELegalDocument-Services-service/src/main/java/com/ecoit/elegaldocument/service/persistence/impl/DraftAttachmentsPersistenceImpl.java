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

package com.ecoit.elegaldocument.service.persistence.impl;

import com.ecoit.elegaldocument.exception.NoSuchDraftAttachmentsException;
import com.ecoit.elegaldocument.model.DraftAttachments;
import com.ecoit.elegaldocument.model.impl.DraftAttachmentsImpl;
import com.ecoit.elegaldocument.model.impl.DraftAttachmentsModelImpl;
import com.ecoit.elegaldocument.service.persistence.DraftAttachmentsPersistence;
import com.ecoit.elegaldocument.service.persistence.impl.constants.ecoit_docPersistenceConstants;

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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the draft attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = DraftAttachmentsPersistence.class)
public class DraftAttachmentsPersistenceImpl
	extends BasePersistenceImpl<DraftAttachments>
	implements DraftAttachmentsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DraftAttachmentsUtil</code> to access the draft attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DraftAttachmentsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDraftId;
	private FinderPath _finderPathWithoutPaginationFindByDraftId;
	private FinderPath _finderPathCountByDraftId;

	/**
	 * Returns all the draft attachmentses where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @return the matching draft attachmentses
	 */
	@Override
	public List<DraftAttachments> findByDraftId(long draftId) {
		return findByDraftId(
			draftId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the draft attachmentses where draftId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param draftId the draft ID
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @return the range of matching draft attachmentses
	 */
	@Override
	public List<DraftAttachments> findByDraftId(
		long draftId, int start, int end) {

		return findByDraftId(draftId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the draft attachmentses where draftId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param draftId the draft ID
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching draft attachmentses
	 */
	@Override
	public List<DraftAttachments> findByDraftId(
		long draftId, int start, int end,
		OrderByComparator<DraftAttachments> orderByComparator) {

		return findByDraftId(draftId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the draft attachmentses where draftId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param draftId the draft ID
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching draft attachmentses
	 */
	@Override
	public List<DraftAttachments> findByDraftId(
		long draftId, int start, int end,
		OrderByComparator<DraftAttachments> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDraftId;
				finderArgs = new Object[] {draftId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDraftId;
			finderArgs = new Object[] {draftId, start, end, orderByComparator};
		}

		List<DraftAttachments> list = null;

		if (useFinderCache) {
			list = (List<DraftAttachments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DraftAttachments draftAttachments : list) {
					if (draftId != draftAttachments.getDraftId()) {
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

			query.append(_SQL_SELECT_DRAFTATTACHMENTS_WHERE);

			query.append(_FINDER_COLUMN_DRAFTID_DRAFTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(DraftAttachmentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(draftId);

				list = (List<DraftAttachments>)QueryUtil.list(
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
	 * Returns the first draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching draft attachments
	 * @throws NoSuchDraftAttachmentsException if a matching draft attachments could not be found
	 */
	@Override
	public DraftAttachments findByDraftId_First(
			long draftId, OrderByComparator<DraftAttachments> orderByComparator)
		throws NoSuchDraftAttachmentsException {

		DraftAttachments draftAttachments = fetchByDraftId_First(
			draftId, orderByComparator);

		if (draftAttachments != null) {
			return draftAttachments;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("draftId=");
		msg.append(draftId);

		msg.append("}");

		throw new NoSuchDraftAttachmentsException(msg.toString());
	}

	/**
	 * Returns the first draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	@Override
	public DraftAttachments fetchByDraftId_First(
		long draftId, OrderByComparator<DraftAttachments> orderByComparator) {

		List<DraftAttachments> list = findByDraftId(
			draftId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching draft attachments
	 * @throws NoSuchDraftAttachmentsException if a matching draft attachments could not be found
	 */
	@Override
	public DraftAttachments findByDraftId_Last(
			long draftId, OrderByComparator<DraftAttachments> orderByComparator)
		throws NoSuchDraftAttachmentsException {

		DraftAttachments draftAttachments = fetchByDraftId_Last(
			draftId, orderByComparator);

		if (draftAttachments != null) {
			return draftAttachments;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("draftId=");
		msg.append(draftId);

		msg.append("}");

		throw new NoSuchDraftAttachmentsException(msg.toString());
	}

	/**
	 * Returns the last draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	@Override
	public DraftAttachments fetchByDraftId_Last(
		long draftId, OrderByComparator<DraftAttachments> orderByComparator) {

		int count = countByDraftId(draftId);

		if (count == 0) {
			return null;
		}

		List<DraftAttachments> list = findByDraftId(
			draftId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the draft attachmentses before and after the current draft attachments in the ordered set where draftId = &#63;.
	 *
	 * @param attachmentId the primary key of the current draft attachments
	 * @param draftId the draft ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next draft attachments
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	@Override
	public DraftAttachments[] findByDraftId_PrevAndNext(
			long attachmentId, long draftId,
			OrderByComparator<DraftAttachments> orderByComparator)
		throws NoSuchDraftAttachmentsException {

		DraftAttachments draftAttachments = findByPrimaryKey(attachmentId);

		Session session = null;

		try {
			session = openSession();

			DraftAttachments[] array = new DraftAttachmentsImpl[3];

			array[0] = getByDraftId_PrevAndNext(
				session, draftAttachments, draftId, orderByComparator, true);

			array[1] = draftAttachments;

			array[2] = getByDraftId_PrevAndNext(
				session, draftAttachments, draftId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DraftAttachments getByDraftId_PrevAndNext(
		Session session, DraftAttachments draftAttachments, long draftId,
		OrderByComparator<DraftAttachments> orderByComparator,
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

		query.append(_SQL_SELECT_DRAFTATTACHMENTS_WHERE);

		query.append(_FINDER_COLUMN_DRAFTID_DRAFTID_2);

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
			query.append(DraftAttachmentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(draftId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						draftAttachments)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DraftAttachments> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the draft attachmentses where draftId = &#63; from the database.
	 *
	 * @param draftId the draft ID
	 */
	@Override
	public void removeByDraftId(long draftId) {
		for (DraftAttachments draftAttachments :
				findByDraftId(
					draftId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(draftAttachments);
		}
	}

	/**
	 * Returns the number of draft attachmentses where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @return the number of matching draft attachmentses
	 */
	@Override
	public int countByDraftId(long draftId) {
		FinderPath finderPath = _finderPathCountByDraftId;

		Object[] finderArgs = new Object[] {draftId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DRAFTATTACHMENTS_WHERE);

			query.append(_FINDER_COLUMN_DRAFTID_DRAFTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(draftId);

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

	private static final String _FINDER_COLUMN_DRAFTID_DRAFTID_2 =
		"draftAttachments.draftId = ?";

	private FinderPath _finderPathFetchByAttachment;
	private FinderPath _finderPathCountByAttachment;

	/**
	 * Returns the draft attachments where attachmentId = &#63; or throws a <code>NoSuchDraftAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching draft attachments
	 * @throws NoSuchDraftAttachmentsException if a matching draft attachments could not be found
	 */
	@Override
	public DraftAttachments findByAttachment(long attachmentId)
		throws NoSuchDraftAttachmentsException {

		DraftAttachments draftAttachments = fetchByAttachment(attachmentId);

		if (draftAttachments == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("attachmentId=");
			msg.append(attachmentId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDraftAttachmentsException(msg.toString());
		}

		return draftAttachments;
	}

	/**
	 * Returns the draft attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	@Override
	public DraftAttachments fetchByAttachment(long attachmentId) {
		return fetchByAttachment(attachmentId, true);
	}

	/**
	 * Returns the draft attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching draft attachments, or <code>null</code> if a matching draft attachments could not be found
	 */
	@Override
	public DraftAttachments fetchByAttachment(
		long attachmentId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {attachmentId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByAttachment, finderArgs, this);
		}

		if (result instanceof DraftAttachments) {
			DraftAttachments draftAttachments = (DraftAttachments)result;

			if (attachmentId != draftAttachments.getAttachmentId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DRAFTATTACHMENTS_WHERE);

			query.append(_FINDER_COLUMN_ATTACHMENT_ATTACHMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

				List<DraftAttachments> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByAttachment, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {attachmentId};
							}

							_log.warn(
								"DraftAttachmentsPersistenceImpl.fetchByAttachment(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DraftAttachments draftAttachments = list.get(0);

					result = draftAttachments;

					cacheResult(draftAttachments);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByAttachment, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DraftAttachments)result;
		}
	}

	/**
	 * Removes the draft attachments where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @return the draft attachments that was removed
	 */
	@Override
	public DraftAttachments removeByAttachment(long attachmentId)
		throws NoSuchDraftAttachmentsException {

		DraftAttachments draftAttachments = findByAttachment(attachmentId);

		return remove(draftAttachments);
	}

	/**
	 * Returns the number of draft attachmentses where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching draft attachmentses
	 */
	@Override
	public int countByAttachment(long attachmentId) {
		FinderPath finderPath = _finderPathCountByAttachment;

		Object[] finderArgs = new Object[] {attachmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DRAFTATTACHMENTS_WHERE);

			query.append(_FINDER_COLUMN_ATTACHMENT_ATTACHMENTID_2);

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

	private static final String _FINDER_COLUMN_ATTACHMENT_ATTACHMENTID_2 =
		"draftAttachments.attachmentId = ?";

	public DraftAttachmentsPersistenceImpl() {
		setModelClass(DraftAttachments.class);

		setModelImplClass(DraftAttachmentsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the draft attachments in the entity cache if it is enabled.
	 *
	 * @param draftAttachments the draft attachments
	 */
	@Override
	public void cacheResult(DraftAttachments draftAttachments) {
		entityCache.putResult(
			entityCacheEnabled, DraftAttachmentsImpl.class,
			draftAttachments.getPrimaryKey(), draftAttachments);

		finderCache.putResult(
			_finderPathFetchByAttachment,
			new Object[] {draftAttachments.getAttachmentId()},
			draftAttachments);

		draftAttachments.resetOriginalValues();
	}

	/**
	 * Caches the draft attachmentses in the entity cache if it is enabled.
	 *
	 * @param draftAttachmentses the draft attachmentses
	 */
	@Override
	public void cacheResult(List<DraftAttachments> draftAttachmentses) {
		for (DraftAttachments draftAttachments : draftAttachmentses) {
			if (entityCache.getResult(
					entityCacheEnabled, DraftAttachmentsImpl.class,
					draftAttachments.getPrimaryKey()) == null) {

				cacheResult(draftAttachments);
			}
			else {
				draftAttachments.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all draft attachmentses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DraftAttachmentsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the draft attachments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DraftAttachments draftAttachments) {
		entityCache.removeResult(
			entityCacheEnabled, DraftAttachmentsImpl.class,
			draftAttachments.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(DraftAttachmentsModelImpl)draftAttachments, true);
	}

	@Override
	public void clearCache(List<DraftAttachments> draftAttachmentses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DraftAttachments draftAttachments : draftAttachmentses) {
			entityCache.removeResult(
				entityCacheEnabled, DraftAttachmentsImpl.class,
				draftAttachments.getPrimaryKey());

			clearUniqueFindersCache(
				(DraftAttachmentsModelImpl)draftAttachments, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DraftAttachmentsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DraftAttachmentsModelImpl draftAttachmentsModelImpl) {

		Object[] args = new Object[] {
			draftAttachmentsModelImpl.getAttachmentId()
		};

		finderCache.putResult(
			_finderPathCountByAttachment, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByAttachment, args, draftAttachmentsModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		DraftAttachmentsModelImpl draftAttachmentsModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				draftAttachmentsModelImpl.getAttachmentId()
			};

			finderCache.removeResult(_finderPathCountByAttachment, args);
			finderCache.removeResult(_finderPathFetchByAttachment, args);
		}

		if ((draftAttachmentsModelImpl.getColumnBitmask() &
			 _finderPathFetchByAttachment.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				draftAttachmentsModelImpl.getOriginalAttachmentId()
			};

			finderCache.removeResult(_finderPathCountByAttachment, args);
			finderCache.removeResult(_finderPathFetchByAttachment, args);
		}
	}

	/**
	 * Creates a new draft attachments with the primary key. Does not add the draft attachments to the database.
	 *
	 * @param attachmentId the primary key for the new draft attachments
	 * @return the new draft attachments
	 */
	@Override
	public DraftAttachments create(long attachmentId) {
		DraftAttachments draftAttachments = new DraftAttachmentsImpl();

		draftAttachments.setNew(true);
		draftAttachments.setPrimaryKey(attachmentId);

		return draftAttachments;
	}

	/**
	 * Removes the draft attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments that was removed
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	@Override
	public DraftAttachments remove(long attachmentId)
		throws NoSuchDraftAttachmentsException {

		return remove((Serializable)attachmentId);
	}

	/**
	 * Removes the draft attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the draft attachments
	 * @return the draft attachments that was removed
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	@Override
	public DraftAttachments remove(Serializable primaryKey)
		throws NoSuchDraftAttachmentsException {

		Session session = null;

		try {
			session = openSession();

			DraftAttachments draftAttachments = (DraftAttachments)session.get(
				DraftAttachmentsImpl.class, primaryKey);

			if (draftAttachments == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDraftAttachmentsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(draftAttachments);
		}
		catch (NoSuchDraftAttachmentsException noSuchEntityException) {
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
	protected DraftAttachments removeImpl(DraftAttachments draftAttachments) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(draftAttachments)) {
				draftAttachments = (DraftAttachments)session.get(
					DraftAttachmentsImpl.class,
					draftAttachments.getPrimaryKeyObj());
			}

			if (draftAttachments != null) {
				session.delete(draftAttachments);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (draftAttachments != null) {
			clearCache(draftAttachments);
		}

		return draftAttachments;
	}

	@Override
	public DraftAttachments updateImpl(DraftAttachments draftAttachments) {
		boolean isNew = draftAttachments.isNew();

		if (!(draftAttachments instanceof DraftAttachmentsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(draftAttachments.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					draftAttachments);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in draftAttachments proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DraftAttachments implementation " +
					draftAttachments.getClass());
		}

		DraftAttachmentsModelImpl draftAttachmentsModelImpl =
			(DraftAttachmentsModelImpl)draftAttachments;

		Session session = null;

		try {
			session = openSession();

			if (draftAttachments.isNew()) {
				session.save(draftAttachments);

				draftAttachments.setNew(false);
			}
			else {
				draftAttachments = (DraftAttachments)session.merge(
					draftAttachments);
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
				draftAttachmentsModelImpl.getDraftId()
			};

			finderCache.removeResult(_finderPathCountByDraftId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDraftId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((draftAttachmentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDraftId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					draftAttachmentsModelImpl.getOriginalDraftId()
				};

				finderCache.removeResult(_finderPathCountByDraftId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDraftId, args);

				args = new Object[] {draftAttachmentsModelImpl.getDraftId()};

				finderCache.removeResult(_finderPathCountByDraftId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDraftId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DraftAttachmentsImpl.class,
			draftAttachments.getPrimaryKey(), draftAttachments, false);

		clearUniqueFindersCache(draftAttachmentsModelImpl, false);
		cacheUniqueFindersCache(draftAttachmentsModelImpl);

		draftAttachments.resetOriginalValues();

		return draftAttachments;
	}

	/**
	 * Returns the draft attachments with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the draft attachments
	 * @return the draft attachments
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	@Override
	public DraftAttachments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDraftAttachmentsException {

		DraftAttachments draftAttachments = fetchByPrimaryKey(primaryKey);

		if (draftAttachments == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDraftAttachmentsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return draftAttachments;
	}

	/**
	 * Returns the draft attachments with the primary key or throws a <code>NoSuchDraftAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments
	 * @throws NoSuchDraftAttachmentsException if a draft attachments with the primary key could not be found
	 */
	@Override
	public DraftAttachments findByPrimaryKey(long attachmentId)
		throws NoSuchDraftAttachmentsException {

		return findByPrimaryKey((Serializable)attachmentId);
	}

	/**
	 * Returns the draft attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments, or <code>null</code> if a draft attachments with the primary key could not be found
	 */
	@Override
	public DraftAttachments fetchByPrimaryKey(long attachmentId) {
		return fetchByPrimaryKey((Serializable)attachmentId);
	}

	/**
	 * Returns all the draft attachmentses.
	 *
	 * @return the draft attachmentses
	 */
	@Override
	public List<DraftAttachments> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the draft attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @return the range of draft attachmentses
	 */
	@Override
	public List<DraftAttachments> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the draft attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of draft attachmentses
	 */
	@Override
	public List<DraftAttachments> findAll(
		int start, int end,
		OrderByComparator<DraftAttachments> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the draft attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of draft attachmentses
	 */
	@Override
	public List<DraftAttachments> findAll(
		int start, int end,
		OrderByComparator<DraftAttachments> orderByComparator,
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

		List<DraftAttachments> list = null;

		if (useFinderCache) {
			list = (List<DraftAttachments>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DRAFTATTACHMENTS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DRAFTATTACHMENTS;

				sql = sql.concat(DraftAttachmentsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<DraftAttachments>)QueryUtil.list(
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
	 * Removes all the draft attachmentses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DraftAttachments draftAttachments : findAll()) {
			remove(draftAttachments);
		}
	}

	/**
	 * Returns the number of draft attachmentses.
	 *
	 * @return the number of draft attachmentses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DRAFTATTACHMENTS);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "attachmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DRAFTATTACHMENTS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DraftAttachmentsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the draft attachments persistence.
	 */
	@Activate
	public void activate() {
		DraftAttachmentsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DraftAttachmentsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DraftAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DraftAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDraftId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DraftAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDraftId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDraftId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DraftAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDraftId",
			new String[] {Long.class.getName()},
			DraftAttachmentsModelImpl.DRAFTID_COLUMN_BITMASK);

		_finderPathCountByDraftId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDraftId",
			new String[] {Long.class.getName()});

		_finderPathFetchByAttachment = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DraftAttachmentsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByAttachment",
			new String[] {Long.class.getName()},
			DraftAttachmentsModelImpl.ATTACHMENTID_COLUMN_BITMASK);

		_finderPathCountByAttachment = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttachment",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DraftAttachmentsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.DraftAttachments"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_DRAFTATTACHMENTS =
		"SELECT draftAttachments FROM DraftAttachments draftAttachments";

	private static final String _SQL_SELECT_DRAFTATTACHMENTS_WHERE =
		"SELECT draftAttachments FROM DraftAttachments draftAttachments WHERE ";

	private static final String _SQL_COUNT_DRAFTATTACHMENTS =
		"SELECT COUNT(draftAttachments) FROM DraftAttachments draftAttachments";

	private static final String _SQL_COUNT_DRAFTATTACHMENTS_WHERE =
		"SELECT COUNT(draftAttachments) FROM DraftAttachments draftAttachments WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "draftAttachments.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DraftAttachments exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DraftAttachments exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DraftAttachmentsPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}