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

import com.ecoit.qa.service.exception.NoSuchAnswerException;
import com.ecoit.qa.service.model.Answer;
import com.ecoit.qa.service.model.impl.AnswerImpl;
import com.ecoit.qa.service.model.impl.AnswerModelImpl;
import com.ecoit.qa.service.service.persistence.AnswerPersistence;
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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AnswerPersistence.class)
public class AnswerPersistenceImpl
	extends BasePersistenceImpl<Answer> implements AnswerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnswerUtil</code> to access the answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnswerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByQuestion;
	private FinderPath _finderPathCountByQuestion;

	/**
	 * Returns the answer where questionId = &#63; or throws a <code>NoSuchAnswerException</code> if it could not be found.
	 *
	 * @param questionId the question ID
	 * @return the matching answer
	 * @throws NoSuchAnswerException if a matching answer could not be found
	 */
	@Override
	public Answer findByQuestion(long questionId) throws NoSuchAnswerException {
		Answer answer = fetchByQuestion(questionId);

		if (answer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAnswerException(msg.toString());
		}

		return answer;
	}

	/**
	 * Returns the answer where questionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param questionId the question ID
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 */
	@Override
	public Answer fetchByQuestion(long questionId) {
		return fetchByQuestion(questionId, true);
	}

	/**
	 * Returns the answer where questionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param questionId the question ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 */
	@Override
	public Answer fetchByQuestion(long questionId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {questionId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByQuestion, finderArgs, this);
		}

		if (result instanceof Answer) {
			Answer answer = (Answer)result;

			if (questionId != answer.getQuestionId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ANSWER_WHERE);

			query.append(_FINDER_COLUMN_QUESTION_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				List<Answer> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByQuestion, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {questionId};
							}

							_log.warn(
								"AnswerPersistenceImpl.fetchByQuestion(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Answer answer = list.get(0);

					result = answer;

					cacheResult(answer);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByQuestion, finderArgs);
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
			return (Answer)result;
		}
	}

	/**
	 * Removes the answer where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @return the answer that was removed
	 */
	@Override
	public Answer removeByQuestion(long questionId)
		throws NoSuchAnswerException {

		Answer answer = findByQuestion(questionId);

		return remove(answer);
	}

	/**
	 * Returns the number of answers where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching answers
	 */
	@Override
	public int countByQuestion(long questionId) {
		FinderPath finderPath = _finderPathCountByQuestion;

		Object[] finderArgs = new Object[] {questionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANSWER_WHERE);

			query.append(_FINDER_COLUMN_QUESTION_QUESTIONID_2);

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

	private static final String _FINDER_COLUMN_QUESTION_QUESTIONID_2 =
		"answer.questionId = ?";

	public AnswerPersistenceImpl() {
		setModelClass(Answer.class);

		setModelImplClass(AnswerImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the answer in the entity cache if it is enabled.
	 *
	 * @param answer the answer
	 */
	@Override
	public void cacheResult(Answer answer) {
		entityCache.putResult(
			entityCacheEnabled, AnswerImpl.class, answer.getPrimaryKey(),
			answer);

		finderCache.putResult(
			_finderPathFetchByQuestion, new Object[] {answer.getQuestionId()},
			answer);

		answer.resetOriginalValues();
	}

	/**
	 * Caches the answers in the entity cache if it is enabled.
	 *
	 * @param answers the answers
	 */
	@Override
	public void cacheResult(List<Answer> answers) {
		for (Answer answer : answers) {
			if (entityCache.getResult(
					entityCacheEnabled, AnswerImpl.class,
					answer.getPrimaryKey()) == null) {

				cacheResult(answer);
			}
			else {
				answer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all answers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnswerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the answer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Answer answer) {
		entityCache.removeResult(
			entityCacheEnabled, AnswerImpl.class, answer.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AnswerModelImpl)answer, true);
	}

	@Override
	public void clearCache(List<Answer> answers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Answer answer : answers) {
			entityCache.removeResult(
				entityCacheEnabled, AnswerImpl.class, answer.getPrimaryKey());

			clearUniqueFindersCache((AnswerModelImpl)answer, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, AnswerImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(AnswerModelImpl answerModelImpl) {
		Object[] args = new Object[] {answerModelImpl.getQuestionId()};

		finderCache.putResult(
			_finderPathCountByQuestion, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByQuestion, args, answerModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AnswerModelImpl answerModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {answerModelImpl.getQuestionId()};

			finderCache.removeResult(_finderPathCountByQuestion, args);
			finderCache.removeResult(_finderPathFetchByQuestion, args);
		}

		if ((answerModelImpl.getColumnBitmask() &
			 _finderPathFetchByQuestion.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				answerModelImpl.getOriginalQuestionId()
			};

			finderCache.removeResult(_finderPathCountByQuestion, args);
			finderCache.removeResult(_finderPathFetchByQuestion, args);
		}
	}

	/**
	 * Creates a new answer with the primary key. Does not add the answer to the database.
	 *
	 * @param answerId the primary key for the new answer
	 * @return the new answer
	 */
	@Override
	public Answer create(long answerId) {
		Answer answer = new AnswerImpl();

		answer.setNew(true);
		answer.setPrimaryKey(answerId);

		answer.setCompanyId(CompanyThreadLocal.getCompanyId());

		return answer;
	}

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answerId the primary key of the answer
	 * @return the answer that was removed
	 * @throws NoSuchAnswerException if a answer with the primary key could not be found
	 */
	@Override
	public Answer remove(long answerId) throws NoSuchAnswerException {
		return remove((Serializable)answerId);
	}

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the answer
	 * @return the answer that was removed
	 * @throws NoSuchAnswerException if a answer with the primary key could not be found
	 */
	@Override
	public Answer remove(Serializable primaryKey) throws NoSuchAnswerException {
		Session session = null;

		try {
			session = openSession();

			Answer answer = (Answer)session.get(AnswerImpl.class, primaryKey);

			if (answer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnswerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(answer);
		}
		catch (NoSuchAnswerException noSuchEntityException) {
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
	protected Answer removeImpl(Answer answer) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(answer)) {
				answer = (Answer)session.get(
					AnswerImpl.class, answer.getPrimaryKeyObj());
			}

			if (answer != null) {
				session.delete(answer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (answer != null) {
			clearCache(answer);
		}

		return answer;
	}

	@Override
	public Answer updateImpl(Answer answer) {
		boolean isNew = answer.isNew();

		if (!(answer instanceof AnswerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(answer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(answer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in answer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Answer implementation " +
					answer.getClass());
		}

		AnswerModelImpl answerModelImpl = (AnswerModelImpl)answer;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (answer.getCreateDate() == null)) {
			if (serviceContext == null) {
				answer.setCreateDate(now);
			}
			else {
				answer.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!answerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				answer.setModifiedDate(now);
			}
			else {
				answer.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (answer.isNew()) {
				session.save(answer);

				answer.setNew(false);
			}
			else {
				answer = (Answer)session.merge(answer);
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
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, AnswerImpl.class, answer.getPrimaryKey(),
			answer, false);

		clearUniqueFindersCache(answerModelImpl, false);
		cacheUniqueFindersCache(answerModelImpl);

		answer.resetOriginalValues();

		return answer;
	}

	/**
	 * Returns the answer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the answer
	 * @return the answer
	 * @throws NoSuchAnswerException if a answer with the primary key could not be found
	 */
	@Override
	public Answer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnswerException {

		Answer answer = fetchByPrimaryKey(primaryKey);

		if (answer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnswerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return answer;
	}

	/**
	 * Returns the answer with the primary key or throws a <code>NoSuchAnswerException</code> if it could not be found.
	 *
	 * @param answerId the primary key of the answer
	 * @return the answer
	 * @throws NoSuchAnswerException if a answer with the primary key could not be found
	 */
	@Override
	public Answer findByPrimaryKey(long answerId) throws NoSuchAnswerException {
		return findByPrimaryKey((Serializable)answerId);
	}

	/**
	 * Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answerId the primary key of the answer
	 * @return the answer, or <code>null</code> if a answer with the primary key could not be found
	 */
	@Override
	public Answer fetchByPrimaryKey(long answerId) {
		return fetchByPrimaryKey((Serializable)answerId);
	}

	/**
	 * Returns all the answers.
	 *
	 * @return the answers
	 */
	@Override
	public List<Answer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @return the range of answers
	 */
	@Override
	public List<Answer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of answers
	 */
	@Override
	public List<Answer> findAll(
		int start, int end, OrderByComparator<Answer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of answers
	 */
	@Override
	public List<Answer> findAll(
		int start, int end, OrderByComparator<Answer> orderByComparator,
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

		List<Answer> list = null;

		if (useFinderCache) {
			list = (List<Answer>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ANSWER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANSWER;

				sql = sql.concat(AnswerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Answer>)QueryUtil.list(
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
	 * Removes all the answers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Answer answer : findAll()) {
			remove(answer);
		}
	}

	/**
	 * Returns the number of answers.
	 *
	 * @return the number of answers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANSWER);

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
		return "answerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ANSWER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnswerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the answer persistence.
	 */
	@Activate
	public void activate() {
		AnswerModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AnswerModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByQuestion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AnswerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByQuestion",
			new String[] {Long.class.getName()},
			AnswerModelImpl.QUESTIONID_COLUMN_BITMASK);

		_finderPathCountByQuestion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestion",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AnswerImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.qa.service.model.Answer"),
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

	private static final String _SQL_SELECT_ANSWER =
		"SELECT answer FROM Answer answer";

	private static final String _SQL_SELECT_ANSWER_WHERE =
		"SELECT answer FROM Answer answer WHERE ";

	private static final String _SQL_COUNT_ANSWER =
		"SELECT COUNT(answer) FROM Answer answer";

	private static final String _SQL_COUNT_ANSWER_WHERE =
		"SELECT COUNT(answer) FROM Answer answer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "answer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Answer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Answer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AnswerPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_qaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}