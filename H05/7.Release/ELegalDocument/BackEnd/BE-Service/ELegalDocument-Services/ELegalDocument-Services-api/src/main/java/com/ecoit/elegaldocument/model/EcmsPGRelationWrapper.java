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
 * This class is a wrapper for {@link EcmsPGRelation}.
 * </p>
 *
 * @author Liverpool
 * @see EcmsPGRelation
 * @generated
 */
public class EcmsPGRelationWrapper
	extends BaseModelWrapper<EcmsPGRelation>
	implements EcmsPGRelation, ModelWrapper<EcmsPGRelation> {

	public EcmsPGRelationWrapper(EcmsPGRelation ecmsPGRelation) {
		super(ecmsPGRelation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("permission", getPermission());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Integer permission = (Integer)attributes.get("permission");

		if (permission != null) {
			setPermission(permission);
		}
	}

	/**
	 * Returns the group user ID of this ecms pg relation.
	 *
	 * @return the group user ID of this ecms pg relation
	 */
	@Override
	public long getGroupUserId() {
		return model.getGroupUserId();
	}

	/**
	 * Returns the group user uuid of this ecms pg relation.
	 *
	 * @return the group user uuid of this ecms pg relation
	 */
	@Override
	public String getGroupUserUuid() {
		return model.getGroupUserUuid();
	}

	/**
	 * Returns the permission of this ecms pg relation.
	 *
	 * @return the permission of this ecms pg relation
	 */
	@Override
	public int getPermission() {
		return model.getPermission();
	}

	/**
	 * Returns the primary key of this ecms pg relation.
	 *
	 * @return the primary key of this ecms pg relation
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the group user ID of this ecms pg relation.
	 *
	 * @param groupUserId the group user ID of this ecms pg relation
	 */
	@Override
	public void setGroupUserId(long groupUserId) {
		model.setGroupUserId(groupUserId);
	}

	/**
	 * Sets the group user uuid of this ecms pg relation.
	 *
	 * @param groupUserUuid the group user uuid of this ecms pg relation
	 */
	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		model.setGroupUserUuid(groupUserUuid);
	}

	/**
	 * Sets the permission of this ecms pg relation.
	 *
	 * @param permission the permission of this ecms pg relation
	 */
	@Override
	public void setPermission(int permission) {
		model.setPermission(permission);
	}

	/**
	 * Sets the primary key of this ecms pg relation.
	 *
	 * @param primaryKey the primary key of this ecms pg relation
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected EcmsPGRelationWrapper wrap(EcmsPGRelation ecmsPGRelation) {
		return new EcmsPGRelationWrapper(ecmsPGRelation);
	}

}