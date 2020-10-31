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

import com.ecoit.qa.service.model.Answer;
import com.ecoit.qa.service.service.AttachmentAnswerLocalServiceUtil;
import com.ecoit.qa.service.service.AttachmentQuestionLocalServiceUtil;
import com.ecoit.qa.service.service.base.AnswerLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the answer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.qa.service.service.AnswerLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnswerLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.qa.service.model.Answer",
	service = AopService.class
)
public class AnswerLocalServiceImpl extends AnswerLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.qa.service.service.AnswerLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.qa.service.service.AnswerLocalServiceUtil</code>.
	 */
	
	public void createUpdateAnswer(long userId, long answerId, long questionId, List<Long> attachmentIdsList, String content) throws Exception {
		Answer answer = null;
		Date now = new Date();
		if (answerId < 1) {
			answerId = counterLocalService.increment();
			answer = answerPersistence.create(answerId);
			answer.setCreatedByUser(userId);
			answer.setCreateDate(now);
		} else {
			answer = answerPersistence.findByPrimaryKey(answerId);	
		}

		answer.setContent(content);
		answer.setQuestionId(questionId);
		answer.setModifiedDate(now);
		answer.setModifiedByUser(userId);
		for (Long attachmentId : attachmentIdsList) {
			if (attachmentId != null) {
				AttachmentAnswerLocalServiceUtil.createAttachmentAnswer(answerId, attachmentId);
			}
		}
		answerPersistence.update(answer);
	}
	
	public Answer getByQuestionId(long questionId) {
		Answer answer = null;
		try {
			answer = answerPersistence.fetchByQuestion(questionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}
}