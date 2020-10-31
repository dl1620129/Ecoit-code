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

package com.ecoit.qa.service.service.impl;

import com.ecoit.qa.service.model.Question;
import com.ecoit.qa.service.model.impl.QuestionImpl;
import com.ecoit.qa.service.service.AttachmentQuestionLocalServiceUtil;
import com.ecoit.qa.service.service.base.QuestionLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the question local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.qa.service.service.QuestionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuestionLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.qa.service.model.Question",
	service = AopService.class
)
public class QuestionLocalServiceImpl extends QuestionLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.qa.service.service.QuestionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.qa.service.service.QuestionLocalServiceUtil</code>.
	 */
	
	public Question createUpdateQuestion(long groupId, String locale, long userId, long questionId, String title, String email, String content,
			String phoneNumber, String address, List<Long> attachmentIdsList, long categoryId, String name, int status) throws Exception {
		Question question = null;
		Date now = new Date();
		if (questionId < 1) {
			questionId = counterLocalService.increment();
			question = questionPersistence.create(questionId);
			question.setCreateDate(now);
			question.setView(0);
		} else {
			question = questionPersistence.findByPrimaryKey(questionId);	
		}

		question.setLanguage(locale);
		question.setGroupId(groupId);
		question.setAddress(address);
		question.setTitle(title);
		question.setContent(content);
		question.setEmail(email);
		question.setPhoneNumber(phoneNumber);
		question.setModifiedDate(now);
		question.setCategoryId(categoryId);
		question.setModifiedByUser(userId);
		question.setUserName(name);
		if (status >= 0) {
			question.setStatus(status);
		}
		questionPersistence.update(question);
		
		for (Long attachmentId : attachmentIdsList) {
			if (attachmentId != null) {
				AttachmentQuestionLocalServiceUtil.createAttachmentQuestion(questionId, attachmentId);
			}
		}
		return question;
	}
	
	public List<Question> getAllQuestions(long groupId, String locale, long categoryId, String searchKey, int start, int limit, int status) throws Exception {
		Session session = null;
		List<Question> questionsList = new ArrayList<>();
		try {
			session = questionPersistence.openSession();
			String sql = "SELECT * FROM ecoit_qa_question WHERE language = :language AND groupid = :groupId AND lower(title) LIKE lower(:searchKey) AND status = :status ";
			
			if (categoryId > 0) {
				sql += "AND categoryid = :categoryId ";
			}
			
			sql += "ORDER BY createdate DESC ";
			
			if (start > 0) {
				sql += "OFFSET :start ";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_qa_question", QuestionImpl.class);
			query.setString("language", locale);
			query.setLong("groupId", groupId);
			query.setString("searchKey", "%" + searchKey + "%");
			query.setInteger("status", status);
			if (limit > 0) {
				query.setMaxResults(limit);
			}
			if (categoryId > 0) {
				query.setLong("categoryId", categoryId);
			}
			
			if (start > 0) {
				query.setInteger("start", start);
			}
			
			QueryPos.getInstance(query);
			questionsList = query.list();
			return questionsList;
		} finally {
			questionPersistence.closeSession(session);
		}
	}
	
	public void updateStatus(long questionId, int statusDoc, long userId) throws Exception {
		Question question = questionPersistence.fetchByPrimaryKey(questionId);
		Date now = new Date();
		question.setModifiedDate(now);
		question.setModifiedByUser(userId);
		question.setStatus(statusDoc);
		questionPersistence.update(question);
	}
	
	
	public void updateView(long questionId) {
		Question question = questionPersistence.fetchByPrimaryKey(questionId);
		question.setView(question.getView() + 1);
		questionPersistence.update(question);
	}
	
	public int countQuestions(long groupId, String locale, long categoryId, String searchKey, int status) throws Exception {
		Session session = null;
		int count = 0;
		try {
			session = questionPersistence.openSession();
			String sql = "SELECT count(*) FROM ecoit_qa_question WHERE language = :language AND groupid = :groupId AND "
					+ "lower(title) LIKE lower(:searchKey) AND status = :status ";
			
			if (categoryId > 0) {
				sql += "AND categoryid = :categoryId ";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.setString("language", locale);
			query.setLong("groupId", groupId);
			query.setString("searchKey", "%" + searchKey + "%");
			query.setInteger("status", status);
			
			if (categoryId > 0) {
				query.setLong("categoryId", categoryId);
			}
			
			Iterator<BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} finally {
			questionPersistence.closeSession(session);
		}
		return count;
	}
	
	public List<Question> getMostPopular(long groupId, String locale, int status, int limit) throws Exception {
		Session session = null;
		List<Question> questionsList = new ArrayList<>();
		try {
			session = questionPersistence.openSession();
			String sql = "SELECT * FROM ecoit_qa_question WHERE language = :language AND groupid = :groupId AND status = :status ORDER BY view DESC";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_qa_question", QuestionImpl.class);
			query.setString("language", locale);
			query.setLong("groupId", groupId);
			query.setInteger("status", status);
			if (limit > 0) {
				query.setMaxResults(limit);
			} else {
				query.setMaxResults(5);
			}
			
			QueryPos.getInstance(query);
			questionsList = query.list();
			return questionsList;
		} finally {
			questionPersistence.closeSession(session);
		}
	}
	
	public Question getQuestionByStatusAndId(int status, long questionId) {
		Session session = null;
        Question question = null;
		try {
			session = questionPersistence.openSession();
			String sql = "SELECT * FROM ecoit_qa_question WHERE questionid = :questionId AND status = :status ORDER BY createdate DESC";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_qa_question", QuestionImpl.class);
			query.setLong("questionId", questionId);
			query.setInteger("status", status);
			
			QueryPos.getInstance(query);
			List<Question> questionsList = new ArrayList<>();
			questionsList = query.list();
			
			if (questionsList != null && questionsList.size() > 0) {
				question = questionsList.get(0);
			}
			return question;
		} finally {
			questionPersistence.closeSession(session);
		}
	}
	
	public List<Question> getByCategoryId(long categoryId) {
		return questionPersistence.findByCategory(categoryId);
	}
	
	public int countByCategoryId(long categoryId) {
		return questionPersistence.countByCategory(categoryId);
	}
	
	public int countByStatus(int status, long groupId, String locale) {
		return questionPersistence.countByStatus(status, groupId, locale);
	}
}