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

import com.ecoit.elegaldocument.model.EcmsPGRelation;
import com.ecoit.elegaldocument.service.base.EcmsPGRelationServiceBaseImpl;
import com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the ecms pg relation remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.EcmsPGRelationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Liverpool
 * @see EcmsPGRelationServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=ecoit_doc",
		"json.web.service.context.path=EcmsPGRelation"
	},
	service = AopService.class
)
public class EcmsPGRelationServiceImpl extends EcmsPGRelationServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.ecoit.elegaldocument.service.EcmsPGRelationServiceUtil</code> to access the ecms pg relation remote service.
	 */
	
	public EcmsPGRelation addPermission(long groupId, int permission) throws Exception {
		EcmsPGRelationPK pk = new EcmsPGRelationPK(groupId, permission);
		EcmsPGRelation relation = this.ecmsPGRelationPersistence.create(pk);
		return this.ecmsPGRelationPersistence.update(relation);
	}

	public void removeByGroupId(long groupId) throws Exception {
		this.ecmsPGRelationPersistence.removeBygroupUserId(groupId);
	}

	public void removeByPermission(int permissionId) throws Exception {
		this.ecmsPGRelationPersistence.removeBygroupUserId(permissionId);
	}

	public List<EcmsPGRelation> findByGroupUserId(long groupUserId)
			throws Exception {
		return this.ecmsPGRelationPersistence.findBygroupUserId(groupUserId);
	}

	public List<EcmsPGRelation> findByPermission(int permission)
			throws Exception {
		return this.ecmsPGRelationPersistence.findBypermission(permission);
	}

	public boolean checkPermission(long groupId, int permission) {
		try {
			EcmsPGRelation relation = this.ecmsPGRelationPersistence.findByG_P(groupId, permission);
			if (relation == null) return false;
			else return true;
		} catch (Exception ex) {
			return false;
		}
	}
}