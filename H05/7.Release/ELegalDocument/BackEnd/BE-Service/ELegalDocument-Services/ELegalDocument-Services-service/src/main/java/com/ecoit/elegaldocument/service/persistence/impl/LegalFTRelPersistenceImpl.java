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

import com.ecoit.elegaldocument.exception.NoSuchLegalFTRelException;
import com.ecoit.elegaldocument.model.LegalFTRel;
import com.ecoit.elegaldocument.model.impl.LegalFTRelImpl;
import com.ecoit.elegaldocument.model.impl.LegalFTRelModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalFTRelPK;
import com.ecoit.elegaldocument.service.persistence.LegalFTRelPersistence;
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
 * The persistence implementation for the legal ft rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalFTRelPersistence.class)
public class LegalFTRelPersistenceImpl
	extends BasePersistenceImpl<LegalFTRel> implements LegalFTRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalFTRelUtil</code> to access the legal ft rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalFTRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByField;
	private FinderPath _finderPathWithoutPaginationFindByField;
	private FinderPath _finderPathCountByField;

	/**
	 * Returns all the legal ft rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal ft rels
	 */
	@Override
	public List<LegalFTRel> findByField(long fieldId) {
		return findByField(fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal ft rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @return the range of matching legal ft rels
	 */
	@Override
	public List<LegalFTRel> findByField(long fieldId, int start, int end) {
		return findByField(fieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal ft rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ft rels
	 */
	@Override
	public List<LegalFTRel> findByField(
		long fieldId, int start, int end,
		OrderByComparator<LegalFTRel> orderByComparator) {

		return findByField(fieldId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal ft rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ft rels
	 */
	@Override
	public List<LegalFTRel> findByField(
		long fieldId, int start, int end,
		OrderByComparator<LegalFTRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByField;
				finderArgs = new Object[] {fieldId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByField;
			finderArgs = new Object[] {fieldId, start, end, orderByComparator};
		}

		List<LegalFTRel> list = null;

		if (useFinderCache) {
			list = (List<LegalFTRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalFTRel legalFTRel : list) {
					if (fieldId != legalFTRel.getFieldId()) {
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

			query.append(_SQL_SELECT_LEGALFTREL_WHERE);

			query.append(_FINDER_COLUMN_FIELD_FIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFTRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				list = (List<LegalFTRel>)QueryUtil.list(
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
	 * Returns the first legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	@Override
	public LegalFTRel findByField_First(
			long fieldId, OrderByComparator<LegalFTRel> orderByComparator)
		throws NoSuchLegalFTRelException {

		LegalFTRel legalFTRel = fetchByField_First(fieldId, orderByComparator);

		if (legalFTRel != null) {
			return legalFTRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalFTRelException(msg.toString());
	}

	/**
	 * Returns the first legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	@Override
	public LegalFTRel fetchByField_First(
		long fieldId, OrderByComparator<LegalFTRel> orderByComparator) {

		List<LegalFTRel> list = findByField(fieldId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	@Override
	public LegalFTRel findByField_Last(
			long fieldId, OrderByComparator<LegalFTRel> orderByComparator)
		throws NoSuchLegalFTRelException {

		LegalFTRel legalFTRel = fetchByField_Last(fieldId, orderByComparator);

		if (legalFTRel != null) {
			return legalFTRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalFTRelException(msg.toString());
	}

	/**
	 * Returns the last legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	@Override
	public LegalFTRel fetchByField_Last(
		long fieldId, OrderByComparator<LegalFTRel> orderByComparator) {

		int count = countByField(fieldId);

		if (count == 0) {
			return null;
		}

		List<LegalFTRel> list = findByField(
			fieldId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal ft rels before and after the current legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param legalFTRelPK the primary key of the current legal ft rel
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ft rel
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	@Override
	public LegalFTRel[] findByField_PrevAndNext(
			LegalFTRelPK legalFTRelPK, long fieldId,
			OrderByComparator<LegalFTRel> orderByComparator)
		throws NoSuchLegalFTRelException {

		LegalFTRel legalFTRel = findByPrimaryKey(legalFTRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalFTRel[] array = new LegalFTRelImpl[3];

			array[0] = getByField_PrevAndNext(
				session, legalFTRel, fieldId, orderByComparator, true);

			array[1] = legalFTRel;

			array[2] = getByField_PrevAndNext(
				session, legalFTRel, fieldId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalFTRel getByField_PrevAndNext(
		Session session, LegalFTRel legalFTRel, long fieldId,
		OrderByComparator<LegalFTRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFTREL_WHERE);

		query.append(_FINDER_COLUMN_FIELD_FIELDID_2);

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
			query.append(LegalFTRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fieldId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalFTRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalFTRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal ft rels where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	@Override
	public void removeByField(long fieldId) {
		for (LegalFTRel legalFTRel :
				findByField(
					fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalFTRel);
		}
	}

	/**
	 * Returns the number of legal ft rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal ft rels
	 */
	@Override
	public int countByField(long fieldId) {
		FinderPath finderPath = _finderPathCountByField;

		Object[] finderArgs = new Object[] {fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFTREL_WHERE);

			query.append(_FINDER_COLUMN_FIELD_FIELDID_2);

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

	private static final String _FINDER_COLUMN_FIELD_FIELDID_2 =
		"legalFTRel.id.fieldId = ?";

	private FinderPath _finderPathWithPaginationFindByType;
	private FinderPath _finderPathWithoutPaginationFindByType;
	private FinderPath _finderPathCountByType;

	/**
	 * Returns all the legal ft rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching legal ft rels
	 */
	@Override
	public List<LegalFTRel> findByType(long typeId) {
		return findByType(typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal ft rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @return the range of matching legal ft rels
	 */
	@Override
	public List<LegalFTRel> findByType(long typeId, int start, int end) {
		return findByType(typeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal ft rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ft rels
	 */
	@Override
	public List<LegalFTRel> findByType(
		long typeId, int start, int end,
		OrderByComparator<LegalFTRel> orderByComparator) {

		return findByType(typeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal ft rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ft rels
	 */
	@Override
	public List<LegalFTRel> findByType(
		long typeId, int start, int end,
		OrderByComparator<LegalFTRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType;
				finderArgs = new Object[] {typeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType;
			finderArgs = new Object[] {typeId, start, end, orderByComparator};
		}

		List<LegalFTRel> list = null;

		if (useFinderCache) {
			list = (List<LegalFTRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalFTRel legalFTRel : list) {
					if (typeId != legalFTRel.getTypeId()) {
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

			query.append(_SQL_SELECT_LEGALFTREL_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFTRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				list = (List<LegalFTRel>)QueryUtil.list(
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
	 * Returns the first legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	@Override
	public LegalFTRel findByType_First(
			long typeId, OrderByComparator<LegalFTRel> orderByComparator)
		throws NoSuchLegalFTRelException {

		LegalFTRel legalFTRel = fetchByType_First(typeId, orderByComparator);

		if (legalFTRel != null) {
			return legalFTRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalFTRelException(msg.toString());
	}

	/**
	 * Returns the first legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	@Override
	public LegalFTRel fetchByType_First(
		long typeId, OrderByComparator<LegalFTRel> orderByComparator) {

		List<LegalFTRel> list = findByType(typeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	@Override
	public LegalFTRel findByType_Last(
			long typeId, OrderByComparator<LegalFTRel> orderByComparator)
		throws NoSuchLegalFTRelException {

		LegalFTRel legalFTRel = fetchByType_Last(typeId, orderByComparator);

		if (legalFTRel != null) {
			return legalFTRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalFTRelException(msg.toString());
	}

	/**
	 * Returns the last legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	@Override
	public LegalFTRel fetchByType_Last(
		long typeId, OrderByComparator<LegalFTRel> orderByComparator) {

		int count = countByType(typeId);

		if (count == 0) {
			return null;
		}

		List<LegalFTRel> list = findByType(
			typeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal ft rels before and after the current legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param legalFTRelPK the primary key of the current legal ft rel
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ft rel
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	@Override
	public LegalFTRel[] findByType_PrevAndNext(
			LegalFTRelPK legalFTRelPK, long typeId,
			OrderByComparator<LegalFTRel> orderByComparator)
		throws NoSuchLegalFTRelException {

		LegalFTRel legalFTRel = findByPrimaryKey(legalFTRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalFTRel[] array = new LegalFTRelImpl[3];

			array[0] = getByType_PrevAndNext(
				session, legalFTRel, typeId, orderByComparator, true);

			array[1] = legalFTRel;

			array[2] = getByType_PrevAndNext(
				session, legalFTRel, typeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalFTRel getByType_PrevAndNext(
		Session session, LegalFTRel legalFTRel, long typeId,
		OrderByComparator<LegalFTRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFTREL_WHERE);

		query.append(_FINDER_COLUMN_TYPE_TYPEID_2);

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
			query.append(LegalFTRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalFTRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalFTRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal ft rels where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	@Override
	public void removeByType(long typeId) {
		for (LegalFTRel legalFTRel :
				findByType(
					typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalFTRel);
		}
	}

	/**
	 * Returns the number of legal ft rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal ft rels
	 */
	@Override
	public int countByType(long typeId) {
		FinderPath finderPath = _finderPathCountByType;

		Object[] finderArgs = new Object[] {typeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFTREL_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

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

	private static final String _FINDER_COLUMN_TYPE_TYPEID_2 =
		"legalFTRel.id.typeId = ?";

	public LegalFTRelPersistenceImpl() {
		setModelClass(LegalFTRel.class);

		setModelImplClass(LegalFTRelImpl.class);
		setModelPKClass(LegalFTRelPK.class);
	}

	/**
	 * Caches the legal ft rel in the entity cache if it is enabled.
	 *
	 * @param legalFTRel the legal ft rel
	 */
	@Override
	public void cacheResult(LegalFTRel legalFTRel) {
		entityCache.putResult(
			entityCacheEnabled, LegalFTRelImpl.class,
			legalFTRel.getPrimaryKey(), legalFTRel);

		legalFTRel.resetOriginalValues();
	}

	/**
	 * Caches the legal ft rels in the entity cache if it is enabled.
	 *
	 * @param legalFTRels the legal ft rels
	 */
	@Override
	public void cacheResult(List<LegalFTRel> legalFTRels) {
		for (LegalFTRel legalFTRel : legalFTRels) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalFTRelImpl.class,
					legalFTRel.getPrimaryKey()) == null) {

				cacheResult(legalFTRel);
			}
			else {
				legalFTRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal ft rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalFTRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal ft rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalFTRel legalFTRel) {
		entityCache.removeResult(
			entityCacheEnabled, LegalFTRelImpl.class,
			legalFTRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalFTRel> legalFTRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalFTRel legalFTRel : legalFTRels) {
			entityCache.removeResult(
				entityCacheEnabled, LegalFTRelImpl.class,
				legalFTRel.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalFTRelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new legal ft rel with the primary key. Does not add the legal ft rel to the database.
	 *
	 * @param legalFTRelPK the primary key for the new legal ft rel
	 * @return the new legal ft rel
	 */
	@Override
	public LegalFTRel create(LegalFTRelPK legalFTRelPK) {
		LegalFTRel legalFTRel = new LegalFTRelImpl();

		legalFTRel.setNew(true);
		legalFTRel.setPrimaryKey(legalFTRelPK);

		return legalFTRel;
	}

	/**
	 * Removes the legal ft rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel that was removed
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	@Override
	public LegalFTRel remove(LegalFTRelPK legalFTRelPK)
		throws NoSuchLegalFTRelException {

		return remove((Serializable)legalFTRelPK);
	}

	/**
	 * Removes the legal ft rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal ft rel
	 * @return the legal ft rel that was removed
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	@Override
	public LegalFTRel remove(Serializable primaryKey)
		throws NoSuchLegalFTRelException {

		Session session = null;

		try {
			session = openSession();

			LegalFTRel legalFTRel = (LegalFTRel)session.get(
				LegalFTRelImpl.class, primaryKey);

			if (legalFTRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalFTRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalFTRel);
		}
		catch (NoSuchLegalFTRelException noSuchEntityException) {
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
	protected LegalFTRel removeImpl(LegalFTRel legalFTRel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalFTRel)) {
				legalFTRel = (LegalFTRel)session.get(
					LegalFTRelImpl.class, legalFTRel.getPrimaryKeyObj());
			}

			if (legalFTRel != null) {
				session.delete(legalFTRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalFTRel != null) {
			clearCache(legalFTRel);
		}

		return legalFTRel;
	}

	@Override
	public LegalFTRel updateImpl(LegalFTRel legalFTRel) {
		boolean isNew = legalFTRel.isNew();

		if (!(legalFTRel instanceof LegalFTRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalFTRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalFTRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalFTRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalFTRel implementation " +
					legalFTRel.getClass());
		}

		LegalFTRelModelImpl legalFTRelModelImpl =
			(LegalFTRelModelImpl)legalFTRel;

		Session session = null;

		try {
			session = openSession();

			if (legalFTRel.isNew()) {
				session.save(legalFTRel);

				legalFTRel.setNew(false);
			}
			else {
				legalFTRel = (LegalFTRel)session.merge(legalFTRel);
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
			Object[] args = new Object[] {legalFTRelModelImpl.getFieldId()};

			finderCache.removeResult(_finderPathCountByField, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByField, args);

			args = new Object[] {legalFTRelModelImpl.getTypeId()};

			finderCache.removeResult(_finderPathCountByType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByType, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalFTRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByField.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalFTRelModelImpl.getOriginalFieldId()
				};

				finderCache.removeResult(_finderPathCountByField, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField, args);

				args = new Object[] {legalFTRelModelImpl.getFieldId()};

				finderCache.removeResult(_finderPathCountByField, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField, args);
			}

			if ((legalFTRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByType.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalFTRelModelImpl.getOriginalTypeId()
				};

				finderCache.removeResult(_finderPathCountByType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType, args);

				args = new Object[] {legalFTRelModelImpl.getTypeId()};

				finderCache.removeResult(_finderPathCountByType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalFTRelImpl.class,
			legalFTRel.getPrimaryKey(), legalFTRel, false);

		legalFTRel.resetOriginalValues();

		return legalFTRel;
	}

	/**
	 * Returns the legal ft rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal ft rel
	 * @return the legal ft rel
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	@Override
	public LegalFTRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalFTRelException {

		LegalFTRel legalFTRel = fetchByPrimaryKey(primaryKey);

		if (legalFTRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalFTRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalFTRel;
	}

	/**
	 * Returns the legal ft rel with the primary key or throws a <code>NoSuchLegalFTRelException</code> if it could not be found.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	@Override
	public LegalFTRel findByPrimaryKey(LegalFTRelPK legalFTRelPK)
		throws NoSuchLegalFTRelException {

		return findByPrimaryKey((Serializable)legalFTRelPK);
	}

	/**
	 * Returns the legal ft rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel, or <code>null</code> if a legal ft rel with the primary key could not be found
	 */
	@Override
	public LegalFTRel fetchByPrimaryKey(LegalFTRelPK legalFTRelPK) {
		return fetchByPrimaryKey((Serializable)legalFTRelPK);
	}

	/**
	 * Returns all the legal ft rels.
	 *
	 * @return the legal ft rels
	 */
	@Override
	public List<LegalFTRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal ft rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @return the range of legal ft rels
	 */
	@Override
	public List<LegalFTRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal ft rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal ft rels
	 */
	@Override
	public List<LegalFTRel> findAll(
		int start, int end, OrderByComparator<LegalFTRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal ft rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal ft rels
	 */
	@Override
	public List<LegalFTRel> findAll(
		int start, int end, OrderByComparator<LegalFTRel> orderByComparator,
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

		List<LegalFTRel> list = null;

		if (useFinderCache) {
			list = (List<LegalFTRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALFTREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALFTREL;

				sql = sql.concat(LegalFTRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalFTRel>)QueryUtil.list(
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
	 * Removes all the legal ft rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalFTRel legalFTRel : findAll()) {
			remove(legalFTRel);
		}
	}

	/**
	 * Returns the number of legal ft rels.
	 *
	 * @return the number of legal ft rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALFTREL);

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
		return "legalFTRelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALFTREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalFTRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal ft rel persistence.
	 */
	@Activate
	public void activate() {
		LegalFTRelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalFTRelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFTRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFTRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFTRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFTRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField",
			new String[] {Long.class.getName()},
			LegalFTRelModelImpl.FIELDID_COLUMN_BITMASK);

		_finderPathCountByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFTRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFTRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] {Long.class.getName()},
			LegalFTRelModelImpl.TYPEID_COLUMN_BITMASK);

		_finderPathCountByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalFTRelImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalFTRel"),
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

	private static final String _SQL_SELECT_LEGALFTREL =
		"SELECT legalFTRel FROM LegalFTRel legalFTRel";

	private static final String _SQL_SELECT_LEGALFTREL_WHERE =
		"SELECT legalFTRel FROM LegalFTRel legalFTRel WHERE ";

	private static final String _SQL_COUNT_LEGALFTREL =
		"SELECT COUNT(legalFTRel) FROM LegalFTRel legalFTRel";

	private static final String _SQL_COUNT_LEGALFTREL_WHERE =
		"SELECT COUNT(legalFTRel) FROM LegalFTRel legalFTRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalFTRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalFTRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalFTRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalFTRelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"fieldId", "typeId"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}