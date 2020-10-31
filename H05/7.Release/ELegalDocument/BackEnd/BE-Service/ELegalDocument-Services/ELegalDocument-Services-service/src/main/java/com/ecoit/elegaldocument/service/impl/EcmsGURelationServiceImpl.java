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

import com.ecoit.elegaldocument.model.EcmsGURelation;
import com.ecoit.elegaldocument.service.base.EcmsGURelationServiceBaseImpl;
import com.ecoit.elegaldocument.service.persistence.EcmsGURelationPK;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the ecms gu relation remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ecoit.elegaldocument.service.EcmsGURelationService</code>
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Liverpool
 * @see EcmsGURelationServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=ecoit_doc",
		"json.web.service.context.path=EcmsGURelation" }, service = AopService.class)
public class EcmsGURelationServiceImpl extends EcmsGURelationServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>com.ecoit.elegaldocument.service.EcmsGURelationServiceUtil</code> to
	 * access the ecms gu relation remote service.
	 */
	public EcmsGURelation addGURelation(long groupUserId, long userId) throws Exception {
		EcmsGURelationPK pk = new EcmsGURelationPK(userId, groupUserId);
		EcmsGURelation relation = this.ecmsGURelationPersistence.create(pk);
		return this.ecmsGURelationPersistence.update(relation);
	}

	public List<EcmsGURelation> searchByGroupUser(long groupUserId) throws Exception {
		return this.ecmsGURelationPersistence.findBygroupUserId(groupUserId);
	}

	public List<EcmsGURelation> searchByUserId(long userId) throws Exception {
		return this.ecmsGURelationPersistence.findByuserId(userId);
	}

	public void removeByGroup(long groupId) throws Exception {
		this.ecmsGURelationPersistence.removeBygroupUserId(groupId);
	}

	public boolean isContain(long groupId, long userId) {
		try {
			EcmsGURelation relation = this.ecmsGURelationPersistence.findByG_U(groupId, userId);
			if (relation == null)
				return false;
			else
				return true;
		} catch (Exception ex) {
			return false;
		}
	}

}