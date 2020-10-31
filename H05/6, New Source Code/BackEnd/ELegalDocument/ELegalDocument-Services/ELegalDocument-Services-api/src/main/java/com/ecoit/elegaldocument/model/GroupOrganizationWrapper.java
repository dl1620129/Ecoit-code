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

package com.ecoit.elegaldocument.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GroupOrganization}.
 * </p>
 *
 * @author Liverpool
 * @see GroupOrganization
 * @generated
 */
public class GroupOrganizationWrapper
	extends BaseModelWrapper<GroupOrganization>
	implements GroupOrganization, ModelWrapper<GroupOrganization> {

	public GroupOrganizationWrapper(GroupOrganization groupOrganization) {
		super(groupOrganization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("organizationid", getOrganizationid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Long organizationid = (Long)attributes.get("organizationid");

		if (organizationid != null) {
			setOrganizationid(organizationid);
		}
	}

	/**
	 * Returns the group user ID of this group organization.
	 *
	 * @return the group user ID of this group organization
	 */
	@Override
	public long getGroupUserId() {
		return model.getGroupUserId();
	}

	/**
	 * Returns the group user uuid of this group organization.
	 *
	 * @return the group user uuid of this group organization
	 */
	@Override
	public String getGroupUserUuid() {
		return model.getGroupUserUuid();
	}

	/**
	 * Returns the organizationid of this group organization.
	 *
	 * @return the organizationid of this group organization
	 */
	@Override
	public long getOrganizationid() {
		return model.getOrganizationid();
	}

	/**
	 * Returns the primary key of this group organization.
	 *
	 * @return the primary key of this group organization
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the group user ID of this group organization.
	 *
	 * @param groupUserId the group user ID of this group organization
	 */
	@Override
	public void setGroupUserId(long groupUserId) {
		model.setGroupUserId(groupUserId);
	}

	/**
	 * Sets the group user uuid of this group organization.
	 *
	 * @param groupUserUuid the group user uuid of this group organization
	 */
	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		model.setGroupUserUuid(groupUserUuid);
	}

	/**
	 * Sets the organizationid of this group organization.
	 *
	 * @param organizationid the organizationid of this group organization
	 */
	@Override
	public void setOrganizationid(long organizationid) {
		model.setOrganizationid(organizationid);
	}

	/**
	 * Sets the primary key of this group organization.
	 *
	 * @param primaryKey the primary key of this group organization
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected GroupOrganizationWrapper wrap(
		GroupOrganization groupOrganization) {

		return new GroupOrganizationWrapper(groupOrganization);
	}

}