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
 * This class is a wrapper for {@link EcmsGURelation}.
 * </p>
 *
 * @author Liverpool
 * @see EcmsGURelation
 * @generated
 */
public class EcmsGURelationWrapper
	extends BaseModelWrapper<EcmsGURelation>
	implements EcmsGURelation, ModelWrapper<EcmsGURelation> {

	public EcmsGURelationWrapper(EcmsGURelation ecmsGURelation) {
		super(ecmsGURelation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("groupUserId", getGroupUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}
	}

	/**
	 * Returns the group user ID of this ecms gu relation.
	 *
	 * @return the group user ID of this ecms gu relation
	 */
	@Override
	public long getGroupUserId() {
		return model.getGroupUserId();
	}

	/**
	 * Returns the group user uuid of this ecms gu relation.
	 *
	 * @return the group user uuid of this ecms gu relation
	 */
	@Override
	public String getGroupUserUuid() {
		return model.getGroupUserUuid();
	}

	/**
	 * Returns the primary key of this ecms gu relation.
	 *
	 * @return the primary key of this ecms gu relation
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.EcmsGURelationPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this ecms gu relation.
	 *
	 * @return the user ID of this ecms gu relation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this ecms gu relation.
	 *
	 * @return the user uuid of this ecms gu relation
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
	 * Sets the group user ID of this ecms gu relation.
	 *
	 * @param groupUserId the group user ID of this ecms gu relation
	 */
	@Override
	public void setGroupUserId(long groupUserId) {
		model.setGroupUserId(groupUserId);
	}

	/**
	 * Sets the group user uuid of this ecms gu relation.
	 *
	 * @param groupUserUuid the group user uuid of this ecms gu relation
	 */
	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		model.setGroupUserUuid(groupUserUuid);
	}

	/**
	 * Sets the primary key of this ecms gu relation.
	 *
	 * @param primaryKey the primary key of this ecms gu relation
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.EcmsGURelationPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this ecms gu relation.
	 *
	 * @param userId the user ID of this ecms gu relation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this ecms gu relation.
	 *
	 * @param userUuid the user uuid of this ecms gu relation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EcmsGURelationWrapper wrap(EcmsGURelation ecmsGURelation) {
		return new EcmsGURelationWrapper(ecmsGURelation);
	}

}