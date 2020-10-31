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

import com.ecoit.elegaldocument.exception.NoSuchDocumentAttachmentsException;
import com.ecoit.elegaldocument.model.DocumentAttachments;
import com.ecoit.elegaldocument.model.impl.DocumentAttachmentsImpl;
import com.ecoit.elegaldocument.model.impl.DocumentAttachmentsModelImpl;
import com.ecoit.elegaldocument.service.persistence.DocumentAttachmentsPersistence;
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
 * The persistence implementation for the document attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = DocumentAttachmentsPersistence.class)
public class DocumentAttachmentsPersistenceImpl
	extends BasePersistenceImpl<DocumentAttachments>
	implements DocumentAttachmentsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocumentAttachmentsUtil</code> to access the document attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocumentAttachmentsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBydocId;
	private FinderPath _finderPathWithoutPaginationFindBydocId;
	private FinderPath _finderPathCountBydocId;

	/**
	 * Returns all the document attachmentses where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching document attachmentses
	 */
	@Override
	public List<DocumentAttachments> findBydocId(long docId) {
		return findBydocId(docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document attachmentses where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @return the range of matching document attachmentses
	 */
	@Override
	public List<DocumentAttachments> findBydocId(
		long docId, int start, int end) {

		return findBydocId(docId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the document attachmentses where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document attachmentses
	 */
	@Override
	public List<DocumentAttachments> findBydocId(
		long docId, int start, int end,
		OrderByComparator<DocumentAttachments> orderByComparator) {

		return findBydocId(docId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document attachmentses where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document attachmentses
	 */
	@Override
	public List<DocumentAttachments> findBydocId(
		long docId, int start, int end,
		OrderByComparator<DocumentAttachments> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydocId;
				finderArgs = new Object[] {docId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydocId;
			finderArgs = new Object[] {docId, start, end, orderByComparator};
		}

		List<DocumentAttachments> list = null;

		if (useFinderCache) {
			list = (List<DocumentAttachments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentAttachments documentAttachments : list) {
					if (docId != documentAttachments.getDocId()) {
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

			query.append(_SQL_SELECT_DOCUMENTATTACHMENTS_WHERE);

			query.append(_FINDER_COLUMN_DOCID_DOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(DocumentAttachmentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docId);

				list = (List<DocumentAttachments>)QueryUtil.list(
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
	 * Returns the first document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document attachments
	 * @throws NoSuchDocumentAttachmentsException if a matching document attachments could not be found
	 */
	@Override
	public DocumentAttachments findBydocId_First(
			long docId,
			OrderByComparator<DocumentAttachments> orderByComparator)
		throws NoSuchDocumentAttachmentsException {

		DocumentAttachments documentAttachments = fetchBydocId_First(
			docId, orderByComparator);

		if (documentAttachments != null) {
			return documentAttachments;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchDocumentAttachmentsException(msg.toString());
	}

	/**
	 * Returns the first document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	@Override
	public DocumentAttachments fetchBydocId_First(
		long docId, OrderByComparator<DocumentAttachments> orderByComparator) {

		List<DocumentAttachments> list = findBydocId(
			docId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document attachments
	 * @throws NoSuchDocumentAttachmentsException if a matching document attachments could not be found
	 */
	@Override
	public DocumentAttachments findBydocId_Last(
			long docId,
			OrderByComparator<DocumentAttachments> orderByComparator)
		throws NoSuchDocumentAttachmentsException {

		DocumentAttachments documentAttachments = fetchBydocId_Last(
			docId, orderByComparator);

		if (documentAttachments != null) {
			return documentAttachments;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchDocumentAttachmentsException(msg.toString());
	}

	/**
	 * Returns the last document attachments in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	@Override
	public DocumentAttachments fetchBydocId_Last(
		long docId, OrderByComparator<DocumentAttachments> orderByComparator) {

		int count = countBydocId(docId);

		if (count == 0) {
			return null;
		}

		List<DocumentAttachments> list = findBydocId(
			docId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the document attachmentses before and after the current document attachments in the ordered set where docId = &#63;.
	 *
	 * @param attachmentId the primary key of the current document attachments
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document attachments
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	@Override
	public DocumentAttachments[] findBydocId_PrevAndNext(
			long attachmentId, long docId,
			OrderByComparator<DocumentAttachments> orderByComparator)
		throws NoSuchDocumentAttachmentsException {

		DocumentAttachments documentAttachments = findByPrimaryKey(
			attachmentId);

		Session session = null;

		try {
			session = openSession();

			DocumentAttachments[] array = new DocumentAttachmentsImpl[3];

			array[0] = getBydocId_PrevAndNext(
				session, documentAttachments, docId, orderByComparator, true);

			array[1] = documentAttachments;

			array[2] = getBydocId_PrevAndNext(
				session, documentAttachments, docId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocumentAttachments getBydocId_PrevAndNext(
		Session session, DocumentAttachments documentAttachments, long docId,
		OrderByComparator<DocumentAttachments> orderByComparator,
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

		query.append(_SQL_SELECT_DOCUMENTATTACHMENTS_WHERE);

		query.append(_FINDER_COLUMN_DOCID_DOCID_2);

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
			query.append(DocumentAttachmentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(docId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						documentAttachments)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DocumentAttachments> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document attachmentses where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	@Override
	public void removeBydocId(long docId) {
		for (DocumentAttachments documentAttachments :
				findBydocId(
					docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(documentAttachments);
		}
	}

	/**
	 * Returns the number of document attachmentses where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching document attachmentses
	 */
	@Override
	public int countBydocId(long docId) {
		FinderPath finderPath = _finderPathCountBydocId;

		Object[] finderArgs = new Object[] {docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENTATTACHMENTS_WHERE);

			query.append(_FINDER_COLUMN_DOCID_DOCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docId);

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

	private static final String _FINDER_COLUMN_DOCID_DOCID_2 =
		"documentAttachments.docId = ?";

	private FinderPath _finderPathFetchByAttachment;
	private FinderPath _finderPathCountByAttachment;

	/**
	 * Returns the document attachments where attachmentId = &#63; or throws a <code>NoSuchDocumentAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching document attachments
	 * @throws NoSuchDocumentAttachmentsException if a matching document attachments could not be found
	 */
	@Override
	public DocumentAttachments findByAttachment(long attachmentId)
		throws NoSuchDocumentAttachmentsException {

		DocumentAttachments documentAttachments = fetchByAttachment(
			attachmentId);

		if (documentAttachments == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("attachmentId=");
			msg.append(attachmentId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDocumentAttachmentsException(msg.toString());
		}

		return documentAttachments;
	}

	/**
	 * Returns the document attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	@Override
	public DocumentAttachments fetchByAttachment(long attachmentId) {
		return fetchByAttachment(attachmentId, true);
	}

	/**
	 * Returns the document attachments where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document attachments, or <code>null</code> if a matching document attachments could not be found
	 */
	@Override
	public DocumentAttachments fetchByAttachment(
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

		if (result instanceof DocumentAttachments) {
			DocumentAttachments documentAttachments =
				(DocumentAttachments)result;

			if (attachmentId != documentAttachments.getAttachmentId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOCUMENTATTACHMENTS_WHERE);

			query.append(_FINDER_COLUMN_ATTACHMENT_ATTACHMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

				List<DocumentAttachments> list = q.list();

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
								"DocumentAttachmentsPersistenceImpl.fetchByAttachment(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocumentAttachments documentAttachments = list.get(0);

					result = documentAttachments;

					cacheResult(documentAttachments);
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
			return (DocumentAttachments)result;
		}
	}

	/**
	 * Removes the document attachments where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @return the document attachments that was removed
	 */
	@Override
	public DocumentAttachments removeByAttachment(long attachmentId)
		throws NoSuchDocumentAttachmentsException {

		DocumentAttachments documentAttachments = findByAttachment(
			attachmentId);

		return remove(documentAttachments);
	}

	/**
	 * Returns the number of document attachmentses where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching document attachmentses
	 */
	@Override
	public int countByAttachment(long attachmentId) {
		FinderPath finderPath = _finderPathCountByAttachment;

		Object[] finderArgs = new Object[] {attachmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENTATTACHMENTS_WHERE);

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
		"documentAttachments.attachmentId = ?";

	public DocumentAttachmentsPersistenceImpl() {
		setModelClass(DocumentAttachments.class);

		setModelImplClass(DocumentAttachmentsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the document attachments in the entity cache if it is enabled.
	 *
	 * @param documentAttachments the document attachments
	 */
	@Override
	public void cacheResult(DocumentAttachments documentAttachments) {
		entityCache.putResult(
			entityCacheEnabled, DocumentAttachmentsImpl.class,
			documentAttachments.getPrimaryKey(), documentAttachments);

		finderCache.putResult(
			_finderPathFetchByAttachment,
			new Object[] {documentAttachments.getAttachmentId()},
			documentAttachments);

		documentAttachments.resetOriginalValues();
	}

	/**
	 * Caches the document attachmentses in the entity cache if it is enabled.
	 *
	 * @param documentAttachmentses the document attachmentses
	 */
	@Override
	public void cacheResult(List<DocumentAttachments> documentAttachmentses) {
		for (DocumentAttachments documentAttachments : documentAttachmentses) {
			if (entityCache.getResult(
					entityCacheEnabled, DocumentAttachmentsImpl.class,
					documentAttachments.getPrimaryKey()) == null) {

				cacheResult(documentAttachments);
			}
			else {
				documentAttachments.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all document attachmentses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentAttachmentsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the document attachments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentAttachments documentAttachments) {
		entityCache.removeResult(
			entityCacheEnabled, DocumentAttachmentsImpl.class,
			documentAttachments.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(DocumentAttachmentsModelImpl)documentAttachments, true);
	}

	@Override
	public void clearCache(List<DocumentAttachments> documentAttachmentses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DocumentAttachments documentAttachments : documentAttachmentses) {
			entityCache.removeResult(
				entityCacheEnabled, DocumentAttachmentsImpl.class,
				documentAttachments.getPrimaryKey());

			clearUniqueFindersCache(
				(DocumentAttachmentsModelImpl)documentAttachments, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DocumentAttachmentsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DocumentAttachmentsModelImpl documentAttachmentsModelImpl) {

		Object[] args = new Object[] {
			documentAttachmentsModelImpl.getAttachmentId()
		};

		finderCache.putResult(
			_finderPathCountByAttachment, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByAttachment, args, documentAttachmentsModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		DocumentAttachmentsModelImpl documentAttachmentsModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				documentAttachmentsModelImpl.getAttachmentId()
			};

			finderCache.removeResult(_finderPathCountByAttachment, args);
			finderCache.removeResult(_finderPathFetchByAttachment, args);
		}

		if ((documentAttachmentsModelImpl.getColumnBitmask() &
			 _finderPathFetchByAttachment.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				documentAttachmentsModelImpl.getOriginalAttachmentId()
			};

			finderCache.removeResult(_finderPathCountByAttachment, args);
			finderCache.removeResult(_finderPathFetchByAttachment, args);
		}
	}

	/**
	 * Creates a new document attachments with the primary key. Does not add the document attachments to the database.
	 *
	 * @param attachmentId the primary key for the new document attachments
	 * @return the new document attachments
	 */
	@Override
	public DocumentAttachments create(long attachmentId) {
		DocumentAttachments documentAttachments = new DocumentAttachmentsImpl();

		documentAttachments.setNew(true);
		documentAttachments.setPrimaryKey(attachmentId);

		return documentAttachments;
	}

	/**
	 * Removes the document attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments that was removed
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	@Override
	public DocumentAttachments remove(long attachmentId)
		throws NoSuchDocumentAttachmentsException {

		return remove((Serializable)attachmentId);
	}

	/**
	 * Removes the document attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document attachments
	 * @return the document attachments that was removed
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	@Override
	public DocumentAttachments remove(Serializable primaryKey)
		throws NoSuchDocumentAttachmentsException {

		Session session = null;

		try {
			session = openSession();

			DocumentAttachments documentAttachments =
				(DocumentAttachments)session.get(
					DocumentAttachmentsImpl.class, primaryKey);

			if (documentAttachments == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentAttachmentsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(documentAttachments);
		}
		catch (NoSuchDocumentAttachmentsException noSuchEntityException) {
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
	protected DocumentAttachments removeImpl(
		DocumentAttachments documentAttachments) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentAttachments)) {
				documentAttachments = (DocumentAttachments)session.get(
					DocumentAttachmentsImpl.class,
					documentAttachments.getPrimaryKeyObj());
			}

			if (documentAttachments != null) {
				session.delete(documentAttachments);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (documentAttachments != null) {
			clearCache(documentAttachments);
		}

		return documentAttachments;
	}

	@Override
	public DocumentAttachments updateImpl(
		DocumentAttachments documentAttachments) {

		boolean isNew = documentAttachments.isNew();

		if (!(documentAttachments instanceof DocumentAttachmentsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(documentAttachments.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					documentAttachments);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in documentAttachments proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocumentAttachments implementation " +
					documentAttachments.getClass());
		}

		DocumentAttachmentsModelImpl documentAttachmentsModelImpl =
			(DocumentAttachmentsModelImpl)documentAttachments;

		Session session = null;

		try {
			session = openSession();

			if (documentAttachments.isNew()) {
				session.save(documentAttachments);

				documentAttachments.setNew(false);
			}
			else {
				documentAttachments = (DocumentAttachments)session.merge(
					documentAttachments);
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
				documentAttachmentsModelImpl.getDocId()
			};

			finderCache.removeResult(_finderPathCountBydocId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBydocId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((documentAttachmentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBydocId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					documentAttachmentsModelImpl.getOriginalDocId()
				};

				finderCache.removeResult(_finderPathCountBydocId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBydocId, args);

				args = new Object[] {documentAttachmentsModelImpl.getDocId()};

				finderCache.removeResult(_finderPathCountBydocId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBydocId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DocumentAttachmentsImpl.class,
			documentAttachments.getPrimaryKey(), documentAttachments, false);

		clearUniqueFindersCache(documentAttachmentsModelImpl, false);
		cacheUniqueFindersCache(documentAttachmentsModelImpl);

		documentAttachments.resetOriginalValues();

		return documentAttachments;
	}

	/**
	 * Returns the document attachments with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document attachments
	 * @return the document attachments
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	@Override
	public DocumentAttachments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentAttachmentsException {

		DocumentAttachments documentAttachments = fetchByPrimaryKey(primaryKey);

		if (documentAttachments == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentAttachmentsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return documentAttachments;
	}

	/**
	 * Returns the document attachments with the primary key or throws a <code>NoSuchDocumentAttachmentsException</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments
	 * @throws NoSuchDocumentAttachmentsException if a document attachments with the primary key could not be found
	 */
	@Override
	public DocumentAttachments findByPrimaryKey(long attachmentId)
		throws NoSuchDocumentAttachmentsException {

		return findByPrimaryKey((Serializable)attachmentId);
	}

	/**
	 * Returns the document attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments, or <code>null</code> if a document attachments with the primary key could not be found
	 */
	@Override
	public DocumentAttachments fetchByPrimaryKey(long attachmentId) {
		return fetchByPrimaryKey((Serializable)attachmentId);
	}

	/**
	 * Returns all the document attachmentses.
	 *
	 * @return the document attachmentses
	 */
	@Override
	public List<DocumentAttachments> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @return the range of document attachmentses
	 */
	@Override
	public List<DocumentAttachments> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the document attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document attachmentses
	 */
	@Override
	public List<DocumentAttachments> findAll(
		int start, int end,
		OrderByComparator<DocumentAttachments> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document attachmentses
	 */
	@Override
	public List<DocumentAttachments> findAll(
		int start, int end,
		OrderByComparator<DocumentAttachments> orderByComparator,
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

		List<DocumentAttachments> list = null;

		if (useFinderCache) {
			list = (List<DocumentAttachments>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DOCUMENTATTACHMENTS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTATTACHMENTS;

				sql = sql.concat(DocumentAttachmentsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<DocumentAttachments>)QueryUtil.list(
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
	 * Removes all the document attachmentses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentAttachments documentAttachments : findAll()) {
			remove(documentAttachments);
		}
	}

	/**
	 * Returns the number of document attachmentses.
	 *
	 * @return the number of document attachmentses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOCUMENTATTACHMENTS);

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
		return _SQL_SELECT_DOCUMENTATTACHMENTS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentAttachmentsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document attachments persistence.
	 */
	@Activate
	public void activate() {
		DocumentAttachmentsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DocumentAttachmentsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DocumentAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DocumentAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBydocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DocumentAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydocId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBydocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DocumentAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydocId",
			new String[] {Long.class.getName()},
			DocumentAttachmentsModelImpl.DOCID_COLUMN_BITMASK |
			DocumentAttachmentsModelImpl.VIEW_COLUMN_BITMASK);

		_finderPathCountBydocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydocId",
			new String[] {Long.class.getName()});

		_finderPathFetchByAttachment = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DocumentAttachmentsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByAttachment", new String[] {Long.class.getName()},
			DocumentAttachmentsModelImpl.ATTACHMENTID_COLUMN_BITMASK);

		_finderPathCountByAttachment = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttachment",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DocumentAttachmentsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.DocumentAttachments"),
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

	private static final String _SQL_SELECT_DOCUMENTATTACHMENTS =
		"SELECT documentAttachments FROM DocumentAttachments documentAttachments";

	private static final String _SQL_SELECT_DOCUMENTATTACHMENTS_WHERE =
		"SELECT documentAttachments FROM DocumentAttachments documentAttachments WHERE ";

	private static final String _SQL_COUNT_DOCUMENTATTACHMENTS =
		"SELECT COUNT(documentAttachments) FROM DocumentAttachments documentAttachments";

	private static final String _SQL_COUNT_DOCUMENTATTACHMENTS_WHERE =
		"SELECT COUNT(documentAttachments) FROM DocumentAttachments documentAttachments WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "documentAttachments.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DocumentAttachments exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DocumentAttachments exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentAttachmentsPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}