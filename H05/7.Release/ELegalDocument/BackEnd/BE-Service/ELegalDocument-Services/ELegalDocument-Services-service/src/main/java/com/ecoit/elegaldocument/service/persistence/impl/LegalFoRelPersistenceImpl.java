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

import com.ecoit.elegaldocument.exception.NoSuchLegalFoRelException;
import com.ecoit.elegaldocument.model.LegalFoRel;
import com.ecoit.elegaldocument.model.impl.LegalFoRelImpl;
import com.ecoit.elegaldocument.model.impl.LegalFoRelModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalFoRelPK;
import com.ecoit.elegaldocument.service.persistence.LegalFoRelPersistence;
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
 * The persistence implementation for the legal fo rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalFoRelPersistence.class)
public class LegalFoRelPersistenceImpl
	extends BasePersistenceImpl<LegalFoRel> implements LegalFoRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalFoRelUtil</code> to access the legal fo rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalFoRelImpl.class.getName();

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
	 * Returns all the legal fo rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal fo rels
	 */
	@Override
	public List<LegalFoRel> findByField(long fieldId) {
		return findByField(fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fo rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @return the range of matching legal fo rels
	 */
	@Override
	public List<LegalFoRel> findByField(long fieldId, int start, int end) {
		return findByField(fieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fo rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fo rels
	 */
	@Override
	public List<LegalFoRel> findByField(
		long fieldId, int start, int end,
		OrderByComparator<LegalFoRel> orderByComparator) {

		return findByField(fieldId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fo rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fo rels
	 */
	@Override
	public List<LegalFoRel> findByField(
		long fieldId, int start, int end,
		OrderByComparator<LegalFoRel> orderByComparator,
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

		List<LegalFoRel> list = null;

		if (useFinderCache) {
			list = (List<LegalFoRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalFoRel legalFoRel : list) {
					if (fieldId != legalFoRel.getFieldId()) {
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

			query.append(_SQL_SELECT_LEGALFOREL_WHERE);

			query.append(_FINDER_COLUMN_FIELD_FIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFoRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				list = (List<LegalFoRel>)QueryUtil.list(
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
	 * Returns the first legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	@Override
	public LegalFoRel findByField_First(
			long fieldId, OrderByComparator<LegalFoRel> orderByComparator)
		throws NoSuchLegalFoRelException {

		LegalFoRel legalFoRel = fetchByField_First(fieldId, orderByComparator);

		if (legalFoRel != null) {
			return legalFoRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalFoRelException(msg.toString());
	}

	/**
	 * Returns the first legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	@Override
	public LegalFoRel fetchByField_First(
		long fieldId, OrderByComparator<LegalFoRel> orderByComparator) {

		List<LegalFoRel> list = findByField(fieldId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	@Override
	public LegalFoRel findByField_Last(
			long fieldId, OrderByComparator<LegalFoRel> orderByComparator)
		throws NoSuchLegalFoRelException {

		LegalFoRel legalFoRel = fetchByField_Last(fieldId, orderByComparator);

		if (legalFoRel != null) {
			return legalFoRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalFoRelException(msg.toString());
	}

	/**
	 * Returns the last legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	@Override
	public LegalFoRel fetchByField_Last(
		long fieldId, OrderByComparator<LegalFoRel> orderByComparator) {

		int count = countByField(fieldId);

		if (count == 0) {
			return null;
		}

		List<LegalFoRel> list = findByField(
			fieldId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fo rels before and after the current legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param legalFoRelPK the primary key of the current legal fo rel
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal fo rel
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	@Override
	public LegalFoRel[] findByField_PrevAndNext(
			LegalFoRelPK legalFoRelPK, long fieldId,
			OrderByComparator<LegalFoRel> orderByComparator)
		throws NoSuchLegalFoRelException {

		LegalFoRel legalFoRel = findByPrimaryKey(legalFoRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalFoRel[] array = new LegalFoRelImpl[3];

			array[0] = getByField_PrevAndNext(
				session, legalFoRel, fieldId, orderByComparator, true);

			array[1] = legalFoRel;

			array[2] = getByField_PrevAndNext(
				session, legalFoRel, fieldId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalFoRel getByField_PrevAndNext(
		Session session, LegalFoRel legalFoRel, long fieldId,
		OrderByComparator<LegalFoRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFOREL_WHERE);

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
			query.append(LegalFoRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fieldId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalFoRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalFoRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fo rels where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	@Override
	public void removeByField(long fieldId) {
		for (LegalFoRel legalFoRel :
				findByField(
					fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalFoRel);
		}
	}

	/**
	 * Returns the number of legal fo rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal fo rels
	 */
	@Override
	public int countByField(long fieldId) {
		FinderPath finderPath = _finderPathCountByField;

		Object[] finderArgs = new Object[] {fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFOREL_WHERE);

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
		"legalFoRel.id.fieldId = ?";

	private FinderPath _finderPathWithPaginationFindByOrg;
	private FinderPath _finderPathWithoutPaginationFindByOrg;
	private FinderPath _finderPathCountByOrg;

	/**
	 * Returns all the legal fo rels where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal fo rels
	 */
	@Override
	public List<LegalFoRel> findByOrg(long organizationId) {
		return findByOrg(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fo rels where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @return the range of matching legal fo rels
	 */
	@Override
	public List<LegalFoRel> findByOrg(long organizationId, int start, int end) {
		return findByOrg(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fo rels where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fo rels
	 */
	@Override
	public List<LegalFoRel> findByOrg(
		long organizationId, int start, int end,
		OrderByComparator<LegalFoRel> orderByComparator) {

		return findByOrg(organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fo rels where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fo rels
	 */
	@Override
	public List<LegalFoRel> findByOrg(
		long organizationId, int start, int end,
		OrderByComparator<LegalFoRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrg;
				finderArgs = new Object[] {organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrg;
			finderArgs = new Object[] {
				organizationId, start, end, orderByComparator
			};
		}

		List<LegalFoRel> list = null;

		if (useFinderCache) {
			list = (List<LegalFoRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalFoRel legalFoRel : list) {
					if (organizationId != legalFoRel.getOrganizationId()) {
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

			query.append(_SQL_SELECT_LEGALFOREL_WHERE);

			query.append(_FINDER_COLUMN_ORG_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalFoRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				list = (List<LegalFoRel>)QueryUtil.list(
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
	 * Returns the first legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	@Override
	public LegalFoRel findByOrg_First(
			long organizationId,
			OrderByComparator<LegalFoRel> orderByComparator)
		throws NoSuchLegalFoRelException {

		LegalFoRel legalFoRel = fetchByOrg_First(
			organizationId, orderByComparator);

		if (legalFoRel != null) {
			return legalFoRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchLegalFoRelException(msg.toString());
	}

	/**
	 * Returns the first legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	@Override
	public LegalFoRel fetchByOrg_First(
		long organizationId, OrderByComparator<LegalFoRel> orderByComparator) {

		List<LegalFoRel> list = findByOrg(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	@Override
	public LegalFoRel findByOrg_Last(
			long organizationId,
			OrderByComparator<LegalFoRel> orderByComparator)
		throws NoSuchLegalFoRelException {

		LegalFoRel legalFoRel = fetchByOrg_Last(
			organizationId, orderByComparator);

		if (legalFoRel != null) {
			return legalFoRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchLegalFoRelException(msg.toString());
	}

	/**
	 * Returns the last legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	@Override
	public LegalFoRel fetchByOrg_Last(
		long organizationId, OrderByComparator<LegalFoRel> orderByComparator) {

		int count = countByOrg(organizationId);

		if (count == 0) {
			return null;
		}

		List<LegalFoRel> list = findByOrg(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal fo rels before and after the current legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param legalFoRelPK the primary key of the current legal fo rel
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal fo rel
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	@Override
	public LegalFoRel[] findByOrg_PrevAndNext(
			LegalFoRelPK legalFoRelPK, long organizationId,
			OrderByComparator<LegalFoRel> orderByComparator)
		throws NoSuchLegalFoRelException {

		LegalFoRel legalFoRel = findByPrimaryKey(legalFoRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalFoRel[] array = new LegalFoRelImpl[3];

			array[0] = getByOrg_PrevAndNext(
				session, legalFoRel, organizationId, orderByComparator, true);

			array[1] = legalFoRel;

			array[2] = getByOrg_PrevAndNext(
				session, legalFoRel, organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalFoRel getByOrg_PrevAndNext(
		Session session, LegalFoRel legalFoRel, long organizationId,
		OrderByComparator<LegalFoRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFOREL_WHERE);

		query.append(_FINDER_COLUMN_ORG_ORGANIZATIONID_2);

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
			query.append(LegalFoRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalFoRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalFoRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal fo rels where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrg(long organizationId) {
		for (LegalFoRel legalFoRel :
				findByOrg(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalFoRel);
		}
	}

	/**
	 * Returns the number of legal fo rels where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching legal fo rels
	 */
	@Override
	public int countByOrg(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrg;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFOREL_WHERE);

			query.append(_FINDER_COLUMN_ORG_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORG_ORGANIZATIONID_2 =
		"legalFoRel.id.organizationId = ?";

	public LegalFoRelPersistenceImpl() {
		setModelClass(LegalFoRel.class);

		setModelImplClass(LegalFoRelImpl.class);
		setModelPKClass(LegalFoRelPK.class);
	}

	/**
	 * Caches the legal fo rel in the entity cache if it is enabled.
	 *
	 * @param legalFoRel the legal fo rel
	 */
	@Override
	public void cacheResult(LegalFoRel legalFoRel) {
		entityCache.putResult(
			entityCacheEnabled, LegalFoRelImpl.class,
			legalFoRel.getPrimaryKey(), legalFoRel);

		legalFoRel.resetOriginalValues();
	}

	/**
	 * Caches the legal fo rels in the entity cache if it is enabled.
	 *
	 * @param legalFoRels the legal fo rels
	 */
	@Override
	public void cacheResult(List<LegalFoRel> legalFoRels) {
		for (LegalFoRel legalFoRel : legalFoRels) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalFoRelImpl.class,
					legalFoRel.getPrimaryKey()) == null) {

				cacheResult(legalFoRel);
			}
			else {
				legalFoRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal fo rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalFoRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal fo rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalFoRel legalFoRel) {
		entityCache.removeResult(
			entityCacheEnabled, LegalFoRelImpl.class,
			legalFoRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalFoRel> legalFoRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalFoRel legalFoRel : legalFoRels) {
			entityCache.removeResult(
				entityCacheEnabled, LegalFoRelImpl.class,
				legalFoRel.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalFoRelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new legal fo rel with the primary key. Does not add the legal fo rel to the database.
	 *
	 * @param legalFoRelPK the primary key for the new legal fo rel
	 * @return the new legal fo rel
	 */
	@Override
	public LegalFoRel create(LegalFoRelPK legalFoRelPK) {
		LegalFoRel legalFoRel = new LegalFoRelImpl();

		legalFoRel.setNew(true);
		legalFoRel.setPrimaryKey(legalFoRelPK);

		return legalFoRel;
	}

	/**
	 * Removes the legal fo rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel that was removed
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	@Override
	public LegalFoRel remove(LegalFoRelPK legalFoRelPK)
		throws NoSuchLegalFoRelException {

		return remove((Serializable)legalFoRelPK);
	}

	/**
	 * Removes the legal fo rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal fo rel
	 * @return the legal fo rel that was removed
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	@Override
	public LegalFoRel remove(Serializable primaryKey)
		throws NoSuchLegalFoRelException {

		Session session = null;

		try {
			session = openSession();

			LegalFoRel legalFoRel = (LegalFoRel)session.get(
				LegalFoRelImpl.class, primaryKey);

			if (legalFoRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalFoRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalFoRel);
		}
		catch (NoSuchLegalFoRelException noSuchEntityException) {
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
	protected LegalFoRel removeImpl(LegalFoRel legalFoRel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalFoRel)) {
				legalFoRel = (LegalFoRel)session.get(
					LegalFoRelImpl.class, legalFoRel.getPrimaryKeyObj());
			}

			if (legalFoRel != null) {
				session.delete(legalFoRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalFoRel != null) {
			clearCache(legalFoRel);
		}

		return legalFoRel;
	}

	@Override
	public LegalFoRel updateImpl(LegalFoRel legalFoRel) {
		boolean isNew = legalFoRel.isNew();

		if (!(legalFoRel instanceof LegalFoRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalFoRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalFoRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalFoRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalFoRel implementation " +
					legalFoRel.getClass());
		}

		LegalFoRelModelImpl legalFoRelModelImpl =
			(LegalFoRelModelImpl)legalFoRel;

		Session session = null;

		try {
			session = openSession();

			if (legalFoRel.isNew()) {
				session.save(legalFoRel);

				legalFoRel.setNew(false);
			}
			else {
				legalFoRel = (LegalFoRel)session.merge(legalFoRel);
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
			Object[] args = new Object[] {legalFoRelModelImpl.getFieldId()};

			finderCache.removeResult(_finderPathCountByField, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByField, args);

			args = new Object[] {legalFoRelModelImpl.getOrganizationId()};

			finderCache.removeResult(_finderPathCountByOrg, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOrg, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalFoRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByField.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalFoRelModelImpl.getOriginalFieldId()
				};

				finderCache.removeResult(_finderPathCountByField, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField, args);

				args = new Object[] {legalFoRelModelImpl.getFieldId()};

				finderCache.removeResult(_finderPathCountByField, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField, args);
			}

			if ((legalFoRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOrg.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalFoRelModelImpl.getOriginalOrganizationId()
				};

				finderCache.removeResult(_finderPathCountByOrg, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOrg, args);

				args = new Object[] {legalFoRelModelImpl.getOrganizationId()};

				finderCache.removeResult(_finderPathCountByOrg, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOrg, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalFoRelImpl.class,
			legalFoRel.getPrimaryKey(), legalFoRel, false);

		legalFoRel.resetOriginalValues();

		return legalFoRel;
	}

	/**
	 * Returns the legal fo rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal fo rel
	 * @return the legal fo rel
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	@Override
	public LegalFoRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalFoRelException {

		LegalFoRel legalFoRel = fetchByPrimaryKey(primaryKey);

		if (legalFoRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalFoRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalFoRel;
	}

	/**
	 * Returns the legal fo rel with the primary key or throws a <code>NoSuchLegalFoRelException</code> if it could not be found.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	@Override
	public LegalFoRel findByPrimaryKey(LegalFoRelPK legalFoRelPK)
		throws NoSuchLegalFoRelException {

		return findByPrimaryKey((Serializable)legalFoRelPK);
	}

	/**
	 * Returns the legal fo rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel, or <code>null</code> if a legal fo rel with the primary key could not be found
	 */
	@Override
	public LegalFoRel fetchByPrimaryKey(LegalFoRelPK legalFoRelPK) {
		return fetchByPrimaryKey((Serializable)legalFoRelPK);
	}

	/**
	 * Returns all the legal fo rels.
	 *
	 * @return the legal fo rels
	 */
	@Override
	public List<LegalFoRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal fo rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @return the range of legal fo rels
	 */
	@Override
	public List<LegalFoRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal fo rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal fo rels
	 */
	@Override
	public List<LegalFoRel> findAll(
		int start, int end, OrderByComparator<LegalFoRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal fo rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal fo rels
	 */
	@Override
	public List<LegalFoRel> findAll(
		int start, int end, OrderByComparator<LegalFoRel> orderByComparator,
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

		List<LegalFoRel> list = null;

		if (useFinderCache) {
			list = (List<LegalFoRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALFOREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALFOREL;

				sql = sql.concat(LegalFoRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalFoRel>)QueryUtil.list(
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
	 * Removes all the legal fo rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalFoRel legalFoRel : findAll()) {
			remove(legalFoRel);
		}
	}

	/**
	 * Returns the number of legal fo rels.
	 *
	 * @return the number of legal fo rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALFOREL);

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
		return "legalFoRelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALFOREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalFoRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal fo rel persistence.
	 */
	@Activate
	public void activate() {
		LegalFoRelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalFoRelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFoRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFoRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFoRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFoRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField",
			new String[] {Long.class.getName()},
			LegalFoRelModelImpl.FIELDID_COLUMN_BITMASK);

		_finderPathCountByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByOrg = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFoRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrg",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByOrg = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalFoRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrg",
			new String[] {Long.class.getName()},
			LegalFoRelModelImpl.ORGANIZATIONID_COLUMN_BITMASK);

		_finderPathCountByOrg = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrg",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalFoRelImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalFoRel"),
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

	private static final String _SQL_SELECT_LEGALFOREL =
		"SELECT legalFoRel FROM LegalFoRel legalFoRel";

	private static final String _SQL_SELECT_LEGALFOREL_WHERE =
		"SELECT legalFoRel FROM LegalFoRel legalFoRel WHERE ";

	private static final String _SQL_COUNT_LEGALFOREL =
		"SELECT COUNT(legalFoRel) FROM LegalFoRel legalFoRel";

	private static final String _SQL_COUNT_LEGALFOREL_WHERE =
		"SELECT COUNT(legalFoRel) FROM LegalFoRel legalFoRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalFoRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalFoRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalFoRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalFoRelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"fieldId", "organizationId"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}