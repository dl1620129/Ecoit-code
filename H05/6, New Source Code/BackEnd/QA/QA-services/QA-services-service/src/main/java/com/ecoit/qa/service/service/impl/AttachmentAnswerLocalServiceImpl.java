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

import com.ecoit.qa.service.model.AttachmentAnswer;
import com.ecoit.qa.service.service.base.AttachmentAnswerLocalServiceBaseImpl;
import com.ecoit.qa.service.service.persistence.AttachmentAnswerPK;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the attachment answer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.qa.service.service.AttachmentAnswerLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentAnswerLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.qa.service.model.AttachmentAnswer",
	service = AopService.class
)
public class AttachmentAnswerLocalServiceImpl
	extends AttachmentAnswerLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.qa.service.service.AttachmentAnswerLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.qa.service.service.AttachmentAnswerLocalServiceUtil</code>.
	 */
	
	public void createAttachmentAnswer(long answerId, long attachmentId) {
		AttachmentAnswerPK primaryKey = new AttachmentAnswerPK();
		primaryKey.setAttachmentId(attachmentId);
		primaryKey.setAnswerId(answerId);
		AttachmentAnswer attachmentAnswer  = attachmentAnswerPersistence.create(primaryKey);
		try {
			attachmentAnswerPersistence.update(attachmentAnswer);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<AttachmentAnswer> getByAnswerId(long answerId) {
		return attachmentAnswerPersistence.findByAnswerId(answerId);
	}
	
	public void deleteByAnswerId(long answerId) {
		attachmentAnswerPersistence.removeByAnswerId(answerId);
	}
}