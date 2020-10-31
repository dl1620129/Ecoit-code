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

import com.ecoit.elegaldocument.exception.NoSuchLegalFieldException;
import com.ecoit.elegaldocument.model.LegalField;
import com.ecoit.elegaldocument.model.impl.LegalFieldImpl;
import com.ecoit.elegaldocument.model.impl.LegalFieldModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalFieldPersistence;
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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
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
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the legal field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalFieldPersistence.class)
public class LegalFieldPersistenceImpl
	extends BasePersistenceImpl<LegalField> implements LegalFieldPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalFieldUtil</code> to access the legal field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalFieldImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByFieldId;
	private FinderPath _finderPathCountByFieldId;

	/**
	 * Returns the legal field where fieldId = &#63; or throws a <code>NoSuchLegalFieldException</code> if it could not be found.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByFieldId(long fieldId)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByFieldId(fieldId);

		if (legalField == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fieldId=");
			msg.append(fieldId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalFieldException(msg.toString());
		}

		return legalField;
	}

	/**
	 * Returns the legal field where fieldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByFieldId(long fieldId) {
		return fetchByFieldId(fieldId, true);
	}

	/**
	 * Returns the legal field where fieldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldId the field ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByFieldId(long fieldId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {fieldId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFieldId, finderArgs, this);
		}

		if (result instanceof LegalField) {
			LegalField legalField = (LegalField)result;

			if (fieldId != legalField.getFieldId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_FIELDID_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				List<LegalField> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFieldId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {fieldId};
							}

							_log.warn(
								"LegalFieldPersistenceImpl.fetchByFieldId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalField legalField = list.get(0);

					result = legalField;

					cacheResult(legalField);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByFieldId, finderArgs);
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
			return (LegalField)result;
		}
	}

	/**
	 * Removes the legal field where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @return the legal field that was removed
	 */
	@Override
	public LegalField removeByFieldId(long fieldId)
		throws NoSuchLegalFieldException {

		LegalField legalField = findByFieldId(fieldId);

		return remove(legalField);
	}

	/**
	 * Returns the number of legal fields where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByFieldId(long fieldId) {
		FinderPath finderPath = _finderPathCountByFieldId;

		Object[] finderArgs = new Object[] {fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_FIELDID_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

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

	private static final String _FINDER_COLUMN_FIELDID_FIELDID_2 =
		"legalField.fieldId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the legal fields where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal fields
	 */
	@Override
	public List<LegalField> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	@Override
	public List<LegalField> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<LegalField> list = null;

		if (useFinderCache) {
			list = (List<LegalField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalField legalField : list) {
					if (groupId != legalField.getGroupId()) {
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

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalField>)QueryUtil.list(
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
	 * Returns the first legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByGroupId_First(
			long groupId, OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByGroupId_First(
			groupId, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByGroupId_First(
		long groupId, OrderByComparator<LegalField> orderByComparator) {

		List<LegalField> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByGroupId_Last(
			long groupId, OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByGroupId_Last(groupId, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalField> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LegalField> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField[] findByGroupId_PrevAndNext(
			long fieldId, long groupId,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			LegalField[] array = new LegalFieldImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, legalField, groupId, orderByComparator, true);

			array[1] = legalField;

			array[2] = getByGroupId_PrevAndNext(
				session, legalField, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalField getByGroupId_PrevAndNext(
		Session session, LegalField legalField, long groupId,
		OrderByComparator<LegalField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFIELD_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fields where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LegalField legalField :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalField);
		}
	}

	/**
	 * Returns the number of legal fields where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"legalField.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L;
	private FinderPath _finderPathWithoutPaginationFindByG_L;
	private FinderPath _finderPathCountByG_L;

	/**
	 * Returns all the legal fields where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal fields
	 */
	@Override
	public List<LegalField> findByG_L(long groupId, String language) {
		return findByG_L(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	@Override
	public List<LegalField> findByG_L(
		long groupId, String language, int start, int end) {

		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return findByG_L(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L;
				finderArgs = new Object[] {groupId, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L;
			finderArgs = new Object[] {
				groupId, language, start, end, orderByComparator
			};
		}

		List<LegalField> list = null;

		if (useFinderCache) {
			list = (List<LegalField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalField legalField : list) {
					if ((groupId != legalField.getGroupId()) ||
						!language.equals(legalField.getLanguage())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindLanguage) {
					qPos.add(language);
				}

				list = (List<LegalField>)QueryUtil.list(
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
	 * Returns the first legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByG_L_First(
			groupId, language, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalField> orderByComparator) {

		List<LegalField> list = findByG_L(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByG_L_Last(
			groupId, language, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalField> orderByComparator) {

		int count = countByG_L(groupId, language);

		if (count == 0) {
			return null;
		}

		List<LegalField> list = findByG_L(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField[] findByG_L_PrevAndNext(
			long fieldId, long groupId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		language = Objects.toString(language, "");

		LegalField legalField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			LegalField[] array = new LegalFieldImpl[3];

			array[0] = getByG_L_PrevAndNext(
				session, legalField, groupId, language, orderByComparator,
				true);

			array[1] = legalField;

			array[2] = getByG_L_PrevAndNext(
				session, legalField, groupId, language, orderByComparator,
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

	protected LegalField getByG_L_PrevAndNext(
		Session session, LegalField legalField, long groupId, String language,
		OrderByComparator<LegalField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALFIELD_WHERE);

		query.append(_FINDER_COLUMN_G_L_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
		}

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
			query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByG_L(long groupId, String language) {
		for (LegalField legalField :
				findByG_L(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalField);
		}
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByG_L(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindLanguage) {
					qPos.add(language);
				}

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

	private static final String _FINDER_COLUMN_G_L_GROUPID_2 =
		"legalField.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 =
		"legalField.language = ?";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 =
		"(legalField.language IS NULL OR legalField.language = '')";

	private FinderPath _finderPathFetchByG_F;
	private FinderPath _finderPathCountByG_F;

	/**
	 * Returns the legal field where groupId = &#63; and fieldId = &#63; or throws a <code>NoSuchLegalFieldException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByG_F(long groupId, long fieldId)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByG_F(groupId, fieldId);

		if (legalField == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", fieldId=");
			msg.append(fieldId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalFieldException(msg.toString());
		}

		return legalField;
	}

	/**
	 * Returns the legal field where groupId = &#63; and fieldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByG_F(long groupId, long fieldId) {
		return fetchByG_F(groupId, fieldId, true);
	}

	/**
	 * Returns the legal field where groupId = &#63; and fieldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByG_F(
		long groupId, long fieldId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, fieldId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_F, finderArgs, this);
		}

		if (result instanceof LegalField) {
			LegalField legalField = (LegalField)result;

			if ((groupId != legalField.getGroupId()) ||
				(fieldId != legalField.getFieldId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_G_F_GROUPID_2);

			query.append(_FINDER_COLUMN_G_F_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(fieldId);

				List<LegalField> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_F, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupId, fieldId};
							}

							_log.warn(
								"LegalFieldPersistenceImpl.fetchByG_F(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalField legalField = list.get(0);

					result = legalField;

					cacheResult(legalField);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByG_F, finderArgs);
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
			return (LegalField)result;
		}
	}

	/**
	 * Removes the legal field where groupId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the legal field that was removed
	 */
	@Override
	public LegalField removeByG_F(long groupId, long fieldId)
		throws NoSuchLegalFieldException {

		LegalField legalField = findByG_F(groupId, fieldId);

		return remove(legalField);
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByG_F(long groupId, long fieldId) {
		FinderPath finderPath = _finderPathCountByG_F;

		Object[] finderArgs = new Object[] {groupId, fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_G_F_GROUPID_2);

			query.append(_FINDER_COLUMN_G_F_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(fieldId);

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

	private static final String _FINDER_COLUMN_G_F_GROUPID_2 =
		"legalField.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_F_FIELDID_2 =
		"legalField.fieldId = ?";

	private FinderPath _finderPathWithPaginationFindByS_L;
	private FinderPath _finderPathWithoutPaginationFindByS_L;
	private FinderPath _finderPathCountByS_L;

	/**
	 * Returns all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @return the matching legal fields
	 */
	@Override
	public List<LegalField> findByS_L(
		long groupId, boolean statusField, String language) {

		return findByS_L(
			groupId, statusField, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	@Override
	public List<LegalField> findByS_L(
		long groupId, boolean statusField, String language, int start,
		int end) {

		return findByS_L(groupId, statusField, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByS_L(
		long groupId, boolean statusField, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return findByS_L(
			groupId, statusField, language, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByS_L(
		long groupId, boolean statusField, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_L;
				finderArgs = new Object[] {groupId, statusField, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_L;
			finderArgs = new Object[] {
				groupId, statusField, language, start, end, orderByComparator
			};
		}

		List<LegalField> list = null;

		if (useFinderCache) {
			list = (List<LegalField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalField legalField : list) {
					if ((groupId != legalField.getGroupId()) ||
						(statusField != legalField.isStatusField()) ||
						!language.equals(legalField.getLanguage())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_S_L_GROUPID_2);

			query.append(_FINDER_COLUMN_S_L_STATUSFIELD_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusField);

				if (bindLanguage) {
					qPos.add(language);
				}

				list = (List<LegalField>)QueryUtil.list(
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
	 * Returns the first legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByS_L_First(
			long groupId, boolean statusField, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByS_L_First(
			groupId, statusField, language, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusField=");
		msg.append(statusField);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByS_L_First(
		long groupId, boolean statusField, String language,
		OrderByComparator<LegalField> orderByComparator) {

		List<LegalField> list = findByS_L(
			groupId, statusField, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByS_L_Last(
			long groupId, boolean statusField, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByS_L_Last(
			groupId, statusField, language, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusField=");
		msg.append(statusField);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByS_L_Last(
		long groupId, boolean statusField, String language,
		OrderByComparator<LegalField> orderByComparator) {

		int count = countByS_L(groupId, statusField, language);

		if (count == 0) {
			return null;
		}

		List<LegalField> list = findByS_L(
			groupId, statusField, language, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField[] findByS_L_PrevAndNext(
			long fieldId, long groupId, boolean statusField, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		language = Objects.toString(language, "");

		LegalField legalField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			LegalField[] array = new LegalFieldImpl[3];

			array[0] = getByS_L_PrevAndNext(
				session, legalField, groupId, statusField, language,
				orderByComparator, true);

			array[1] = legalField;

			array[2] = getByS_L_PrevAndNext(
				session, legalField, groupId, statusField, language,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalField getByS_L_PrevAndNext(
		Session session, LegalField legalField, long groupId,
		boolean statusField, String language,
		OrderByComparator<LegalField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALFIELD_WHERE);

		query.append(_FINDER_COLUMN_S_L_GROUPID_2);

		query.append(_FINDER_COLUMN_S_L_STATUSFIELD_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
		}

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
			query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusField);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 */
	@Override
	public void removeByS_L(
		long groupId, boolean statusField, String language) {

		for (LegalField legalField :
				findByS_L(
					groupId, statusField, language, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalField);
		}
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByS_L(long groupId, boolean statusField, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByS_L;

		Object[] finderArgs = new Object[] {groupId, statusField, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_S_L_GROUPID_2);

			query.append(_FINDER_COLUMN_S_L_STATUSFIELD_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusField);

				if (bindLanguage) {
					qPos.add(language);
				}

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

	private static final String _FINDER_COLUMN_S_L_GROUPID_2 =
		"legalField.groupId = ? AND ";

	private static final String _FINDER_COLUMN_S_L_STATUSFIELD_2 =
		"legalField.statusField = ? AND ";

	private static final String _FINDER_COLUMN_S_L_LANGUAGE_2 =
		"legalField.language = ?";

	private static final String _FINDER_COLUMN_S_L_LANGUAGE_3 =
		"(legalField.language IS NULL OR legalField.language = '')";

	private FinderPath _finderPathWithPaginationFindByG_C_L;
	private FinderPath _finderPathWithoutPaginationFindByG_C_L;
	private FinderPath _finderPathCountByG_C_L;

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the matching legal fields
	 */
	@Override
	public List<LegalField> findByG_C_L(
		long groupId, long companyId, String language) {

		return findByG_C_L(
			groupId, companyId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	@Override
	public List<LegalField> findByG_C_L(
		long groupId, long companyId, String language, int start, int end) {

		return findByG_C_L(groupId, companyId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return findByG_C_L(
			groupId, companyId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_L;
				finderArgs = new Object[] {groupId, companyId, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_L;
			finderArgs = new Object[] {
				groupId, companyId, language, start, end, orderByComparator
			};
		}

		List<LegalField> list = null;

		if (useFinderCache) {
			list = (List<LegalField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalField legalField : list) {
					if ((groupId != legalField.getGroupId()) ||
						(companyId != legalField.getCompanyId()) ||
						!language.equals(legalField.getLanguage())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (bindLanguage) {
					qPos.add(language);
				}

				list = (List<LegalField>)QueryUtil.list(
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
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByG_C_L_First(
			long groupId, long companyId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByG_C_L_First(
			groupId, companyId, language, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByG_C_L_First(
		long groupId, long companyId, String language,
		OrderByComparator<LegalField> orderByComparator) {

		List<LegalField> list = findByG_C_L(
			groupId, companyId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByG_C_L_Last(
			long groupId, long companyId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByG_C_L_Last(
			groupId, companyId, language, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByG_C_L_Last(
		long groupId, long companyId, String language,
		OrderByComparator<LegalField> orderByComparator) {

		int count = countByG_C_L(groupId, companyId, language);

		if (count == 0) {
			return null;
		}

		List<LegalField> list = findByG_C_L(
			groupId, companyId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField[] findByG_C_L_PrevAndNext(
			long fieldId, long groupId, long companyId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		language = Objects.toString(language, "");

		LegalField legalField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			LegalField[] array = new LegalFieldImpl[3];

			array[0] = getByG_C_L_PrevAndNext(
				session, legalField, groupId, companyId, language,
				orderByComparator, true);

			array[1] = legalField;

			array[2] = getByG_C_L_PrevAndNext(
				session, legalField, groupId, companyId, language,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalField getByG_C_L_PrevAndNext(
		Session session, LegalField legalField, long groupId, long companyId,
		String language, OrderByComparator<LegalField> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALFIELD_WHERE);

		query.append(_FINDER_COLUMN_G_C_L_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_L_COMPANYID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_2);
		}

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
			query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 */
	@Override
	public void removeByG_C_L(long groupId, long companyId, String language) {
		for (LegalField legalField :
				findByG_C_L(
					groupId, companyId, language, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalField);
		}
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByG_C_L(long groupId, long companyId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_C_L;

		Object[] finderArgs = new Object[] {groupId, companyId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (bindLanguage) {
					qPos.add(language);
				}

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

	private static final String _FINDER_COLUMN_G_C_L_GROUPID_2 =
		"legalField.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_COMPANYID_2 =
		"legalField.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_LANGUAGE_2 =
		"legalField.language = ?";

	private static final String _FINDER_COLUMN_G_C_L_LANGUAGE_3 =
		"(legalField.language IS NULL OR legalField.language = '')";

	private FinderPath _finderPathWithPaginationFindByG_C_L_S;
	private FinderPath _finderPathWithoutPaginationFindByG_C_L_S;
	private FinderPath _finderPathCountByG_C_L_S;

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @return the matching legal fields
	 */
	@Override
	public List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField) {

		return findByG_C_L_S(
			groupId, companyId, language, statusField, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	@Override
	public List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField,
		int start, int end) {

		return findByG_C_L_S(
			groupId, companyId, language, statusField, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField,
		int start, int end, OrderByComparator<LegalField> orderByComparator) {

		return findByG_C_L_S(
			groupId, companyId, language, statusField, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField,
		int start, int end, OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_L_S;
				finderArgs = new Object[] {
					groupId, companyId, language, statusField
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_L_S;
			finderArgs = new Object[] {
				groupId, companyId, language, statusField, start, end,
				orderByComparator
			};
		}

		List<LegalField> list = null;

		if (useFinderCache) {
			list = (List<LegalField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalField legalField : list) {
					if ((groupId != legalField.getGroupId()) ||
						(companyId != legalField.getCompanyId()) ||
						!language.equals(legalField.getLanguage()) ||
						(statusField != legalField.isStatusField())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_S_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_C_L_S_STATUSFIELD_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(statusField);

				list = (List<LegalField>)QueryUtil.list(
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
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByG_C_L_S_First(
			long groupId, long companyId, String language, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByG_C_L_S_First(
			groupId, companyId, language, statusField, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusField=");
		msg.append(statusField);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByG_C_L_S_First(
		long groupId, long companyId, String language, boolean statusField,
		OrderByComparator<LegalField> orderByComparator) {

		List<LegalField> list = findByG_C_L_S(
			groupId, companyId, language, statusField, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByG_C_L_S_Last(
			long groupId, long companyId, String language, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByG_C_L_S_Last(
			groupId, companyId, language, statusField, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusField=");
		msg.append(statusField);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByG_C_L_S_Last(
		long groupId, long companyId, String language, boolean statusField,
		OrderByComparator<LegalField> orderByComparator) {

		int count = countByG_C_L_S(groupId, companyId, language, statusField);

		if (count == 0) {
			return null;
		}

		List<LegalField> list = findByG_C_L_S(
			groupId, companyId, language, statusField, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField[] findByG_C_L_S_PrevAndNext(
			long fieldId, long groupId, long companyId, String language,
			boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		language = Objects.toString(language, "");

		LegalField legalField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			LegalField[] array = new LegalFieldImpl[3];

			array[0] = getByG_C_L_S_PrevAndNext(
				session, legalField, groupId, companyId, language, statusField,
				orderByComparator, true);

			array[1] = legalField;

			array[2] = getByG_C_L_S_PrevAndNext(
				session, legalField, groupId, companyId, language, statusField,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalField getByG_C_L_S_PrevAndNext(
		Session session, LegalField legalField, long groupId, long companyId,
		String language, boolean statusField,
		OrderByComparator<LegalField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALFIELD_WHERE);

		query.append(_FINDER_COLUMN_G_C_L_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_L_S_COMPANYID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_C_L_S_STATUSFIELD_2);

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
			query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (bindLanguage) {
			qPos.add(language);
		}

		qPos.add(statusField);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 */
	@Override
	public void removeByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField) {

		for (LegalField legalField :
				findByG_C_L_S(
					groupId, companyId, language, statusField,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalField);
		}
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_C_L_S;

		Object[] finderArgs = new Object[] {
			groupId, companyId, language, statusField
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_S_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_C_L_S_STATUSFIELD_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(statusField);

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

	private static final String _FINDER_COLUMN_G_C_L_S_GROUPID_2 =
		"legalField.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_COMPANYID_2 =
		"legalField.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_LANGUAGE_2 =
		"legalField.language = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_LANGUAGE_3 =
		"(legalField.language IS NULL OR legalField.language = '') AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_STATUSFIELD_2 =
		"legalField.statusField = ?";

	private FinderPath _finderPathWithPaginationFindByFieldStatus;
	private FinderPath _finderPathWithoutPaginationFindByFieldStatus;
	private FinderPath _finderPathCountByFieldStatus;

	/**
	 * Returns all the legal fields where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @return the matching legal fields
	 */
	@Override
	public List<LegalField> findByFieldStatus(boolean statusField) {
		return findByFieldStatus(
			statusField, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fields where statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	@Override
	public List<LegalField> findByFieldStatus(
		boolean statusField, int start, int end) {

		return findByFieldStatus(statusField, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fields where statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByFieldStatus(
		boolean statusField, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return findByFieldStatus(
			statusField, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fields where statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByFieldStatus(
		boolean statusField, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFieldStatus;
				finderArgs = new Object[] {statusField};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFieldStatus;
			finderArgs = new Object[] {
				statusField, start, end, orderByComparator
			};
		}

		List<LegalField> list = null;

		if (useFinderCache) {
			list = (List<LegalField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalField legalField : list) {
					if (statusField != legalField.isStatusField()) {
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

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_FIELDSTATUS_STATUSFIELD_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusField);

				list = (List<LegalField>)QueryUtil.list(
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
	 * Returns the first legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByFieldStatus_First(
			boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByFieldStatus_First(
			statusField, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusField=");
		msg.append(statusField);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the first legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByFieldStatus_First(
		boolean statusField, OrderByComparator<LegalField> orderByComparator) {

		List<LegalField> list = findByFieldStatus(
			statusField, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByFieldStatus_Last(
			boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByFieldStatus_Last(
			statusField, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusField=");
		msg.append(statusField);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the last legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByFieldStatus_Last(
		boolean statusField, OrderByComparator<LegalField> orderByComparator) {

		int count = countByFieldStatus(statusField);

		if (count == 0) {
			return null;
		}

		List<LegalField> list = findByFieldStatus(
			statusField, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where statusField = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField[] findByFieldStatus_PrevAndNext(
			long fieldId, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			LegalField[] array = new LegalFieldImpl[3];

			array[0] = getByFieldStatus_PrevAndNext(
				session, legalField, statusField, orderByComparator, true);

			array[1] = legalField;

			array[2] = getByFieldStatus_PrevAndNext(
				session, legalField, statusField, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalField getByFieldStatus_PrevAndNext(
		Session session, LegalField legalField, boolean statusField,
		OrderByComparator<LegalField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFIELD_WHERE);

		query.append(_FINDER_COLUMN_FIELDSTATUS_STATUSFIELD_2);

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
			query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statusField);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fields where statusField = &#63; from the database.
	 *
	 * @param statusField the status field
	 */
	@Override
	public void removeByFieldStatus(boolean statusField) {
		for (LegalField legalField :
				findByFieldStatus(
					statusField, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalField);
		}
	}

	/**
	 * Returns the number of legal fields where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByFieldStatus(boolean statusField) {
		FinderPath finderPath = _finderPathCountByFieldStatus;

		Object[] finderArgs = new Object[] {statusField};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_FIELDSTATUS_STATUSFIELD_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusField);

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

	private static final String _FINDER_COLUMN_FIELDSTATUS_STATUSFIELD_2 =
		"legalField.statusField = ?";

	private FinderPath _finderPathWithPaginationFindByS_Rss;
	private FinderPath _finderPathWithoutPaginationFindByS_Rss;
	private FinderPath _finderPathCountByS_Rss;

	/**
	 * Returns all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @return the matching legal fields
	 */
	@Override
	public List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable) {

		return findByS_Rss(
			groupId, statusField, rssable, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	@Override
	public List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable, int start,
		int end) {

		return findByS_Rss(groupId, statusField, rssable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return findByS_Rss(
			groupId, statusField, rssable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_Rss;
				finderArgs = new Object[] {groupId, statusField, rssable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_Rss;
			finderArgs = new Object[] {
				groupId, statusField, rssable, start, end, orderByComparator
			};
		}

		List<LegalField> list = null;

		if (useFinderCache) {
			list = (List<LegalField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalField legalField : list) {
					if ((groupId != legalField.getGroupId()) ||
						(statusField != legalField.isStatusField()) ||
						(rssable != legalField.isRssable())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_S_RSS_GROUPID_2);

			query.append(_FINDER_COLUMN_S_RSS_STATUSFIELD_2);

			query.append(_FINDER_COLUMN_S_RSS_RSSABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusField);

				qPos.add(rssable);

				list = (List<LegalField>)QueryUtil.list(
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
	 * Returns the first legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByS_Rss_First(
			long groupId, boolean statusField, boolean rssable,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByS_Rss_First(
			groupId, statusField, rssable, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusField=");
		msg.append(statusField);

		msg.append(", rssable=");
		msg.append(rssable);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByS_Rss_First(
		long groupId, boolean statusField, boolean rssable,
		OrderByComparator<LegalField> orderByComparator) {

		List<LegalField> list = findByS_Rss(
			groupId, statusField, rssable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByS_Rss_Last(
			long groupId, boolean statusField, boolean rssable,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByS_Rss_Last(
			groupId, statusField, rssable, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusField=");
		msg.append(statusField);

		msg.append(", rssable=");
		msg.append(rssable);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByS_Rss_Last(
		long groupId, boolean statusField, boolean rssable,
		OrderByComparator<LegalField> orderByComparator) {

		int count = countByS_Rss(groupId, statusField, rssable);

		if (count == 0) {
			return null;
		}

		List<LegalField> list = findByS_Rss(
			groupId, statusField, rssable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField[] findByS_Rss_PrevAndNext(
			long fieldId, long groupId, boolean statusField, boolean rssable,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			LegalField[] array = new LegalFieldImpl[3];

			array[0] = getByS_Rss_PrevAndNext(
				session, legalField, groupId, statusField, rssable,
				orderByComparator, true);

			array[1] = legalField;

			array[2] = getByS_Rss_PrevAndNext(
				session, legalField, groupId, statusField, rssable,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalField getByS_Rss_PrevAndNext(
		Session session, LegalField legalField, long groupId,
		boolean statusField, boolean rssable,
		OrderByComparator<LegalField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALFIELD_WHERE);

		query.append(_FINDER_COLUMN_S_RSS_GROUPID_2);

		query.append(_FINDER_COLUMN_S_RSS_STATUSFIELD_2);

		query.append(_FINDER_COLUMN_S_RSS_RSSABLE_2);

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
			query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusField);

		qPos.add(rssable);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 */
	@Override
	public void removeByS_Rss(
		long groupId, boolean statusField, boolean rssable) {

		for (LegalField legalField :
				findByS_Rss(
					groupId, statusField, rssable, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalField);
		}
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByS_Rss(
		long groupId, boolean statusField, boolean rssable) {

		FinderPath finderPath = _finderPathCountByS_Rss;

		Object[] finderArgs = new Object[] {groupId, statusField, rssable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_S_RSS_GROUPID_2);

			query.append(_FINDER_COLUMN_S_RSS_STATUSFIELD_2);

			query.append(_FINDER_COLUMN_S_RSS_RSSABLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusField);

				qPos.add(rssable);

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

	private static final String _FINDER_COLUMN_S_RSS_GROUPID_2 =
		"legalField.groupId = ? AND ";

	private static final String _FINDER_COLUMN_S_RSS_STATUSFIELD_2 =
		"legalField.statusField = ? AND ";

	private static final String _FINDER_COLUMN_S_RSS_RSSABLE_2 =
		"legalField.rssable = ?";

	private FinderPath _finderPathWithPaginationFindByFindGroup;
	private FinderPath _finderPathWithoutPaginationFindByFindGroup;
	private FinderPath _finderPathCountByFindGroup;

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @return the matching legal fields
	 */
	@Override
	public List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField) {

		return findByFindGroup(
			groupId, companyId, statusField, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	@Override
	public List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField, int start, int end) {

		return findByFindGroup(
			groupId, companyId, statusField, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return findByFindGroup(
			groupId, companyId, statusField, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindGroup;
				finderArgs = new Object[] {groupId, companyId, statusField};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindGroup;
			finderArgs = new Object[] {
				groupId, companyId, statusField, start, end, orderByComparator
			};
		}

		List<LegalField> list = null;

		if (useFinderCache) {
			list = (List<LegalField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalField legalField : list) {
					if ((groupId != legalField.getGroupId()) ||
						(companyId != legalField.getCompanyId()) ||
						(statusField != legalField.isStatusField())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSFIELD_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusField);

				list = (List<LegalField>)QueryUtil.list(
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
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByFindGroup_First(
			long groupId, long companyId, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByFindGroup_First(
			groupId, companyId, statusField, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusField=");
		msg.append(statusField);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByFindGroup_First(
		long groupId, long companyId, boolean statusField,
		OrderByComparator<LegalField> orderByComparator) {

		List<LegalField> list = findByFindGroup(
			groupId, companyId, statusField, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByFindGroup_Last(
			long groupId, long companyId, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByFindGroup_Last(
			groupId, companyId, statusField, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusField=");
		msg.append(statusField);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusField,
		OrderByComparator<LegalField> orderByComparator) {

		int count = countByFindGroup(groupId, companyId, statusField);

		if (count == 0) {
			return null;
		}

		List<LegalField> list = findByFindGroup(
			groupId, companyId, statusField, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField[] findByFindGroup_PrevAndNext(
			long fieldId, long groupId, long companyId, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			LegalField[] array = new LegalFieldImpl[3];

			array[0] = getByFindGroup_PrevAndNext(
				session, legalField, groupId, companyId, statusField,
				orderByComparator, true);

			array[1] = legalField;

			array[2] = getByFindGroup_PrevAndNext(
				session, legalField, groupId, companyId, statusField,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalField getByFindGroup_PrevAndNext(
		Session session, LegalField legalField, long groupId, long companyId,
		boolean statusField, OrderByComparator<LegalField> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALFIELD_WHERE);

		query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_STATUSFIELD_2);

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
			query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(statusField);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 */
	@Override
	public void removeByFindGroup(
		long groupId, long companyId, boolean statusField) {

		for (LegalField legalField :
				findByFindGroup(
					groupId, companyId, statusField, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalField);
		}
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByFindGroup(
		long groupId, long companyId, boolean statusField) {

		FinderPath finderPath = _finderPathCountByFindGroup;

		Object[] finderArgs = new Object[] {groupId, companyId, statusField};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSFIELD_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusField);

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

	private static final String _FINDER_COLUMN_FINDGROUP_GROUPID_2 =
		"legalField.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_COMPANYID_2 =
		"legalField.companyId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_STATUSFIELD_2 =
		"legalField.statusField = ?";

	private FinderPath _finderPathWithPaginationFindByFindAll;
	private FinderPath _finderPathWithoutPaginationFindByFindAll;
	private FinderPath _finderPathCountByFindAll;

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal fields
	 */
	@Override
	public List<LegalField> findByFindAll(long groupId, long companyId) {
		return findByFindAll(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	@Override
	public List<LegalField> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return findByFindAll(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return findByFindAll(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	@Override
	public List<LegalField> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindAll;
				finderArgs = new Object[] {groupId, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindAll;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<LegalField> list = null;

		if (useFinderCache) {
			list = (List<LegalField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalField legalField : list) {
					if ((groupId != legalField.getGroupId()) ||
						(companyId != legalField.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<LegalField>)QueryUtil.list(
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
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByFindAll_First(
			groupId, companyId, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalField> orderByComparator) {

		List<LegalField> list = findByFindAll(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	@Override
	public LegalField findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByFindAll_Last(
			groupId, companyId, orderByComparator);

		if (legalField != null) {
			return legalField;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalFieldException(msg.toString());
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	@Override
	public LegalField fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalField> orderByComparator) {

		int count = countByFindAll(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<LegalField> list = findByFindAll(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField[] findByFindAll_PrevAndNext(
			long fieldId, long groupId, long companyId,
			OrderByComparator<LegalField> orderByComparator)
		throws NoSuchLegalFieldException {

		LegalField legalField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			LegalField[] array = new LegalFieldImpl[3];

			array[0] = getByFindAll_PrevAndNext(
				session, legalField, groupId, companyId, orderByComparator,
				true);

			array[1] = legalField;

			array[2] = getByFindAll_PrevAndNext(
				session, legalField, groupId, companyId, orderByComparator,
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

	protected LegalField getByFindAll_PrevAndNext(
		Session session, LegalField legalField, long groupId, long companyId,
		OrderByComparator<LegalField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALFIELD_WHERE);

		query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

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
			query.append(LegalFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindAll(long groupId, long companyId) {
		for (LegalField legalField :
				findByFindAll(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalField);
		}
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal fields
	 */
	@Override
	public int countByFindAll(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindAll;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALFIELD_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_FINDALL_GROUPID_2 =
		"legalField.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_COMPANYID_2 =
		"legalField.companyId = ?";

	public LegalFieldPersistenceImpl() {
		setModelClass(LegalField.class);

		setModelImplClass(LegalFieldImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the legal field in the entity cache if it is enabled.
	 *
	 * @param legalField the legal field
	 */
	@Override
	public void cacheResult(LegalField legalField) {
		entityCache.putResult(
			entityCacheEnabled, LegalFieldImpl.class,
			legalField.getPrimaryKey(), legalField);

		finderCache.putResult(
			_finderPathFetchByFieldId, new Object[] {legalField.getFieldId()},
			legalField);

		finderCache.putResult(
			_finderPathFetchByG_F,
			new Object[] {legalField.getGroupId(), legalField.getFieldId()},
			legalField);

		legalField.resetOriginalValues();
	}

	/**
	 * Caches the legal fields in the entity cache if it is enabled.
	 *
	 * @param legalFields the legal fields
	 */
	@Override
	public void cacheResult(List<LegalField> legalFields) {
		for (LegalField legalField : legalFields) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalFieldImpl.class,
					legalField.getPrimaryKey()) == null) {

				cacheResult(legalField);
			}
			else {
				legalField.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal fields.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalFieldImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal field.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalField legalField) {
		entityCache.removeResult(
			entityCacheEnabled, LegalFieldImpl.class,
			legalField.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LegalFieldModelImpl)legalField, true);
	}

	@Override
	public void clearCache(List<LegalField> legalFields) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalField legalField : legalFields) {
			entityCache.removeResult(
				entityCacheEnabled, LegalFieldImpl.class,
				legalField.getPrimaryKey());

			clearUniqueFindersCache((LegalFieldModelImpl)legalField, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalFieldImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalFieldModelImpl legalFieldModelImpl) {

		Object[] args = new Object[] {legalFieldModelImpl.getFieldId()};

		finderCache.putResult(
			_finderPathCountByFieldId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByFieldId, args, legalFieldModelImpl, false);

		args = new Object[] {
			legalFieldModelImpl.getGroupId(), legalFieldModelImpl.getFieldId()
		};

		finderCache.putResult(
			_finderPathCountByG_F, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_F, args, legalFieldModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LegalFieldModelImpl legalFieldModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {legalFieldModelImpl.getFieldId()};

			finderCache.removeResult(_finderPathCountByFieldId, args);
			finderCache.removeResult(_finderPathFetchByFieldId, args);
		}

		if ((legalFieldModelImpl.getColumnBitmask() &
			 _finderPathFetchByFieldId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalFieldModelImpl.getOriginalFieldId()
			};

			finderCache.removeResult(_finderPathCountByFieldId, args);
			finderCache.removeResult(_finderPathFetchByFieldId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalFieldModelImpl.getGroupId(),
				legalFieldModelImpl.getFieldId()
			};

			finderCache.removeResult(_finderPathCountByG_F, args);
			finderCache.removeResult(_finderPathFetchByG_F, args);
		}

		if ((legalFieldModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_F.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalFieldModelImpl.getOriginalGroupId(),
				legalFieldModelImpl.getOriginalFieldId()
			};

			finderCache.removeResult(_finderPathCountByG_F, args);
			finderCache.removeResult(_finderPathFetchByG_F, args);
		}
	}

	/**
	 * Creates a new legal field with the primary key. Does not add the legal field to the database.
	 *
	 * @param fieldId the primary key for the new legal field
	 * @return the new legal field
	 */
	@Override
	public LegalField create(long fieldId) {
		LegalField legalField = new LegalFieldImpl();

		legalField.setNew(true);
		legalField.setPrimaryKey(fieldId);

		legalField.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalField;
	}

	/**
	 * Removes the legal field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field that was removed
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField remove(long fieldId) throws NoSuchLegalFieldException {
		return remove((Serializable)fieldId);
	}

	/**
	 * Removes the legal field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal field
	 * @return the legal field that was removed
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField remove(Serializable primaryKey)
		throws NoSuchLegalFieldException {

		Session session = null;

		try {
			session = openSession();

			LegalField legalField = (LegalField)session.get(
				LegalFieldImpl.class, primaryKey);

			if (legalField == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalFieldException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalField);
		}
		catch (NoSuchLegalFieldException noSuchEntityException) {
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
	protected LegalField removeImpl(LegalField legalField) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalField)) {
				legalField = (LegalField)session.get(
					LegalFieldImpl.class, legalField.getPrimaryKeyObj());
			}

			if (legalField != null) {
				session.delete(legalField);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalField != null) {
			clearCache(legalField);
		}

		return legalField;
	}

	@Override
	public LegalField updateImpl(LegalField legalField) {
		boolean isNew = legalField.isNew();

		if (!(legalField instanceof LegalFieldModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalField.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalField);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalField proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalField implementation " +
					legalField.getClass());
		}

		LegalFieldModelImpl legalFieldModelImpl =
			(LegalFieldModelImpl)legalField;

		Session session = null;

		try {
			session = openSession();

			if (legalField.isNew()) {
				session.save(legalField);

				legalField.setNew(false);
			}
			else {
				legalField = (LegalField)session.merge(legalField);
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
			Object[] args = new Object[] {legalFieldModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				legalFieldModelImpl.getGroupId(),
				legalFieldModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L, args);

			args = new Object[] {
				legalFieldModelImpl.getGroupId(),
				legalFieldModelImpl.isStatusField(),
				legalFieldModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByS_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByS_L, args);

			args = new Object[] {
				legalFieldModelImpl.getGroupId(),
				legalFieldModelImpl.getCompanyId(),
				legalFieldModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_C_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_L, args);

			args = new Object[] {
				legalFieldModelImpl.getGroupId(),
				legalFieldModelImpl.getCompanyId(),
				legalFieldModelImpl.getLanguage(),
				legalFieldModelImpl.isStatusField()
			};

			finderCache.removeResult(_finderPathCountByG_C_L_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_L_S, args);

			args = new Object[] {legalFieldModelImpl.isStatusField()};

			finderCache.removeResult(_finderPathCountByFieldStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFieldStatus, args);

			args = new Object[] {
				legalFieldModelImpl.getGroupId(),
				legalFieldModelImpl.isStatusField(),
				legalFieldModelImpl.isRssable()
			};

			finderCache.removeResult(_finderPathCountByS_Rss, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByS_Rss, args);

			args = new Object[] {
				legalFieldModelImpl.getGroupId(),
				legalFieldModelImpl.getCompanyId(),
				legalFieldModelImpl.isStatusField()
			};

			finderCache.removeResult(_finderPathCountByFindGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindGroup, args);

			args = new Object[] {
				legalFieldModelImpl.getGroupId(),
				legalFieldModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindAll, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAll, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalFieldModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {legalFieldModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((legalFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalFieldModelImpl.getOriginalGroupId(),
					legalFieldModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);

				args = new Object[] {
					legalFieldModelImpl.getGroupId(),
					legalFieldModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);
			}

			if ((legalFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByS_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalFieldModelImpl.getOriginalGroupId(),
					legalFieldModelImpl.getOriginalStatusField(),
					legalFieldModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByS_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_L, args);

				args = new Object[] {
					legalFieldModelImpl.getGroupId(),
					legalFieldModelImpl.isStatusField(),
					legalFieldModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByS_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_L, args);
			}

			if ((legalFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalFieldModelImpl.getOriginalGroupId(),
					legalFieldModelImpl.getOriginalCompanyId(),
					legalFieldModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_C_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L, args);

				args = new Object[] {
					legalFieldModelImpl.getGroupId(),
					legalFieldModelImpl.getCompanyId(),
					legalFieldModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_C_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L, args);
			}

			if ((legalFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_L_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalFieldModelImpl.getOriginalGroupId(),
					legalFieldModelImpl.getOriginalCompanyId(),
					legalFieldModelImpl.getOriginalLanguage(),
					legalFieldModelImpl.getOriginalStatusField()
				};

				finderCache.removeResult(_finderPathCountByG_C_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L_S, args);

				args = new Object[] {
					legalFieldModelImpl.getGroupId(),
					legalFieldModelImpl.getCompanyId(),
					legalFieldModelImpl.getLanguage(),
					legalFieldModelImpl.isStatusField()
				};

				finderCache.removeResult(_finderPathCountByG_C_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L_S, args);
			}

			if ((legalFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFieldStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalFieldModelImpl.getOriginalStatusField()
				};

				finderCache.removeResult(_finderPathCountByFieldStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFieldStatus, args);

				args = new Object[] {legalFieldModelImpl.isStatusField()};

				finderCache.removeResult(_finderPathCountByFieldStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFieldStatus, args);
			}

			if ((legalFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByS_Rss.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalFieldModelImpl.getOriginalGroupId(),
					legalFieldModelImpl.getOriginalStatusField(),
					legalFieldModelImpl.getOriginalRssable()
				};

				finderCache.removeResult(_finderPathCountByS_Rss, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_Rss, args);

				args = new Object[] {
					legalFieldModelImpl.getGroupId(),
					legalFieldModelImpl.isStatusField(),
					legalFieldModelImpl.isRssable()
				};

				finderCache.removeResult(_finderPathCountByS_Rss, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_Rss, args);
			}

			if ((legalFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindGroup.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalFieldModelImpl.getOriginalGroupId(),
					legalFieldModelImpl.getOriginalCompanyId(),
					legalFieldModelImpl.getOriginalStatusField()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);

				args = new Object[] {
					legalFieldModelImpl.getGroupId(),
					legalFieldModelImpl.getCompanyId(),
					legalFieldModelImpl.isStatusField()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);
			}

			if ((legalFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAll.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalFieldModelImpl.getOriginalGroupId(),
					legalFieldModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);

				args = new Object[] {
					legalFieldModelImpl.getGroupId(),
					legalFieldModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalFieldImpl.class,
			legalField.getPrimaryKey(), legalField, false);

		clearUniqueFindersCache(legalFieldModelImpl, false);
		cacheUniqueFindersCache(legalFieldModelImpl);

		legalField.resetOriginalValues();

		return legalField;
	}

	/**
	 * Returns the legal field with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal field
	 * @return the legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalFieldException {

		LegalField legalField = fetchByPrimaryKey(primaryKey);

		if (legalField == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalFieldException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalField;
	}

	/**
	 * Returns the legal field with the primary key or throws a <code>NoSuchLegalFieldException</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField findByPrimaryKey(long fieldId)
		throws NoSuchLegalFieldException {

		return findByPrimaryKey((Serializable)fieldId);
	}

	/**
	 * Returns the legal field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field, or <code>null</code> if a legal field with the primary key could not be found
	 */
	@Override
	public LegalField fetchByPrimaryKey(long fieldId) {
		return fetchByPrimaryKey((Serializable)fieldId);
	}

	/**
	 * Returns all the legal fields.
	 *
	 * @return the legal fields
	 */
	@Override
	public List<LegalField> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of legal fields
	 */
	@Override
	public List<LegalField> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal fields
	 */
	@Override
	public List<LegalField> findAll(
		int start, int end, OrderByComparator<LegalField> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal fields
	 */
	@Override
	public List<LegalField> findAll(
		int start, int end, OrderByComparator<LegalField> orderByComparator,
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

		List<LegalField> list = null;

		if (useFinderCache) {
			list = (List<LegalField>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALFIELD);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALFIELD;

				sql = sql.concat(LegalFieldModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalField>)QueryUtil.list(
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
	 * Removes all the legal fields from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalField legalField : findAll()) {
			remove(legalField);
		}
	}

	/**
	 * Returns the number of legal fields.
	 *
	 * @return the number of legal fields
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALFIELD);

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
		return "fieldId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALFIELD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalFieldModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal field persistence.
	 */
	@Activate
	public void activate() {
		LegalFieldModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalFieldModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByFieldId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByFieldId",
			new String[] {Long.class.getName()},
			LegalFieldModelImpl.FIELDID_COLUMN_BITMASK);

		_finderPathCountByFieldId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFieldId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			LegalFieldModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFieldModelImpl.POSITION_COLUMN_BITMASK |
			LegalFieldModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] {Long.class.getName(), String.class.getName()},
			LegalFieldModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFieldModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalFieldModelImpl.POSITION_COLUMN_BITMASK |
			LegalFieldModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByG_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_F",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalFieldModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFieldModelImpl.FIELDID_COLUMN_BITMASK);

		_finderPathCountByG_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_F",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByS_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByS_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			LegalFieldModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFieldModelImpl.STATUSFIELD_COLUMN_BITMASK |
			LegalFieldModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalFieldModelImpl.POSITION_COLUMN_BITMASK |
			LegalFieldModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByS_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByG_C_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			LegalFieldModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFieldModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalFieldModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalFieldModelImpl.POSITION_COLUMN_BITMASK |
			LegalFieldModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_C_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByG_C_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName()
			},
			LegalFieldModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFieldModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalFieldModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalFieldModelImpl.STATUSFIELD_COLUMN_BITMASK |
			LegalFieldModelImpl.POSITION_COLUMN_BITMASK |
			LegalFieldModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_C_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFieldStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFieldStatus",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFieldStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFieldStatus",
			new String[] {Boolean.class.getName()},
			LegalFieldModelImpl.STATUSFIELD_COLUMN_BITMASK |
			LegalFieldModelImpl.POSITION_COLUMN_BITMASK |
			LegalFieldModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFieldStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFieldStatus",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByS_Rss = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_Rss",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByS_Rss = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_Rss",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			LegalFieldModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFieldModelImpl.STATUSFIELD_COLUMN_BITMASK |
			LegalFieldModelImpl.RSSABLE_COLUMN_BITMASK |
			LegalFieldModelImpl.POSITION_COLUMN_BITMASK |
			LegalFieldModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByS_Rss = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_Rss",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			LegalFieldModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFieldModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalFieldModelImpl.STATUSFIELD_COLUMN_BITMASK |
			LegalFieldModelImpl.POSITION_COLUMN_BITMASK |
			LegalFieldModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalFieldModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFieldModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalFieldModelImpl.POSITION_COLUMN_BITMASK |
			LegalFieldModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalFieldImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalField"),
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

	private static final String _SQL_SELECT_LEGALFIELD =
		"SELECT legalField FROM LegalField legalField";

	private static final String _SQL_SELECT_LEGALFIELD_WHERE =
		"SELECT legalField FROM LegalField legalField WHERE ";

	private static final String _SQL_COUNT_LEGALFIELD =
		"SELECT COUNT(legalField) FROM LegalField legalField";

	private static final String _SQL_COUNT_LEGALFIELD_WHERE =
		"SELECT COUNT(legalField) FROM LegalField legalField WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalField.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalField exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalField exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalFieldPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}