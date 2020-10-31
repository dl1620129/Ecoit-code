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
import com.ecoit.elegaldocument.model.EcmsGroup;
import com.ecoit.elegaldocument.service.base.EcmsGroupServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the ecms group remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.elegaldocument.service.EcmsGroupService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Liverpool
 * @see EcmsGroupServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=ecoit_doc",
		"json.web.service.context.path=EcmsGroup"
	},
	service = AopService.class
)
public class EcmsGroupServiceImpl extends EcmsGroupServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.ecoit.elegaldocument.service.EcmsGroupServiceUtil</code> to access the ecms group remote service.
	 */
	
	public EcmsGroup addGroup(String groupName, String groupDesciption, long groupId)
			throws Exception {
		long groupUserId = CounterLocalServiceUtil.increment(EcmsGroup.class
				.toString());
		EcmsGroup group = this.ecmsGroupPersistence.create(groupUserId);
		group.setGroupName(groupName);
		group.setDescription(groupDesciption);
		group.setGroupId(groupId);
		return this.ecmsGroupPersistence.update(group);
	}

	public EcmsGroup updateGroup(long groupId, String groupName,
			String groupDesciption) throws Exception {
		EcmsGroup group = this.ecmsGroupPersistence.findByPrimaryKey(groupId);
		group.setGroupName(groupName);
		group.setDescription(groupDesciption);
		return this.ecmsGroupPersistence.update(group);
	}

	public void updateGroup(EcmsGroup group) throws Exception {
		this.ecmsGroupPersistence.update(group);
	}

	public void deleteGroup(long groupId) throws Exception {
		EcmsGroup group = this.ecmsGroupPersistence.findByPrimaryKey(groupId);
		this.ecmsGroupPersistence.remove(group);
		this.ecmsGURelationPersistence.removeBygroupUserId(groupId);
	}

	public List<EcmsGroup> findAll() throws Exception {
		return this.ecmsGroupPersistence.findAll();
	}

	public EcmsGroup findByPrimaryKey(long groupId) throws Exception {
		return this.ecmsGroupPersistence.findByPrimaryKey(groupId);
	}

	public long findUserInGroup(long userId) {
		try {
			for (Iterator<EcmsGroup> iterator = this.ecmsGroupPersistence
					.findAll().iterator(); iterator.hasNext();) {
				EcmsGroup group = iterator.next();
				for (Iterator<EcmsGURelation> iterator2 = this.ecmsGURelationPersistence
						.findBygroupUserId(group.getGroupUserId()).iterator(); iterator2
						.hasNext();) {
					EcmsGURelation relation = iterator2.next();
					if (relation.getUserId() == userId) return relation.getGroupUserId();
				}
			}
		} catch (Exception ex) {
		}

		return -1;
	}
}