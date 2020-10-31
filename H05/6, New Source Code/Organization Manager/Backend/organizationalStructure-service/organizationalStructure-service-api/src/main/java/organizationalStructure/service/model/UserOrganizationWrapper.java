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

package organizationalStructure.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserOrganization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOrganization
 * @generated
 */
public class UserOrganizationWrapper
	extends BaseModelWrapper<UserOrganization>
	implements ModelWrapper<UserOrganization>, UserOrganization {

	public UserOrganizationWrapper(UserOrganization userOrganization) {
		super(userOrganization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("organizationId", getOrganizationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}
	}

	/**
	 * Returns the organization ID of this user organization.
	 *
	 * @return the organization ID of this user organization
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this user organization.
	 *
	 * @return the primary key of this user organization
	 */
	@Override
	public
		organizationalStructure.service.service.persistence.UserOrganizationPK
			getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this user organization.
	 *
	 * @return the user ID of this user organization
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this user organization.
	 *
	 * @return the user uuid of this user organization
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the organization ID of this user organization.
	 *
	 * @param organizationId the organization ID of this user organization
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this user organization.
	 *
	 * @param primaryKey the primary key of this user organization
	 */
	@Override
	public void setPrimaryKey(
		organizationalStructure.service.service.persistence.UserOrganizationPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this user organization.
	 *
	 * @param userId the user ID of this user organization
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this user organization.
	 *
	 * @param userUuid the user uuid of this user organization
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected UserOrganizationWrapper wrap(UserOrganization userOrganization) {
		return new UserOrganizationWrapper(userOrganization);
	}

}