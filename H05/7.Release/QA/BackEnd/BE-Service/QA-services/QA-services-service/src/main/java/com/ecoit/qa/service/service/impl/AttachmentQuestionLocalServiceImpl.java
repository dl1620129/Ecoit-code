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


import com.ecoit.qa.service.model.AttachmentQuestion;
import com.ecoit.qa.service.service.base.AttachmentQuestionLocalServiceBaseImpl;
import com.ecoit.qa.service.service.persistence.AttachmentQuestionPK;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the attachment question local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.qa.service.service.AttachmentQuestionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentQuestionLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.qa.service.model.AttachmentQuestion",
	service = AopService.class
)
public class AttachmentQuestionLocalServiceImpl
	extends AttachmentQuestionLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.qa.service.service.AttachmentQuestionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.qa.service.service.AttachmentQuestionLocalServiceUtil</code>.
	 */
	public void createAttachmentQuestion(long questionId, long attachmentId) {
		AttachmentQuestionPK primaryKey = new AttachmentQuestionPK();
		primaryKey.setAttachmentId(attachmentId);
		primaryKey.setQuestionId(questionId);
		AttachmentQuestion attachmentQuestion  = attachmentQuestionPersistence.create(primaryKey);
		try {
			attachmentQuestionPersistence.update(attachmentQuestion);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<AttachmentQuestion> getByQuestionId(long questionId) {
		return attachmentQuestionPersistence.findByQuestionId(questionId);
	}
	
	public void deleteByQuestionId(long questionId) {
		attachmentQuestionPersistence.removeByQuestionId(questionId);
	}
}