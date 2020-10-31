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

package com.ecoit.elegaldocument.service.impl;

import com.ecoit.elegaldocument.model.DocumentAttachments;
import com.ecoit.elegaldocument.model.LegalDocument;
import com.ecoit.elegaldocument.service.LegalDSRelLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDTypeRelLocalServiceUtil;
import com.ecoit.elegaldocument.service.base.LegalDraftDocumentLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the legal draft document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.LegalDraftDocumentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liverpool
 * @see LegalDraftDocumentLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.elegaldocument.model.LegalDraftDocument",
	service = AopService.class
)
public class LegalDraftDocumentLocalServiceImpl
	extends LegalDraftDocumentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.elegaldocument.service.LegalDraftDocumentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.elegaldocument.service.LegalDraftDocumentLocalServiceUtil</code>.
	 */
}